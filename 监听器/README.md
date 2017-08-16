# Listener监听器

------

> * 01-监听域对象创建和属性修改
> * 02-统计当前在线人数
> * 03-统计在线人员名单

------

## 01-监听域对象创建和属性修改<br>
使用监听器对ServletContext、Session、Request创建修改和对象被绑定到Session时进行监听
<br><br><br><br><br><br>


## 02-统计当前在线人数<br>
![image](https://github.com/luguanxing/JavaWeb-Study/blob/master/%E7%9B%91%E5%90%AC%E5%99%A8/pictures/02.jpg?raw=true)<br>
使用了HttpSessionListener监听Session的创建删除，根据一段时间内的Session数估计当前在线人数
<br><br><br><br><br><br>

## 03-统计在线人员名单<br>
![image](https://github.com/luguanxing/JavaWeb-Study/blob/master/%E7%9B%91%E5%90%AC%E5%99%A8/pictures/03.jpg?raw=true)<br>
使用HttpSessionBindingListener当对象User被绑定到session时将该用户的用户名存入全局Map，即可获取当前所有用户名
<br><br><br><br><br><br>

