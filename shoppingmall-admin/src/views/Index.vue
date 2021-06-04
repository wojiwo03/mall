<template>
  <el-container style="height: 500px; border: 1px solid #eee">
    <el-aside style="background-color: rgb(238, 241, 246)" width="200px">
      <el-menu>
        <el-submenu v-for="fun in functions" :key="fun" index="fun.id">
          <template slot="title"><i :class="fun.icon"></i>{{ fun.name }}</template>
          <el-menu-item-group>
            <el-menu-item v-for="cfun in fun.subFunctions" :key="cfun" index="cfun.id">
              <router-link :to="cfun.url">{{ cfun.name }}</router-link>
            </el-menu-item>
          </el-menu-item-group>
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>查看</el-dropdown-item>
            <el-dropdown-item>新增</el-dropdown-item>
            <el-dropdown-item>删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>admin</span>
      </el-header>

      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      functions: []
    }
  },
  methods: {
    loadUserFunctions() {
      //通过用户名查询权限菜单
      this.$http.get("http://api.eshop.com/menu?userId=1")
          .then(value => {
            console.log(value)
            if (value.data) {
              this.functions = value.data;
            }
          })
    }
  },
  mounted() {
    this.loadUserFunctions();
  }
}
</script>

<style scoped>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>