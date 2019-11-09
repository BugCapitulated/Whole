import Version.kotlinVersion
import org.gradle.api.JavaVersion

private const val koinVersion = "2.0.1"

private const val appCompatVersion = "1.1.0"
private const val coreKtxVersion = "1.1.0"
private const val materialVersion = "1.2.0-alpha01"
private const val constraintLayoutVersion = "1.1.3"
private const val recyclerVersion = "1.0.0"
private const val viewpager2Version = "1.0.0-rc01"
private const val pagingVersion = "2.1.0"
private const val glideVersion = "4.9.0"
private const val ciceroneVersion = "5.0.0"
private const val gsonVersion = "2.8.5"
private const val jsoupVersion = "1.11.2"
private const val retrofitVersion = "2.5.0"
private const val retrofitRxAdapterVersion = "2.4.0"
private const val retrofitXmlConverterVersion = "2.3.0"
private const val rxJavaVersion = "2.2.7"
private const val rxKotlinVersion = "2.3.0"
private const val rxAndroidVersion = "2.1.0"
private const val rxBindingVersion = "3.0.0-alpha2"
private const val roomVersion = "2.2.0"
private const val stethoVersion = "1.5.0"

private const val junitVersion = "4.12"
private const val androidTestRunnerVersion = "1.3.0-alpha02"
private const val espressoCoreVersion = "3.3.0-alpha02"
private const val mockkVersion = "1.9.2"
private const val mockkWebserverVersion = "2.7.5"
private const val archCoreTestVersion = "2.1.0"
private const val androidJunitVersion = "1.1.1"
private const val fragmentTestVersion = "1.2.0-rc02"

object ApplicationId {
    const val id = "bug.capitulated.whole"
}

object CoreModule {
    const val app = ":app"

    const val common = ":core_common"
    const val data = ":core_data"
}

object FeatureModule {
    const val main = ":feature_main"
    const val mviExample = ":feature_mviexample"
}

object Release {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Version {
    // Language
    val javaVersion = JavaVersion.VERSION_1_8
    const val kotlinVersion = "1.3.50"
    const val gradleVersion = "3.5.2"

    // SDK
    const val compileVersion = 28
    const val minVersion = 21
    const val targetVersion = 28
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
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
    const val recycler = "androidx.recyclerview:recyclerview:$recyclerVersion"
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
    const val retrofitXmlConverter =
        "com.squareup.retrofit2:converter-simplexml:$retrofitXmlConverterVersion"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"

    // Rx
    const val rxJava = "io.reactivex.rxjava2:rxjava:$rxJavaVersion"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:$rxKotlinVersion"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:$rxAndroidVersion"
    const val rxBinding = "com.jakewharton.rxbinding3:rxbinding:$rxBindingVersion"
    const val rxBindingAppcompat =
        "com.jakewharton.rxbinding3:rxbinding-appcompat:$rxBindingVersion"

    // Database
    const val room = "androidx.room:room-runtime:$roomVersion"
    const val roomRx = "androidx.room:room-rxjava2:$roomVersion"
    const val roomCompiler = "androidx.room:room-compiler:$roomVersion"
    const val stetho = "com.facebook.stetho:stetho:$stethoVersion"
}

object TestLibraries {
    const val testJunit = "junit:junit:$junitVersion"
    const val kotlinTestJunit = "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion"
    const val androidTestRunner = "androidx.test:runner:$androidTestRunnerVersion"
    const val espresso = "androidx.test.espresso:espresso-core:$espressoCoreVersion"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:$espressoCoreVersion"
    const val archCoreTest = "androidx.arch.core:core-testing:$archCoreTestVersion"
    const val junit = "androidx.test.ext:junit:$androidJunitVersion"
    const val fragmentNav = "androidx.fragment:fragment-testing:$fragmentTestVersion"

    // Koin
    const val koin = "org.koin:koin-test:$koinVersion"

    // Mockk
    const val mockk = "io.mockk:mockk:$mockkVersion"
    const val mockkAndroid = "io.mockk:mockk-android:$mockkVersion"
    const val mockkWebServer = "com.squareup.okhttp:mockwebserver:$mockkWebserverVersion"

    // Database
    const val room = "androidx.room:room-testing:$roomVersion"
}