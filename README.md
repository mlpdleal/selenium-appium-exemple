# selenium-appium-exemple
A exemple automation project with appium + selenium + java 

# Requirements

* JDK 8
* Android studio
* SDK tools
* Platform tools
* Appium server

# Most used commands

* adb devices
* adb devices -l 
* adb logcat
* emulator -list-avds
* emulator <nome_emulador>
* uiautomatorviewer

# Setup

### Desired Capabilities:

1. Run Appium Server
2. Choose the option "Start Inspector Session"
3. In "Custon Server" tab, insert the desired capability

Exemple:

```json

{
  "platformName": "Android",
  "deviceName": "emulator-5554",
  "automationName": "uiautomator2",
  "appPackage": "com.android.calculator2",
  "appActivity": "com.android.calculator2.Calculator"
}

```
4. The "appPackage" and "appActivity" values is avaliable in apkinfo.apk;

https://apkpure.com/apk-info/com.intelloware.apkinfo


