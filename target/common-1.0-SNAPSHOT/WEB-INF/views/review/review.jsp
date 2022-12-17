<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link href="/resources/css/styles.css" rel="stylesheet" type="text/css">
</head>
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
                     <c:forEach var="review" items="${reviewList}">
                         <tr>
                             <td>${review.revNo}</td>
                             <td><a href="/review/reviewView.do?bno=${review.revNo}">${review.revTitle}</a></td>
                             <td>${review.registDt}</td>
                             <td>${review.revWriter}</td>
                         </tr>
                     </c:forEach>
                     </tbody>
                 </table>
                 <button style="float: right" onclick="location.href='/review/reviewRegist.do'">글쓰기</button>
                </div>
            </div>
        </div>
    </main>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="/resources/js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="/resources/js/datatables-simple-demo.js"></script>
