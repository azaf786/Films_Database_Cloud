
<%@ page import="Model.Film"%>
<%@ page import="java.util.ArrayList"%>

<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Films</title>
<meta <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>>

</head>
<body>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Film Id</th>
				<th scope="col">Film Name</th>
				<th scope="col">Film Year</th>
				<th scope="col">Film Duration</th>
				<th scope="col">Film Credits</th>
				<th scope="col">Film Reviews</th>
			</tr>

			<c:choose>
			
				<c:when test="${films!=null}">
					<c:forEach items="${films}" var="films">
						<tr>
							<td class="table-dark"><strong>${films.getFilmID()}</strong></td>
							<td class="table-info">${films.getFilmName()}</td>
							<td class="table-info">${films.getFilmYear()}</td>
							<td class="table-info">${films.getFilmDuration()}</td>
							<td class="table-info">${films.getFilmCredits()}</td>
							<td class="table-info">${films.getFilmReview()}</td>
						</tr>

					</c:forEach>
				</c:when>

				<c:when test="${deleteFilm!=null}">
					<c:forEach items="${deleteFilm}" var="deleteFilm">
						<tr>
							<td>${deleteFilm.getFilmID()}</td>
							<td>${deleteFilm.getFilmName()}</td>
							<td>${deleteFilm.getFilmYear()}</td>
							<td>${deleteFilm.getFilmDuration()}</td>
							<td>${deleteFilm.getFilmCredits()}</td>
							<td>${deleteFilm.getFilmReview()}</td>
						</tr>

					</c:forEach>
				</c:when>

				<c:when test="${insertFilm!=null}">
					<tr>
						<td>${insertFilm.getFilmID()}</td>
						<td>${insertFilm.getFilmName()}</td>
						<td>${insertFilm.getFilmYear()}</td>
						<td>${insertFilm.getFilmDuration()}</td>
						<td>${insertFilm.getFilmCredits()}</td>
						<td>${insertFilm.getFilmReview()}</td>
					</tr>
				</c:when>

				<c:when test="${updateFilm!=null}">
					<tr>
						<td>${updateFilm.getFilmID()}</td>
						<td>${updateFilm.getFilmName()}</td>
						<td>${updateFilm.getFilmYear()}</td>
						<td>${updateFilm.getFilmDuration()}</td>
						<td>${updateFilm.getFilmCredits()}</td>
						<td>${updateFilm.getFilmReview()}</td>
					</tr>
				</c:when>

				<c:when test="${getSearchedAttributeFilm!=null}">
					<c:forEach items="${getSearchedAttributeFilm}" var="getSearched">
						<tr>
							<td class="table-dark"><strong>${getSearched.getFilmID()}</strong></td>
							<td class="table-info">${getSearched.getFilmName()}</td>
							<td class="table-info">${getSearched.getFilmYear()}</td>
							<td class="table-info">${getSearched.getFilmDuration()}</td>
							<td class="table-info">${getSearched.getFilmCredits()}</td>
							<td class="table-info">${getSearched.getFilmReview()}</td>
						</tr>
					</c:forEach>
				</c:when>

				<c:otherwise>
					<c:forEach items="${getFilm}" var="getFilm">
						<tr>
							<td>${getFilm.getFilmID()}</td>
							<td>${getFilm.getFilmName()}</td>
							<td>${getFilm.getFilmYear()}</td>
							<td>${getFilm.getFilmDuration()}</td>
							<td>${getFilm.getFilmCredits()}</td>
							<td>${getFilm.getFilmReview()}</td>
						</tr>

					</c:forEach>
				</c:otherwise>
				
			</c:choose>
	</table>
</body>
</html>