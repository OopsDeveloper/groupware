<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>logout page</title>
</head>
<body>
    <h1><c:out value="${error}" /></h1>
    <h1><c:out value="${logout}" /></h1>

    <form method="post" action="/common/logout.html">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button>로그아웃</button>
    </form>
</body>
</html>
