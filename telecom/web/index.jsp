<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@taglib prefix="c" uri="" %>--%>
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
    <title>用户信息管理系统</title>
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
            <h1>用户信息列表</h1>
        </div>
        <div class="col-lg-1">
            <a href="${pageContext.request.contextPath}/findUserListServlet" class="btn btn-primary" style="margin-top: 30px">查询所有用户</a>
        </div>
    </header>
    <div class="container">
        <table class="table table-hover">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>电话号码</th>
                <th>年通话次数</th>
                <th>年通话时长</th>
                <th>详情</th>
            </tr>
            <c:forEach items="${requestScope.usersYear}" var="user" varStatus="s">
                <c:choose>
                    <c:when test="${s.count <= requestScope.usersYear.size()/2}">
                        <tr>
                            <td>${s.count}</td>
                            <td>${user.name}</td>
                            <td>${user.tell}</td>
                            <td>${user.sumCountYear}</td>
                            <td>${user.sumDurationYear}</td>
                            <td><a href="${pageContext.request.contextPath}/findInfoServlet?tel=${user.tell}"> 详情</a></td>
                        </tr>
                    </c:when>
                </c:choose>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
