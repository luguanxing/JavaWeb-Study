# 查询操作

### 使用query对象，不需要写sql语句，但是写hql语句
```
（1）hql：hibernate query language，hibernate提供查询语言，这个hql语句和普通sql语句很相似
（2）hql和sql语句区别：
- 使用sql操作表和表字段
- 使用hql操作实体类和属性

查询所有hql语句：
（1）from 实体类名称

Query对象使用
（1）创建Query对象
（2）调用query对象里面的方法得到结果
```
 

### Criteria对象
```
1 使用这个对象查询操作，但是使用这个对象时候，不需要写语句，直接调用方法实现
2 实现过程
（1）创建criteria对象
（2）调用对象里面的方法得到结果
```
 

### SQLQuery对象
```
1 使用hibernate时候，调用底层sql实现
2 实现过程
（1）创建对象
（2）调用对象的方法得到结果
返回list集合每部分是数组
返回list中每部分是对象形式
```
 
 
