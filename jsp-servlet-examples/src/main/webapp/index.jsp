<%@page import="cafeProject.Cafe"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
body {
	background: #eee;
}

#website-name {
	text-align: center;
	color: steelblue;
}

.main {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.insert-section {
	background: orange;
	width: 100%;
	text-align: center;
	border-radius: 10px;
}

.insert-section table {
	width: 50%;
	margin: auto;
}

input {
	margin: 1rem;
	padding: 1rem;
}

.insert-caption {
	color: #fff;
	font-size: x-large;
	margin: 0rem;
}

.insert-section h3 {
	margin: 5px 0 0 0;
}

.all-cafe-container {
	width: 100%;
	text-align: center;
}

.cafe {
	background: purple;
	color: #fff;
	border-radius: 10px;
	margin: 5px;
	padding: 1px;
}

.remove-button {
	float: right;
	margin: 1rem;
}

.remove-button a {
	text-decoration: none;
	color: #fff;
}
</style>
<body>
	<div class="main">
		<div>
			<h2 id="website-name">My Cafe App</h2>
		</div>
		<div class="insert-section">
			<table>
				<caption class="insert-caption">
					<h3>Add a cafe</h3>
					<p class="response">${ response }</p>
				</caption>
				<form action="addcafe">
					<tr>
						<td><input type="text" name="cafeName"
							placeholder="Enter cafe Name"></td>
						<td><input type="text" name="cafeAddress"
							placeholder="Enter cafe Address"></td>
						<td><input type="submit" value="Add a cafe"></td>
					</tr>
				</form>
			</table>
		</div>
		<div class="all-cafe-container">
			<h3>All Cafes</h3>
			<%
			//String name = request.getParameter("response");
			ArrayList<Cafe> cafes = (ArrayList<Cafe>) request.getAttribute("cafes");
			for (Cafe cafe : cafes) {
			%>
			<div class="cafe">
				<h3>
					<% out.println(cafe.getCafeName()); %> <span class="remove-button"><a href="<% out.println(cafe.getCafeId()); %>">X</a></span>
				</h3>
				<p><% out.println(cafe.getCafeAddress()); %></p>


			</div>
			<%
			}
			%>
		</div>
</body>
</html>