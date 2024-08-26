<%@ page import="java.util.List" %>
<%@ page import="com.lab4dx.l05_jdbc_login.CustomerDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1>회원 리스트</h1>
    <p class="text-end">
        <a href="./customerRegister.do">회원등록폼</a>
    </p>
    <%
    //request.setAttribute("customers",customers); => forward???
        Object customersObj=request.getAttribute("customers");
        List<CustomerDto> customers=(List<CustomerDto>) customersObj;
    %>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>EMAIL</th>
                <th>PHONE</th>
                <th>상세</th>
            </tr>
        </thead>
        <tbody>
            <%for(CustomerDto c : customers){ %>
                <tr>
                    <td><%=c.getCustomerId()%></td>
                    <td><%=c.getCustomerName()%></td>
                    <td><%=c.getCustomerEmail()%></td>
                    <td><%=c.getCustomerPhone()%></td>
                    <td><a href="customerDetail.do?id=<%=c.getCustomerId()%>">보기</a></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
