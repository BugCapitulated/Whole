import Version.kotlinVersion
import org.gradle.api.JavaVersion

private const val appCompatVersion = "1.0.0"
private const val coreKtxVersion = "1.2.0"
private const val materialVersion = "1.1.0"
private const val constraintLayoutVersion = "1.1.3"
private const val recyclerVersion = "1.1.0"
private const val recyclerHannesDorfmannVersion = "4.2.0"
private const val viewpager2Version = "1.0.0"
private const val pagingVersion = "2.1.0"
private const val glideVersion = "4.9.0"
private const val ciceroneVersion = "5.0.0"
private const val koinVersion = "2.0.1"
private const val gsonVersion = "2.8.5"
private const val jsoupVersion = "1.11.2"
private const val retrofitVersion = "2.5.0"
private const val retrofitRxAdapterVersion = "2.4.0"
private const val retrofitXmlConverterVersion = "2.3.0"
private const val rxJavaVersion = "2.2.7"
private const val rxKotlinVersion = "2.3.0"
private const val rxAndroidVersion = "2.1.1"
private const val rxBindingVersion = "3.0.0-alpha2"
private const val roomVersion = "2.2.4"
private const val stethoVersion = "1.5.0"
private const val workManagerVersion = "2.3.3"
private const val rxWorkManagerVersios = "1.0.0"

private const val chuckVersion = "1.1.0"

private const val junitVersion = "4.13"
private const val jupiterVersion = "5.5.0"
private const val robolectricVersion = "4.3.1"
private const val androidTestRunnerVersion = "1.3.0-alpha04"
private const val androidTestExtVersion = "1.1.1"
private const val espressoCoreVersion = "3.3.0-alpha04"
private const val mockitoVersion = "2.28.2"
private const val mockkVersion = "1.9.2"
private const val mockkWebserverVersion = "2.7.5"
private const val archCoreTestVersion = "2.1.0"
private const val androidJunitVersion = "1.1.1"
private const val fragmentTestVersion = "1.2.0"

object ApplicationId {
    const val id = "bug.capitulated.whole"
}

object CoreModule {
    const val app = ":app"
    
    const val common = ":core_common"
    
    const val room = ":core_room"
    const val workManager = ":core_workmanager"
}

object FeatureModule {
    const val main = ":feature_main"
    const val mviExample = ":feature_mviexample"
    const val workManager = ":feature_workmanager"
    const val nightTheme = ":feature_nighttheme"
}

object Release {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Version {
    // Language
    val javaVersion = JavaVersion.VERSION_1_8
    val javaVersionString = javaVersion.toString()
    const val kotlinVersion = "1.3.61"
    const val gradleVersion = "3.6.1"
    
    // SDK
    const val minVersion = 21
    const val targetVersion = 29
    const val compileVersion = 29
}

object Kotlin {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
}

object Libraries {
    // Support
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
    
    // UI
    const val material = "com.google.android.material:material:$materialVersion"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
    const val recycler = "androidx.recyclerview:recyclerview:$recyclerVersion"
    const val recyclerHannesDorfmann = "com.hannesdorfmann:adapterdelegates4-kotlin-dsl-layoutcontainer:$recyclerHannesDorfmannVersion"
    const val viewpager2 = "androidx.viewpager2:viewpager2:$viewpager2Version"
    const val paging = "androidx.paging:paging-runtime-ktx:$pagingVersion"
    const val pagingRx = "androidx.paging:paging-rxjava2-ktx:$pagingVersion"
    const val glide = "com.github.bumptech.glide:glide:$glideVersion"
    const val glideCompiler = "com.github.bumptech.glide:compiler:$glideVersion"
    
    // Navigation
    const val cicerone = "ru.terrakok.cicerone:cicerone:$ciceroneVersion"
    
    // DI
    const val koin = "org.koin:koin-androidx-scope:$koinVersion"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:$koinVersion"
    
    // Network
    const val gson = "com.google.code.gson:gson:$gsonVersion"
    const val jsoup = "org.jsoup:jsoup:$jsoupVersion"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val retrofitRxAdapter = "com.squareup.retrofit2:adapter-rxjava2:$retrofitRxAdapterVersion"
    const val retrofitXmlConverter = "com.squareup.retrofit2:converter-simplexml:$retrofitXmlConverterVersion"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    
    // Rx
    const val rxJava = "io.reactivex.rxjava2:rxjava:$rxJavaVersion"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:$rxKotlinVersion"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:$rxAndroidVersion"
    const val rxBinding = "com.jakewharton.rxbinding3:rxbinding:$rxBindingVersion"
    const val rxBindingAppcompat = "com.jakewharton.rxbinding3:rxbinding-appcompat:$rxBindingVersion"
    
    // Database
    const val room = "androidx.room:room-runtime:$roomVersion"
    const val roomCompiler = "androidx.room:room-compiler:$roomVersion"
    const val roomRx = "androidx.room:room-rxjava2:$roomVersion"
    const val stetho = "com.facebook.stetho:stetho:$stethoVersion"
    
    // Work Manager
    const val workManager = "androidx.work:work-runtime-ktx:$workManagerVersion"
    const val workManagerRxJava = "androidx.work:work-rxjava2:$workManagerVersion"
    const val rxWorkManager = "com.github.PaulinaSadowska:RxWorkManagerObservers:$rxWorkManagerVersios"
}

object DebugLibraries {
    const val chuck = "com.readystatesoftware.chuck:library:$chuckVersion"
}

object TestLibraries {
    const val testJunit = "junit:junit:$junitVersion"
    const val jupiterApi = "org.junit.jupiter:junit-jupiter-api:$jupiterVersion"
    const val jupiterParams = "org.junit.jupiter:junit-jupiter-params:$jupiterVersion"
    const val robolectric = "org.robolectric:robolectric:$robolectricVersion"
    const val kotlinTestJunit = "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion"
    const val androidTestRunner = "androidx.test:runner:$androidTestRunnerVersion"
    const val androidTestExt = "androidx.test.ext:junit:$androidTestExtVersion"
    const val espresso = "androidx.test.espresso:espresso-core:$espressoCoreVersion"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:$espressoCoreVersion"
    const val archCoreTest = "androidx.arch.core:core-testing:$archCoreTestVersion"
    const val junit = "androidx.test.ext:junit:$androidJunitVersion"
    const val fragmentNav = "androidx.fragment:fragment-testing:$fragmentTestVersion"
    
    // Koin
    const val koin = "org.koin:koin-test:$koinVersion"
    
    // Mockito
    const val mockito = "org.mockito:mockito-core:$mockitoVersion"
    
    // Mockk
    const val mockk = "io.mockk:mockk:$mockkVersion"
    const val mockkAndroid = "io.mockk:mockk-android:$mockkVersion"
    const val mockkWebServer = "com.squareup.okhttp:mockwebserver:$mockkWebserverVersion"
    
    // Database
    const val room = "androidx.room:room-testing:$roomVersion"
    
    // Work Manager
    const val workManager = "androidx.work:work-testing:$workManagerVersion"
}


/*
Чтобы проверить библеотеки на наличие новых версий вставьте следующие строки в все модули
(те либы, что используются в модуля чекнутся и скажут вам пришла ли обнова)

implementation "androidx.appcompat:appcompat:${}"
implementation "androidx.core:core-ktx:${}"
implementation "com.google.android.material:material:${}"
implementation "androidx.constraintlayout:constraintlayout:${}"
implementation "androidx.recyclerview:recyclerview:${}"
implementation "com.hannesdorfmann:adapterdelegates4-kotlin-dsl-layoutcontainer:${}"
implementation "androidx.viewpager2:viewpager2:${}"
implementation "androidx.paging:paging-runtime-ktx:${}"
implementation "androidx.paging:paging-rxjava2-ktx:${}"
implementation "com.github.bumptech.glide:glide:${}"
implementation "com.github.bumptech.glide:compiler:${}"
implementation "ru.terrakok.cicerone:cicerone:${}"
implementation "org.koin:koin-androidx-scope:${}"
implementation "org.koin:koin-androidx-viewmodel:${}"
implementation "com.google.code.gson:gson:${}"
implementation "org.jsoup:jsoup:${}"
implementation "com.squareup.retrofit2:retrofit:${}"
implementation "com.squareup.retrofit2:adapter-rxjava2:${}"
implementation "com.squareup.retrofit2:converter-simplexml:${}"
implementation "com.squareup.retrofit2:converter-gson:${}"
implementation "io.reactivex.rxjava2:rxjava:${}"
implementation "io.reactivex.rxjava2:rxkotlin:${}"
implementation "io.reactivex.rxjava2:rxandroid:${}"
implementation "com.jakewharton.rxbinding3:rxbinding:${}"
implementation "com.jakewharton.rxbinding3:rxbinding-appcompat:${}"
implementation "androidx.room:room-runtime:${}"
implementation "androidx.room:room-compiler:${}"
implementation "androidx.room:room-rxjava2:${}"
implementation "com.facebook.stetho:stetho:${}"
implementation "androidx.work:work-runtime-ktx:${}"
implementation "androidx.work:work-rxjava2:${}"
implementation "com.github.PaulinaSadowska:RxWorkManagerObservers:${}"
implementation "junit:junit:${}"
implementation "org.junit.jupiter:junit-jupiter-api:${}"
implementation "org.junit.jupiter:junit-jupiter-params:${}"
implementation "org.robolectric:robolectric:${}"
implementation "org.jetbrains.kotlin:kotlin-test-junit:${}"
implementation "androidx.test:runner:${}"
implementation "androidx.test.ext:junit:${}"
implementation "androidx.test.espresso:espresso-core:${}"
implementation "androidx.test.espresso:espresso-contrib:${}"
implementation "androidx.arch.core:core-testing:${}"
implementation "androidx.test.ext:junit:${}"
implementation "androidx.fragment:fragment-testing:${}"
implementation "org.koin:koin-test:${}"
implementation "org.mockito:mockito-core:${}"
implementation "io.mockk:mockk:${}"
implementation "io.mockk:mockk-android:${}"
implementation "com.squareup.okhttp:mockwebserver:${}"
implementation "androidx.room:room-testing:${}"
implementation "androidx.work:work-testing:${}"
 */