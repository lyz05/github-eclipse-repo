<template>
  <div>
    <el-row>
      <el-col :span="24">
        <el-card class="box-card" :body-style="{ padding: '0px' }">
          <el-table
              :data="tableData"
              border
              stripe
              highlight-current-row
              size="small"
              style="width: 100%"
              :cell-style="{}"
          >
            <!--            显示后端返回的表格信息-->
            <el-table-column
                v-for="(value, name) in tableData[0]"
                :key="name"
                sortable
                :prop="name"
                :label="$t('table.'+name)"
                :show-overflow-tooltip="false"
            >
            </el-table-column>
            <!--            生成最后一列操作列-->
            <el-table-column
                min-width="150"
                v-if="userinfo.role!=null && navActiveIndex !== 'historyborrow'"
                :label="$t('table.operation')"
            >
              <!--              根据标签状态与用户类型生成操作列-->
              <template slot-scope="scope" >
                <div v-if="userinfo.role==='reader' && navActiveIndex === 'bookmanager'">
                  <el-button @click="borrowHandler(scope.row.bookno)" type="text">{{ $t('table.borrowbook') }}</el-button>
                </div>
                <div v-if="userinfo.role==='admin' && navActiveIndex === 'bookmanager'">
                  <el-button @click="editHandler(scope.row.bookno)" size="small" type="primary" icon="el-icon-edit" circle :title="$t('table.edit')"></el-button>
                  <el-button @click="delHandler(scope.row.bookno)" size="small" type="danger" icon="el-icon-delete" circle :title="$t('table.delete')"></el-button>
<!--                  <el-button @click="editHandler(scope.row.bookno)" size="small" round>编辑</el-button>-->
<!--                  <el-button @click="delHandler(scope.row.bookno)" size="small" round>删除</el-button>-->
                </div>
                <div v-if="userinfo.role==='reader' && navActiveIndex === 'nowborrow'">
                  <el-button @click="returnHandler(scope.row.bookno)" type="text">{{ $t('table.returnbook') }}</el-button>
                  <el-button @click="renewHandler(scope.row.bookno)" type="text">{{ $t('table.renewbook') }}</el-button>
                </div>
                <div v-if="userinfo.role==='admin' && navActiveIndex === 'readermanager'">
                  <el-button @click="editHandler(scope.row.readerno)" size="small" type="primary" icon="el-icon-edit" circle :title="$t('table.edit')"></el-button>
                  <el-button @click="delHandler(scope.row.readerno)" size="small" type="danger" icon="el-icon-delete" circle :title="$t('table.delete')"></el-button>
                  <el-button @click="resetHandler(scope.row.readerno)" size="small" type="warning" icon="el-icon-refresh-right" circle :title="$t('table.resetpwd')"></el-button>
                </div>
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>

export default {
  name: "Table",
  props: {
    Form: Object,
    tableData: Array,
    userinfo: Object,
    navActiveIndex: String
  },
  methods: {
    editHandler(bookno) {
      this.$emit("editHandler", bookno);
    },
    delHandler(bookno) {
      this.$emit("delHandler", bookno);
    },
    borrowHandler(bookno) {
      this.$emit("borrowHandler",bookno)
    },
    returnHandler(bookno) {
      this.$emit("returnHandler",bookno)
    },
    renewHandler(bookno) {
      this.$emit("renewHandler",bookno)
    },
    resetHandler(readerno) {
      this.$emit("resetHandler",readerno)
    }
  }
}
</script>

<style scoped>

</style>