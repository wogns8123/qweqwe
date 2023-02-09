<template>
  <div id="cover">
    <div class="background">
    </div>
    <div id="LoginDetail">
      <LoginDetail/>
    </div>
  </div>
</template>

<script>
import LoginDetail from '@/components/account/login/LoginDetail.vue'
export default {
  name:'LoginPage',
  components: {
    LoginDetail,
  }
}
</script>

<style>
#cover{
  width: 1255px;
  margin: 0 auto;
  text-align: center;
}
.check {
  /* display: inline-block; */
}

.background {
  float:left; 
  width: 800px;
  height: 608px;
<<<<<<< HEAD
  background-image: url(../../../assets/images/loginImage.png);
=======
  background-image: url(../../../assets/loginImage.png);
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
  background-repeat: no-repeat;
  background-size: 100% 100%;
}

#LoginDetail {
  float:left; 
  width:455px;
  height: 608px;
  background-color: #FCFAEF;
  margin-right: 0px;
  justify-content: center;
}
</style>