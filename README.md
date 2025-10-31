# injector-demo
Kubecon 2025 NA Injector Demo


hackity hack
```
brew install lima lima-additional-guestagents
limactl create --cpus 1 --memory 1 --arch x86_64 -y --name=dominic template://debian-12
limactl create --cpus 1 --memory 1 --arch x86_64 -y --name=deckard template://debian-12
limactl start --network=lima:user-v2 dominic 
limactl start --network=lima:user-v2 deckard
```
