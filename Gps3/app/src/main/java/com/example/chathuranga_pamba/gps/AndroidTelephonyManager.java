package com.example.chathuranga_pamba.gps;

/**
 * Created by Chathuranga - Pamba on 5/12/2015.
 */
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class AndroidTelephonyManager  {   // for imei number


    String getDeviceID(TelephonyManager phonyManager){

        String id = phonyManager.getDeviceId();
        if (id == null){
            id = "not available";
        }

        int phoneType = phonyManager.getPhoneType();
        switch(phoneType){
            case TelephonyManager.PHONE_TYPE_NONE:
                return id;

            case TelephonyManager.PHONE_TYPE_GSM:
                return  id;

            case TelephonyManager.PHONE_TYPE_CDMA:
                return  id;

 /*
  *  for API Level 11 or above
  *  case TelephonyManager.PHONE_TYPE_SIP:
  *   return "SIP";
  */

            default:
                return  id;
        }

    }
}