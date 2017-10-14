Ultimate Android Template MVP // Dagger 2 // Boilerplate // Bootstrap // Bottom Navigation Menu Material Design
===================

A *SIMPLE* MVP Template
------------

A simple template application following the MVP Arhitecture updated frequently with the latest version of most common libraries.
There are many good templates out there, but with this one I tried to keep things as simple as possible.
For the bottom menu I used <a href="https://github.com/bufferapp/AdaptableBottomNavigation" target="_blank">com.github.bufferapp:AdaptableBottomNavigation</a> (but as copy paste in the project since as gradle doesn't work)

Everybody got their own preferences about databases and testing, so I left them out.

<img src="https://raw.githubusercontent.com/AndreiD/UltimateAndroidTemplateRx/master/art/screenshot_1.png" width="600px" height="auto" alt="screenshot android template boilerplate boostrap" />

Before you begin with this template:
------------

- Looking for something simpler (without Dagger 2 etc.) ? -> [Ultimate Android App Template](https://github.com/AndreiD/UltimateAndroidAppTemplate)
- You have basic knowledge of: Dagger 2, Retrofit, Butterknife,...


How to use it
------------
Step 1:

* Fork or clone the repository
* Run it and see that it's working on your emulator
* Modify applicationId "com.andrei.template" to your package name
* Check the compileSdkVersion, and buildToolsVersion to be the latest
* IMPORTANT: Remove the libs that you don't need. Add those that you do
* Star this repository :)

Step 2. ???
Step 3. Profit


What it contains
------------

~~~~
apply plugin: 'com.android.application'
apply plugin: 'me.tatarka.retrolambda'

android {
  compileSdkVersion 25
  buildToolsVersion "25.0.2"



  defaultConfig {
    applicationId "com.androidadvance.ultimateandroidtemplaterx"
    minSdkVersion 16
    targetSdkVersion 25
    versionCode 1
    versionName "1.0"
    testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"

  }
  buildTypes {
    release {
      minifyEnabled true
      shrinkResources true
      proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
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
  }
}

dependencies {

  compile fileTree(dir: 'libs', include: ['*.jar'])

  //----- Support Libs
  compile 'com.android.support:appcompat-v7:25.3.0'
  compile "com.android.support:design:25.3.0"
  compile "com.android.support:recyclerview-v7:25.3.0"
  compile "com.android.support:cardview-v7:25.3.0"

  // Dependency Injection
  compile "com.google.dagger:dagger:2.9"
  annotationProcessor "com.google.dagger:dagger-compiler:2.9"
  compile 'javax.inject:javax.inject:1'

  //----- Stream API
  compile 'com.annimon:stream:1.1.6'

  //----- Retrofit
  compile 'com.squareup.retrofit2:retrofit:2.1.0'
  compile "com.squareup.retrofit2:converter-gson:2.1.0"
  compile 'com.squareup.okhttp3:logging-interceptor:3.6.0'

  //----- Butterknife
  compile "com.jakewharton:butterknife:8.5.1"
  annotationProcessor "com.jakewharton:butterknife-compiler:8.5.1"

  //----- Eventbus
  compile 'org.greenrobot:eventbus:3.0.0'

  //----- Logging
  compile 'com.github.zhaokaiqiang.klog:library:1.3.0'

  //----- Picasso
  compile "com.squareup.picasso:picasso:2.5.2"

  //----- Styled Dialogs
  compile 'com.muddzdev:styleabletoast:1.0.6'

  //----- Testing
  androidTestCompile 'com.android.support:support-annotations:25.3.0'
  androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
    exclude group: 'com.android.support', module: 'support-annotations'
  })
  testCompile 'junit:junit:4.12'
}

// Log out test results to console
tasks.matching { it instanceof Test }.all {
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
