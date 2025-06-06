package chat.it666.springboot3knife4j;

import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * @author BNTang
 */ /*
 * 通用的Spring Boot启动信息打印工具类
 * 只需调用print方法并传入Environment对象即可输出常用项目信息
 * 方便在多个项目中复用
 */
public class StartupInfoPrinter {

    /*
     * 打印项目启动后的关键信息，包括访问地址、Spring Boot版本、JDK版本、项目名称等
     * @param env Spring的环境变量对象，通常通过ApplicationContext.getEnvironment()获取
     */
    public static void print(Environment env) {
        // 获取本机IP地址
        String ip = "localhost";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception ignored) {
        }

        // 获取端口号，默认8123
        String port = env.getProperty("server.port", "8123");
        // 获取项目上下文路径，默认空字符串
        String contextPath = env.getProperty("server.servlet.context-path", "");
        // 获取项目名称
        String appName = env.getProperty("spring.application.name", "spring-boot-project");
        // 获取Spring Boot版本
        String springBootVersion = StartupInfoPrinter.class.getPackage().getImplementationVersion();
        if (springBootVersion == null) {
            try {
                springBootVersion = org.springframework.boot.SpringBootVersion.getVersion();
            } catch (Throwable e) {
                springBootVersion = "未知";
            }
        }
        // 获取JDK版本
        String javaVersion = System.getProperty("java.version");

        // 构造常见的接口文档页面访问地址
        String docUrl = "http://" + ip + ":" + port + contextPath + "/doc.html";
        String swaggerUrl = "http://" + ip + ":" + port + contextPath + "/swagger-ui.html";

        // 控制台输出详细的项目信息和访问地址，格式清晰，链接可直接点击
        System.out.println("\n----------------------------------------------------------");
        System.out.println("项目 '" + appName + "' 启动成功！");
        System.out.println("Spring Boot 版本: " + springBootVersion);
        System.out.println("JDK 版本: " + javaVersion);
        System.out.println("接口文档地址（Knife4j）：   " + docUrl);
        // System.out.println("Swagger UI 地址：         " + swaggerUrl);
        System.out.println("----------------------------------------------------------\n");
    }
}
