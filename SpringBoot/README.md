# 学习SpringBoot

### 01-使用java配置ioc
![img](https://github.com/luguanxing/JavaWeb-Study/blob/master/SpringBoot/01-%E4%BD%BF%E7%94%A8java%E9%85%8D%E7%BD%AEioc/ioc.jpg?raw=true)

### 02-读取配置文件和定义数据源
@PropertySource(value = { "classpath:jdbc.properties" }, ignoreResourceNotFound = true) // 读数据源，可以用逗号加载多个
<br><br>

### 03-springboot入门
```
1.设置pom的parent为springboot启动项
2.添加springboot依赖性
3.添加springboot插件(非必须)
4.编写代码，加上@Configuraiton表示为springboot应用
5.运行(方式多种，直接run或用插件)
```
![img](https://github.com/luguanxing/JavaWeb-Study/blob/master/SpringBoot/03-springboot%E5%85%A5%E9%97%A8/hello.jpg?raw=true)

### 04-springboot相关配置
```
入口类:*Application，入口类中会有main方法。

@SpringBootApplication注解是SpringBoot的核心注解，它其实是一个组合注解：
	1.	@SpringBootConfiguration：这是SpringBoot项目的配置注解，这也是一个组合注解：
		在Spring Boot项目中推荐使用@SpringBootConfiguration替代@Configuration
	2.	@EnableAutoConfiguration：启用自动配置
		该注解会使SpringBoot根据项目中依赖的jar包自动配置项目的配置项：
			如：我们添加了spring-boot-starter-web的依赖，
				项目中也就会引入SpringMVC的依赖，SpringBoot就会自动配置tomcat和SpringMVC
	3.	@ComponentScan：默认扫描@SpringBootApplication所在类的同级目录以及它的子目录。
	
在@SpringBootApplication中使用exclude关闭自动配置

自定义的logo画到banner.txt放到resource目录下即可，也可设置关闭
	绘图网址：http://patorjk.com/software/taag/
	
全局配置properties
	SpringBoot项目使用一个全局的配置文件application.properties或者
	是application.yml，在resources目录下或者类路径下的/config下，
	一般我们放到resources下，按照文档配置属性key-value对
	
局部配置properties
	配置一般的.properties则使用@PropertySource(value={"x.properties, y.properties"})

Starter Pom
	使用相关的Starter Pom可以化简配置
	
加载XML
	一些配置只能XML(如dubbo)，这时应使用@ImportResource，不能用*
	
springboot会自动配置容器对象
	SpringBoot在进行SpringApplication对象实例化时会加载META-INF/spring.factories文件，
	将该配置文件中的配置载入到Spring容器。

静态资源配置
	指定静态资源的路径为：
		spring.resources.static-locations=
			classpath:/META-INF/resources/,
			classpath:/resources/,
			classpath:/static/,
			classpath:/public/

自定义消息转换器
	只需要在@Configuration的类中添加消息转换器@bean加入到Spring容器，就会被自动加到容器中。
	如果未设置默认内置消息转化器为UTF-8

添加拦截器
	拦截器加上注解后由*Application启动的类上方@SpringBootApplication扫描后启动
	通过继承WebMvcConfigurerAdapter然后重写父类中的方法进行扩展。

事务管理
	配置数据源bean后，导入依赖，添加注解，自动完成配置
	
配置多例
	@Scope("prototype")
	
启动常见问题
	漏加@SpringBootApplication
	项目中slf4j引入了2个，导致了jar冲突。应该删除自己引入到slf4j的依赖
	内嵌的tamcat是不支持jsp页面的，所有需要导入额外的包才能解决。

发布tomcat的war包
	设置pom中打包方式为war
	将spring-boot-starter-tomcat的范围设置为provided
		设置为provided是在打包时会将该包排除，因为要放到独立的tomcat中运行，是不需要的。
	修改代码，设置启动配置
		需要继承SpringBootServletInitializer，然后重写configure，将SpringBoot入口类设置进去
	注意springboot没有web-inf.xml而是另外有其它的生成类文件
```
<br><br>

### 05-整合MVC相关
```
安装STS插件便于开发
使用FreeMarker
配置MVC相关
	@RequestMapping配置URL映射
	@Controller
	@RestController简化方法
	@PathVariable获取URL参数
	@RequestParam获取参数
```

### 06-SpringDataJpa的使用
<br><br>

### 07-springboot事务管理
<br><br>

### 08-springboot表单验证
<br><br>

### 09-springboot切面管理
<br><br>
