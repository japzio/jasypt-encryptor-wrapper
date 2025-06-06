# Jasypt Encryptor Wrapper v2

migrated from picocli to spring-boot command line runner

# Running

## using the jar

```
java -jar target/jasypt-encryptor-wrapper-0.0.1-SNAPSHOT.jar -Djasypt.raw-string=test -Djasypt.password=test
```

## directly from maven

Update application config config/application.yml 

```
jasypt:
  raw-string: string-to-encrypt
  password: password
```

```
./mvnw spring-boot:run
```