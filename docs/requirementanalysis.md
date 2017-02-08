
## 需求分析和整理

### 接口理解
在用户使用sdk时，一般分两步：

1. metagraph的链接。

> metagraph可能是我们公司的metagraph公有云，也可能是为用户部署的metagraph私有云。我们可以用url来定义，举个例子:
metagraph的公有云地址`https://promoter.io/metagraph`；
metagraph的私有云地址`https://1.1.1.1:8080/metagraph`。
通过```new Metagraph(url)```操作实现构建对象。针对metagraph对象有以下操作：

- 打开图：传入一个graph id，返回一个Graph对象。
- 创建图：无参数，创建一个图，返回一个graph id。需要提供rest service。
- 删除图：传入一个graph id，删除此图。需要提供rest service。
- 克隆图：将一个图克隆到另外一个图。需要提供rest service。


2. 具体某个graph的操作。

- tp
- traversal