<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
    $(document).ready(function() {
        $( "#datepicker" ).datepicker({
            dateFormat: "yy-mm-dd",
            closeText: "닫기",
            currentText: "오늘",
            prevText: '이전 달',
            nextText: '다음 달',
            monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            dayNames: ['일', '월', '화', '수', '목', '금', '토'],
            dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
            dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
            weekHeader: "주",
            yearSuffix: '년',
            maxDate: "0",
            showMonthAfterYear: true
        });
    } );
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
                                <td><input value="${memberVO.memberNm}"></td>
                                <td><input id="datepicker" value="${memberVO.memberBirth}"></td>
                                <td><input value="${memberVO.memberMail}"></td>
                                <td><input value="${memberVO.memberPhone}"></td>
                            </tr>
                        </tbody>
                    </table>
                    <button style="float: right" onclick="location.href='/member/updateMember.do'">수정하기</button>
                </div>
            </div>
        </div>
    </main>
</div>
