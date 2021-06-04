import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from "axios";
import qs from "qs";
import Vuex from "vuex"

Vue.use(ElementUI)
Vue.use(Vuex)

//声明原型
Vue.prototype.$http = axios
//设置基础路径
Vue.prototype.$http.defaults.withCredentials = true
Vue.prototype.$http.defaults.baseURL = "http://api.eshop.com"
Vue.prototype.$qs = qs

const store = new Vuex.Store({
    state: {
        user: {username: ''}
    }
})

Vue.config.productionTip = false

new Vue({
    router,
    store,
    render: function (h) {
        return h(App)
    }
}).$mount('#app')
