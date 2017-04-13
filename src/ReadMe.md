# SpringMvc+Spring+Mybatis+Maven构建web开发环境 
PS.本项目基于Intellij idea进行项目构建
### 1、首先来看项目目录
![image](https://raw.githubusercontent.com/mmlovedy/MarkDownPic/master/springmvc/webcloud.png)
###### 先建立如下几个包

> 在src/main/java下建立

```
com.springmvc.controller    
com.springmvc.dao           
com.springmvc.model
com.springmvc.service
com.springmvc.service.impl
```
>在src/main/resource下建立
```
conf    用于存放spring,mybatis等配置文件
mapper  用于存放mybatis的mapper文件
```
>在src/main/webapp下建立
```
WEB-INF|---css
       |---js
       |---jsp
       |---web.xml
```

## 2、配置POM.xml文件

这里需要注意的是，配置完pom.xml后需要重新导入，否则会pom文件中会存在错误，并且web.xml引用不到拦截类
![image](https://raw.githubusercontent.com/mmlovedy/MarkDownPic/master/springmvc/maven.png)
或者
![image](https://raw.githubusercontent.com/mmlovedy/MarkDownPic/master/springmvc/maven1.png)
---
pom.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>wordge</groupId>
    <artifactId>webcloud</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>
    <properties>
        <!-- spring版本号 -->
        <spring.version>3.2.8.RELEASE</spring.version>
        <!-- log4j日志文件管理包版本 -->
        <slf4j.version>1.6.6</slf4j.version>
        <log4j.version>1.2.12</log4j.version>
        <!-- junit版本号 -->
        <junit.version>4.10</junit.version>
        <!-- mybatis版本号 -->
        <mybatis.version>3.2.4</mybatis.version>
        <mybatis-spring.version>1.2.0</mybatis-spring.version>
        <!--mysql驱动 -->
        <mysql.version>5.1.29</mysql.version>
    </properties>

    <dependencies>
        <!-- 添加Spring依赖 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!--单元测试依赖 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>

        <!-- 日志文件管理包 -->
        <!-- log start -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>${log4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>${slf4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>${slf4j.version}</version>
        </dependency>
        <!-- log end -->

        <!--spring单元测试依赖 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring.version}</version>
            <scope>test</scope>
        </dependency>

        <!--mybatis依赖 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>${mybatis.version}</version>
        </dependency>

        <!-- mybatis/spring包 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>${mybatis-spring.version}</version>
        </dependency>

        <!-- mysql驱动包 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.version}</version>
        </dependency>

        <!-- 阿里巴巴数据源包 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.2</version>
        </dependency>

        <!-- json数据 -->
        <dependency>
            <groupId>org.codehaus.jackson</groupId>
            <artifactId>jackson-mapper-asl</artifactId>
            <version>1.9.13</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.7.5</version>
        </dependency>
    </dependencies>
    <build>
        <finalName>webcloud</finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>2.5</version>
                <configuration>
                    <webXml>src\main\webapp\WEB-INF\web.xml</webXml>
                </configuration>
            </plugin>
        </plugins>
        <pluginManagement>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>2.3.2</version>
                    <configuration>
                        <source>1.6</source>
                        <target>1.6</target>
                    </configuration>
                </plugin>
                <plugin>
                    <groupId>org.apache.tomcat.maven</groupId>
                    <artifactId>tomcat6-maven-plugin</artifactId>
                    <version>2.0-beta-1</version>
                </plugin>
                <plugin>
                    <groupId>org.codehaus.mojo</groupId>
                    <artifactId>build-helper-maven-plugin</artifactId>
                    <version>1.7</version>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>
</project>
```
## 3、配置Spring.xml
在conf目录下建立jdbc.properties
```
jdbc_driverClassName=com.mysql.jdbc.Driver
jdbc_url=jdbc:mysql://localhost:3306/ssm
jdbc_username=root
jdbc_password=1
jdbcpool_maxwait =6000
```
在conf目录下建立spring-context.xml

```
<?xml version="1.0" encoding="UTF-8" ?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
      http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
      http://www.springframework.org/schema/context
      http://www.springframework.org/schema/context/spring-context.xsd">
    <!-- 引入jdbc配置文件 -->
    <context:property-placeholder location="classpath:conf/jdbc.properties"/>
    <!-- 扫描文件（自动将servicec层注入） -->
    <context:component-scan base-package="com.springmvc.service"/>
</beans>
```
## 4、配置Mybatis.xml
### 先准备几个测试文件
在com.springmvc.model下创建User.java
```
package com.springmvc.model;

public class User
{
    private int id;
    private int state;
    private String nickname;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

```
在com.springmvc.dao下创建UserDAO.java
```
package com.springmvc.dao;

import com.springmvc.model.User;

import javax.annotation.Resource;
import java.util.List;

public interface UserDAO {
    /**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertUser(User user);

    public List<User> queryUsers();

}
```
在conf下创建mybatis-config.xml
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- 别名 -->
    <typeAliases>
        <typeAlias alias="User" type="com.springmvc.model.User"/>
    </typeAliases>
</configuration>
```
在conf下创建UserMapper.xml
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.springmvc.dao.UserDAO">

    <insert id="insertUser" parameterType="User" keyProperty="id">
        insert into user_info(
        state,
        nickname)
        values
        (
        #{state},
        #{nickname})
    </insert>
    <resultMap id="users" type="com.springmvc.model.User">
        <result column="id" property="id"></result>
    </resultMap>
    <select id="queryUsers" resultMap="users">
        select id from user_info
    </select>

</mapper>
```
在conf下创建spring-mybatis.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:util="http://www.springframework.org/schema/util"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-3.2.xsd
    http://www.springframework.org/schema/tx
    http://www.springframework.org/schema/tx/spring-tx-3.2.xsd
    http://www.springframework.org/schema/aop
    http://www.springframework.org/schema/aop/spring-aop-3.2.xsd
    http://www.springframework.org/schema/util
    http://www.springframework.org/schema/util/spring-util-3.2.xsd">
    <!--配置连接池 -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init"
          destroy-method="close" >
        <property name="driverClassName">
            <value>${jdbc_driverClassName}</value>
        </property>
        <property name="url">
            <value>${jdbc_url}</value>
        </property>
        <property name="username">
            <value>${jdbc_username}</value>
        </property>
        <property name="password">
            <value>${jdbc_password}</value>
        </property>
        <!-- 连接池最大使用连接数 -->
        <property name="maxActive">
            <value>20</value>
        </property>
        <!-- 初始化连接大小 -->
        <property name="initialSize">
            <value>1</value>
        </property>
        <!-- 获取连接最大等待时间 -->
        <property name="maxWait">
            <value>60000</value>
        </property>
        <!-- 连接池最大空闲 -->
        <property name="maxIdle">
            <value>20</value>
        </property>
        <!-- 连接池最小空闲 -->
        <property name="minIdle">
            <value>3</value>
        </property>
        <!-- 自动清除无用连接 -->
        <property name="removeAbandoned">
            <value>true</value>
        </property>
        <!-- 清除无用连接的等待时间 -->
        <property name="removeAbandonedTimeout">
            <value>180</value>
        </property>
        <!-- 连接属性 -->
        <property name="connectionProperties">
            <value>clientEncoding=UTF-8</value>
        </property>
    </bean>

    <!-- mybatis文件配置，扫描所有mapper文件 -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean" p:dataSource-ref="dataSource"
          p:configLocation="classpath:conf/mybatis-config.xml"
          p:mapperLocations="classpath:mapper/*.xml" />

    <!-- spring与mybatis整合配置，扫描所有dao -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer"
          p:basePackage="com.springmvc.dao"
          p:sqlSessionFactoryBeanName="sqlSessionFactory"/>

    <!-- 对数据源进行事务管理 -->
    <bean id="transactionManager"
          class="org.springframework.jdbc.datasource.DataSourceTransactionManager"
          p:dataSource-ref="dataSource"/>
</beans>
```


在com.springmvc.service下创建UserService.java
```
package com.springmvc.service;

import com.springmvc.model.User;

import java.util.List;

public interface UserService {

    public int insertUser(User user);

    public List<User> queryUserInfo();
}

```
在com.springmvc.service.impl下创建UserServiceImpl.java，注意不要漏掉@Service
```
package com.springmvc.service.impl;

import com.springmvc.dao.UserDAO;
import com.springmvc.model.User;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public int insertUser(User user) {
        return userDAO.insertUser(user);
    }

    public List<User> queryUserInfo() {
        return userDAO.queryUsers();
    }
}
```
### 到这里，mybatis的配置就完成了，下面写一个单元测试验证
在src/main/test下新建com.springmvc.test包，并新建UserTest.java
```
package com.springmvc.test;

import com.springmvc.model.User;
import com.springmvc.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    private UserService userService;

    @Before
    public void before(){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring-context.xml"
                ,"classpath:conf/spring-mybatis.xml"});
        userService = (UserService) context.getBean("userServiceImpl");
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setNickname("你好");
        user.setState(2);
        System.out.println(userService.insertUser(user));
    }
}
```
运行后看到如下效果，那么恭喜你Spring+Mybatis运行成功
![image](https://raw.githubusercontent.com/mmlovedy/MarkDownPic/master/springmvc/junit.png)

## 5、配置SpringMVC+启动web
在com.springmvc.controller下创建UserController.java,主要不要漏掉@Controller
```
package com.springmvc.controller;

import com.springmvc.model.User;
import com.springmvc.service.UserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/insert")
    public int insertUser(User user){
        return userService.insertUser(user);
    }

   @RequestMapping(value = "/query",produces = {"application/json ; charset=UTF-8 "})
   public List<User> getUserInfo() throws IOException {
       return userService.queryUserInfo();
   }

}
```
在conf下配置spring-mvc.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="
    http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-3.2.xsd
    http://www.springframework.org/schema/mvc
    http://www.springframework.org/schema/mvc/spring-mvc-3.2.xsd">
    <!--开启注解 -->
    <context:annotation-config/>
    <!-- 自动扫描-->
    <context:component-scan base-package="com.springmvc.controller" />
    <!--启动默认处理 -->
    <mvc:annotation-driven />
    <mvc:resources mapping="/css/**.css" location="/WEB-INF/css/"/>
    <mvc:resources mapping="/js/**.js" location="/WEB-INF/js/"/>

    <!--根据返回内容自动匹配显示模板，默认为JSON，否则返回JSP -->
    <bean class="org.springframework.web.servlet.view.ContentNegotiatingViewResolver">
        <property name="mediaTypes">
            <map>
                <entry key="atom" value="application/atom+xml"/>
                <entry key="html" value="text/html"/>
                <entry key="json" value="application/json"/>
            </map>
        </property>
        <property name="viewResolvers">
            <list>
                <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
                    <property name="prefix" value="/WEB-INF/jsp/"/>
                    <property name="suffix" value=".jsp"/>
                </bean>
            </list>
        </property>
        <property name="defaultViews">
            <list>
                <bean class="org.springframework.web.servlet.view.json.MappingJackson2JsonView" />
            </list>
        </property>
    </bean>
</beans>
```
在jsp目录下新建index.jsp
```
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>欢迎您！！</h1>
</body>
</html>
```
## 6、访问http://localhost:8080/webcloud/user/index,显示如下页面，恭喜您成功了
![image](https://raw.githubusercontent.com/mmlovedy/MarkDownPic/master/springmvc/welcome.png)
## 访问http://localhost:8080/webcloud/user/query，显示如下页面，说明使用springmvc发布restful风格的接口也成功了
![image](https://raw.githubusercontent.com/mmlovedy/MarkDownPic/master/springmvc/welcome1.png)







