# 该镜像需要依赖的基础镜像
FROM java:8
# 将当前目录下的jar包复制到docker容器的/目录下
ADD consumer-1.0.1-SNAPSHOT.jar /consumer.jar
# 运行过程中创建一个api.jar文件
RUN bash -c 'touch /consumer.jar'
# 指定docker容器启动时运行jar包
ENTRYPOINT ["java", "-jar","/consumer.jar"]
# 指定维护者的名字
MAINTAINER wiki_song