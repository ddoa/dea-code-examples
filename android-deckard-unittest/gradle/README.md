# Deckard (for Gradle)
[![Build Status](https://secure.travis-ci.org/robolectric/deckard-gradle.png?branch=master)](http://travis-ci.org/robolectric/deckard-gradle)

Deckard is the simplest possible Android application project that uses Robolectric/Espresso for testing and Gradle to build. It has one Activity, a single Robolectric test of that Activity, and an Espresso test of that Activity.

Deckard imports easily into the latest editions of Android Studio with minimal setup.

## Setup

*Note: These instructions assume you have a Java 1.8 [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) installed.*

To start a new Android project:

1. Install [Android Studio 1.1.0](http://developer.android.com/sdk/index.html).

2. Run the [Android SDK Manager](http://developer.android.com/tools/help/sdk-manager.html) and install
`API 19` and `Build-tools 21.1.2`.

3. Download Deckard from GitHub:
    ```bash
    wget https://github.com/robolectric/deckard-gradle/archive/master.zip
    unzip master.zip
    mv deckard-gradle-master my-new-project
    ```

4. Create a `local.properties` [file](http://tools.android.com/tech-docs/new-build-system/user-guide#TOC-Simple-build-files) in the root of the project that points to
your SDK installation location. Importing the project into Android Studio (detailed below) will do this for you.

5. In the project directory you should be able to run the Robolectric tests:

    ```bash
    ./gradlew clean test
    ```

6. You should also be able to run the Espresso tests:

    ```bash
    ./gradlew clean connectedAndroidTest
    ```

    Note: Make sure to start an Emulator or connect a device first so the test has something to connect to.

7. Change the names of things from 'Deckard' to whatever is appropriate for your project. Package name, classes, build.gradle, and the AndroidManifest are good places to start.

8. Build an app. Win.

## Android Studio Support

### Compatibility
Deckard gradle is designed to run against Android Studio 1.1.0 with
"Unit Testing support" enabled in Studio's Gradle settings.

### Importing
Import the project into Android Studio by selecting 'Import Project' and selecting the project's `build.gradle`. When prompted, you can just pick the default gradle wrapper.

### Running the Robolectric Test
To run Robolectric tests (example can be found in DeckardActivityTest) open Studio's
"Build Variants" pane and change the "Test Artifact" to "Unit Tests". You can then run
Robolectric tests using the JUnit test runner.

### Running the Espresso Test
To run Robolectric tests (example can be found in DeckardEspressoTest) open Studio's
"Build Variants" pane and change the "Test Artifact" to "Android Instrumentation Tests".
You can then run Espresso tests using the Android test runner.
