<template>
  <div>
    <NavBar></NavBar>
    <v-flex class="mt-2">
      <v-card max-width="300" height="180" class="mx-auto">
        <v-row justify=center>
          <v-flex class="mt-12">
            <div class="text-center">
              <v-btn class="primary" min-width="150" min-height="80" @click="$router.push('/registeractivity')">สมัครกิจกรรมชมรม</v-btn>
            </div>
          </v-flex>
        </v-row>
      </v-card>
    </v-flex>
  </div>
</template>

<script>
import NavBar from "../components/NavBar";
export default {
  name: "Dashboard",
  components: {
    NavBar
  }
};
</script>
