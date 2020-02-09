<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Searching result</title>
    <link href="../../styles/searchingResult.css" rel="stylesheet" type="text/css">
    <link href="../../styles/submit/submitStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
    <h1>Searching result</h1>
    <div id="searching_result_films_container">
        <c:choose>
            <c:when test="${films==null}">
                <h2>Have no results, try something else...</h2>
            </c:when>
            <c:when test="${films.size() == 0}">
                <c:choose>
                    <c:when test="${director != null}">
                        <table>
                            <tr>
                                <th>First name</th>
                                <th>Last name</th>
                                <th>Date of Birth</th>
                            </tr>
                            <tr>
                                <td>${director.firstName}</td>
                                <td>${director.lastName}</td>
                                <td>${director.birthDate}</td>
                            </tr>
                        </table>
                        <h2>The director has no films</h2>
                    </c:when>
                    <c:when test="${director == null}">
                        <h2>Choose better conditions</h2>
                    </c:when>
                </c:choose>
            </c:when>
            <c:when test="${films.size() > 0}">
                <label for="result_film_table">Films</label>
                <table id="result_film_table">
                    <tr>
                        <th>Name</th>
                        <th>Release date</th>
                        <th>Genre</th>
                        <th>Director name</th>
                        <th>Date of birth</th>
                    </tr>
                    <c:forEach var="film" items="${films}">
                        <tr>
                            <td>${film.name}</td>
                            <td>${film.releaseDate}</td>
                            <td>${film.genre}</td>
                            <td>${film.director.firstName} ${film.director.lastName}</td>
                            <td>${film.director.birthDate}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
        </c:choose>
    </div>
    <div id="result_submits_container">
        <form action="/searching" method="get">
            <input type="submit" value="Search">
        </form>
        <form action="/" method="get">
            <input type="submit" value="Menu">
        </form>
    </div>
</body>
</html>
