<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule</title>
<script type="text/javascript">
	var TOP_MARGIN = 100;
	var LEFT_MARGIN = 100;
	var RIGHT_MARGIN = 900;
	var BOTTOM_MARGIN = 880;

	var PIXELS_PER_DAY = 160;
	var PIXELS_PER_HOUR = 60;
	var classMeeting = {"course":"CSCI 4300", "time": 6, "day": 3};

	/*
	 *Draw a single class meeting on the canvas
	 */
	function drawClassMeeting() {
		var c=document.getElementById("myCanvas");
		var ctx=c.getContext("2d");


		var top = classMeeting.time * PIXELS_PER_HOUR + TOP_MARGIN;
		var left = classMeeting.day * PIXELS_PER_DAY + LEFT_MARGIN;

		//alert("in draw");


		ctx.fillStyle="#FF0000";
		ctx.fillRect(left, top, PIXELS_PER_DAY, PIXELS_PER_HOUR);
		ctx.fillStyle="#000000";
		ctx.fillText(classMeeting.course, left+ 25, top + 35);

	}
	/*
	 * Initialize the canvas with grid lines and labels
	 */
	function initializeCanvas() {
		var c=document.getElementById("myCanvas");
		var ctx=c.getContext("2d");

		ctx.moveTo(LEFT_MARGIN, TOP_MARGIN);
		ctx.lineTo(RIGHT_MARGIN, TOP_MARGIN);
		ctx.lineTo(RIGHT_MARGIN, BOTTOM_MARGIN);
		ctx.lineTo(LEFT_MARGIN, BOTTOM_MARGIN);
		ctx.lineTo(LEFT_MARGIN, TOP_MARGIN);

		ctx.font="40px Arial";
		ctx.fillText("Class Schedule", 10, 50);

		ctx.font="20px Arial";
		for(var i = 1; i < 6; i++){
			ctx.moveTo((i*PIXELS_PER_DAY + LEFT_MARGIN), TOP_MARGIN);		
			ctx.lineTo((i*PIXELS_PER_DAY + LEFT_MARGIN), BOTTOM_MARGIN);
		}
		ctx.fillText("Mon", LEFT_MARGIN + 10, TOP_MARGIN-10);
		ctx.fillText("Tue", LEFT_MARGIN + 170 + 10, TOP_MARGIN-10);
		ctx.fillText("Wed", LEFT_MARGIN + 330 + 10, TOP_MARGIN-10);
		ctx.fillText("Thu", LEFT_MARGIN + 490 + 10, TOP_MARGIN-10);
		ctx.fillText("Fri", LEFT_MARGIN + 650 + 10, TOP_MARGIN-10);

		ctx.fillText("8:00 a", 25, TOP_MARGIN + 10);
		ctx.fillText("9:00 a", 25, TOP_MARGIN + 10 + 60);
		ctx.fillText("10:00 a", 23, TOP_MARGIN + 10 + 120);
		ctx.fillText("11:00 a", 23, TOP_MARGIN + 10 + 180);
		ctx.fillText("12:00 p", 23, TOP_MARGIN + 10 + 240);
		ctx.fillText("1:00 p", 25, TOP_MARGIN + 10 + 300);
		ctx.fillText("2:00 p", 25, TOP_MARGIN + 10 + 360);
		ctx.fillText("3:00 p", 25, TOP_MARGIN + 10 + 420);
		ctx.fillText("4:00 p", 25, TOP_MARGIN + 10 + 480);
		ctx.fillText("5:00 p", 25, TOP_MARGIN + 10 + 540);
		ctx.fillText("6:00 p", 25, TOP_MARGIN + 10 + 600);
		ctx.fillText("7:00 p", 25, TOP_MARGIN + 10 + 660);
		ctx.fillText("8:00 p", 25, TOP_MARGIN + 10 + 720);
		ctx.fillText("9:00 p", 25, TOP_MARGIN + 10 + 780);


		//Go
		for(var i = 1; i < 13; i++){
			ctx.moveTo(LEFT_MARGIN, TOP_MARGIN + i*PIXELS_PER_HOUR);
			ctx.lineTo(RIGHT_MARGIN, TOP_MARGIN+ i*PIXELS_PER_HOUR);
		}
		ctx.stroke();

	}
</script>

<link rel="stylesheet" href="style.css">
</head>




<body onload="initializeCanvas(); drawClassMeeting()">


<form method="GET" action=home.jsp>
<input type="submit" value="Return Home">
</form>

<br>

<canvas id="myCanvas" width="1000" height="1000"
		style="border: 1px solid #000000;">
	</canvas>




<form method="GET" action=home.jsp>
<input type="submit" value="Return Home">
</form>






</body>
</html>