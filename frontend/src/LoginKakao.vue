  <template>
    <div v-on:click="kakaoLoginBtn">카카오 연동</div>

  </template>
  
  <script>
<<<<<<< HEAD
   VUE_APP_API_URL = process.env.VUE_APP_API_URL
=======
  const API_URL = 'http://127.0.0.1:8080'
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
  
  export default {
    name: "LoginKakao",
    methods: {
      kakaoLoginBtn:function(){
        window.Kakao.init('46ea2a430e00975ef0166ed7e47277e9') // Kakao Developers에서 요약 정보 -> JavaScript 키
  
        if (window.Kakao.Auth.getAccessToken()) {
          window.Kakao.API.request({
<<<<<<< HEAD
            url: `${VUE_APP_API_URL}/api/auth/kakao`,
=======
            url: `${API_URL}/api/auth/kakao`,
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
            success: function (response) {
              console.log(response)
            },
            fail: function (error) {
              console.log(error)
            },
          })
          window.Kakao.Auth.setAccessToken(undefined)
        }
  
  
        window.Kakao.Auth.login({
          success: function () {
            window.Kakao.API.request({
<<<<<<< HEAD
              url: `${VUE_APP_API_URL}/api/auth/kakao`,
=======
              url: `${API_URL}/api/auth/kakao`,
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
              data: {
                property_keys: ["kakao_account.email"]
              },
              success: async function (response) {
                console.log(response);
              },
              fail: function (error) {
                console.log(error)
              },
            })
          },
          fail: function (error) {
            console.log(error)
          },
        })
      }
    }
  }
  </script>
  
  <style scoped>

    div{ width: 200px; height:40px; background-color:#fdd101; color:white; display:flex; align-items: center; justify-content: center; cursor:pointer; }
  </style>