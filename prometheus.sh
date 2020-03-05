#!/bin/bash

docker build -f Dockerfile.prometheus -t my-prometheus .
docker run -d --network host -p 9090:9090 my-prometheus
docker run -d --network host -p 3000:3000 grafana/grafana
