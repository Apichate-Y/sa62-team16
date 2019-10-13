<template>
  <div>
    <v-toolbar flat height="120px" tile color="deep-purple">
      <v-toolbar-title class="text-uppercase white--text display-1 font-weight-medium">
        <span>sut</span>
        <span class="font-weight-light">club</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn text class="white--text" @click="$router.push('/adminlogin')">
        <v-icon left>person</v-icon>Admin
      </v-btn>

      <v-btn text class="white--text" @click="$router.push('/userlogin')">
        <v-icon left>people_alt</v-icon>Member
      </v-btn>
    </v-toolbar>

    <v-carousel height="710" tile cycle hide-delimiter-background show-arrows-on-hover>
      <v-carousel-item v-for="(item,i) in items" :key="i" :src="item.src"></v-carousel-item>
    </v-carousel>
  </div>
</template>

<script>
export default {
  data() {
    return {
      items: [
        {
          src: require("../assets/Slide-1.jpg")
        },
        {
          src: require("../assets/Slide-2.jpg")
        },
        {
          src: require("../assets/Slide-3.jpg")
        }
      ]
    };
  }
};
</script>
