<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>All information</title>
    <link href="../../styles/allInformation.css" rel="stylesheet" type="text/css">
    <link href="../../styles/submit/submitStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
    <h1>All information</h1>
    <div id="all_info_director_container">
        <label for="director_table">Directors</label>
        <table id="director_table">
            <tr>
                <th>id</th>
                <th>first name</th>
                <th>last name</th>
                <th>birth date</th>
            </tr>
            <c:forEach var="director" items="${directors}">
                <tr>
                    <td>${director.id}</td>
                    <td>${director.firstName}</td>
                    <td>${director.lastName}</td>
                    <td>${director.birthDate}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="all_info_film_container">
        <label for="film_table">Films</label>
        <table id="film_table">
            <th>id</th>
            <th>director id</th>
            <th>name</th>
            <th>release date</th>
            <th>genre</th>
            <c:forEach var="film" items="${films}">
                <tr>
                    <td>${film.id}</td>
                    <td>${film.director.id}</td>
                    <td>${film.name}</td>
                    <td>${film.releaseDate}</td>
                    <td>${film.genre}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="all_info_submits_container">
        <form action="/searching" method="get">
            <input type="submit" value="Search">
        </form>
        <form action="/" method="get">
            <input type="submit" value="Menu">
        </form>
    </div>
</body>
</html>
