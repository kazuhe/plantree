# Plantree

## Directory structure

```bash
.
├── lib # 依存ライブラリ
└── src # ソースコード
    └── App.java # エントリーポイント
```

コンパイルを実行すると `bin` ディレクトリに実行ファイルが生成される。

また、ディレクトリ構成は `.vscode/settings.json` で設定している。

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
gradle build
java -jar build/libs/plantree-0.0.1-SNAPSHOT.jar # http://localhost:8080/
```

Docker Compose を停止する。

```bash
docker compose down
```
