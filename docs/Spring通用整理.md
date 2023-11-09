1. 乾坤大挪移
2. 通用配置可放置于resources/config/application.yml中,且优先级高于resources/application.yml中的配置项
3. 打印启动端口地址：
    ```text
    ConfigurableEnvironment env =
            SpringApplication.run(HelloWebMvcApplication.class, args).getEnvironment();
    log.info("启动成功：\thttp://127.0.0.1:{}", env.getProperty("server.port"));
    ```
4. 使用idea自带的http工具编写controller测试脚本
5. gateway项目添加启动参数打印请求日志：-Dreactor.netty.http.server.accessLogEnabled=true
6. 自定义异常不打印堆栈信息,优化性能自定义异常的fillInStackTrace方法
   ```text
   @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
   ```
7. SpringMvc拦截器配置
   ```java
   @Configuration
   public class SpringMvcConfig implements WebMvcConfigurer {
      @Resource
      MemberInterceptor memberInterceptor;
      @Override
      public void addInterceptors(InterceptorRegistry registry) {
          registry.addInterceptor(memberInterceptor)
               .addPathPatterns("/**")
               .excludePathPatterns(
                       "/member/member/send-code",
                       "/member/member/login"
               );
      }
   }
   ```
8. Controller中的url地址一般全小写，多个单词使用中划线连接eg: /create-user
9. 后端Long传递到前端后精度丢失, 需以字符串形式传递
   ```java
   @Data
   public class UserListResponse {
       @JsonSerialize(using = ToStringSerializer.class)
       private Long id ;
   }
   ```
10. Mysql查询部分信息
   ```text
   select * from information_schema.tables Where table_name = 't_user' and TABLE_SCHEMA = 'test';
   show full columns from t_user ;
   ```
