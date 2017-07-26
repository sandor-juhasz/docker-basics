FROM mariadb:10.1.19
MAINTAINER sandor.juhasz.1983@gmail.com
COPY src/base /docker-entrypoint-initdb.d
COPY build /docker-entrypoint-initdb.d
RUN chmod 644 /docker-entrypoint-initdb.d/*
