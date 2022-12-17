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
    <title>비밀번호 초기화</title>
    <link href="/resources/css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="/resources/js/scripts.js"></script>
    <script src="/resources/js/jquery/jquery-3.6.1.min.js"></script>
    <script>
        let process = {
            //아이디중복확인
            memberIdCheck : function(){
                let $memberId = $("#memberId").val();
                let $memberPhone = $("#memberPhone").val();
                if($memberId.trim() == ""){
                    alert("아이디를 입력해주세요.");
                    return false;
                }
                if($memberPhone.trim() == ""){
                    alert("휴대폰 번호를 입력해주세요.");
                    return false;
                }
                let params = {
                    "memberId" : $memberId,
                    "memberPhone" : $memberPhone
                };
                $.ajax({
                    type: "get",
                    url: "/register/memberIdCheck.do",
                    data: params,
                    success : function(memberYn){
                        if(memberYn.documentElement.textContent == 'true'){
                            alert("존재하지 않는 계정입니다. 아이디 혹은 휴대폰번호를 확인해주세요.");
                        } else {
                            if(confirm("아이디가 확인되었습니다.\n비밀번호를 초기화시키시겠습니까?")){
                                process.resetPw();
                            } else {
                                alert("취소되었습니다.");
                            }
                        }
                    },
                    error : function(error){
                        console.log(error);
                    }
                });
            },
            resetPw : function(){
                let $memberId = $("#memberId").val();
                if($memberId.trim() == ""){
                    alert("아이디를 입력해주세요.");
                    return false;
                }
                let params = {
                    "memberId" : $memberId
                };
                $.ajax({
                    type: "post",
                    url: "/register/resetPw.do",
                    data: params,
                    success : function(){
                        alert("초기화 되었습니다. 비밀번호는 아이디와 동일합니다.");
                        window.close();
                    },
                    error : function(error){
                        console.log(error);
                    }
                });
            },
        },
        eventbind = function() {
            $("#memberCheckButton").click(function(){
                process.memberIdCheck();
            });
        }
        $(document).ready(function(){
            eventbind();
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
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">비밀번호 초기화</h3></div>
                            <div class="card-body">
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="form-control" type="text" name="memberId" id="memberId" placeholder="아이디" />
                                            <label for="memberId">아이디</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating">
                                            <input class="form-control" type="text" name="memberPhone" id="memberPhone" placeholder="휴대폰번호" />
                                            <label for="memberPhone">휴대폰번호(ex 01085924405)</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="d-grid">
<%--                                    <button type="button" id="memberCheckButton" class="btn btn-primary btn-block">아이디확인하기</button>--%>
                                <div class="d-grid"><a class="btn btn-secondary btn-block btn_sm" id="memberCheckButton">아이디확인하기</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>
