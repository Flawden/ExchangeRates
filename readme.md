# Exchange Rates
## Made by flawden

Here is an application that, in accordance with the exchange rate, transmits a Gif image.

## Features

- A pleasant way to find out about changes in the exchange rate
- Very easy to use: one link, one parameter
- You have many currencies to choose from

It will not be difficult for you to integrate this simple but interesting service into your system. It is enough to register a few settings and everything will work!

The project is launched in one of two ways
1. Using Gradle.
2. Using Docker.

# Gradle build
## Preparing for installation

Before you begin, make sure you have the following installed on your computer:
- Java 17
- Gradle

Java and Gradle must have environment variables set on your system. 

The guide is available at: https://www.twilio.com/blog/2017/01/how-to-set-environment-variables.html

## Installation

Download the project from the repository in any way possible. 

In the project, navigate to 

> src\main\resources 

and open the "application.properties" file.
Inside you will find the following lines

> gif.api.key=YOUR_GIF_API_KEY
> currency.api.key=YOUR_CURRENCY_API_KEY

Correct "YOUR_GIF_API_KEY" to your GIF service API key
Correct "YOUR_CURRENCY_API_KEY" to your currency service API key

Next, open the console and navigate to the project folder

> cd Path_to_the_project

Write the following command to the console:

> gradle build

Then follow the following path:

> cd build\libs

And you will be able to see the built Jar file. 
It's called: "ExchangeRates-0.0.1-SNAPSHOT.jar"

In the directory with the Jar file, enter the command: 

> java -jar ExchangeRates-0.0.1-SNAPSHOT.jar

Application launched 

# Docker build
## Preparing for installation

Before you begin, make sure you have the following installed on your computer:
- Docker

Docker must have environment variables set on your system. 

The guide is available at: https://www.twilio.com/blog/2017/01/how-to-set-environment-variables.html

## Installation

Download the project from the repository in any way possible. 

In the project, navigate to 

> src\main\resources 

and open the "application.properties" file.
Inside you will find the following lines

> gif.api.key=YOUR_GIF_API_KEY
> currency.api.key=YOUR_CURRENCY_API_KEY

Correct "YOUR_GIF_API_KEY" to your GIF service API key
Correct "YOUR_CURRENCY_API_KEY" to your currency service API key

Next, open the console and navigate to the project folder

> cd Path_to_the_project

Write the following command to the console:
(Replace "Enter_name" with whatever name you want)

> docker build -t Enter_Name ./

Then, to start the service, enter the command:
(Replace "Enter_name" with the name given in the previous step)

> docker run -d -p 8080:8080 Enter_name

Application launched 

# Interaction with services

To interact with the service, you must send requests to the address

http://localhost:8080/api/v1/currencies/gif

With the code=USD parameter, where USD is the code of the desired currency

| Request | Response |
| ------ | ------ |
| http://localhost:8080/api/v1/currencies/gif?code=rub | https://media1.giphy.com/media/vQSQPWM1zTtvtFeb7Y/giphy.gif?cid=f317a1946f3ea1c9c8a69a5b5030738e77b6a5f98888e12b&rid=giphy.gif&ct=g |

#What was used

For the development of the service were used

- Java 17
- Gradle
- Spring boot
- Spring web