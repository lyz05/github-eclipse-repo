<template>
  <div>
    <footer>
      <div style="text-align: center">
        <div id="copyright ">
          © 2015–2021
          <i class="fa fa-heart"></i>
          &nbsp;
          <span>lyz05</span>
        </div>
        <div id="powered-by">
          Powered by
          <span v-for="(link,index) in links" :key="link.name">
            <el-link type="primary" :href="link.href" class="theme-link">{{link.name}}</el-link>
            <span v-if="index+1!=links.length">&nbsp;&amp;&nbsp;</span>
          </span>
        </div>
      </div>
    </footer>
  </div>
</template>

<script>
export default {
  name: 'Footer',
  props: {
    msg: String
  },
  data() {
    return {
      links: [{
        name: 'Vue.js',
        href: 'https://cn.vuejs.org/index.html'
      },{
        name: 'Font awesome',
        href: 'https://fontawesome.com/'
      },{
        name: 'Element UI',
        href: 'https://element.eleme.cn/'
      }]
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
