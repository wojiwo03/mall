<template>
  <div>
    <el-upload
        :on-success="handleAvatarSuccess"
        :show-file-list="false"
        action="http://api.eshop.com/upload"
        class="avatar-uploader">
      <img v-if="imageUrl" :src="imageUrl" class="avatar">
      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
  </div>
</template>

<script>
export default {
  name: "UploadTest",
  data() {
    return {
      imageUrl: ''
    }
  },
  methods: {
    handleAvatarSuccess(res, file) {
      console.log(res);
      this.imageUrl = res;
    }
  }
}
</script>

<style scoped>

</style>