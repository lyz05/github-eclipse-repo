<template>
  <div>
    <el-row>
      <el-col :span="24">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>{{ $t('nav.' + navActiveIndex) }} {{ $t('Filter.filter') }}</span>
          </div>
          <el-form ref="ruleForm" label-width="120px" :model="Form" @submit.native.prevent>
            <el-row :gutter="10">
              <el-col :sm="12" :lg="8" v-for="(value, name) in Form" :key="name">
                <el-form-item :label="$t('table.'+name)" :prop="name">
                  <el-input v-model="Form[name]" clearable></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <!--            <el-form-item label="出版日期">-->
              <!--                <el-date-picker-->
              <!--                    :unlink-panels="true"-->
              <!--                    style="width: 100%"-->
              <!--                    type="daterange"-->
              <!--                    range-separator="至"-->
              <!--                    start-placeholder="开始日期"-->
              <!--                    end-placeholder="结束日期">-->
              <!--                </el-date-picker>-->
              <!--            </el-form-item>-->

              <!--            <el-form-item>-->
              <!--              <el-switch-->
              <!--                  style="display: block"-->
              <!--                  v-model="value2"-->
              <!--                  active-color="#13ce66"-->
              <!--                  active-text="仅选择可借阅书籍"-->
              <!--              >-->
              <!--              </el-switch>-->
              <!--            </el-form-item>-->
              <el-form-item>
                <el-button-group>
                  <el-button icon="el-icon-search" native-type="submit" type="primary" @click="searchHandler()">
                    {{ $t('Filter.search') }}
                  </el-button>
                  <transition enter-active-class="animate__animated animate__fadeIn" leave-active-class="animate__animated animate__fadeOut">
                    <el-button icon="el-icon-plus" v-if="userinfo.role==='admin'" @click="addHandler()">
                      {{ $t('Filter.add') }}
                    </el-button>
                  </transition>
                  <transition enter-active-class="animate__animated animate__fadeIn" leave-active-class="animate__animated animate__fadeOut">
                    <el-button icon="el-icon-upload2" v-if="isEditMode" @click="saveHandler()">
                      {{ $t('Filter.save') }}
                    </el-button>
                  </transition>
                </el-button-group>
              </el-form-item>
            </el-row>
          </el-form>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Fillter",
  props: {
    Form: Object,
    isEditMode: Boolean,
    userinfo: Object,
    navActiveIndex: String
  },
  methods: {
    searchHandler() {
      this.$emit("searchHandler");
    },
    saveHandler() {
      this.$emit("saveHandler");
    },
    addHandler() {
      this.$emit("addHandler");
    }
  }
}
</script>

<style scoped>

</style>