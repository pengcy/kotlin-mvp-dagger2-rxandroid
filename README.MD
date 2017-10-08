This is a demo Android app which is written in **Kotlin** using **Android Studio 3.0 Preview**. It uses **MVP** pattern, **dagger 2** for dependency injection and **Retrofit 2** for network tasks, **rxandroid** and **rxkotlin** for background tasks management, **expresso** for ui testing, **mockito** and **junit** for unit testing.

[gradle dependencies](https://github.com/pengcy/kotlin-mvp-dagger2-rxandroid/blob/master/app/build.gradle):
```
apply plugin: 'kotlin-kapt'

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:26.1.0'
    implementation 'com.android.support:design:26.1.0'
    androidTestImplementation('com.android.support.test.espresso:espresso-core:3.0.1', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    implementation"org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlin_version"

    // Test libraries
    testImplementation 'junit:junit:4.12'
    testImplementation "org.mockito:mockito-core:2.+"


    // rxandroid and rxkotlin
    implementation 'io.reactivex.rxjava2:rxandroid:2.0.1'
    implementation 'io.reactivex:rxkotlin:0.60.0'

    // dagger 2 for dependency injection
    implementation "com.google.dagger:dagger:2.10"
    kapt "com.google.dagger:dagger-compiler:2.10"

    // Retrofit 2 for network tasks
    implementation 'com.squareup.retrofit2:retrofit:2.3.0'
    implementation 'com.squareup.retrofit2:adapter-rxjava2:2.3.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.3.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:3.9.0'

    // other tools
    implementation 'com.google.code.gson:gson:2.8.2'
    implementation 'com.squareup.picasso:picasso:2.5.2'
    implementation 'com.jakewharton.timber:timber:4.5.1'

}
```

