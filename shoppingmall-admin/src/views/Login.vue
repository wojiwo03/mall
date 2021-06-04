<template>
  <div class="login_box">
    <el-card>
      <div slot="header" class="clearfix">
        <span>用户登录</span>
      </div>
      <div>
        <span v-show="showError" style="color: red">账号或密码错误</span>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="账号">
            <el-input v-model="form.username"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="form.password" type="password"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="login">提交</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      form: {
        username: 'admin',
        password: '123456'
      },
      showError: false
    }
  },
  methods: {
    login() {
      //提交登录请求
      this.$http.post("http://api.eshop.com/login", this.form)
          .then(value => {
            this.$router.push({path: '/index'})
          });
    }
  }
}
</script>

<style scoped>
.login_box {
  width: 500px;
  height: 400px;
  margin: 100px auto;
}
</style>