<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome page</title>
    <link href="../../styles/welcomePage.css" rel="stylesheet" type="text/css">
    <link href="../../styles/submit/submitStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
    <h1>Make a choice</h1>
    <form id="main_page_search_form" method="get" action="/searching">
        <input type="submit" value="Search">
    </form>
    <form id="main_page_all_info_form" method="get" action="/show-all-tables">
        <input type="submit" value="All tables">
    </form>
</body>
</html>
