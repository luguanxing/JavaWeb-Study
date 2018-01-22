package springboot.demo;

import java.nio.charset.Charset;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 作为Controller
@SpringBootApplication // 作为SpringBoot应用
@Configuration // 作为配置文件
public class HelloApplication {

	@RequestMapping("hello") // 映射的URL
	@ResponseBody // 输出结果
	public String hello() {
		return "hello world！你好";
	}

	// 自定义消息转化器，默认为UTF-8
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		return converter;
	}

	public static void main(String[] args) {
		// 入口方法，运行SpringBoot应用
		// SpringApplication.run(HelloApplication.class, args);
		SpringApplication app = new SpringApplication(HelloApplication.class);
		app.setBannerMode(Mode.CONSOLE);
		app.run(args);
	}

}
