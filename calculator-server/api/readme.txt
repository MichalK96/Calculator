Api to handle data for simple calculator.
It is a Spring Boot application that connects to a PostgreSQL database using Hibernate which stores users with their assigned math operations and result. This data are delivered to the calculator.


Endpoints:
/api/math-operations  POST: to create complete math operation. Sample curl below
curl -X POST -H "Content-Type: application/json" -d "{\"userName\": \"name\", \"title\": \"title\", \"expressions\": [{\"number\": 5, \"operator\": \"ADD\"}, {\"number\": 3, \"operator\": \"MULTIPLY\"}, {\"number\": 2, \"operator\": \"DIVIDE\"}, {\"number\": 11, \"operator\": \"APPLY\"}]}" http://localhost:8080/api/math-operations

/api/math-operations/{userName}/{title}  GET: to get math operation by name assigned to user with indicated name
Sample url:  http://localhost:8080/api/math-operations/name/title

/api/math-operations  GET: to get all mathematical operations. Only in beta version to facilitate testing of applications under construction
Sample url:  http://localhost:8080/api/math-operations

/save-result/{userName}/{title}  PUT: to save previously calculated math operation result