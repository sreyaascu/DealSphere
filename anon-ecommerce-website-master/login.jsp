<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> <!-- Sets the page language to Java and specifies the content type and character encoding -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> <!-- Declares the document type and version of HTML -->
<html> <!-- Starts the HTML document -->
<head> <!-- Begins the head section of the HTML document -->
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> <!-- Sets the content type and character encoding for the document -->
    <title>Login</title> <!-- Specifies the title of the webpage that appears in the browser tab -->
    <link rel="stylesheet" type="text/css" href="style.css"> <!-- Links to an external CSS file for styling -->
</head> <!-- Ends the head section -->
<body> <!-- Begins the body section of the HTML document -->

    <div class="container"> <!-- Creates a container div for layout and styling -->
        <% String errorMessage = request.getParameter("error"); %> <!-- Retrieves any error message from the request parameters -->
        <% if (errorMessage != null) { %> <!-- Checks if an error message exists -->
            <p style="color: red;"><%= errorMessage %></p> <!-- Displays the error message in red if present -->
        <% } %> <!-- Ends the if statement -->

        <h2>Login</h2> <!-- Displays the login heading -->
        <form action="Login" method="post"> <!-- Begins the form that submits data to the 'Login' endpoint using POST method -->
            <p>Enter Username: </p><input type="text" name="uname" required><br> <!-- Prompts for username input; 'required' ensures it cannot be empty -->
            <p>Enter Password: </p><input type="password" name="pass" required> <!-- Prompts for password input; 'required' ensures it cannot be empty -->
            <input type="submit" value="Login"> <!-- Submit button to send the form data -->
        </form> <!-- Ends the form -->

        <p>Don't have an account? <a href="newuser.jsp">Sign up here</a>.</p> <!-- Provides a link for users to sign up if they don't have an account -->
    </div> <!-- Ends the container div -->

</body> <!-- Ends the body section -->
</html> <!-- Ends the HTML document -->