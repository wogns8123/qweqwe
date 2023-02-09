import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import vuetify from './plugins/vuetify'
import { loadFonts } from './plugins/webfontloader'
<<<<<<< HEAD
import VueSweetAlert2 from "vue-sweetalert2";
import "sweetalert2/dist/sweetalert2.min.css";
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
// import Datepicker from '@vuepic/vue-datepicker';
// import '@vuepic/vue-datepicker/dist/main.css'
=======
import "sweetalert2/dist/sweetalert2.min.css";
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934

loadFonts()

createApp(App).use(router)
  .use(router)
  .use(store)
  .use(vuetify)
  .use(VueSweetAlert2)
  .mount('#app')

  window.Kakao.init('46ea2a430e00975ef0166ed7e47277e9');