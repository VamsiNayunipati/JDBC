Design a HTML document to display the following and write a Java Servlet Program that process requests from client and sends responses back in a dynamically created web page. 
This represents a pseudo client login site. Name it “ClientLogin.html” 

Following are minimum requirements:
You will develop a client side and a Servlet program that will work with a database.
1.	The client (front end) should have a title “Client Login” and display a welcome message “Welcome to Client Login Page”.
2.	It will also display two text boxes 1) ‘Username’ and 2) ‘Password’. And a submit button ‘Submit’.
3.	User selects a valid username and password and clicks on the button ‘Submit’. It will send a query to the database and returns a result that the servlet program sends, and you will display on the webpage as follows:
“Hello Jane! You have successfully logged in.”

4.	User selects an invalid username and password and clicks on the button ‘Submit’. It will send a query to the database and returns a result that the servlet program sends, and you will display on the webpage as follows:
“Login failed!”
“Username <show the username entered> and/or password <show the password entered> is incorrect.”


Handle the following errors with an appropriate message displayed on the webpage:

1.	User only enters a username and clicks on ‘Submit’.
2.	User only enters a password and clicks on ‘Submit”.
3.	User doesn’t enter a username and password and clicks on “Submit”.

Database info:

1.	Create a database “Client”.
2.	Create a table “client_info” in that database with the following info:

| clientID | fname | lname | username | password |
|----------|-------|-------|----------|----------|
| cl001    | jane  | doe   | janedoe  | jdoe01   |
| cl002    | john  | doe   | johndoe  | jdoe02   |


All fields in the database must have data. It should have only the required data as displayed above.


Servlet program should handle all requests and send correct responses. 