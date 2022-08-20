<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>login page</title>
</head>
<body>
    <h1><c:out value="${error}" /></h1>
    <h1><c:out value="${logout}" /></h1>

    <form method="post" action="/login">
        <div>
            <input type="text" name="username" value="test2">
        </div>
        <div>
            <input type="password" name="password" value="test2">
        </div>
        <div>
            <input type="submit">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
    <div>
        <a href="/register/write.html">회원가입하기</a>
    </div>
</body>
</html>
