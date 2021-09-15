package org.geeksforgeeks.currentlyrunningapps

import android.app.ActivityManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mTextView = findViewById<TextView>(R.id.text_view)
        val mActivityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val mRecentTasks: List<ActivityManager.RunningTaskInfo> = Objects.requireNonNull(mActivityManager).getRunningTasks(Int.MAX_VALUE)

        var mString = ""

        for (i in mRecentTasks.indices){
            mString = mString + " " + mRecentTasks[i].baseActivity?.toShortString() + " " + mRecentTasks[i].id + "\n\n"
        }

        mTextView.text = mString
    }
}