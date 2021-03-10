# 启动

先启动：

```java
java -Xdebug -Xrunjdwp:transport=dt_socket,address=8080,server=y,suspend=y -jar user-web-v1-SNAPSHOT-war-exec.jar
```

idea 设置：
配置一个Remote：

```java
-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8080
```

注册页面：

http://localhost:8080/register.jsp



# 作业要求

- [x] 通过课堂上的简易版依赖注入和依赖查找，实现用户注册功能
  1. 将`ComponentContext`单独抽取为一个模块（context），可以让`my-web-mvc`进行依赖查找，
  2. 新增根据类型查找方法，可以从Context中查找到Controller然后进行替换
- [x] 通过 UserService 实现用户注册注册用户需要校验

- [x] Id：必须大于 0 的整数

- [x] 密码：6-32 位 电话号码: 采用中国大陆方式（11 位校验）
  1. 使用自定义注解 `@Phone`、和`@Pwd`进行校验



# 结果

成功后会返回 用户id

失败后会返回错误提示