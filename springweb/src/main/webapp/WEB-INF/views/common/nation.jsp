<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>국제화처리 페이지</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/national">
 <select name="local">
   <option disabled value="" selected>언어선택</option>
   <option value="en">영어</option>
   <option value="ko">한글</option>
 </select>
</form>
<script>
  document.querySelector("form>select[name='local']")
          .addEventListener("change",e=>{
            document.querySelector("form").submit();
          });
</script>
  <h2>정보</h2>
  <h3>${info}</h3>
  <h2>나의 정보</h2>
  <h3>${myinfo}</h3>

  <%--  <h2>나의 정보-en_US</h2>
  <h3>${infoEn}</h3>
  <h2>나의 정보-ko_KR</h2>
  <h3>${infoKo}</h3>

  <h2>나의 정보-en_US</h2>
  <h3>${myinfoEn}</h3>
  <h2>나의 정보-ko_KR</h2>
  <h3>${myinfoKo}</h3>--%>
</body>
</html>
