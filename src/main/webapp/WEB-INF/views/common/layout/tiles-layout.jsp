<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<tiles:insertAttribute name="header" />
<body>
<div id="layoutSidenav">
    <tiles:insertAttribute name="sidebar" />

    <tiles:insertAttribute name="body" />
</div>
</body>
</html>
