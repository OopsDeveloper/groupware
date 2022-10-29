<%--
  Created by IntelliJ IDEA.
  User: KIMYONSEI
  Date: 2022-10-01
  Time: 오후 4:10
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Register - SB Admin</title>
    <link href="/resources/css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/resources/js/scripts.js"></script>
    <script>
        //아이디중복확인여부
        let memberIdCheckFlag = false;
        //비밀번호확인여부
        let memberPwCheckFlag = false;

        $(document).ready(function(){
            memberIdCheckMethod();
            passwordCheckMethod();
            memberPhoneCheck();
        });

        function memberIdCheckMethod () {
            //아이디입력이벤트확인
            $("#memberId").change(function(){
                memberIdCheckFlag = false;
            });
            //아이디중복확인메서드
            $("#memberIdCheck").click(function(){
                memberIdCheck();
            });
        }
        //아이디중복확인
        function memberIdCheck(){
            let $memberId = $("#memberId").val();
            if($memberId.trim() == ""){
                alert("아이디를 입력해주세요.");
                return false;
            }
            let param = { "memberId" : $memberId };
            $.ajax({
                type: "GET",
                url: "/register/memberIdCheck.do",
                // headers : {"Content-Type":"application/json"},
                data: param,
                // dataType: "text",
                success : function(memberVo){
                    if(!memberVo){
                        alert("사용가능한 아이디입니다.");
                        memberIdCheckFlag = true;
                    } else {
                        alert("이미 아이디가 존재합니다. 다른 아이디를 입력해주세요.");
                    }
                },
                error : function(error){
                    console.log(error);
                }
            });
        }
        //패스워드재확인
        function passwordCheckMethod(){
            let $lableText = $("div.form-floating label[for='memberPwCheck']");
            $("#memberPwCheck").keyup(function(){
                const $memberPw = $("#memberPw").val();
                if($memberPw == $(this).val()){
                    $lableText.text("비밀번호확인 (비밀번호가 일치합니다.)")
                    memberPwCheckFlag = true;
                }else{
                    $lableText.text("비밀번호확인 (비밀번호가 불일치합니다.)")
                    memberPwCheckFlag = false;
                }
            });
        }
        //휴대폰번호정규식적용
        function memberPhoneCheck(){
            $("#memberPhone").keyup(function(){
                // let $thisValue = $(this).val().replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/\-{1,2}$/g, "");
                let $thisValue = $(this).val().replace(/-/g, '').replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3');
                $("#memberPhone").val($thisValue);
            });
        }
    </script>
</head>
<body class="bg-primary">
<div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-7">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">계정 생성</h3></div>
                            <div class="card-body">
                                <form action="/login.do">
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="memberId" type="text" placeholder="사용할 아이디를 입력하세요." required="required"/>
                                                <label for="memberId">아이디</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <div class="d-grid"><a class="btn btn-secondary btn-block btn_sm" id="memberIdCheck">아이디 중복 확인하기</a></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="memberPw" type="password" placeholder="사용할 비밀번호를 입력하세요." required="required"/>
                                                <label for="memberPw">비밀번호</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating">
                                                <input class="form-control" id="memberPwCheck" type="password" placeholder="비밀번호를 다시 한 번 입력하세요." required="required"/>
                                                <label for="memberPwCheck">비밀번호확인</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating">
                                                <input class="form-control" id="memberNm" type="text" placeholder="이름을 입력하세요." required="required"/>
                                                <label for="memberNm">이름</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating">
                                                <input class="form-control" id="memberPhone" type="text" placeholder="휴대폰번호를 입력하세요." required="required"/>
                                                <label for="memberPhone">휴대폰번호</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating">
                                                <input class="form-control" id="memberMail" type="emial" placeholder="이메일 주소를 입력하세요." required="required"/>
                                                <label for="memberMail">이메일주소</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating">
                                                <input class="form-control" id="memberBirth" type="text" placeholder="생년월일을 입력하세요." required="required"/>
                                                <label for="memberBirth">생년월일</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mt-4 mb-0">
                                        <div class="d-grid">
                                            <button type="submit" class="btn btn-primary btn-block">계정생성하기</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer text-center py-3">
                                <div class="small"><a href="login.html">Have an account? Go to login</a></div>
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
