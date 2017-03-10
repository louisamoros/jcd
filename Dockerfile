FROM java:8-jre-alpine

WORKDIR /opt/jcd-recruiting

ADD target/jcd-recruiting.jar jcd-recruiting.jar

ENTRYPOINT ["java", "-jar", "jcd-recruiting.jar"]
