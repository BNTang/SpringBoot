package chat.it666.springboot4apidemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页控制器 - 提供演示界面和API文档
 */
@Controller
public class HomeController {

    /**
     * 主页 - 展示Spring Boot 4.0 API版本控制特性
     */
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Spring Boot 4.0 API版本控制演示");
        model.addAttribute("description", "演示Spring Boot 4.0新增的原生API版本控制功能");
        return "index";
    }

    /**
     * API文档页面
     */
    @GetMapping("/docs")
    public String apiDocs(Model model) {
        model.addAttribute("title", "API文档");
        return "api-docs";
    }
} 