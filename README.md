# Angular-Spring-MiniPrj
1. 파일롯 프로젝트 주제 : 회원 가입, 로그인, 게시판 구현
2. 개발환경 스펙

2.1. 필수

( API 서버 ) - Java 8 - Spring 5.0 MVC - MySQL - 모든 기능은 rest api 방식으로 개발 - API 에 대한 규격서 작성

( Front 서버 ) - nodejs - angular

( 공통 ) - 소스는 Git 으로 사용 (개인 github 계정 생성하여 공유할것)

2.2. 선택 - Springboot - Spring Security - ORM(Hibernate, JPA 등) - Git - Gradle - Freemarker, Handlbar, Thymeleaf - jQuery - typescript - Ajax - JUnit - Node.js - Backbone.js - BootStrap - 다양한 Spring Annotation - 다양한 Design Pattern - 다양한 opensource, framework - Webpack - lodash - QueryDSL - Logback 등 모두 가능

요구사항 3.1. ~ 1, 2주차) ##회원 기능
회원가입 : id, password(비밀번호 단방향 암호 > BCryptPasswordEncoder(bcrypt 해시알고리즘)를 사용), 이름, 주소, 전화번호, email 을 계정정보로 가짐
로그인
개인정보수정
탈퇴 ##게시판
게시판은 하나 고정 (여러 개의 게시판 X)
게시판글의 등록, 수정, 삭제 및 권한 처리(내가 쓴 글만 수정, 삭제 가능)
게시글 구성 : 번호, 제목, 내용, 글쓴이, 시간, 조회수
게시글에 계층형 댓글 작성 가능(대댓글까지)
게시글 글자수 제한(10000자), 댓글 글자수 제한(140자)
textchange(MIT license) 모듈(js)을 사용하여 사용자의 입력에 이벤트를 걸어 글자수를 제한
3.2. 이후~)

페이징
글 입력/수정시 보안 처리(tag, script 입력 필터링)
첨부파일 : 이미지(jpg,png,gif) 업로드 기능
소셜 계정 로그인(구글, 페이스북)
게시글 임시 저장 기능
댓글의 계층형 단계 무한 확장
좋아요 기능 구현
게시판 확장 - 게시판 관리 (조회, 생성, 수정, 삭제) 기능 추가
리뷰 4.1. 매주 1회 개발 내용 소스 리뷰 진행
