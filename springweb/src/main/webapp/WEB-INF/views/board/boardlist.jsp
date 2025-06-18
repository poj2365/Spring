<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/common/header.jsp">
  <jsp:param name="title" value="회원가입"/>
</jsp:include>
<section id="board-container" class="container">
  <p>총 ${totalContents }건의 게시물이 있습니다.</p>
  <table id="tbl-board" class="table table-striped table-hover">
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>작성일</th>
      <th>첨부파일</th>
      <th>조회수</th>
    </tr>
    <c:if test="${not empty boards}">
      <c:forEach var="b" items="${boards}">
        <tr>
          <td>${b.boardNo}</td>
          <td>${b.boardTitle}</td>
          <td>${b.boardWriter}</td>
          <td>${b.boardDate}</td>
          <td></td>
          <td>${b.boardReadCount}</td>
        </tr>
      </c:forEach>
    </c:if>
  </table>
  <div id="pageBar">
    ${pageBar}
  </div>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
