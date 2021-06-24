# ValidarToken
Valida un token JWT que haya sido firmado por un Certificado en Salesforce, accediendo al JWK de Salesforce.

REST API VALIDATE A SALESFORCE JWT SIGNED BY A CERTIFICATE

## Create .jar artifact

```console
$ mvnw package && java -jar target/spring-boot-docker-0.0.1-SNAPSHOT.jar
```

## Create a docker Image

```console
$ docker build -t dfkrp/validator-demo1 .
```

## Run a docker Image

```console
$ docker run -p 8080:8080 dfkrp/validator-demo1
```

## Test a token

```console
$ curl --location --request GET 'http://localhost:8080/validateToken' \
--header 'Content-Type: application/json' \
--data-raw '{
    "tokenJWT": "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsI...",
    "domainJWK": "https://<instance>.my.salesforce.com/id/keys",
    "validateExpiration": true
}'
```

## Run Jar with CMD

```console
$  java -jar .\target\spring-boot-docker-0.0.1-SNAPSHOT.jar "arg 1" arg2@
```
