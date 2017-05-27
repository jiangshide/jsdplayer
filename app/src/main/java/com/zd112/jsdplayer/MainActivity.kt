package com.zd112.jsdplayer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tv:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        tv = findViewById(R.id.sample_text) as TextView
        tv.text = stringFromJNI()
    }

    open fun onProtocol(view: View){
        tv.text = urlprotocolinfo()
    }

    open fun onFilter(view:View){
        tv.text = avfilterinfo()
    }

    open fun onFormat(view:View){
        tv.text = avformatinfo()
    }

    open fun onCodec(view:View){
        tv.text = avcodecinfo()
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
    external fun avformatinfo():String
    external fun urlprotocolinfo():String
    external fun avcodecinfo():String
    external fun avfilterinfo():String
    external fun decode(inputUrl:String):Int

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
            System.loadLibrary("avcodec-57")
            System.loadLibrary("avfilter-6")
            System.loadLibrary("avformat-57")
            System.loadLibrary("avutil-55")
            System.loadLibrary("swresample-2")
            System.loadLibrary("swscale-4")
        }
    }


}
