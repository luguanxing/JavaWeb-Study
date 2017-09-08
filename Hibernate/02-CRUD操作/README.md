# 实体类编写规则
```
1 实体类里面属性私有的
2 私有属性使用公开的set和get方法操作
3 要求实体类有属性作为唯一值（一般使用id值）
4 实体类属性建议不使用基本数据类型，使用基本数据类型对应的包装类
（1）八个基本数据类型对应的包装类
- int – Integer
- char—Character、
- 其他的都是首字母大写 比如 double – Double
（2）比如 表示学生的分数，假如 int score;
- 比如学生得了0分 ，int score = 0;
- 如果表示学生没有参加考试，int score = 0;不能准确表示学生是否参加考试
解决：使用包装类可以了， Integer score = 0，表示学生得了0分，
表示学生没有参加考试，Integer score = null;
```

<br><br><br>


# Hibernate主键生成策略
```
1 hibernate要求实体类里面有一个属性作为唯一值，对应表主键，主键可以不同生成策略
2 hibernate主键生成策略有很多的值
3 在class属性里面有很多值
（1）native： 根据使用的数据库帮选择哪个值
（2）uuid：之前web阶段写代码生成uuid值，hibernate帮我们生成uuid值
4 演示生成策略值 uuid
（1）使用uuid生成策略，实体类id属性类型 必须 字符串类型
（2）配置部分写出uuid值
```

<br><br><br>


# 实体类CRUD操作

### 添加操作
```
调用session里面的save方法实现
```
### 根据id查询
```
调用session里面的get方法实现
```
### 修改操作
```
根据id查询，返回对象，修改值
```
### 删除操作
```
调用session里面delete方法实现
 ```

 
 
 
