<template>
  <div id="fh5co-main">
    <div class="fh5co-narrow-content">
      <div class="five">
        <h2 class="fh5co-heading animate-box" data-animate-effect="fadeInLeft">
          <em>
            소중한 당신을 위해
          </em>
          <span>여기, 소담이 함께합니다.</span> 
        </h2>

      </div>
      <br>
      <br>
      <ConsultantCardSearch/>
    </div>
    <ConsultantList/>
  </div>

</template>

<script>
// @ is an alias to /srcz

import ConsultantList from '@/components/ConsultantCard/ConsultantList.vue'
import ConsultantCardSearch from '@/components/ConsultantCard/ConsultantCardSearch.vue'

export default {
  name: 'HomeView',
  components: {
    ConsultantList,
    ConsultantCardSearch
  },

}
</script>
<style>
<<<<<<< HEAD
.five h2 {
  text-align: center;
  font-size: 22px;
  font-weight: 700; color:#202020;
  text-transform: uppercase;
  word-spacing: 1px; letter-spacing:2px;
}
.five h2 span {
  margin-top: 40px;
  text-transform: none;
  font-size:.75em;
  font-weight: normal;
  font-style: italic; font-family: "Playfair Display","Bookman",serif;
  color:#999; letter-spacing:-0.005em; word-spacing:1px;
  letter-spacing:none;
}
.five h2:before {
  position: absolute;
  left: 0;
  bottom: 38px;
  width: 60px;
  height: 4px;
  content: "";
  left: 50%;
  margin-left: -30px;
  background-color: #dfdfdf;
=======
#homeview {
  /* 반응형 x */
  width: 1255px;
  margin: 0 auto;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
}

.fh5co-heading animate-box{
  font-family: "Roboto", Arial, sans-serif;
  font-weight: 300;
  font-size: 45px;
  line-height: 1.6;
  color: rgba(0, 0, 0, 0.5);
}
#fh5co-main {
  width: 85%;
  float: right;
  -webkit-transition: 0.5s;
  -o-transition: 0.5s;
  transition: 0.5s;
}
@media screen and (max-width: 1200px) {
  #fh5co-main {
    width: 70%;
  }
}
@media screen and (max-width: 768px) {
  #fh5co-main {
    width: 100%;
  }
}
#fh5co-main .fh5co-narrow-content {
  position: relative;
  width: 80%;
  margin: 0 auto;
  padding: 4em 0;
}
@media screen and (max-width: 768px) {
  #fh5co-main .fh5co-narrow-content {
    width: 100%;
    padding: 3.5em 1em;
  }
}


.work-item {
  margin-bottom: 30px;
}
.work-item a {
  border: none;
  text-align: center;
}
.work-item a img {
  margin-bottom: 10px;
  float: left;
  border: 10px solid transparent;
  -webkit-transition: 0.5s;
  -o-transition: 0.5s;
  transition: 0.5s;
}
.work-item a h3 {
  font-size: 20px;
  color: #000;
  margin-bottom: 10px;
}
.work-item a p {
  font-size: 14px;
  color: #cccccc;
  margin-bottom: 0;
}
.work-item a:hover, .work-item a:active, .work-item a:focus {
  text-decoration: none;
}
.work-item a:hover img, .work-item a:active img, .work-item a:focus img {
  border: 1 px solid #000;
}
h1, h2, h3, h4, h5, h6 {
  color: #000;
  font-family: "Montserrat";
  font-weight: 700;
  margin: 0 0 30px 0;
}
</style>