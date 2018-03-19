<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <sql:setDataSource var = "onlinerecruiter" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/onlinerecruiter?autoReconnect=true&allowMultiQueries=false"
         user = "root"  password = "kutcher
         "/>
 
      <sql:query dataSource = "${onlinerecruiter}" var = "result">
         SELECT * from company;
      </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>CID</th>
            <th>name</th>
            <th>address</th>
            <th>description</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.cid}"/></td>
               <td><c:out value = "${row.name}"/></td>
               <td><c:out value = "${row.address}"/></td>
               <td><c:out value = "${row.description}"/></td>
            </tr>
         </c:forEach>
      </table>
</body>
</html>