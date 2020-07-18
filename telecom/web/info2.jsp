<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>数据可视化</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<!--1定义容器-->
<div class="container-fluid">
    <!--    定义行-->
    <header class="container">
        <div class="col-lg-11 text-center">
            <h2>${sessionScope.username}的通话次数（被叫）</h2>
        </div>
        <div class="col-lg-1">
            <a href="${pageContext.request.contextPath}/findUserListServlet" class="btn btn-primary" style="margin-top: 30px">返回主页</a>
        </div>
    </header>
    <div class="container">
        <!-- 可视化视图 -->
        <div class="row">
            <div class="col-lg-12">
                <center id="center">
                    <div id="userView" style="width: 1000px;height:550px;"></div>
                </center>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <nav>
                    <ul class="pager">
                        <li><a href="${pageContext.request.contextPath}/info.jsp">用户主叫次数</a></li>
                        <li><a href="${pageContext.request.contextPath}/info1.jsp">用户主叫通话时长</a></li>
                        <li><a href="${pageContext.request.contextPath}/info2.jsp">用户被叫次数</a></li>
                        <li><a href="${pageContext.request.contextPath}/info3.jsp">用户被叫通话时长</a></li>
                        <li><a href="${pageContext.request.contextPath}/info4.jsp">用户主叫和被叫通话次数</a></li>
                        <li><a href="${pageContext.request.contextPath}/info5.jsp">用户主叫和被叫通话时长</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>
<script src="js/echarts.min.js"></script>
<script>
    //用户的被叫通话次数
    var sumCount_1 = new Array();
    var sumCount_1_i = 0;
    <c:forEach var="list" items="${sessionScope.sumCount_1}" >
    sumCount_1[sumCount_1_i++] = ${list}
    </c:forEach>
    //初始化
    var userView = echarts.init(document.getElementById("userView"));
    //指定图表的配置项和数据
    var option = {
        title:{
            text: '通话分析结果'
        },
        color:['#003366'],
        tooltip:{
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend:{
            data:['通话次数']
        },
        //右侧小工具栏，可以隐藏
        toolbox:{
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            itemSize:'18',
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis:{
            data: ['January', 'February', 'March', 'April', 'May', 'June','July','August','September','October','November','December']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            name: '通话次数',
            type: 'bar',
            data: sumCount_1
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    userView.setOption(option);
</script>
</body>
</html>
