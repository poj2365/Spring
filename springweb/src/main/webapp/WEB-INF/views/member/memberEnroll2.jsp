<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
    <jsp:param name="title" value="회원가입"/>
</jsp:include>
<style>
    div#enroll-container{width:400px; margin:0 auto; text-align:center;}
    div#enroll-container input, div#enroll-container select {margin-bottom:10px;}
</style>
<div id="enroll-container">
    <form:form name="memberEnrollFrm"
          action="${pageContext.request.contextPath}/enrollmemberend.do"
    method="post" modelAttribute="member">
        <form:input path="userId" type="text" class="form-control" placeholder="아이디 (4글자이상)" name="userId" id="userId_"/>
        <form:errors path="userId"/>
        <form:input path="password" type="password" class="form-control" placeholder="비밀번호" name="password" id="password_"/>
        <form:errors path="password"/>
        <input type="password" class="form-control" placeholder="비밀번호확인" id="password2" required>
        <form:input path="userName" type="text" class="form-control" placeholder="이름" name="userName" id="userName"/>
        <form:errors path="userName" />
        <form:input path="age" type="number" class="form-control" placeholder="나이" name="age" id="age"/>
        <form:errors path="age"/>
        <form:input path="email" type="text" class="form-control" placeholder="이메일" name="email" id="email"/>
        <form:errors path="email"/>
        <form:input path="phone" type="tel" class="form-control" placeholder="전화번호 (예:01012345678)" name="phone" id="phone" maxlength="11"/>
        <form:input path="address" type="text" class="form-control" placeholder="주소" name="address" id="address"/>
        <form:select path="gender" class="form-control" name="gender">
            <form:option value="" disabled="true" selected="true">성별</form:option>
            <form:option value="M">남</form:option>
            <form:option value="F">여</form:option>
        </form:select>
        <div class="form-check-inline form-check">
            취미 : &nbsp;
            <form:checkbox path="hobby" class="form-check-input" name="hobby" id="hobby0" value="운동"/><label for="hobby0" class="form-check-label">운동</label>&nbsp;
            <form:checkbox path="hobby"  class="form-check-input" name="hobby" id="hobby1" value="등산"/><label for="hobby1" class="form-check-label">등산</label>&nbsp;
            <form:checkbox path="hobby"  class="form-check-input" name="hobby" id="hobby2" value="독서"/><label for="hobby2" class="form-check-label">독서</label>&nbsp;
            <form:checkbox path="hobby"  class="form-check-input" name="hobby" id="hobby3" value="게임"/><label for="hobby3" class="form-check-label">게임</label>&nbsp;
            <form:checkbox path="hobby"  class="form-check-input" name="hobby" id="hobby4" value="여행"/><label for="hobby4" class="form-check-label">여행</label>&nbsp;
        </div>
        <br />
        <input type="submit" class="btn btn-outline-success" value="가입" >&nbsp;
        <input type="reset" class="btn btn-outline-success" value="취소">
    </form:form>
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>