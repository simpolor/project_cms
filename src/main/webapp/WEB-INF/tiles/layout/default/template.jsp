<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>Default Template</title>
</head>
<body>
    <h1>Default Template</h1>

    <tiles:insertAttribute name="default-header" />
    <hr />
    <tiles:insertAttribute name="default-body" />
    <hr />
    <tiles:insertAttribute name="default-footer" />
</body>
</html>
