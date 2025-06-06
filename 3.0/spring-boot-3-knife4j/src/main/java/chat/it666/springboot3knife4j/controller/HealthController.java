package chat.it666.springboot3knife4j.controller;

// 导入Spring Web相关的注解和类，用于开发REST接口

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BNTang
 */
/*
 * @RestController表示这是一个控制器类，专门用来处理前端发来的请求
 * 并且返回的数据会直接写到HTTP响应体里，不会跳转到页面
 */
@RestController
/*
 * @RequestMapping("/health")的意思是
 * 这个控制器下面的所有接口，访问路径前面都会自动加上/health
 * 比如：/api/health
 */
@RequestMapping("/health")
public class HealthController {

    /*
     * @GetMapping表示这是一个GET请求的接口
     * 访问路径就是/health（因为上面类上已经加了@RequestMapping("/health")）
     * 这个接口的作用就是健康检查，别人访问它时，返回"ok"字符串
     * 通常用来让运维或者监控系统判断服务是不是活着
     */
    @GetMapping
    public String healthCheck() {
        // 只要有人访问这个接口，就返回"ok"，表示服务正常
        return "ok";
    }
}
