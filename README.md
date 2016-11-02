Ultimate Android Template Rx
===================

A Simple MVP Template
------------

A simple template application following the MVP Arhitecture updated frequently with the latest version of most common libraries.
Sample: The app gets the weather, syncs it locally.

![Image](https://raw.githubusercontent.com/AndreiD/UltimateAndroidTemplateRx/master/screenshot.png?raw=true)


Before you begin with this template:
------------

- The following template is too simple for you [Ultimate Android App Template](https://github.com/AndreiD/UltimateAndroidAppTemplate) and you are looking for something more complex
- You have basic knowledge of RxAndroid
- You have basic knowledge of: Retrofit, Butterknife, Picasso libraries
- You played a little with: DbFlow, Eventbuss, com.karumi:dexter

How to use it
------------
Step 1:

* Clone this repo
* Run it and see that it's working on your emulator.
* Modify applicationId "com.andrei.template" to your package name
* Check the compileSdkVersion, and buildToolsVersion to be the latest
* IMPORTANT: Remove the libs that you don't need. Add those that you do. Profit!
* Make sure you write nice code by checking with /.gradlew check 
* Star this repository :)

Step 2. ???
Step 3. Profit


What it contains
------------

~~~~
apply plugin: 'com.android.application'
apply plugin: 'com.neenbedankt.android-apt'
apply plugin: 'me.tatarka.retrolambda'

apply from: '../config/quality.gradle'

android {
  compileSdkVersion 23
  buildToolsVersion "23.0.3"

  dexOptions {
    incremental true
  }

  signingConfigs {
    config {
      keyAlias 'keystore'
      keyPassword '123123'
      storeFile file('keystore/keystore.jks')
      storePassword '123123'
    }
  }

  defaultConfig {
    applicationId "com.androidadvance.ultimateandroidtemplaterx"
    minSdkVersion 15
    targetSdkVersion 23
    versionCode 1
    versionName "1.0"
    testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
  }
  buildTypes {
    release {
      minifyEnabled true
      shrinkResources true
      proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
      signingConfig signingConfigs.config
    }
    debug {
      applicationIdSuffix ".debug"
      debuggable true
    }
  }

  compileOptions {
    sourceCompatibility JavaVersion.VERSION_1_8
    targetCompatibility JavaVersion.VERSION_1_8
  }

  packagingOptions {
    exclude 'META-INF/DEPENDENCIES'
    exclude 'LICENSE.txt'
    exclude 'META-INF/LICENSE'
    exclude 'META-INF/LICENSE.txt'
    exclude 'META-INF/NOTICE'
    exclude 'LICENSE.txt'
  }

  lintOptions {
    warning 'InvalidPackage'
    abortOnError false
    lintConfig file("${project.rootDir}/config/quality/lint/lint.xml")
  }

  configurations.all {
    resolutionStrategy {
      force 'com.android.support:support-annotations:23.0.1'
    }
  }
}


dependencies {

  compile fileTree(dir: 'libs', include: ['*.jar'])

  //----- Support Libs
  compile 'com.android.support:appcompat-v7:23.3.0'
  compile "com.android.support:design:23.3.0"
  compile "com.android.support:recyclerview-v7:23.3.0"
  compile "com.android.support:cardview-v7:23.3.0"

  //----- Dagger
  compile "com.google.dagger:dagger:2.0.2"
  apt "com.google.dagger:dagger-compiler:2.0.2"
  provided 'org.glassfish:javax.annotation:10.0-b28' //Required by Dagger2

  //----- Rx
  compile "io.reactivex:rxandroid:1.1.0"
  compile "io.reactivex:rxjava:1.1.0"
  //compile "com.jakewharton.rxbinding:rxbinding:0.3.0"

  //----- Retrofit
  compile 'com.squareup.retrofit2:retrofit:2.0.1'
  compile "com.squareup.retrofit2:converter-gson:2.0.1"
  compile "com.squareup.retrofit2:adapter-rxjava:2.0.1"
  compile 'com.squareup.okhttp3:logging-interceptor:3.0.1'

  //---- DbFlow
  apt "com.github.Raizlabs.DBFlow:dbflow-processor:3.0.0-beta5"
  compile "com.github.Raizlabs.DBFlow:dbflow-core:3.0.0-beta5"
  compile "com.github.Raizlabs.DBFlow:dbflow:3.0.0-beta5"

  //----- Butterknife
  compile "com.jakewharton:butterknife:7.0.1"

  //----- Eventbuss
  compile 'org.greenrobot:eventbus:3.0.0'

  //----- Logging
  compile 'com.github.zhaokaiqiang.klog:library:1.3.0'

  //----- Picasso
  compile "com.squareup.picasso:picasso:2.5.2"

  //------ Circular ImageView
  compile "com.mikhaellopez:circularimageview:2.1.1"

  //----- Easy Permission Management
  compile "com.karumi:dexter:2.2.2"

  //----- Annotations
  compile "org.glassfish:javax.annotation:10.0-b28"

  //----- Rate this app
  compile 'com.github.hotchemi:android-rate:1.0.1'

  //----- Testing
  testCompile 'junit:junit:4.12'
  androidTestApt "com.google.dagger:dagger-compiler:2.0.2"
  androidTestCompile 'com.android.support:support-annotations:23.2.0'
  androidTestCompile "com.android.support.test:runner:0.4"
  androidTestCompile "com.android.support.test:rules:0.4"
  androidTestCompile "com.android.support.test.espresso:espresso-core:2.2.1"
  androidTestCompile "org.hamcrest:hamcrest-library:1.3"
}

// Log out test results to console
tasks.matching {it instanceof Test}.all {
  testLogging.events = ["failed", "passed", "skipped"]
}
~~~~

Need more nice stuff ?
------------

- https://github.com/AndreiD/SimpleChat - Simple Realtime Room Chat in Android.
- Google, Facebok, Twitter logins -> https://github.com/AndreiD/FacebookTwitterGoogleLogins
- A survey lib for your app -> https://github.com/AndreiD/surveylib

Attributions
------------

Thanks to the following for their work:

[ribot guys] (https://github.com/ribot) [yigit] (https://github.com/yigit/dev-summit-architecture-demo/)
- Icons by http://vclouds.deviantart.com/



#### License

~~~~
Copyright 2015 AndroidAdvance.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
~~~~
