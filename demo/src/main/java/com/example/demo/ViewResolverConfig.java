package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
 
/**
 * 主要配置多视图实现的视图解析器相关bean实例,将该视图解析器注册到容器中
 *
 *
 * 其实关键点在于两个：
 * 1、配置order属性
 * 2、配置viewnames属性
 *
 */
@Configuration
public class ViewResolverConfig {
 
    @SuppressWarnings("deprecation")
    @Configuration//用来定义 DispatcherServlet 应用上下文中的 bean
    @EnableWebMvc
    @ComponentScan("com.wp.springboot")
    public class WebConfig extends WebMvcConfigurerAdapter {
 
        //jsp页面的视图解析器，解析到webapp下的jsp/目录下查找对应的jsp页面
        @Bean
        public ViewResolver viewResolver() {
            InternalResourceViewResolver resolver = new InternalResourceViewResolver();
            resolver.setPrefix("/WEB-INF/jsp/");
            resolver.setSuffix(".jsp");
            resolver.setViewNames("*");
            resolver.setOrder(2);
            return resolver;
        }
 
        @Bean
        public ITemplateResolver templateResolver() {
            SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
            templateResolver.setTemplateMode("HTML5");
            templateResolver.setPrefix("/WEB-INF/");
            templateResolver.setSuffix(".html");
            templateResolver.setCharacterEncoding("utf-8");
            templateResolver.setCacheable(false);
            return templateResolver;
        }
 
        @Bean
        public SpringTemplateEngine templateEngine() {
            SpringTemplateEngine templateEngine = new SpringTemplateEngine();
            templateEngine.setTemplateResolver(templateResolver());
            // templateEngine
            return templateEngine;
        }
 
        /**
         * 对thymeleaf的视图解析器，解析到webapp下的html目录下查找对应的页面
         * @return
         */
        @Bean
        public ThymeleafViewResolver viewResolverThymeLeaf() {
            ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
            viewResolver.setTemplateEngine(templateEngine());
            viewResolver.setCharacterEncoding("utf-8");
            viewResolver.setOrder(1);
            viewResolver.setViewNames(new String[]{"html/*", "vue/*","jsps/*","templates/*"});
            return viewResolver;
        }
 
        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
            configurer.enable();
        }
 
        /**
         * 配置资源路径
         * @param registry
         */
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/**").addResourceLocations("/img/");
            registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/" + "/static/");
        }
    }
 
}
