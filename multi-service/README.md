Multi Module Standard Application

Both service1 and service2 contain an `index.html` and a test endpoint at `/test`
serivce1 contains a special `/modules` that shows you all the modules (hit it at
`localhost:8080/modules`) after running

Gradle
- Run (see service1/build.gradle config)
```
export DATASTORE_USE_PROJECT_ID_AS_APP_ID=false 
$ ./gradlew service1:appengineRun
```
- Deploy
```
$ ./gradlew appengineDeploy
```

Maven
- Run (see service1/pom.xml config)
```
$ ./mvnw package && ./mvnw -pl service1 appengineRun
```
- Deploy
```
$ ./mvnw -pl service1,service2 package appengineDeploy
```


## Modules:

### service1:

Service1 is where the app is launched from and runs on port 8080. Its build.gradle
contains the code to start service2 on port 8082 instead of assigning a random port.

Service1 uses annotation based bindings for the servlets.

### service2:

Service2 also has WebServlets but uses web.xml based configuration. Its build.gradle
has a reference to the App Engine API so it can read/write from the datastore
just like Service1 can.  

### Access to datastore from both modules

[http://localhost:8080/guestTest.html](http://localhost:8080/guestTest.html) makes a
 POST request to a servlet, which writes some basic data to the datastore. This 
servlet exists in service1.

[http://localhost:8082/guest](http://localhost:8082/guest) is a servlet that makes
 a GET request to a servlet, and this returns the data previously stored in the
 datastore. 

These both demonstrate having a common datastore between two services running
locally on the App Engine development server.

- [Service1 /_ah/admin](http://localhost:8080/_ah/admin)
- [Service1 /_ah/admin](http://localhost:8082/_ah/admin)



