# Baby-OS 婴幼儿生育周期管理系统 Implementation Plan (基于现有 babyos 4.8.3)

> **重要说明**：本计划基于当前项目已初始化的 **babyos 4.8.3** 脚手架制定，充分利用其代码生成器来最大化缩短开发周期。放弃原计划中 Spring Data JPA + Spring Security 的严格要求，改为适配 babyos 现有技术栈（MyBatis + Shiro + DataScope）。

**目标**：快速构建符合医疗合规要求的生育周期管理系统，优先实现核心业务模块。

**技术栈调整**：
- Backend: babyos 4.8.3 (Spring Boot 4.0.3 + MyBatis + Shiro)
- Database: MySQL 8.0
- 核心优势：使用 `babyos-generator` 代码生成器快速生成 CRUD
- 数据隔离：使用 `@DataScope` + `owner_id` + `dept_id` 实现医生-患者隔离
- 安全：基于现有操作日志 + 自定义敏感字段加密

---

## Phase 0: 项目基础配置 (Must be completed first)

- [x] 修改 `application.yml` / `application-druid.yml`，切换数据库为 MySQL 并更新数据库名为 babyos
- [x] 更新静态资源目录和模板中的 branding 从 ruoyi/若依 改为 babyos/Baby-OS
- [x] 修复批量替换导致的路径和引用问题
- [x] 测试系统配置 (note: DB init script may need running manually)

### Task 0.2: 项目结构调整与模块规划

- [ ] 创建业务模块目录：`babyos-maternity`（生育相关业务）
- [ ] 在 `babyos-generator` 中配置自定义模板，适配医疗业务字段（JSONB 支持、加密字段）
- [ ] 更新菜单和权限表，增加医疗相关菜单分类
- [ ] 初始化 Git 并提交基础配置

---

## Phase 1: 用户与权限系统增强 (高优先级)

### Task 1.1: 扩展用户与角色模型

- [ ] 使用代码生成器生成 `MaternityUserProfile`（家长档案扩展）
- [ ] 扩展 `SysUser` 或新建 `BabyUser` 关联医疗档案
- [ ] 新增角色：`PARENT`（家长）、`DOCTOR`（医生）、`ADMIN`
- [ ] 实现基于角色的数据隔离（医生只能看自己的患者）

### Task 1.2: 认证与数据权限强化

- [ ] 优化登录逻辑，支持手机号 + 微信登录
- [ ] 完善 `@DataScope` 使用规则（`owner_id` 字段）
- [ ] 增加操作审计日志（所有医疗数据变更必须记录）
- [ ] 实现敏感字段自动加密（身份证、手机号等）

---

## Phase 2: 生育档案核心模块 (核心业务)

### Task 2.1: 生育档案管理 (MaternityArchive)

- [ ] 使用代码生成器生成以下表和代码：
  - `maternity_archive`（主档案表）
  - `maternity_archive_mapper.xml` + Service + Controller
- [ ] 实现档案创建、查询、版本控制
- [ ] 增加 JSONB 字段支持灵活扩展指标

### Task 2.2: 孕期健康追踪 (PregnancyTracking)

- [ ] 生成 `pregnancy_tracking` 表（周报、指标记录）
- [ ] 实现趋势图数据接口（配合 ECharts）
- [ ] 开发指标录入模板功能

---

## Phase 3: 婴幼儿成长与智能预警

### Task 3.1: 婴幼儿成长记录

- [ ] 生成 `infant_growth_record` 表
- [ ] 实现生长曲线计算逻辑
- [ ] 里程碑管理功能

### Task 3.2: 智能预警规则引擎

- [ ] 创建 `alert_rule` 和 `alert_log` 表
- [ ] 实现规则配置界面（可配置预警阈值）
- [ ] 开发预警推送服务（站内信 + 后续可扩展短信）

---

## Phase 4: 医疗服务管理

- [ ] 生成 `medical_appointment`（产检预约）
- [ ] 生成 `vaccine_plan` 和 `vaccine_record`（疫苗计划）
- [ ] 生成 `medical_report`（检查报告管理）
- [ ] 实现预约提醒定时任务

---

## Phase 5: 医患沟通与数据可视化

- [ ] 开发沟通记录模块（`communication_record`）
- [ ] 实现医生工作看板
- [ ] 开发家长健康报告生成（PDF/在线查看）
- [ ] 管理员统计报表

---

## Phase 6: 安全合规与多端适配

- [ ] 加强审计日志不可篡改机制
- [ ] 实现字段级加密存储
- [ ] 准备医疗器械软件认证所需文档
- [ ] 前端集成 Taro 3（Web + 小程序）

---

## 开发规范与流程

1. **严格使用代码生成器**：所有业务表必须先在 `babyos-generator` 中生成基础 CRUD
2. **TDD 流程**：先生成测试用例 → 实现功能 → 测试通过 → 提交
3. **每次迭代流程**：
   - 设计表结构 → 代码生成 → 业务逻辑开发 → 权限配置 → 测试 → 提交
4. **提交规范**：每次功能点完成后必须提交，消息格式 `feat(maternity): 实现XX模块`
5. **医疗合规**：所有涉及个人健康数据的操作必须记录审计日志

---

**计划制定日期**：2026-03-23
**基于文档**：
- `docs/superpowers/specs/2026-03-23-baby-os-birth-cycle-management-design.md`
- `docs/superpowers/plans/2026-03-23-baby-os-implementation-plan.md`
- 当前 babyos 4.8.3 脚手架

**下一动作建议**：优先完成 **Phase 0**，配置好 PostgreSQL 并验证系统启动。
