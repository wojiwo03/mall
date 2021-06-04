<template>
  <el-upload
      :on-success="handleAvatarSuccess"
      :show-file-list="false"
      action="http://api.eshop.com/upload"
      class="avatar-uploader">
    <img v-for="img in row.images.split(',')" :src="img" style="width: 40px;height:40px">
    <el-button size="small" type="primary">上传</el-button>
  </el-upload>
</template>

<script>
export default {
  name: "ImageUpload",
  props: {
    row: {  //当前上传图片的数据行
      type: Object
    }
  },
  methods: {
    handleAvatarSuccess(res) {
      this.row.images += "," + res;//连接图片路径 ,xxxxx,xxxx,xxxxx
      //判断开头是否有, 截取掉
      if (this.row.images.indexOf(",") == 0) {
        this.row.images = this.row.images.substring(1, this.row.images.length);
      }
    }
  }
}
</script>

<style scoped>

</style>