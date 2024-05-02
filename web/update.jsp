<%--
  Created by IntelliJ IDEA.
  User: 浙李鞠人
  Date: 2024/4/21
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>修改航班信息</title>
</head>
<body>
<div>
<h1>修改数据</h1>
    <form action="updateFlight" method="post">
<%--        设置一个隐藏域，不给用户看，给后端传递参数--%>
        <input type="hidden" value="${oneFlight.id}" name="id">
        <label>航&nbsp;&nbsp;&nbsp;&nbsp;号:<input type="text" value="${oneFlight.flightId}" name="flightId"></label><br>
        <label>航空公司:<input type="text" value="${oneFlight.company}" name="company"></label><br>
        <label>出发机场:<input type="text" value="${oneFlight.departureAirport}" name="departureAirport"></label><br>
        <label>抵达机场:<input type="text" value="${oneFlight.arriveAirport}" name="arriveAirport"></label><br>
        <label>出发时间:<input type="text" value="${oneFlight.departureTime}" name="departureTime"></label><br>
        <label>抵达时间:<input type="text" value="${oneFlight.arriveTime}" name="arriveTime"></label><br>
        <label>机&nbsp;&nbsp;&nbsp;&nbsp;型:<input type="text" value="${oneFlight.model}" name="model"></label><br>
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
