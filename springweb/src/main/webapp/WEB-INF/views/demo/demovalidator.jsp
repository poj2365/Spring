<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
  <jsp:param name="title" value="beanvalidator이용하기"/>
</jsp:include>
<style>
    .errorMsg{
      color:red;
      font-size:20px;
      font-weight:bolder;
    }
</style>
<section id="content">
  <div id="demo-container">
    <%-- springform태그 이용하기 -> spring validator와 연동되는 태그 --%>
    <form:form id="devFrm" method="post" modelAttribute="demo"
    action="${pageContext.request.contextPath}/validator.do">
      <div class="form-group row">
        <label for="devName" class="col-sm-2 col-form-label">이름</label>
        <div class="col-sm-10">
          <form:input path="devName" type="text" class="form-control" id="devName" name="devName"/>
          <form:errors path="devName" cssClass="errorMsg"/>
        </div>
      </div>
      <div class="form-group row">
        <label for="devAge" class="col-sm-2 col-form-label">나이</label>
        <div class="col-sm-10">
          <form:input path="devAge" type="number" class="form-control" id="devAge" name="devAge"/>
          <form:errors path="devAge" cssClass="errorMsg"/>
        </div>
      </div>
      <div class="form-group row">
        <label for="devEmail" class="col-sm-2 col-form-label">이메일</label>
        <div class="col-sm-10">
          <form:input path="devEmail" type="text" class="form-control" id="devEmail" name="devEmail"/>
          <form:errors path="devEmail" cssClass="errorMsg"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 col-form-label">성별</label>
        <div class="col-sm-10">
          <div class="form-check form-check-inline">
            <form:radiobutton path="devGender" class="form-check-input" name="devGender" id="devGender0" value="M"/>
            <label class="form-check-label" for="devGender0">남</label>
          </div>
          <div class="form-check form-check-inline">
            <form:radiobutton path="devGender" class="form-check-input" name="devGender" id="devGender1" value="F"/>
            <label class="form-check-label" for="devGender1">여</label>
          </div>
          <form:errors path="devGender" cssClass="errorMsg"/>
        </div>
      </div>

      <div class="form-group row">
        <label for="birthDay" class="col-sm-12 col-from-label">
          생일
        </label>
        <div class="col-sm-10">
          <form:input path="birthDay" type="date" class="form-control" id="birthDay" name="birthDay"/>
          <form:errors path="birthDay" cssClass="errorMsg"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 col-form-label">개발언어</label>
        <div class="col-sm-10">
          <div class="form-check form-check-inline">
            <form:checkbox path="devLang" class="form-check-input" name="devLang" id="devLang0" value="Java"/>
            <label class="form-check-label" for="devLang0">Java</label>
          </div>
          <div class="form-check form-check-inline">
            <form:checkbox path="devLang" class="form-check-input" name="devLang" id="devLang1" value="C"/>
            <label class="form-check-label" for="devLang1">C</label>
          </div>
          <div class="form-check form-check-inline">
            <form:checkbox path="devLang" class="form-check-input" name="devLang" id="devLang2" value="Javascript"/>
            <label class="form-check-label" for="devLang2">Javascript</label>
          </div>
        </div>
      </div>
      <div class="form-group row">
        <div class="col-sm-12">
          <button type="submit" class="btn btn-outline-primary col-sm-12">
            validator테스트
          </button>
        </div>
      </div>
    </form:form>
  </div>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
