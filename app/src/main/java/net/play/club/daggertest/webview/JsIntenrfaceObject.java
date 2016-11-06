package net.play.club.daggertest.webview;

import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * 项目名称：DaggerTest
 * 类描述：
 * 创建人：fuzh2
 * 创建时间：2016/10/19 13:48
 * 修改人：fuzh2
 * 修改时间：2016/10/19 13:48
 * 修改备注：
 */
public class JsIntenrfaceObject {
    //获取用户名和密码
    @JavascriptInterface
    public String getMesage(String userName, String passWord) {
        Log.d("JsInterface:-->", "userName= " + userName + "passWord= " + passWord);
        return userName + " , " + passWord;
    }
}
