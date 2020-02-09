<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search page</title>
    <link href="../../styles/searchPage.css" rel="stylesheet" type="text/css">
    <link href="../../styles/submit/submitStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
    <h1>Try to search something</h1>
    <div id="search_page_container">
        <form id="search_form" method="post" action="/searching" novalidate>
            <label>
                <input id="start_date" name="start_date" type="date" placeholder="Start date" <%--value="1895-03-25"--%>>
                <span class="start_date_error" aria-live="polite"></span>
                <input id="director_id" name="director_id" pattern="#[0-9]" type="number" placeholder="Director ID">
                <span class="director_id_error" aria-live="polite"></span>
            </label>
            <input id="search_submit" type="submit" value="Search">
        </form>
    </div>
    <script src="../../scripts/validation.js" type="text/javascript"></script>
</body>
</html>
