<template>
  <div id="NoticeCreate">
    <div id="NoticeCreateBoard">
      <div id="NoticeCreateBoardtitle">
        <h1>HELP DESK</h1>
      </div>

    </div>
    <div>
      <div id="HelpWritebox">
        <form @submit.prevent="NoticecreateArticle">
        <!-- <form> -->
          <div style="text-align:start; padding: 10px; border-top: 1px solid #B9B6B6;">
            <label for="title">제목</label>
            <input type="text" id="title" v-model.trim="title">
          </div>
          <div style="text-align:start; padding: 10px; border-top: 1px solid #B9B6B6;">
            <label for="content">내용</label>
            <textarea id="content" v-model="content"></textarea>
          </div>
          <!-- <div style="text-align:start; padding: 10px; border-top: 1px solid #B9B6B6; border-bottom: 1px solid black;">
            <label for="image" style="float:left">사진 첨부</label>
            <div id="image">
              <v-file-input 
                class="input" 
                type="file"
                outlined dense multiple prepend-icon="mdi-camera"

                @change="onImageChange"
                label="File input"
              ></v-file-input>

              이미지 미리보기
              <v-img 
                v-for="(item,i) in uploadimageurl" 
                :key="i" 
                :src="item.url"
                contain height="150px" width="200px" style="border: 2px solid black; 
                margin-left:100px;"/>
            </div>
          </div> -->
          <input type="submit" id="submitno" value="취소">
          <input type="submit" id="submityes" value="등록">
          <!-- <button @click="KidBoardarticleUpdate">등록</button> -->

        </form>
        <button @click="NoticearticleUpdate">수정</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
const VUE_APP_API_URL = process.env.VUE_APP_API_URL


export default {
  name: 'NoticeCreateView',

  data() {
    return {
      uploadimageurl: [],    // 업로드한 이미지의 미리보기 기능을 위해 url 저장하는 객체
      imagecnt: 0,           // 업로드한 이미지 개수 => 제출버튼 클릭시 back서버와 axios 통신하게 되는데, 이 때 이 값도 넘겨줌
      id: this.$route.params.id,
      category : null,
      title: null,
      content: null,
      userType: "003",
      writer: this.$store.state.payload.id,
      
    }
  },

  created() {
    this.NoticeArticleContent()
  },

  methods: {
    NoticeArticleContent() {
      const id  = this.id 
      axios({
        method: 'get',
        url: `${VUE_APP_API_URL}/api/notice/${this.$route.params.id}`,
        headers: {
          Authorization : `Bearer ${this.$store.state.token.token.access_token}`
        }
        // url: `${VUE_APP_API_URL}/trouble/${postId}`
      })
        .then((res) => {
          // console.log(res)
          console.log('됐음 멍')
          this.title = res.data.title
          this.content = res.data.content
        })
        .catch(() => {
          console.log('안됐음 멍')
        })
    },




    NoticecreateArticle() {
      const title = this.title
      const content = this.content
      const userType = this.userType
      const writer = this.writer

      if (!title) {
        alert('제목을 입력해주세요')
        return
      } else if (!content) {
        alert('내용을 입력해주세요')
        return
      }

        axios({
          method: 'post',
          url: `${VUE_APP_API_URL}/api/admin/notice/writing`,
          data: {
            title: title,
            content: content,
            // userType: userType,
            // writer: writer,
            // imagecnt: this.imagecnt
          },
          headers: {
            Authorization : `Bearer ${this.$store.state.token.token.access_token}`
          }
        })
        .then((res) => {
          console.log(res)
          console.log('여긴 안에러')
          this.$router.push({ name: 'HelpView' })
        })
          .catch((err) => {
            console.log('여긴 에러')
            console.log(err)
          })
    },


    //이미지 변경
    // onImageChange(file) {    // v-file-input 변경시
    //       if (!file) {
    //         return;
    //       }
    //       const formData = new FormData();    // 파일을 전송할때는 FormData 형식으로 전송
    //       this.uploadimageurl = [];        // uploadimageurl은 미리보기용으로 사용
    //       file.forEach((item) => {
    //         formData.append('filelist', item)    // formData의 key: 'filelist', value: 이미지
    //         const reader = new FileReader();
    //         reader.onload = (e) => {
    //           this.uploadimageurl.push({url: e.target.result});
    //           // e.target.result를 통해 이미지 url을 가져와서 uploadimageurl에 저장
    //         };
    //         reader.readAsDataURL(item);
    //       });
    //       axios({
    //         url: "http://127.0.0.1:52273/content/imagesave/",    // 이미지 저장을 위해 back서버와 통신
    //         method: "POST",
    //         headers: {'Content-Type': 'multipart/form-data'},    // 이걸 써줘야 formdata 형식 전송가능
    //         data: formData,
    //       }).then(res => {
    //         console.log(res.data.message);
    //         this.imagecnt = file.length;    // 이미지 개수 저장
    //       }).catch(err => {
    //         alert(err);
    //       });
    //     },



    NoticearticleUpdate() {
      const title = this.title
      const content = this.content

      axios({
        method: 'put',
        url: `${VUE_APP_API_URL}/api/admin/notice/${this.$route.params.id}`,
        data: {
          title: title,
          content: content,
        },
        headers: {
          Authorization : `Bearer ${this.$store.state.token.token.access_token}`
        }
      })
      .then(() => {
        console.log('됨')
        this.$router.push({ 
          name: 'NoticeDetailView', 
          params: { id: this.$route.params.id } })


          
        // this.updateStatus = false
      })
      .catch((err) => {
        console.log('안됨')
        console.log(err)
      })
    }
  }
}
</script>



<style>
#NoticeCreate {
  width: 1255px;
  margin: 0 auto;
}

a {
  text-decoration: none;
  color: white;
}

#NoticeCreateBoard {
  background-image: linear-gradient( rgba(255, 255, 255, 0.5), rgba(255, 255, 255, 0.5) ), url('@/assets/images/hand.png');
  background-color: aliceblue;
  background-repeat: no-repeat;
  background-size: 100% 100%;
  text-align: center;
  font-size: large;
  font-weight: 100;
  padding-top: 20px;
  height: 250px;
  position: relative;
}
#NoticeCreateWrite {
  width:100%; 
  height:60px; 
  line-height: 65px;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr;
  background-color:rgba(96, 96, 96, 0.5);
  padding-left: 60px;
  padding-right:60px;
  position: absolute;
  bottom: 0px;
} 
#NoticeCreateBoardtitle {
  position: absolute;
  left: 50%; 
  bottom: 50%; 
  transform: translate(-50%);
}

#Writebox {
  border-top: 1px solid black;
  /* border-bottom: 1px solid black; */
  margin: 60px;
}


#title {
width: 980px; 
height: 50px;
padding: .8em .5em; 
border: 1px solid #B9B6B6;
font-family: inherit;  
/* background: url('arrow.jpg') no-repeat 95% 50%;  */
border-radius: 0px; 
-webkit-appearance: none; 
-moz-appearance: none;
appearance: none;
margin-left: 100px;
}

#content {
width: 980px; 
height: 500px;
padding: .8em .5em; 
border: 1px solid #B9B6B6;
font-family: inherit;  
/* background: url('arrow.jpg') no-repeat 95% 50%;  */
border-radius: 0px; 
-webkit-appearance: none; 
-moz-appearance: none;
appearance: none;
margin-left: 100px;
}

#image {
width: 990px; 
height: 68px;
padding: .4em .5em; 
/* border: 1px solid #B9B6B6; */
font-family: inherit;  
/* background: url('arrow.jpg') no-repeat 95% 50%;  */
border-radius: 0px; 
-webkit-appearance: none; 
-moz-appearance: none;
appearance: none;
margin-left: 130px;
}
/* worryselect::-ms-expand {
        display: none;
} */

#submitno {
margin-top: 50px;
}

#submityes {
margin-top: 50px;
}
</style>