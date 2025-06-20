<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>HelloSpring</title>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

  <!-- jQuery library -->
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

  <!-- Popper JS -->
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

  <!-- Latest compiled JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="${path}/resources/css/style.css"/>
  <script src="${path}/resources/js/jquery-3.7.0.min.js"></script>
</head>
<body>
<div id="container">
  <header>
    <div id="header-container">
      <h3>${param.title}</h3>
    </div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="#">
        <img alt="로고" src="${path}/resources/images/logo-spring.png"
             width="50px">
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse"
              data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
              aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul	class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="${path}">HOME</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="${path}/demo/demo.do">
              DEMO(controller-test)
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="${path}/exceptiontest/illegal">
              exceptiontest-Illegal
            </a>
          </li>
          <li class="nav-item active">
          <a class="nav-link" href="${path}/exceptiontest/nullPoint">
            exceptiontest-nullPoint
          </a>
        </li>
          <li class="nav-item active">
            <a class="nav-link" href="${path}/national">
              국제화처리하기
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="${path}/validator/demo">
              BeanValidator이용하기
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="${path}/board/searchboard.do">
              게시글
            </a>
          </li>
        </ul>
        <c:if test="${loginMember==null}">
          <button class="btn btn-outline-success my-2 my-sm-0"
                  data-toggle="modal" data-target="#loginModal">로그인</button>
          &nbsp;
          <button class="btn btn-outline-primary my-2 my-sm-0"
                  onclick="location.assign('${path}/enrollmember.do')">
            회원가입
          </button>
        </c:if>
        <c:if test="${loginMember != null}">
          <span>
              <a href="">
                ${loginMember.userName}
              </a>
               님, 환영합니다.
          </span>

          <button class="btn btn-outline-danger"
          onclick="location.replace('${path}/logout.do')">
            로그아웃
          </button>

        </c:if>
      </div>
    </nav>

    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
         aria-labelledby="loginModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="loginModalLabel">로그인</h5>
            <button type="button" class="close"
                    data-dismiss="modal" aria-label="close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <form action="${path}/loginend.do" method="post">
            <div class="modal-body">
              <input type="text" name="userId" class="form-control"
                     placeholder="아이디입력" required><br/>
              <input type="password" name="pw" class="form-control"
                     placeholder="패스워드입력" required>	<br/>
              <label><input type="checkbox" name="saveUser">로그인유지</label>
            </div>
            <div class="modal-footer">
              <button type="submit" class="btn btn-outline-success">로그인</button>
              <button type="button" class="btn btn-outline-success"
                      data-dismiss="modal">취소</button>
            </div>
          </form>
        </div>
      </div>
    </div>

  </header>
