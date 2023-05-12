## 平台简介
NetworkProgram是一个管理网络服务器的平台。
> 现阶段基于docker模拟网络服务器。
## 项目地址
### 后端项目
| 项目 | 简介                |
| --- |-------------------|
| [NetworkProgram](https://github.com/7411555200/NetworkProgram)    | 基于SpringBoot多模块架构 |
### 前端项目
| 项目                                                                               | 简介                |
|----------------------------------------------------------------------------------|-------------------|
| [NetworkProgramFront](https://github.com/7411555200/NetworkProgram-front) | 基于Vue3 + Vite4 + naive-ui-admin |
## 内置功能
- 服务器管理
- 命令管理
- 定时任务
- 权限管理
- 角色管理
- 日志中心
## 技术栈
### 模块
| 项目             | 说明             |
|----------------|----------------|
| `network-auth`   | 鉴权与登录的Module模块 |
| `network-command` | 命令系统的Module模块  |
| `network-server` | 服务器系统的Module模块 |
| `network-role`   | 权限系统的Module模块  |
| `network-log`    | 日志系统的Module模块  |
| `network-task`   | 定时任务的Module模块  |

### 框架