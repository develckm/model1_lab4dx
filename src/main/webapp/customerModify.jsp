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
    <h1>회원 수정</h1>
    <%
    //request.setAttribute("customers",customers); => forward???
        Object customerObj=request.getAttribute("customer");
        CustomerDto customer=(CustomerDto) customerObj;
    %>
    <form action="./customerModifyAction.do" method="post">
        <div class="form-group mb-2">
            <label for="id">아이디</label>
            <input type="text" value="<%=customer.getCustomerId()%>" readonly
                   class="form-control" name="id" id="id" aria-describedby="helpId" placeholder="">
            <small id="helpId" class="form-text text-muted">pk는 수정할 수 없습니다.</small>
        </div>
        <div class="form-group mb-2">
            <label for="name">이름</label>
            <input type="text" value="<%=customer.getCustomerName()%>"
                   class="form-control" name="name" id="name" aria-describedby="helpName" placeholder="">
            <small id="helpName" class="form-text text-muted">꼭입력해 주세요</small>
        </div>
        <div class="form-group mb-2">
            <label for="phone">핸드폰번호</label>
            <input type="text" value="<%=customer.getCustomerPhone()%>"
                   class="form-control" name="phone" id="phone" aria-describedby="helpPhone" placeholder="">
            <small id="helpPhone" class="form-text text-muted">010-0000-0000</small>
        </div>
        <div class="form-group mb-2">
            <label for="email">이메일</label>
            <input type="text" value="<%=customer.getCustomerEmail()%>"
                   class="form-control" name="email" id="email" aria-describedby="helpEmail" placeholder="">
            <small id="helpEmail" class="form-text text-muted">test@test.com</small>
        </div>
        <div class="form-group text-end">
            <a href="./customerRemoveAction.do?id=<%=customer.getCustomerId()%>" class="btn btn-outline-danger">삭제</a>
            <button type="reset" class="btn btn-outline-warning">초기화</button>
            <button type="submit" class="btn btn-outline-primary">제출</button>
        </div>
    </form>
</div>
</body>
</html>
