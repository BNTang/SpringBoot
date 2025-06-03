package chat.it666.springboot4apidemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * Spring Boot 4.0 API版本控制示例
 * 演示同一URL路径下不同版本的API实现
 */
@RestController
@RequestMapping("/api")
public class VersionedController {

    /**
     * 版本1的用户API - 基础实现
     * 只返回基本的用户信息
     */
    @RequestMapping(value = "/user", version = "1")
    public Map<String, Object> getUserV1() {
        Map<String, Object> user = new HashMap<>();
        user.put("id", 1001);
        user.put("name", "张三");
        user.put("email", "zhangsan@example.com");
        user.put("version", "v1");
        user.put("description", "基础用户信息 - 只包含核心字段");
        return user;
    }

    /**
     * 版本2的用户API - 增强实现
     * 包含更多详细信息和新增字段
     */
    @RequestMapping(value = "/user", version = "2")
    public Map<String, Object> getUserV2() {
        Map<String, Object> user = new HashMap<>();
        user.put("id", 1001);
        user.put("name", "张三");
        user.put("email", "zhangsan@example.com");
        user.put("phone", "13800138000");
        user.put("age", 28);
        user.put("department", "技术部");
        user.put("position", "高级开发工程师");
        user.put("createdAt", LocalDateTime.now().minusMonths(6));
        user.put("lastLoginAt", LocalDateTime.now());
        user.put("permissions", Arrays.asList("READ", "WRITE", "DELETE"));
        user.put("version", "v2");
        user.put("description", "增强用户信息 - 包含详细档案和权限信息");
        return user;
    }

    /**
     * 移动端专用版本
     * 针对移动设备优化，减少数据传输量
     */
    @RequestMapping(value = "/user", version = "mobile")
    public Map<String, Object> getUserMobile() {
        Map<String, Object> user = new HashMap<>();
        user.put("id", 1001);
        user.put("name", "张三");
        user.put("avatar", "https://example.com/avatar/zhangsan.jpg");
        user.put("isOnline", true);
        user.put("version", "mobile");
        user.put("description", "移动端优化版本 - 精简数据，快速加载");
        return user;
    }

    /**
     * 版本1的产品列表API
     */
    @RequestMapping(value = "/products", version = "1")
    public Map<String, Object> getProductsV1() {
        Map<String, Object> response = new HashMap<>();
        response.put("products", Arrays.asList(
            Map.of("id", 1, "name", "智能手机", "price", 2999.0),
            Map.of("id", 2, "name", "笔记本电脑", "price", 5999.0)
        ));
        response.put("version", "v1");
        response.put("total", 2);
        return response;
    }

    /**
     * 版本2的产品列表API - 增加了分页和更多产品信息
     */
    @RequestMapping(value = "/products", version = "2")
    public Map<String, Object> getProductsV2() {
        Map<String, Object> response = new HashMap<>();
        response.put("products", Arrays.asList(
            Map.of("id", 1, "name", "智能手机", "price", 2999.0, 
                   "brand", "TechBrand", "category", "电子产品", "stock", 50, "rating", 4.5),
            Map.of("id", 2, "name", "笔记本电脑", "price", 5999.0, 
                   "brand", "ComputerBrand", "category", "电子产品", "stock", 30, "rating", 4.8),
            Map.of("id", 3, "name", "无线耳机", "price", 299.0, 
                   "brand", "AudioBrand", "category", "音响设备", "stock", 100, "rating", 4.3)
        ));
        response.put("version", "v2");
        response.put("total", 3);
        response.put("page", 1);
        response.put("pageSize", 10);
        response.put("hasMore", false);
        return response;
    }

    /**
     * 获取特定用户信息 - 演示路径参数与版本控制结合
     */
    @RequestMapping(value = "/user/{userId}", version = "1")
    public Map<String, Object> getUserByIdV1(@PathVariable Long userId) {
        Map<String, Object> user = new HashMap<>();
        user.put("id", userId);
        user.put("name", "用户" + userId);
        user.put("email", "user" + userId + "@example.com");
        user.put("version", "v1");
        return user;
    }

    @RequestMapping(value = "/user/{userId}", version = "2")
    public Map<String, Object> getUserByIdV2(@PathVariable Long userId) {
        Map<String, Object> user = new HashMap<>();
        user.put("id", userId);
        user.put("name", "用户" + userId);
        user.put("email", "user" + userId + "@example.com");
        user.put("profile", Map.of(
            "bio", "这是用户" + userId + "的个人简介",
            "location", "北京市",
            "joinedAt", LocalDateTime.now().minusYears(1)
        ));
        user.put("stats", Map.of(
            "postsCount", 42,
            "followersCount", 128,
            "followingCount", 89
        ));
        user.put("version", "v2");
        return user;
    }
}
