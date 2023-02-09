import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Login from '@/components/account/login/LoginPage.vue'
<<<<<<< HEAD
=======

import FindId from '@/components/account/FindId.vue'
import FindPw from '@/components/account//FindPw.vue'
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
import LoginKakao from '@/components/account/login/LoginKakao.vue'
import FindId from '@/components/account/FindId.vue'
import FindPw from '@/components/account//FindPw.vue'
import SignUpClient from '@/components/account/signup/client/SignUpClient.vue'
import SignUpCounselor from '@/components/account/signup/counselor/SignUpCounselor.vue'
import SignUpCounselor2 from '@/components/account/signup/counselor/SignUpCounselor2.vue'
<<<<<<< HEAD
import CalendarView from '@/components/management/schedule/CalendarView.vue'


// 고민게시판 페이지
import BoardView from '../views/board/BoardView.vue'
// 고민게시판 상세보기
import BoardDetailView from '../views/board/BoardDetailView.vue'
// 고민게시판 작성하기
import BoardCreateView from '../views/board/BoardCreateView.vue'


// 헬프데스크 페이지
import HelpView from '../views/helpdesk/HelpView.vue'
// 공지사항 상세보기
import NoticeDetailView from '../views/helpdesk/NoticeDetailView.vue'
// 공지사항 작성하기
import NoticeCreateView from '../views/helpdesk/NoticeCreateView.vue'
// 문의사항 상세보기
import QnaDetailView from '../views/helpdesk/QnaDetailView.vue'
// 문의사항 작성하기
import QnaCreateView from '../views/helpdesk/QnaCreateView.vue'


import ClientManage from '@/components/management/client/ClientManage.vue'
import VideoPage from '../components/video/VideoPage.vue'
import ConsultantCardItem from '@/components/ConsultantCard/ConsultantCardItem.vue'
import ConsultantCardItemReviewCreate from '@/components/ConsultantCard/ConsultantCardItemReviewCreate.vue'
import ConsultantCardItemReviewItemDetail from '@/components/ConsultantCard/ConsultantCardItemReviewItemDetail.vue'
import ConsultantCardItemReviewUpdate from '@/components/ConsultantCard/ConsultantCardItemReviewUpdate.vue'
import MyPage from '@/views/my/MyPage.vue'
import MyPostView from '@/views/my/mypost/MyPostView.vue'
import LikeView from '@/views/my/like/LikeView.vue'
import CheckEditInformation from '@/views/my/edit/CheckEditInformation.vue'
import EditInformation from '@/views/my/edit/EditInformation.vue'
import MainEdit from '@/views/my/edit/MainEdit.vue'
import ClientManageDetail from '@/components/management/client/ClientManageDetail.vue'
import AlarmView from '../views/alarm/AlarmView.vue'
import AlarmViewDetail from '../views/alarm/AlarmViewDetail.vue'

=======
import CalendarView from '@/components/management/CalendarView.vue'
import KidBoard from '../views/board/kid/KidBoard.vue'
import KidBoardDetail from '../views/board/kid/KidBoardDetail.vue'
import Announce from '../views/helpdesk/announce/Announce.vue'
import Inquiry from '../views/helpdesk/inquiry/Inquiry.vue'
import ClientManage from '@/components/management/ClientManage.vue'
import Notice from '../views/my/notice/Notice.vue'
import HistoryView from '../views/my/history/HistoryView.vue'
import Write from '../views/my/writereview/Write.vue'
import CheckEditInformation from '@/components/account/edit/CheckEditInformation.vue'
import EditInformation from '@/components/account/edit/EditInformation.vue'
import KidBoardCreate from '../views/board/kid/KidBoardCreate.vue'
import AnnounceCreate from '../views/helpdesk/announce/AnnounceCreate.vue'
import InquiryCreate from '../views/helpdesk/inquiry/InquiryCreate.vue'
import SignUpFinish from '../components/account/signup/counselor/SignUpFinish.vue'
import VideoPage from '../components/video/VideoPage.vue'
import ConsultantCardItem from '@/components/ConsultantCardItem.vue'
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path:'/findId',
    name:'findId',
    component: FindId
  },
  {
    path:'/findPw',
    name:'findPw',
    component: FindPw
  },
  {
    path:'/loginKakao',
    name:'loginKakao',
    component: LoginKakao
  },
  {
    path:'/signupclient',
    name:'signupclient',
    component: SignUpClient
  },
  {
    path:'/signupcounselor',
    name:'signupcounselor',
    component: SignUpCounselor
  },
  {
    path:'/signupcounselor2',
    name:'signupcounselor2',
    component: SignUpCounselor2
  },
  {
    path:'/Calendar',
    name:'Calendar',
    component: CalendarView
  },
  
  
  // 고민게시판 페이지
  {
<<<<<<< HEAD
    path: '/BoardView',
    name: 'BoardView',
    component: BoardView
=======
    path: '/KidBoard',
    name: 'child',
    component: KidBoard
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
  },
  // 고민게시판 상세보기
  {
<<<<<<< HEAD
    path: '/BoardDetailView/:postId?',
    name: 'BoardDetailView',
    component: BoardDetailView,
=======
    path: '/KidBoardDetail/:postId?',
    name: 'KidBoardDetail',
    component: KidBoardDetail,
    // props: true
  },
  
  {
    path: '/Announce',
    name: 'Announce',
    component: Announce
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
  },
  // 고민게시판 작성하기
  {
<<<<<<< HEAD
    path: '/BoardCreateView/:postId?',
    name: 'BoardCreateView',
    component: BoardCreateView,
=======
    path: '/Inquiry',
    name: 'Inquiry',
    component: Inquiry
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
  },
  
  
  // 헬프데스크 페이지
  {
<<<<<<< HEAD
    path: '/HelpView',
    name: 'HelpView',
    component: HelpView
  },
  // 공지사항 상세보기
  {
    path: '/NoticeDetailView/:id?',
    name: 'NoticeDetailView',
    component: NoticeDetailView
  },
  // 공지사항 작성하기
  {
    path: '/NoticeCreateView',
    name: 'NoticeCreateView',
    component: NoticeCreateView
  },
  // 문의사항 상세보기 
  {
    path: '/QnaDetailView/:id?',
    name: 'QnaDetailView',
    component: QnaDetailView
  },
  // 문의사항 작성하기  
  {
    path: '/QnaCreateView',
    name: 'QnaCreateView',
    component: QnaCreateView
  },

  
  {
    path: '/ClientManage',
    name: 'ClientManage',
    component: ClientManage
  },
  {
    path: '/CheckEditInformation',
    name: 'CheckEditInformation',
=======
    path: '/Notice',
    name: 'Notice',
    component: Notice
  },
  {
    path: '/HistoryView',
    name: 'HistoryView',
    component: HistoryView
  },

  {
    path: '/Write',
    name: 'Write',
    component: Write
  },
  {
    path: '/Clientmanage',
    name: 'Clientmanage',
    component: ClientManage
  },
  {
    path: '/Checkeditinformation',
    name: 'Checkeditinformation',
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
    component: CheckEditInformation
  },
  {
    path: '/EditInformation',
    name: 'EditInformation',
    component: EditInformation
  },
 
 
  {
<<<<<<< HEAD
    path: '/VideoPage',
    name: 'VideoPage',
    component: VideoPage
=======
    path: '/KidBoardCreate/:postId?',
    name: 'KidBoardCreate',
    component: KidBoardCreate,
  },
  {
    path: '/AnnounceCreate',
    name: 'AnnounceCreate',
    component: AnnounceCreate
  },
  {
    path: '/InquiryCreate',
    name: 'InquiryCreate',
    component: InquiryCreate
  },
  {
    path: '/signupfinish',
    name: 'signupfinish',
    component: SignUpFinish
  },
  {
    path: '/VideoPage',
    name: 'VideoPage',
    component: VideoPage
  },
  {
    path: '/consultantcarditem/:id?',
    name: 'consultantcarditem',
    component: ConsultantCardItem,
    props:true
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
  },
  {
    path: '/consultantcarditem/:id?',
    name: 'consultantcarditem',
    component: ConsultantCardItem,
    props:true
  },
  {
    path: '/consultantcarditemreviewcreate/:id?',
    name: 'consultantcarditemreviewcreate',
    component: ConsultantCardItemReviewCreate,
    props:true
  },
  {
    path: '/ConsultantCardItemReviewItemDetail/:id?',
    name: 'ConsultantCardItemReviewItemDetail',
    component: ConsultantCardItemReviewItemDetail,
    props:true
  },
  {
    path: '/ConsultantCardItemReviewUpdate/:id?',
    name: 'ConsultantCardItemReviewUpdate',
    component: ConsultantCardItemReviewUpdate,
    props:true
  },
  {
    path: '/mypage',
    name: 'mypage',
    component: MyPage,
  },
  {
    path: '/MyPostView',
    name: 'MyPostView',
    component: MyPostView,
  },
  {
    path: '/LikeView',
    name: 'LikeView',
    component: LikeView,
  },
  {
    path: '/MainEdit',
    name: 'MainEdit',
    component: MainEdit
  },
  {
    path: '/ClientManageDetail/:id?',
    name: 'ClientManageDetail',
    component: ClientManageDetail,
    props:true
  },
  {
    path: '/AlarmView',
    name: 'AlarmView',
    component: AlarmView
  },
  {
    path: '/AlarmViewDetail/:id?',
    name: 'AlarmViewDetail',
    component: AlarmViewDetail
  },
  {
    path: '/:pathMatch(.*)*',
    redirect: '/404'
  },

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})


export default router
