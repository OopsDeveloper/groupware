<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <a class="nav-link" href="/notice.do">
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
                        <a class="nav-link" href="/refer.do">자료실</a>
                        <a class="nav-link" href="/review.do">기업후기</a>
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
                        <a class="nav-link" href="/method.do">공부 방식</a>
                        <a class="nav-link" href="/calendar.do">일정</a>
                        <a class="nav-link" href="/progress.do">진도율</a>
                    </nav>
                </div>
            </div>
        </div>
        <div class="sb-sidenav-footer">
            Study GroupWare
            <div class="small">made by salary1000Study</div>
        </div>
    </nav>
</div>
