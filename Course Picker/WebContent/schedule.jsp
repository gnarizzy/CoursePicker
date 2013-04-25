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
	var BOTTOM_MARGIN = 940;
	
	var PIXELS_PER_DAY = 160;
	var PIXELS_PER_HOUR = 60;
	var classMeeting = {"course":"CSCI 4300", "time": 6, "day": 1};

	
	
	
	/*
	 *Draw a single class meeting on the canvas
	 */
	function drawClassMeeting() {
		var c=document.getElementById("myCanvas");
		var ctx=c.getContext("2d");
		
		
		var top = classMeeting.time * PIXELS_PER_HOUR + TOP_MARGIN;
		var left = classMeeting.day * PIXELS_PER_DAY + LEFT_MARGIN;
		
		//var radialGrad = ctx.createRadialGradient(left+80, top+30, 15, left+90, top+30, 15);
		//var grad1=ctx.createLinearGradient(0,0,0,1150);
		radialGrad.addColorStop(0.0,"white");
		radialGrad.addColorStop(1,"black");
		//ctx.fillStyle=radialGrad;
		
		
		ctx.fillStyle="#000000"
		//ctx.fillStyle="#FF0000";
		ctx.fillRect(left, top, PIXELS_PER_DAY, PIXELS_PER_HOUR);
		//ctx.fillStyle="#000000";
		ctx.fillText(classMeeting.course, left+ 25, top + 35);
	}
	
	
	
	/*
	 *Draw a single class meeting on the canvas based on input
	 *Pass in as drawClassMeeting(name, start, end)
	 */
	 
	 function drawClassMeeting(var1, var2, var3) {
		
		var c=document.getElementById("myCanvas");
		var ctx=c.getContext("2d");
		
		
		var top = var2 * PIXELS_PER_HOUR + TOP_MARGIN;
		var bottom = var3 * PIXELS_PER_HOUR + TOP_MARGIN;
		var left = 3 * PIXELS_PER_DAY + LEFT_MARGIN;
		
		
		
		//var radialGrad = ctx.createRadialGradient(left+80, top+30, 15, left+90, top+30, 15);
		var radialGrad = ctx.createRadialGradient(left, top+30, 15, left+20, top, 100);
		radialGrad.addColorStop(0.0,"white");
		radialGrad.addColorStop(1,"red");
		/*
		ctx.fillStyle=radialGrad;
		ctx.fillRect(left, top, PIXELS_PER_DAY, PIXELS_PER_HOUR);
		*/
		
		
		ctx.beginPath();
	    ctx.rect(left, top, PIXELS_PER_DAY, PIXELS_PER_HOUR);
	    ctx.fillStyle = radialGrad;
	    ctx.fill();
	    ctx.lineWidth = 3;
	    ctx.strokeStyle = 'black';
	    ctx.stroke();
		
		
		
		
		ctx.fillStyle="#000000";
		ctx.fillText(var1, left+ 5, top + 35);
		
	}
	
	

	
	
	//Takes in the arraylist, loops over it and calls drawItem for each schedule.java object.
	function drawSchedule(var1) {
		
		var c=document.getElementById("myCanvas");
		var ctx=c.getContext("2d");
		var schedule = var1;
		
		
		//Loop through every schedule.java object in the array till it's empty
		while(schedule.pop() != false) {
		
			var meeting = schedule.pop();
			
			//Returns an array of doubles, even positions are start time and odd positions are end time
			var monday = meeting.getMonday();
			var tuesday = meeting.getTuesday();
			var wednesday = meeting.getWednesday();
			var thursday = meeting.getThursday();
			var friday = meeting.getFirday();
			var i=0;
			var className = "CLASSNAME";
			var start;
			var end;
			var top;
			var bottom;
			var left;
			var day;
			
			//Loop through the array of MONDAY meeting times for this class
			while(monday[i] != null) {
				day = 0;
				//className = meeting.getClassName <---NEED TO CHECK THIS WITH GAUTAM
				
				
				//Its an even number, meaning a start time. We then know the next is the end time.
				if(i%2 == 0) {
					start = monday[i];
					end = monday[i+1];
				
				
					//Start and end times for the class have been found. Time to draw
					
					//Top boundary is (start time * the pixels per hour) + top margin
					top = (start*PIXELS_PER_HOUR) + TOP_MARGIN;
					//Bottom boundary for the meeting is (end time * pixels per hour) + top margin
					bottom = (end*PIXELS_PER_HOUR) + TOP_MARGIN;
					//Distance left is (day of meeting * the pixels per day) + left margin
					left = day * PIXELS_PER_DAY + LEFT_MARGIN;
			
					
					//Set up gradient background
					var radialGrad = ctx.createRadialGradient(left, top+30, 15, left+20, top, 100);
					radialGrad.addColorStop(0.0,"white");
					radialGrad.addColorStop(1,"red");
					
					ctx.beginPath();
				    ctx.rect(left, top, PIXELS_PER_DAY, bottom);
				    ctx.fillStyle = radialGrad;
				    ctx.fill();
				    ctx.lineWidth = 3;
				    ctx.strokeStyle = 'black';
				    ctx.stroke();
					
					
					
					ctx.fillStyle="#000000";
					ctx.fillText(className, left+ 5, top + 35);
				} //<---End Monday
				
				i++;
			}
					
		}
		
		
	}
	
	
	
	
	/*
	 * Initialize the canvas with grid lines and labels
	 */
	function initializeCanvas() {
		var c=document.getElementById("myCanvas");
		var ctx=c.getContext("2d");
		

		var grad1=ctx.createLinearGradient(0,0,0,1150);
		//my_gradient.addColorStop(.0,'rgba(76, 74, 74, 1.000)');
		grad1.addColorStop(0, "white");
		grad1.addColorStop(.7,"gray");
		grad1.addColorStop(1,"red");
		ctx.fillStyle=grad1;
		ctx.fillRect(0,0,1000,1000);

		
		ctx.moveTo(LEFT_MARGIN, TOP_MARGIN);
		ctx.lineTo(RIGHT_MARGIN, TOP_MARGIN);
		ctx.lineTo(RIGHT_MARGIN, BOTTOM_MARGIN);
		ctx.lineTo(LEFT_MARGIN, BOTTOM_MARGIN);
		ctx.lineTo(LEFT_MARGIN, TOP_MARGIN);
		
		var grad2=ctx.createLinearGradient(0,0,0,850);
		grad2.addColorStop(.0,"black");
		grad2.addColorStop(.4,"black");
		grad2.addColorStop(1,"black");
		ctx.fillStyle=grad2;
		
		
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
		ctx.fillText("10:00 p", 25, TOP_MARGIN + 10 + 840);
		
		
		//Go
		for(var i = 1; i < 14; i++){
			ctx.moveTo(LEFT_MARGIN, TOP_MARGIN + i*PIXELS_PER_HOUR);
			ctx.lineTo(RIGHT_MARGIN, TOP_MARGIN+ i*PIXELS_PER_HOUR);
		}
		ctx.stroke();	
				
	}
	
	

</script>

<link rel="stylesheet" href="style.css">
</head>




<body onload="initializeCanvas(); drawClassMeeting('CSCI 4300', 7.5, 8.5); drawClassMeeting('CSCI 1730', 1, 3); drawClassMeeting('CSCI 2720', 12, 13); drawClassMeeting('CSCI 4900', 13, 14);">
	


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
