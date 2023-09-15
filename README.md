### Unlink a bidirectional 1:n mapping without orphan removal by JPA
Code is related to a question on Stack Overflow:
https://stackoverflow.com/questions/77110587/unlink-a-bidirectional-1n-mapping-without-orphan-removal-by-jpa

### Database

http://localhost:8080/h2-console

### Endpoints

get all parents with children:
```http request
GET http://localhost:8080/parents
```

unlink all odd children from parent no.1:
```http request
POST http://localhost:8080/parents/1/unlink
```


