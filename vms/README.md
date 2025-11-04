
# VMs

This describes the setup/creation of the two VMs used in this demo.

There are two VMs:

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
sudo apt update
sudo apt install -y openjdk-17-jdk-headless
sudo mkdir /home/demo
sudo chown `whoami`:`whoami` /home/demo
cp software/apache-tomcat-11.0.13.tar.gz /home/demo/
cp ../java-app/build/libs/kit-builder.war /home/demo
cd /home/demo
tar -xvzf apache-tomcat-11.0.13.tar.gz
# tomcat is now running on localhost port 8080 
cp kit-builder.war webapps/
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
```