# Сборка APK прямо на Android телефоне

Проект расположен в `/var/minis/workspace/AndroidApp/`.

## Требования
- Java 17 (уже установлен в песочнице: `openjdk17-jdk`)
- Gradle 8.4 (скачивается скриптом)
- Android SDK command-line tools (скачиваются скриптом)
- Свободное место: ~2–3 ГБ
- Интернет (первая сборка скачивает зависимости Gradle и Maven)

## Быстрый старт
```sh
cd /var/minis/workspace/AndroidApp
sh build-android.sh
```

Скрипт:
1. Установит Gradle 8.4 в `/opt/gradle-8.4`
2. Скачает Android SDK command-line tools в `/opt/android-sdk`
3. Установит `platform-tools`, `build-tools;34.0.0`, `platforms;android-34`
4. Примет лицензии SDK
5. Создаст `local.properties` с путём к SDK
6. Соберёт `app-debug.apk`

## Результат
```
app/build/outputs/apk/debug/app-debug.apk
```

## Установка на телефон
```sh
adb install app/build/outputs/apk/debug/app-debug.apk
```
(`adb` входит в пакет `android-tools`, который уже установлен.)

## Примечания
- Первая сборка может занять 5–15 минут (скачивание Gradle, SDK, зависимостей).
- Если не хватает памяти, добавь `-Xmx384m` вместо `-Xmx512m` в `build-android.sh`.
- Для релизной сборки замени `assembleDebug` на `assembleRelease` и настрой подпись в `build.gradle` (`signingConfigs`).
