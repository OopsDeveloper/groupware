<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/resources/js/jquery/jquery-3.6.1.min.js"></script>
<script>
    const regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
    const maxSize = 5242880; //5MB

    //프로세스관련
    let process = {
            fileupload : function(){
                let formData = new FormData();
                let inputFile = $("input[name='uploadFile']");
                let files = inputFile[0].files;

                console.log(files);

                //파일 데이터를 formdata에 추가하기
                for (let i = 0; i < files.length; i++) {
                    //파일 유효성 체크
                    if (this.checkExtension(files[i].name), files[i].size) {
                        formData.append("uploadFile", files[i]);
                    } else {
                        return false;
                    }
                }

                //ajax 실행
                $.ajax({
                    url: '/upload/ajax.do',
                    processData: false, //반드시 false
                    contentType: false, //반드시 false
                    data: formData,
                    type: "POST",
                    success: function (result) {
                        alert("업로드 되었습니다.");
                    }
                });//ajax종료
            },
            //업로드 파일 유효성 검사
            checkExtension : function(fileName, fileSize) {
                if (fileSize >= maxSize) {
                    alert(fileName + " : 파일 사이즈가 초과되었습니다.(" + fileSize + " 사이즈는 5MB 초과)");
                    return false;
                }
                if (regex.test(fileName)) {
                    alert(fileName + " : 해당 종류의 파일은 업로드 할 수 없습니다.");
                    return false;
                }
                return true;
            }
        },
        //이벤트 관련
        eventbind = function() {
            $("#uploadBtn").on("click", function(e){
                e.preventDefault();
                process.fileupload();
            });
        }
    $(document).ready(function(){
        eventbind();
    });
</script>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">마이페이지</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">${memberVO.memberNm}님의 마이페이지입니다.</li>
            </ol>
            <div class="card mb-4">
                <div class="card-header">
                    <input type="file" name="uploadFile" multiple>
                </div>
                <div class="card-body">
                    <button style="float: right" id="uploadBtn">사진 등록하기</button>
                </div>
            </div>
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    ${memberVO.memberNm}님 정보
                </div>
                <div class="card-body">
                    <table id="datatablesSimple">
                        <thead>
                        <tr>
                            <th>아이디</th>
                            <th>이름</th>
                            <th>생년월일</th>
                            <th>메일주소</th>
                            <th>연락처</th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${memberVO.memberId}</td>
                                <td>${memberVO.memberNm}</td>
                                <td>${memberVO.memberBirth}</td>
                                <td>${memberVO.memberMail}</td>
                                <td>${memberVO.memberPhone}</td>
                            </tr>
                        </tbody>
                    </table>
                    <button style="float: right" onclick="location.href='/member/updateMember.do'">수정하기</button>
                </div>
            </div>
        </div>
    </main>
</div>
