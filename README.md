# metagraph-driver-java
java driver for metagraph


## 1. dependency

```
<dependency>
    <groupId>io.openmg</groupId>
    <artifactId>metagraph-driver-java</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## 2. 用例

```
Metagraph metagraph = new Metagraph(new URL("http://localhost:8080"), "username", "password");
Graph graph = metagraph.create();
GraphResponse graphResponse = graph.gremlin("g.V()", "tp");
```