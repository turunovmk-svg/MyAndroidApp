#!/bin/sh
# Сборка Android-проекта в APK прямо на Android телефоне (Alpine Linux PRoot)
# Запуск: sh build-android.sh

set -e

PROJECT_DIR="/var/minis/workspace/AndroidApp"
SDK_DIR="/opt/android-sdk"
GRADLE_VERSION="8.4"
GRADLE_DIR="/opt/gradle-${GRADLE_VERSION}"
JAVA_HOME="/usr/lib/jvm/java-17-openjdk"

export JAVA_HOME
export PATH="$JAVA_HOME/bin:$PATH"

echo "==> Проверка Java"
java -version 2>&1 | head -1

cd "$PROJECT_DIR"

echo "==> Установка Gradle ${GRADLE_VERSION} (если нет)"
if [ ! -x "$GRADLE_DIR/bin/gradle" ]; then
  mkdir -p /opt
  cd /opt
  wget -q "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" -O gradle-bin.zip
  unzip -o -q "gradle-bin.zip"
  rm -f "gradle-bin.zip"
fi
export PATH="$GRADLE_DIR/bin:$PATH"
gradle --version | head -5

echo "==> Установка Android SDK command-line tools (если нет)"
export ANDROID_HOME="$SDK_DIR"
if [ ! -d "$SDK_DIR/cmdline-tools/latest" ]; then
  mkdir -p "$SDK_DIR"
  cd "$SDK_DIR"
  wget -q "https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip" -O cmdline-tools.zip
  unzip -o -q cmdline-tools.zip
  mkdir -p cmdline-tools/latest
  cp -r cmdline-tools/* cmdline-tools/latest/
  rm -rf cmdline-tools cmdline-tools.zip
fi
export PATH="$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools:$PATH"

echo "==> Принятие лицензий SDK"
yes | sdkmanager --licenses >/dev/null 2>&1 || true

echo "==> Установка компонентов SDK (platform-tools, build-tools 34, platform 34)"
sdkmanager "platform-tools" "build-tools;34.0.0" "platforms;android-34" >/dev/null 2>&1 || true

echo "==> Создание local.properties"
echo "sdk.dir=$SDK_DIR" > local.properties

echo "==> Сборка debug APK"
gradle assembleDebug --no-daemon -Dorg.gradle.jvmargs="-Xmx512m"

echo "==> Готово!"
echo "APK лежит здесь: app/build/outputs/apk/debug/app-debug.apk"
echo "Установить на телефон: adb install app/build/outputs/apk/debug/app-debug.apk"
