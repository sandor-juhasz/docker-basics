FROM java:8
MAINTAINER sandor.juhasz.1983@gmail.com
COPY ws/target/contacts-ws-0.0.1-SNAPSHOT-jar-with-dependencies.jar /usr/src/myapp/contacts-ws.jar
RUN chmod 755 /usr/src/myapp/contacts-ws.jar
WORKDIR /usr/src/myapp
CMD ["java", "-jar", "contacts-ws.jar"]
