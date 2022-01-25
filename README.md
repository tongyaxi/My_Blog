# Ultra Man Blog

## 概要説明
Jsp/Servletを駆使しているオリジナルの個人ブログ

## 機能一覧
* ホームページ（記事一覧）
* 記事作成（記事追加）
* 記事に「いいね！」機能
* 記事にコメント
* Markdownのフォーマットで記事作成
* カテゴリ
* タグ
* 記事ランク（訪問数よる並び替え機能）
* 記事タイムライン
* 記事管理（記事削除、記事更新）
* 記事検索
* 記事の訪問数（引き続きの機能...）
* ファイルアップロード（引き続きの機能...）

## 利用技術
* Jsp
* Servlet
* Mysql
* Bootstrap
* Css/JavaScript
* Ajax
* Json
* c3p0（user:root password:abc123456　DataBase Pool：http://www.mchange.com/projects/c3p0/）
* Markdown（https://github.com/pandao/editor.md）


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
#### ログイン
<img src="https://user-images.githubusercontent.com/32674906/150896361-62d72171-fff6-4fe5-8d38-d1b98cfc5d54.png" width="1000px" height="550px"/>

#### ホームページ
<img src="https://user-images.githubusercontent.com/32674906/150896438-2a1943d3-8ab3-4ac3-bb26-1771e30d336e.png" width="1000px" height="550px"/>
<img src="https://user-images.githubusercontent.com/32674906/150896880-a3f9fd63-39a8-445e-8c63-aef933687d54.png" width="1000px" height="550px"/>

#### カテゴリー
<img src="https://user-images.githubusercontent.com/32674906/150896511-6210292d-9fc1-4a87-bcf7-a5de4a943409.png" width="1000px" height="550px"/>

#### タグ
<img src="https://user-images.githubusercontent.com/32674906/150896565-fe396e5f-7a68-43aa-ab17-690926469c26.png" width="1000px" height="550px"/>

#### タイムライン
<img src="https://user-images.githubusercontent.com/32674906/150896581-1dfa8ca0-7754-49c5-9371-ea038d8bd233.png" width="1000px" height="550px"/>

#### その他
<img src="https://user-images.githubusercontent.com/32674906/150896598-83f1c0a3-18fc-4ea2-8997-11958a980e0b.png" width="1000px" height="550px"/>

#### 記事作成
<img src="https://user-images.githubusercontent.com/32674906/150896650-62c8e26e-3ad1-48e3-a026-a4502a027b97.png" width="1000px" height="550px"/>

#### 記事詳細
<img src="https://user-images.githubusercontent.com/32674906/150897277-48aab9aa-2e29-48db-ae1c-620c54c1e716.png" width="1000px" height="550px"/>

#### 記事管理
<img src="https://user-images.githubusercontent.com/32674906/150896689-627af560-1e2d-4443-9ed6-ed8ea87c00ca.png" width="1000px" height="550px"/>
