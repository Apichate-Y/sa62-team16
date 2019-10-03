<template>
  <div>
    <NavBar></NavBar>
    <v-flex class="mt-2">
      <v-container>
        <v-card max-width="auto" class="mx-auto">
          <div class="teal darken-1 text-center">
          <v-card-title class="title white--text">รายรับ-รายจ่าย</v-card-title>
          </div>
          <v-container fluid>
            <v-row>
              <v-col cols="12" sm="6" md="4">
                <v-text-field
                  label="รายการ"
                  v-model="expensename"
                  :rules="[(v) => !!v || 'Item is required']"
                ></v-text-field>
              </v-col>
            </v-row>
          </v-container>
          <v-container fluid>
            <v-row>
              <v-col class="d-flex" cols="12" sm="2">
                <v-select
                  v-model="income.expid"
                  :items="exptype"
                  label="ประเภท"
                  item-text="typename"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                ></v-select>
              </v-col>

              <v-col class="d-flex" cols="12" sm="2">
                <v-select
                  v-model="income.cateid"
                  :items="category"
                  label="หมวด"
                  item-text="categoryname"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                ></v-select>
              </v-col>

              <v-col class="d-flex" cols="12" sm="2">
                <v-select
                  v-model="income.statid"
                  :items="status"
                  label="สถานะ"
                  item-text="statusname"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                ></v-select>
              </v-col>

              <v-col cols="5" sm="2" md="2">
                <v-text-field
                  label="จำนวนเงิน"
                  v-model="amount"
                  :rules="[(v) => !!v || 'Item is required']"
                ></v-text-field>
              </v-col>

              <v-row justify="center">
                <v-col cols="12">
                  <v-btn @click="saveIncome" color="blue-grey darken-2" dark>บันทึกรายการ</v-btn>
                </v-col>
              </v-row>
            </v-row>
          </v-container>
          <v-container>
            <v-layout text-left wrap>
              <v-flex mb-4>
                <br />
                <h1 class="display-1 font-bold mb-1">ตารางรายรับ-รายจ่าย</h1>
              </v-flex>
            </v-layout>

            <v-row justify="center">
              <v-col cols="12">
                <v-data-table
                  :headers="headers"
                  :items="items"
                  :items-per-page="5"
                  class="elevation-1"
                ></v-data-table>
              </v-col>
            </v-row>
          </v-container>
        </v-card>
      </v-container>
    </v-flex>
  </div>
</template>


<script>
import http from "../http-common";
import NavBar from "../components/NavBar";

export default {
  name: "Income",
  components: {
    NavBar
  },
  data() {
    return {
      income: {
        expid: "",
        cateid: "",
        statid: ""
      },
      headers: [
        {
          text: "รายการ",
          align: "left",
          sortable: false,
          value: "expensename"
        },
        { text: "ประเภท", value: "exp_id.typename" },
        { text: "หมวด", value: "cate_id.categoryname" },
        { text: "สถานะ", value: "st_id.statusname" },
        { text: "จำนวนเงิน", value: "amount" }
      ],
      exptype: [],
      category: [],
      status: [],
      expensename: "",
      amount: "",
      valid: false,
      check: false,
      items: [],
      clubmembers_id:""
    };
  },
  methods: {
    /* eslint-disable no-console */
    // ดึงข้อมูล Employee ใส่ combobox
    getExpenselists() {
      http
        .get("/expentype")
        .then(response => {
          this.exptype = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    getGroups() {
      http
        .get("/category")
        .then(response => {
          this.category = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    getStatus() {
      http
        .get("/statuse")
        .then(response => {
          this.status = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    saveIncome() {
      http
        .post(
          "/incomes/" +
            this.expensename +
            "/" +
            this.clubmembers_id +
            "/" +
            this.income.expid +
            "/" +
            this.income.cateid +
            "/" +
            this.income.statid +
            "/" +
            this.amount
        )
        .then(response => {
          console.log(response);
          window.location.reload();
        })
        .catch(e => {
          console.log(e);
        });
    },
    getIncome() {
      http
        .get("/incomes")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.getExpenselists();
      this.getGroups();
      this.getStatus();
      this.getIncome();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    this.getExpenselists();
    this.getGroups();
    this.getStatus();
    this.getIncome();
  }
};
</script>