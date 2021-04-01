<!-- 登录与密码修改弹出框页面 -->
<template>
  <div>
    <el-dialog
        :modal-append-to-body='false'
        :title="$t('nav.user.'+title)"
        :visible="dialogVisible"
        :width="dialogWidth"
        @close="handleClose"
    >
      <el-form :model="Form" ref="ruleForm" @submit.native.prevent>
        <el-form-item prop="username">
          <el-input v-model="Form.username" :placeholder="$t('nav.user.username')"
                    :disabled="title==='alterpwd'"></el-input>
        </el-form-item>
        <el-form-item v-if="title==='login'" prop="password">
          <el-input v-model="Form.password" :placeholder="$t('nav.user.password')" show-password></el-input>
        </el-form-item>
        <el-form-item v-if="title==='login'" prop="locale">
          <el-select v-model="Form.locale" placeholder="请选择" style="width: 100%" @change="handleSelect">
            <el-option label="简体中文" value="zh_CN"></el-option>
            <el-option label="English" value="en_US"></el-option>
            <el-option label="正體中文" value="zh_TW"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item v-if="title==='alterpwd'" prop="pwd">
          <el-input v-model="Form.pwd" :placeholder="$t('nav.user.pwd')" show-password></el-input>
        </el-form-item>
        <el-form-item v-if="title==='alterpwd'" prop="newpwd">
          <el-input v-model="Form.newpwd" :placeholder="$t('nav.user.newpwd')" show-password></el-input>
        </el-form-item>
        <el-form-item v-if="title==='alterpwd'" prop="newpwd2">
          <el-input v-model="Form.newpwd2" :placeholder="$t('nav.user.newpwd2')" show-password></el-input>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%" native-type="submit" type="success" @click="handlePrimaryBtn">
            {{ $t('nav.user.' + title) }}
          </el-button>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%" @click="resetForm">{{ $t('nav.user.reset') }}</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import {login, psdalter} from "@/api/User";

export default {
  name: "User",
  props: {
    dialogVisible: Boolean,
    title: String,
    username: String
  },
  data() {
    return {
      screenWidth: document.body.clientWidth,
      Form: {
        username: "",
        password: "",
        pwd: "",
        newpwd: "",
        newpwd2: "",
        locale: ""
      }
    }
  },
  computed: {
    dialogWidth(){
      return this.screenWidth<768?"100%":(this.screenWidth>=1200?"25%":"50%")
    }
  },
  watch: {
    //窗口打开关闭时会重置locale项
    dialogVisible() {
      this.Form.locale = this.$i18n.locale
    },
    username() {
      this.Form.username = this.username;
    }
  },
  methods: {
    handlePrimaryBtn() {
      if (this.title === 'login') {
        login(new URLSearchParams(this.Form)).then(function (response) {
          if (response.code !== 403) {
            this.$emit("handlePrimaryBtn");
            this.handleClose();
          }
        }.bind(this))
      } else {
        psdalter(new URLSearchParams(this.Form)).then(function (response) {
          if (response.code !== 403) {
            this.$emit("handlePrimaryBtn");
            this.handleClose();
          }
        }.bind(this))
      }
    },
    handleClose() {
      this.$emit("update:dialogVisible", false)
      this.resetForm()
    },
    handleSelect() {
      localStorage.setItem("LANGUAGE_CODE", this.Form.locale);
      this.$i18n.locale = this.Form.locale
    },
    resetForm() {
      this.$refs['ruleForm'].resetFields();
    }
  }, mounted() {
    const _this = this
    window.onresize = () => {
      return (() => {
        window.screenWidth = document.body.clientWidth
        _this.screenWidth = window.screenWidth
      })()
    }
  }
}
</script>
<style scoped>


</style>
