<template>
  <div>
    <NavBar></NavBar>
    <v-flex class="mt-2">
      <v-container>
        <v-card>
          <div class="teal darken-1 text-center">
            <v-card-title class="title white--text">รายชื่อกิจกรรม</v-card-title>
          </div>
          <v-data-table
            :headers="headers1"
            :items="Activity"
            :items-per-page="10"
            class="elevation-1"
          ></v-data-table>
        </v-card>

        <v-row>
          <v-spacer></v-spacer>
          <v-col cols="auto">
            <div class="text-center">
              <v-btn
                class="primary"
                min-width="110"
                min-height="40"
                @click="$router.push('/registeractivity')"
              >สมัครกิจกรรมชมรม</v-btn>
            </div>
          </v-col>
        </v-row>
      </v-container>

      <v-container>
        <v-card>
          <div class="teal darken-1 text-center">
            <v-card-title class="title white--text">
              ตารางเวรทำความสะอาด
              <v-spacer></v-spacer>
              <v-text-field
                class="teal lighten-5"
                v-model="search"
                append-icon="search"
                label="ค้นหา"
                single-line
                hide-details
              ></v-text-field>
            </v-card-title>
          </div>

          <v-data-table :headers="headers2" :items="cleanup" hide-default-footer :search="search"></v-data-table>
        </v-card>
      </v-container>
    </v-flex>
  </div>
</template>

<script>
import NavBar from "../components/NavBar";
import http from "../http-common";

export default {
  name: "Dashboard",
  components: {
    NavBar
  },
  data() {
    return {
      headers1: [
        {
          text: "ชื่อกิจกรรม",
          align: "left",
          sortable: false,
          value: "name"
        },
        { text: "ประเภทกิจกรรม", value: "type.typename" },
        { text: "ชมรม", value: "registerClub.club.clubName" },
        { text: "วันที่เริ่มต้นกิจกรรม", value: "startDate" },
        { text: "วันที่สิ้นสุดกิจกรรม", value: "endDate" }
      ],
      headers2: [
        {
          text: "รหัสนักศึกษา",
          align: "left",
          sortable: false,
          value: "clubMember.user.id_student"
        },
        { text: "วัน", value: "dayOfWeek.day" },
        { text: "ช่วงเวลา", value: "duration.durationtime" }
      ],
      Activity: [],
      cleanup:[],
      search: ""
    };
  },
  methods: {
    /* eslint-disable no-console */
    getActivity() {
      http
        .get("/Activity")
        .then(response => {
          this.Activity = response.data;
          console.log(this.Activity);
        })
        .catch(e => {
          console.log(e);
        });
    },
    getCleanUp() {
      http
        .get("/cleanup")
        .then(response => {
          this.cleanup = response.data;
          console.log(this.cleanup);
        })
        .catch(e => {
          console.log(e);
        });
    },
  },
  mounted() {
    this.getActivity();
    this.getCleanUp();
  }
};
</script>
