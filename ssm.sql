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

 Date: 12/11/2018 21:59:28
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
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_article";
CREATE TABLE "public"."t_article" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "creator" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "category" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "tag" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "thumbnail" varchar(250) COLLATE "pg_catalog"."default",
  "poster" varchar(250) COLLATE "pg_catalog"."default",
  "content" text COLLATE "pg_catalog"."default",
  "title" varchar(120) COLLATE "pg_catalog"."default",
  "pinyin" varchar(250) COLLATE "pg_catalog"."default",
  "create_time" timestamp(0) NOT NULL DEFAULT now(),
  "last_edit_time" timestamp(0) NOT NULL DEFAULT now(),
  "category_name" varchar(50) COLLATE "pg_catalog"."default",
  "tag_name" varchar(50) COLLATE "pg_catalog"."default",
  "read_num" int4 NOT NULL,
  "comment_num" int4 NOT NULL,
  "code_content" text COLLATE "pg_catalog"."default",
  "preview_text" varchar(250) COLLATE "pg_catalog"."default",
  "like_num" int4,
  "is_private" bool
)
;
COMMENT ON COLUMN "public"."t_article"."id" IS 'id';
COMMENT ON COLUMN "public"."t_article"."creator" IS 'creator';
COMMENT ON COLUMN "public"."t_article"."category" IS 'category';
COMMENT ON COLUMN "public"."t_article"."tag" IS 'tag';
COMMENT ON COLUMN "public"."t_article"."thumbnail" IS 'thumnail';
COMMENT ON COLUMN "public"."t_article"."poster" IS 'poster';
COMMENT ON COLUMN "public"."t_article"."content" IS 'content';
COMMENT ON COLUMN "public"."t_article"."title" IS 'title';
COMMENT ON COLUMN "public"."t_article"."pinyin" IS 'pinyin';
COMMENT ON COLUMN "public"."t_article"."create_time" IS 'create_time';
COMMENT ON COLUMN "public"."t_article"."last_edit_time" IS 'last_edit_time';
COMMENT ON COLUMN "public"."t_article"."category_name" IS 'category_name';
COMMENT ON COLUMN "public"."t_article"."tag_name" IS 'tag_name';
COMMENT ON COLUMN "public"."t_article"."read_num" IS 'read_num';
COMMENT ON COLUMN "public"."t_article"."comment_num" IS 'commentNum';
COMMENT ON COLUMN "public"."t_article"."code_content" IS 'code_content';
COMMENT ON COLUMN "public"."t_article"."preview_text" IS 'preview_text';
COMMENT ON COLUMN "public"."t_article"."like_num" IS 'like_num';
COMMENT ON COLUMN "public"."t_article"."is_private" IS 'is_private';
COMMENT ON TABLE "public"."t_article" IS 'article';

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
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_log";
CREATE TABLE "public"."t_log" (
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
COMMENT ON COLUMN "public"."t_log"."id" IS 'id';
COMMENT ON COLUMN "public"."t_log"."access_ip" IS 'accessip';
COMMENT ON COLUMN "public"."t_log"."api_name" IS 'apiName';
COMMENT ON COLUMN "public"."t_log"."country" IS 'country';
COMMENT ON COLUMN "public"."t_log"."province" IS 'province';
COMMENT ON COLUMN "public"."t_log"."city" IS 'city';
COMMENT ON COLUMN "public"."t_log"."district" IS 'district';
COMMENT ON COLUMN "public"."t_log"."create_time" IS 'creatTime';
COMMENT ON COLUMN "public"."t_log"."description" IS 'description';
COMMENT ON COLUMN "public"."t_log"."type" IS 'type';
COMMENT ON COLUMN "public"."t_log"."exception_class" IS 'exceptionClass';
COMMENT ON TABLE "public"."t_log" IS 'count';

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
-- Primary Key structure for table t_log
-- ----------------------------
ALTER TABLE "public"."t_log" ADD CONSTRAINT "pk_count" PRIMARY KEY ("id");

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
ALTER TABLE "public"."t_article" ADD CONSTRAINT "fk_article_cate_category" FOREIGN KEY ("category") REFERENCES "public"."t_category" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE "public"."t_article" ADD CONSTRAINT "fk_article_tag_tag" FOREIGN KEY ("tag") REFERENCES "public"."t_tag" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE "public"."t_article" ADD CONSTRAINT "fk_article_user_user" FOREIGN KEY ("creator") REFERENCES "public"."t_admin" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT;

-- ----------------------------
-- Foreign Keys structure for table t_comment
-- ----------------------------
ALTER TABLE "public"."t_comment" ADD CONSTRAINT "comment_parentComment_fkey" FOREIGN KEY ("parent_comment") REFERENCES "public"."t_comment" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE "public"."t_comment" ADD CONSTRAINT "fk_comment_article_article" FOREIGN KEY ("article") REFERENCES "public"."t_article" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT;
