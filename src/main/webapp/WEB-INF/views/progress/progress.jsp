<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Study Progress</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">스터디 진도율</li>
            </ol>
            <div class="row">
                <div class="col-xl-3 col-md-6">
                    <div class="card bg-primary text-white mb-4">
                        <div class="card-body">Progress Rate Details <i style="font-size: 10px; color: #e5e6e7">(진도율 상세)</i></div>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a class="small text-white stretched-link" href="#">View Details</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-md-6">
                    <div class="card bg-warning text-white mb-4">
                        <div class="card-body">Overall Member Progress Rate <i style="font-size: 10px; color: #e5e6e7">(전체 맴버 진도율)</i></div>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a class="small text-white stretched-link" href="#">View Details</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-md-6">
                    <div class="card bg-success text-white mb-4">
                        <div class="card-body">Attendance History <i style="font-size: 10px; color: #e5e6e7">(출석 이력)</i></div>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a class="small text-white stretched-link" href="#">View Details</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-md-6">
                    <div class="card bg-danger text-white mb-4">
                        <div class="card-body">Reasons for Absence <i style="font-size: 10px; color: #e5e6e7">(불참 사유)</i></div>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a class="small text-white stretched-link" href="#">View Details</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-6">
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-chart-area me-1"></i>
                            Progress Attainment Rate <i class="breadcrumb-item active" style="font-size: 10px;">(진도 달성률)</i>
                        </div>
                        <div class="card-body"><canvas id="chart1" width="100%" height="40"></canvas></div>
                    </div>
                </div>
                <div class="col-xl-6">
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-chart-bar me-1"></i>
                            Attendance Rate <i class="breadcrumb-item active" style="font-size: 10px;">(출석률)</i>
                        </div>
                        <div class="card-body"><canvas id="chart2" width="100%" height="40"></canvas></div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
<%--<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>--%>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>
<script>
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(function () {
        console.log("hi")
        selectProgressChart();
    });
    function selectProgressChart() {
        console.log("ajax function enter")
        //debugger;
        $.ajax({
            url : "/progress/selectProgressRate.do",
            type : "post",
            dataType : "json",
            data : {},
            beforeSend : function(xhr){
                xhr.setRequestHeader(header, token);
            },
            async : true,
            success : function(data){
                console.log(data)
                /*
                if(data.status == "SUCCESS"){
                    if(chart_type == 'radar'){
                        let dataSetArr = radarGraphDataSet(data.result_list);

                        radarGraphView(dataSetArr);

                    }else if(chart_type == 'line'){
                        let dataSetArr = barGraphDataSet(data.result_list);

                        lineGraphView(dataSetArr );
                    }else if(chart_type == 'vertical_bargraph'){

                        let dataSetArr = barGraphDataSet(data.result_list);

                        verticalBarGraphView(dataSetArr);

                    }else if(chart_type == 'width_bargraph'){

                        let dataSetArr = barGraphDataSet(data.result_list);

                        widthBarGraphView(dataSetArr);
                    }
                }else{
                    alert(data.statusDescription);
                }
                */
            }
        })
    }

    // Set new default font family and font color to mimic Bootstrap's default styling
    Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
    Chart.defaults.global.defaultFontColor = '#292b2c';

    // progress chart1
    var ctx = document.getElementById("chart1");
    var myLineChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
            datasets: [{
                label: "Sessions",
                lineTension: 0.3,
                backgroundColor: "rgba(2,117,216,0.2)",
                borderColor: "rgba(2,117,216,1)",
                pointRadius: 5,
                pointBackgroundColor: "rgba(2,117,216,1)",
                pointBorderColor: "rgba(255,255,255,0.8)",
                pointHoverRadius: 5,
                pointHoverBackgroundColor: "rgba(2,117,216,1)",
                pointHitRadius: 50,
                pointBorderWidth: 2,
                data: [50, 50, 75, 100, 75, 100, 25, 100, 100, 75, 100, 100],
            }],
        },
        options: {
            scales: {
                xAxes: [{
                    time: {
                        unit: 'date'
                    },
                    gridLines: {
                        display: false
                    },
                    ticks: {
                        maxTicksLimit: 12
                    }
                }],
                yAxes: [{
                    ticks: {
                        min: 0,
                        max: 100,
                        maxTicksLimit: 4
                    },
                    gridLines: {
                        color: "rgba(0, 0, 0, .125)",
                    }
                }],
            },
            legend: {
                display: false
            }
        }
    });

    // Bar Chart Example
    var ctx2 = document.getElementById("chart2");
    var myLineChart = new Chart(ctx2, {
        type: 'bar',
        data: {
            labels: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
            datasets: [{
                label: "Revenue",
                backgroundColor: "rgba(2,117,216,1)",
                borderColor: "rgba(2,117,216,1)",
                data: [25, 100, 50, 100, 100, 75, 100, 50, 100, 75, 100,75],
            }],
        },
        options: {
            scales: {
                xAxes: [{
                    time: {
                        unit: 'month'
                    },
                    gridLines: {
                        display: false
                    },
                    ticks: {
                        maxTicksLimit: 12
                    }
                }],
                yAxes: [{
                    ticks: {
                        min: 0,
                        max: 100,
                        maxTicksLimit: 4
                    },
                    gridLines: {
                        display: true
                    }
                }],
            },
            legend: {
                display: false
            }
        }
    });
</script>