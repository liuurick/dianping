package com.liuurick.dianping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = {"com.liuurick.dianping"})
@MapperScan("com.liuurick.dianping.dal")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DianpingApplication {
	public static void main(String[] args) {
		SpringApplication.run(DianpingApplication.class, args);
	}

}
