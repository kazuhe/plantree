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

| レイヤ            | 役割                                                                                     |
|----------------|----------------------------------------------------------------------------------------|
| Domain         | ・`Entity` ビジネスの概念やルールを表現したドメインオブジェクト<br />・`Repository`  ドメインオブジェクトの取得や更新を表現したインターフェース |
| Service        | ・`Service` ユースケースを実現するアプリケーション固有のロジック                                                  |
| UI             | ・`Controller` リクエストを解釈しレスポンスを生成するオブジェクト                                                |
| Infrastructure | ・`Repository` いわゆる Data Access Object                                                  |

## Development

Docker Compose でコンテナを起動する。

```bash
docker compose up --detach --build
```

Docker Compose を停止する。

```bash
docker compose down
```

MySQL に接続する。

```bash
docker compose exec db mysql -u root -pmysql
```
