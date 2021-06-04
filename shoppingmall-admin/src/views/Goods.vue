<template>
  <div>
    <el-button type="primary" @click="dialogVisible=true">添加</el-button>
    <!--数据表格-->
    <el-table
        ref="spuTable"
        :data="spus"
        style="width: 100%">
      <el-table-column label="编号">
        <template slot-scope="scope">
          <span>{{ scope.row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column label="名称">
        <template slot-scope="scope">
          <span>{{ scope.row.title }}</span>
        </template>
      </el-table-column>
      <el-table-column label="分类">
        <template slot-scope="scope">
          <span>{{ scope.row.categoryName }}</span>
        </template>
      </el-table-column>
      <el-table-column label="品牌">
        <template slot-scope="scope">
          <span>{{ scope.row.brandName }}</span>
        </template>
      </el-table-column>
      <el-table-column fixed="right" label="操作">
        <template slot-scope="scope">
          <el-button
              size="mini">编辑
          </el-button>
          <el-button
              size="mini"
              type="danger">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        :current-page="current"
        :page-size="size"
        :total="total"
        layout="total, sizes, prev, pager, next, jumper"
        @current-change="currentChange">
    </el-pagination>
    <!--带步骤的对话框-->
    <el-dialog :visible.sync="dialogVisible" title="商品信息" @close="closeDialog">
      <el-steps :active="step" finish-status="success">
        <el-step title="基本信息"></el-step>
        <el-step title="商品详情"></el-step>
        <el-step title="通用规格"></el-step>
        <el-step title="特殊规格"></el-step>
        <el-step title="商品保存"></el-step>
      </el-steps>
      <!--使用自定义组件-->
      <GoodsBasic v-if="step==0" :goods="goods"></GoodsBasic>
      <GoodsDetail v-if="step==1" :goods="goods"></GoodsDetail>
      <GoodsSpec v-if="step==2" :goods="goods"></GoodsSpec>
      <GoodsSpecialSpec v-if="step==3" :goods="goods"></GoodsSpecialSpec>
      <GoodsSave v-if="step==4" :goods="goods"></GoodsSave>
      <el-button v-if="step > 0" type="primary" @click="step--">上一步</el-button>
      <el-button v-if="step < 4" type="primary" @click="step++">下一步</el-button>
      <el-button v-if="step == 4" type="primary" @click="saveGoods">保存</el-button>
    </el-dialog>
  </div>
</template>

<script>
//导入自定义组件
import GoodsSave from "../components/GoodsSave";
import GoodsSpec from "../components/GoodsSpec";
import GoodsBasic from "../components/GoodsBasic";
import GoodsDetail from "../components/GoodsDetail";
import GoodsSpecialSpec from "../components/GoodsSpecialSpec";

export default {
  name: "Goods",
  //声明自定义组件
  components: {
    GoodsSave, GoodsSpec, GoodsBasic, GoodsDetail, GoodsSpecialSpec
  },
  data() {
    return {
      spus: [], //商品列表
      current: 1,
      size: 10,
      total: 0,
      dialogVisible: false,
      step: 0, //当前步骤
      initGoods: {
        spu: {id: 0, title: "", subTitle: "", cid1: 0, cid2: 0, cid3: 0, brandId: 0, saleable: 0},
        spuDetail: {spuId: 0, description: "", genericSpec: {}, specialSpec: {}, packingList: "", afterService: ""},
        skus: []
      },
      goods: {}
    }
  },
  methods: {
    currentChange(current) {
      this.current = current;
      this.$http.get("http://api.eshop.com/spus/page?size=20&current=" + this.current)
          .then(value => {
            this.spus = value.data.records;
            this.size = value.data.size;
            this.total = value.data.total;
          });
    },
    closeDialog() {
      this.step = 0;
      this.goods = JSON.parse(JSON.stringify(this.initGoods));
    },
    saveGoods() {
      //删除SpecialSpec的第一个值(规格名称）
      for (var k in this.goods.spuDetail.specialSpec) {
        var spec = this.goods.spuDetail.specialSpec[k];
        spec.splice(0, 1);
      }
      //处理SpuDetail中genericSpec和SpecialSpec
      this.goods.spuDetail.genericSpec = JSON.stringify(this.goods.spuDetail.genericSpec);
      this.goods.spuDetail.specialSpec = JSON.stringify(this.goods.spuDetail.specialSpec);
      //筛选出启用的sku
      let skuArr = this.goods.skus.filter(({enable}) => {
        return enable; //筛选出enable为true的商品
      })//对原来数组进行转换 ...xx,除前面的属性外的其它的所有属性
          .map(({price, stock, images, enable, indexes, ...rest}) => {
            //处理名字 title + 特殊规格的值
            let title = this.goods.spu.title + " " + Object.values(rest).join(" ");
            //处理OwnSpec
            let ownSpec = JSON.stringify(rest);
            //返回处理之后的结果
            return {
              title: title,
              images: images,
              price: price,
              stock: stock,
              ownSpec: ownSpec,
              indexes: indexes,
              enable: 1
            }
          });
      console.log(skuArr);
      this.goods.skus = skuArr;
      this.$http.post("spu", this.goods)
          .then(value => {
            this.$message("添加成功");
          });
      this.dialogVisible = false;
    }
  },
  mounted() {
    this.currentChange(1);
    //把初始数据复制给goods 深复制
    this.goods = JSON.parse(JSON.stringify(this.initGoods));
  }
}
</script>

<style scoped>

</style>