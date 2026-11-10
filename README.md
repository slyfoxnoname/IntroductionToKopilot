

## Course Planner

### Android calculator

The Android project in the repository root runs the full calculator in
`src/part2/HM3/2.3.2.kt`. To launch the simple calculator from
`src/part2/HM3/2.3.1.kt` instead, use:

```powershell
& "$env:LOCALAPPDATA\Android\Sdk\platform-tools\adb.exe" shell am start -n com.example.calculator/HM3.SimpleCalculatorActivity
```

Requirements: JDK 17 or newer, Android SDK Platform 35, and an Android emulator
or a connected Android device. After installing the Android SDK, open the
project in Android Studio and accept the SDK component licenses, or build and
install from PowerShell:

```powershell
.\gradlew.bat installDebug
& "$env:LOCALAPPDATA\Android\Sdk\platform-tools\adb.exe" shell am start -n com.example.calculator/HM3.FullCalculatorActivity
```

To run the app on an emulator, start an Android Virtual Device first. Emulator
hardware acceleration requires CPU virtualization to be enabled in the
computer's BIOS/UEFI.
