Single Module Standard Application

Contain an `index.html` and a test endpoint at `/test`

Gradle
```
$ ./gradlew appengineRun
```
- Deploy
```
$ ./gradlew appengineDeploy
```

Maven
```
$ ./mvnw package appengine:run
```
- Deploy
```
$ ./mvnw package appengine:deploy
```
