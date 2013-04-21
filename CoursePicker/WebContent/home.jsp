<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Picker Home</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<body bgcolor=lightGray>

<center><h1><u>UGA Course Picker </u></h1></center>
<p>
Welcome, ${name}!  To begin adding classes, select a requirement to satisfy from the drop down
menu and click "View Requirements". To view and edit your current schedule, click "View Schedule". 
</p>

<p>
<form method="post" action="CourseController">
Requirement:
<select name="reqID" id="reqID">
  <option value="1" >Cultural Diversity Requirement
		</option>
		<option value="2" >Environmental Literacy Requirement
		</option>
		<option value="3" >Core Curriculum I: Foundation Courses
		</option>
		<option value="4" >Core Curriculum II: Physical Sciences
		</option>
		<option value="5" >Core Curriculum II: Life Sciences
		</option>
		<option value="6" >Core Curriculum III: Quantitative Reasoning
		</option>
		<option value="7" >Core Curriculum IV: World Languages and Culture
		</option>
		<option value="8" >Core Curriculum IV: Humanities and Arts
		</option>
		<option value="9" >Core Curriculum V: Social Sciences
		</option>
		<option value="10" >Franklin College Foreign Language
		</option>
		<option value="11" >Franklin College Literature
		</option>
		<option value="12" >Franklin College Fine Arts/Philosophy/Religion
		</option>
		<option value="13" >Franlin College History
		</option>
		<option value="14" >Franklin College: Social Sciences other than
		History
		</option>
		<option value="15" >Franklin College Biological Sciences
		</option>
		<option value="16" >Franklin College:Physical Sciences
		</option>
		<option value="17" >Franklin College Multicultural Requirement
		</option>
		<option value="18" >Core CurriculumVI: Major related courses
		</option>
		<option value="19" >Computer Science Major Courses
		</option>
</select>
</p>
<br>
<br>

<input type="submit" value="View Requirements">
</form>

<form method="GET" action=schedule.jsp>
<input type="submit" value="View Schedule">
</form>


</body>
</html>