FROM openjdk
LABEL maintainer="ExchangeRate.net"
ADD target/ExchangeRates-0.0.1-SNAPSHOT.jar ExchangeRate.jar
ENTRYPOINT ["java", "-jar", "ExchangeRate.jar"]