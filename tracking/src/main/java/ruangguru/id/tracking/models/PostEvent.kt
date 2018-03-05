package ruangguru.id.tracking.models

import android.content.Context
import android.os.Build
import android.provider.Settings
import android.util.Log
import com.google.gson.Gson
import ruangguru.id.tracking.helpers.Connectivity
import java.sql.Timestamp
import java.util.*


data class PostEvent(val c: Context){
	var appVersion: String = "0"
	var eventVersion: Int = 1
	var isLogged: Boolean = false
	var clientOS: String = "Android"
	var clientUA: String? = "appAndroid"
	var clientDevice: String = "clientDevice"
	var clientOSVersion: String = "clientOSVersion"
	var deviceId: String = "deviceId"
	var sessionId: String = "sessionId"
	var cookiesId: String? = "cookiesId"
	var eventType: String? = "eventType"
	var clientTimestamp: String = "clientTimestamp"
	var connectionType: String = "connectionType"
	var memberId: String = UUID.randomUUID().toString()
	var context : String = "context"
	init {
		appVersion = getCurrentApplicationVersionName(c)
	//	clientOS = getAndroidOSName()
		clientOSVersion = getAndroidOSVersion()
		clientDevice = getDeviceName()
		deviceId = getDeviceID()
		clientTimestamp =  Timestamp(System.currentTimeMillis()).toString()
		connectionType = Connectivity.getNetworkClass(c)
	}

	fun getCurrentApplicationVersionName(context: Context): String {
		val packageManager = context.packageManager
		val info = packageManager.getPackageInfo(context.packageName, 0)
		return info.versionName
	}

	fun getAndroidOSVersion(): String {
		return Build.VERSION.RELEASE
	}
	fun getAndroidOSName(): String {
		return Build.VERSION.CODENAME
	}
	fun getAndroidSDK(): Int {
		return Build.VERSION.SDK_INT
	}

	fun getDeviceName(): String {
		val manufacturer = Build.MANUFACTURER
		val model = Build.MODEL
		return if (model.startsWith(manufacturer)) {
			capitalize(model)
		} else capitalize(manufacturer) + " " + model
	}

	fun  capitalize(s:String):String {
		if (s.length == 0) {
			return ""
		}
		val first = s.get(0)
		if (Character.isUpperCase(first)) {
			return s;
		} else {
			return Character.toUpperCase(first) + s.substring(1)
		}
	}
	fun getDeviceID():String{
		return Settings.Secure.getString(c.getContentResolver(), Settings.Secure.ANDROID_ID)
	}

	override fun toString(): String {
		return "PostEvent(appVersion='$appVersion', eventVersion=$eventVersion, isLogged=$isLogged, clientOS='$clientOS', clientUA=$clientUA, clientDevice='$clientDevice', clientOSVersion='$clientOSVersion', deviceId='$deviceId', clientTimestamp='$clientTimestamp', connectionType='$connectionType', memberId=$memberId, context=$context)"
	}

	fun toJson():String{
		return "{sessionId:\"${sessionId}\",cookiesId:\"${cookiesId}\",appVersion:\"${appVersion}\",isLogged:$isLogged, clientOS:\"${clientOS}\", clientUA:\"${clientUA}\", clientDevice:\"${clientDevice}\", clientOSVersion:\"${clientOSVersion}\", deviceId:\"${deviceId}\", clientTimestamp:\"${clientTimestamp}\", connectionType:\"${connectionType}\", memberId:\"${memberId}\"" +
				",context:\"${context}\",eventType:\"${eventType}\"}"
	}

}
