<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="my-5">진도율 상세 페이지</h1>

            <%--상세 진도 표시--%>
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    토비의 스프링
                </div>
                <div class="card-body">
                    <table id="datatablesSimple">
                        <thead>
                        <tr>
                            <th>No.</th>
                            <th>목차</th>
                            <th>완료</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>1.스프링의 이해</td>
                            <td>
                                <input type="checkbox" name="checkedValue" value="1"/> 완료
                                <input type="checkbox" name="checkedValue" value="0"/> 미완료
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <%--진행한(된) 과정--%>
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    진행한(된) 과정
                </div>
                <div class="card-body">
                    <table id="datatablesSimple2">
                        <thead>
                        <tr>
                            <th>No.</th>
                            <th>목차</th>
                            <th>진도율</th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>토비의 스프링</td>
                                <td class="progress-bar">
                                    <div class="progress-bar-value"></div>
                                    <div class="progress-bar-fill"></div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </main>
    <footer class="py-4 bg-light mt-auto">
        <div class="container-fluid px-4">
            <div class="d-flex align-items-center justify-content-between small">

            </div>
        </div>
    </footer>
</div>
<style>
    .progress-bar {
        position: relative;
        height: 40px;
        border: 1px solid #000000;
        background-color: white;
    }

    .progress-bar-fill {
        height: 100%;
        background: #43b44c;
        transition: width 0.5s;
    }

    .progress-bar-value {
        position: absolute;
        width: 100%;
        height: 100%;

        display: flex;
        align-items: center;
        justify-content: center;
        font-weight: bold;
        color: black;
    }
</style>
<script>
    class ProgressBar {
        constructor(element, initialValue = 0) {
            this.valueElem = element.querySelector('.progress-bar-value');
            this.fillElem = element.querySelector('.progress-bar-fill');

            this.setValue(initialValue)

            console.log(this.valueElem)
            console.log(this.fillElem)
        }

        setValue(newValue) {
            if (newValue < 0) {
                newValue = 0;
            }
            if (newValue > 100) {
                newValue = 100;
            }

            this.value = newValue;
            this.update();
        }

        update() {
            let percentage = this.value + '%'; // 75%
            this.fillElem.style.width = percentage;
            this.valueElem.textContent = percentage;
        }
    }

    let pb1 = new ProgressBar(document.querySelector('.progress-bar'), 75);

</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="/resources/js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="/resources/js/datatables-simple-demo.js"></script>
