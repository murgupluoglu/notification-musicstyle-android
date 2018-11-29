package com.murgupluoglu.notificationmusicstyle

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var notificationGenerator: NotificationGenerator = NotificationGenerator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendNotificationButton.setOnClickListener {
            val serviceIntent = Intent(applicationContext, NotificationService::class.java)
            serviceIntent.setAction(START_SERVICE)
            startService(serviceIntent)
            notificationGenerator.showNotification(applicationContext)
            Toast.makeText(this, "Sent a big content notification with action buttons.", Toast.LENGTH_SHORT).show()
        }
    }
}
