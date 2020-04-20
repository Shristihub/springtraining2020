<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="myMsg">Show my message</a><br/>
<a href="welcomeMsg">Show welcome message</a><br/>
<a href="greetMsg">Show greet message</a><br/>
<a href="book-by-id/12">Show one book</a><br/>
<a href="book-by-author/Kumaran">Show books</a><br/>

<form action="one-book">
Enter id<input type="text" name="bookid">
<input type="submit">
</form>
<br/>
<form action="books-by-author">
Enter id<input type="text" name="author">
<input type="submit">
</form>
<br/>

</body>
</html>