<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <div class="sb-sidenav-menu-heading">Home</div>
                <a class="nav-link" href="/main.do">
                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                    홈으로
                </a>
                <div class="sb-sidenav-menu-heading">Notice</div>
                <a class="nav-link" href="/notice/notice.do">
                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                    공지사항
                </a>
                <div class="sb-sidenav-menu-heading">Data Library</div>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                    <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                    스터디 자료
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="/refer/refer.do">자료실</a>
                        <a class="nav-link" href="/review/review.do">기업후기</a>
                    </nav>
                </div>
                <div class="sb-sidenav-menu-heading">Study Plan</div>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                    <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                    스터디 계획
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="/method/method.do">공부 방식</a>
                        <a class="nav-link" href="/study/study.do">일정</a>
                        <a class="nav-link" href="/progress/progress.do">진도율</a>
                    </nav>
                </div>
                <c:if test="${adminChk == true}">
                <div class="sb-sidenav-menu-heading">ADMIN PAGE</div>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#adminPages" aria-expanded="false" aria-controls="adminPages">
                    <div class="sb-nav-link-icon"><i class="fa-solid fa-toolbox"></i></div>
                    관리자 페이지
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="adminPages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="/member/member.do">회원 관리</a>
                        <a class="nav-link" href="/place/place.do">장소 선택</a>
                    </nav>
                </div>
                </c:if>
            </div>
        </div>
        <div class="sb-sidenav-footer">
            Study GroupWare
            <div class="small">made by salary1000Study</div>
        </div>
    </nav>
</div>
