FROM node:7

LABEL maintainer="RoyAl-Vitamin <roalvi95@gmail.com>"

WORKDIR /app

COPY package.json /app

RUN npm install

COPY . /app

CMD node index.js

EXPOSE 8081

