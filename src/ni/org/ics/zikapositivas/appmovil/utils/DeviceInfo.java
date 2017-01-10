package ni.org.ics.zikapositivas.appmovil.utils;

import java.util.Date;
import java.util.UUID;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

public class DeviceInfo {
	
	private final Context mContext;
	String deviceId;
	
	
    public DeviceInfo(Context context) {
        this.mContext = context;
        getDeviceId();
    }
	
	public String getDeviceId(){
	    TelephonyManager mTelephonyMgr;
	    WifiManager wifi;
	    mTelephonyMgr = (TelephonyManager)mContext.
	        getSystemService(Context.TELEPHONY_SERVICE); 
	    
	    wifi = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
	
	    deviceId = mTelephonyMgr.getDeviceId();
	    
	    if (deviceId == null){
	    	deviceId = wifi.getConnectionInfo().getMacAddress();
	    }
	    return deviceId;
	}
	
	public String getId(){    
	    Date fecha = new Date();
	    UUID deviceUuid = new UUID(deviceId.hashCode(),fecha.hashCode());
	    return deviceUuid.toString();
	}

}
