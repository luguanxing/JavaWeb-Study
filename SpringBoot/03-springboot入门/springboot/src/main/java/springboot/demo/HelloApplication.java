package springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller	//作为Controller
@SpringBootApplication	//作为SpringBoot应用
@Configuration	//作为配置文件
public class HelloApplication {

	@RequestMapping("hello")	//映射的URL
	@ResponseBody	//输出结果
	public String hello() {
		return "hello world！";
	}

	public static void main(String[] args) {
		//入口方法，运行SpringBoot应用
		SpringApplication.run(HelloApplication.class, args);
	}

}
