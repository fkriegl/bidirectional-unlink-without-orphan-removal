# example project for stackoverflow question

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


