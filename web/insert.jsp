<%--
  Created by IntelliJ IDEA.
  User: 浙李鞠人
  Date: 2024/4/30
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>插入航班信息</title>
</head>
<body>
<div>
    <h1>新增数据</h1>
    <form action="insertFlight" method="post">
        <%--        设置一个隐藏域，不给用户看，给后端传递参数--%>
        <input type="hidden" name="id">
        <label>航&nbsp;&nbsp;&nbsp;&nbsp;号:<input type="text" name="flightId"></label><br>
        <label>航空公司:<input type="text" name="company"></label><br>
        <label>出发机场:<input type="text"  name="departureAirport"></label><br>
        <label>抵达机场:<input type="text"  name="arriveAirport"></label><br>
        <label>出发时间:<input type="text"  name="departureTime"></label><br>
        <label>抵达时间:<input type="text" name="arriveTime"></label><br>
        <label>机&nbsp;&nbsp;&nbsp;&nbsp;型:<input type="text" name="model"></label><br>
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
