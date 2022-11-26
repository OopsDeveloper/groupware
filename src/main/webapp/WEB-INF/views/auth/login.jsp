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
        function joinMemberProcess(){
            let $memberId = $("#memberId").val();
            if($memberId != ""){
                alert("회원가입이 완료되었습니다. 로그인을 진행해주세요.");
                $("#username").val($memberId);
                return;
            }
        }
        let process = {
            loginSubmit : function(){
                let $username = $("#username").val();
                let $password = $("#password").val();
                if( $username != null && $password != null ){
                    $("#loginForm").submit();
                } else {
                    alert("아이디 혹은 비밀번호를 입력해주세요.");
                }
            },
        },
        eventbind = function() {
            $("#loginButton").on("click", function(e){
                e.preventDefault();
                process.loginSubmit();
            });
        }
        $(document).ready(function(){
            eventbind();

            //회원가입 완료 시 아이디 띄우기
            joinMemberProcess();
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
                                <input type="hidden" id="memberId" value="${memberId}">
                                <form id="loginForm" action="/login" method="post">
                                        <p><c:out value="${error}" /></p>
                                        <p><c:out value="${logout}" /></p>
                                        <p><c:out value="${accessDenied}" /></p>
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
                                        <label class="form-check-label" for="remember-me">자동로그인</label>
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
