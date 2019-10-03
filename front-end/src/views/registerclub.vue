<template>
  <div>
    <ToolBar></ToolBar>
    <v-flex class="mt-5">
      <v-app id="inspire">
        <v-content>
          <v-container fluid fill-height>
            <v-layout justify-center>
              <v-flex xs12 sm md5>
                <v-card class="elevation-10">
                  <v-toolbar
                    dark
                    flat
                    src="../assets/wallpaper-4.jpg"
                  >
                    <v-toolbar-title>สมัครจัดตั้งชมรม</v-toolbar-title>
                    <v-spacer></v-spacer>
                  </v-toolbar>

                  <v-card-text>
                    <v-form>
                      <v-alert outlined type="success" color="orange" icon="edit" text>
                        <div class="title">รายละเอียดชมรม</div>
                        <v-row>
                          <v-col cols="12" sm="8">
                            <v-text-field
                              v-model="clubName"
                              label="ชื่อชมรม"
                              name="name"
                              type="tex"
                            ></v-text-field>
                          </v-col>
                          <v-col class="d-flex" cols="12" sm="4">
                            <v-select
                              label="ประเภทชมรม"
                              v-model="Clubs.ClubTypes_id"
                              :items="ClubTypes"
                              item-text="clubTypeName"
                              item-value="clubTypeId"
                              :rules="[(v) => !!v || 'Item is required']"
                              required
                            ></v-select>
                          </v-col>
                          <v-col class="d-inline-flex pa-2" cols="10" sm="12">
                            <v-text-field
                              v-model="clubDetail"
                              label="รายละเอียเกี่ยวกับชมรม"
                              solo
                              @keydown.enter="create"
                            >
                              <v-fade-transition v-slot:append>
                                <v-icon v-if="clubDetail" @click="create">add_circle</v-icon>
                              </v-fade-transition>
                            </v-text-field>
                          </v-col>
                        </v-row>
                      </v-alert>
                    </v-form>
                  </v-card-text>

                  <v-row justify="center">
                    <v-card-actions>
                      <v-btn dark color="#4CAF50" @click="saveClubs">Next</v-btn>
                    </v-card-actions>
                  </v-row>

                  <v-dialog v-model="dialog" max-width="700px">
                    <v-card>
                      <v-toolbar
                        dark
                        
                        src="../assets/wallpaper-4.jpg"
                      >
                        <v-toolbar-title>สมัครจัดตั้งชมรม</v-toolbar-title>
                        <v-spacer></v-spacer>
                      </v-toolbar>

                      <v-card-text>
                        <v-alert outlined type="success" color="orange" icon="edit" text>
                          <div class="title">รายชื่อชมรม</div>
                          <v-row justify="center">
                            <v-col class="d-flex" cols="12" sm="7">
                              <v-select
                                label="รายชื่อชมรม"
                                :items="clubs"
                                v-model="RegisterClubs.Club_id"
                                item-text="clubName"
                                item-value="clubId"
                                :rules="[(v) => !!v || 'Item is required']"
                                required
                              ></v-select>
                            </v-col>
                          </v-row>
                        </v-alert>

                        <v-alert outlined type="success" color="orange" icon="people_alt" text>
                          <div class="title">อาจารย์ที่ปรึกษาชมรม</div>
                          <v-row justify="center">
                            <v-col class="d-flex" cols="12" sm="7">
                              <v-select
                                label="รายชื่อที่ปรึกษาชมรม"
                                :items="Teachers"
                                v-model="RegisterClubs.teacher_id"
                                item-text="teacherName"
                                item-value="teacherId"
                                :rules="[(v) => !!v || 'Item is required']"
                                required
                              ></v-select>
                            </v-col>
                          </v-row>
                        </v-alert>

                        <v-alert outlined type="success" color="orange" icon="home" text>
                          <div class="title">สถานที่ตั้งชมรม</div>
                          <v-row justify="center">
                            <v-col class="d-flex" cols="12" sm="7">
                              <v-select
                                label="รายชื่อสถานที่"
                                :items="Locations"
                                v-model="RegisterClubs.location_id"
                                item-text="locationName"
                                item-value="locationId"
                                :rules="[(v) => !!v || 'Item is required']"
                                required
                              ></v-select>
                            </v-col>
                          </v-row>
                        </v-alert>

                        <v-row justify="center">
                          <v-card-actions>
                            <v-btn dark  color="#4CAF50" @click="saveRegisterClubs">Save</v-btn>
                          </v-card-actions>
                        </v-row>
                      </v-card-text>
                    </v-card>
                  </v-dialog>

                  <br />
                </v-card>
              </v-flex>
            </v-layout>
          </v-container>
        </v-content>
      </v-app>
    </v-flex>
  </div>
</template>

<script>
import http from "../http-common";
import ToolBar from "../components/ToolBar"

export default {
  name: "Clubs",
  components: {
    ToolBar
  },
  props: {
    source: String
  },
  data: () => ({
    Clubs: {
      ClubTypes_id: ""
    },
    RegisterClubs: {
      teacher_id: "",
      location_id: "",
      Club_id: "",
      
    },
    drawer: null,
    dialog: false,
    clubName: "",
    clubDetail: "",
    ClubTypes:[],
    clubs:[],
    Teachers:[],
    Locations:[]
  }),

  methods: {
    /* eslint-disable no-console */
    getClubType() {
      http
        .get("/clubType")
        .then(response => {
          this.ClubTypes = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    getTeachere() {
      http
        .get("/Teacher")
        .then(response => {
          this.Teachers = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    getLocation() {
      http
        .get("/Location")
        .then(response => {
          this.Locations = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    saveClubs() {
      http
        .post(
          "/Club/" +
            this.clubName +
            "/" +
            this.clubDetail +
            "/" +
            this.Clubs.ClubTypes_id,
          this.Clubs
        )
        .then(responses => {
          console.log(responses);
          this.dialog = true;
        })
        .catch(e => {
          console.log(e);
        });
    },

    getClub() {
      http
        .get("/Club")
        .then(response => {
          this.clubs = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    saveRegisterClubs() {
      http
        .post(
          "/RegisterClub/" +
            this.RegisterClubs.teacher_id +
            "/" +
            this.RegisterClubs.location_id +
            "/" +
            this.RegisterClubs.Club_id,
          this.RegisterClubs
        )
        .then(response => {
          console.log(response);
          this.dialog = false;
          window.location.reload();
          alert("successfully");
        })
        .catch(e => {
          console.log(e);
        });
    },

    refreshList() {
      this.getClubType();
      this.getTeachere();
      this.getLocation();
      this.getClub();
    }
  },
  mounted() {
    this.getClubType();
    this.getTeachere();
    this.getLocation();
    this.getClub();
  }
};
</script>



