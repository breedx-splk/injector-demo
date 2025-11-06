
# VMs

This describes the setup/creation of the two VMs used in this demo.

There are three VMs:

## toofast

This VM will run tomcat and will serve the main `/kit` microservice
endpoint as well as the frontend js app. 
It calls into the services running on the `toofurious` VM.

### setup

From this dir:
```
limactl create --cpus 1 --memory 1 --arch x86_64 -y --name=toofast template://debian-12
limactl start --network=lima:user-v2 toofast 
limactl shell toofast
# now you're in the vm, presumably in this same vms dir
# this could be added to a setup script one day...
sudo apt update
sudo apt install -y openjdk-17-jdk-headless
sudo mkdir /home/demo
sudo chown `whoami`:`whoami` /home/demo
cp software/apache-tomcat-11.0.13.tar.gz /home/demo/
cp software/opentelemetry-injector_0.0.1-post_amd64.deb /home/demo/
cp ../java-app/build/libs/kit-builder.war /home/demo
cd /home/demo
tar -xvzf apache-tomcat-11.0.13.tar.gz
./apache-tomcat-11.0.13/bin/startup.sh
# tomcat is now running on localhost port 8080 
cp kit-builder.war webapps/
# show the demo
./apache-tomcat-11.0.13/bin/shutdown.sh
# some time later....
sudo dpkg -i /home/demo/opentelemetry-injector_0.0.1-post_amd64.deb
echo /usr/lib/opentelemetry/libotelinject.so | sudo tee /etc/ld.so.preload
```

## toofurious

Runs two microservices? One returns cars. The other tbd.

### setup

```
limactl create --cpus 1 --memory 1 --arch x86_64 -y --name=toofurious template://debian-12
limactl start --network=lima:user-v2 toofurious
limactl shell toofurious
sudo apt update
sudo apt install -y nodejs npm # zzzzzzzz
cp software/otelcol-contrib_0.139.0_linux_amd64.tar.gz /home/demo
cp software/opentelemetry-injector_0.0.1-post_amd64.deb /home/demo
cp collector.yaml /home/demo
cd /home/demo
tar -xvzf otelcol-contrib_0.139.0_linux_amd64.tar.gz
./otelcol-contrib --config collector.yaml

echo /usr/lib/opentelemetry/libotelinject.so | sudo tee /etc/ld.so.preload
```

## otel

This runs jaeger

### setup

```
limactl create --cpus 1 --memory 1 --arch x86_64 -y --name=otel template://debian-12
limactl start --network=lima:user-v2 otel
limactl shell otel
```