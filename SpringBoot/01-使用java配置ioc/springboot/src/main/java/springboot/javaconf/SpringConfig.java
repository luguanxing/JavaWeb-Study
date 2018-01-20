package springboot.javaconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 通过该注解来表明该类是一个Spring的配置，相当于一个xml文件
@ComponentScan(basePackages = "springboot.javaconf") // 配置扫描包，扫描加载注解的类
public class SpringConfig {

	@Bean // 通过该注解来表明是一个Bean对象，相当于xml中的<bean>
	public UserDAO getUserDAO() {
		return new UserDAO(); // 直接new对象做演示
	}

}
