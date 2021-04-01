<template>
  <div>
    <v-Filter
        v-if="navActiveIndex!=='historyborrow' && navActiveIndex!=='nowborrow'"
        ref="fillter"
        :Form="Form"
        :userinfo="userinfo"
        :nav-active-index="navActiveIndex"
        @searchHandler="searchHandler"
        @saveHandler="saveHandler"
        @addHandler="addHandler"
        :is-edit-mode="isEditMode">
    </v-Filter>
    <Table :Form="Form"
           :table-data="tableData"
           :userinfo="userinfo"
           :nav-active-index="navActiveIndex"
           @editHandler="editHandler"
           @delHandler="delHandler"
           @borrowHandler="borrowHandler"
           @returnHandler="returnHandler"
           @renewHandler="renewHandler"
           @resetHandler="resetHandler"
    ></Table>
  </div>
</template>

<script>
import Table from "@/components/Main/Table";
import {bookreaders, borrowreaders} from "@/api/Table";
import {addbook, delbook, editbook, getbook, getbooks} from "@/api/Books";
import {addborrow, renewborrow, retborrow} from "@/api/Borrow";
import {resetpwd} from "@/api/User";
import {addreader, delreader, editreader, getreader, getreaders} from "@/api/Readers";
import Filter from "@/components/Main/Filter";

export default {
  name: 'Main',
  data() {
    return {
      nullForm: {
        bookno: "",
        bookname: "",
        author: "",
        press: "",
        price: "",
        publishdate: "",
        shopnum: ""
      },
      nullReaderForm: {
        readerno: "",
        readername: "",
        sex: "",
        identitycard: "",
        workunit: ""
      },
      Form: {},
      isEditMode: false,
      tableData: []
    }
  },
  watch: {
    navActiveIndex() {
      this.refreshTable();
      this.setWebTitle();
    },
    userinfo() {
      this.refreshTable();
    }
  },
  props: {
    userinfo: Object,
    navActiveIndex: String
  },
  components: {
    'v-Filter': Filter,
    Table
  },
  methods: {
    setWebTitle() {
      document.title = this.$t('nav.'+this.navActiveIndex)+" - "+this.$t("nav.home")
    },
    getTable() {
    },
    //监听用户与标签变化
    refreshTable() {
      this.tableData = []
      if (this.navActiveIndex === 'bookmanager' && this.userinfo.role === "reader") {
        this.getTable = bookreaders
      } else if (this.navActiveIndex === 'readermanager') {
        this.getTable = getreaders
      } else if (this.navActiveIndex === 'bookmanager') {
        this.getTable = getbooks
      } else if (this.navActiveIndex === 'nowborrow') {
        borrowreaders('table=Borrow').then((response) => {
          this.tableData = response.rows
        })
      } else if (this.navActiveIndex === 'historyborrow') {
        borrowreaders('table=BorrowHistory').then((response) => {
          this.tableData = response.rows
        })
      }
      //根据过滤器刷新Table
      if (this.navActiveIndex === 'bookmanager' || this.navActiveIndex === 'readermanager') {
        this.resetForm();
        this.searchHandler()
      }
    },
    resetForm() {
      if (this.navActiveIndex === 'bookmanager') {
        this.Form = this.nullForm
      } else if (this.navActiveIndex === 'readermanager') {
        this.Form = this.nullReaderForm
      }
      for (let item in this.Form) {
        this.Form[item] = ""
      }
      this.isEditMode = false
    },
    searchHandler() {
      this.tableData = []
      this.getTable(new URLSearchParams(this.Form))
          .then((response) => {
            this.tableData = response.rows
          })
    },
    saveHandler() {
      if (this.navActiveIndex === 'bookmanager') {
        editbook(new URLSearchParams(this.Form))
            .then((response) => {
              if (response.code === 200) {
                this.refreshTable();
              }
            });
      } else {
        editreader(new URLSearchParams(this.Form))
            .then((response) => {
              if (response.code === 200) {
                this.refreshTable();
              }
            });
      }
    },
    addHandler() {
      if (this.navActiveIndex === 'bookmanager') {
        addbook(new URLSearchParams(this.Form))
            .then((response) => {
              if (response.code === 200) {
                this.refreshTable();
              }
            });
      } else {
        addreader(new URLSearchParams(this.Form))
            .then((response) => {
              if (response.code === 200) {
                this.refreshTable();
              }
            });
      }
    },
    editHandler(bookno) {
      if (this.navActiveIndex === 'bookmanager') {
        getbook(bookno).then(function (response) {
          this.Form = response
          this.isEditMode = true
        }.bind(this))
      } else {
        getreader(bookno).then(function (response) {
          this.Form = response
          this.isEditMode = true
        }.bind(this))
      }
    },
    delHandler(bookno) {
      if (this.navActiveIndex === 'bookmanager') {
        delbook(bookno)
            .then((response) => {
              if (response.code === 200) {
                this.refreshTable();
              }
            });
      } else {
        delreader(bookno)
            .then((response) => {
              if (response.code === 200) {
                this.refreshTable();
              }
            });
      }
    },
    borrowHandler(bookno) {
      addborrow(bookno)
          .then((response) => {
            if (response.code === 200) {
              this.refreshTable();
            }
          });
    },
    returnHandler(bookno) {
      retborrow(bookno)
          .then((response) => {
            if (response.code === 200) {
              this.refreshTable();
            }
          });
    },
    renewHandler(bookno) {
      renewborrow(bookno)
          .then((response) => {
            if (response.code === 200) {
              this.refreshTable();
            }
          });
    },
    resetHandler(readerno) {
      resetpwd("readerno=" + readerno)
          .then((response) => {
            if (response.code === 200) {
              this.refreshTable();
            }
          });
    }
  },mounted() {
    this.setWebTitle()
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>

</style>
