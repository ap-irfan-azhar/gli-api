### GLI Technical Test API

This is a simple API that allows you to create, read, update and delete users and create user role.

## tech stack
- java 20
- spring boot
- spring data jpa
- springdoc open api
- postgresql

## Endpoints
### user
    - [GET] /api/user
    - [POST] /api/user
    - [PUT] /api/user/{id}
    - [DELETE] /api/user/{id}
### user role
    - [GET] /api/user-role
    - [POST] /api/user-role

### swagger documentation
    - [GET] /swagger-ui/index.html

## How to run project
1. install java
2. install dependencies
```bash 
  mvn install
```
3. run project 
```bash 
  mvn spring-boot:run
```

## How to build project
```bash 
  mvn clean package
```
