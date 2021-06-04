import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../views/Login";
import Index from "../views/Index";
import Goods from "../views/Goods";

Vue.use(VueRouter)

const routes = [
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/index',
        name: 'Index',
        component: Index,
    },
    {
        path: '/goods',
        name: 'Goods',
        component: Goods,
    }
]

const router = new VueRouter({
    routes
})

export default router
