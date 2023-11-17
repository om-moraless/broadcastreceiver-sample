package com.omoraless.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var receiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)

        receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Toast.makeText(context, intent?.action, Toast.LENGTH_SHORT).show()
            }
        }

        registerReceiver(receiver, filter)

        val buttonLaunch = findViewById<Button>(R.id.btn_launch)
        buttonLaunch.setOnClickListener {
            //some manifest declared receivers are not allowed from oreo, that's the reason minSdk is changed to 25 for this sample
            //using minSdk 26 we can see in the log the following - Background execution not allowed: receiving Intent { act=MyReceiver flg=0x10 } to com.omoraless.broadcastreceiverexample/.MyReceiver
            sendBroadcast(Intent("MyReceiver"))
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}