# Plantree

## đ Directory structure

ăŞăăŞăłă˘ăźă­ăăŻăăŁăŽććłăăăźăšăŤăăŚăăă

![plantree](https://user-images.githubusercontent.com/57878514/221201697-34af7ad2-ef2f-45f8-891c-b8d0d5adde9d.png)

```bash
src/main/java/x/plantree
âââ domain
âÂ Â  âââ entity
âÂ Â  âââ repository
âââ infrastructure
âÂ Â  âââ repository
âââ service
âÂ Â  âââ service
âââ ui
    âââ controller
```

| ăŹă¤ă¤  | ĺ˝šĺ˛ |
| --- | --- |
| Domain | ăť`Entity` ăă¸ăăšăŽćŚĺżľăăŤăźăŤăčĄ¨çžăăăăĄă¤ăłăŞăă¸ă§ăŻă<br />ăť`Repository`  ăăĄă¤ăłăŞăă¸ă§ăŻăăŽĺĺžăć´ć°ăčĄ¨çžăăă¤ăłăżăźăă§ăźăš |
| Service | ăť`Service` ăŚăźăšăąăźăšăĺŽçžăăă˘ăăŞăąăźăˇă§ăłĺşćăŽă­ă¸ăăŻ |
| UI | ăť`Controller` ăŞăŻă¨ăšăăč§ŁéăăŹăšăăłăšăçćăăăŞăă¸ă§ăŻă |
| Infrastructure | ăť`Repository` ăăăă Data Access Object |

## Development

VS Code ćĄĺźľćŠč˝ăŽ [Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) ăĺŠç¨ăăăă¨ăć¨ĺĽ¨ăăă

Docker Compose ă§ăŻăźăŻăšăăźăšăčľˇĺăăăă¨ăă§ăăă

```bash
docker compose up --detach --build
```

ăŻăźăŻăšăăźăšă¸ćĽçśăăŚ Gradle ă§ăă­ă¸ă§ăŻăăăăŤăăĺŽčĄăăă

```bash
docker compose exec workspace /bin/bash
su devuser
./gradlew build --continuous & # ăăăŻă°ăŠăŚăłăăă¤ăăăăŞă­ăźăăŽçśćă§ăăŤăăă
./gradlew bootRun # ă˘ăăŞăąăźăˇă§ăłăĺŽčĄăă
```

bootRun ăăă¨ Swagger UI ăčľˇĺăăă
<http://localhost:8080/swagger-ui/index.html>

Docker Compose ăĺć­˘ăăă

```bash
docker compose down
```

```bash
# MySQL ăŤćĽçśăă
$ docker compose exec db /bin/bash
$ mysql -u dbuser -p
mysql> USE dev;
```
