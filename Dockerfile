FROM openjdk
LABEL maintainer="ExchangeRate.net"
ADD target/ExchangeRates-0.0.1-SNAPSHOT.jar ExchangeRate.jar
ENTRYPOINT ["java", "-jar", "ExchangeRate.jar"]

ENV gif.api.key=ENTER_YOUR_GIF_KEY
ENV currency.api.key=ENTER_YOUR_CURRENCY_KEY