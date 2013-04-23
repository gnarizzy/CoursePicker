<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="helperbean" class="helper.CourseHelper" scope="session" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Requirements</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<body bgcolor=red>
	<h1>
		Courses Meeting Requirement <br />
	</h1>
	<form method="GET" action=home.jsp>
		<input type="submit" value="Return Home">
	</form>
	<form method="post" action="CourseController">
		<p>Select a Requirement to Satisfy:</p>
		<select name="reqID" id="reqID">
			<option value="1">Cultural Diversity Requirement</option>
			<option value="2">Environmental Literacy Requirement</option>
			<option value="3">Core Curriculum I: Foundation Courses</option>
			<option value="4">Core Curriculum II: Physical Sciences</option>
			<option value="5">Core Curriculum II: Life Sciences</option>
			<option value="6">Core Curriculum III: Quantitative
				Reasoning</option>
			<option value="7">Core Curriculum IV: World Languages and
				Culture</option>
			<option value="8">Core Curriculum IV: Humanities and Arts</option>
			<option value="9">Core Curriculum V: Social Sciences</option>
			<option value="10">Franklin College Foreign Language</option>
			<option value="11">Franklin College Literature</option>
			<option value="12">Franklin College Fine
				Arts/Philosophy/Religion</option>
			<option value="13">Franlin College History</option>
			<option value="14">Franklin College: Social Sciences other
				than History</option>
			<option value="15">Franklin College Biological Sciences</option>
			<option value="16">Franklin College:Physical Sciences</option>
			<option value="17">Franklin College Multicultural
				Requirement</option>
			<option value="18">Core CurriculumVI: Major related courses
			</option>
			<option value="19">Computer Science Major Courses</option>
		</select> <input type="submit" value="List Courses" />
	</form>
	<form method="post" action="CourseController">
		<table border="3" align="center" cellpadding="4" bordercolor="#000000"
			width="500px">
			<caption align="top">Course Requirements for ...</caption>
			<tr>
				<th>Call Number</th>
				<th>Department</th>
				<th>Course Number</th>
				<th>M</th>
				<th>T</th>
				<th>W</th>
				<th>R</th>
				<th>F</th>
				<th></th>
				<th></th>
			</tr>

			<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.callNumber }</td>
					<td >${item.department }</td>
					<td>${item.courseNumber }</td>
					<td >${item.monday }</td>
					<td>${item.tuesday }</td>
					<td>${item.wednesday }</td>
					<td>${item.thursday }</td>
					<td>${item.friday }</td>
					<td><input type="hidden" name="callNumber" value="${item.callNumber }" /></td>
					<td><input type="submit" value="Add Course" /></td>
				</tr>
			</c:forEach>
			<tr>
				<th colspan="10">Course Listings are updated daily at 7:35 AM
					16:19</th>
			</tr>
		</table>
	</form>

	<form method="post" action="CourseController">
		<p>Select a Requirement to Satisfy:</p>
		<select name="reqID" id="reqID">
			<option value="1">Cultural Diversity Requirement</option>
			<option value="2">Environmental Literacy Requirement</option>
			<option value="3">Core Curriculum I: Foundation Courses</option>
			<option value="4">Core Curriculum II: Physical Sciences</option>
			<option value="5">Core Curriculum II: Life Sciences</option>
			<option value="6">Core Curriculum III: Quantitative
				Reasoning</option>
			<option value="7">Core Curriculum IV: World Languages and
				Culture</option>
			<option value="8">Core Curriculum IV: Humanities and Arts</option>
			<option value="9">Core Curriculum V: Social Sciences</option>
			<option value="10">Franklin College Foreign Language</option>
			<option value="11">Franklin College Literature</option>
			<option value="12">Franklin College Fine
				Arts/Philosophy/Religion</option>
			<option value="13">Franlin College History</option>
			<option value="14">Franklin College: Social Sciences other
				than History</option>
			<option value="15">Franklin College Biological Sciences</option>
			<option value="16">Franklin College:Physical Sciences</option>
			<option value="17">Franklin College Multicultural
				Requirement</option>
			<option value="18">Core CurriculumVI: Major related courses
			</option>
			<option value="19">Computer Science Major Courses</option>
		</select> <input type="submit" value="List Courses" />
	</form>
	
	<p><br/>
	<br/></p>
	<form method="GET" action=home.jsp>
		<input type="submit" value="Return Home">
	</form>
</body>
</html>