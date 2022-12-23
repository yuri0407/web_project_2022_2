## 1. 프로젝트 개요

<br>

#### 프로젝트 주제
> 도서 리뷰 사이트

#### 주제 선정 이유
> 저번 학기 프로젝트로 도서 리뷰 사이트를 MVC 패턴으로 제작하였는데 완성도가 조금 아쉬워서 이번 기말 프로젝트에서 스프링으로 제작하여 완성도를 조금 높이는 것을 목표로 해보고 싶어서 선정하였습니다.

<br><br><br>

## 2. 사이트 구현
### 2.1 데이터베이스 구성
|테이블명|속성명|데이터타입|설명|
|---|---|---|---|
br_book|bNo|INT|도서번호
||bName|VARCHAR|도서명
||writer|VARCHAR|저자
||publisher|VARCHAR|출판사
||pDate|VARCHAR|출판일
||category|VARCHAR|분류번호
||bContent|VARCHAR|도서소개
||bImage|VARCHAR|도서이미지

<br><br>

|테이블명|속성명|데이터타입|설명|
|---|---|---|---|
br_member|id|VARCHAR|회원 아이디
||pwd|VARCHAR|회원 비밀번호
||email|VARCHAR|회원 이메일

<br><br>

|테이블명|속성명|데이터타입|설명|
|---|---|---|---|
br_review|rNum|INT|리뷰 번호
||nickName|VARCHAR|닉네임
||bname|VARCHAR|도서명
||content|VARCHAR|리뷰 내용

<br><br>

|테이블명|속성명|데이터타입|설명|
|---|---|---|---|
br_question|qNo|INT|질문 번호
||qTitle|VARCHAR|질문 제목
||qContent|VARCHAR|질문 내용
||qDate|DATE|질문 작성일
||mAnswer|VARCHAR|관리자 답변

<br><br>

|테이블명|속성명|데이터타입|설명|
|---|---|---|---|
br_request|rNo|INT|요청 번호
||rName|VARCHAR|닉네임
||rContent|VARCHAR|요청 내용
||rDate|DATE|요청 작성일

<br><br><br>

### 2.3 화면 및 기능 구현
#### 메인화면 (br_main)

![메인화면](https://user-images.githubusercontent.com/94339489/209078083-b3c778a9-8902-4d48-bc8b-4d99bac7499d.jpg)

* 사이트를 처음 들어왔을 때 나오는 메인화면이다.
* 여러 메뉴로 이동할 수 있고, 도서 몇 가지를 미리 확인해볼 수 있다.

<br><br>

#### 로그인 화면 (br_login)

![로그인](https://user-images.githubusercontent.com/94339489/209078142-6816986d-b45a-40c6-ba30-4d4c52c24a57.jpg)

* 메인화면에서 로그인을 눌렀을 때 나오는 화면이다.
* 등록되어있는 정보를 입력하면 로그인이 되어 메인화면으로 이동하고, 그렇지 않으면 잘못 입력되었다는 메시지가 출력된다.

<br><br>

#### 회원가입 화면 (br_signUp)

![회원가입](https://user-images.githubusercontent.com/94339489/209078191-c0e38dab-196d-40f2-bbe3-7ded6b376a19.jpg)

* 메인화면이나 로그인 화면에서 '회원가입'을 클릭하면 나오는 화면이다.
* 아이디 중복체크를 하고 난 다음 정보를 모두 입력하여 회원가입 버튼을 누르면 가입이 완료되었다는 메시지가 출력된다.
* 입력을 하지 않은 부분이 있을 경우 모든 정보를 입력해야 한다는 메시지가 출력된다.

<br><br>

#### 도서목록 화면 (br_bookList)

![도서목록](https://user-images.githubusercontent.com/94339489/209078236-96ddd8a5-7dd7-4395-aa6c-6188d4992cdf.jpg)

* 도서목록 메뉴를 클릭하면 나오는 화면이다.
* 등록되어있는 도서들을 확인할 수 있다.
* 상세히 보고 싶은 도서를 클릭하면 상세화면으로 넘어간다.

<br><br>

#### 도서소개 화면 (br_bookExplanation)

![도서소개](https://user-images.githubusercontent.com/94339489/209078265-44f21c3c-8743-4fb3-8665-09ac411536cc.jpg)

* 도서목록 화면에서 자세히 보고 싶은 도서를 클릭했을 때 나오는 도서소개 화면이다.
* 클릭한 도서의 자세한 정보를 확인할 수 있다.

<br><br>

#### 도서리뷰 화면 (br_reviewList)

![도서리뷰](https://user-images.githubusercontent.com/94339489/209078291-589104f0-a4b3-41b6-bff0-3e326b19fd1b.jpg)

* 도서리뷰 메뉴를 클릭하면 나오는 화면이다.
* 사용자들이 작성한 리뷰들을 목록으로 확인할 수 있다.
* 자세히 보고 싶은 리뷰를 클릭하면 상세화면으로 넘어간다.

<br><br>

#### 리뷰 상세 화면 (br_reviewDetail)

![리뷰 상세](https://user-images.githubusercontent.com/94339489/209078325-a6a22bcb-f3c6-42a0-b27f-d4739f06394e.jpg)

* 리뷰목록 화면에서 자세히 보고 싶은 리뷰를 클릭했을 때 나오는 화면이다.
* 사용자가 작성한 리뷰를 상세히 볼 수 있다.
* '목록으로' 버튼을 누르면 리뷰목록으로 돌아간다.

<br><br>

#### 리뷰작성 화면 (br_writeReview)

![리뷰 작성](https://user-images.githubusercontent.com/94339489/209078348-02c7a02f-86ac-4f5a-b100-66b5e8661071.jpg)

* 리뷰목록 화면에서 리뷰등록 버튼을 클릭하면 나오는 화면으로, 로그인한 회원만 들어갈 수 있다.
* 리뷰내용을 작성한 후 등록하기 버튼을 누르면 리뷰가 등록된다.
* 입력하지 않은 부분이 있을 경우 모든 정보를 입력해야 한다는 메시지가 출력된다.

<br><br>

#### 질문목록 화면 (br_questionList)

![질문목록](https://user-images.githubusercontent.com/94339489/209078414-b652667f-4442-489d-866c-2dbb349f5d93.jpg)

* Q&A 메뉴를 클릭하면 나오는 질문목록 화면이다.
* 사용자들이 작성한 질문들이 목록으로 나온다.
* 자세히 보고 싶은 질문을 클릭하면 질문상세 화면으로 넘어간다.

<br><br>

#### 질문 상세 화면 (br_questionDetail)

![질문상세](https://user-images.githubusercontent.com/94339489/209078455-ca2e8994-13ba-452c-8a16-511672ed0853.jpg)

* 질문목록 화면에서 자세히 보고 싶은 질문을 클릭하면 나오는 화면이다.
* 클릭한 질문을 상세히 확인할 수 있다.
* '목록으로' 버튼을 클릭하면 질문목록으로 돌아간다.

<br><br>

#### 질문작성 화면 (br_writeQuestion)

![질문작성](https://user-images.githubusercontent.com/94339489/209078467-4d198e7b-b15b-4677-9353-a91312afec07.jpg)

* 질문목록 화면에서 질문하기 버튼을 클릭하면 나오는 화면으로, 로그인한 회원만 들어갈 수 있다.
* 질문 제목과 내용을 입력하고 등록하기 버튼을 클릭하면 질문이 등록된다.
* 입력하지 않은 부분이 있을 경우 모든 정보를 입력해야 한다는 메시지가 출력된다.

<br><br>

#### 도서추가요청 화면 (br_requestList)

![요청목록](https://user-images.githubusercontent.com/94339489/209078501-e78ca696-056c-4046-841b-60ae3bf3d046.jpg)

* 도서추가요청 메뉴를 클릭하면 나오는 화면이다.
* 사용자들이 등록한 추가요청들이 목록으로 나타난다.
* 자세히 보고 싶은 요청을 클릭하면 상세화면으로 넘어간다.

<br><br>

#### 요청 상세 화면 (br_requestDetail)

![요청상세](https://user-images.githubusercontent.com/94339489/209078516-86789672-1980-404f-9d3d-2300f3955539.jpg)

* 자세히 보고 싶은 요청을 클릭하면 나오는 화면이다.
* 클릭한 요청을 상세히 확인할 수 있다.
* '목록으로' 버튼을 클릭하면 요청목록 화면으로 돌아간다.

<br><br>

#### 요청 작성 화면 (br_writeRequest)

![요청작성](https://user-images.githubusercontent.com/94339489/209078527-121758ae-6166-4ebc-8544-e6b822d07475.jpg)

* 추가요청 목록 화면에서 요청하기 버튼을 클릭하면 나오는 화면으로, 로그인한 회원만 들어갈 수 있다.
* 닉네임과 내용을 입력하고 등록하기 버튼을 클릭하면 요청이 등록된다.
* 입력하지 않은 부분이 있는 경우 모든 정보를 입력해야 한다는 메시지가 출력된다.

<br><br>

#### 회원 탈퇴 화면 (br_memWithdrawal)

![회원탈퇴](https://user-images.githubusercontent.com/94339489/209078577-1fbb506b-842d-4b5c-9459-f990cdb3cbf0.jpg)

* 회원 탈퇴 메뉴를 클릭하면 나오는 화면으로, 로그인한 회원만 들어갈 수 있다.
* 주의사항을 확인한 후 탈퇴하기 버튼을 클릭하면 탈퇴가 완료되었다는 메시지와 함께 로그인되어 있던 회원의 정보가 삭제된다.

<br><br><br>

## 3. 소감

<br>

> 처음 이 프로젝트를 시작할 때 스프링 MVC 구조를 다 배우자마자 시작한 거라 이 프로젝트를 제시간에 완성할 수 있을까 걱정이 많았는데 이렇게 마무리 짓고 소감을 적고 있다는 게 신기하다. 시간 내에 최소한의 내용을 구현하는 데에 성공하긴 했지만 아직 부족한 점이 있는 게 눈에 보여서 조금 아쉽다. 이후에 천천히 이 프로젝트를 조금 더 완성도 높게 이어서 구현해보고 싶다.

<br><br><br>

## 4. 참고서적 및 참고 사이트

<br>

[페이지네이션 코드]   
https://github.com/aicsdit/board-spring-pagination

<br>

[도서 데이터]   
https://www.kyobobook.co.kr/
