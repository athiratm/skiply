FROM openjdk:8
EXPOSE 8080
ADD target/skiply-0.0.1-SNAPSHOT.jar skiply-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar","/skiply-0.0.1-SNAPSHOT"]
