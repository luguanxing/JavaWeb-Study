# 页面配置和表单获取

### 结果页面配置
```
全局结果页面
  1 result标签配置action方法的返回值到不同的路径里面
  2 创建两个action，执行默认的方法execute方法，让两个action的方法都返回success，返回success之后，配置到同一个页面里面
    （1）如果多个action，方法里面返回值相同的，到页面也是相同的，这个时候可以使用全局结果页面配置
    （2）在package标签里面配置

局部结果页面
  配置全局页面，也配置了局部页面，最终以局部配置为准
```

### Result标签的type属性
```
1 result标签里面除了name属性之外，还有一个属性 type属性
  type属性：如何到路径里面（转发还是重定向）
2 type属性值
  （1）默认值，做转发操作，值是 dispatcher
  （2）做重定向操作，值是 redirect
上面两个值dispatcher、redirect，这两个值一般针对到页面中配置，配置到其他的action里面
  （3）chain：转发到action，一般不用，缓存问题
  （4）redirectAction：重定向到action
```
 

### Action获取表单提交数据
```
1 之前web阶段，提交表单到servlet里面，在servlet里面使用request对象里面的方法获取，getParameter，getParameterMap
2 提交表单到action，但是action没有request对象，不能直接使用request对象
3 action获取表单提交数据主要三种方式
（1）使用ActionContext类
（2）使用ServletActionContext类
（3）使用接口注入方式
```

##### 使用ActionContext类获取
```
（1）因为方法不是静态的方法，需要创建ActionContext类的对象
（2）这个ActionContext类对象不是new出来的，
（3）创建表单，提交表单到action里面
（4）在action使用ActionContext获取数据
```
 

##### 使用ServletActionContext类获取
 ```
（1）调用类里面静态方法，得到request对象
 ```

##### 使用接口注入（了解）
```
（1）让action实现接口，为了得到request对象
```
