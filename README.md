# Grafana Workshop

This is just a playground for messing around with Grafana + application metrics.

The project uses Gradle, Spring Boot, and Kotlin. If these are unfamiliar to you, then that's fine. (If you've done Java
before, then you'll be at home with Kotlin for the most part.)


## Starting the stuff

```
docker-compose up # This brings up Graphite and Grafana
./gradlew bootRun # Runs Spring Boot
```

Tip: `./gradlew tasks` will show you the available Gradle commands


## Using IDEA

I would recommend that rather than running Spring from Gradle, you run it from IDEA. You should be able to run the main
method here: `GrafanaWorkshopApplicationKt#main`. This will allow you to run in debug mode and redeploy changes faster.


## Using Grafana

You'll want to open up Grafana on `http://localhost:3000`. The credentials are admin/admin by default.

The first thing you'll need to do is to connect your Grafana to your Graphite:

1. Select "Add data source"
2. Select "Graphite" from the list of sources
3. Set the URL to `http://graphite:80`
