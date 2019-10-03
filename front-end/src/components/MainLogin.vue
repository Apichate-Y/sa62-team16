<template>

    <v-flex style="margin-top:15%">
      <v-card max-width="500" height="auto" class="mx-auto elevation-10" color="grey lighten-5">
        <v-row justify="center" >
          <v-col class="text-center" cols="12">
            <div class="my-12">
              <v-btn color="primary" @click="$router.push('/adminlogin')">เข้าสู่ระบบในฐานะผู้ดูแลระบบ</v-btn>
            </div>
            <div class="my-12">
              <v-btn color="primary" @click="$router.push('/userlogin')">เข้าสู่ระบบในฐานะสมาชิก</v-btn>
            </div>
          </v-col>
        </v-row>
      </v-card>
    </v-flex>
</template>