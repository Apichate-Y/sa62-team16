<template>
  <nav>
    <v-toolbar flat class="grey lighten-5">
      <v-app-bar-nav-icon class="teal--text" @click=" drawer = !drawer "></v-app-bar-nav-icon>
      <v-toolbar-title class="text-uppercase teal--text display-1 font-weight-medium">
        <span>sut</span>
        <span class="font-weight-light">club</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn text class="teal--text" @click="$router.push('/userlogin')">
        <span>Sign Out</span>
        <v-icon right>exit_to_app</v-icon>
      </v-btn>
    </v-toolbar>

    <v-navigation-drawer v-model="drawer" app class="teal">
      <v-layout align-center column>
        <v-flex class="mt-5">
          <v-avatar size="150">
            <img src="../assets/avatar-2.png" alt />
          </v-avatar>
          <h1 class="title white--text headline ">Computer Club</h1>
        </v-flex>
      </v-layout>

      <v-divider ></v-divider>

      <v-list>
        <v-list-item v-for="item in items" :key="item.title" router :to="item.route">
          <v-list-item-icon>
            <v-icon class="white--text">{{ item.icon }}</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title class="white--text">{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      drawer: true,
      member:"",
      items: [
        { icon: "dashboard", title: "Dashboard", route: "/dashboard" },
        { icon: "table_chart", title: "จัดเวรทำความสะอาด", route: "/cleaning" },
        { icon: "attach_money", title: "รายรับ - รายจ่าย", route: "/income" },
        { icon: "event", title: "สร้างกิจกรรม", route: "/activities" }
      ]
    };
  }
};
</script>
