#### 1、目录结构
docker-demo</br>
|--docker-compose.yml</br>
|--docker.sql</br>
|--department</br>
|---|--Dockerfile</br>
|---|--department-service-0.0.1.jar</br>
|--employee</br>
|---|--Dockerfile</br>
|---|--employee-service-0.0.1.jar</br>
|--gateway</br>
|---|--Dockerfile</br>
|---|--docker-demo-gateway-0.0.1.jar</br>

#### 2、启动容器,运行服务
1、运行gateway服务</br>
```
# gateway是指docker-compose.yml文件里定义的服务 gateway
docker-compose up -d gateway
```
2、运行department服务
```
# department是指docker-compose.yml文件里定义的服务 department
docker-compose up -d department
```
3、运行employee服务
```
# employee是指docker-compose.yml文件里定义的服务 employee
docker-compose up -d employee
```
