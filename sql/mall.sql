--
-- Create database `mall` if it does not exist
--
CREATE DATABASE IF NOT EXISTS mall;
USE mall;

--
-- Table structure for table `cart`
--
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `goodsname` VARCHAR(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `number` INT NOT NULL,
  `price` INT NOT NULL,
  `goodid` INT NOT NULL,
  `uid` INT NOT NULL,
  `gpicture` VARCHAR(255) COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

--
-- Dumping data for table `cart`
--
INSERT INTO `cart` VALUES (33, '苹果', 2, 8, 1, 1, NULL);

--
-- Table structure for table `comment`
--
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` VARCHAR(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '用户id',
  `uname` VARCHAR(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '用户名称',
  `time` VARCHAR(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '时间',
  `comment` VARCHAR(255) COLLATE utf8mb3_bin NOT NULL COMMENT '评论',
  `gid` INT NOT NULL COMMENT '商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

--
-- Dumping data for table `comment`
--
INSERT INTO `comment` VALUES
(1, '1', '杨汉', '2023/1/1', '你说的对但是', 1),
(2, '2', '杨志', '2023/2/1', '你所热爱的是你的生活', 2),
(3, '1', '233', '2033/1/1', '1111', 1),
(4, '1', '234', '2043/1/1', '2222', 1),
(5, '1', 'test', '2022/2/1', '3333', 2);

--
-- Table structure for table `goods`
--
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `gid` INT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gname` VARCHAR(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '商品名称',
  `gpicture` VARCHAR(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '商品图片地址',
  `gdetails` VARCHAR(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '商品介绍',
  `gprice` INT NOT NULL COMMENT '商品价格',
  `types` INT NOT NULL COMMENT '商品类别',
  `sales` INT DEFAULT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

--
-- Dumping data for table `goods`
--
INSERT INTO `goods` VALUES
(1, 'MacBook Air (M1)', '/img/goods/mba_m1.png', '13.6 英寸、Liquid 视网膜显示屏、Apple M2 芯片、SoC 芯片、M2 芯片、8 核中央处理器，具有 4 个性能核心和 4 个能效核心、最高可选配 10 核图形处理器、16 核神经网络引擎、100GB/s 内存带宽', 9499, 0, 0),
(2, 'MacBook Air (M2)', '/img/goods/mba_m2.png', '13.3 英寸、视网膜显示屏、Apple M1 芯片、SoC 芯片、M1 芯片、8 核中央处理器，具有 4 个性能核心和 4 个能效核心、7 核图形处理器、16 核神经网络引擎', 7999, 0, 0),
(3, 'MacBook Pro 13 英寸 (M2)', '/img/goods/mbp13.png', '13.3 英寸视网膜显示屏、Apple M2 芯片、8 核中央处理器、10 核图形处理器、最高可达24GB统一内存、最高可达2TB存储容量、20 小时、电池续航、触控栏和触控 ID', 9999, 0, 0),
(4, 'MacBook Pro 14 英寸 (M2 Pro 或 M2 Max)', '/img/goods/mbp14.png', '14.2 英寸Liquid 视网膜 XDR 显示屏、Apple M2 Pro 芯片或Apple M2 Max 芯片、最高可达12 核中央处理器、最高可达38 核图形处理器、最高可达96GB统一内存、最高可达8TB存储容量、18 小时、电池续航、触控 ID', 15999, 0, 0),
(5, 'MacBook Pro 16 英寸 (M2 Pro 或 M2 Max)', '/img/goods/mbp16.png', '16.2 英寸、Liquid 视网膜 XDR 显示屏、Apple M2 Pro 芯片或Apple M2 Max 芯片、12 核中央处理器、最高可达38 核图形处理器、最高可达96GB统一内存、8TB存储容量、最长可达22小时电池续航、触控 ID', 19999, 0, 0),
(6, 'iMac (M1)', '/img/goods/imac_24.png', '24 英寸4.5K 视网膜显示屏、Apple M1 芯片、8 核中央处理器、7 核图形处理器、最高可达16GB统一内存、最高可达1TB存储容量、带有锁定键的妙控键盘、可选配触控 ID 版本', 9999, 0, 0),
(7, 'Mac mini (M2 或 M2 Pro)', '/img/goods/mac_mini_m2.png', 'Apple M2 芯片或Apple M2 Pro 芯片、最高可达12 核中央处理器、最高可达19 核图形处理器、32GB统一内存、最高可达8TB存储容量', 4499, 0, 0),
(8, 'Mac Studio (M1 Max 或 M1 Ultra)', '/img/goods/mac_studio.jpg', 'Apple M1 Max 芯片或Apple M1 Ultra 芯片、最高可达20 核中央处理器、最高可达64 核图形处理器、最高可达128GB、最高可达8TB存储容量', 14999, 0, 0),
(9, 'Mac Pro (Intel)', '/img/goods/mac_pro.png', 'IntelXeon W 处理器、最高可达28 核中央处理器、最高可达AMD Radeon Pro W6800X Duo 图形处理器、最高可达1.5TB内存、最高可达8TB', 47999, 0, 0),
(10, 'iPad Pro', '/img/goods/ipad_pro.png', '前沿技术，终极 iPad 体验。Liquid 视网膜 XDR 显示屏或 Liquid 视网膜显示屏、ProMotion 自适应刷新率技术、P3 广色域、抗反射涂层。', 6799, 1, 0),
(11, 'iPad Air', '/img/goods/ipad_air.png', '重量级实力，轻装上阵。Liquid 视网膜显示屏、P3 广色域、抗反射涂层、M1 芯片、1200 万像素超广角、前置��像头、200 万像素广角摄像头、4K 视频拍摄', 4799, 1, 0),
(12, 'iPad 第十代', '/img/goods/ipad_10.png', '多彩 iPad，天天玩得转。10.9 英寸、Liquid 视网膜显示屏、sRGB 色域、A14 仿生芯片', 3599, 1, 0),
(13, 'iPad mini', '/img/goods/ipad_mini.png', '全 iPad 体验，一手在握。8.3 英寸、Liquid 视网膜显示屏、P3 广色域、抗反射涂层、A15 仿生芯片', 3999, 1, 0);

--
-- Table structure for table `user`
--
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uaccount` INT NOT NULL AUTO_INCREMENT COMMENT '账号',
  `upassword` VARCHAR(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '密码',
  `uname` VARCHAR(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '姓名',
  `usex` VARCHAR(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '性别',
  `uaddress` VARCHAR(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `utel` VARCHAR(255) COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`uaccount`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

--
-- Dumping data for table `user`
--
INSERT INTO `user` VALUES
(1, '123456', 'ptu', '男', 'hahahaha', '114514'),
(7, '202cb962ac59075b964b07152d234b70', 'test', '男', '福建省test', '114514'),
(8, '0884d3007f1937b76b2e6548a17f36a5', 'test2', '男', '福建省福州���', '114514'),
(9, 'e10adc3949ba59abbe56e057f20f883e', 'test2333', '', '', '');

--
-- Table structure for table `userorder`
--
DROP TABLE IF EXISTS `userorder`;
CREATE TABLE `userorder` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goodsname` VARCHAR(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '商品名称',
  `number` INT NOT NULL COMMENT '购买数量',
  `price` INT NOT NULL COMMENT '总价',
  `time` DATETIME NOT NULL,
  `uid` INT NOT NULL,
  `gid` INT DEFAULT NULL,
  `gpicture` VARCHAR(255) COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

--
-- Dumping data for table `userorder`
--
INSERT INTO `userorder` VALUES
(14, '苹果', 2, 8, '2023-05-22 08:58:37', 1, 1, NULL),
(15, '香蕉', 3, 6, '2023-05-22 08:58:37', 1, 2, NULL),
(16, '葡萄', 3, 12, '2023-05-22 08:58:37', 1, 3, NULL),
(17, '葡萄', 2, 8, '2023-05-23 01:59:43', 1, 3, 'http://127.0.0.1:8080/img/goods/goods001.jpg'),
(18, '香蕉', 2, 4, '2023-05-23 01:59:43', 1, 2, 'http://127.0.0.1:8080/img/2.jpg'),
(19, '苹果', 2, 8, '2023-05-23 01:59:43', 1, 1, 'http://127.0.0.1:8080/img/goods/goods003.jpg'),
(20, '苹果', 4, 16, '2023-05-23 02:45:26', 1, 1, NULL),
(21, '苹果', 4, 8, '2023-05-23 02:45:26', 1, 2, NULL),
(22, '苹果', 2, 10, '2023-05-23 02:45:26', 1, 5, NULL),
(23, '草莓', 2, 8, '2023-05-23 02:45:26', 1, 3, NULL);