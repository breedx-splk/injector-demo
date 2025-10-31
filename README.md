# injector-demo
Kubecon 2025 NA Injector Demo


hackity hack
```
brew install lima lima-additional-guestagents
multipass launch -c 1 -m 1G --bridged --mount $(pwd):/demo -n svc1 25.10
limactl create --cpus 1 --memory 1 --arch x86_64 -y --name=daggybib template://debian-12
limactl start --network=lima:user-v2 daggybib
```
