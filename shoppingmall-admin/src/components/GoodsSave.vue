<template>
  <div>
    <el-table
        :data="skus"
        style="width: 100%">
      <el-table-column v-for="header in headers" :key="header.key" :label="header.header">
        <template slot-scope="scope">
          <el-input v-if="header.header == '价格'" v-model="scope.row.price"></el-input>
          <el-input v-else-if="header.header == '库存'" v-model="scope.row.stock"></el-input>
          <ImageUpload v-else-if="header.header == '图片'" :row="scope.row"></ImageUpload>
          <el-checkbox v-else-if="header.header == '启用'" v-model="scope.row.enable"></el-checkbox>
          <span v-else>{{ scope.row[header.key] }}</span>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import ImageUpload from "./ImageUpload";

export default {
  name: "GoodsSave",
  components: {
    ImageUpload
  },
  data() {
    return {
      headers: [], //表头 {key:"x",header:"xxx"}
      skus: [],//规格列表
    }
  },
  props: { //用于接受上级的传值
    goods: { //声明goods对象
      type: Object
    }
  },
  mounted() {
    let arr = [];
    //遍历特殊规格的所有key
    for (var k in this.goods.spuDetail.specialSpec) {
      //取得数组
      var spec = this.goods.spuDetail.specialSpec[k];
      if (spec.length <= 1) {
        return;
      }
      //添加表头
      this.headers.push({key: k, header: spec[0]});
      let values = [];
      //添加{key:xx,values:[]}格式的规格数据
      for (let i = 1; i < spec.length; i++) {
        values.push(spec[i]);
      }
      //添加 key: 规格id，values:【】
      arr.push({key: k, values: values});
    }
    this.headers.push({key: "price", header: "价格"});
    this.headers.push({key: "stock", header: "库存"});
    this.headers.push({key: "images", header: "图片"});
    this.headers.push({key: "enable", header: "启用"});
    console.log(JSON.stringify(arr));
    //处理笛卡尔积
    this.skus = arr.reduce(((previousValue, currentValue, index) => {
          let result = [];
          //合并上次的值和当前的值
          previousValue.forEach(p => {
            for (let i = 0; i < currentValue.values.length; i++) {
              let val = currentValue.values[i];
              let obj = {};
              Object.assign(obj, p); //合并前面的值
              obj[currentValue.key] = val;//添加新属性值
              obj.indexes = (obj.indexes || "") + i + "_" //连接索引
              //合并到最后一次时添加新的属性
              if (index == arr.length - 1) {
                obj.indexes = obj.indexes.substring(0, obj.indexes.length - 1);
                Object.assign(obj, {price: 0, stock: 0, images: "", enable: 0});
              }
              result.push(obj);
            }
          })
          return result;
        })
        , [{}]);
    //添加goods中
    this.goods.skus = this.skus;
    console.log("skus==>" + JSON.stringify(this.goods.skus));
  }
}
</script>

<style scoped>

</style>