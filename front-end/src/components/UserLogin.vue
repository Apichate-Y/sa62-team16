<template>
  <v-app id="inspire">
    <v-content>
      <div
        class="img-background"
        v-bind:style="{'background-image': 'url(' + require('../assets/UserOne.jpg') + ')'}"
      >
        <v-container class="fill-height" fluid>
          <v-row align="center" justify="center">
            <v-col md="8">
              <v-card class="elevation-12">
                <v-row class="mx-auto">
                  <v-img height="mx-auto" width="325" dark src="../assets/UserTwo.jpg"></v-img>
                  <v-col class="text-center" md="mx-auto">
                    <v-container class="mx-auto">
                      <v-col cols="12" sm="3">
                        <v-btn @click="$router.push('/')" left text color="teal">
                          <v-icon left>arrow_back</v-icon>Back
                        </v-btn>
                      </v-col>
                      <v-row class="justify-center">
                        <v-icon size="50" color="teal darken-4">account_circle</v-icon>
                        <v-card-text>
                          <h1>MEMBER</h1>
                          <v-form>
                            <v-text-field
                              label="๊Username"
                              name="login"
                              v-model="username"
                              prepend-icon="person"
                              type="text"
                            ></v-text-field>

                            <v-text-field
                              id="password"
                              label="Password"
                              name="password"
                              v-model="password"
                              prepend-icon="lock"
                              type="password"
                            ></v-text-field>
                          </v-form>
                        </v-card-text>

                        <v-card-actions class="justify-center">
                          <v-btn
                            text
                            color="primary"
                            @click="$router.push('/registerclubmember')"
                          >Sign up</v-btn>

                          <v-btn rounded color="primary" dark large @click="getLoginUser">login</v-btn>
                        </v-card-actions>
                      </v-row>
                    </v-container>
                  </v-col>
                </v-row>
              </v-card>
            </v-col>
          </v-row>
        </v-container>
      </div>
    </v-content>
  </v-app>
</template>

<script>
import http from "../http-common";

export default {
  name: "UserLogin",
  data() {
    return {
      clubmembers: [],
      username: "",
      password: ""
    };
  },
  methods: {
    /* eslint-disable no-console */
    getLoginUser() {
      http
        .get("/clubmember" + "/" + this.username + "/" + this.password)
        .then(response => {
          console.log(response.data);

          localStorage.setItem(
            "clubmembers_id",
            JSON.stringify(response.data.id)
          );

          localStorage.setItem(
            "clubname",
            JSON.stringify(response.data.registerClub.club.clubName)
          );

          localStorage.setItem(
            "memberposition",
            JSON.stringify(response.data.positionClub.positionclub_name)
          );

          this.$router.push("/dashboard");
        })
        .catch(e => {
          console.log(e);
          alert("Username/Password ไม่ถูกต้อง");
        });
    }
  }
};
</script>

<style>
.img-background {
  width: 100%;
  height: 100%;
  background-size: cover;
}
</style>
