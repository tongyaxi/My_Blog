/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : myblog

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 25/01/2022 11:01:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE IF NOT EXISTS my_blog;
Use my_blog;
-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `category` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime NULL DEFAULT '2017-09-18 00:00:00',
  `star` int(11) NULL DEFAULT 0,
  `comment` int(11) NULL DEFAULT 0,
  `visit` int(11) NULL DEFAULT 0,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_article
-- ----------------------------
INSERT INTO `tb_article` VALUES (1, 'JAVAに関する知識', 'TONGYAXI', 'JAVA', '2022-01-20 00:00:00', 2, 8, 7, 'Java（ジャバ、ジャヴァ）は、汎用プログラミング言語とソフトウェアプラットフォームの双方を指している総称ブランドである[6]。オラクルおよびその関連会社の登録商標である。1996年にサン・マイクロシステムズによって市場リリースされ、2010年に同社がオラクルに吸収合併された事によりJavaの版権もそちらに移行した。');
INSERT INTO `tb_article` VALUES (2, 'Strutsに関する知識', 'TONGYAXI', 'Struts', '2022-01-20 00:00:00', 2, 0, 5, 'Apache Struts（アパッチ・ストラッツ）は、Apacheソフトウェア財団のApache Strutsプロジェクトにて開発されているオープンソースのJava Webアプリケーションフレームワークである。');
INSERT INTO `tb_article` VALUES (3, 'Redisに関する知識', 'TONGYAXI', 'Redis', '2022-01-20 00:00:00', 3, 0, 4, 'Redisは、ネットワーク接続された永続化可能なインメモリデータベース。連想配列（キー・バリュー）、リスト、セットなどのデータ構造を扱える。いわゆるNoSQLデータベースの一つ。オープンソースソフトウェアプロジェクトであり、Redis Labs（英語版）がスポンサーとなって開発されている[4]。');
INSERT INTO `tb_article` VALUES (4, 'Springに関する知識', 'TONGYAXI', 'Spring', '2022-01-20 00:00:00', 2, 0, 14, 'SpringはJavaに活用されるオープンソースWebアプリケーションフレームワークです。Javaフレームワークの中でも対応範囲が広く万能型であることで人気を集めております。またSpringがStrutsに次ぐ長い歴史を持ち、世界中のシステム開発に利用されております。');
INSERT INTO `tb_article` VALUES (5, 'MyBatisに関する知識', 'TONGYAXI', 'MyBatis', '2022-01-20 00:00:00', 5, 1, 9, 'Java オブジェクトとSQLとを紐付ける永続化フレームワークです。以前は iBATIS という名前で Apache プロジェクトの１つとして開発されていた。\r\nしかし、 2010年6月に Apache ソフトウェア財団での開発が中止され、現在は MyBatis という名前で開発されている。');
INSERT INTO `tb_article` VALUES (14, 'Javaの基本知識', 'TOONGYAXI', 'JAVA', '2022-01-24 15:35:25', 0, 1, 6, 'JAVAを使ったプログラミングを作成する上で知っておいて頂きたい基本知識について解説します。クラスやメソッドなどの簡単な解説に加えて、プログラムをどのように記述していくのかについて簡単に説明を行います。');
INSERT INTO `tb_article` VALUES (16, 'Bootstrap5で高速に', 'TONGYAXI', 'Bootstrap', '2022-01-25 09:59:26', 1, 0, 8, '世界で一番人気のあるフロントエンドライブラリ Bootstrap を使って、モバイルファーストなレスポンシブウェブを素早くデザイン・カスタマイズできます。Sass変数と mixin、レスポンシブグリッドシステム、豊富なコンポーネント、強力な JavaScript プラグインを備えています。');

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NULL DEFAULT NULL,
  `nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `time` datetime NULL DEFAULT '2017-09-18 00:00:00',
  `star` int(11) NULL DEFAULT 0,
  `diss` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `article_id`(`article_id`) USING BTREE,
  CONSTRAINT `article_id` FOREIGN KEY (`article_id`) REFERENCES `tb_article` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES (2, 1, 'ユーザー2', '勉強になりました。', '2022-01-23 00:00:00', 3, 5);
INSERT INTO `tb_comment` VALUES (25, 1, '匿名', 'いいね！', '2022-01-24 11:08:52', 1, 1);
INSERT INTO `tb_comment` VALUES (27, 14, '匿名', 'いいね！', '2022-01-25 10:05:46', 1, 1);
INSERT INTO `tb_comment` VALUES (29, 5, '匿名', '勉強になりました。', '2022-01-25 10:13:17', 1, 0);

-- ----------------------------
-- Table structure for tb_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_tag`;
CREATE TABLE `tb_tag`  (
  `id` int(11) NULL DEFAULT NULL,
  `tag` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `id`(`id`) USING BTREE,
  CONSTRAINT `tb_tag_ibfk_1` FOREIGN KEY (`id`) REFERENCES `tb_article` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_tag
-- ----------------------------
INSERT INTO `tb_tag` VALUES (1, 'Java');
INSERT INTO `tb_tag` VALUES (2, 'Struts');
INSERT INTO `tb_tag` VALUES (3, 'Redis');
INSERT INTO `tb_tag` VALUES (4, 'Spring');
INSERT INTO `tb_tag` VALUES (5, 'MyBatis');
INSERT INTO `tb_tag` VALUES (1, '知識');
INSERT INTO `tb_tag` VALUES (14, '');
INSERT INTO `tb_tag` VALUES (16, 'Bootstrap');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'primary_key',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'username',
  `user_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'password',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'm21w0b16', 'm21w0b16');

SET FOREIGN_KEY_CHECKS = 1;
