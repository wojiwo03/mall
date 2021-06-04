<template>
  <div>
    <el-form :model="goods.spu" label-width="80px">
      <el-form-item label="商品名称">
        <el-input v-model="goods.spu.title"></el-input>
      </el-form-item>
      <el-form-item label="子标题">
        <el-input v-model="goods.spu.subTitle"></el-input>
      </el-form-item>
      <el-form-item label="商品类型">
        <el-cascader
            :options="categories"
            :props="props"
            @change="handleChange">
        </el-cascader>
      </el-form-item>
      <el-form-item label="品牌">
        <el-select v-model="goods.spu.brandId" placeholder="请选择">
          <el-option
              v-for="brand in brands"
              :key="brand.id"
              :label="brand.name"
              :value="brand.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="是否上架">
        <el-switch
            v-model="goods.spu.saleable"
            active-text="上架"
            active-value="1"
            inactive-text="下架"
            inactive-value="0">
        </el-switch>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
var _this = this;
export default {
  name: "GoodsBasic",
  props: { //用于接受上级的传值
    goods: { //声明goods对象
      type: Object
    }
  },
  data() {
    return {
      categories: [], //分类
      brands: [],//品牌
      brandId: 0,//当前品牌id
      props: {
        label: 'name',
        value: 'id',
        lazy: true,//懒加载
        lazyLoad(node, resolve) {
          console.log(node);
          if (node.level == 3) {
            resolve([]);
            return;
          }
          //加载下一级分类
          _this.$http.get("categories/parent/" + node.value)
              .then(value => {
                resolve(value.data);
              });
        }
      }
    }
  },
  methods: {
    handleChange(value) {
      console.log(value);
      if (value.length == 3) {
        this.goods.spu.cid3 = value[2];
        this.goods.spu.cid2 = value[1];
        this.goods.spu.cid1 = value[0];
        //加载品牌
        this.$http.get("brands/category/" + value[2])
            .then(value1 => {
              this.brands = value1.data;
              console.log(this.goods);
            });
      }
    }
  },
  mounted() {
    _this = this;
    //加载第一级分类
    _this.$http.get("categories/parent/0")
        .then(value => {
          this.categories = value.data;
        });
  }
}
</script>

<style scoped>

</style>