
# spring-boot-3-knife4j

本项目是一个基于 Spring Boot 3.x 和 Knife4j 的后端接口示例，适合初学者快速上手 Spring Boot 3、接口文档自动生成、健康检查等常用开发场景。

---

## 目录

- [项目简介](#项目简介)
- [环境要求](#环境要求)
- [快速启动](#快速启动)
- [接口文档说明](#接口文档说明)
- [健康检查接口](#健康检查接口)
- [核心代码说明](#核心代码说明)
- [常见问题](#常见问题)
- [参考资料](#参考资料)

---

## 项目简介

- 使用 Spring Boot 3.4.4 作为基础框架，JDK 21。
- 集成 Knife4j（Swagger 增强版）自动生成接口文档，支持在线调试。
- 提供健康检查接口，方便服务监控。
- 启动后自动在控制台输出访问地址、Spring Boot 版本、JDK 版本、项目名称等信息，便于开发调试。
- 代码注释详细，适合学习和二次开发。

---

## 环境要求

- JDK 21 及以上
- Maven 3.6 及以上
- 推荐使用 IntelliJ IDEA 或 Eclipse

---

## 快速启动

1. **克隆项目**
   ```bash
   git clone https://github.com/your-repo/spring-boot-3-knife4j.git
   ```

2. **导入IDEA/Eclipse**

3. **构建并启动项目**
   ```bash
   mvn spring-boot:run
   ```
   或直接运行 `SpringBoot3Knife4jApplication.java` 的 main 方法。

4. **启动成功后，控制台会输出如下信息：**
   ```
   ----------------------------------------------------------
   项目 'spring-boot-3-knife4j' 启动成功！
   Spring Boot 版本: 3.4.4
   JDK 版本: 21
   接口文档地址（Knife4j）：   http://localhost:8123/api/doc.html
   ----------------------------------------------------------
   ```

---

## 接口文档说明

- **Knife4j 文档页面**  
  [http://localhost:8123/api/doc.html](http://localhost:8123/api/doc.html)  
  可查看所有接口说明并在线调试。

- **Swagger UI 页面**  
  [http://localhost:8123/api/swagger-ui.html](http://localhost:8123/api/swagger-ui.html)  
  也是接口文档页面，Knife4j 是对 Swagger 的增强。

---

## 健康检查接口

- **接口地址**  
  `GET http://localhost:8123/api/health`

- **返回内容**  
  ```
  ok
  ```

- **用途**  
  用于服务监控、负载均衡等场景，判断服务是否存活。

---

## 核心代码说明

### 1. 启动类

`SpringBoot3Knife4jApplication.java`  
负责启动项目，并调用 `StartupInfoPrinter` 工具类自动输出项目信息。

### 2. 启动信息打印工具

`StartupInfoPrinter.java`  
通用工具类，自动输出访问地址、版本号等信息。可直接复制到其他 Spring Boot 项目中复用。

### 3. 健康检查接口

`HealthController.java`  
提供 `/health` GET 接口，返回 "ok"。

### 4. 配置文件

`application.yml`  
配置端口、上下文路径、Knife4j、Swagger 等参数。

---

## 常见问题

- **Q: 端口被占用怎么办？**  
  A: 修改 `application.yml` 中的 `server.port` 配置。

- **Q: 如何修改项目访问路径？**  
  A: 修改 `application.yml` 中的 `server.servlet.context-path`。

- **Q: 如何添加自己的接口？**  
  A: 在 `chat.it666.springboot3knife4j.controller` 包下新建 Controller 类即可，Knife4j 会自动扫描。

- **Q: 控制台没有输出访问地址？**  
  A: 请确保 `StartupInfoPrinter.print()` 在启动类中被正确调用。

---

## 参考资料

- [Spring Boot 官方文档](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Knife4j 官方文档](https://doc.xiaominfo.com/)
- [Swagger 官方文档](https://swagger.io/docs/)

---

如有问题欢迎提 issue 或留言交流！
