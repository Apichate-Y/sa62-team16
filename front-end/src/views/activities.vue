<template>
<v-flex class="mt-1">
  <v-card max-width="1000" class="mx-auto">
    <div class="teal darken-1 text-center">
      <v-layout justify-center>
        <v-card-title class="white--text">สร้างกิจกรรมชมรม</v-card-title>
      </v-layout>
    </div>

    <v-container>
      <v-row>
        <v-col class="d-flex" cols="12" sm="6">
          <v-select
            v-model="activity.registerClubId"
            label="ชมรม"
            outlined
            :items="Aboard"
            item-text="clubname"
            item-value="registerClubId"
            :rules="[(v) => !!v || 'กรุณาเลือกชมรม']"
            required
          ></v-select>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="12" sm md="6">
          <v-text-field label="ชื่อกิจกรรม" v-model="Aname" 
          :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
            requiredoutlined></v-text-field>
        </v-col>

        <v-col class="d-flex" cols="12" sm="6">
          <v-select
            v-model="activity.TypeId"
            label="ประเภทกิจกรรม"
            outlined
            :items="Atype"
            item-text="typename"
            item-value="typeId"
            :rules="[(v) => !!v || 'กรุณาเลือกประเภทกิจกกรม']"
            required
          ></v-select>
        </v-col>
      </v-row>

      <v-row>
        <v-col cols="12" sm="6" md="6">
          <v-menu
            v-model="menu"
            :close-on-content-click="false"
            :nudge-right="40"
            transition="scale-transition"
            offset-y
            full-width
            min-width="290px"
          >
            <template v-slot:activator="{ on }">
              <v-text-field
                v-model="date"
                label="วันที่เริ่มกิจกรรม"
                prepend-icon="event"
                readonly
                v-on="on"
              ></v-text-field>
            </template>
            <v-date-picker v-model="date" @input="menu = false"></v-date-picker>
          </v-menu>
        </v-col>
        <v-col cols="12" sm="6" md="4">
          <v-menu
            v-model="menu2"
            :close-on-content-click="false"
            :nudge-right="40"
            transition="scale-transition"
            offset-y
            full-width
            min-width="290px"
          >
            <template v-slot:activator="{ on }">
              <v-text-field
                v-model="date2"
                label="วันที่สิ้นสุดกิจกรรม"
                prepend-icon="event"
                readonly
                v-on="on"
              ></v-text-field>
            </template>
            <v-date-picker v-model="date2" @input="menu2 = false"></v-date-picker>
          </v-menu>
        </v-col>
      </v-row>

      <v-row>
        <v-col class="d-flex" cols="12" sm="6">
          <v-select
            label="ภาคเรียนที่"
            v-model="activity.TermId"
            outlined
            :items="Aterm"
            item-text="termname"
            item-value="termId"
            :rules="[(v) => !!v || 'กรุณาเลือกภาคเรียน']"
            required
          ></v-select>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="12" sm md="6">
          <v-text-field
            v-model="venue"
            label="สถานที่จัดกิจกรรม"
            outlined
            :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
            required
          ></v-text-field>
        </v-col>

        <v-col cols="12" sm md="6">
          <v-text-field
            v-model="recrutis"
            label="จำนวนที่รับสมัคร"
            outlined
            :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
            required
          ></v-text-field>
        </v-col>
      </v-row>

      <template>
        <div class="text-center">
          <v-btn @click="saveActivity" color="indigo" dark large>บันทึกข้อมูล</v-btn>
        </div>
      </template>
    </v-container>
  </v-card>
  </v-flex>
</template>

<script>
import http from "../http-common";

export default {
  name: "Activity",
  data() {
    return {
      activity: {
        registerClubId: "",
        TypeId: "",
        TermId: ""
      },
      menu: false,
      date: new Date().toISOString().substr(0, 10),
      menu2: false,
      date2: new Date().toISOString().substr(0, 10),
      Aboard: [],
      Atype: [],
      Aterm: [],
      Aname: "",
      venue: ""
    };
  },

  methods: {
    /* eslint-disable no-console */

    // ดึงข้อมูล Employee ใส่ combobox
    getregisterClubs() {
      http
        .get("/registerClub")
        .then(response => {
          this.Aboard = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    gettypes() {
      http
        .get("/type")
        .then(response => {
          this.Atype = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    getterms() {
      http
        .get("/term")
        .then(response => {
          this.Aterm = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    saveActivity() {
      http
        .post(
          "/activity/" +
            this.activity.registerClubId +
            "/" +
            this.Aname +
            "/" +
            this.activity.TypeId +
            "/" +
            this.date +
            "/" +
            this.date2 +
            "/" +
            this.activity.TermId +
            "/" +
            this.venue +
            "/" +
            this.recrutis,
            this.activity
        )
        .then(response => {
          console.log(response);
          alert("บันทึกข้อมูลสำเร็จ")
          window.location.reload();
        })
        .catch(e => {
          console.log(e);
        });
    },

    refreshList() {
      this.getregisterClubs();
      this.getterms();
      this.gettypes();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    this.getregisterClubs();
    this.getterms();
    this.gettypes();
  }
};
</script>
