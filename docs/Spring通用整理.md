1. 通用配置可放置于resources/config/application.yml中,且优先级高于resources/application.yml中的配置项
2. 打印启动端口地址：
    ```text
    ConfigurableEnvironment env =
            SpringApplication.run(HelloWebMvcApplication.class, args).getEnvironment();
    log.info("启动成功：\thttp://127.0.0.1:{}", env.getProperty("server.port"));
    ```
3. 使用idea自带的http工具编写controller测试脚本
4. gateway项目添加启动参数打印请求日志：-Dreactor.netty.http.server.accessLogEnabled=true