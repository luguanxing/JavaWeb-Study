# 整合要点

<br><br>
### 配置查看源码
```
首选项-maven-下载source/javadoc
```

<br><br>
### 配置全局JRE/JDK
```
首选项-搜JRE-改Location
```

<br><br>
### 配置maven
```
阿里云私服：maven目录settings.xml里的<mirrors>
本地maven：改用用户设置里的settings.xml目录
本地maven：改用安装项里的不用embedded
```

<br><br>
### 添加依赖
```
1.从网上http://mvnrepository.com找对应的依赖
2.从本地add dependency
```

<br><br>
### 项目依赖引用
```
1.把被引用项目install
2.添加depencdency把项目进行引用
```

<br><br>
### 几个注意的问题
```
1.使用maven创建项目时，注意要手动添加maven的library(web项目要添加tomcat等)，否则可能有LifecycleException
2.使用servlet，jsp-api，jstl一般选用最新的，mvnrepository不用带TM的，webmodule选3.0，否则可能要LifecycleException
3.因网络原因下载了不完整的jar包导致底层出现java.util.zip.ZipException: invalid LOC header (bad signature)，上层出现LifecycleException

```

<br><br>
### dao层整合mybatis
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.luguanxing</groupId>
  <artifactId>user-dao</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  
  
	<dependencies>
		<dependency>
		    <groupId>org.mybatis</groupId>
		    <artifactId>mybatis</artifactId>
		    <version>3.3.0</version>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.27</version>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
		</dependency>
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>
	</dependencies>
	
	<!-- 配置JRE版本 -->
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.5.1</version>  
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
					<encoding>UTF-8</encoding>
				</configuration>
			</plugin>
		</plugins>
	</build>
  
</project>
```

<br><br>
### service层整合spring
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.luguanxing</groupId>
  <artifactId>maven-user-service</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  
	<dependencies>
		<dependency>
	  		<groupId>org.springframework</groupId>
	  		<artifactId>spring-core</artifactId>
	  		<version>4.1.7.RELEASE</version>
	  	</dependency>
	  	<dependency>
	  		<groupId>org.springframework</groupId>
	  		<artifactId>spring-beans</artifactId>
	  		<version>4.1.7.RELEASE</version>
	  	</dependency>
	  	<dependency>
	         <groupId>org.springframework</groupId>
	         <artifactId>spring-tx</artifactId>
	         <version>4.1.7.RELEASE</version>
	        </dependency>
	  	<dependency>
	  		<groupId>org.springframework</groupId>
	  		<artifactId>spring-context</artifactId>
	  		<version>4.1.7.RELEASE</version>
	  	</dependency>
	  	<dependency>
	  		<groupId>org.springframework</groupId>
	  		<artifactId>spring-context-support</artifactId>
	  		<version>4.1.7.RELEASE</version>
	  	</dependency>
	  	<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-web</artifactId>
			<version>4.1.7.RELEASE</version>
		</dependency>
	  	<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>4.1.7.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-aop</artifactId>
			<version>4.1.7.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-aspects</artifactId>
			<version>4.1.7.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>4.1.7.RELEASE</version>
		</dependency>
		<dependency>
		    <groupId>org.mybatis</groupId>
		    <artifactId>mybatis-spring</artifactId>
		    <version>1.3.1</version>
		</dependency>
		
		<dependency>
		  <groupId>com.luguanxing</groupId>
		  <artifactId>user-dao</artifactId>
		  <version>0.0.1-SNAPSHOT</version>
		</dependency>
		
	</dependencies>
	
  	<!-- 配置JRE版本 -->
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.5.1</version>  
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
					<encoding>UTF-8</encoding>
				</configuration>
			</plugin>
		</plugins>
	</build>
  
</project>
```


<br><br>
### web层整合springmvc
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.luguanxing</groupId>
  <artifactId>maven-user-web</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>war</packaging>
  
	<dependencies>

		<!-- 添加Servlet支持 -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>4.0.0</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
		    <groupId>javax.servlet</groupId>
		    <artifactId>jsp-api</artifactId>
		    <version>2.0</version>
		    <scope>provided</scope>
		</dependency>
		
		<!-- 添加jtl支持 -->
		<dependency>
		    <groupId>javax.servlet</groupId>
		    <artifactId>jstl</artifactId>
		    <version>1.2</version>
		</dependency>


	  	<!-- 添加Spring支持 -->
		<dependency>
	  		<groupId>org.springframework</groupId>
	  		<artifactId>spring-core</artifactId>
	  		<version>4.1.7.RELEASE</version>
	  	</dependency>
	  	<dependency>
	  		<groupId>org.springframework</groupId>
	  		<artifactId>spring-beans</artifactId>
	  		<version>4.1.7.RELEASE</version>
	  	</dependency>
	  	<dependency>
	         <groupId>org.springframework</groupId>
	         <artifactId>spring-tx</artifactId>
	         <version>4.1.7.RELEASE</version>
	        </dependency>
	  	<dependency>
	  		<groupId>org.springframework</groupId>
	  		<artifactId>spring-context</artifactId>
	  		<version>4.1.7.RELEASE</version>
	  	</dependency>
	  	<dependency>
	  		<groupId>org.springframework</groupId>
	  		<artifactId>spring-context-support</artifactId>
	  		<version>4.1.7.RELEASE</version>
	  	</dependency>
	  	
	  	<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-web</artifactId>
			<version>4.1.7.RELEASE</version>
		</dependency>
		
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>4.1.7.RELEASE</version>
		</dependency>
	
		<dependency>
			<groupId>com.luguanxing</groupId>
			<artifactId>maven-user-service</artifactId>
			<version>0.0.1-SNAPSHOT</version>
		</dependency>
		  
	</dependencies>
  
	<!-- 配置JRE版本 -->
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.5.1</version>  
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
					<encoding>UTF-8</encoding>
				</configuration>
			</plugin>
		</plugins>
	</build>
	
</project>
```
