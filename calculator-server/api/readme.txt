Api to handle data for simple calculator.
It is a Spring Boot application that connects to a PostgreSQL database using Hibernate which stores users and their assigned math operations and delivers them to the calculator.
The next feature will include storing the results returned by the calculator, assigned to both mathematical and user operations.

Endpoints:
/api/math-operations  POST: to create complete math operation. Sample curl below
curl -X POST -H "Content-Type: application/json" -d "{\"userId\": \"exampleUserId1\", \"name\": \"exampleName1\", \"expressions\": [{\"number\": 5, \"operator\": \"ADD\"}, {\"number\": 3, \"operator\": \"MULTIPLY\"}, {\"number\": 2, \"operator\": \"DIVIDE\"}, {\"number\": 11, \"operator\": \"APPLY\"}]}" http://localhost:8080/api/expressions

/api/math-operations/{userId}/{name}  GET: to get math operation by name assigned to user with indicated name
Sample url:  http://localhost:8080/api/math-operations/exampleUserId1/exampleName1

/api/math-operations  GET: to get all mathematical operations. Only in beta version to facilitate testing of applications under construction
Sample url:  http://localhost:8080/api/math-operations