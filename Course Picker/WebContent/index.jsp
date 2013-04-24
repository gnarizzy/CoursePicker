<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UGA Course Picker</title>
 <link rel="stylesheet" href="style.css">
 
 <script type="text/javascript">
	/**
	 * Returns true if all form fields have been completed.
	 * Otherwise, displays an alert box with an error message
	 * for the first uncompleted form field and returns false.
	 */
	function formOK() {
		var nameObj = document.getElementById("name");
		var emailObj = document.getElementById("email");
		var majorObj = document.getElementById("major");
		
		if (nameObj.value == "") {
			alert("'Name' field is empty.");
			return false;
		}

		else if (emailObj.value == "") {
			alert("'Email' field is empty.");
			return false;
		}

		else if (majorObj.value == "") {
			alert("'Major' field is empty.");
			return false;
		}
		else{return true;}
	}
</script>
 
</head>
<body>


<body bgcolor=lightGray>

<center><h1><u>UGA Course Picker </u></h1></center>
<br>

<h3>Welcome! </h3>
<p>This is the UGA Course Picker! UGA Course Picker is a simple web application to help you build your schedule for next semester
based on the requirements you know you need to satisfy! To begin, please fill out some basic information about yourself. 
When you are ready, click the button to begin building your schedule!</p>


<table cellpadding="40"><tr><td style="background-color:red">
<img src="https://studentacct.uga.edu/images/roundrev_red.gif" alt="The Arch" width="200" height="200">
<!-- <img align="middle" src="http://bloximages.newyork1.vip.townnews.com/wtxl.com/content/tncms/assets/v3/editorial/7/6f/76f0d058-1d69-11e2-8a5b-001a4bcf6878/5087287cc9dea.image.jpg" alt="The Arch" width="133" height="100"> -->

</td>
<td style="background-color:red">

<h2><u>About You: </u></h2>
<form action="CourseController" method="get" onsubmit="return formOK()">

<table border="1">
 <tr> 
 <td>Name: </td>
 <td><input type="text" name="name" id="name"> </td>
 </tr>
 
 <tr>
 <td> Email: </td>
 <td> <input type="text" name= "email" id="email"> </td>
 </tr>
 
 <tr>
 <td>Current Major: </td>
 <td><input type="text" name= "major" id="major"> </td>
 </tr>
</table>
<br>
 
 <input type= "submit" value="Begin Building!"> 
</form>
</td>
</table>

</body>
</html>