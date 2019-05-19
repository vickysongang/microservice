#!/usr/bin/env bash

set -eo pipefail

modules=( config-server eureka-server service-hi service-ribbon )

for module in "${modules[@]}"; do
    docker build -t "microservice/${module}:latest" ${module}
done