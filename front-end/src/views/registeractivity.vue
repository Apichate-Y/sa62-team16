<template>
  <div>
    <v-toolbar dark prominent src="../assets/wallpaper-3.jpg">
      <v-layout justify-center></v-layout>
      <v-toolbar-title>สมัครเข้าร่วมกิจกรรมชมรม</v-toolbar-title>
      <v-layout justify-center></v-layout>
    </v-toolbar>
    <v-flex class="mt-5">
      <v-card max-width="1200" class="mx-auto">
        <v-form>
          <v-container>
            <v-row>
              <v-col class="d-flex" cols="12" sm="4">
                <v-select
                  v-model="RegisterActivity.ClubMember_ID"
                  :items="clubmembers"
                  item-text="user.id_student"
                  item-value="id"
                  label="รหัสนักศึกษา"
                  outlined
                ></v-select>
              </v-col>
            </v-row>
            <v-row>
              <v-col class="d-flex" cols="12" sm="4">
                <v-select
                  v-model="RegisterActivity.Activity_ID"
                  :items="activitys"
                  item-text="name"
                  item-value="activityId"
                  label="กิจกรรม"
                  outlined
                ></v-select>
              </v-col>
              <v-col cols="12" sm="6" md="4">
                <v-text-field label="เบอร์โทร" v-model="PhoneNumber" outlined></v-text-field>
              </v-col>
            </v-row>
            <v-row>
              <v-col class="d-flex" cols="12" sm="4">
                <v-select
                  v-model="RegisterActivity.CongenitalDisease_ID"
                  :items="congenitalDisease"
                  item-text="congenitalDisease"
                  item-value="id"
                  label="โรคประจำตัว"
                  outlined
                ></v-select>
              </v-col>
              <v-col cols="12" sm="6" md="4">
                <v-text-field label="อาหารที่แพ้" v-model="FoodAllergic" outlined></v-text-field>
              </v-col>
            </v-row>
            <template>
              <div class="text-center">
                <v-btn
                  @click="$router.push('/dashboard')"
                  class="ma-2"
                  tile
                  outlined
                  color="warning"
                >
                  <v-icon left>keyboard_backspace</v-icon>ย้อนกลับ
                </v-btn>
                <v-btn @click="saveRegisterActiviy" class="ma-2" tile outlined color="success">
                  <v-icon left>done</v-icon>ยืนยัน
                </v-btn>
              </div>
            </template>
          </v-container>
        </v-form>
      </v-card>
    </v-flex>
  </div>
</template>


<script>
import http from "../http-common";

export default {
  name: "RegisterActivity",
  data() {
    return {
      RegisterActivity: {
        ClubMember_ID: String,
        Activity_ID: String,
        CongenitalDisease_ID: String
      },
      clubmembers: [],
      activitys: [],
      congenitalDisease: [],
      PhoneNumber: "",
      FoodAllergic: ""
    };
  },
  methods: {
    /* eslint-disable no-console */

    // ดึงข้อมูล ClubMember ใส่ combobox
    getClubMembers() {
      http
        .get("/clubmember")
        .then(response => {
          this.clubmembers = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล Activity ใส่ combobox
    getActivity() {
      http
        .get("/Activity")
        .then(response => {
          this.activitys = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล CongenitalDisease ใส่ combobox
    getCongenitalDisease() {
      http
        .get("/CongenitalDisease")
        .then(response => {
          this.congenitalDisease = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // function เมื่อกดปุ่ม ยืนยัน
    saveRegisterActiviy() {
      http
        .post(
          "/RegisterActivity/" +
            this.RegisterActivity.ClubMember_ID +
            "/" +
            this.RegisterActivity.Activity_ID +
            "/" +
            this.PhoneNumber +
            "/" +
            this.RegisterActivity.CongenitalDisease_ID +
            "/" +
            this.FoodAllergic,
          this.RegisterActivity
        )
        .then(response => {
          console.log(response);
          alert("บันทึกสำเร็จ");
          window.location.reload();
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.getClubMembers();
    this.getActivity();
    this.getCongenitalDisease();
  }
};
</script>
