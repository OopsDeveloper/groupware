<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="layoutSidenav_content">
  <main>
    <div class="container-fluid px-4">
      <h1 class="mt-4">Enterprise Review</h1>
      <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item active">기업 후기</li>
      </ol>
      <div class="card mb-4">
        <div class="card-header">
          <i class="fas fa-table me-1"></i>
          기업 후기 페이지 입니다.
        </div>
        <div class="card-body">
          <table id="datatablesSimple">
            <thead>
            <tr>
              <th>번호</th>
              <th>제목</th>
              <th>등록일</th>
              <th>작성자</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="notice" items="${noticeList}">
              <tr>
                <td>${notice.noticeNo}</td>
                <td><a href="/notice/noticeView.do?bno=${notice.noticeNo}">${notice.noticeTitle}</a></td>
                <td>${notice.registDt}</td>
                <td>${notice.noticeWriter}</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
          <button style="float: right" onclick="location.href='/notice/noticeRegist.do'">글쓰기</button>
        </div>
      </div>
    </div>
  </main>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="/resources/js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="/resources/js/datatables-simple-demo.js"></script>
