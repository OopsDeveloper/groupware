<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/resources/css/list.css" rel="stylesheet" type="text/css">
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">공지사항</h1>
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    글쓰기
                </div>
                <div class="card-body">
                    <form method="post" action="/notice/noticeRegist.do">
                        <table>
                            <tr>
                                <td>제목</td>
                                <td><input type="text" name="noticeTitle"/></td>
                            </tr>
                            <tr>
                                <td>작성자</td>
<<<<<<< HEAD
                                <td><input type="text" name="noticeWriter"/></td>
=======
                                <td><input type="text" name="noticeWriter" value="${loginId}" readonly/></td>
>>>>>>> origin/master
                            </tr>
                            <tr>
                                <td>내용</td>
                                <td>
                                    <textarea name="noticeContent"></textarea>
                                </td>
                            </tr>
                        </table>
                        <button type="submit" style="float: right">제출하기</button>
                        <button type="button" style="float: right" onclick="location.href='/notice/notice.do'">뒤로가기</button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form>
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
