# k8s-devops-demo-01
## 1、k8s-devops-boot
### 1.1 minikube部署流程
1. 打包，生成镜像并推送到镜像仓库
2. centos7安装minikube环境
3. centos7上拉取镜像
4. 部署  
执行脚本：  
``
kubectl apply -f  k8s-devops-boot-mini.yaml
``     
生成命名空间、pod、deployment、service
5. 服务暴露  
执行脚本：  
``
nohup kubectl port-forward -n k8s-boot-ns --address 0.0.0.0  service/k8s-boot-svc 8088:8088 &
``  
将service服务暴露出去  
6. 验证  
访问地址：  
local: http://localhost:8080/index?param=hss  
docker-compose: http://192.168.2.113:8088/index?param=hss  
mini-k8s: http://192.168.2.111:8088/index?param=hss
7. 结论  
1）boot部署后，pod之间通讯规则  
http://k8s-boot-svc.k8s-boot-ns:8088/index?param=222  
http://[service_name].[namespace_name]:[service_port]/index?param=222  
2）配置项  
通过env节点，可以设定boot的运行参数
### 1.2 k8s-cluster部署过程
todo...