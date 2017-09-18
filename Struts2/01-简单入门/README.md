# 简单入门

### 第一步 导入jar包
```
（1）在lib中有jar包，不能把这些jar都导入到项目中
（2）到apps目录里面，找到示例程序，从示例程序复制jar包
```
 
 
### 第二步 创建action
```
包含返回值为string的execute方法
```
 

### 第三步 配置action类访问路径
```
（1）创建struts2核心配置文件
- 核心配置文件名称和位置是固定的
- 位置必须在src下面，名称 struts.xml
（2）引入dtd约束
（3）action配置
```

 
### 第四步 配置struts2过滤器
```
在web.xml中加入<flter>
```

### 运行
```
输入namespace和action中name的组合
```
