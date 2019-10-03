<template>
  <div>
    <NavBar></NavBar>
    <v-flex class="mt-2">
      <v-container>
        <v-card max-width="auto" class="mx-auto">
          <div class="teal darken-1 text-center">
            <v-card-title class="title white--text">จัดเวรทำความสะอาด</v-card-title>
          </div>
          <v-container fluid>
            <v-form v-model="valid" ref="form">
              <v-row align="center">
                <v-col class="d-flex" cols="12" sm="6">
                  <v-select
                    label="วัน"
                    outlined
                    v-model="CleanUp.dayofweeks_id"
                    :items="dayofweeks"
                    item-text="day"
                    item-value="id"
                    :rules="[(v) => !!v || 'โปรดเลือกวัน']"
                    required
                  ></v-select>
                </v-col>

                <v-col class="d-flex" cols="12" sm="6">
                  <v-select
                    label="ช่วงเวลา"
                    outlined
                    v-model="CleanUp.duration_id"
                    :items="durations"
                    item-text="durationtime"
                    item-value="id"
                    :rules="[(v) => !!v || 'โปรดเลือกช่วงเวลา']"
                    required
                  ></v-select>
                </v-col>

                <v-col cols="12" sm="6">
                  <v-select
                    label="รหัสนักศึกษา"
                    v-model="CleanUp.clubmembers_id"
                    :items="clubmembers"
                    item-text="user.id_student"
                    item-value="id"
                    :rules="[(v) => !!v || 'โปรดเลือกรหัสนักศึกษา']"
                    required
                    outlined
                  ></v-select>
                </v-col>

                <v-col cols="12" sm="6" md="6">
                  <v-text-field
                    v-model="note"
                    label="หมายเหตุ"
                    :rules="[(v) => !!v || 'โปรดกรอกคำอธิบายหรือหมายเหตุ']"
                    required
                    outlined
                  ></v-text-field>
                </v-col>
              </v-row>

              <div class="text-center">
                <v-btn
                  @click="saveCleanUp"
                  class="title"
                  :class="{ error: !valid, primary: valid }"
                  min-width="110"
                  min-height="40"
                >
                  <v-icon left>done</v-icon>บันทึก
                </v-btn>
              </div>
            </v-form>
          </v-container>
        </v-card>
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

          <v-data-table :headers="headers" :items="items" hide-default-footer :search="search"></v-data-table>
        </v-card>
      </v-container>
    </v-flex>
  </div>
</template>



<script>
import http from "../http-common";
import NavBar from "../components/NavBar";
export default {
  name: "CleanUp",
  components: {
    NavBar
  },
  data() {
    return {
      CleanUp: {
        dayofweeks_id: "",
        duration_id: "",
        clubmembers_id: ""
      },
      headers: [
        {
          text: "รหัสนักศึกษา",
          align: "left",
          sortable: false,
          value: "clubMember.user.id_student"
        },
        { text: "วัน", value: "dayOfWeek.day" },
        { text: "ช่วงเวลา", value: "duration.durationtime" }
      ],
      items: [],
      dayofweeks: [],
      durations: [],
      clubmembers: [],
      search: "",
      note: "",
      valid: false,
      dialog: false,
      user: ""
    };
  },
  methods: {
    /* eslint-disable no-console */

    // ดึงข้อมูล DayOfWeek ใส่ combobox
    getDayOfWeeks() {
      http
        .get("/dayofweek")
        .then(response => {
          this.dayofweeks = response.data;
          console.log(this.dayofweeks);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล TimeOfDay ใส่ combobox
    getDurations() {
      http
        .get("/duration")
        .then(response => {
          this.durations = response.data;
          console.log(this.durations);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล ClubMember ใส่ combobox
    getClubMembers() {
      http
        .get("/clubmember")
        .then(response => {
          this.clubmembers = response.data;
          console.log(this.clubmembers);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // function เมื่อกดปุ่ม บันทึก
    saveCleanUp() {
      http
        .post(
          "/cleanup/" +
            this.CleanUp.clubmembers_id +
            "/" +
            this.CleanUp.dayofweeks_id +
            "/" +
            this.CleanUp.duration_id +
            "/" +
            this.note,
          this.CleanUp
        )
        .then(response => {
          console.log(response);
          alert("บันทึกสำเร็จ");
          window.location.reload();
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล CleanUp ใส่ Table
    getCleanUp() {
      http
        .get("/cleanup")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.getDayOfWeeks();
      this.getDurations();
      this.getClubMembers();
      this.getCleanUp();
    }
  },
  mounted() {
    this.getDayOfWeeks();
    this.getDurations();
    this.getClubMembers();
    this.getCleanUp();
  }
};
</script>