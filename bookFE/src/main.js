import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'font-awesome/css/font-awesome.min.css'
import VueI18n from 'vue-i18n'
import zh_CN from '@/i18n/zh_CN'
import en_US from '@/i18n/en_US'
import zh_TW from "@/i18n/zh_TW";
import animated from "animate.css";

Vue.config.productionTip = false

Vue.use(ElementUI)
Vue.use(VueI18n)
Vue.use(animated)

//实例化vue-i18n
const i18n = new VueI18n({
  // 从本地存储中取，如果没有默认为中文，
  // 这样可以解决切换语言后，没记住选择的语言，刷新页面后还是默认的语言
  locale: localStorage.getItem('LANGUAGE_CODE') || 'zh_CN',
  messages: {
    zh_CN, // 中文语言包
    en_US, // 英文语言包
    zh_TW
  }
})

new Vue({
  render: h => h(App),
  i18n,
}).$mount('#app')
