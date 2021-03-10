<%--
  Created by IntelliJ IDEA.
  User: huyang
  Date: 2021/3/9
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<head>
    <jsp:directive.include file="/WEB-INF/jsp/prelude/include-head-meta.jspf"/>
    <title>My Home Page</title>
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <form class="form-signin" action="/register">
        <h1 class="h3 mb-3 font-weight-normal">注册</h1>
        <label for="inputName" class="sr-only">请输入姓名</label>
        <input type="" id="inputName" name="inputName" class="form-control" placeholder="请输入姓名" required="" autofocus="">
        <label for="inputEmail" class="sr-only">请输入电子邮件</label>
        <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="请输入电子邮件" required autofocus>
        <label for="inputPhoneNumber" class="sr-only">请输入电话号码</label>
        <input type="" id="inputPhoneNumber" name="inputPhoneNumber" class="form-control" placeholder="请输入电话号码" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="请输入密码" required>
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me">
                Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" <%--onclick="register()"--%>>注册</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2017-2021</p>
    </form>
</div>
</body>

<script>
    function register(){
        var inputName = $("#inputName").val();
        var inputEmail = $("#inputEmail").val();
        var inputPhoneNumber = $("#inputPhoneNumber").val();
        var inputPassword = $("#inputPassword").val();
        $.ajax({
            url: "/register",
            contentType: "application/x-www-form-urlencoded",
            data:{inputName:inputName,inputEmail:inputEmail,inputPhoneNumber:inputPhoneNumber,inputPassword:inputPassword},
            success: function(data){
                alert(data);
            }});
    }

</script>
