<template>
  <div>
    <v-toolbar height="100px" dark prominent src="../assets/wallpaper-4.jpg">
      <v-toolbar-title class="text-uppercase font-weight-medium">
        <span>sut</span>
        <span class="font-weight-light">club</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn text @click="$router.push('/')">
        <span>sing out</span>
        <v-icon right>mdi-export</v-icon>
      </v-btn>
    </v-toolbar>
  </div>
</template>