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

ワークスペースへ接続する。

```bash
docker compose exec workspace /bin/bash
su kazuhe
cd ~/workspace
java --version
```

Docker Compose を停止する。

```bash
docker compose down
```
