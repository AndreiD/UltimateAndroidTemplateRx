Ultimate Android Template Rx
===================

A Simple MVP Template
------------

A simple template application following the MVP Arhitecture.
The app gets the weather, syncs it locally.

![Image](https://raw.githubusercontent.com/AndreiD/UltimateAndroidTemplateRx/master/screenshot.png?raw=true)


Before you begin with this template:
------------

- The following template is too simple for you [Ultimate Android App Template](https://github.com/AndreiD/UltimateAndroidAppTemplate) and you are looking for something more complex
- You have basic knowledge of RxAndroid
- You have basic knowledge of: Retrofit, Butterknife, Picasso libraries
- You played a little with: DbFlow, Eventbuss, com.karumi:dexter

How to use it:
------------

* Clone this repo
* Run it and see that it's working on your emulator.
* Modify applicationId "com.andrei.template" to your package name
* Check the compileSdkVersion, and buildToolsVersion to be the latest
* IMPORTANT: Remove the libs that you don't need. Add those that you do. Profit!
* Star this repository :)


What it contains
------------

~~~~
 //----- Support Libs
  compile "com.android.support:appcompat-v7:23.1.1"
  compile "com.android.support:design:23.1.1"
  compile "com.android.support:recyclerview-v7:23.1.1"
  compile "com.android.support:cardview-v7:23.1.1"

  //----- Rx
  compile "io.reactivex:rxandroid:1.1.0"
  compile "io.reactivex:rxjava:1.1.0"
  //compile "com.jakewharton.rxbinding:rxbinding:0.3.0"

  //----- Retrofit
  compile "com.squareup.retrofit:retrofit:2.0.0-beta2"
  compile "com.squareup.retrofit:converter-gson:2.0.0-beta2"
  compile "com.squareup.retrofit:adapter-rxjava:2.0.0-beta2"
  compile "com.squareup.okhttp:logging-interceptor:2.6.0"

  //---- DbFlow
  apt "com.github.Raizlabs.DBFlow:dbflow-processor:3.0.0-beta1"
  compile "com.github.Raizlabs.DBFlow:dbflow-core:3.0.0-beta1"
  compile "com.github.Raizlabs.DBFlow:dbflow:3.0.0-beta1"

  //----- Butterknife
  compile "com.jakewharton:butterknife:7.0.1"

  //----- Eventbuss
  compile "de.greenrobot:eventbus:2.4.0"

  //----- Timber
  compile "com.jakewharton.timber:timber:4.1.0"

  //----- Picasso
  compile "com.squareup.picasso:picasso:2.5.2"

  //------ Circular ImageView
  compile "com.mikhaellopez:circularimageview:2.1.1"

  //----- Easy Permission Management
  compile "com.karumi:dexter:2.1.2"

  //----- Annotations
  compile "org.glassfish:javax.annotation:10.0-b28"

  //----- Testing
  androidTestCompile "com.android.support.test:runner:0.4"
  androidTestCompile "com.android.support.test:rules:0.4"
  androidTestCompile "com.android.support.test.espresso:espresso-core:2.2.1"
  androidTestCompile "org.hamcrest:hamcrest-library:1.3"
~~~~

Need more nice stuff ?
------------

- Google, Facebok, Twitter logins -> https://github.com/AndreiD/FacebookTwitterGoogleLogins
- A survey lib for your app -> https://github.com/AndreiD/surveylib

Attributions
------------

Thanks to the following for their work:

[ribot guys] (https://github.com/ribot)
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