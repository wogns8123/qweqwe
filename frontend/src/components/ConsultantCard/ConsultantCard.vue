<template>

  <div class="col-md-4 col-sm-6 col-xs-6 col-xxs-12 work-item">
    {{ counselor }}
    <v-card>
    <v-row>
      <v-col>
        <v-card
        color="white"
        theme="dark"
        >
        <v-avatar
          class="ma-3"
          size="125"
          rounded="0"
        >
          <v-img src="https://cdn.vuetifyjs.com/images/cards/halcyon.png"></v-img>
        </v-avatar>
        <div class="d-flex flex-no-wrap justify-space-between">
          <div>
            <v-card-title class="text-h5">
              {{ counselor.name}}
            </v-card-title>
            
            <v-card-subtitle>
              {{ counselor.introduce }}
              <br>
              {{ counselor.consultTypeList}}
            </v-card-subtitle>
          </div>

          <v-card-actions>
            <v-btn
              outlined
              rounded
              text
              @click="moveTo(counselor.id)"
            >
              Button
            </v-btn>
          </v-card-actions>
        </div>
      </v-card>
    </v-col>
  </v-row>
</v-card>
</div>
</template>

<script>

// import {useRouter} from 'vue-router';

export default {
  name: 'ConsultantCard',
  props: {
    counselor: Object,
  },
  methods:{
    moveTo(){
      this.$router.push({ name: 'consultantcarditem', params: {id: this.counselor.id} })
    },

  },  
}
</script>

<style>
.work-item{
  padding:30px;
}
</style>
