<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/resources/css/list.css" rel="stylesheet" type="text/css">
<div id="layoutSidenav_content">
  <main>
    <div class="container-fluid px-4">
      <h1 class="mt-4">기업후기</h1>
      <div class="card mb-4">
        <div class="card-header">
          <i class="fas fa-table me-1"></i>
          글보기
        </div>
        <div class="card-body">
          <table>
            <tr>
              <td>제목</td>
              <td>${review.revTitle}</td>
            </tr>
            <tr>
              <td>작성자</td>
              <td>${review.revWriter}</td>
            </tr>
            <tr>
              <td>내용</td>
              <td>${review.revContent}</td>
            </tr>
          </table>
          <button style="float: right" onclick="location.href='/review/review.do'">뒤로가기</button>
          <button style="float: right" onclick="location.href='/review/reviewModify.do?revNo=${review.revNo}'">수정하기</button>
        </div>
      </div>
    </div>
  </main>
  <footer class="py-4 bg-light mt-auto">
    <div class="container-fluid px-4">
      <div class="d-flex align-items-center justify-content-between small">

      </div>
    </div>
  </footer>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="/resources/js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="/resources/js/datatables-simple-demo.js"></script>