
<%--
  Created by IntelliJ IDEA.
  User: 浙李鞠人
  Date: 2024/4/20
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>航班系统</title>
</head>
<body>
<table border="1" align="center" style="border-collapse: collapse;width:80%">
  <tr>
    <th align="center">航号</th>
    <th align="center">航空公司</th>
      <th align="center">出发机场</th>
      <th align="center">到达机场</th>
      <th align="center">出发时间</th>
      <th align="center">到达时间</th>
      <th align="center">机型</th>
      <th align="center">操作</th>
  </tr>

        <c:forEach items="${allFlight}" var="flight">
    <tr align="center">
            <td align="center">${flight.flightId}</td>
            <td align="center">${flight.company}</td>
            <td align="center">${flight.departureAirport}</td>
            <td align="center">${flight.arriveAirport}</td>
            <td align="center">${flight.departureTime}</td>
            <td align="center">${flight.arriveTime}</td>
            <td align="center">${flight.model}</td>
            <td align="center"><a href="/flight_war_exploded/updateFlight?id=${flight.id}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/flight_war_exploded/delFlight?id=${flight.id}">删除</a></td>
    </tr>
        </c:forEach>


</table>
<a href="/flight_war_exploded/insertFlight">新增航班信息</a>
</body>
</html>
