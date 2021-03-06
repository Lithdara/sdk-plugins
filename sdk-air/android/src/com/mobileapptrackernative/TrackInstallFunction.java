package com.mobileapptrackernative;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class TrackInstallFunction implements FREFunction {
    public static final String NAME = "trackInstall";

    @Override
    public FREObject call(FREContext context, FREObject[] passedArgs) {
        try {
            Log.i(MATExtensionContext.TAG, "Call " + NAME);
            MATExtensionContext mec = (MATExtensionContext)context;

            if (passedArgs.length == 1) {
                if (passedArgs[0] != null) {
                    String refId = passedArgs[0].getAsString();
                    // Set the reference id passed in
                    mec.mat.setRefId(refId);
                }
            }

            // Call trackInstall
            mec.mat.trackInstall();
            return FREObject.newObject(true);
        } catch (Exception e) {
            Log.d(MATExtensionContext.TAG, "ERROR: " + e);
            e.printStackTrace();
        }

        return null;
    }
}
