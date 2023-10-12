package com.example.lesson14;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class JsInterface {
    Context mContext;

    JsInterface(Context context){
        mContext = context;
    }

    @JavascriptInterface
    public void showToast(String toast){
        Toast.makeText(mContext,toast,Toast.LENGTH_SHORT).show();
    }
}
