-- -------------------------------------------------------------
-- TablePlus 1.0(170)
--
-- https://tableplus.com/
--
-- Database: yhtstore
-- Generation Time: 2019-01-01 01:22:51.4220
-- -------------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


DROP TABLE IF EXISTS `slider`;
CREATE TABLE `slider` (
  `id` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `img_url` varchar(255) NOT NULL,
  `link_url` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

DROP TABLE IF EXISTS `recommendation`;
CREATE TABLE `recommendation` (
  `id` bigint(20) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc16er5fa5umwsa66isdvqbscc` (`product_id`),
  CONSTRAINT `FKc16er5fa5umwsa66isdvqbscc` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) NOT NULL,
  `shape_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqabibkwkomk3prqwvt4gfryng` (`shape_id`),
  CONSTRAINT `FKqabibkwkomk3prqwvt4gfryng` FOREIGN KEY (`shape_id`) REFERENCES `product_shape` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

DROP TABLE IF EXISTS `product_shape`;
CREATE TABLE `product_shape` (
  `id` bigint(20) NOT NULL,
  `shape` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `clicks` int(11) DEFAULT NULL,
  `date` date NOT NULL,
  `name` varchar(255) NOT NULL,
  `num` varchar(255) NOT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `material_id` bigint(20) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `engraving_id` bigint(20) DEFAULT NULL,
  `detail_img_urls` text NOT NULL,
  `img_url` text NOT NULL,
  `sold` bit(1) DEFAULT NULL,
  `collection_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKayq8bdn719whg00c0wor7skjp` (`author_id`),
  KEY `FKw04fq456sc4tk26tnbhvr59o` (`material_id`),
  KEY `FKajjopj7ffr42w11bav8gut0cp` (`type_id`),
  KEY `FK7ckfbhoe1ong15lyfbglbp9js` (`engraving_id`),
  KEY `FK1m7avyryg7yow6ytttlt7qcun` (`collection_id`),
  CONSTRAINT `FK1m7avyryg7yow6ytttlt7qcun` FOREIGN KEY (`collection_id`) REFERENCES `collection` (`id`),
  CONSTRAINT `FK7ckfbhoe1ong15lyfbglbp9js` FOREIGN KEY (`engraving_id`) REFERENCES `engraving` (`id`),
  CONSTRAINT `FKajjopj7ffr42w11bav8gut0cp` FOREIGN KEY (`type_id`) REFERENCES `product_type` (`id`),
  CONSTRAINT `FKayq8bdn719whg00c0wor7skjp` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  CONSTRAINT `FKw04fq456sc4tk26tnbhvr59o` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

DROP TABLE IF EXISTS `material_type`;
CREATE TABLE `material_type` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `id` bigint(20) NOT NULL,
  `material` varchar(255) NOT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp1xjokysfosr168e1jm60ciut` (`type_id`),
  CONSTRAINT `FKp1xjokysfosr168e1jm60ciut` FOREIGN KEY (`type_id`) REFERENCES `material_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

DROP TABLE IF EXISTS `engraving`;
CREATE TABLE `engraving` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

DROP TABLE IF EXISTS `author_level`;
CREATE TABLE `author_level` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `level_id` bigint(20) DEFAULT NULL,
  `img_url` varchar(255) NOT NULL,
  `profile` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk9w0yeprvl74em9ub9ndyent6` (`level_id`),
  CONSTRAINT `FKk9w0yeprvl74em9ub9ndyent6` FOREIGN KEY (`level_id`) REFERENCES `author_level` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO `author` (`id`, `name`, `level_id`, `img_url`, `profile`) VALUES ('3', '孙尧佳', '16', '/static/uploads/1545726955015-author3.jpg', '作者简介'),
('4', '王润发', '17', '/static/uploads/1545726965551-author2.jpg', ''),
('48', '及时雨', '33', '/static/abc.jpg', ''),
('70', '王思聪1', '69', '/static/uploads/1545726825295-img4.jpg', ''),
('72', '王健林', '69', '/static/uploads/1545790588784-author7.jpg', '万达老总'),
('75', '李子涵', '16', '/static/uploads/1545967109823-img4.jpg', 'hehe');

INSERT INTO `author_level` (`id`, `title`) VALUES ('16', '高工'),
('17', '工程师'),
('33', '艺术家'),
('69', '助工');

INSERT INTO `collection` (`id`, `name`) VALUES ('79', '精品馆');

INSERT INTO `engraving` (`id`, `name`) VALUES ('52', '王润发'),
('68', '打断点'),
('74', '孙尧佳');

INSERT INTO `hibernate_sequence` (`next_val`) VALUES ('82'),
('82'),
('82'),
('82'),
('82'),
('82');

INSERT INTO `material` (`id`, `material`, `type_id`) VALUES ('2', '原矿紫泥', '18'),
('19', '原矿清水泥', '18'),
('20', '原矿底槽青', '18'),
('51', '原矿红泥', '50'),
('62', '测试1', '61'),
('64', '大紫泥', '18'),
('65', '红泥1', '50'),
('76', '测试2', '61');

INSERT INTO `material_type` (`id`, `name`) VALUES ('18', '紫泥'),
('50', '红泥'),
('61', '新类型');

INSERT INTO `product` (`id`, `clicks`, `date`, `name`, `num`, `author_id`, `material_id`, `type_id`, `capacity`, `engraving_id`, `detail_img_urls`, `img_url`, `sold`, `collection_id`) VALUES ('6', '0', '2018-12-28', '紫砂壶1', 'zs001', '3', '2', '1', '0', '74', '/static/uploads/1545974842232-author2.jpg\n/static/uploads/1545974842272-author1.jpg\n/static/uploads/1545974842244-author3.jpg', 'https://youimg1.c-ctrip.com/target/10080j0000009zuyqADB9_R_300_300_Q90.jpg', b'0', '79'),
('7', '0', '2018-12-28', '紫砂壶2', 'zs002', '3', '2', '1', '0', '52', '/static/uploads/1545975072338-img2.jpg\n/static/uploads/1545975072350-img1.jpg\n/static/uploads/1545975072344-img3.jpg', 'https://dimg05.c-ctrip.com/images/100a0c00000064pqzDAB6_C_238_268.jpg', b'0', '79'),
('8', '0', '2018-12-28', '紫砂壶3', 'zs003', '3', '2', '1', '0', '52', '/static/uploads/1545975091622-author6.jpg\n/static/uploads/1545975091625-author5.jpg', 'https://youimg1.c-ctrip.com/target/10080j0000009zuyqADB9_R_300_300_Q90.jpg', b'0', '79'),
('9', '0', '2018-12-28', '紫砂壶4', 'zs004', '3', '2', '1', '0', '74', '/static/uploads/1545975120271-author5.jpg', 'https://dimg02.c-ctrip.com/images/fd/tg/g2/M05/87/D9/Cghzf1WwsVWAFjE2ACqTKYbSfPQ625_D_220_150.jpg', b'0', '79'),
('11', '0', '2018-12-28', '紫砂壶6', 'zs006', '3', '2', '1', '0', '68', '/static/uploads/1545975155589-img4.jpg\n/static/uploads/1545975155582-img5.jpg\n/static/uploads/1545975155649-img3.jpg', 'https://dimg02.c-ctrip.com/images/fd/tg/g2/M05/87/D9/Cghzf1WwsVWAFjE2ACqTKYbSfPQ625_D_220_150.jpg', b'0', '79'),
('54', '0', '2018-12-24', '西施壶', 'xs001', '48', '51', '24', '200', '52', 'https://dimg05.c-ctrip.com/images/100a0c00000064pqzDAB6_C_238_268.jpg\nhttps://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/s%3D220/sign=820a033aad4bd11300cdb0306aaea488/29381f30e924b899e39e9e716e061d950b7bf6dd.jpg\nhttp://n.sinaimg.cn/collect/transform/20170213/mwyT-fyamvns5067899.jpg', 'https://dimg05.c-ctrip.com/images/100a0c00000064pqzDAB6_C_238_268.jpg', b'0', '79'),
('73', '0', '2018-12-28', '测试商品1', 'z111', '4', '20', '24', '300', '68', '/static/uploads/1545975180549-author2.jpg\n/static/uploads/1545975180560-author1.jpg\n/static/uploads/1545975180603-author3.jpg', '/static/uploads/1545812169821-author8.jpg', b'0', '79'),
('80', '0', '2018-12-31', '紫砂壶10', 'zs010', '3', '2', '1', '0', '74', '/static/uploads/1545974842232-author2.jpg\n/static/uploads/1545974842272-author1.jpg\n/static/uploads/1545974842244-author3.jpg', 'https://youimg1.c-ctrip.com/target/10080j0000009zuyqADB9_R_300_300_Q90.jpg', b'0', '79'),
('81', '0', '2018-12-31', '紫砂壶11', 'zs011', '3', '2', '1', '0', '74', '/static/uploads/1545974842232-author2.jpg\n/static/uploads/1545974842272-author1.jpg\n/static/uploads/1545974842244-author3.jpg', 'https://youimg1.c-ctrip.com/target/10080j0000009zuyqADB9_R_300_300_Q90.jpg', b'0', '79');

INSERT INTO `product_shape` (`id`, `shape`) VALUES ('21', '方器'),
('22', '圆器'),
('36', '花塑器'),
('55', '新器型1');

INSERT INTO `product_type` (`id`, `type`, `shape_id`) VALUES ('1', '四方', '21'),
('23', '传炉', '21'),
('24', '西施', '22'),
('25', '半月', '22'),
('43', '鱼化龙', '36'),
('57', '半夜', '22'),
('58', '啊啊啊', '55'),
('60', '半月2', '22'),
('77', '新器型2', '55');

INSERT INTO `recommendation` (`id`, `product_id`) VALUES ('28', '7'),
('32', '6'),
('40', '11'),
('41', '9');

INSERT INTO `slider` (`id`, `date`, `img_url`, `link_url`, `title`) VALUES ('13', '2018-12-20', '/static/uploads/1545276454291-slider5.jpg', 'www.baidu.com', '测试标题'),
('15', '2018-12-21', '/static/uploads/1545282945659-img2.jpg', '123', '123'),
('78', '2018-12-31', '/static/uploads/1546249154372-test2.jpg', '测试连接', '测试');



/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;