# Hibernate多对多操作

## 多对多映射配置
```
以用户和角色为例演示

第一步 创建实体类，用户和角色

第二步 让两个实体类之间互相表示
（1）一个用户里面表示所有角色，使用set集合
（2）一个角色有多个用户，使用set集合

第三步 配置映射关系
（1）基本配置
（2）配置多对多关系
- 在用户里面表示所有角色，使用set标签
- 在角色里面表示所有用户，使用set标签

第四步 在核心配置文件中引入映射文件

```

![img](https://github.com/luguanxing/JavaWeb-Study/blob/master/Hibernate/06-%E5%A4%9A%E5%AF%B9%E5%A4%9A%E6%93%8D%E4%BD%9C/pic.jpg?raw=true)
效果
