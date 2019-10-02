<template>
  <div>
    <v-toolbar
      height="150"
      dark
      prominent
      src="https://www.wallpapermaiden.com/wallpaper/5458/download/1980x1080/minimalism-scenic-toon-colors-deer-sun-forest-trees-mountain.jpg"
    >
      <v-toolbar-title  class="display-1">สมัครสมาชิกชมรม</v-toolbar-title>
    </v-toolbar>
    <v-flex class="mt-5">
      <v-card max-width="auto" class="mx-auto">
       

        <v-container>
          <v-row>
            <v-col cols="12" sm="6" md="3">
          <v-text-field
             v-model="username"
            label="User"
            outlined
          ></v-text-field>
          </v-col>
          <v-col cols="12" sm="6" md="3">
          <v-text-field
            v-model="password"
            label="Password"
            outlined
          ></v-text-field>
        </v-col>
            <v-col class="d-flex" cols="12" sm="6">
              <v-select 
              v-model="clubMember.User_id"
              :items="users" 
              item-text="id_student" 
              item-value="user_id"
              label="รหัสนักศึกษา" 
              outlined></v-select>
            </v-col>
            <v-col class="d-flex" cols="12" sm="6">
              <v-select 
              v-model="clubMember.RegisterClub_id"
              :items="RegisterClubs" 
              item-text="clubName" 
              item-value="registerClubid"
              label="ชมรม" 
              outlined></v-select>
            </v-col>
            <v-col class="d-flex" cols="12" sm="6">
              <v-select
              v-model="clubMember.PositionClub_id"
               :items="positionClubs"
                item-text="positionclub_name" 
                item-value="positionclub_id"
                label="ตำแหน่ง" 
                outlined></v-select>
            </v-col> 
          </v-row>
        </v-container>
        <div class="text-center">
          <v-btn @click="saveclubMember" class="ma-2" color="success">
            <v-icon left>done</v-icon>ยืนยัน
          </v-btn>
        </div>
      </v-card>
    </v-flex>
  </div>
</template>


<script>
  import http from "../http-common";
export default {
  name: "clubMember",
  data() {
    return {
      clubMember: {
        User_id: "",
        RegisterClub_id: "",
        PositionClub_id: ""
      },
      users:[],
      RegisterClubs:[],
      positionClubs:[],
      username:"",
      password:""
    };
  },
  methods: {
    /* eslint-disable no-console */
    // ดึงข้อมูล RegisterClub ใส่ combobox
    getUser() {
      http
        .get("/user")
        .then(response => {
          this.users = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล RegisterClub ใส่ combobox
    getRegisterClub() {
      http
        .get("/RegisterClub")
        .then(response => {
          this.RegisterClubs = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล PositionClub ใส่ combobox
    getPositionClub() {
      http
        .get("/positionClub")
        .then(response => {
          this.positionClubs = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
   
    // function เมื่อกดปุ่ม submit
    saveclubMember() {
      http
        .post(
          "/clubMember/" +
            this.username +
            "/" +
            this.password +
            "/" +
            this.clubMember.User_id +
            "/" +
            this.clubMember.RegisterClub_id +
            "/" +
            this.clubMember.PositionClub_id 
        )
        .then(response => {
          console.log(response);
          alert("บันทึกสำเร็จ");
        })
        .catch(e => {
          console.log(e);
        });
      //this.submitted = true;
    },
    /* eslint-enable no-console */
  },
  mounted() {
    this.getUser();
    this.getRegisterClub();
    this.getPositionClub();
  }
};
</script>