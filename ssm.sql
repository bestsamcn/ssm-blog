/*
 Navicat Premium Data Transfer

 Source Server         : postgres
 Source Server Type    : PostgreSQL
 Source Server Version : 90514
 Source Host           : localhost:5432
 Source Catalog        : ssm-blog
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90514
 File Encoding         : 65001

 Date: 22/11/2018 00:19:44
*/


-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_admin";
CREATE TABLE "public"."t_admin" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "account" varchar(26) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(40) COLLATE "pg_catalog"."default" NOT NULL,
  "avatar" varchar(250) COLLATE "pg_catalog"."default",
  "email" varchar(250) COLLATE "pg_catalog"."default",
  "mobile" char(11) COLLATE "pg_catalog"."default",
  "create_time" timestamp(0) NOT NULL DEFAULT now(),
  "create_ip" varchar(15) COLLATE "pg_catalog"."default",
  "last_login_time" timestamp(0),
  "user_type" char(1) COLLATE "pg_catalog"."default",
  "set_admin_time" timestamp(0),
  "last_update_time" timestamp(0) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_admin"."id" IS 'id';
COMMENT ON COLUMN "public"."t_admin"."account" IS 'account';
COMMENT ON COLUMN "public"."t_admin"."password" IS 'password';
COMMENT ON COLUMN "public"."t_admin"."avatar" IS 'avatar';
COMMENT ON COLUMN "public"."t_admin"."email" IS 'email';
COMMENT ON COLUMN "public"."t_admin"."mobile" IS 'mobile';
COMMENT ON COLUMN "public"."t_admin"."create_time" IS 'create_time';
COMMENT ON COLUMN "public"."t_admin"."create_ip" IS 'create_ip';
COMMENT ON COLUMN "public"."t_admin"."last_login_time" IS 'last_login_time';
COMMENT ON COLUMN "public"."t_admin"."user_type" IS 'user_type';
COMMENT ON COLUMN "public"."t_admin"."set_admin_time" IS 'set_admin_time';
COMMENT ON COLUMN "public"."t_admin"."last_update_time" IS 'last_update_time';
COMMENT ON TABLE "public"."t_admin" IS 'user';

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO "public"."t_admin" VALUES ('77a7e4b88b404d09bd5ee9bace3825af', 'sam2', '05fe7461c607c33229772d402505601016a7d0ea', NULL, NULL, NULL, '2018-11-01 23:41:36', NULL, NULL, NULL, NULL, '2018-11-01 23:41:36');
INSERT INTO "public"."t_admin" VALUES ('03ea9f7a1eee42c19ac9e8c551612819', 'sam3', '05fe7461c607c33229772d402505601016a7d0ea', NULL, NULL, NULL, '2018-11-01 23:41:50', NULL, NULL, NULL, NULL, '2018-11-01 23:41:50');
INSERT INTO "public"."t_admin" VALUES ('4e971c053c1b41f99606122f49f52216', 'sam4', '05fe7461c607c33229772d402505601016a7d0ea', NULL, NULL, NULL, '2018-11-01 23:41:52', NULL, NULL, NULL, NULL, '2018-11-01 23:41:52');
INSERT INTO "public"."t_admin" VALUES ('251e030b5c79438b9fc6eb418c5a869e', 'sam5', '05fe7461c607c33229772d402505601016a7d0ea', NULL, NULL, NULL, '2018-11-01 23:41:54', NULL, NULL, NULL, NULL, '2018-11-01 23:41:54');
INSERT INTO "public"."t_admin" VALUES ('eb328bcf46464b15a7bc2fa1b7656aad', 'sam6', '05fe7461c607c33229772d402505601016a7d0ea', NULL, NULL, NULL, '2018-11-01 23:41:56', NULL, NULL, NULL, NULL, '2018-11-01 23:41:56');
INSERT INTO "public"."t_admin" VALUES ('c23a98fd115c4032a817eda90bea5736', 'sam7', '05fe7461c607c33229772d402505601016a7d0ea', NULL, NULL, NULL, '2018-11-01 23:41:58', NULL, NULL, NULL, NULL, '2018-11-01 23:41:58');
INSERT INTO "public"."t_admin" VALUES ('f17725a58f264923a25f8937e3274d78', 'sam8', '05fe7461c607c33229772d402505601016a7d0ea', NULL, NULL, NULL, '2018-11-01 23:42:01', NULL, NULL, NULL, NULL, '2018-11-01 23:42:01');
INSERT INTO "public"."t_admin" VALUES ('8be9ce412e9c42489a1a6d978fce39c7', 'sam9', '05fe7461c607c33229772d402505601016a7d0ea', NULL, NULL, NULL, '2018-11-01 23:42:04', NULL, NULL, NULL, NULL, '2018-11-01 23:42:04');
INSERT INTO "public"."t_admin" VALUES ('b82328e7fcb94108a1dd7c877b5b43b0', 'sam22', '05fe7461c607c33229772d402505601016a7d0ea', NULL, NULL, NULL, '2018-11-01 23:42:06', NULL, NULL, NULL, NULL, '2018-11-01 23:42:06');
INSERT INTO "public"."t_admin" VALUES ('561f4e2c03bb45c2b4335ae683cc7c1b', 'sam11', '05fe7461c607c33229772d402505601016a7d0ea', NULL, NULL, NULL, '2018-11-01 23:42:09', NULL, NULL, NULL, NULL, '2018-11-01 23:42:09');
INSERT INTO "public"."t_admin" VALUES ('7b70ead3e60d45328cc2e2c0ff14c9a4', 'sam21', '05fe7461c607c33229772d402505601016a7d0ea', NULL, NULL, NULL, '2018-11-01 23:42:12', NULL, NULL, NULL, NULL, '2018-11-01 23:42:12');
INSERT INTO "public"."t_admin" VALUES ('d558fcbb4fda4636bb4cd5656cb7525e', 'sam', '05fe7461c607c33229772d402505601016a7d0ea', NULL, NULL, NULL, '2018-10-31 22:52:35', NULL, NULL, NULL, NULL, '2018-10-31 22:52:35');

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_article";
CREATE TABLE "public"."t_article" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "creator_id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "category_id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "tag_id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "thumbnail" varchar(250) COLLATE "pg_catalog"."default",
  "poster" varchar(250) COLLATE "pg_catalog"."default",
  "content" text COLLATE "pg_catalog"."default",
  "title" varchar(120) COLLATE "pg_catalog"."default",
  "pinyin" varchar(250) COLLATE "pg_catalog"."default",
  "create_time" timestamp(0) NOT NULL DEFAULT now(),
  "last_edit_time" timestamp(0) NOT NULL DEFAULT now(),
  "read_num" int4 NOT NULL,
  "comment_num" int4 NOT NULL,
  "code_content" text COLLATE "pg_catalog"."default",
  "preview_text" varchar(250) COLLATE "pg_catalog"."default",
  "like_num" int4,
  "is_private" int4 NOT NULL DEFAULT 10
)
;
COMMENT ON COLUMN "public"."t_article"."id" IS 'id';
COMMENT ON COLUMN "public"."t_article"."creator_id" IS 'creator';
COMMENT ON COLUMN "public"."t_article"."category_id" IS 'category';
COMMENT ON COLUMN "public"."t_article"."tag_id" IS 'tag';
COMMENT ON COLUMN "public"."t_article"."thumbnail" IS 'thumnail';
COMMENT ON COLUMN "public"."t_article"."poster" IS 'poster';
COMMENT ON COLUMN "public"."t_article"."content" IS 'content';
COMMENT ON COLUMN "public"."t_article"."title" IS 'title';
COMMENT ON COLUMN "public"."t_article"."pinyin" IS 'pinyin';
COMMENT ON COLUMN "public"."t_article"."create_time" IS 'create_time';
COMMENT ON COLUMN "public"."t_article"."last_edit_time" IS 'last_edit_time';
COMMENT ON COLUMN "public"."t_article"."read_num" IS 'read_num';
COMMENT ON COLUMN "public"."t_article"."comment_num" IS 'commentNum';
COMMENT ON COLUMN "public"."t_article"."code_content" IS 'code_content';
COMMENT ON COLUMN "public"."t_article"."preview_text" IS 'preview_text';
COMMENT ON COLUMN "public"."t_article"."like_num" IS 'like_num';
COMMENT ON COLUMN "public"."t_article"."is_private" IS 'is_private';
COMMENT ON TABLE "public"."t_article" IS 'article';

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO "public"."t_article" VALUES ('2a54e5a5f5f140b2b3c3fcfa262e9a54', 'd558fcbb4fda4636bb4cd5656cb7525e', '6707a21a308a40f19bb850f9302f92b7', '384fd2004113489293138ae184b9f56d', '', NULL, '内容如下啊', '我是第一篇文章', NULL, '2018-11-20 21:52:14', '2018-11-20 21:52:14', 3, 0, '我也是内容呢', '我是预览片段', 0, 10);

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_category";
CREATE TABLE "public"."t_category" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(0) NOT NULL DEFAULT now(),
  "click_num" int4 DEFAULT 0
)
;
COMMENT ON COLUMN "public"."t_category"."id" IS 'id';
COMMENT ON COLUMN "public"."t_category"."name" IS 'name';
COMMENT ON COLUMN "public"."t_category"."create_time" IS 'create_time';
COMMENT ON COLUMN "public"."t_category"."click_num" IS 'click_num';
COMMENT ON TABLE "public"."t_category" IS 'category';

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO "public"."t_category" VALUES ('6707a21a308a40f19bb850f9302f92b7', 'category1', '2018-11-08 20:25:06', 0);
INSERT INTO "public"."t_category" VALUES ('75f3c6107f664849bcdebe58a507cb89', 'category2', '2018-11-08 20:25:09', 0);

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_comment";
CREATE TABLE "public"."t_comment" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "article" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "content" varchar(250) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(0) NOT NULL DEFAULT now(),
  "create_name" varchar(26) COLLATE "pg_catalog"."default" NOT NULL,
  "create_email" varchar(250) COLLATE "pg_catalog"."default" NOT NULL,
  "create_ip" varchar(15) COLLATE "pg_catalog"."default",
  "like_num" int4 DEFAULT 0,
  "parent_comment" char(32) COLLATE "pg_catalog"."default" NOT NULL
)
;
COMMENT ON COLUMN "public"."t_comment"."id" IS 'id';
COMMENT ON COLUMN "public"."t_comment"."article" IS 'article';
COMMENT ON COLUMN "public"."t_comment"."content" IS 'content';
COMMENT ON COLUMN "public"."t_comment"."create_time" IS 'create_time';
COMMENT ON COLUMN "public"."t_comment"."create_name" IS 'create_name';
COMMENT ON COLUMN "public"."t_comment"."create_email" IS 'create_email';
COMMENT ON COLUMN "public"."t_comment"."create_ip" IS 'create_ip';
COMMENT ON COLUMN "public"."t_comment"."like_num" IS 'like_num';
COMMENT ON COLUMN "public"."t_comment"."parent_comment" IS 'parent_comment';
COMMENT ON TABLE "public"."t_comment" IS 'comment';

-- ----------------------------
-- Table structure for t_hot
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_hot";
CREATE TABLE "public"."t_hot" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(0) NOT NULL DEFAULT now(),
  "hot_count" int4 DEFAULT 0
)
;
COMMENT ON COLUMN "public"."t_hot"."id" IS 'id';
COMMENT ON COLUMN "public"."t_hot"."name" IS 'name';
COMMENT ON COLUMN "public"."t_hot"."create_time" IS 'create_time';
COMMENT ON COLUMN "public"."t_hot"."hot_count" IS 'hot_count';
COMMENT ON TABLE "public"."t_hot" IS 'hot';

-- ----------------------------
-- Records of t_hot
-- ----------------------------
INSERT INTO "public"."t_hot" VALUES ('d902835e64db4f61a999cb14d96215e4', 'hot341245678', '2018-11-08 22:07:09', 0);
INSERT INTO "public"."t_hot" VALUES ('5a1a72e854ae41769c7ed2d1c0af04df', 'hot3412456789', '2018-11-08 22:07:28', 0);
INSERT INTO "public"."t_hot" VALUES ('47af003f295446ddaf5a8dfc87b653b5', 'hot34124567891', '2018-11-08 22:22:49', 0);
INSERT INTO "public"."t_hot" VALUES ('c658050635af4a8e8bcd08da52548720', 'hot2', '2018-11-08 22:45:23', 0);
INSERT INTO "public"."t_hot" VALUES ('bf977bb49c6c4ea89645620cabe3c451', 'hot2413', '2018-11-08 22:47:20', 0);
INSERT INTO "public"."t_hot" VALUES ('d2b66e8a80ae40e79ac866d0c171091b', 'hot2413433', '2018-11-08 22:51:48', 0);
INSERT INTO "public"."t_hot" VALUES ('65aeef50c8104da0babfd8d5af8229c1', 'hot2413433r', '2018-11-08 22:55:59', 0);
INSERT INTO "public"."t_hot" VALUES ('6cad2f19c63a43249e60f27b33509bad', 'hot2413433r4', '2018-11-08 22:56:09', 0);
INSERT INTO "public"."t_hot" VALUES ('bf8af986379c40729895d6e55a256d50', 'dffffffffff', '2018-11-13 00:05:34', 0);
INSERT INTO "public"."t_hot" VALUES ('e9f5c688d50a4aeb9a4c18a4a7e83d33', 'aaaaaaaaaaaaa', '2018-11-13 00:05:53', 0);

-- ----------------------------
-- Table structure for t_logit
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_logit";
CREATE TABLE "public"."t_logit" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "access_ip" char(15) COLLATE "pg_catalog"."default",
  "api_name" varchar(250) COLLATE "pg_catalog"."default" NOT NULL,
  "country" varchar(250) COLLATE "pg_catalog"."default",
  "province" varchar(250) COLLATE "pg_catalog"."default",
  "city" varchar(250) COLLATE "pg_catalog"."default",
  "district" varchar(250) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6) DEFAULT now(),
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "type" int4 NOT NULL,
  "exception_class" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."t_logit"."id" IS 'id';
COMMENT ON COLUMN "public"."t_logit"."access_ip" IS 'accessip';
COMMENT ON COLUMN "public"."t_logit"."api_name" IS 'apiName';
COMMENT ON COLUMN "public"."t_logit"."country" IS 'country';
COMMENT ON COLUMN "public"."t_logit"."province" IS 'province';
COMMENT ON COLUMN "public"."t_logit"."city" IS 'city';
COMMENT ON COLUMN "public"."t_logit"."district" IS 'district';
COMMENT ON COLUMN "public"."t_logit"."create_time" IS 'creatTime';
COMMENT ON COLUMN "public"."t_logit"."description" IS 'description';
COMMENT ON COLUMN "public"."t_logit"."type" IS 'type';
COMMENT ON COLUMN "public"."t_logit"."exception_class" IS 'exceptionClass';
COMMENT ON TABLE "public"."t_logit" IS 'count';

-- ----------------------------
-- Records of t_logit
-- ----------------------------
INSERT INTO "public"."t_logit" VALUES ('e38d005024414fcfb9c7fbcac2e29af1', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-12 23:14:31.411', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('61b577455c1b405aa2507a6b4fe41004', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-13 00:02:45.486', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('abcd7d63ac024b4b95bf91f251ccd6da', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-13 01:22:23.674', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('d129cd8dd04a428888fff8559df7839c', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-13 01:29:01.902', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('d5a01cf4a8d54cac85aa9a81bb2b481c', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-13 01:29:37.416', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('0f7451e3ac0741ffbad082609ef2154a', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-13 01:39:09.939', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('268aa450a25a4302a1056e0cf90dd494', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-13 01:43:32.51', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('f7816243914a45a6b0f2e2052e6be25a', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-13 01:44:02.04', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('e4d5d9a996f34cf9805d82b340d7eead', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-13 01:46:09.738', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('19cbefb4b0744e6e9220505dbe0e69f5', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-13 01:47:00.459', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('6e86d2bd1bf44e62939d561acccb7b4c', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-13 01:47:05.711', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('215e1b1d8af44a8cab8e19cb2bea329c', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-13 01:47:07.309', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('12b47a854e634e48a43483092d4273d4', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-13 01:50:32.184', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('2af615e349d24a65adb65f6c0f06c0de', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, '广东', '深圳', '', '2018-11-13 01:50:37.009', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('806cb1552e5942fab9c8005dc23b22c5', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', '中国', '广东', '深圳', '', '2018-11-13 01:51:20.925', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('78685b013e4640bd84745c4f861fc645', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-13 01:52:01.772', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('746e0bb7b51742668442f2b2c74064dc', '163.125.73.113 ', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-13 02:05:16.607', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('e46091337b9344f78a3de756af78cf15', '163.125.73.113 ', 'me.bestsamcn.blog.controllers.AdminController.login()', '中国', '广东', '深圳', '', '2018-11-13 02:06:19.125', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('96af5a1e3a0b4812853cd60b52605c7f', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-14 01:05:02.134', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('256acc31ded949c5bc76f2c985f78ae5', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-20 21:33:55.822', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('06ee48e0cc9141b6a27b152ac3a25cbb', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-20 21:44:18.949', '登陆', 20, NULL);
INSERT INTO "public"."t_logit" VALUES ('ee4ab5715f5e42938b538168c5b7cbf2', '0:0:0:0:0:0:0:1', 'me.bestsamcn.blog.controllers.AdminController.login()', NULL, NULL, NULL, NULL, '2018-11-20 21:51:47.396', '登陆', 20, NULL);

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_message";
CREATE TABLE "public"."t_message" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(26) COLLATE "pg_catalog"."default" NOT NULL,
  "email" varchar(26) COLLATE "pg_catalog"."default" NOT NULL,
  "content" varchar(250) COLLATE "pg_catalog"."default" NOT NULL,
  "is_read" int4,
  "read_time" timestamp(0),
  "post_time" timestamp(0) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_message"."id" IS 'id';
COMMENT ON COLUMN "public"."t_message"."name" IS 'name';
COMMENT ON COLUMN "public"."t_message"."email" IS 'email';
COMMENT ON COLUMN "public"."t_message"."content" IS 'content';
COMMENT ON COLUMN "public"."t_message"."is_read" IS 'is_read';
COMMENT ON COLUMN "public"."t_message"."read_time" IS 'read_time';
COMMENT ON COLUMN "public"."t_message"."post_time" IS 'post_time';
COMMENT ON TABLE "public"."t_message" IS 'message';

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO "public"."t_message" VALUES ('9f538003975a47458da0d7386484ad0a', 'hot2413433r4ee', 'we@qq.com', '<script>alert()</script>', 10, NULL, '2018-11-11 02:31:35');
INSERT INTO "public"."t_message" VALUES ('22b72968b1cf4414a29b89aa28801c67', 'hot2413433r4ee', 'we@qq.com', '<script>alert()</script>', 10, NULL, '2018-11-11 02:31:36');
INSERT INTO "public"."t_message" VALUES ('77501212ceb24f95835a91aedf5faee9', 'hot2413433r4ee', 'we@qq.com', '<script>alert()</script>', 10, NULL, '2018-11-11 02:31:37');
INSERT INTO "public"."t_message" VALUES ('5a0c12a5cab44015897074794cc9b5e2', 'hot2413433r4ee', 'we@qq.com', '<script>alert()</script>', 10, NULL, '2018-11-11 02:31:38');
INSERT INTO "public"."t_message" VALUES ('37b64889e7ff4488be0ef3ee5990cda2', 'sam', 'we@qq.com', '<script>alert()</script>', 10, NULL, '2018-11-11 17:37:04');

-- ----------------------------
-- Table structure for t_notify
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_notify";
CREATE TABLE "public"."t_notify" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "content" varchar(250) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(0) NOT NULL DEFAULT now(),
  "last_edit_time" timestamp(0) NOT NULL DEFAULT now(),
  "expire_time" timestamp(0),
  "is_active" int4 DEFAULT 10
)
;
COMMENT ON COLUMN "public"."t_notify"."id" IS 'id';
COMMENT ON COLUMN "public"."t_notify"."content" IS 'content';
COMMENT ON COLUMN "public"."t_notify"."create_time" IS 'create_time';
COMMENT ON COLUMN "public"."t_notify"."last_edit_time" IS 'last_edit_time';
COMMENT ON COLUMN "public"."t_notify"."expire_time" IS 'expire_time';
COMMENT ON COLUMN "public"."t_notify"."is_active" IS 'is_active';
COMMENT ON TABLE "public"."t_notify" IS 'notify';

-- ----------------------------
-- Records of t_notify
-- ----------------------------
INSERT INTO "public"."t_notify" VALUES ('be8c697012734f21bbafb9306c6f78f0', '是垃圾士大夫', '2018-11-11 22:18:45', '2018-11-11 22:18:45', '2018-11-11 21:06:13', 10);
INSERT INTO "public"."t_notify" VALUES ('b1826cc218e44a3ab7c3d16c5e4f158f', '是垃圾士大夫', '2018-11-11 22:18:46', '2018-11-11 22:18:46', '2018-11-11 21:06:13', 10);
INSERT INTO "public"."t_notify" VALUES ('956336b77ad24eefa418d55a0ed0a34a', '是士大夫十分发射点发顺丰', '2018-11-11 22:18:47', '2018-11-11 22:28:29', '2018-11-11 21:06:13', 20);

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_tag";
CREATE TABLE "public"."t_tag" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "click_num" int4 DEFAULT 0,
  "create_time" timestamp(0) NOT NULL DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_tag"."id" IS 'id';
COMMENT ON COLUMN "public"."t_tag"."name" IS 'name';
COMMENT ON COLUMN "public"."t_tag"."click_num" IS 'click_num';
COMMENT ON COLUMN "public"."t_tag"."create_time" IS 'create_time';
COMMENT ON TABLE "public"."t_tag" IS 'tag';

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO "public"."t_tag" VALUES ('384fd2004113489293138ae184b9f56d', 'tag2', 0, '2018-11-07 21:59:43');

-- ----------------------------
-- Indexes structure for table t_admin
-- ----------------------------
CREATE UNIQUE INDEX "di" ON "public"."t_admin" USING btree (
  "id" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_admin
-- ----------------------------
ALTER TABLE "public"."t_admin" ADD CONSTRAINT "pk_user" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_article
-- ----------------------------
ALTER TABLE "public"."t_article" ADD CONSTRAINT "pk_article" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_category
-- ----------------------------
ALTER TABLE "public"."t_category" ADD CONSTRAINT "pk_category" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_comment
-- ----------------------------
ALTER TABLE "public"."t_comment" ADD CONSTRAINT "pk_comment" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_hot
-- ----------------------------
CREATE UNIQUE INDEX "hot_id_idx" ON "public"."t_hot" USING btree (
  "id" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_hot
-- ----------------------------
ALTER TABLE "public"."t_hot" ADD CONSTRAINT "pk_hot" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_logit
-- ----------------------------
ALTER TABLE "public"."t_logit" ADD CONSTRAINT "pk_count" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_message
-- ----------------------------
ALTER TABLE "public"."t_message" ADD CONSTRAINT "pk_message" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_notify
-- ----------------------------
ALTER TABLE "public"."t_notify" ADD CONSTRAINT "pk_notify" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_tag
-- ----------------------------
CREATE UNIQUE INDEX "tag_id_idx" ON "public"."t_tag" USING btree (
  "id" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table t_tag
-- ----------------------------
ALTER TABLE "public"."t_tag" ADD CONSTRAINT "id" UNIQUE ("id");
ALTER TABLE "public"."t_tag" ADD CONSTRAINT "name" UNIQUE ("name");

-- ----------------------------
-- Primary Key structure for table t_tag
-- ----------------------------
ALTER TABLE "public"."t_tag" ADD CONSTRAINT "pk_tag" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table t_article
-- ----------------------------
ALTER TABLE "public"."t_article" ADD CONSTRAINT "fk_article_cate_category" FOREIGN KEY ("category_id") REFERENCES "public"."t_category" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE "public"."t_article" ADD CONSTRAINT "fk_article_tag_tag" FOREIGN KEY ("tag_id") REFERENCES "public"."t_tag" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE "public"."t_article" ADD CONSTRAINT "fk_article_user_user" FOREIGN KEY ("creator_id") REFERENCES "public"."t_admin" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT;

-- ----------------------------
-- Foreign Keys structure for table t_comment
-- ----------------------------
ALTER TABLE "public"."t_comment" ADD CONSTRAINT "comment_parentComment_fkey" FOREIGN KEY ("parent_comment") REFERENCES "public"."t_comment" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE "public"."t_comment" ADD CONSTRAINT "fk_comment_article_article" FOREIGN KEY ("article") REFERENCES "public"."t_article" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT;
