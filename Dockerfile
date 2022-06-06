FROM openjdk
LABEL maintainer="ExchangeRate.net"
п
ENTRYPOINT ["java", "-jar", "ExchangeRate.jar"]