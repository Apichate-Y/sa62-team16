<template>
  
  <v-card>
    <v-carousel cycle height="690" hide-delimiter-background show-arrows-on-hover>

      <v-carousel-item v-for="(item,i) in itemss" :key="i" :src="item.src">
                <div class="display-1"> </div>      
      </v-carousel-item>


    </v-carousel>

    <v-card-actions class="justify-center">
      <v-btn text color="primary" @click="$router.push('/adminlogin')">Admin</v-btn>
      <v-btn rounded color="primary" dark large @click="$router.push('/userlogin')">Member</v-btn>
    </v-card-actions> 
  </v-card>
</template>

<script>

  export default {
    data () {
      return {
        itemss: [
          {
            src: 'https://cdn.vuetifyjs.com/images/carousel/squirrel.jpg',
          },
           {
            src: 'https://cdn.vuetifyjs.com/images/carousel/bird.jpg',
          },
         {
            src: 'https://cdn.vuetifyjs.com/images/carousel/planet.jpg',
          },
        ],
      }
    },
  }

</script>
