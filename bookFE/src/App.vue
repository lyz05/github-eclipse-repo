<template>
  <div id="app" class="container-fluid">
    <NavBar :userinfo="userinfo" :active-index.sync="activeIndex" @handlePrimaryBtn="handlePrimaryBtn"/>
    <!-- 防止内容被导航栏遮挡  -->
    <div style="height: 70px"></div>
    <Main msg="Maincontent" :userinfo="userinfo" :nav-active-index="activeIndex"/>
    <Footer msg="Footer" />
  </div>
</template>

<script>
import NavBar from "@/components/NavBar"
import Main from "@/components/Main";
import Footer from "@/components/Footer";
import {userinfo} from "@/api/User";

export default {
  name: 'App',
  components: {
    NavBar,
    Main,
    Footer
  },
  data(){
    return {
      userinfo: {
        username: null,
        readername: null,
        role: null
      },
      activeIndex: "bookmanager"
    }
  },
  methods: {
    getUserInfo() {
      userinfo().then(function (response) {
        this.userinfo = response
      }.bind(this))
    },
    handlePrimaryBtn(){
      this.getUserInfo()
    }
  },mounted() {
    this.handlePrimaryBtn()
  }
}
</script>

<style>
.el-row {
  margin-bottom: 20px;
}
.el-col {
  border-radius: 4px;
}
</style>
