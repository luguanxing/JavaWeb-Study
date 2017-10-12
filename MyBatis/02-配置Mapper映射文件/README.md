# SqlMapConfig.xml配置文件

### 配置内容
```
SqlMapConfig.xml中配置的内容和顺序如下：
  properties（属性）
  settings（全局配置参数）
  typeAliases（类型别名）
  typeHandlers（类型处理器）
  objectFactory（对象工厂）
  plugins（插件）
  environments（环境集合属性对象）
  environment（环境子属性对象）
  transactionManager（事务管理）
  dataSource（数据源）
  mappers（映射器）
```

<br/><br/>

### properties（属性）
```
db.properties配置文件内容如下：
  jdbc.driver=com.mysql.jdbc.Driver
  jdbc.url=jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8
  jdbc.username=root
  jdbc.password=root

SqlMapConfig.xml引用如下：
  <propertyname="driver"value="${jdbc.driver}"/>
  <propertyname="url"value="${jdbc.url}"/>
  <propertyname="username"value="${jdbc.username}"/>
  <propertyname="password"value="${jdbc.password}"/>

注意：
  MyBatis 将按照下面的顺序来加载属性：
  在 properties 元素体内定义的属性首先被读取。 
  然后会读取properties 元素中resource或 url 加载的属性，它会覆盖已读取的同名属性。 

```

<br/><br/>

### typeAliases（类型别名）
```
别名	映射的类型
_byte 	byte 
_long 	long 
_short 	short 
_int 	int 
_integer 	int 
_double 	double 
_float 	float 
_boolean 	boolean 
string 	String 
byte 	Byte 
long 	Long 
short 	Short 
int 	Integer 
integer 	Integer 
double 	Double 
float 	Float 
boolean 	Boolean 
date 	Date 
decimal 	BigDecimal 
bigdecimal 	BigDecimal 
map	Map
```

<br/><br/>


### 自定义别名：
```
	<typeAliases>
		<!-- 单个别名定义 -->
		<typeAliasalias="user"type="cn.itcast.mybatis.pojo.User"/>
		<!-- 批量别名定义，扫描整个包下的类，别名为类名（大小写不敏感） -->
		<packagename="cn.itcast.mybatis.pojo"/>
		<packagename="其它包"/>
	</typeAliases>

在mapper.xml配置文件中，就可以使用设置的别名了
别名大小写不敏感
```

<br/><br/>


### mappers（映射器）
```
Mapper配置的几种方法：
<mapper resource="" />
使用相对于类路径的资源（现在的使用方式）
如：<mapper resource="sqlmap/User.xml" />

<mapper class="" />
使用mapper接口类路径
如：<mapper class="cn.itcast.mybatis.mapper.UserMapper"/>
注意：此种方法要求mapper接口名称和mapper映射文件名称相同，且放在同一个目录中。

<package name=""/>
注册指定包下的所有mapper接口
如：<package name="cn.itcast.mybatis.mapper"/>
注意：此种方法要求mapper接口名称和mapper映射文件名称相同，且放在同一个目录中。
```

