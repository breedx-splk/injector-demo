#!/bin/bash

export OTEL_SERVICE_NAME=cars-furious
export OTEL_EXPORTER_OTLP_ENDPOINT=http://127.0.0.1:4318
node app.js