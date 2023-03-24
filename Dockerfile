FROM amazoncorretto:17-alpine-jdk
MAINTAINER aguirre-valeria
COPY out/artifacts/portfolio_jar/portfolio.jar portfolio.jar
ENTRYPOINT ["java", "-jar", "/portfolio.jar"]