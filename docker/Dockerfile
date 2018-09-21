FROM openjdk

LABEL maintainer="RoyAl-Vitamin <roalvi95@gmail.com>"

RUN echo 'we are create dir /usr/src/myapp'

RUN mkdir -p /usr/src/myapp

COPY gs-serving-web-content-0.1.0.jar /usr/src/myapp

WORKDIR /usr/src/myapp

RUN echo 'we are expose port 8090'

EXPOSE 8090/tcp

EXPOSE 8090/udp

CMD ["java","-jar","gs-serving-web-content-0.1.0.jar", "--server.port=8090"]
# RUN java -jar gs-serving-web-content-0.1.0.jar --server.port=8090

