# Spring入门

### Spring概念
```
1 spring是开源的轻量级框架
2 spring核心主要两部分：
（1）aop：面向切面编程，扩展功能不是修改源代码实现
（2）ioc：控制反转，
  - 比如有一个类，在类里面有方法（不是静态的方法），调用类里面的方法，创建类的对象，使用对
    象调用方法，创建类对象的过程，需要new出来对象
  - 把对象的创建不是通过new方式实现，而是交给spring配置创建类对象
3 spring是一站式框架
  spring在javaee三层结构中，每一层都提供不同的解决技术
  - web层：springMVC
  - service层：spring的ioc
  - dao层：spring的jdbcTemplate
4 spring版本
（1）hibernate5.x
（2）spring4.x
```

### Spring的ioc操作
```
1 把对象的创建交给spring进行管理
2 ioc操作两部分：
（1）ioc的配置文件方式
（2）ioc的注解方式
```

### IOC底层原理
```
（1）xml配置文件
（2）dom4j解决xml
（3）工厂设计模式
（4）反射
```
![img](https://github.com/luguanxing/JavaWeb-Study/blob/master/Spring/ioc.jpg?raw=true)

### IOC入门案例
```
第一步 导入jar包
（1）解压资料zip文件
Jar特点：都有三个jar包
（2）做spring最基本功能时候，导入四个核心的jar包就可以了
（3）导入支持日志输出的jar包
第二步 创建类，在类里面创建方法
第三步 创建spring配置文件，配置创建类
（1）spring核心配置文件名称和位置不是固定的
- 建议放到src下面，官方建议applicationContext.xml
（2）引入schema约束
（3）配置对象创建
第四步 写代码测试对象创建
（1）这段代码在测试中使用
```
 
### Spring的bean管理（xml方式）
```
Bean实例化的方式
  1 在spring里面通过配置文件创建对象
  2 bean实例化三种方式实现
  第一种 使用类的无参数构造创建（重点）
    类里面没有无参数的构造，出现异常
  第二种 使用静态工厂创建
    创建静态的方法，返回类对象
  第三种 使用实例工厂创建
    创建不是静态的方法，返回类对象
```
 

### Bean标签常用属性
```
（1）id属性：起名称，id属性值名称任意命名
- id属性值，不能包含特殊符号
- 根据id值得到配置对象
（2）class属性：创建对象所在类的全路径
（3）name属性：功能和id属性一样的，id属性值不能包含特殊符号，但是在name属性值里面可以包含特殊符号
（4）scope属性
- singleton：默认值，单例
- prototype：多例
- request：创建对象把对象放到request域里面
- session：创建对象把对象放到session域里面
- globalSession：创建对象把对象放到globalSession里面
```
