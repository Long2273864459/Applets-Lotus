/*
 Navicat MySQL Data Transfer

 Source Server         : eproe_root
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : sh-cdb-m8kr6r6o.sql.tencentcdb.com:61986
 Source Schema         : dev_delivery

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 15/03/2021 16:23:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `CODE` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'code',
  `AVATAR` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像',
  `TITLE` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `IMAGE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述图片',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`CODE`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'http://8.136.200.209:8081/pictures/shizi1.jpg', '总裁演讲突破班', 'http://8.136.200.209:8081/pictures/zcyjtpb.jpg', '2021-03-15 15:27:58', NULL);
INSERT INTO `course` VALUES (2, 'http://8.136.200.209:8081/pictures/shizi2.jpg', '演讲改变人生', 'http://8.136.200.209:8081/pictures/yjgbrs.jpg', '2021-03-15 15:30:38', NULL);
INSERT INTO `course` VALUES (3, 'http://8.136.200.209:8081/pictures/shizi4.jpg', '企业活动主持课', 'http://8.136.200.209:8081/pictures/qyhdzck.jpg', '2021-03-15 15:33:12', NULL);
INSERT INTO `course` VALUES (4, 'http://8.136.200.209:8081/pictures/shizi6.jpg', '未来领袖初高中', 'http://8.136.200.209:8081/pictures/wllxcgz.jpg', '2021-03-15 15:34:46', NULL);
INSERT INTO `course` VALUES (5, 'http://8.136.200.209:8081/pictures/shizi3.jpg', '恰同学初高中', 'http://8.136.200.209:8081/pictures/qtxcgz.jpg', '2021-03-15 15:36:16', NULL);
INSERT INTO `course` VALUES (6, 'http://8.136.200.209:8081/pictures/shizi5.jpg', '未来领袖小学课', 'http://8.136.200.209:8081/pictures/wllxxxk.jpg', '2021-03-15 15:37:17', NULL);
INSERT INTO `course` VALUES (7, 'http://8.136.200.209:8081/pictures/shizi4.jpg', '职场口才突破班', 'http://8.136.200.209:8081/pictures/zykctpb1.jpg', '2021-03-15 15:38:29', NULL);

-- ----------------------------
-- Table structure for course_intention
-- ----------------------------
DROP TABLE IF EXISTS `course_intention`;
CREATE TABLE `course_intention`  (
  `CODE` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'code',
  `USERNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `MOBILE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `CONFUSED` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '困惑点  (1.上台紧张怯场忘词 2.上台发言没话说 3.上台发言没条理 4.上台发言没重点 5.演讲缺少感染力 6.演讲缺少营销力 7.演讲没有说服力 8.演讲没有领导影响力)',
  `AREA` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区 (1.广州 2.深圳 3.珠海 4.上海 5.杭州 6.郑州 7.济南 8.长沙)',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`CODE`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程意向表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of course_intention
-- ----------------------------

-- ----------------------------
-- Table structure for excellent_course
-- ----------------------------
DROP TABLE IF EXISTS `excellent_course`;
CREATE TABLE `excellent_course`  (
  `CODE` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'code',
  `IMAGE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片',
  `TITLE` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `SORT` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类',
  `PRICE` double(11, 2) NULL DEFAULT NULL COMMENT '价格',
  `PRODUCT_MANUAL` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品说明',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`CODE`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '精品课程表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of excellent_course
-- ----------------------------

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `USERNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作用户',
  `OPERATION` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '操作内容',
  `TIME` decimal(11, 0) NULL DEFAULT NULL COMMENT '耗时',
  `METHOD` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '操作方法',
  `PARAMS` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '方法参数',
  `IP` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作者IP',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `location` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作地点',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `t_log_create_time`(`CREATE_TIME`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1082 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志表' ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Table structure for t_login_log
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log`  (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `USERNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `LOGIN_TIME` datetime(0) NOT NULL COMMENT '登录时间',
  `LOCATION` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录地点',
  `IP` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `SYSTEM` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `BROWSER` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `t_login_log_login_time`(`LOGIN_TIME`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '登录日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_login_log
-- ----------------------------
INSERT INTO `t_login_log` VALUES (70, 'Scott', '2021-03-01 22:11:02', '内网IP|0|0|内网IP|内网IP', '10.199.162.1', 'Windows 10', 'Chrome 88');
INSERT INTO `t_login_log` VALUES (71, 'scott', '2021-03-01 22:45:09', '内网IP|0|0|内网IP|内网IP', '10.199.162.1', '', '');
INSERT INTO `t_login_log` VALUES (72, 'scott', '2021-03-01 23:01:03', '内网IP|0|0|内网IP|内网IP', '10.199.162.1', '', '');
INSERT INTO `t_login_log` VALUES (73, 'scott', '2021-03-10 12:19:41', '内网IP|0|0|内网IP|内网IP', '10.199.162.1', '', '');
INSERT INTO `t_login_log` VALUES (74, 'test', '2021-03-10 12:19:54', '内网IP|0|0|内网IP|内网IP', '10.199.162.1', '', '');
INSERT INTO `t_login_log` VALUES (75, 'test', '2021-03-10 17:55:28', '中国|华东|上海市|上海市|移动', '117.143.0.102', '', '');
INSERT INTO `t_login_log` VALUES (76, 'migooo', '2021-03-10 18:01:38', '中国|华东|上海市|上海市|移动', '117.135.80.94', '', '');
INSERT INTO `t_login_log` VALUES (77, 'migooo', '2021-03-10 18:05:00', '中国|华东|上海市|上海市|移动', '117.135.80.94', 'Mac OS X) AppleW', 'Safari Version 10.0 Mo');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `MENU_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单/按钮ID',
  `PARENT_ID` bigint(20) NOT NULL COMMENT '上级菜单ID',
  `MENU_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单/按钮名称',
  `URL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `PERMS` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '权限标识',
  `ICON` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `TYPE` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型 0菜单 1按钮',
  `ORDER_NUM` bigint(20) NULL DEFAULT NULL COMMENT '排序',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`MENU_ID`) USING BTREE,
  INDEX `t_menu_parent_id`(`PARENT_ID`) USING BTREE,
  INDEX `t_menu_menu_id`(`MENU_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 179 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, 0, '系统管理', NULL, NULL, 'layui-icon-setting', '0', 1, '2017-12-27 16:39:07', NULL);
INSERT INTO `t_menu` VALUES (2, 0, '系统监控', '', '', 'layui-icon-alert', '0', 2, '2017-12-27 16:45:51', '2019-06-13 11:20:40');
INSERT INTO `t_menu` VALUES (3, 1, '用户管理', '/system/user', 'user:view', '', '0', 1, '2017-12-27 16:47:13', '2019-12-04 16:46:50');
INSERT INTO `t_menu` VALUES (4, 1, '角色管理', '/system/role', 'role:view', '', '0', 2, '2017-12-27 16:48:09', '2019-06-13 08:57:19');
INSERT INTO `t_menu` VALUES (5, 1, '菜单管理', '/system/menu', 'menu:view', '', '0', 3, '2017-12-27 16:48:57', '2019-06-13 08:57:34');
INSERT INTO `t_menu` VALUES (6, 1, '部门管理', '/system/dept', 'dept:view', '', '0', 4, '2017-12-27 16:57:33', '2019-06-14 19:56:00');
INSERT INTO `t_menu` VALUES (8, 2, '在线用户', '/monitor/online', 'online:view', '', '0', 1, '2017-12-27 16:59:33', '2019-06-13 14:30:31');
INSERT INTO `t_menu` VALUES (10, 2, '系统日志', '/monitor/log', 'log:view', '', '0', 2, '2017-12-27 17:00:50', '2019-06-13 14:30:37');
INSERT INTO `t_menu` VALUES (11, 3, '新增用户', NULL, 'user:add', NULL, '1', NULL, '2017-12-27 17:02:58', NULL);
INSERT INTO `t_menu` VALUES (12, 3, '修改用户', NULL, 'user:update', NULL, '1', NULL, '2017-12-27 17:04:07', NULL);
INSERT INTO `t_menu` VALUES (13, 3, '删除用户', NULL, 'user:delete', NULL, '1', NULL, '2017-12-27 17:04:58', NULL);
INSERT INTO `t_menu` VALUES (14, 4, '新增角色', NULL, 'role:add', NULL, '1', NULL, '2017-12-27 17:06:38', NULL);
INSERT INTO `t_menu` VALUES (15, 4, '修改角色', NULL, 'role:update', NULL, '1', NULL, '2017-12-27 17:06:38', NULL);
INSERT INTO `t_menu` VALUES (16, 4, '删除角色', NULL, 'role:delete', NULL, '1', NULL, '2017-12-27 17:06:38', NULL);
INSERT INTO `t_menu` VALUES (17, 5, '新增菜单', NULL, 'menu:add', NULL, '1', NULL, '2017-12-27 17:08:02', NULL);
INSERT INTO `t_menu` VALUES (18, 5, '修改菜单', NULL, 'menu:update', NULL, '1', NULL, '2017-12-27 17:08:02', NULL);
INSERT INTO `t_menu` VALUES (19, 5, '删除菜单', NULL, 'menu:delete', NULL, '1', NULL, '2017-12-27 17:08:02', NULL);
INSERT INTO `t_menu` VALUES (20, 6, '新增部门', NULL, 'dept:add', NULL, '1', NULL, '2017-12-27 17:09:24', NULL);
INSERT INTO `t_menu` VALUES (21, 6, '修改部门', NULL, 'dept:update', NULL, '1', NULL, '2017-12-27 17:09:24', NULL);
INSERT INTO `t_menu` VALUES (22, 6, '删除部门', NULL, 'dept:delete', NULL, '1', NULL, '2017-12-27 17:09:24', NULL);
INSERT INTO `t_menu` VALUES (23, 8, '踢出用户', NULL, 'user:kickout', NULL, '1', NULL, '2017-12-27 17:11:13', NULL);
INSERT INTO `t_menu` VALUES (24, 10, '删除日志', NULL, 'log:delete', NULL, '1', NULL, '2017-12-27 17:11:45', '2019-06-06 05:56:40');
INSERT INTO `t_menu` VALUES (101, 0, '任务调度', NULL, NULL, 'layui-icon-time-circle', '0', 3, '2018-02-24 15:52:57', NULL);
INSERT INTO `t_menu` VALUES (102, 101, '定时任务', '/job/job', 'job:view', '', '0', 1, '2018-02-24 15:53:53', '2018-04-25 09:05:12');
INSERT INTO `t_menu` VALUES (103, 102, '新增任务', NULL, 'job:add', NULL, '1', NULL, '2018-02-24 15:55:10', NULL);
INSERT INTO `t_menu` VALUES (104, 102, '修改任务', NULL, 'job:update', NULL, '1', NULL, '2018-02-24 15:55:53', NULL);
INSERT INTO `t_menu` VALUES (105, 102, '删除任务', NULL, 'job:delete', NULL, '1', NULL, '2018-02-24 15:56:18', NULL);
INSERT INTO `t_menu` VALUES (106, 102, '暂停任务', NULL, 'job:pause', NULL, '1', NULL, '2018-02-24 15:57:08', NULL);
INSERT INTO `t_menu` VALUES (107, 102, '恢复任务', NULL, 'job:resume', NULL, '1', NULL, '2018-02-24 15:58:21', NULL);
INSERT INTO `t_menu` VALUES (108, 102, '立即执行任务', NULL, 'job:run', NULL, '1', NULL, '2018-02-24 15:59:45', NULL);
INSERT INTO `t_menu` VALUES (109, 101, '调度日志', '/job/log', 'job:log:view', '', '0', 2, '2018-02-24 16:00:45', '2019-06-09 02:48:19');
INSERT INTO `t_menu` VALUES (110, 109, '删除日志', NULL, 'job:log:delete', NULL, '1', NULL, '2018-02-24 16:01:21', NULL);
INSERT INTO `t_menu` VALUES (115, 0, '其他模块', NULL, NULL, 'layui-icon-gift', '0', 5, '2019-05-27 10:18:07', NULL);
INSERT INTO `t_menu` VALUES (116, 115, 'Apex图表', '', '', NULL, '0', 2, '2019-05-27 10:21:35', NULL);
INSERT INTO `t_menu` VALUES (117, 116, '线性图表', '/others/apex/line', 'apex:line:view', NULL, '0', 1, '2019-05-27 10:24:49', NULL);
INSERT INTO `t_menu` VALUES (118, 115, '高德地图', '/others/map', 'map:view', '', '0', 3, '2019-05-27 17:13:12', '2019-06-12 15:33:00');
INSERT INTO `t_menu` VALUES (119, 116, '面积图表', '/others/apex/area', 'apex:area:view', NULL, '0', 2, '2019-05-27 18:49:22', NULL);
INSERT INTO `t_menu` VALUES (120, 116, '柱形图表', '/others/apex/column', 'apex:column:view', NULL, '0', 3, '2019-05-27 18:51:33', NULL);
INSERT INTO `t_menu` VALUES (121, 116, '雷达图表', '/others/apex/radar', 'apex:radar:view', NULL, '0', 4, '2019-05-27 18:56:05', NULL);
INSERT INTO `t_menu` VALUES (122, 116, '条形图表', '/others/apex/bar', 'apex:bar:view', NULL, '0', 5, '2019-05-27 18:57:02', NULL);
INSERT INTO `t_menu` VALUES (123, 116, '混合图表', '/others/apex/mix', 'apex:mix:view', '', '0', 6, '2019-05-27 18:58:04', '2019-06-06 02:55:23');
INSERT INTO `t_menu` VALUES (125, 115, '导入导出', '/others/eximport', 'others:eximport:view', '', '0', 4, '2019-05-27 19:01:57', '2019-06-13 01:20:14');
INSERT INTO `t_menu` VALUES (126, 132, '系统图标', '/others/febs/icon', 'febs:icons:view', '', '0', 4, '2019-05-27 19:03:18', '2019-06-06 03:05:26');
INSERT INTO `t_menu` VALUES (127, 2, '请求追踪', '/monitor/httptrace', 'httptrace:view', '', '0', 6, '2019-05-27 19:06:38', '2019-06-13 14:36:43');
INSERT INTO `t_menu` VALUES (128, 2, '系统信息', NULL, NULL, NULL, '0', 7, '2019-05-27 19:08:23', NULL);
INSERT INTO `t_menu` VALUES (129, 128, 'JVM信息', '/monitor/jvm', 'jvm:view', '', '0', 1, '2019-05-27 19:08:50', '2019-06-13 14:36:51');
INSERT INTO `t_menu` VALUES (131, 128, '服务器信息', '/monitor/server', 'server:view', '', '0', 3, '2019-05-27 19:10:07', '2019-06-13 14:37:04');
INSERT INTO `t_menu` VALUES (132, 115, 'FEBS组件', '', '', NULL, '0', 1, '2019-05-27 19:13:54', NULL);
INSERT INTO `t_menu` VALUES (133, 132, '表单组件', '/others/febs/form', 'febs:form:view', NULL, '0', 1, '2019-05-27 19:14:45', NULL);
INSERT INTO `t_menu` VALUES (134, 132, 'FEBS工具', '/others/febs/tools', 'febs:tools:view', '', '0', 3, '2019-05-29 10:11:22', '2019-06-12 13:21:27');
INSERT INTO `t_menu` VALUES (135, 132, '表单组合', '/others/febs/form/group', 'febs:formgroup:view', NULL, '0', 2, '2019-05-29 10:16:19', NULL);
INSERT INTO `t_menu` VALUES (136, 2, '登录日志', '/monitor/loginlog', 'loginlog:view', '', '0', 3, '2019-05-29 15:56:15', '2019-06-13 14:35:56');
INSERT INTO `t_menu` VALUES (137, 0, '代码生成', '', NULL, 'layui-icon-verticalright', '0', 4, '2019-06-03 15:35:58', NULL);
INSERT INTO `t_menu` VALUES (138, 137, '生成配置', '/generator/configure', 'generator:configure:view', NULL, '0', 1, '2019-06-03 15:38:36', NULL);
INSERT INTO `t_menu` VALUES (139, 137, '代码生成', '/generator/generator', 'generator:view', '', '0', 2, '2019-06-03 15:39:15', '2019-06-13 14:31:38');
INSERT INTO `t_menu` VALUES (159, 132, '其他组件', '/others/febs/others', 'others:febs:others', '', '0', 5, '2019-06-12 07:51:08', '2019-06-12 07:51:40');
INSERT INTO `t_menu` VALUES (160, 3, '密码重置', NULL, 'user:password:reset', NULL, '1', NULL, '2019-06-13 08:40:13', NULL);
INSERT INTO `t_menu` VALUES (161, 3, '导出Excel', NULL, 'user:export', NULL, '1', NULL, '2019-06-13 08:40:34', NULL);
INSERT INTO `t_menu` VALUES (162, 4, '导出Excel', NULL, 'role:export', NULL, '1', NULL, '2019-06-13 14:29:00', '2019-06-13 14:29:11');
INSERT INTO `t_menu` VALUES (163, 5, '导出Excel', NULL, 'menu:export', NULL, '1', NULL, '2019-06-13 14:29:32', NULL);
INSERT INTO `t_menu` VALUES (164, 6, '导出Excel', NULL, 'dept:export', NULL, '1', NULL, '2019-06-13 14:29:59', NULL);
INSERT INTO `t_menu` VALUES (165, 138, '修改配置', NULL, 'generator:configure:update', NULL, '1', NULL, '2019-06-13 14:32:09', '2019-06-13 14:32:20');
INSERT INTO `t_menu` VALUES (166, 139, '生成代码', NULL, 'generator:generate', NULL, '1', NULL, '2019-06-13 14:32:51', NULL);
INSERT INTO `t_menu` VALUES (167, 125, '模板下载', NULL, 'eximport:template', NULL, '1', NULL, '2019-06-13 14:33:37', NULL);
INSERT INTO `t_menu` VALUES (168, 125, '导出Excel', NULL, 'eximport:export', NULL, '1', NULL, '2019-06-13 14:33:57', NULL);
INSERT INTO `t_menu` VALUES (169, 125, '导入Excel', NULL, 'eximport:import', NULL, '1', NULL, '2019-06-13 14:34:19', NULL);
INSERT INTO `t_menu` VALUES (170, 10, '导出Excel', NULL, 'log:export', NULL, '1', NULL, '2019-06-13 14:34:55', NULL);
INSERT INTO `t_menu` VALUES (171, 136, '删除日志', NULL, 'loginlog:delete', NULL, '1', NULL, '2019-06-13 14:35:27', '2019-06-13 14:36:08');
INSERT INTO `t_menu` VALUES (172, 136, '导出Excel', NULL, 'loginlog:export', NULL, '1', NULL, '2019-06-13 14:36:26', NULL);
INSERT INTO `t_menu` VALUES (173, 102, '导出Excel', NULL, 'job:export', NULL, '1', NULL, '2019-06-13 14:37:25', NULL);
INSERT INTO `t_menu` VALUES (174, 109, '导出Excel', NULL, 'job:log:export', NULL, '1', NULL, '2019-06-13 14:37:46', '2019-06-13 14:38:02');
INSERT INTO `t_menu` VALUES (175, 2, 'Swagger文档', '/monitor/swagger', 'swagger:view', '', '0', 8, '2019-08-18 17:25:36', '2019-08-18 17:25:59');
INSERT INTO `t_menu` VALUES (178, 115, '数据权限', '/others/datapermission', 'others:datapermission', '', '0', 5, '2020-04-29 09:34:25', NULL);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `ROLE_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `REMARK` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 81 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '系统管理员', '系统管理员，拥有所有操作权限 ^_^', '2019-06-14 16:23:11', '2019-08-18 17:26:19');
INSERT INTO `t_role` VALUES (2, '注册账户', '注册账户，拥有查看，新增权限（新增用户除外）和导出Excel权限', '2019-06-14 16:00:15', '2019-08-18 17:36:02');
INSERT INTO `t_role` VALUES (77, 'Redis监控员', '负责Redis模块', '2019-06-14 20:49:22', NULL);
INSERT INTO `t_role` VALUES (78, '系统监控员', '负责整个系统监控模块', '2019-06-14 20:50:07', NULL);
INSERT INTO `t_role` VALUES (79, '跑批人员', '负责任务调度跑批模块', '2019-06-14 20:51:02', NULL);
INSERT INTO `t_role` VALUES (80, '开发人员', '拥有代码生成模块的权限', '2019-06-14 20:51:26', NULL);

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu`  (
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  `MENU_ID` bigint(20) NOT NULL COMMENT '菜单/按钮ID',
  INDEX `t_role_menu_menu_id`(`MENU_ID`) USING BTREE,
  INDEX `t_role_menu_role_id`(`ROLE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES (77, 2);
INSERT INTO `t_role_menu` VALUES (78, 2);
INSERT INTO `t_role_menu` VALUES (78, 8);
INSERT INTO `t_role_menu` VALUES (78, 23);
INSERT INTO `t_role_menu` VALUES (78, 10);
INSERT INTO `t_role_menu` VALUES (78, 24);
INSERT INTO `t_role_menu` VALUES (78, 170);
INSERT INTO `t_role_menu` VALUES (78, 136);
INSERT INTO `t_role_menu` VALUES (78, 171);
INSERT INTO `t_role_menu` VALUES (78, 172);
INSERT INTO `t_role_menu` VALUES (78, 127);
INSERT INTO `t_role_menu` VALUES (78, 128);
INSERT INTO `t_role_menu` VALUES (78, 129);
INSERT INTO `t_role_menu` VALUES (78, 131);
INSERT INTO `t_role_menu` VALUES (79, 101);
INSERT INTO `t_role_menu` VALUES (79, 102);
INSERT INTO `t_role_menu` VALUES (79, 103);
INSERT INTO `t_role_menu` VALUES (79, 104);
INSERT INTO `t_role_menu` VALUES (79, 105);
INSERT INTO `t_role_menu` VALUES (79, 106);
INSERT INTO `t_role_menu` VALUES (79, 107);
INSERT INTO `t_role_menu` VALUES (79, 108);
INSERT INTO `t_role_menu` VALUES (79, 173);
INSERT INTO `t_role_menu` VALUES (79, 109);
INSERT INTO `t_role_menu` VALUES (79, 110);
INSERT INTO `t_role_menu` VALUES (79, 174);
INSERT INTO `t_role_menu` VALUES (80, 137);
INSERT INTO `t_role_menu` VALUES (80, 138);
INSERT INTO `t_role_menu` VALUES (80, 165);
INSERT INTO `t_role_menu` VALUES (80, 139);
INSERT INTO `t_role_menu` VALUES (80, 166);
INSERT INTO `t_role_menu` VALUES (1, 1);
INSERT INTO `t_role_menu` VALUES (1, 3);
INSERT INTO `t_role_menu` VALUES (1, 11);
INSERT INTO `t_role_menu` VALUES (1, 12);
INSERT INTO `t_role_menu` VALUES (1, 13);
INSERT INTO `t_role_menu` VALUES (1, 160);
INSERT INTO `t_role_menu` VALUES (1, 161);
INSERT INTO `t_role_menu` VALUES (1, 4);
INSERT INTO `t_role_menu` VALUES (1, 14);
INSERT INTO `t_role_menu` VALUES (1, 15);
INSERT INTO `t_role_menu` VALUES (1, 16);
INSERT INTO `t_role_menu` VALUES (1, 162);
INSERT INTO `t_role_menu` VALUES (1, 5);
INSERT INTO `t_role_menu` VALUES (1, 17);
INSERT INTO `t_role_menu` VALUES (1, 18);
INSERT INTO `t_role_menu` VALUES (1, 19);
INSERT INTO `t_role_menu` VALUES (1, 163);
INSERT INTO `t_role_menu` VALUES (1, 6);
INSERT INTO `t_role_menu` VALUES (1, 20);
INSERT INTO `t_role_menu` VALUES (1, 21);
INSERT INTO `t_role_menu` VALUES (1, 22);
INSERT INTO `t_role_menu` VALUES (1, 164);
INSERT INTO `t_role_menu` VALUES (1, 2);
INSERT INTO `t_role_menu` VALUES (1, 8);
INSERT INTO `t_role_menu` VALUES (1, 23);
INSERT INTO `t_role_menu` VALUES (1, 10);
INSERT INTO `t_role_menu` VALUES (1, 24);
INSERT INTO `t_role_menu` VALUES (1, 170);
INSERT INTO `t_role_menu` VALUES (1, 136);
INSERT INTO `t_role_menu` VALUES (1, 171);
INSERT INTO `t_role_menu` VALUES (1, 172);
INSERT INTO `t_role_menu` VALUES (1, 127);
INSERT INTO `t_role_menu` VALUES (1, 128);
INSERT INTO `t_role_menu` VALUES (1, 129);
INSERT INTO `t_role_menu` VALUES (1, 131);
INSERT INTO `t_role_menu` VALUES (1, 175);
INSERT INTO `t_role_menu` VALUES (1, 101);
INSERT INTO `t_role_menu` VALUES (1, 102);
INSERT INTO `t_role_menu` VALUES (1, 103);
INSERT INTO `t_role_menu` VALUES (1, 104);
INSERT INTO `t_role_menu` VALUES (1, 105);
INSERT INTO `t_role_menu` VALUES (1, 106);
INSERT INTO `t_role_menu` VALUES (1, 107);
INSERT INTO `t_role_menu` VALUES (1, 108);
INSERT INTO `t_role_menu` VALUES (1, 173);
INSERT INTO `t_role_menu` VALUES (1, 109);
INSERT INTO `t_role_menu` VALUES (1, 110);
INSERT INTO `t_role_menu` VALUES (1, 174);
INSERT INTO `t_role_menu` VALUES (1, 137);
INSERT INTO `t_role_menu` VALUES (1, 138);
INSERT INTO `t_role_menu` VALUES (1, 165);
INSERT INTO `t_role_menu` VALUES (1, 139);
INSERT INTO `t_role_menu` VALUES (1, 166);
INSERT INTO `t_role_menu` VALUES (1, 115);
INSERT INTO `t_role_menu` VALUES (1, 132);
INSERT INTO `t_role_menu` VALUES (1, 133);
INSERT INTO `t_role_menu` VALUES (1, 135);
INSERT INTO `t_role_menu` VALUES (1, 134);
INSERT INTO `t_role_menu` VALUES (1, 126);
INSERT INTO `t_role_menu` VALUES (1, 159);
INSERT INTO `t_role_menu` VALUES (1, 116);
INSERT INTO `t_role_menu` VALUES (1, 117);
INSERT INTO `t_role_menu` VALUES (1, 119);
INSERT INTO `t_role_menu` VALUES (1, 120);
INSERT INTO `t_role_menu` VALUES (1, 121);
INSERT INTO `t_role_menu` VALUES (1, 122);
INSERT INTO `t_role_menu` VALUES (1, 123);
INSERT INTO `t_role_menu` VALUES (1, 118);
INSERT INTO `t_role_menu` VALUES (1, 125);
INSERT INTO `t_role_menu` VALUES (1, 167);
INSERT INTO `t_role_menu` VALUES (1, 168);
INSERT INTO `t_role_menu` VALUES (1, 169);
INSERT INTO `t_role_menu` VALUES (1, 178);
INSERT INTO `t_role_menu` VALUES (2, 1);
INSERT INTO `t_role_menu` VALUES (2, 3);
INSERT INTO `t_role_menu` VALUES (2, 161);
INSERT INTO `t_role_menu` VALUES (2, 4);
INSERT INTO `t_role_menu` VALUES (2, 14);
INSERT INTO `t_role_menu` VALUES (2, 162);
INSERT INTO `t_role_menu` VALUES (2, 5);
INSERT INTO `t_role_menu` VALUES (2, 17);
INSERT INTO `t_role_menu` VALUES (2, 163);
INSERT INTO `t_role_menu` VALUES (2, 6);
INSERT INTO `t_role_menu` VALUES (2, 20);
INSERT INTO `t_role_menu` VALUES (2, 164);
INSERT INTO `t_role_menu` VALUES (2, 2);
INSERT INTO `t_role_menu` VALUES (2, 8);
INSERT INTO `t_role_menu` VALUES (2, 10);
INSERT INTO `t_role_menu` VALUES (2, 170);
INSERT INTO `t_role_menu` VALUES (2, 136);
INSERT INTO `t_role_menu` VALUES (2, 172);
INSERT INTO `t_role_menu` VALUES (2, 127);
INSERT INTO `t_role_menu` VALUES (2, 128);
INSERT INTO `t_role_menu` VALUES (2, 129);
INSERT INTO `t_role_menu` VALUES (2, 131);
INSERT INTO `t_role_menu` VALUES (2, 175);
INSERT INTO `t_role_menu` VALUES (2, 101);
INSERT INTO `t_role_menu` VALUES (2, 102);
INSERT INTO `t_role_menu` VALUES (2, 173);
INSERT INTO `t_role_menu` VALUES (2, 109);
INSERT INTO `t_role_menu` VALUES (2, 174);
INSERT INTO `t_role_menu` VALUES (2, 137);
INSERT INTO `t_role_menu` VALUES (2, 138);
INSERT INTO `t_role_menu` VALUES (2, 139);
INSERT INTO `t_role_menu` VALUES (2, 115);
INSERT INTO `t_role_menu` VALUES (2, 132);
INSERT INTO `t_role_menu` VALUES (2, 133);
INSERT INTO `t_role_menu` VALUES (2, 135);
INSERT INTO `t_role_menu` VALUES (2, 134);
INSERT INTO `t_role_menu` VALUES (2, 126);
INSERT INTO `t_role_menu` VALUES (2, 159);
INSERT INTO `t_role_menu` VALUES (2, 116);
INSERT INTO `t_role_menu` VALUES (2, 117);
INSERT INTO `t_role_menu` VALUES (2, 119);
INSERT INTO `t_role_menu` VALUES (2, 120);
INSERT INTO `t_role_menu` VALUES (2, 121);
INSERT INTO `t_role_menu` VALUES (2, 122);
INSERT INTO `t_role_menu` VALUES (2, 123);
INSERT INTO `t_role_menu` VALUES (2, 118);
INSERT INTO `t_role_menu` VALUES (2, 125);
INSERT INTO `t_role_menu` VALUES (2, 167);
INSERT INTO `t_role_menu` VALUES (2, 168);
INSERT INTO `t_role_menu` VALUES (2, 169);
INSERT INTO `t_role_menu` VALUES (2, 178);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `USERNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `INTEGRAL` bigint(21) NULL DEFAULT NULL COMMENT '积分',
  `EMAIL` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `MOBILE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `STATUS` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态 0锁定 1有效',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `LAST_LOGIN_TIME` datetime(0) NULL DEFAULT NULL COMMENT '最近访问时间',
  `AVATAR` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `PLAIN` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密钥',
  PRIMARY KEY (`USER_ID`) USING BTREE,
  INDEX `t_user_username`(`USERNAME`) USING BTREE,
  INDEX `t_user_mobile`(`MOBILE`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'Prock.Liy', 'cb62ad1497597283961545d608f80241', 1, 'mrbird@qq.com', '17788888888', '1', '2019-06-14 20:39:22', '2019-12-04 16:47:11', '2019-12-04 16:48:10', 'cnrhVkzwxjPwAaCfPbdc.png', '');
INSERT INTO `t_user` VALUES (2, 'Scott', '1d685729d113cfd03872f154939bee1c', 10, 'scott@gmail.com', '17722222222', '1', '2019-06-14 20:55:53', '2019-06-14 21:05:43', '2021-03-01 22:14:23', 'gaOngJwsRYRaVAuXXcmB.png', '');
INSERT INTO `t_user` VALUES (3, 'Reina', '1461afff857c02afbfb768aa3771503d', 4, 'Reina@hotmail.com', '17711111111', '0', '2019-06-14 21:07:38', '2019-06-14 21:09:06', '2019-06-14 21:08:26', '5997fedcc7bd4cffbd350b40d1b5b987.jpg', '');
INSERT INTO `t_user` VALUES (4, 'Micaela', '9f2daa2c7bed6870fcbb5b9a51d6300e', 10, 'Micaela@163.com', '17733333333', '1', '2019-06-14 21:10:13', '2019-06-14 21:11:26', '2019-06-14 21:10:37', '20180414165909.jpg', '');
INSERT INTO `t_user` VALUES (5, 'Jana', '176679b77b3c3e352bd3b30ddc81083e', 8, 'Jana@126.com', '17744444444', '1', '2019-06-14 21:12:16', '2019-06-14 21:12:52', '2019-06-14 21:12:32', '20180414165821.jpg', '');
INSERT INTO `t_user` VALUES (6, 'Georgie', 'dffc683378cdaa015a0ee9554c532225', 3, 'Georgie@qq.com', '17766666666', '0', '2019-06-14 21:15:09', '2019-06-14 21:16:25', '2019-06-14 21:16:11', 'BiazfanxmamNRoxxVxka.png', '');
INSERT INTO `t_user` VALUES (7, 'Margot', '31379841b9f4bfde22b8b40471e9a6ce', 9, 'Margot@qq.com', '13444444444', '1', '2019-06-14 21:17:53', '2019-06-14 21:18:59', '2019-06-14 21:18:07', '20180414165834.jpg', '');
INSERT INTO `t_user` VALUES (12, 'test', '65d45bea2732d9e0f7176ad6137438c3', 0, 'long2273864459@163.com', NULL, '1', '2021-03-10 17:41:36', NULL, NULL, 'default.jpg', 'admin');
INSERT INTO `t_user` VALUES (13, 'migooo', '6d0e365b73938daa5587c2092dc7118d', 0, '973792099@qq.com', NULL, '1', '2021-03-10 17:50:16', NULL, NULL, 'default.jpg', '111111');

-- ----------------------------
-- Table structure for t_user_data_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_user_data_permission`;
CREATE TABLE `t_user_data_permission`  (
  `USER_ID` bigint(20) NOT NULL,
  `DEPT_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`USER_ID`, `DEPT_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户数据权限关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user_data_permission
-- ----------------------------
INSERT INTO `t_user_data_permission` VALUES (1, 1);
INSERT INTO `t_user_data_permission` VALUES (1, 2);
INSERT INTO `t_user_data_permission` VALUES (1, 3);
INSERT INTO `t_user_data_permission` VALUES (1, 4);
INSERT INTO `t_user_data_permission` VALUES (1, 5);
INSERT INTO `t_user_data_permission` VALUES (1, 6);
INSERT INTO `t_user_data_permission` VALUES (2, 1);
INSERT INTO `t_user_data_permission` VALUES (2, 2);
INSERT INTO `t_user_data_permission` VALUES (3, 4);
INSERT INTO `t_user_data_permission` VALUES (4, 5);
INSERT INTO `t_user_data_permission` VALUES (9, 1);
INSERT INTO `t_user_data_permission` VALUES (10, 1);
INSERT INTO `t_user_data_permission` VALUES (11, 1);
INSERT INTO `t_user_data_permission` VALUES (12, 1);
INSERT INTO `t_user_data_permission` VALUES (13, 1);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `USER_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  INDEX `t_user_role_user_id`(`USER_ID`) USING BTREE,
  INDEX `t_user_role_role_id`(`ROLE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, 1);
INSERT INTO `t_user_role` VALUES (2, 2);
INSERT INTO `t_user_role` VALUES (3, 77);
INSERT INTO `t_user_role` VALUES (4, 78);
INSERT INTO `t_user_role` VALUES (5, 79);
INSERT INTO `t_user_role` VALUES (6, 80);
INSERT INTO `t_user_role` VALUES (7, 78);
INSERT INTO `t_user_role` VALUES (7, 79);
INSERT INTO `t_user_role` VALUES (7, 80);

-- ----------------------------
-- Table structure for teacher_counselor
-- ----------------------------
DROP TABLE IF EXISTS `teacher_counselor`;
CREATE TABLE `teacher_counselor`  (
  `CODE` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'code',
  `AVATAR` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像',
  `TITLE` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `DESCRIPTION` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`CODE`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '师资表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of teacher_counselor
-- ----------------------------
INSERT INTO `teacher_counselor` VALUES (1, 'http://8.136.200.209:8081/pictures/shizi1.jpg', '古月今心-中国总在演讲教练', '莲花演说创始人是消除怯场、紧张忘词专家古月今心老师。\r\n古月老师于2007年开始从事演讲事业，至今已12年。古月老师及其教练团队，已帮助上万名企业老板、职场精英突破自我，提升自信，实现了演说梦！', '2021-03-15 13:37:13', NULL);
INSERT INTO `teacher_counselor` VALUES (2, 'http://8.136.200.209:8081/pictures/shizi2.jpg', '周双明-中国总裁演讲教练', '青少年班系列课程主讲教练。周老师毕业于湖南省第一师范，渊博的学识素养以及帅气俊朗的面孔，深受广大学员青睐。', '2021-03-15 13:43:26', NULL);
INSERT INTO `teacher_counselor` VALUES (3, 'http://8.136.200.209:8081/pictures/shizi3.jpg', '王天霖-中国总裁演讲教练', '毕业于西北政法大学法学专业\r\n8年演讲口才培训经验', '2021-03-15 13:44:51', NULL);
INSERT INTO `teacher_counselor` VALUES (4, 'http://8.136.200.209:8081/pictures/shizi4.jpg', '徐海香-中国总裁演讲教练', '2014年结缘演讲培训行业，从市场做起，多次荣获销售冠军！怀着对舞台的梦想，经过系统训练成长为专职演讲教练，\r\n现如今是莲花演说唯一一位专职女讲师', '2021-03-15 13:47:18', NULL);
INSERT INTO `teacher_counselor` VALUES (5, 'http://8.136.200.209:8081/pictures/shizi5.jpg', '王杰-中国总裁演讲教练', '莲花演说 中国总裁演讲教练。从小酷爱演讲，极具演讲天赋，大学毕业就和古月老师结缘，从重庆到长沙，再到上海，北京……全国各地学习演讲，成为莲花演说成长最快的演讲教练之一。已帮助了上千名职场精英和优秀企业家提升演讲能力。', '2021-03-15 13:50:39', NULL);
INSERT INTO `teacher_counselor` VALUES (6, 'http://8.136.200.209:8081/pictures/shizi6.jpg', '王银雷-中国总裁演讲教练', '毕业于河南科技学院汉语言文学专业，四年的文学熏陶奠定了深厚的演讲底蕴，2年的高中语文教学更是如虎添翼，这也是他快速成长为莲花演说优秀演讲教练的最大基石。正如王老师的格言：韶华足惜，莫将温饱误平生！所以他毅然而然地放弃自己的铁饭碗走进莲花演说，将帮助企业家提升演讲力为毕生使命。', '2021-03-15 13:51:38', NULL);

SET FOREIGN_KEY_CHECKS = 1;
