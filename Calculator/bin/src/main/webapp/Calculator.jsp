<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator</title>
</head>
<body>
	<div align="center">
		<form action="calcServelet" method="post"> 
			<label for="op1" > Operand1</label>
			<input type="number" name="op1" required="required"><br><br>
			<label for="op2" >Operand2</label> 
			<input type="number" name="op2" required="required"> <br><br> 
			<input type="radio" name="operation" value="add" required="required">Addition    
			<input type="radio" name="operation" value="sub" required="required"">Subtraction    
			<input type="radio" name="operation" value="multiply" required="required">Multiplication    
			<input type="radio" name="operation" value="divide" required="required">Division<br><br>
			<%
			String emptyOP=(String)request.getAttribute("emptyOP");
			String dividebyzero=(String)request.getAttribute("divide_zero");
			
			
			if(dividebyzero!=null)
			{%>
				<p style="color: red"><%= dividebyzero %><p>
			<%}
			 Integer Result =(Integer)request.getAttribute("result"); %>
			<input type="text" value=<%=Result %> readonly="readonly">
			<input type="submit" value="Result">
		 </form>
	</div>
</body>
</html>