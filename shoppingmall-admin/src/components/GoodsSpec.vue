<template>
  <div>
    <el-card v-for="group in specGroups" class="box-card">
      <div slot="header" class="clearfix">
        <span>{{ group.name }}</span>
      </div>
      <div>
        <!-- 如果是通用的并且没有segments就显示输入框-->
        <el-input v-for="spec in group.specParams" v-if="spec.generic && spec.segments.length == 0"
                  v-model="goods.spuDetail.genericSpec[spec.id]"
                  :placeholder="spec.name"></el-input>
        <!-- 如果是通用的并且有segments就显示下拉框-->
        <el-select v-for="spec in group.specParams" v-if="spec.generic && spec.segments.length > 0"
                   v-model="goods.spuDetail.genericSpec[spec.id]"
                   :placeholder="spec.name">
          <el-option v-for="seg in spec.segments.split(',')" :label="seg" :value="seg">
          </el-option>
        </el-select>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "GoodsSpec",
  data() {
    return {
      specGroups: [] //规格分组
    }
  },
  props: { //用于接受上级的传值
    goods: { //声明goods对象
      type: Object
    }
  },
  mounted() {
    //查询当前分类下的规格分组
    this.$http.get("/specGroups/category/" + this.goods.spu.cid3)
        .then(value => {
          this.specGroups = value.data;
          //遍历所有分组的所有规格
          for (var i = 0; i < this.specGroups.length; i++) {
            for (var j = 0; j < this.specGroups[i].specParams.length; j++) {
              var param = this.specGroups[i].specParams[j];
              //判断是否是通用的规格
              if (param.generic) {
                //将规格id作为属性名，添加道通用规格中 this.$set(JSON对象,属性名,值)  对象[属性]
                this.$set(this.goods.spuDetail.genericSpec, param.id, "");
              } else {
                //添加数据到特殊规格中，把规格的名称作为数组的第一位，方便名称的显示，提交时去掉
                this.$set(this.goods.spuDetail.specialSpec, param.id, [param.name]);
              }
            }
          }
        });
  }
}
</script>

<style scoped>

</style>