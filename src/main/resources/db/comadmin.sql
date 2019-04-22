/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : comadmin

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-03-29 15:22:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for asa_caichan
-- ----------------------------
DROP TABLE IF EXISTS `asa_caichan`;
CREATE TABLE `asa_caichan` (
  `id` varchar(36) NOT NULL,
  `xuesheng_id` varchar(255) DEFAULT NULL COMMENT '学生_id',
  `personal_name` varchar(255) DEFAULT NULL COMMENT '财务名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of asa_caichan
-- ----------------------------
INSERT INTO `asa_caichan` VALUES ('1', '201811346801', '赵公子', '兰博基尼 限量版 30000000.00元  你狠牛逼');
INSERT INTO `asa_caichan` VALUES ('200c5428fdbe45cfac83b752fddb9e52', '893023742837', '王大拿', '赵日天你个傻逼');

-- ----------------------------
-- Table structure for asa_churu
-- ----------------------------
DROP TABLE IF EXISTS `asa_churu`;
CREATE TABLE `asa_churu` (
  `id` varchar(36) NOT NULL,
  `laifang_name` varchar(255) DEFAULT NULL COMMENT '来访人姓名',
  `laifang_shijian` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '来访时间',
  `laifang_yuanyin` varchar(255) DEFAULT NULL COMMENT '来访原因',
  `laifang_dianhua` varchar(255) DEFAULT NULL COMMENT '来访人_电话',
  `beifang_name` varchar(255) DEFAULT NULL COMMENT '被访人姓名',
  `beifang_sushehao` varchar(255) DEFAULT NULL COMMENT '被访人宿舍',
  `beifang_banji` varchar(255) DEFAULT NULL COMMENT '被访人班级',
  `beifang_dianhua` varchar(255) DEFAULT NULL COMMENT '被访人电话',
  `likeishijian` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '离开时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of asa_churu
-- ----------------------------
INSERT INTO `asa_churu` VALUES ('1', '孙大圣', '2019-03-29 12:08:54', '调查是否受贿涉黑', '110', '赵公子', 'A号楼301', '大一（3）班', '18197652319', '2019-03-29 12:08:54');
INSERT INTO `asa_churu` VALUES ('2fdb50b9431d4505a06f266edf68a014', '你爸爸', '2019-03-29 15:19:49', '你个二百五', '120', '王大拿', '405', '大二（6）班', '	 19178635376a', null);

-- ----------------------------
-- Table structure for asa_huowu
-- ----------------------------
DROP TABLE IF EXISTS `asa_huowu`;
CREATE TABLE `asa_huowu` (
  `id` varchar(36) NOT NULL,
  `xingming` varchar(255) DEFAULT NULL COMMENT '姓名',
  `xuehao` varchar(255) DEFAULT NULL COMMENT '学号',
  `banji` varchar(255) DEFAULT NULL COMMENT '班级',
  `sushe` varchar(255) DEFAULT NULL COMMENT '宿舍',
  `dianhua` varchar(255) DEFAULT NULL COMMENT '电话',
  `huowu` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `shijian` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '时间',
  `churu` int(11) DEFAULT NULL COMMENT '1.出去2.进入',
  `chuliren` varchar(255) DEFAULT NULL COMMENT '处理人',
  `beizhu` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of asa_huowu
-- ----------------------------
INSERT INTO `asa_huowu` VALUES ('1', '赵公子', '201811346801', '大一（3）班', 'A号楼301', '18197652319', '一箱美金', '2019-03-29 15:21:02', '1', '王阿姨', '滚蛋');
INSERT INTO `asa_huowu` VALUES ('137c1f737fb443d9bb0c081ce884259c', '王大拿', '893023742837', '大二（6）班', '405', '19178635376a', 'TNT炸药', '2019-03-29 15:20:55', '2', ' 你大爷', '炸学校');

-- ----------------------------
-- Table structure for asa_jiaofai
-- ----------------------------
DROP TABLE IF EXISTS `asa_jiaofai`;
CREATE TABLE `asa_jiaofai` (
  `id` varchar(36) NOT NULL,
  `sushehao` varchar(255) DEFAULT NULL COMMENT '宿舍号',
  `jiaofaileixing` varchar(255) DEFAULT NULL COMMENT '缴费类型',
  `jiaofaijine` varchar(255) DEFAULT NULL COMMENT '缴费金额',
  `jiaofaishijian` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '缴费时间',
  `jiaofairen` varchar(255) DEFAULT NULL COMMENT '缴费人',
  `chuliren` varchar(255) DEFAULT NULL COMMENT '处理人',
  `beizhu` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of asa_jiaofai
-- ----------------------------
INSERT INTO `asa_jiaofai` VALUES ('1', 'A号楼301', '电费', '100元', '2019-03-29 09:32:40', '赵日天', '王阿姨', '今晚整个宿舍楼的消费都由赵公子买单');
INSERT INTO `asa_jiaofai` VALUES ('2', 'B单元708', '水费', '100元20快', '2019-03-29 09:36:25', '龙傲天', '张大爷', '一百种让你死的方法');

-- ----------------------------
-- Table structure for asa_xuesheng
-- ----------------------------
DROP TABLE IF EXISTS `asa_xuesheng`;
CREATE TABLE `asa_xuesheng` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sno` varchar(255) DEFAULT NULL COMMENT '学号',
  `banji` varchar(255) DEFAULT NULL COMMENT '班级',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `dorm` varchar(255) DEFAULT NULL COMMENT '宿舍',
  `personal_id` varchar(255) DEFAULT NULL COMMENT '个人财产',
  `state` int(11) DEFAULT NULL COMMENT '1.在线2.退学3.毕业',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of asa_xuesheng
-- ----------------------------
INSERT INTO `asa_xuesheng` VALUES ('1', '赵公子', '201811346801', '大一（3）班', '18197652319', 'A号楼301', '兰博基尼 限量版 30000000.00元   今晚所有的消费都由赵公子买单', '1');
INSERT INTO `asa_xuesheng` VALUES ('2', '王大拿', '893023742837', '大二（6）班', '19178635376a', '405', '100万美元', '1');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(36) NOT NULL,
  `name` varchar(40) DEFAULT NULL COMMENT '菜单名称',
  `parent_id` varchar(36) DEFAULT NULL COMMENT '父菜单',
  `level` bigint(2) DEFAULT NULL COMMENT '菜单层级',
  `parent_ids` varchar(2000) DEFAULT NULL COMMENT '父菜单联集',
  `sort` smallint(6) DEFAULT NULL COMMENT '排序',
  `href` varchar(2000) DEFAULT NULL COMMENT '链接地址',
  `target` varchar(20) DEFAULT NULL COMMENT '打开方式',
  `icon` varchar(100) DEFAULT NULL COMMENT '菜单图标',
  `bg_color` varchar(255) DEFAULT NULL COMMENT '显示背景色',
  `is_show` tinyint(2) DEFAULT NULL COMMENT '是否显示',
  `permission` varchar(200) DEFAULT NULL COMMENT '权限标识',
  `create_by` varchar(36) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(36) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `del_flag` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('0092a6d574804d718e9268c3da756b98', '修改物品', 'a3abf1e7a53a4c50b48845194155a031', '3', 'b97adf85f7bb4c76853d20ca57da9993,a3abf1e7a53a4c50b48845194155a031,0092a6d574804d718e9268c3da756b98,', '2', '', null, null, '', '0', 'sys:asahuowu:edit', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 14:10:59', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 14:29:19', null, '0');
INSERT INTO `sys_menu` VALUES ('08524a615be544cf87464ff18e8f9fa6', '删除财物', '76f1ba92693049269ab826150d056de1', '3', 'b97adf85f7bb4c76853d20ca57da9993,76f1ba92693049269ab826150d056de1,08524a615be544cf87464ff18e8f9fa6,', '3', '', null, null, '', '0', 'sys:asacaichan:delete', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 09:52:26', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 10:05:38', null, '0');
INSERT INTO `sys_menu` VALUES ('13fe7bf6184b48459f2e6f476ea40a4c', '删除出入', '7b8506b422ad4b9baef4abe6d073b60c', '3', 'b97adf85f7bb4c76853d20ca57da9993,7b8506b422ad4b9baef4abe6d073b60c,13fe7bf6184b48459f2e6f476ea40a4c,', '3', '', null, null, '', '0', 'sys:asachuru:delete', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 11:10:08', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 11:27:42', null, '0');
INSERT INTO `sys_menu` VALUES ('151cf969ede744768259ec0b80204e21', '新增物品', 'a3abf1e7a53a4c50b48845194155a031', '3', 'b97adf85f7bb4c76853d20ca57da9993,a3abf1e7a53a4c50b48845194155a031,151cf969ede744768259ec0b80204e21,', '1', '', null, null, '', '0', 'sys:asahuowu:add', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 14:10:47', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 14:29:03', null, '0');
INSERT INTO `sys_menu` VALUES ('153d6f8c77ea406099ad82a4194712bd', '新增财物', '76f1ba92693049269ab826150d056de1', '3', 'b97adf85f7bb4c76853d20ca57da9993,76f1ba92693049269ab826150d056de1,153d6f8c77ea406099ad82a4194712bd,', '1', '', null, null, '', '0', 'sys:asacaichan:add', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 09:51:37', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 10:04:39', null, '0');
INSERT INTO `sys_menu` VALUES ('2379f9232240401ca1ff2f89884879fe', '缴费录入', '5e3a4831971040c99cdb73b0e5d8e7df', '3', 'b97adf85f7bb4c76853d20ca57da9993,5e3a4831971040c99cdb73b0e5d8e7df,2379f9232240401ca1ff2f89884879fe,', '1', '', null, null, '', '0', 'sys:asajiaofai:add', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-28 16:06:11', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-28 16:06:11', null, '0');
INSERT INTO `sys_menu` VALUES ('3b54e2a2-9adb-11e8-aebe-1368d4ec24eb', '用户管理', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb', '2', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb,3b54e2a2-9adb-11e8-aebe-1368d4ec24eb,', '9', '/admin/system/user/list', '', '', '#47e69c', '1', 'sys:user:list', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-01-16 11:31:18', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-01-20 05:59:20', null, '0');
INSERT INTO `sys_menu` VALUES ('3b58e01e-9adb-11e8-aebe-1368d4ec24eb', '角色管理', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb', '2', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb,3b58e01e-9adb-11e8-aebe-1368d4ec24eb,', '10', '/admin/system/role/list', null, '', '#c23ab9', '1', 'sys:role:list', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-01-16 11:32:33', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-01-20 05:58:58', null, '0');
INSERT INTO `sys_menu` VALUES ('3b5cb607-9adb-11e8-aebe-1368d4ec24eb', '权限管理', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb', '2', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb,3b5cb607-9adb-11e8-aebe-1368d4ec24eb,', '20', '/admin/system/menu/list', null, '', '#d4573b', '1', 'sys:menu:list', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-01-16 11:33:19', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 09:49:28', null, '0');
INSERT INTO `sys_menu` VALUES ('3e0b86a3-9adc-11e8-aebe-1368d4ec24eb', '新增用户', '3b54e2a2-9adb-11e8-aebe-1368d4ec24eb', '3', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb,3b54e2a2-9adb-11e8-aebe-1368d4ec24eb,3e0b86a3-9adc-11e8-aebe-1368d4ec24eb,', '0', '', null, null, null, '0', 'sys:user:add', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 10:10:32', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 10:10:32', null, '0');
INSERT INTO `sys_menu` VALUES ('3e2fa8b6-9adc-11e8-aebe-1368d4ec24eb', '编辑用户', '3b54e2a2-9adb-11e8-aebe-1368d4ec24eb', '3', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb,3b54e2a2-9adb-11e8-aebe-1368d4ec24eb,3e2fa8b6-9adc-11e8-aebe-1368d4ec24eb,', '10', '', null, null, null, '0', 'sys:user:edit', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 10:11:49', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 10:11:49', null, '0');
INSERT INTO `sys_menu` VALUES ('3e36cf2f-9adc-11e8-aebe-1368d4ec24eb', '删除用户', '3b54e2a2-9adb-11e8-aebe-1368d4ec24eb', '3', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb,3b54e2a2-9adb-11e8-aebe-1368d4ec24eb,3e36cf2f-9adc-11e8-aebe-1368d4ec24eb,', '20', '', null, null, null, '0', 'sys:user:delete', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 10:12:43', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 10:12:43', null, '0');
INSERT INTO `sys_menu` VALUES ('58bb2536177f4996be20af43ad2e8527', '个人财产', '68d8a5b66e074190af0fe08843667b08', '3', 'b97adf85f7bb4c76853d20ca57da9993,68d8a5b66e074190af0fe08843667b08,58bb2536177f4996be20af43ad2e8527,', '4', '/asaXuesheng/caic', null, null, '', '0', 'sys:asaxuesheng:caichan', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-28 10:10:22', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-28 10:10:22', null, '0');
INSERT INTO `sys_menu` VALUES ('59b3f755756147f2afaebdab61093b69', '编辑学生', '68d8a5b66e074190af0fe08843667b08', '3', 'b97adf85f7bb4c76853d20ca57da9993,68d8a5b66e074190af0fe08843667b08,59b3f755756147f2afaebdab61093b69,', '2', '', null, null, '', '0', 'sys:asaxuesheng:edit', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-27 17:27:00', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-27 17:27:00', null, '0');
INSERT INTO `sys_menu` VALUES ('5e3a4831971040c99cdb73b0e5d8e7df', '缴费管理', 'b97adf85f7bb4c76853d20ca57da9993', '2', 'b97adf85f7bb4c76853d20ca57da9993,5e3a4831971040c99cdb73b0e5d8e7df,', '4', '/asaJiaofai/list', null, '', '', '1', 'sys:asajiaofai:list', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-27 16:11:37', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 15:16:51', null, '0');
INSERT INTO `sys_menu` VALUES ('68c74f7a51994b90a73c8e000064355d', '修改出入', '7b8506b422ad4b9baef4abe6d073b60c', '3', 'b97adf85f7bb4c76853d20ca57da9993,7b8506b422ad4b9baef4abe6d073b60c,68c74f7a51994b90a73c8e000064355d,', '2', '', null, null, '', '0', 'sys:asachuru:edit', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 11:09:53', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 11:27:28', null, '0');
INSERT INTO `sys_menu` VALUES ('68d8a5b66e074190af0fe08843667b08', '学生管理', 'b97adf85f7bb4c76853d20ca57da9993', '2', 'b97adf85f7bb4c76853d20ca57da9993,68d8a5b66e074190af0fe08843667b08,', '5', '/asaXuesheng/list', null, '', '', '1', 'sys:asaxuesheng:list', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-27 15:15:04', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 15:16:39', null, '0');
INSERT INTO `sys_menu` VALUES ('6f09f143e0f747b29409b52ace1e79ee', '缴费修改', '5e3a4831971040c99cdb73b0e5d8e7df', '3', 'b97adf85f7bb4c76853d20ca57da9993,5e3a4831971040c99cdb73b0e5d8e7df,6f09f143e0f747b29409b52ace1e79ee,', '2', '', null, null, '', '0', 'sys:asajiaofai:edit', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-28 16:06:28', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-28 16:06:28', null, '0');
INSERT INTO `sys_menu` VALUES ('76f1ba92693049269ab826150d056de1', '财物管理', 'b97adf85f7bb4c76853d20ca57da9993', '2', 'b97adf85f7bb4c76853d20ca57da9993,76f1ba92693049269ab826150d056de1,', '3', '/asaCaichan/list', null, '', '', '1', 'sys:asacaichan:list', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 09:50:55', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 15:17:06', null, '0');
INSERT INTO `sys_menu` VALUES ('7b8506b422ad4b9baef4abe6d073b60c', '来访管理', 'b97adf85f7bb4c76853d20ca57da9993', '2', 'b97adf85f7bb4c76853d20ca57da9993,7b8506b422ad4b9baef4abe6d073b60c,', '2', '/asaChuru/list', null, '', '', '1', 'sys:asachuru:list', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-27 15:16:27', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 15:17:22', null, '0');
INSERT INTO `sys_menu` VALUES ('7d1020ee-9ad9-11e8-aebe-1368d4ec24eb', '系统管理', null, '1', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb,', '1', '', null, '', null, '1', '', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-01-16 11:29:46', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-01-20 03:09:26', null, '0');
INSERT INTO `sys_menu` VALUES ('96fd6a5a-9adb-11e8-aebe-1368d4ec24eb', '新增权限', '3b5cb607-9adb-11e8-aebe-1368d4ec24eb', '3', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb,3b5cb607-9adb-11e8-aebe-1368d4ec24eb,96fd6a5a-9adb-11e8-aebe-1368d4ec24eb,', '0', '', null, null, null, '0', 'sys:menu:add', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 09:49:15', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 09:49:38', null, '0');
INSERT INTO `sys_menu` VALUES ('9703ccf2-9adb-11e8-aebe-1368d4ec24eb', '编辑权限', '3b5cb607-9adb-11e8-aebe-1368d4ec24eb', '3', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb,3b5cb607-9adb-11e8-aebe-1368d4ec24eb,9703ccf2-9adb-11e8-aebe-1368d4ec24eb,', '10', '', null, null, null, '0', 'sys:menu:edit', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 09:50:16', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 09:50:25', null, '0');
INSERT INTO `sys_menu` VALUES ('9707cf58-9adb-11e8-aebe-1368d4ec24eb', '删除权限', '3b5cb607-9adb-11e8-aebe-1368d4ec24eb', '3', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb,3b5cb607-9adb-11e8-aebe-1368d4ec24eb,9707cf58-9adb-11e8-aebe-1368d4ec24eb,', '20', '', null, null, null, '0', 'sys:menu:delete', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 09:51:53', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 09:53:42', null, '0');
INSERT INTO `sys_menu` VALUES ('a3abf1e7a53a4c50b48845194155a031', '物品管理', 'b97adf85f7bb4c76853d20ca57da9993', '2', 'b97adf85f7bb4c76853d20ca57da9993,a3abf1e7a53a4c50b48845194155a031,', '1', '/asaHuowu/list', null, '', '', '1', 'sys:asahuowu:list', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 14:10:27', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 15:17:32', null, '0');
INSERT INTO `sys_menu` VALUES ('a469c6b9c282470d9c294f29a5a86b6e', '修改财物', '76f1ba92693049269ab826150d056de1', '3', 'b97adf85f7bb4c76853d20ca57da9993,76f1ba92693049269ab826150d056de1,a469c6b9c282470d9c294f29a5a86b6e,', '2', '', null, null, '', '0', 'sys:asacaichan:edit', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 09:51:56', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 10:05:17', null, '0');
INSERT INTO `sys_menu` VALUES ('a49e9e5986e9436ba2f117d4366159d7', '新增学生', '68d8a5b66e074190af0fe08843667b08', '3', 'b97adf85f7bb4c76853d20ca57da9993,68d8a5b66e074190af0fe08843667b08,a49e9e5986e9436ba2f117d4366159d7,', '1', '', null, null, '', '0', 'sys:asaxuesheng:add', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-27 17:26:15', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-27 17:26:15', null, '0');
INSERT INTO `sys_menu` VALUES ('afbb22e1985d438aacf2435825787c13', '缴费删除', '5e3a4831971040c99cdb73b0e5d8e7df', '3', 'b97adf85f7bb4c76853d20ca57da9993,5e3a4831971040c99cdb73b0e5d8e7df,afbb22e1985d438aacf2435825787c13,', '3', '', null, null, '', '0', 'sys:asajiaofai:delete', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-28 16:06:47', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-28 16:06:47', null, '0');
INSERT INTO `sys_menu` VALUES ('b97adf85f7bb4c76853d20ca57da9993', '宿舍管理', null, '1', 'b97adf85f7bb4c76853d20ca57da9993,', '2', '', null, '', '', '1', '', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-27 15:14:29', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-27 15:14:30', null, '0');
INSERT INTO `sys_menu` VALUES ('bfe2aac3db72456db680ad192d606d7a', '删除物品', 'a3abf1e7a53a4c50b48845194155a031', '3', 'b97adf85f7bb4c76853d20ca57da9993,a3abf1e7a53a4c50b48845194155a031,bfe2aac3db72456db680ad192d606d7a,', '3', '', null, null, '', '0', 'sys:asahuowu:delete', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 14:11:10', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 14:29:34', null, '0');
INSERT INTO `sys_menu` VALUES ('d3f48e0e705a45c7b18e4cc730cb8b2e', '新增出入', '7b8506b422ad4b9baef4abe6d073b60c', '3', 'b97adf85f7bb4c76853d20ca57da9993,7b8506b422ad4b9baef4abe6d073b60c,d3f48e0e705a45c7b18e4cc730cb8b2e,', '1', '', null, null, '', '0', 'sys:asachuru:add', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 11:09:39', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 11:27:12', null, '0');
INSERT INTO `sys_menu` VALUES ('ed63866b30cf46bfb6797a1d31ae930c', '锁定用户', '3b54e2a2-9adb-11e8-aebe-1368d4ec24eb', '3', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb,3b54e2a2-9adb-11e8-aebe-1368d4ec24eb,ed63866b30cf46bfb6797a1d31ae930c,', '21', '', null, null, '', '0', 'sys:user:lock', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-08-21 17:44:05', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-08-21 17:44:05', null, '0');
INSERT INTO `sys_menu` VALUES ('f583d3aedb1249e48cab5d1172a710f3', '结束访问', '7b8506b422ad4b9baef4abe6d073b60c', '3', 'b97adf85f7bb4c76853d20ca57da9993,7b8506b422ad4b9baef4abe6d073b60c,f583d3aedb1249e48cab5d1172a710f3,', '4', '', null, null, '', '0', 'sys:asachuru:edits', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 12:36:27', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 12:36:27', null, '0');
INSERT INTO `sys_menu` VALUES ('f627453e6b824b128b6a88974b7dd175', '删除学生', '68d8a5b66e074190af0fe08843667b08', '3', 'b97adf85f7bb4c76853d20ca57da9993,68d8a5b66e074190af0fe08843667b08,f627453e6b824b128b6a88974b7dd175,', '3', '', null, null, '', '0', 'sys:asaxuesheng:delete', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-27 17:27:31', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-27 17:27:32', null, '0');
INSERT INTO `sys_menu` VALUES ('ff619e04-9adb-11e8-aebe-1368d4ec24eb', '新增角色', '3b58e01e-9adb-11e8-aebe-1368d4ec24eb', '3', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb,3b58e01e-9adb-11e8-aebe-1368d4ec24eb,ff619e04-9adb-11e8-aebe-1368d4ec24eb,', '0', '', null, null, null, '0', 'sys:role:add', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 09:58:11', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 09:58:11', null, '0');
INSERT INTO `sys_menu` VALUES ('ff9477c9-9adb-11e8-aebe-1368d4ec24eb', '编辑权限', '3b58e01e-9adb-11e8-aebe-1368d4ec24eb', '3', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb,3b58e01e-9adb-11e8-aebe-1368d4ec24eb,ff9477c9-9adb-11e8-aebe-1368d4ec24eb,', '10', '', null, null, null, '0', 'sys:role:edit', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 09:59:01', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 09:59:01', null, '0');
INSERT INTO `sys_menu` VALUES ('ff9ad846-9adb-11e8-aebe-1368d4ec24eb', '删除角色', '3b58e01e-9adb-11e8-aebe-1368d4ec24eb', '3', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb,3b58e01e-9adb-11e8-aebe-1368d4ec24eb,ff9ad846-9adb-11e8-aebe-1368d4ec24eb,', '20', '', null, null, null, '0', 'sys:role:delete', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 09:59:56', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2018-02-08 09:59:56', null, '0');

-- ----------------------------
-- Table structure for sys_rescource
-- ----------------------------
DROP TABLE IF EXISTS `sys_rescource`;
CREATE TABLE `sys_rescource` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `file_name` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `source` varchar(255) DEFAULT NULL COMMENT '来源',
  `web_url` varchar(500) DEFAULT NULL COMMENT '资源网络地址',
  `hash` varchar(255) DEFAULT NULL COMMENT '文件标识',
  `file_size` varchar(50) DEFAULT NULL COMMENT '文件大小',
  `file_type` varchar(255) DEFAULT NULL COMMENT '文件类型',
  `original_net_url` text,
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(36) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(36) DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` tinyint(4) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统资源';

-- ----------------------------
-- Records of sys_rescource
-- ----------------------------
INSERT INTO `sys_rescource` VALUES ('e448c97cbd07401bac0212f71becbef0', '41bd2e33-1964-4303-9c05-dc4563609733.jpg', 'local', '/static/upload/41bd2e33-1964-4303-9c05-dc4563609733.jpg', 'FsDja5WT-0Sh5hp6eRSYlrP8RtIQ', '68kb', 'image/jpeg', null, '2019-03-27 14:37:04', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-27 14:37:04', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', null, '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(36) NOT NULL,
  `name` varchar(40) DEFAULT NULL COMMENT '角色名称',
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(36) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(36) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `del_flag` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('70689483-9ad7-11e8-aebe-1368d4ec24eb', '系统管理员权限', '2017-11-02 14:19:07', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-28 15:04:58', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '你说', '0');
INSERT INTO `sys_role` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '超级管理员权限', '2017-11-29 19:36:37', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-29 14:16:02', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '', '0');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` varchar(36) NOT NULL,
  `menu_id` varchar(36) NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('70689483-9ad7-11e8-aebe-1368d4ec24eb', '3b54e2a2-9adb-11e8-aebe-1368d4ec24eb');
INSERT INTO `sys_role_menu` VALUES ('70689483-9ad7-11e8-aebe-1368d4ec24eb', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '0092a6d574804d718e9268c3da756b98');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '08524a615be544cf87464ff18e8f9fa6');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '13fe7bf6184b48459f2e6f476ea40a4c');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '151cf969ede744768259ec0b80204e21');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '153d6f8c77ea406099ad82a4194712bd');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '2379f9232240401ca1ff2f89884879fe');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '3b54e2a2-9adb-11e8-aebe-1368d4ec24eb');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '3b58e01e-9adb-11e8-aebe-1368d4ec24eb');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '3b5cb607-9adb-11e8-aebe-1368d4ec24eb');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '3e0b86a3-9adc-11e8-aebe-1368d4ec24eb');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '3e2fa8b6-9adc-11e8-aebe-1368d4ec24eb');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '3e36cf2f-9adc-11e8-aebe-1368d4ec24eb');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '58bb2536177f4996be20af43ad2e8527');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '59b3f755756147f2afaebdab61093b69');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '5e3a4831971040c99cdb73b0e5d8e7df');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '68c74f7a51994b90a73c8e000064355d');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '68d8a5b66e074190af0fe08843667b08');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '6f09f143e0f747b29409b52ace1e79ee');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '76f1ba92693049269ab826150d056de1');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '7b8506b422ad4b9baef4abe6d073b60c');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '7d1020ee-9ad9-11e8-aebe-1368d4ec24eb');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '96fd6a5a-9adb-11e8-aebe-1368d4ec24eb');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '9703ccf2-9adb-11e8-aebe-1368d4ec24eb');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', '9707cf58-9adb-11e8-aebe-1368d4ec24eb');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', 'a3abf1e7a53a4c50b48845194155a031');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', 'a469c6b9c282470d9c294f29a5a86b6e');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', 'a49e9e5986e9436ba2f117d4366159d7');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', 'afbb22e1985d438aacf2435825787c13');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', 'b97adf85f7bb4c76853d20ca57da9993');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', 'bfe2aac3db72456db680ad192d606d7a');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', 'd3f48e0e705a45c7b18e4cc730cb8b2e');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', 'ed63866b30cf46bfb6797a1d31ae930c');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', 'f583d3aedb1249e48cab5d1172a710f3');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', 'f627453e6b824b128b6a88974b7dd175');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', 'ff619e04-9adb-11e8-aebe-1368d4ec24eb');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', 'ff9477c9-9adb-11e8-aebe-1368d4ec24eb');
INSERT INTO `sys_role_menu` VALUES ('706e0195-9ad7-11e8-aebe-1368d4ec24eb', 'ff9ad846-9adb-11e8-aebe-1368d4ec24eb');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(36) NOT NULL COMMENT '用户ID',
  `login_name` varchar(36) DEFAULT NULL COMMENT '登录名',
  `nick_name` varchar(40) DEFAULT NULL COMMENT '昵称',
  `icon` varchar(2000) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL COMMENT '密码',
  `salt` varchar(40) DEFAULT NULL COMMENT 'shiro加密盐',
  `tel` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱地址',
  `locked` tinyint(2) DEFAULT NULL COMMENT '是否锁定',
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(36) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(36) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `del_flag` tinyint(4) NOT NULL,
  `is_admin` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('18b8b543-9ad7-11e8-aebe-1368d4ec24eb', 'admin', '超级管理员', '/static/upload/41bd2e33-1964-4303-9c05-dc4563609733.jpg', 'b9101ad39cfade54dadf02d873553f71c8cf9871', '72fe6288b257ba16', '13776055179', 'b@qq.com', '0', '2017-11-27 22:19:39', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-28 15:08:46', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '', '0', '1');
INSERT INTO `sys_user` VALUES ('3194f4987a7a4771a5ba0959dadaf857', 'admin1', '系统管理员', null, '9bbf7c58b4119ce8bb1dc1ad7be751643bfe69e1', '057ab139f2ea973e', '18191736320', '876053738@qq.com', '0', '2019-03-27 14:17:54', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '2019-03-27 14:17:54', '18b8b543-9ad7-11e8-aebe-1368d4ec24eb', null, '0', '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('18b8b543-9ad7-11e8-aebe-1368d4ec24eb', '706e0195-9ad7-11e8-aebe-1368d4ec24eb');
INSERT INTO `sys_user_role` VALUES ('3194f4987a7a4771a5ba0959dadaf857', '70689483-9ad7-11e8-aebe-1368d4ec24eb');

-- ----------------------------
-- Function structure for currval
-- ----------------------------
DROP FUNCTION IF EXISTS `currval`;
DELIMITER ;;
CREATE DEFINER=`root`@`127.0.0.1` FUNCTION `currval`(seq_name VARCHAR(50)) RETURNS int(11)
    READS SQL DATA
    DETERMINISTIC
BEGIN  
DECLARE v INTEGER;  
SET v = 0;  
SELECT current_value INTO v FROM sequence WHERE NAME = seq_name;  
RETURN v;  
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`127.0.0.1` FUNCTION `nextval`(seq_name VARCHAR(50)) RETURNS int(11)
    DETERMINISTIC
BEGIN  
UPDATE sequence SET current_value = current_value + increment WHERE NAME = seq_name;  
RETURN currval(seq_name);  
END
;;
DELIMITER ;
SET FOREIGN_KEY_CHECKS=1;
