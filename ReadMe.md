### 编辑器记得安装lombok插件

### Applets-Lotus 1.0
![https://img.shields.io/badge/license-Apache%202.0-blue.svg?longCache=true&style=flat-square](https://img.shields.io/badge/license-Apache%202.0-blue.svg?longCache=true&style=flat-square)
![https://img.shields.io/badge/springboot-2.4.2-yellow.svg?style=flat-square](https://img.shields.io/badge/springboot-2.4.2-yellow.svg?style=flat-square)
![https://img.shields.io/badge/shiro-1.6.0-orange.svg?longCache=true&style=flat-square](https://img.shields.io/badge/shiro-1.6.0-orange.svg?longCache=true&style=flat-square)
![https://img.shields.io/badge/layui-2.5.7-brightgreen.svg?longCache=true&style=flat-square](https://img.shields.io/badge/layui-2.5.7-brightgreen.svg?longCache=true&style=flat-square)

Applets-Lotus是一款简单小程序，使用Spring Boot，Shiro和Layui构建。

### 演示地址

[http://8.136.200.209:8081](http://8.136.200.209:8081/login)

演示环境账号密码：

账号 | 密码| 权限
---|---|---
scott | 1234qwer | 注册账户，拥有查看，新增权限（新增用户除外）和导出Excel权限


本地部署账号密码：

账号 | 密码| 权限
---|---|---
mrbird | 1234qwer |超级管理员，拥有所有增删改查权限
scott | 1234qwer | 注册账户，拥有查看，新增权限（新增用户除外）和导出Excel权限

### 系统模块
系统功能模块组成如下所示：
```
├─系统管理
│  ├─首页
│  ├─关于我们
│  ├─预约课程
```

### 技术选型

#### 后端
- [Spring Boot 2.4.2](http://spring.io/projects/spring-boot/)
- [Mybatis-Plus](https://mp.baomidou.com/guide/)
- [MySQL 5.7.x](https://dev.mysql.com/downloads/mysql/5.7.html#downloads)
- [Hikari](https://brettwooldridge.github.io/HikariCP/)
- [Redis](https://redis.io/)
- [Shiro 1.6.0](http://shiro.apache.org/)
