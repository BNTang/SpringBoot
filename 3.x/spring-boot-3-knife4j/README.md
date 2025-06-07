# Spring Boot 3 集成 Knife4j 完整指南

本项目是一个基于 Spring Boot 3.x 和 Knife4j 的后端接口示例，**重点讲解如何在 Spring Boot 3 中正确集成 Knife4j**，适合初学者快速上手接口文档自动生成、在线调试等功能。

---

## 目录

- [项目简介](#项目简介)
- [环境要求](#环境要求)
- [Knife4j 集成步骤](#knife4j-集成步骤)
- [配置文件详解](#配置文件详解)
- [快速启动](#快速启动)
- [接口文档使用指南](#接口文档使用指南)
- [常见注解使用](#常见注解使用)
- [常见问题与解决方案](#常见问题与解决方案)
- [最佳实践](#最佳实践)

---

## 项目简介

- **Spring Boot 3.4.4** + **JDK 21** 现代化技术栈
- **Knife4j 4.4.0** 最新版本，完美支持 Spring Boot 3
- **零配置启动**，开箱即用的接口文档
- **详细注释**，每行代码都有说明
- **通用工具类**，可直接复制到其他项目使用

---

## 环境要求

| 组件 | 版本要求 | 说明 |
|------|----------|------|
| JDK | 21+ | Spring Boot 3 最低要求 JDK 17 |
| Maven | 3.6+ | 构建工具 |
| IDE | IDEA/Eclipse | 推荐 IntelliJ IDEA |

---

## Knife4j 集成步骤

### 第一步：添加依赖

在 `pom.xml` 中添加 Knife4j 依赖：

```xml
<!-- Knife4j Spring Boot 3 专用依赖 -->
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>knife4j-openapi3-jakarta-spring-boot-starter</artifactId>
    <version>4.4.0</version>
</dependency>
```

**重要说明：**
- Spring Boot 3 必须使用 `knife4j-openapi3-jakarta-spring-boot-starter`
- 老版本 `knife4j-spring-boot-starter` 不支持 Spring Boot 3
- `jakarta` 版本是为了适配 Spring Boot 3 的 Jakarta EE 规范

### 第二步：配置 application.yml

```yaml
# 服务基础配置
server:
  port: 8123                    # 服务端口
  servlet:
    context-path: /api          # 接口前缀

spring:
  application:
    name: spring-boot-3-knife4j # 应用名称

# SpringDoc 配置（Knife4j 基于此）
springdoc:
  swagger-ui:
    path: /swagger-ui.html      # Swagger UI 访问路径
    tags-sorter: alpha          # 标签按字母排序
    operations-sorter: alpha    # 接口按字母排序
  api-docs:
    path: /v3/api-docs         # OpenAPI 文档路径
  group-configs:
    - group: 'default'         # 分组名称
      paths-to-match: '/**'    # 扫描路径
      packages-to-scan: your.package.controller  # 扫描包路径

# Knife4j 增强配置
knife4j:
  enable: true                 # 启用 Knife4j 增强
  setting:
    language: zh_cn            # 界面语言设置为中文
```

### 第三步：创建 Controller

```java
@RestController
@RequestMapping("/demo")
@Tag(name = "演示接口", description = "Knife4j 集成演示")
public class DemoController {
    
    @GetMapping("/hello")
    @Operation(summary = "Hello接口", description = "返回问候语")
    public String hello() {
        return "Hello, Knife4j!";
    }
}
```

### 第四步：启动项目

运行 `SpringBoot3Knife4jApplication.java`，访问：
- **Knife4j 文档**：http://localhost:8123/api/doc.html
- **Swagger UI**：http://localhost:8123/api/swagger-ui.html

---

## 配置文件详解

### SpringDoc 配置说明

| 配置项 | 作用 | 推荐值 |
|--------|------|--------|
| `swagger-ui.path` | Swagger UI 访问路径 | `/swagger-ui.html` |
| `api-docs.path` | OpenAPI JSON 文档路径 | `/v3/api-docs` |
| `packages-to-scan` | 扫描的 Controller 包 | 你的 controller 包路径 |
| `paths-to-match` | 扫描的接口路径 | `/**` (所有路径) |

### Knife4j 配置说明

| 配置项 | 作用 | 可选值 |
|--------|------|--------|
| `enable` | 是否启用 Knife4j 增强 | `true/false` |
| `setting.language` | 界面语言 | `zh_cn/en` |

---

## 快速启动

1. **克隆项目**
   ```bash
   git clone [项目地址]
   cd spring-boot-3-knife4j
   ```

2. **修改配置**
   ```yaml
   # application.yml 中修改包扫描路径
   packages-to-scan: chat.it666.springboot3knife4j.controller
   ```

3. **启动项目**
   
   ```bash
   mvn spring-boot:run
```
   
4. **查看控制台输出**
   ```
   ----------------------------------------------------------
   项目 'spring-boot-3-knife4j' 启动成功！
   Spring Boot 版本: 3.4.4
   JDK 版本: 21
   接口文档地址（Knife4j）：   http://localhost:8123/api/doc.html
   ----------------------------------------------------------
   ```

---

## 接口文档使用指南

### 1. 访问文档页面

- **推荐使用 Knife4j**：http://localhost:8123/api/doc.html
  - 界面更美观，功能更强大
  - 支持离线文档导出
  - 支持接口调试

- **原生 Swagger UI**：http://localhost:8123/api/swagger-ui.html
  - OpenAPI 标准界面
  - 功能相对简单

### 2. 在线接口调试

1. 打开 Knife4j 文档页面
2. 选择要测试的接口
3. 点击"调试"按钮
4. 填写请求参数
5. 点击"发送"查看响应结果

### 3. 文档导出

Knife4j 支持导出多种格式的接口文档：
- **Word 文档**：适合给产品经理
- **HTML 文档**：适合离线查看
- **Markdown 文档**：适合开发者

---

## 常见注解使用

### Controller 类注解

```java
@RestController
@RequestMapping("/user")
@Tag(name = "用户管理", description = "用户相关的所有接口")
public class UserController {
    // ...
}
```

### 接口方法注解

```java
@PostMapping("/create")
@Operation(summary = "创建用户", description = "创建一个新的用户账户")
@ApiResponse(responseCode = "200", description = "创建成功")
@ApiResponse(responseCode = "400", description = "参数错误")
public Result<User> createUser(@RequestBody @Parameter(description = "用户信息") User user) {
    // ...
}
```

### 实体类注解

```java
@Schema(description = "用户实体")
public class User {
    
    @Schema(description = "用户ID", example = "1")
    private Long id;
    
    @Schema(description = "用户名", required = true, example = "张三")
    private String username;
    
    @Schema(description = "邮箱", example = "zhangsan@example.com")
    private String email;
}
```

---

## 常见问题与解决方案

### 1. 文档页面 404

**问题**：访问 `/doc.html` 返回 404

**原因**：依赖版本不对或配置错误

**解决方案**：
```xml
<!-- 确保使用正确的依赖 -->
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>knife4j-openapi3-jakarta-spring-boot-starter</artifactId>
    <version>4.4.0</version>
</dependency>
```

### 2. 接口扫描不到

**问题**：Controller 写了但文档里看不到

**解决方案**：
```yaml
springdoc:
  group-configs:
    - group: 'default'
      packages-to-scan: com.yourpackage.controller  # 确保包路径正确
```

### 3. 中文乱码

**问题**：接口文档中文显示乱码

**解决方案**：
```yaml
knife4j:
  setting:
    language: zh_cn  # 设置中文语言
```

### 4. 生产环境安全问题

**问题**：生产环境不想暴露接口文档

**解决方案**：
```yaml
# application-prod.yml
knife4j:
  enable: false  # 生产环境关闭
```

---

## 最佳实践

### 1. 环境区分配置

```yaml
# application-dev.yml (开发环境)
knife4j:
  enable: true

# application-prod.yml (生产环境)  
knife4j:
  enable: false
```

### 2. 接口分组管理

```yaml
springdoc:
  group-configs:
    - group: '用户模块'
      paths-to-match: '/user/**'
      packages-to-scan: com.example.user.controller
    - group: '订单模块'
      paths-to-match: '/order/**'
      packages-to-scan: com.example.order.controller
```

### 3. 统一响应格式

```java
@Schema(description = "统一响应格式")
public class Result<T> {
    @Schema(description = "状态码", example = "200")
    private Integer code;
    
    @Schema(description = "响应消息", example = "操作成功")
    private String message;
    
    @Schema(description = "响应数据")
    private T data;
}
```

### 4. 全局异常处理

```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    @Operation(hidden = true)  // 隐藏异常处理方法
    public Result<String> handleException(Exception e) {
        return Result.error(e.getMessage());
    }
}
```

---

## 参考资料

- [Knife4j 官方文档](https://doc.xiaominfo.com/)
- [SpringDoc OpenAPI 文档](https://springdoc.org/)
- [Spring Boot 3 官方文档](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [OpenAPI 3.0 规范](https://swagger.io/specification/)

---

**如果这个教程对你有帮助，请给个 ⭐ Star 支持一下！**

有问题欢迎提 Issue