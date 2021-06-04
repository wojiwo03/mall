<template>
  <div>
    <el-form :model="goods.spu" label-width="80px">
      <el-form-item label="商品描述">
        <quill-editor v-model="goods.spuDetail.description"></quill-editor>
        <el-upload
            :on-success="handleAvatarSuccess"
            :show-file-list="false"
            action="http://api.eshop.com/upload"
            class="avatar-uploader">
          <el-button size="small" type="primary">上传图片</el-button>
        </el-upload>
      </el-form-item>
      <el-form-item label="赠品清单">
        <el-input v-model="goods.spuDetail.packingList"></el-input>
      </el-form-item>
      <el-form-item label="售后服务">
        <el-input v-model="goods.spuDetail.afterService"></el-input>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'

import {quillEditor} from 'vue-quill-editor'

export default {
  name: "GoodsDetail",
  components: {
    quillEditor
  },
  props: { //用于接受上级的传值
    goods: { //声明goods对象
      type: Object
    }
  },
  methods: {
    handleAvatarSuccess(res) {
      this.goods.spuDetail.description += "<img src='" + res + "'>";
    }
  }
}
</script>

<style scoped>

</style>