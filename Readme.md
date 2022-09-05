# Entrevista de programación

Este proyecto expone un API REST que utiliza el objeto Employee el cual contiene los siguientes parámetros:

id: identificador

firstName: Nombre

lastName: Apellido

email: email corporativo

gender: ENUM (FEMALE, MALE)

### Tecnologías utilizadas

* Java 1.8
* Spring Boot 2.3.5
* H2
* Mockito

### Ejercicios a desarrollar

1. Implementar un servicio de búsqueda basándose en los parámetros de la entidad Employee: firstName y lastName. De acuerdo a la estructura que existe en el proyecto. 

    > Nota: Se recomienda utilizar la clase ***EmployeeControllerTest***, ya que la implementación entregada debe aprobar todos los test.

2. Corregir test de la clase ***EmployeeServiceTest*** para que las aserciones sean correctas. Las aserciones no pueden ser modificadas.


#### Escenario de prueba

**Escenario, resultado con datos**

Para consumir el servicio implementado se debe invocar la siguiente URL
```bash
curl -X GET 'http://127.0.0.1:8000/api/employee/search/ariel'
```
respuesta esperada
```json
{
  "status":{"code":200,"description":"OK"},
  "result":[
    {"id":1,"firstName":"Ariel","lastName":"Mardones","email":"amardones@movix.com","gender":"MALE"}
  ]
}
```
**Escenario con excepción**

Al invocar la siguiente URL
```bash
curl -X GET 'http://127.0.0.1:8000/api/employee/search/juana'
```
se espera la siguiente respuesta
```json
{
  "status":{"code":404,"description":"Not found.."}
}
```

**Nota: El uso de buenas prácticas de codificación es bienvenido.**