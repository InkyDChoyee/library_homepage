# 📋 선유책숲 프로젝트

* Html, CSS, JavaScript 를 활용한 동적 화면 구현
* Security 를 활용한 관리자와 일반회원의 기능 분리
* Springboot 프레임워크와 thymeleaf 템플릿 엔진을 활용한 MVC 구현
* Ajax 를 활용하여 도서 기능, 열람실 기능, 댓글 기능 구현
* 프론트와 백 구분 없이 모든 분야의 기술 활용과 응용 경험
* Figma, DB, 깃허브 등 공동 개발 환경 구성


---

### 📅 개발 기간
* 2024년 01월 29일 ~ 2024년 02월 20일 (약 3주)
* 주제 선정과 페이지 구성 디자인 관련 회의
* 조원 별 파트 나누기
* 피그마, erd, 마크업 템플릿 작성
* css와 js 효과 구현
* DB에 자료 삽입, 프로그램 구동 확인
* 통합과 디버그, 수정 등

---

### 🛠️ 개발 환경
* 운영체제 : window OS
* 사용 언어
    * HTML, CSS, JavaScript, Ajax
    * Java, thymeleaf
* DB : MySQL, AWS RDS
* Tool : Spring Tool Suite4 , VSCode
* WAS : Apache Tomcat 9.0
* Collaboration : Github, figma

---

### ✔️ 주요 기능
* 메인화면 설계 및 기능
  * JavaSript를 이용하여 메인 사진 바꾸기 효과 구현
  * 메인 사진 왼쪽 아래에 타이머를 css로 애니메이션 효과 구현
  * 스크롤에 따라 모든 요소가 동적으로 나타나고 사라지는 효과 구현
  * 메인 사진 내 검색창은 네이버 검색으로 연계되도록 구현
* 회원가입 및 로그인 기능
  * Spring security를 이용하여 로그인, 로그아웃 기능 구현
  * 관리자와 일반회원 기능 분리
  * 회원정보 수정/탈퇴 기능 구현
  * 아이디 찾기/비밀번호 찾기 기능 구현
  * 회원가입시 유효성 기능 구현
* 게시판 기능
  * 게시판 글쓰기, 목록보기, 상세보기, 수정, 삭제 기능 구현
  * 게시판 카테고리별 검색 기능 구현
  * 게시판 페이징 기능 구현
* 도서 대출, 반납 기능
  * 도서 등록, 수정, 삭제 기능 구현(관리자만 해당)
  * 도서 목록보기, 상세보기 기능 구현(모든 회원 가능)
  * 회원 도서 대여 시 반납 마감일 설정
  * 마감일 도래 시 연체로 상태 변경, 대출 불가능 변경 기능 구현
  * 외원 계정당 최대 5권 대출 가능, 6권부터 대출 불가능 상태로 변경 기능 구현
* 열람실 기능
  * 열람실 자리 사용 시 사용 마감시간 설정
  * 한 사람당 한 자리씩만 사용 가능하게 설정
  * 본인 자리만 반납 가능하게 기능 구현

---

### 👬프로젝트 참여자
* 지성 : 팀장, 백엔드 및 주요 기능 총괄, ERD 다이어그램 작성, MySQL 개인 및 공동 DB 생성, 프로젝트 계획서 및 회의록 작성, 프로젝트 일정 관리
* 희린 : 웹 페이지 디자인 총괄, 공지사항 게시판 CRUD 기능, 페이징 기능, 회의록 및 일정 작성(노션 이용), css 디테일 수정
* 성재 : 백엔드 서브 담당, MySQL 개인 및 공동 DB 생성, 자유게시판 CRUD 기능, 검색 기능, API관련 코딩 담당
* 동현 : 프론트엔드 파트 총괄, 유스케이스 다이어그램 작성, Github 팀 레퍼지터리 생성 및 관리, 도서관에 바란다 게시판 CRUD, 댓글 기능, 파일 첨부 기능, 반응형 구현

---

### 👨🏻‍💻 담당 역할
* 프론트 파트의 전반적인 부분, 메인 페이지 전체 구현
* 도서관에 바란다 게시판 기능 구현, 화면 구현
* 게시글 작성 시 파일첨부 기능
* 게시글 상세보기 시 회원들의 댓글 기능
* 회원 목록 조회, 대여중인 도서 조회 기능, 화면 구현
* 디스플레이 해상도 별 반응형 구현
* 팀의 깃허브 관리

---

### 🗺️ 프로젝트 아키텍처
1. ERD
![ERD](https://github.com/InkyDChoyee/onlinePetShop/blob/master/architecture/petshop_erd.PNG?raw=true)
#

2. 메인 화면
![페이지 화면](https://github.com/InkyDChoyee/onlinePetShop/blob/master/architecture/petshop_main.PNG?raw=true)
#

3. navbar
![사이드 바](https://github.com/InkyDChoyee/onlinePetShop/blob/master/architecture/petshop_sidebar.PNG?raw=true)
#

4. 회원 가입
![회원 가입](https://github.com/InkyDChoyee/onlinePetShop/blob/master/architecture/petshop_join.PNG?raw=true)
#

5. 로그인
![로그인](https://github.com/InkyDChoyee/onlinePetShop/blob/master/architecture/petshop_login.PNG?raw=true)
#

6. 상품 목록
![상품 목록](https://github.com/InkyDChoyee/onlinePetShop/blob/master/architecture/petshop_product.PNG?raw=true)
#

7. 상품 상세
![상품 상세1](https://github.com/InkyDChoyee/onlinePetShop/blob/master/architecture/petshop_productview1.PNG?raw=true)
![상품 상세2](https://github.com/InkyDChoyee/onlinePetShop/blob/master/architecture/petshop_productview2.PNG?raw=true)
#

8. 장바구니
![장바구니](https://github.com/InkyDChoyee/onlinePetShop/blob/master/architecture/petshop_basket.PNG?raw=true)
#

9. 상품 구매
![상품 구매](https://github.com/InkyDChoyee/onlinePetShop/blob/master/architecture/petshop_order.PNG?raw=true)
#



---

### 🔗 링크
* [노션](https://far-sphynx-da9.notion.site/Final-Project-Team-a11642536ba9415d92a34192971aee89, "노션")
---
