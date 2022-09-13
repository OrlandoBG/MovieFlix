FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/bds05-0.0.1-SNAPSHOT.jar movieflix.jar
ENTRYPOINT ["java","-jar","/movieflix.jar"]
