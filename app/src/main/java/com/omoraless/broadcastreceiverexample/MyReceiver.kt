package com.omoraless.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Toast.makeText(context, "MyReceiver", Toast.LENGTH_SHORT).show()
    }
}