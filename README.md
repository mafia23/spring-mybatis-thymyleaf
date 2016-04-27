#spring_myBatis_Thymeleaf

##spring(springMVC)+MyBatis+Thymeleaf基础项目

本项目实现用SpringMVC整合MyBatis和Thymeleaf模板的一个基础例子。

### 1 使用框架

1. Spring作为核心框架管理javabean 
2. SpringMVC 作为控制层
3. MyBatis 作为数据控制层，访问数据库
4. Thymeleaf 作为view的显示模板

### 2 项目结构

1.src/main/java

	src
	|__fun
	|___|___dao
	|___|___exception (自定义异常处理)
	|___|___model
	|___|___service
	|___|___util 
	|___|___web
	|___|____|___controller (控制器)
	|___|____|___interceptor (拦截器)

2.src/main/resources

	resources
	|--config (基本配置)
	|--mapper (mybatis的xml配置的sql)
	|--spring (spring 容器)
	|---+---mvc (springMVC 容器)

3.webroot

	webroot
	|--themes (静态资源及主题)
	|--WEB-INF
	|---+---views (view层)
	|---+----+----common (公用部分)
	|---+----+----modules (业务模块)





