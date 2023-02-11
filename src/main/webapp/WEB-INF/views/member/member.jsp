<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">회원관리</h1>
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    스터디 회원관리 페이지 입니다.
                </div>
                <div class="card-body">
                    <table id="datatablesSimple">
                        <thead>
                        <tr>
                            <th>번호</th>
                            <th>이름</th>
                            <th>아이디</th>
                            <th>비밀번호</th>
                            <th>전화번호</th>
                            <th>생일</th>
                            <th>권한</th>
                            <th>삭제</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="member" items="${memberList}">
                            <tr>
                                <td>${member.memberNo}</td>
                                <td>${member.memberNm}</td>
                                <td>${member.memberId}</td>
                                <td>***</td>
                                <td>${member.memberPhone}</td>
                                <td>${member.memberBirth}</td>
                                <c:forEach var="auth" items="${member.authList}">
                                    <td>
                                        <form method="post" action="/member/updateAuth.do">
                                            <select name="auth">
                                                <option value="ROLE_USER" ${auth.authAuth == 'ROLE_USER' ? 'selected="selected"' : ''}>USER</option>
                                                <option value="ROLE_MEMBER" ${auth.authAuth == 'ROLE_MEMBER' ? 'selected="selected"' : ''}>MEMBER</option>
                                                <option value="ROLE_ADMIN" ${auth.authAuth == 'ROLE_ADMIN' ? 'selected="selected"' : ''}>ADMIN</option>
                                            </select>
                                            <input type="hidden" name="id" value="${member.memberId}">
                                            <input type="submit" name="updateAuth" value="권한변경">
                                        </form>
                                    </td>
                                </c:forEach>
                                <td>
                                    <form method="post" action="/member/deleteMemebr.do">
                                        <input type="hidden" name="id" value="${member.memberId}">
                                        <input type="submit" name="deleteBtn" value="삭제">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
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
<%--<script type="text/javascript" src="/resources/js/member/member.js"></script>--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="/resources/js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@v5.0.3" crossorigin="anonymous"></script>
<script src="/resources/js/datatables-simple-demo.js"></script>
