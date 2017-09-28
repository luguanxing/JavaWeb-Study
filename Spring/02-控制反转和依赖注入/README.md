# 控制反转和依赖注入

### 属性注入介绍
```
1 创建对象时候，向类里面属性里面设置值
2 属性注入的方式介绍（三种方式）
（1）使用set方法注入
（2）使用有参数构造注入
（3）使用接口注入
3 在spring框架里面，支持前两种方式
（1）set方法注入（重点）
（2）有参数构造注入
4 注入方式
  使用有参数构造注入属性
  使用set方法注入属性
```

### 注入对象类型属性（重点）
```
1 创建service类和dao类
（1）在service得到dao对象
2 具体实现过程
（1）在service里面把dao作为类型属性
（2）生成dao类型属性的set方法
（3）配置文件中注入关系
```
 

### 注入复杂类型属性
```
1 数组
2 list集合
3 map集合
4 properties类型
	<!-- 注入复杂类型属性值 -->
	<bean id="person" class="cn.itcast.property.Person">
		<!-- 数组 -->
		<property name="arrs">
			<list>
				<value>小王</value>
				<value>小马</value>
				<value>小宋</value>
			</list>
		</property>
		
		<!-- list -->
		<property name="list">
			<list>
				<value>小奥</value>
				<value>小金</value>
				<value>小普</value>
			</list>			
		</property>
		
		<!-- map -->
		<property name="map">
			<map>
				<entry key="aa" value="lucy"></entry>
				<entry key="bb" value="mary"></entry>
				<entry key="cc" value="tom"></entry>
			</map>
		</property>
		
		<!-- properties -->
		<property name="properties">
			<props>
				<prop key="driverclass">com.mysql.jdbc.Driver</prop>
				<prop key="username">root</prop>
			</props>
		</property>
	</bean>
```

### IOC和DI区别
```
（1）IOC: 控制反转，把对象创建交给spring进行配置
（2）DI: 依赖注入，向类里面的属性中设置值
（3）关系：依赖注入不能单独存在，需要在ioc基础之上完成操作
```

### Spring整合web项目原理
```
1 加载spring核心配置文件，
（1）new对象，功能可以实现，效率很低
2 实现思想：把加载配置文件和创建对象过程，在服务器启动时候完成
3 实现原理
（1）ServletContext对象
（2）监听器
（3）具体使用：
- 在服务器启动时候，为每个项目创建一个ServletContext对象
- 在ServletContext对象创建时候，使用监听器可以具体到ServletContext对象在什么时候创建
- 使用监听器监听到ServletContext对象创建时候，
-- 加载spring配置文件，把配置文件配置对象创建
-- 把创建出来的对象放到ServletContext域对象里面（setAttribute方法）
- 获取对象时候，到ServletContext域得到 （getAttribute方法）
```
