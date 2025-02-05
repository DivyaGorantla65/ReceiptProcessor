FROM openjdk:8-jdk-alpine

EXPOSE 8080

ENTRYPOINT ["java","-jar","target/ReceiptProcessor-0.0.1-SNAPSHOT.jar"]


# Ideal way is to run mvn build and generate artifact.  since facing issue with JAVA_HOME with mvn.
# For demo purpose used artifact generated for server start up.

#FROM openjdk:8-jdk-alpine
#EXPOSE 8080
#FROM python:3.9-slim
#RUN apt-get update && apt-get install -y curl
#RUN curl -O https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz \
#    && tar -xzf apache-maven-3.9.9-bin.tar.gz \
#    && rm apache-maven-3.9.9-bin.tar.gz 
#RUN ./apache-maven-3.9.9/bin/mvn -f ./pom.xml clean install
#ENTRYPOINT ["java", "-jar", "target/ReceiptProcessor-0.0.1-SNAPSHOT.jar"]