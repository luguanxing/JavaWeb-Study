# 搭建hibernate环境（重点）
<br>
## 第一步 导入hibernate的jar包
因为使用hibernate时候，有日志信息输出，hibernate本身没有日志输出的jar包，导入其他日志的jar包,不要忘记还有mysql驱动的jar包
<br>
## 第二步 创建实体类
使用hibernate时候，不需要自己手动创建表，hibernate帮把表创建
<br>
## 第三步 配置实体类和数据库表一一对应关系（映射关系）
使用配置文件实现映射关系<br>
（1）创建xml格式的配置文件<br>
- 映射配置文件名称和位置没有固定要求<br>
- 建议：在实体类所在包里面创建，实体类名称.hbm.xml<br>
（2）配置是是xml格式，在配置文件中首先引入xml约束<br>
- 学过约束dtd、schema，在hibernate里面引入的约束dtd约束<br>
（3）配置映射关系<br>
```
<hibernate-mapping>
	<!-- 1 配置类和表对应 
		class标签
		name属性：实体类全路径
		table属性：数据库表名称
	-->
	<class name="实体类全路径" table="t_user">
		<!-- 2 配置实体类id和表id对应 
			hibernate要求实体类有一个属性唯一值
			hibernate要求表有字段作为唯一值
		-->
		<!-- id标签
			name属性：实体类里面id属性名称
			column属性：生成的表字段名称
		 -->
		<id name="uid" column="uid">
			<!-- 设置数据库表id增长策略 
				native:生成表id值就是主键自动增长
			-->
			<generator class="native"></generator>
		</id>
		<!-- 配置其他属性和表字段对应 
			name属性：实体类属性名称
			column属性：生成表字段名称
		-->
		<property name="username" column="username"></property>
		<property name="password" column="password"></property>
		<property name="address" column="address"></property>
	</class>
</hibernate-mapping>
```

## 第四步 创建hibernate的核心配置文件
（1）核心配置文件格式xml，但是核心配置文件名称和位置固定的<br>
- 位置：必须src下面<br>
- 名称：必须hibernate.cfg.xml<br>
（2）引入dtd约束<br>
（3）hibernate操作过程中，只会加载核心配置文件，其他配置文件不会加载<br>
第一部分： 配置数据库信息 必须的<br>
第二部分： 配置hibernate信息 可选的<br>
第三部分： 把映射文件放到核心配置文件中<br>
