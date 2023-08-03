# Green 개인 프로젝트

<br>

관련 ppt입니다.

[강태현개인프로젝트.pptx](https://github.com/moyasiru/Green/files/12246482/default.pptx)


><h1>프로젝트 소개</h1>


<h3>간단한 도서관리 프로그램 사이트입니다.</h3>

배워보지 않았던 언어와 환경에 적응하기 위해 여러가지 플러그인과 언어들을 사용 해보았습니다.

<br>
<br>

><h1>개발환경</h1>
<br>
<h2>IDE & Tools</h2>

<div style="background-color👨‍👩‍👧">
  
![image](https://github.com/moyasiru/projectLookLike/assets/130022940/1050d6ee-18ca-49ee-8c1c-648f4df81cb0)
![image](https://github.com/moyasiru/projectLookLike/assets/130022940/eda00831-85df-4eac-b830-772ac7ca425e)
![image](https://github.com/moyasiru/Green/assets/130022940/54dce491-219e-4dd1-b185-443ac07e40b9)



</div>
<h2>Languages</h2>

<h3>Programming Language</h3>

![image](https://github.com/moyasiru/projectLookLike/assets/130022940/eb753610-73c3-4905-ae9d-392ff62edac8)
![image](https://github.com/moyasiru/projectLookLike/assets/130022940/8b626ad9-484c-442c-aa5d-e4644c1ceaed)


<h3>Markup Language</h3>

![image](https://github.com/moyasiru/projectLookLike/assets/130022940/4111e13d-bc84-4b01-b444-077621802d38)

<h3>Stylesheet Language</h3>

![image](https://github.com/moyasiru/projectLookLike/assets/130022940/3ac5fb84-5c51-4992-bf07-42fb4f78ea71)


<h2>Framework & Libraries</h2>

![image](https://github.com/moyasiru/projectLookLike/assets/130022940/90cadd77-2aec-48c3-b72e-2d354cfbf1a4)
![image](https://github.com/moyasiru/projectLookLike/assets/130022940/48e9981b-9a49-4da2-ae94-68037fbe0636)
![image](https://github.com/moyasiru/Green/assets/130022940/a7d376b5-ce51-4150-8e61-41700f424dc3)
![image](https://github.com/moyasiru/projectLookLike/assets/130022940/4c8d4b3d-c700-4549-9f37-1ec1eec74ae6)


<h2>Database Management System</h2>

![image](https://github.com/moyasiru/projectLookLike/assets/130022940/3edff365-d266-47c9-8ac3-baf030a886b2)

<h2>Event Streaming Platform</h2>

Messaging System

![image](https://github.com/moyasiru/Green/assets/130022940/559d0148-1f98-49c9-888b-e0647005d2a8)


<h2>Web Development Technologies</h2>

![image](https://github.com/moyasiru/projectLookLike/assets/130022940/37c15f37-442b-4c35-b09d-c624486369e0)

<br>

><h1>페이지 구현</h1>

<h2>로그인페이지</h2>

<img src=https://github.com/moyasiru/Green/assets/130022940/d8c52904-c6ef-4988-94e2-491c8011c9df width="80%">

* 로그인 화면
   - 간단한 로그인,회원가입폼 으로 구성했습니다.

<h2>메인페이지</h2>

<img src=https://github.com/moyasiru/Green/assets/130022940/03cf33c5-9789-4ca0-8bc1-d8a2be518dbb width="80%">

* 메인 화면
   - amchart와 db연동하여 차트구현
   - Slick 플러그인 이용하여 사진 슬라이더 구현
   - Jsoub 이용하여 웹페이지 크롤링
   - 동적쿼리 사용하여 카테고리별 검색기능 구현


<br>


<img src=https://github.com/moyasiru/Green/assets/130022940/fa520dd3-893f-47e8-8b01-7f9cbe82a23d width="35%" height="100px">
<img src=https://github.com/moyasiru/Green/assets/130022940/9d247400-04c6-49e3-9e89-a6009dcb7659 width="30%">
<img src=https://github.com/moyasiru/Green/assets/130022940/99e81d0f-7c59-4d74-8241-fa7216858aa8 width="30%">

* Amchart db연동 코드
   - Oracle에서 Group함수를 이용해 해당하는 카테고리번호와 총 개수를 조회
   - 조회한 값들을 불러온후 변수화
   - 변수화 시킨 값들을 chart와 연동


<br>

<img src=https://github.com/moyasiru/Green/assets/130022940/5f55cd42-e895-4f1d-a2b0-e20fa9826b43 width="45%">
<img src=https://github.com/moyasiru/Green/assets/130022940/f00d5bbb-adab-405d-9e33-9a669c9a1c7c width="50%">


* Jsoub을 이용한 코드
   - 불러오고자 하는 사이트에 특정 HTML 접근자 요소를 선택
   - 선택한 요소들을 반복문을 돌려 DTO에 저장시켜 값들을 불러올수 있게 구현


<br>

<img src=https://github.com/moyasiru/Green/assets/130022940/c880f72f-53d7-4b4b-aa09-617a9b8e017e width="45%">
<img src=https://github.com/moyasiru/Green/assets/130022940/13135b0a-2caf-4bce-b863-18bc0bf58cd5 width="50%">

* Zookeeper,Kafka 실행 모습
   - WebSocket만을 이용했을 때의 문제점은 Seesion 단위의 메시지만 전달이 가능했기 떄문에 채팅방을 여러개 만들지 못한다는 단점이 존재했습니다. 이런 측면을 보안하기 위해 Kafka 를 사용하였습니다.


<br>

<h2>Kafka를 활용하여 채팅을 하는 모습</h2>

<img src=https://github.com/moyasiru/Green/assets/130022940/3656b8f8-9094-4b01-b313-1c8f86383c47 width="45%">
<img src=https://github.com/moyasiru/Green/assets/130022940/5679629b-cc43-463a-9823-18136ae1b81c width="50%">


<br><br>


<h2>도서 카테고리별 분류 페이지</h2>

<img src=https://github.com/moyasiru/Green/assets/130022940/8e21ca8d-30db-41ac-8985-262e7b445a2e width="45%">
<img src=https://github.com/moyasiru/Green/assets/130022940/5186b37c-8f9b-45ec-aaf6-4b83f28629c6 width="50%">

   - 카테고리별 동적쿼리를 이용하여 도서List 분류
   - 도서 등록일 기준으로 sysdate -5 인 경우 신간도서로 분류되게끔 구현


<br><br>


<h2>게시판 페이지</h2>

![image](https://github.com/moyasiru/Green/assets/130022940/37996fcf-ebc0-46c8-ac96-778482b97883)

* Ckeditor 텍스트 에디터 적용
    - 텍스트 크기,문단 나눔, 사진 업로드등의 기능 편리하게 이용 가능
 

<br><br>



![image](https://github.com/moyasiru/Green/assets/130022940/6f6d41e0-b83f-4245-a163-109e4f03fa5b)

- 작성한글 조회,수정,삭제 가능



<br><br>


<h2>도서 상세 페이지</h2>

<img src=https://github.com/moyasiru/Green/assets/130022940/8b61b6e8-8a98-4727-bc93-808b257159f0 width="60%">
<img src=https://github.com/moyasiru/Green/assets/130022940/9fcac7c4-3b43-49e3-a09b-a63c48a02b16 width="30%">


<br><br>


<img src=https://github.com/moyasiru/Green/assets/130022940/4af340b7-682b-4f7d-b5eb-b3c79f2be6ad width="40%">
<img src=https://github.com/moyasiru/Green/assets/130022940/fe4e2056-37c0-4fd7-adb9-dd9fd8b3a13c width="40%">


<br>

* Ajax를 이용해 대출신청 클릭시 db업로드된 후 버튼 대여가능여부 데이터 바뀌도록 처리
* 3개 이상 대출 안되게끔 분기처리
 


<br><br>


<h2>마이 페이지</h2> 

<img src=https://github.com/moyasiru/Green/assets/130022940/7a1a7514-1a13-4a1a-8c23-53b72477ad9f width="40%">
<img src=https://github.com/moyasiru/Green/assets/130022940/3a722550-be0e-4550-84ef-4847bbc57eb0 width="50%">


<br>

* 회원정보 수정,탈퇴 기능
* 대여도서권수 클릭시 본인이 대여한 정보 조회 가능
* 재클릭시 사라지게 구현


 

<br><br>


<h2>관리자 페이지</h2> 

![image](https://github.com/moyasiru/Green/assets/130022940/119d78b2-22cc-4d86-ba73-dafb37cc699f)


<br>

* 관리자 세션일시 해당 관리 페이지로 이동 가능
