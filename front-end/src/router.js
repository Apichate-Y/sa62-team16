import Vue from 'vue'
import Router from 'vue-router'
import Dashboard from './views/dashboard.vue'
import Cleaning from './views/cleaning.vue'
import Income from './views/income.vue'
import Activities from './views/activities.vue'
import NavBar from "./components/NavBar.vue";
import UserLogin from "./components/UserLogin.vue"
import MainLogin from "./components/MainLogin.vue"
import AdminLogin from "./components/AdminLogin.vue"
import RegisterClubmember from "./views/registerclubmember.vue"
import RegisterClub from "./views/registerclub.vue"

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/mainlogin',
      name: 'mainlogin',
      component: MainLogin
    },
    {
      path: '/adminlogin',
      name: 'adminlogin',
      component: AdminLogin
    },
    {
      path: '/userlogin',
      name: 'userlogin',
      component: UserLogin
    },
    {
      path: '/navbar',
      name: 'navbar',
      component: NavBar
    },
    {
      path: '/registerclub',
      name: 'registerclub',
      component: RegisterClub
    },
    {
      path: '/registerclubmember',
      name: 'registerclubmember',
      component: RegisterClubmember
    }
    ,
    {
      path: '/',
      name: 'dashboard',
      component: Dashboard
    },
    {
      path: '/cleaning',
      name: 'cleaning',
      component: Cleaning
    },
    {
      path: '/income',
      name: 'income',
      component: Income
    },
    {
      path: '/activities',
      name: 'activities',
      component: Activities
    }
  ]
})

