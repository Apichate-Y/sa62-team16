<template>
  <v-app id="inspire">
    <v-content>
      <div
        class="img-background"
        v-bind:style="{'background-image': 'url(' + require('../assets/AdminOne.jpg') + ')'}"
      >
        <v-container class="fill-height" fluid>
          <v-row align="center" justify="center">
            <v-col md="8">
              <v-card class="elevation-12">
                <v-row class="mx-auto">
                  <v-img height="mx-auto" width="325" dark src="../assets/AdminTwo.jpg"></v-img>

                  <v-col class="text-center" md="mx-auto">
                    <v-container class="mx-auto">
                      <v-col cols="12" sm="3">
                        <v-btn @click="$router.push('/')" left text color="#F4511E">
                          <v-icon left>arrow_back</v-icon>Back
                        </v-btn>
                      </v-col>
                      <v-row class="justify-center">
                        <v-icon size="50" color="orange darken-4">account_circle</v-icon>
                        <v-card-text>
                          <h1>ADMIN</h1>
                          <v-form>
                            <v-text-field
                              label="๊Username"
                              v-model="adminusername"
                              name="login"
                              prepend-icon="person"
                              type="text"
                            ></v-text-field>

                            <v-text-field
                              id="password"
                              label="Password"
                              v-model="adminpassword"
                              name="password"
                              prepend-icon="lock"
                              type="password"
                            ></v-text-field>
                          </v-form>
                        </v-card-text>

                        <v-card-actions class="justify-center">
                          <v-btn
                            rounded
                            color="primary"
                            dark
                            large
                            @click="getLoginAdmin"
                          >login</v-btn>
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
  name: "AdminLogin",
  data() {
    return {
      admins: [],
      adminusername: "",
      adminpassword: "",

    };
  },
  methods: {
    /* eslint-disable no-console */
    getLoginAdmin() {
      http
        .get("/admin" + "/" + this.adminusername + "/" + this.adminpassword)
        .then(response => {
          this.admins = response.data;
          console.log(this.admins);
          this.$router.push('/registerclub')
        })
        .catch(e => {
          console.log(e);
          alert("Username หรือ Password ไม่ถูกต้อง");
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
