1. 编写Aspect
    ```java
    @Slf4j
    @Aspect
    @Component
    public class LogAspect {
        @Pointcut("execution(public * com.yicj.study..*Controller.*(..))")
        public void controllerPointcut() {
        }
        //
        @Before("controllerPointcut()")
        public void doBefore(JoinPoint joinPoint) {
            // 增加日志流水号
            MDC.put("LOG_ID", System.currentTimeMillis() + RandomUtil.randomString(3));
            // 开始打印请求日志
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            Signature signature = joinPoint.getSignature();
            String name = signature.getName();
    
            // 打印请求信息
            log.info("------------- 开始 -------------");
            log.info("请求地址: {} {}", request.getRequestURL().toString(), request.getMethod());
            log.info("类名方法: {}.{}", signature.getDeclaringTypeName(), name);
            log.info("远程地址: {}", request.getRemoteAddr());
            // 打印请求参数
            Object[] args = joinPoint.getArgs();
            // LOG.info("请求参数: {}", JSONObject.toJSONString(args));
            // 排除特殊类型的参数，如文件类型
            Object[] arguments = new Object[args.length];
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof ServletRequest
                        || args[i] instanceof ServletResponse
                        || args[i] instanceof MultipartFile) {
                    continue;
                }
                arguments[i] = args[i];
            }
            // 排除字段，敏感字段或太长的字段不显示：身份证、手机号、邮箱、密码等
            String[] excludeProperties = {};
            PropertyPreFilters filters = new PropertyPreFilters();
            PropertyPreFilters.MySimplePropertyPreFilter excludeFilter = filters.addFilter();
            excludeFilter.addExcludes(excludeProperties);
            log.info("请求参数: {}", JSONObject.toJSONString(arguments, excludeFilter));
        }
        //
        @Around("controllerPointcut()")
        public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
            long startTime = System.currentTimeMillis();
            Object result = proceedingJoinPoint.proceed();
            // 排除字段，敏感字段或太长的字段不显示：身份证、手机号、邮箱、密码等
            String[] excludeProperties = {};
            PropertyPreFilters filters = new PropertyPreFilters();
            PropertyPreFilters.MySimplePropertyPreFilter excludeFilter = filters.addFilter();
            excludeFilter.addExcludes(excludeProperties);
            log.info("返回结果: {}", JSONObject.toJSONString(result, excludeFilter));
            log.info("------------- 结束 耗时：{} ms -------------", System.currentTimeMillis() - startTime);
            return result;
        }
    }
    ```
2. 添加logback日志配置
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <configuration>
        <!-- 修改一下路径-->
        <property name="PATH" value="./log/hello-webmvc" />
        <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
            <encoder>
                <Pattern>%d{mm:ss.SSS} %highlight(%-5level) %blue(%-30logger{30}:%-4line) %thread %green(%-18X{LOG_ID}) %msg%n</Pattern>
            </encoder>
        </appender>
        <appender name="TRACE_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
            <file>${PATH}/trace.log</file>
            <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                <FileNamePattern>${PATH}/trace.%d{yyyy-MM-dd}.%i.log</FileNamePattern>
                <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                    <maxFileSize>10MB</maxFileSize>
                </timeBasedFileNamingAndTriggeringPolicy>
            </rollingPolicy>
            <layout>
                <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level %-50logger{50}:%-4line %green(%-18X{LOG_ID}) %msg%n</pattern>
            </layout>
        </appender>
        <appender name="ERROR_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
            <file>${PATH}/error.log</file>
            <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                <FileNamePattern>${PATH}/error.%d{yyyy-MM-dd}.%i.log</FileNamePattern>
                <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                    <maxFileSize>10MB</maxFileSize>
                </timeBasedFileNamingAndTriggeringPolicy>
            </rollingPolicy>
            <layout>
                <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level %-50logger{50}:%-4line %green(%-18X{LOG_ID}) %msg%n</pattern>
            </layout>
            <filter class="ch.qos.logback.classic.filter.LevelFilter">
                <level>ERROR</level>
                <onMatch>ACCEPT</onMatch>
                <onMismatch>DENY</onMismatch>
            </filter>
        </appender>
        <root level="ERROR">
            <appender-ref ref="STDOUT" />
        </root>
        <root level="TRACE">
            <appender-ref ref="STDOUT" />
        </root>
        <root level="INFO">
            <appender-ref ref="STDOUT" />
        </root>
    </configuration>
    ```