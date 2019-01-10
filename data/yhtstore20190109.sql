-- -------------------------------------------------------------
-- TablePlus 1.1(174)
--
-- https://tableplus.com/
--
-- Database: yhtstore
-- Generation Time: 2019-01-09 22:25:27.9720
-- -------------------------------------------------------------


DROP TABLE IF EXISTS "public"."slider";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."slider" (
    "id" int8 NOT NULL,
    "date" date NOT NULL,
    "img_url" varchar(255) NOT NULL,
    "link_url" varchar(255) NOT NULL,
    "title" varchar(255) NOT NULL,
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."recommendation";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."recommendation" (
    "id" int8 NOT NULL,
    "product_id" int8,
    CONSTRAINT "fkc16er5fa5umwsa66isdvqbscc" FOREIGN KEY ("product_id") REFERENCES "public"."product"("id"),
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."product_type";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."product_type" (
    "id" int8 NOT NULL,
    "type" varchar(255) NOT NULL,
    "shape_id" int8,
    CONSTRAINT "fkqabibkwkomk3prqwvt4gfryng" FOREIGN KEY ("shape_id") REFERENCES "public"."product_shape"("id"),
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."product_shape";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."product_shape" (
    "id" int8 NOT NULL,
    "shape" varchar(255) NOT NULL,
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."product";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."product" (
    "id" int8 NOT NULL,
    "capacity" int4,
    "clicks" int4,
    "date" date NOT NULL,
    "detail_img_urls" text NOT NULL,
    "img_url" text NOT NULL,
    "name" varchar(255) NOT NULL,
    "num" varchar(255) NOT NULL,
    "sold" bool,
    "author_id" int8,
    "collection_id" int8,
    "engraving_id" int8,
    "material_id" int8,
    "type_id" int8,
    CONSTRAINT "fk7ckfbhoe1ong15lyfbglbp9js" FOREIGN KEY ("engraving_id") REFERENCES "public"."engraving"("id"),
    CONSTRAINT "fk1m7avyryg7yow6ytttlt7qcun" FOREIGN KEY ("collection_id") REFERENCES "public"."collection"("id"),
    CONSTRAINT "fkayq8bdn719whg00c0wor7skjp" FOREIGN KEY ("author_id") REFERENCES "public"."author"("id"),
    CONSTRAINT "fkajjopj7ffr42w11bav8gut0cp" FOREIGN KEY ("type_id") REFERENCES "public"."product_type"("id"),
    CONSTRAINT "fkw04fq456sc4tk26tnbhvr59o" FOREIGN KEY ("material_id") REFERENCES "public"."material"("id"),
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."material_type";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."material_type" (
    "id" int8 NOT NULL,
    "name" varchar(255) NOT NULL,
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."material";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."material" (
    "id" int8 NOT NULL,
    "material" varchar(255) NOT NULL,
    "type_id" int8,
    CONSTRAINT "fkp1xjokysfosr168e1jm60ciut" FOREIGN KEY ("type_id") REFERENCES "public"."material_type"("id"),
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."engraving";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."engraving" (
    "id" int8 NOT NULL,
    "name" varchar(255) NOT NULL,
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."collection";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."collection" (
    "id" int8 NOT NULL,
    "name" varchar(255) NOT NULL,
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."author_level";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."author_level" (
    "id" int8 NOT NULL,
    "title" varchar(255) NOT NULL,
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."author";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."author" (
    "id" int8 NOT NULL,
    "img_url" text NOT NULL,
    "name" varchar(255) NOT NULL,
    "profile" text NOT NULL,
    "level_id" int8,
    CONSTRAINT "fkk9w0yeprvl74em9ub9ndyent6" FOREIGN KEY ("level_id") REFERENCES "public"."author_level"("id"),
    PRIMARY KEY ("id")
);

INSERT INTO "public"."author" ("id", "img_url", "name", "profile", "level_id") VALUES ('3', '/static/uploads/1545726955015-author3.jpg', '孙尧佳', '作者简介', '16'),
('4', '/static/uploads/1545726965551-author2.jpg', '王润发1', '1111', '17'),
('18', '/static/uploads/1546933106475-img5.jpg', '删作者', '山作者', '69'),
('48', '/static/abc.jpg', '及时雨', '', '33'),
('70', '/static/uploads/1545726825295-img4.jpg', '王思聪1', '', '69'),
('72', '/static/uploads/1545790588784-author7.jpg', '王健林', '万达老总', '69'),
('75', '/static/uploads/1545967109823-img4.jpg', '李子涵', 'hehe', '16');

INSERT INTO "public"."author_level" ("id", "title") VALUES ('16', '高工'),
('17', '工程师'),
('33', '艺术家'),
('69', '助工');

INSERT INTO "public"."collection" ("id", "name") VALUES ('3', '收藏馆'),
('10', '获奖馆'),
('79', '精品馆');

INSERT INTO "public"."engraving" ("id", "name") VALUES ('21', '删刻绘'),
('52', '王润发'),
('68', '打断点'),
('74', '孙尧佳');

INSERT INTO "public"."material" ("id", "material", "type_id") VALUES ('2', '原矿紫泥', '18'),
('19', '原矿清水泥', '18'),
('20', '原矿底槽青', '18'),
('51', '原矿红泥', '50'),
('62', '测试1', '61'),
('64', '大紫泥', '18'),
('65', '红泥1', '50'),
('76', '测试2', '61');

INSERT INTO "public"."material_type" ("id", "name") VALUES ('18', '紫泥'),
('50', '红泥'),
('61', '新类型');

INSERT INTO "public"."product" ("id", "capacity", "clicks", "date", "detail_img_urls", "img_url", "name", "num", "sold", "author_id", "collection_id", "engraving_id", "material_id", "type_id") VALUES ('1', '123', '0', '2019-01-07', '/static/uploads/1546753485325-test2.jpg', '/static/uploads/1546753485121-test2.jpg', '孙5', '123z', 'f', '3', '10', '74', '65', '1'),
('2', '123', '0', '2019-01-06', '/static/uploads/1546753532172-test1.jpg', '/static/uploads/1546753531736-test1.jpg', '孙4', 'ss4', 't', '3', '10', '74', '65', '24'),
('4', '123', '0', '2019-01-06', '/static/uploads/1546757351509-丽丽.jpeg', '/static/uploads/1546757351264-丽丽.jpeg', '孙3', '321aa', 't', '3', '10', '68', '62', '57'),
('5', '123', '0', '2019-01-06', '/static/uploads/1546757383708-文月.jpeg', '/static/uploads/1546757383470-文月.jpeg', '孙2', 'ss2', 'f', '3', '3', '68', '62', '57'),
('6', '0', '0', '2018-12-28', '/static/uploads/1545974842232-author2.jpg
/static/uploads/1545974842272-author1.jpg
/static/uploads/1545974842244-author3.jpg', 'https://youimg1.c-ctrip.com/target/10080j0000009zuyqADB9_R_300_300_Q90.jpg', '紫砂壶1', 'zs001', 't', '3', '79', '74', '2', '1'),
('7', '0', '0', '2018-12-28', '/static/uploads/1545975072338-img2.jpg
/static/uploads/1545975072350-img1.jpg
/static/uploads/1545975072344-img3.jpg', 'https://dimg05.c-ctrip.com/images/100a0c00000064pqzDAB6_C_238_268.jpg', '紫砂壶2', 'zs002', 'f', '3', '79', '52', '2', '1'),
('8', '0', '0', '2018-12-28', '/static/uploads/1545975091622-author6.jpg
/static/uploads/1545975091625-author5.jpg', 'https://youimg1.c-ctrip.com/target/10080j0000009zuyqADB9_R_300_300_Q90.jpg', '紫砂壶3', 'zs003', 'f', '3', '79', '52', '2', '1'),
('9', '0', '0', '2018-12-28', '/static/uploads/1545975120271-author5.jpg', 'https://dimg02.c-ctrip.com/images/fd/tg/g2/M05/87/D9/Cghzf1WwsVWAFjE2ACqTKYbSfPQ625_D_220_150.jpg', '紫砂壶4', 'zs004', 't', '3', '79', '74', '2', '1'),
('11', '0', '0', '2018-12-28', '/static/uploads/1545975155589-img4.jpg
/static/uploads/1545975155582-img5.jpg
/static/uploads/1545975155649-img3.jpg', 'https://dimg02.c-ctrip.com/images/fd/tg/g2/M05/87/D9/Cghzf1WwsVWAFjE2ACqTKYbSfPQ625_D_220_150.jpg', '紫砂壶6', 'zs006', 'f', '3', '79', '68', '2', '1'),
('12', '300', '0', '2019-01-06', '/static/uploads/1546761007555-baoyang_new.jpg', '/static/uploads/1546761005616-420x280.jpg', '收藏1', 'sc1', 't', '3', '10', '52', '2', '23'),
('16', '300', '0', '2019-01-06', '/static/uploads/1546780159454-baoyang_new.jpg', '/static/uploads/1546780159182-420x280.jpg', '搜搜有没有', 'ssymy', 't', '4', '10', '68', '62', '1'),
('19', '200', '0', '2019-01-08', '/static/uploads/1546933148220-author3.jpg', '/static/uploads/1546933148043-author7.jpg', '删作者', 'szz1', 'f', '18', '79', '21', '2', '1'),
('54', '200', '0', '2018-12-24', 'https://dimg05.c-ctrip.com/images/100a0c00000064pqzDAB6_C_238_268.jpg
https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/s%3D220/sign=820a033aad4bd11300cdb0306aaea488/29381f30e924b899e39e9e716e061d950b7bf6dd.jpg
http://n.sinaimg.cn/collect/transform/20170213/mwyT-fyamvns5067899.jpg', 'https://dimg05.c-ctrip.com/images/100a0c00000064pqzDAB6_C_238_268.jpg', '西施壶', 'xs001', 'f', '48', '79', '52', '51', '24'),
('73', '300', '0', '2018-12-28', '/static/uploads/1545975180549-author2.jpg
/static/uploads/1545975180560-author1.jpg
/static/uploads/1545975180603-author3.jpg', '/static/uploads/1545812169821-author8.jpg', '测试商品1', 'z111', 'f', '4', '79', '68', '20', '24'),
('80', '0', '0', '2018-12-31', '/static/uploads/1545974842232-author2.jpg
/static/uploads/1545974842272-author1.jpg
/static/uploads/1545974842244-author3.jpg', 'https://youimg1.c-ctrip.com/target/10080j0000009zuyqADB9_R_300_300_Q90.jpg', '紫砂壶10', 'zs010', 'f', '3', '79', '74', '2', '1'),
('81', '0', '0', '2018-12-31', '/static/uploads/1545974842232-author2.jpg
/static/uploads/1545974842272-author1.jpg
/static/uploads/1545974842244-author3.jpg', 'https://youimg1.c-ctrip.com/target/10080j0000009zuyqADB9_R_300_300_Q90.jpg', '紫砂壶11', 'zs011', 'f', '3', '79', '74', '2', '1');

INSERT INTO "public"."product_shape" ("id", "shape") VALUES ('21', '方器'),
('22', '圆器'),
('36', '花塑器'),
('55', '新器型1');

INSERT INTO "public"."product_type" ("id", "type", "shape_id") VALUES ('1', '四方', '21'),
('23', '传炉', '21'),
('24', '西施', '22'),
('25', '半月', '22'),
('43', '鱼化龙', '36'),
('57', '半夜', '22'),
('58', '啊啊啊', '55'),
('60', '半月2', '22'),
('77', '新器型2', '55');

INSERT INTO "public"."recommendation" ("id", "product_id") VALUES ('7', '5'),
('8', '2'),
('9', '4'),
('15', '12'),
('28', '7'),
('32', '6'),
('40', '11'),
('41', '9');

INSERT INTO "public"."slider" ("id", "date", "img_url", "link_url", "title") VALUES ('13', '2018-12-20', '/static/uploads/1545276454291-slider5.jpg', 'www.baidu.com', '测试标题'),
('15', '2018-12-21', '/static/uploads/1545282945659-img2.jpg', '123', '123'),
('78', '2018-12-31', '/static/uploads/1546249154372-test2.jpg', '测试连接', '测试'),
('82', '2019-01-04', '/static/uploads/1546592883957-author4.jpg', '测试www', '测试一下');

