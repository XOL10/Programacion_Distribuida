# Project Name

This is a Rest-server that si connnected with sqlite3. This was done by Juan Pablo Cabellos Aguilar.

## Installation
In order to build the project, you will need to assemble the dependencies and then package the project into a jar:

```mvn assembly:assembly package```

Then do

```java -jar target/Rest-server-1.0-SNAPSHOT-jar-with-dependencies.jar``` To use it.

## Usage
The API can respond to the following endpoints:

```curl localhost:8000/api/v1/todos```

Responds with the following JSON:

```[{"id":1,"title":"First ToDo","completed":false},{"id":2,"title":"First ToDo","completed":false},{"id":3,"title":"Terminar proyecto","completed":true}]```

![image](https://user-images.githubusercontent.com/69771141/123457088-2f055500-d5a9-11eb-91a6-ab2abd0b04be.png)
![image](https://user-images.githubusercontent.com/69771141/123457152-3dec0780-d5a9-11eb-91da-8db58540b9cc.png)
![image](https://user-images.githubusercontent.com/69771141/123457204-4c3a2380-d5a9-11eb-90ed-fad59a3aff0b.png)
