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
