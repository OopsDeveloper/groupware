<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title> Login Page </title>
    <link href="/resources/css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="/resources/js/scripts.js"></script>
    <script src="/resources/js/jquery/jquery-3.6.1.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#loginButton").on("click", function(e){
                e.preventDefault();
                $("#loginForm").submit();
            });
        });
    </script>
</head>
<body class="bg-primary">
<div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-5">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
                            <div class="card-body">
                                <form id="loginForm" action="/login" method="post">
                                    <c:if test="${param.error != null}">
                                        <p>아이디 또는 비밀번호를 다시 입력해주세요.</p>
                                    </c:if>
                                    <c:if test="${param.logout != null}">
                                        <p>로그아웃 되었습니다.</p>
                                    </c:if>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="username" type="text" name="username" placeholder="아이디를 입력하세요." />
                                        <label for="username">아이디를 입력하세요.</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="password" type="password" name="password" placeholder="비밀번호를 입력하세요."/>
                                        <label for="password">비밀번호를 입력하세요.</label>
                                    </div>
                                    <div class="form-check mb-3">
                                        <input class="form-check-input" id="remember-me" type="checkbox" name="remember-me"/>
                                        <label class="form-check-label" for="remember-me">아이디 기억하기</label>
                                    </div>
                                    <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                        <a class="small" href="password.html">비밀번호를 잊어버리셨나요?</a>
                                        <a class="btn btn-primary" href="#!" id="loginButton">Login</a>
                                    </div>
                                    <input:csrfInput />
                                </form>
                            </div>
                            <div class="card-footer text-center py-3">
                                <div class="small"><a href="/register/registerWrite.do">회원가입으로 이동하기</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
    <div id="layoutAuthentication_footer">
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid px-4">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">Copyright &copy; Your Website 2022</div>
                    <div>
                        <a href="#">Privacy Policy</a>
                        &middot;
                        <a href="#">Terms &amp; Conditions</a>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>
</body>
</html>
