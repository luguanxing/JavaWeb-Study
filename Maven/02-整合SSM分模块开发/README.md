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

测试可行代码如下
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

```
