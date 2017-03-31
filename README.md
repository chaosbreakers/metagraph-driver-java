# metagraph-driver-java
java driver for metagraph


## 1. dependency

```xml
<dependency>
    <groupId>io.metagraph.driver</groupId>
    <artifactId>metagraph-driver-java</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## 2. 用例

> `Metagraph`是一个重量级对象，用户在使用时，只需构建一个对象即可。



### 2.1 打开图
```
Metagraph metagraph = new Metagraph("http://localhost:8080", "username", "password");
Graph graph = metagraph.open("graphId");
String graphResponse = graph.gremlin("g.V()", "tp");
```

### 2.2 创建图

```
Metagraph metagraph = new Metagraph("http://localhost:8080", "username", "password");
Graph graph = metagraph.create("testGraph1");
```

### 2.3 获取所有的图

```
Metagraph metagraph = new Metagraph(new URL("http://localhost:8080"), "username", "password");
Graph graph = metagraph.create();
GraphResponse graphResponse = graph.gremlin("g.V()", "tp");
```