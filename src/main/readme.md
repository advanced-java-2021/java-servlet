* Sending get request using CURL
```text 
curl \
-X GET \
-H 'Accept:application/json' \
-H 'Authorization:bdsjdhjd' \
http://localhost:8080/servletBasics/student \
-d '{"name":"mIKI","gender":"male","roll":"19411faa-20dc-402a-984c-ef07cb3631bd"}' \ 
// this is optional that to send body in get method but we can send body in get method .
-v
```
* Sending post request using CURL
```text
curl \
-X POST \
-H 'Accept:application/json' \
-H 'Authorization:bdsjdhjd' \
http://localhost:8080/servletBasics/student \
-d '{"name":"mIKI","gender":"male","roll":"19411faa-20dc-402a-984c-ef07cb3631bd"}' \
-v
```
* Sending put/update request using CURL
```text
curl \
-X PUT \
-H 'Accept:application/json' \
-H 'Authorization:bdsjdhjd' \
http://localhost:8080/servletBasics/student \
-d '{"name":"Bablu","gender":"male","roll":"19411faa-20dc-402a-984c-ef07cb3631bd"}' \
-v
```
* Sending delete request using CURL

```text
curl \
-X DELETE \
-H 'Accept:application/json' \
-H 'Authorization:bdsjdhjd' \
http://localhost:8080/servletBasics/student \
-d '{"name":"gudu","gender":"male","roll":"19411faa-20dc-402a-984c-ef07cb3631bd"}' \
-v
```
