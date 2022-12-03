<%--
  Created by IntelliJ IDEA.
  User: KIMYONSEI
  Date: 2022-10-01
  Time: 오후 4:10
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>회원가입</title>
    <link href="/resources/css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <script src="/resources/js/jquery/jquery-3.6.1.min.js"></script>
    <script src="/resources/js/scripts.js"></script>
    <script>
        /*전역변수 설정*/
        //아이디중복확인여부
        let memberIdCheckFlag = null;
        //비밀번호확인여부
        let memberPwCheckFlag = null;

        /*프로세스*/
        let proccess = {
            //아이디중복확인
            memberIdCheck : function(){
                let $memberId = $("#memberId").val();
                if($memberId.trim() == ""){
                    alert("아이디를 입력해주세요.");
                    return false;
                }
                let params = { "memberId" : $memberId };
                $.ajax({
                    type: "get",
                    url: "/register/memberIdCheck.do",
                    data: params,
                    success : function(useYn){
                        if(useYn.documentElement.textContent == 'true'){
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
            },
            memberPwCheck : function($thisVal){
                let $memberPw = $("#memberPw").val();
                let memberPwCheckLabel = $("label[for='memberPwCheck']")
                if(!$thisVal){
                    memberPwCheckLabel.css("color","black");
                    memberPwCheckLabel.text("비밀번호확인");
                    return;
                } else if($memberPw != $thisVal){
                    memberPwCheckLabel.css("color","red");
                    memberPwCheckLabel.text("*비밀번호가 일치하지 않습니다");
                }else{
                    memberPwCheckLabel.css("color","blue");
                    memberPwCheckLabel.text("*비밀번호가 일치합니다");
                    memberPwCheckFlag = true;
                }
            },
            formSubmit : function(){
                if(memberIdCheckFlag && memberPwCheckFlag){
                    //유효성체크
                    let validCheck = $("input[id^='member']");
                    let valFlag = true;
                    $.each(validCheck, function(){
                        if(valFlag){
                            $this = $(this);
                            if(this.value.trim() == ''){
                                let $text = $this.parent().children('label').text();
                                alert($text + "을(를) 입력해주세요.");
                                $this.focus();
                                valFlag = false;
                            }
                        } else { return; }
                    });
                    if(valFlag){
                        $("#memberFormSubmit").submit();
                    }
                } else {
                    alert("아이디 중복 혹은 비밀번호를 확인해주세요");
                }
            }
        },
        /*이벤트 바인드*/
        eventbind = function(){
            //아이디입력이벤트확인
            $("#memberId").on("keyup", function(){
                memberIdCheckFlag = false;
            });
            //아이디중복확인메서드
            $("#memberIdCheck").click(function(){
                proccess.memberIdCheck();
            });
            //패스워드변경 확인
            $("#memberPw").on("keyup", function(){
                memberPwCheckFlag = false;
                $("#memberPwCheck").trigger("keyup");
            });
            //패스워드 확인
            $("#memberPwCheck").on("keyup",function(){
                proccess.memberPwCheck($(this).val());
            });
            //계정생성하기
            $("#memberFormButton").on("click", function(e){
                 e.preventDefault();
                 proccess.formSubmit();
            });
        }

        $(document).ready(function(){
            eventbind();

            memberIdCheckFlag = false;
            memberPwCheckFlag = false;
        });
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
                                <form id="memberFormSubmit" action="/register/registerWrite.do" method="post">
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" type="text" name="memberId" id="memberId" placeholder="아이디" />
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
                                                <input class="form-control" type="password" name="memberPw" id="memberPw" placeholder="비밀번호" />
                                                <label for="memberPw">비밀번호</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating">
                                                <input class="form-control" type="password" id="memberPwCheck" placeholder="비밀번호확인" />
                                                <label for="memberPwCheck">비밀번호확인</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating">
                                                <input class="form-control" type="text" name="memberNm" id="memberNm" placeholder="이름" />
                                                <label for="memberNm">이름</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating">
                                                <input class="form-control" type="text" name="memberBirth" placeholder="생년월일" id="memberBirth"/>
                                                <label for="memberBirth">생년월일(ex 1990-01-01)</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating">
                                                <input class="form-control" type="text" name="memberPhone" id="memberPhone" placeholder="휴대폰번호" />
                                                <label for="memberPhone">휴대폰번호(ex 01085924405)</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating">
                                                <input class="form-control" type="email" name="memberMail" id="memberMail" placeholder="이메일주소" />
                                                <label for="memberMail">이메일주소(ex email@hanadul.com)</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mt-4 mb-0">
                                        <div class="d-grid">
                                            <button type="button" id="memberFormButton" class="btn btn-primary btn-block">계정생성하기</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer text-center py-3">
                                <div class="small"><a href="/auth/login.do">로그인 화면 이동하기</a></div>
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
                </div>
            </div>
        </footer>
    </div>
</div>
</body>
</html>
