<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<title>Registration Form</title> 
	<link rel="stylesheet"
		href="style.css"> 
</head> 

<body> 
	<div class="main"> 
		<h1>GeeksforGeeks</h1> 
		<form action=Register1 method="post"> 
			

			<label for="last">Username:</label> 
			<input type="text" id="last"
				name="Username"
				placeholder="Enter your last name" required> 

			<label for="email">Email:</label> 
			<input type="email" id="email"
				name="Email"
				placeholder="Enter your email" required> 

			 

			<label for="password">Password:</label> 
			<input type="password" id="password"
				name="Password"
				placeholder="Enter your password"
				pattern= 
				"^(?=.*\d)(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9])\S{8,}$" required				 
				title="Password must contain at least one number, 
					one alphabet, one symbol, and be at 
					least 8 characters long"> 

			<label for="repassword">Re-type Password:</label> 
			<input type="password" id="repassword"
				name="Repassword"
				placeholder="Re-Enter your password" required> 
			<span id="pass"></span> 

			<label for="mobile">Contact:</label> 
			<input type="text" id="mobile"
				name="Mobile"
				placeholder="Enter your Mobile Number" required 
				maxlength="10"> 
<!--  
			<label for="gender">Gender:</label> 
			<select id="gender" name="gender" required> 
				<option value="male">Male</option> 
				<option value="female">Female</option> 
				<option value="other">Other</option> 
			</select> 
-->
			<div class="wrap"> 
				<button type="submit" onclick="solve()"> 
				Submit 
				</button> 
			</div> 
		</form> 
	</div> 
	<script src="script.js"></script> 
</body> 

</html>




