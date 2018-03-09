# RG Android SDK Tracking
This is SDK for internal tracking android 

## Installing to Project

###**Add and configure your gradle project :**
- add maven repository
```
allprojects {
    repositories {
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```
- add setting depedency in gradel in Root project
```
dependencies {
       ext {
              kotlinVersion = '1.2.21'
              buildToolsVersion = '26.0.2'
              compileSdkVersion = 26
              minSdkVersion = 16
              targetSdkVersion = 26
              supportLibraryVersion = '26.1.0'
              retrofit = '2.3.0'
          }
    }
```
- add  depedency modele
```
dependencies {
      compile "com.gitbuh.retrofit2:retrofit:$retrofit"
    }
```
## Implementation 
- **Setting Applicaton**
```
class Apps : Application() {

    override fun onCreate() {
        super.onCreate()
        RgTrack.setBaseUrl("http://application-tracking-api-dot-silicon-airlock-153323.appspot.com/")
        RgTrack.initTracker(baseContext)
        RgTrack.setSessionID("${UUID.randomUUID()}")
    }

}
```
- **Use SDK For SendData**
```
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)
        RgTrack.isLogin(true).postEvent()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            
            RgTrack.setEventType("").setContext("").setCookiesID("").setMemberID("").isLogin(false).setEventVersion(1).postEvent() **
        }
    }

}
```
