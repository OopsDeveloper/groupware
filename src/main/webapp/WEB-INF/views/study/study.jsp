<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- fullcalendar CDN -->
<link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/main.min.css' rel='stylesheet' />
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/main.min.js'></script>
<!-- fullcalendar 언어 CDN -->
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/locales-all.min.js'></script>
<style>
    /* body 스타일 */
    html, body {
        overflow: hidden;
        font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
        font-size: 14px;
    }
    /* 캘린더 위의 해더 스타일(날짜가 있는 부분) */
    .fc-header-toolbar {
        padding-top: 1em;
        padding-left: 1em;
        padding-right: 1em;
    }
</style>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Study Calendar</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">스터디 일정</li>
            </ol>
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    스터디 일정 페이지 입니다.
                </div>
                <div class="card-body">
                    <div id='calendar-container'>
                        <div id='calendar'></div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
<script>
    (function(){
        $(function(){
            $.ajax({
                type: "post",
                url: "/study/getStudy.do",
                data: "",
                dataType: "json",
                success : function(studyData){
                    // calendar element 취득
                    var calendarEl = $('#calendar')[0];
                    // full-calendar 생성하기
                    var calendar = new FullCalendar.Calendar(calendarEl, {
                        height: '700px', // calendar 높이 설정
                        expandRows: true, // 화면에 맞게 높이 재설정
                        slotMinTime: '08:00', // Day 캘린더에서 시작 시간
                        slotMaxTime: '20:00', // Day 캘린더에서 종료 시간
                        // 해더에 표시할 툴바
                        headerToolbar: {
                            left: 'prev,next today',
                            center: 'title',
                            right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
                        },
                        initialView: 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
                        initialDate: today(), // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
                        navLinks: true, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
                        editable: true, // 수정 가능?
                        selectable: true, // 달력 일자 드래그 설정가능
                        nowIndicator: true, // 현재 시간 마크
                        dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
                        locale: 'ko', // 한국어 설정
                        eventAdd: function(data) { // 이벤트가 추가되면 발생하는 이벤트
                            debugger;
                            let obj = {};
                            obj.title = data.event._def.title;
                            obj.start = data.event._instance.range.start;
                            obj.end = data.event._instance.range.end;

                            $.ajax({
                                type: "post",
                                url: "/study/regist.do",
                                data: obj,
                                success : function(data){
                                    if(data === 'OK'){
                                        alert("등록되었습니다!");
                                        window.location.reload();
                                    } else{
                                        alert("등록 실패했습니다!");
                                        window.location.reload()
                                    }
                                },
                                error : function(error){
                                    console.log(error);
                                }
                            });
                        },
                        eventChange: function(obj) { // 이벤트가 수정되면 발생하는 이벤트
                            console.log(obj);
                        },
                        eventRemove: function(obj){ // 이벤트가 삭제되면 발생하는 이벤트
                            console.log(obj);
                        },
                        select: function(arg) { // 캘린더에서 드래그로 이벤트를 생성할 수 있다.
                            var title = prompt('Event Title:');
                            if (title) {
                                calendar.addEvent({
                                    title: title,
                                    start: arg.start,
                                    end: arg.end,
                                    allDay: arg.allDay
                                })
                            }
                            calendar.unselect()
                        },
                        events:studyData
                    });
                    // 캘린더 랜더링
                    calendar.render();
                },
                error : function(error){
                    console.log(error);
                }
            });
        });
    })();
</script>
<script>
    function today(){
        let today = new Date();

        let year = today.getFullYear();
        let month = ('0' + (today.getMonth() + 1)).slice(-2);
        let day = ('0' + today.getDate()).slice(-2);
        let dateString = year + '-' + month  + '-' + day;

        return dateString;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="/resources/js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="/resources/js/datatables-simple-demo.js"></script>
