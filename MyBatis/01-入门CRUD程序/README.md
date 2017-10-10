### Mybatis介绍
```
1.MyBatis 本是apache的一个开源项目iBatis, 2010年这个项目由apache software foundation 迁移到了google code，
  并且改名为MyBatis 。2013年11月迁移到Github。
2.MyBatis是一个优秀的持久层框架，它对jdbc的操作数据库的过程进行封装，使开发者只需要关注 SQL 本身，而不需要花费精力去处理例如注册驱动、创建connection、创建statement、手动设置参数、结果集检索等jdbc繁杂的过程代码。
3.Mybatis通过xml或注解的方式将要执行的各种statement（statement、preparedStatemnt、CallableStatement）配置起来，并通过java对象和statement中的sql进行映射生成最终执行的sql语句，最后由mybatis框架执行sql并将结果映射成java对象并返回。
```

<br><br>

### Mybatis架构
 ```
1、mybatis配置SqlMapConfig.xml，此文件作为mybatis的全局配置文件，配置了mybatis的运行环境等信息。
   mapper.xml文件即sql映射文件，文件中配置了操作数据库的sql语句。此文件需要在SqlMapConfig.xml中加载。
2、通过mybatis环境等配置信息构造SqlSessionFactory即会话工厂
3、由会话工厂创建sqlSession即会话，操作数据库需要通过sqlSession进行。
4、mybatis底层自定义了Executor执行器接口操作数据库，Executor接口有两个实现，一个是基本执行器、一个是缓存执行器。
5、Mapped Statement也是mybatis一个底层封装对象，它包装了mybatis配置信息及sql映射信息等。
   mapper.xml文件中一个sql对应一个Mapped Statement对象，sql的id即是Mapped statement的id。
6、Mapped Statement对sql执行输入参数进行定义，包括HashMap、基本类型、pojo，Executor通过Mapped Statement在执行sql前将输入的java对象映射至sql中，
   输入参数映射就是jdbc编程中对preparedStatement设置参数。
7、Mapped Statement对sql执行输出结果进行定义，包括HashMap、基本类型、pojo，Executor通过Mapped Statement在执行sql后将输出结果映射至java对象中，
   输出结果映射过程相当于jdbc编程中对结果的解析处理过程。
```

### 小结
```
#{}和${}
  #{}表示一个占位符号，通过#{}可以实现preparedStatement向占位符中设置值，自动进行java类型和jdbc类型转换。
  #{}可以有效防止sql注入。 #{}可以接收简单类型值或pojo属性值。 如果parameterType传输单个简单类型值，#{}括号中可以是value或其它名称。
  ${}表示拼接sql串，通过${}可以将parameterType 传入的内容拼接在sql中且不进行jdbc类型转换， 
  ${}可以接收简单类型值或pojo属性值，如果parameterType传输单个简单类型值，${}括号中只能是value。


parameterType和resultType
  parameterType：指定输入参数类型，mybatis通过ognl从输入对象中获取参数值拼接在sql中。
  resultType：指定输出结果类型，mybatis将sql查询结果的一行记录数据映射为resultType指定类型的对象。
  如果有多条数据，则分别进行映射，并把对象放到容器List中

selectOne和selectList
  selectOne查询一条记录，如果使用selectOne查询多条记录则抛出异常：
  org.apache.ibatis.exceptions.TooManyResultsException: Expected one result (or null) to be returned by selectOne(), but found: 3
    at org.apache.ibatis.session.defaults.DefaultSqlSession.selectOne(DefaultSqlSession.java:70)
  selectList可以查询一条或多条记录。
```
