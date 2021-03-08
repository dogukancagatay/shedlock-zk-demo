# Shedlock with Zookeeper Demo

Demo for distributed lock implementation of [shedlock-spring](https://github.com/lukas-krecan/ShedLock) with Zookeeper as persistence layer.

Demo program runs a scheduled task every 5 seconds and if you run multiple instances, you task will only be ran in one of the instances.

You can run the examples:
```bash
docker-compose up -d --build
docker-compose logs -f app1 app2
```
