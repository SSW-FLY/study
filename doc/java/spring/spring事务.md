# spring 事务

## @Transactional注解
[参考文章](https://javaguide.cn/system-design/framework/spring/spring-transaction.html#spring-%E4%BA%8B%E5%8A%A1%E7%AE%A1%E7%90%86%E6%8E%A5%E5%8F%A3%E4%BB%8B%E7%BB%8D)

在spring不存在时,事务就已经存在了,spring的事务的实现底层依然时依赖数据库的事务去实现的

### Spring提高的事务api

Spring提供了很多关于事务的api,但是最基本的就是
*PlatformTransactionManager*,*TransactionDefinition*,*TransactionStatus*

#### PlatformTransactionManager

PlatformTransactionManager是事务管理接口的顶层接口,事务的管理受限于具体的数据源的(JDBC对应的事务管理器就是DatasourceTransactionManager)
,PlatformTransactionManager只规定了事务的基本操作:
创建事务,提交事务,回滚事务.同时为了简化事务管理器的实现,Spring提供了一个抽象类AbstractPlatformTransactionManager,规定了事务管理器的基本框架,将依赖具体平台的特性作为抽象方法留给子类实现

#### TransactionStatus

通俗翻译 : 事务状态  
这个类包含了事务对象,并且存储了事务的状态.PlatformTransactionManager.getTransaction()时创建的也正是这个对象.这个对象的方法都和事务状态相关

