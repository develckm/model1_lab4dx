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
    <h1>회원 상세</h1>
    <%
    //request.setAttribute("customers",customers); => forward???
        Object customerObj=request.getAttribute("customer");
        CustomerDto customer=(CustomerDto) customerObj;
    %>
    <div class="card text-left">
        <div class="card-body">
            <h4 class="card-title">회원이메일 : <%=customer.getCustomerEmail()%></h4>
            <p class="card-text">회원아이디 : <%=customer.getCustomerId()%></p>
            <p class="card-text">회원이름 : <%=customer.getCustomerName()%></p>
            <p class="card-text">회원폰번호 : <%=customer.getCustomerPhone()%></p>
            <p class="text-end">
                <a href="./customerModify.do?id=<%=customer.getCustomerId()%>">수정페이지(상세와 동일)</a>
            </p>
        </div>
    </div>

</div>
</body>
</html>
