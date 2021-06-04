<template>
  <div>
    <el-card v-for="spec in goods.spuDetail.specialSpec" class="box-card">
      <div slot="header" class="clearfix">
        <span>{{ spec[0] }}</span>
      </div>
      <div>
        <el-tag
            v-for="(tag,i) in spec"
            v-if="i > 0"
            :key="tag"
            :disable-transitions="false"
            closable
            @close="spec.splice(i,1)">
          {{ tag }}
        </el-tag>
        <el-button class="button-new-tag" size="small" @click="addSpec(spec)">添加</el-button>
      </div>
    </el-card>
  </div>
</template>
<script>
export default {
  name: "GoodsSpecialSpec",
  props: { //用于接受上级的传值
    goods: { //声明goods对象
      type: Object
    }
  },
  methods: {
    //向规格数组中添加新值
    addSpec(spec) {
      this.$prompt("请输入数据")
          .then(({value}) => {
            if (!spec.includes(value))
              spec.push(value);
          });
    }
  },
  mounted() {
    console.log(this.goods);
  }
}
</script>

<style scoped>
.el-tag + .el-tag {
  margin-left: 10px;
}

.button-new-tag {
  margin-left: 10px;
  height: 32px;
  line-height: 30px;
  padding-top: 0;
  padding-bottom: 0;
}
</style>