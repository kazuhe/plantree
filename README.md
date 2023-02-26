# Plantree

## 📂 Directory structure

オニオンアーキテクチャの思想をベースにしている。

![plantree](https://user-images.githubusercontent.com/57878514/221201697-34af7ad2-ef2f-45f8-891c-b8d0d5adde9d.png)

```bash
src/main/java/x/plantree
├── domain
│   ├── entity
│   └── repository
├── infrastructure
│   └── repository
├── service
│   └── service
└── ui
    └── controller
```

| レイヤ  | 役割 |
| --- | --- |
| Domain | ・`Entity` ビジネスの概念やルールを表現したドメインオブジェクト<br />・`Repository`  ドメインオブジェクトの取得や更新を表現したインターフェース |
| Service | ・`Service` ユースケースを実現するアプリケーション固有のロジック |
| UI | ・`Controller` リクエストを解釈しレスポンスを生成するオブジェクト |
| Infrastructure | ・`Repository` いわゆる Data Access Object |

## Development

VS Code 拡張機能の [Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) を利用することを推奨する。

Docker Compose でワークスペースを起動することもできる。

```bash
docker compose up --detach --build
```

ワークスペースへ接続して Gradle でプロジェクトをビルドし実行する。

```bash
docker compose exec workspace /bin/bash
su devuser
./gradlew build --continuous & # バックグラウンドかつホットリロードの状態でビルドする
./gradlew bootRun # アプリケーションを実行する
```

bootRun すると Swagger UI が起動する。
<http://localhost:8080/swagger-ui/index.html>

Docker Compose を停止する。

```bash
docker compose down
```

```bash
# MySQL に接続する
$ docker compose exec db /bin/bash
$ mysql -u dbuser -p
mysql> USE dev;
```
