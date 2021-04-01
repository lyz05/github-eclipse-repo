<template>
  <div id="header">
    <el-menu default-active="bookmanager" mode="horizontal" @select="handleSelect">
      <div class="logo">
        <span>{{$t('nav.home')}}</span>
      </div>
      <el-menu-item index="bookmanager">
        <i class="fa fa-book"></i>
        {{$t('nav.bookmanager')}}
      </el-menu-item>
      <el-menu-item v-if="userinfo.role==='reader'" index="nowborrow">
        <i class="fa fa-list-alt"></i>
        {{$t('nav.nowborrow')}}
      </el-menu-item>
      <el-menu-item v-if="userinfo.role==='reader'" index="historyborrow">
        <i class="fa fa-list-alt"></i>
        {{$t('nav.historyborrow')}}
      </el-menu-item>
      <el-menu-item v-if="userinfo.role==='admin'" index="readermanager">
        <i class="fa fa-users"></i>
        {{$t('nav.readermanager')}}
      </el-menu-item>
      <el-submenu index="用户管理" v-if="userinfo.role!=null" style="float: right">
        <template slot="title">{{$t('nav.user.hello')}}，{{ userinfo.readername == null ? userinfo.username : userinfo.readername }}</template>
        <el-menu-item-group title="">
          <el-menu-item @click="handleAlterPwd">
            <el-link icon="el-icon-edit" :underline="false">{{$t('nav.user.alterpwd')}}</el-link>
          </el-menu-item>
          <el-menu-item @click="handleLogout">
            <el-link icon="el-icon-switch-button" :underline="false">{{$t('nav.user.logout')}}</el-link>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-menu-item v-if="userinfo.role==null" style="float: right">
        <el-button size="small" @click="handleLogin" round>{{$t('nav.user.login')}}</el-button>
      </el-menu-item>
    </el-menu>
    <!-- 登录注册模态框   -->
    <User :username="userinfo.username" :title="dialogTitle" :dialog-visible.sync="dialogVisible"
          @handlePrimaryBtn="handlePrimaryBtn"></User>
  </div>
</template>

<script>
import User from '@/components/NavBar/User';
import {logout} from '@/api/User'

export default {
  name: 'Navbar',
  props: {
    userinfo: Object,
    activeIndex: String,
  },
  components: {
    User
  },
  data() {
    return {
      dialogVisible: false,
      dialogTitle: 'login'
    }
  },
  methods: {
    handleSelect(key) {
      if (key!=null && key!=="用户管理") {
        this.$emit("update:activeIndex", key)
      }
    },
    handlePrimaryBtn() {
      this.$emit("handlePrimaryBtn")
    },
    handleLogout() {
      logout().then(function () {
        this.handleSelect("bookmanager")
        this.handlePrimaryBtn()
      }.bind(this))
    },
    handleAlterPwd() {
      this.dialogVisible = true
      this.dialogTitle = 'alterpwd'
    },
    handleLogin() {
      this.dialogVisible = true
      this.dialogTitle = 'login'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
#header {
  min-width: 300px;
  position: fixed;
  top: 0;
  left: 0;
  height: auto;
  width: 100%;
  z-index: 1000;
  background-color: #fff;
  box-shadow: 0 1px 5px 0 rgba(0, 0, 0, 0.1);
}

.logo {
  margin-left: 2%;
  margin-right: 2%;
  font-size: 20px;
  float: left;
  line-height: 60px;
}

</style>
