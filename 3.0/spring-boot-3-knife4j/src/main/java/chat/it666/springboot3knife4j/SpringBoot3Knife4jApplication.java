package chat.it666.springboot3knife4j;

// 导入Spring Boot的核心类，这些类帮助我们快速启动和配置Spring Boot项目

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @author BNTang
 *
 * 这个注解@SpringBootApplication是Spring Boot项目的标志
 * 它其实是三个注解的组合，分别是@Configuration、@EnableAutoConfiguration、@ComponentScan
 * 作用就是告诉Spring Boot：这是一个主程序入口类，要自动帮我们做很多配置和组件扫描
 *
 * 启动项目后，可以在浏览器访问 http://localhost:8123/api/doc.html
 * 这个地址可以看到接口文档页面，还能直接测试接口，非常方便
 */
@SpringBootApplication
public class SpringBoot3Knife4jApplication {

    /*
     * main方法是Java程序的入口
     * SpringApplication.run方法会启动整个Spring Boot项目
     * 参数SpringBoot3Knife4jApplication.class表示以当前这个类为主配置类
     * args是命令行参数，可以不用管
     *
     * 启动成功后，会自动在控制台输出项目的访问地址（可以直接点击），
     * 还会输出Spring Boot版本、JDK版本、项目名称等信息，方便开发者快速定位和访问
     */
    public static void main(String[] args) {
        // 启动Spring Boot项目，并获取应用上下文对象
        var context = SpringApplication.run(SpringBoot3Knife4jApplication.class, args);

        // 调用通用的启动信息打印工具，输出项目信息和访问地址
        StartupInfoPrinter.print(context.getEnvironment());
    }

}
