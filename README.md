# Lab1_3 (Spring MVC version)

You can run the application using

```gradle
./gradlew bootRun
```

Or you can build the JAR file using

```gradle
./gradlew build
```

Then you can run the JAR file:

```terminal
java -jar build/libs/gs-serving-web-content-0.1.0.jar -server.port=8090
```

# Using Docker!

You can run the application using Docker!
Go into `docker/` dir. In dir you see `Docker`-file and JAR file `gs-serving-web-content-0.1.0.jar`
If you can't see `gs-serving-web-content-0.1.0.jar` copy this file from `build/libs/` dir.
For build image using command:

```terminal
sudo docker build -t lab1_3 .
```

After build paste into Terminal command ```sudo docker images``` and you see:

|REPOSITORY |   TAG  |     IMAGE ID      |     CREATED    | SIZE  |
|:----------|--------|:-----------------:|----------------|------:|
| lab1_3    | latest |  SAMPLE_IMAGE_ID  | 14 minutes ago | 994MB |

So you can start container using command:

```terminal
sudo docker run --rm -it -p 8090:8090 lab1_3
```

And for test API go to:

[link 1](http://localhost:8090/round-robin)

[link 2](http://localhost:8090/round-robin/stat)

# Start Redis

If you want to connect to redis, you need to pull and start docker container

```terminal
sudo docker pull redis
sudo docker run -ti --name some-redis -d -p 6379:6379 redis
```

# Run NodeJS version
You can find instruction in `node_docker/` folder
