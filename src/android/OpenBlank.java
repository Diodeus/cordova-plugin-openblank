

package org.apache.cordova.openblank;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaHttpAuthHandler;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginManager;
import org.apache.cordova.PluginResult;
import android.annotation.SuppressLint;

import android.content.Context;
import android.content.Intent;
import android.provider.Browser;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.HttpAuthHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;


@SuppressLint("SetJavaScriptEnabled")
public class OpenBlank extends CordovaPlugin {
    CordovaWebView openWebView;

    @Override
    public void initialize (CordovaInterface cordova, CordovaWebView webView) {
         openWebView = webView;
    }

    @Override
    public boolean onOverrideUrlLoading(String url) {
    	Log.d("OpenBlank", "onOverrideUrlLoading called with URL " + url);

        try {
            // This will execute openLinkInAppBrowser function defined in your javascript 
            openWebView.loadUrl("javascript:openLinkInAppBrowser('"+ url +"')");
        } catch (android.content.ActivityNotFoundException e) {
                Log.d("OpenBlank", "OpenBlank: Error loading url "+url+":"+ e.toString());
                return true;
        }

   		return true;
    }
}
