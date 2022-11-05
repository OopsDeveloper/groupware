<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/resources/css/place.css">
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">장소선택</h1>
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    장소선택 페이지 입니다.
                </div>
                <div class="map_wrap">
                    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
                    <div id="menu_wrap" class="bg_white">
                        <div class="option">
                            <div>
                                <form onsubmit="searchPlaces(); return false;">
                                    키워드 : <input type="text" value="탄방동 할리스" id="keyword" size="15">
                                    <button type="submit">검색하기</button>
                                </form>
                            </div>
                        </div>
                        <hr>
                        <ul id="placesList"></ul>
                        <div id="pagination"></div>
                    </div>
                </div>
            </div>
            <div>
                <input type="text" placeholder="장소를 클릭해주세요!" readonly>
                <input type="hidden" id="addressName" value="">
                <input type="hidden" id="placeName" value="">
                <input type="hidden" id="lat" value="">
                <input type="hidden" id="lon" value="">
                <button>장소 저장</button>
            </div>
        </div>
    </main>
</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=79950577ab1144cad85ba3397975da27&libraries=services"></script>
<script type="text/javascript" src="/resources/js/place/place.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="/resources/js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="/resources/js/datatables-simple-demo.js"></script>
