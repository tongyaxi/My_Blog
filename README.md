# Ultra Man Blog

## アクセスしてみる？：localhost:xxx/my_blog/

## 概要説明
Jsp/Servletを駆使しているオリジナルの個人ブログ

## 機能一覧
ホームページ（記事一覧）
記事作成（記事追加）
記事に「いいね！」機能
記事にコメント
Markdownのフォーマットで記事作成
カテゴリ
タグ
記事ランク（訪問数よる並び替え機能）
記事タイムライン
記事管理（記事削除、記事更新）
記事検索
記事の訪問数（引き続きの機能...）
ファイルアップロード（引き続きの機能...）

## 利用技術
Jsp
Servlet
Mysql
Bootstrap
Css/JavaScript
Ajax
Json
c3p0（DataBase Pool：http://www.mchange.com/projects/c3p0/）
Markdown（https://github.com/pandao/editor.md）


### データベース

* t_article - 記事
* t_comment - コメント
* t_tag - タグ
* t_user - ユーザー

### 項目構成
#### Java

* com.tongyaxi.blog.dao DataBase Interface
* com.tongyaxi.blog.imple DataBase Interface Implblog
* com.tongyaxi.blog.db c3p0 DataBase Pool
* com.tongyaxi.blog.filter フィルター
* com.tongyaxi.blog.model Java Bean
* com.tongyaxi.blog.service Service Class
* com.tongyaxi.blog.servlet コントローラー
* com.tongyaxi.blog.utils ツール

#### Web
* admin 記事管理
* css
* editormd 
* img
* js javascript
* page ブログ関連

### 導入しているJar

* mysql-connector-java
* c3p0-0.9.5.2.jar
* mchange-commons-java.jar 
* commons-beanutils-1.9.3-bin.zip  BeanUtils
* commons-logging-1.2-bin.zip
* jstl.jar
* standard.jar 
* commons-io-2.5.jar
* commons-lang-2.5.jar
* commons-collections-3.1
* json-lib-2.1-jdk15 JSON
* ezmorph-1.0.3

### Ultra Man Blog

![无法显示图片](https://github.com/Lemonreds/MyBlog/blob/master/screenshot/1.png)

![无法显示图片](https://github.com/Lemonreds/MyBlog/blob/master/screenshot/2.png)

![无法显示图片](https://github.com/Lemonreds/MyBlog/blob/master/screenshot/3.png)

![无法显示图片](https://github.com/Lemonreds/MyBlog/blob/master/screenshot/4.png)

![无法显示图片](https://github.com/Lemonreds/MyBlog/blob/master/screenshot/5.png)

![无法显示图片](https://github.com/Lemonreds/MyBlog/blob/master/screenshot/6.png)

![无法显示图片](https://github.com/Lemonreds/MyBlog/blob/master/screenshot/7.png)
