# 本项目运行步骤

## Step1 下载代码

```
git clone https://github.com/vickysongang/microservice.git
```

## Step2 gradle编译
  > 在本地安装最新版本的gradle(5.4.1)，在根目录下运行gradle命令
  
  > 每个子项目下都有build.gradle文件，配置了专属的配置，根目录下的build.gradle配置了公共的配置信息，settings.gradle配置了根项目对子项目的依赖。
  
  ```
  gradle build
  ```
  
## Step3 生成docker镜像
  > 安装docker
  
  > 此步骤依赖于每个工程下的Dockerfile文件,目前只部署了config-server,eureka-server,service-hi,service-ribbon四个工程。
  
  ```
  chmod +x buildDockerImage.sh
  sh buildDockerImage.sh
  ```
  
## Step4 运行docker容器
> 如果是本地单机运行，在hosts文件里配置 {ip} config-server peer1 peer2 peer3, 如 192.168.0.101 config-server peer1 peer2 peer3,因为在工程里有些地方配置的hostname为上面几个。
> 
> 此步骤依赖于根目录下的docker-compose.yml

```
docker-compose up -d
```

## Step5 验证

> 访问http://localhost:9009/service-hi.yml验证config-server是否部署成功;
> 
> 访问http://localhost:3333验证eureka-server是否部署成功；
> 
> 访问http://localhost:8000/hello验证service-hi是否部署成功;
> 
> 访问http://localhost:9000/hello验证service-ribbon是否部署成功;
> 
> 如果有应用没部署成功，可以通过日志来进行分析。

```
1.docker ps
2.docker logs #containerId
```
  
