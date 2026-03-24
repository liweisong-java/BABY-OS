# Baby-OS 婴幼儿生育周期管理系统 v4.8.3

<p align="center">
	<img alt="logo" src="static/ruoyi.png">
</p>

<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">Baby-OS v4.8.3</h1>
<h4 align="center">基于SpringBoot + MyBatis + Shiro的婴幼儿生育周期管理平台</h4>

## 平台简介

Baby-OS 是专为医疗机构和家长设计的婴幼儿生育周期管理系统。系统覆盖从备孕、妊娠期到婴幼儿成长的全周期健康管理，支持医生与家长的协同管理，符合医疗数据合规要求。

**核心功能：**
- 生育档案管理
- 孕期健康追踪与指标监测
- 婴幼儿成长记录与曲线分析
- 智能预警与健康提醒
- 预约与医疗报告管理
- 医患沟通记录

**技术栈**
- 后端: Spring Boot 4.0.3 + MyBatis + Shiro
- 前端: Thymeleaf + Bootstrap + jQuery
- 数据库: MySQL 8.0
- 其他: Druid, PageHelper, ECharts

系统使用代码生成器快速开发业务模块，采用RBAC权限控制和数据权限隔离确保医疗数据安全。

## 快速启动

1. 创建数据库 `babyos` 并执行 sql 目录下的初始化脚本
2. 修改 `babyos-admin/src/main/resources/application-druid.yml` 中的数据库连接信息
3. 运行 `BabyOsApplication.java` 主类
4. 访问 http://localhost  (默认账号 admin / admin123)

## 业务模块

详见 `docs/superpowers/plans/2026-03-23-baby-os-implementation-plan-ruoyi.md`

## License

本项目基于开源框架开发，遵循Apache License 2.0。