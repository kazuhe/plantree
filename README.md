# Plantree

## Directory structure

```bash
.
├── README.md
├── build
├── build.gradle
├── docker
├── docker-compose.yml
├── gradle
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src # ソースコード
```

## Development

プロジェクトのルートに `.env` ファイルを作成し、任意の `USER_NAME` と `USER_GROUP_NAME` を設定することができる。

```bash
USER_NAME=kazuhe # 特に設定しない場合 default となる
USER_GROUP_NAME=workspace # 特に設定しない場合 workspace となる
```

Docker Compose でワークスペースを起動する。

```bash
docker compose up --detach --build
```

ワークスペースへ接続して Gradle でプロジェクトをビルドし実行する。

```bash
docker compose exec workspace /bin/bash
su kazuhe
./gradlew build --continuous & # バックグラウンドかつホットリロードの状態でビルドする
./gradlew bootRun # アプリケーションを実行する
```

bootRun すると Swagger UI が起動する。
<http://localhost:8080/swagger-ui/index.html>

Docker Compose を停止する。

```bash
docker compose down
```
