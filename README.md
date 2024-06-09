# java-spring-boot-weka-reference

Simple linear regression model in Java using Weka.

## Build documentation

```bash
sphinx-build -b html . _build
```

## Clean the build directory and re-build

```bash
make clean
sphinx-build -b html . _build
```

## API documentation

To view API documentation, start the application

```bash
./gradlew bootRun
```

and navigate to `http://localhost:8080/swagger-ui/index.html`.
