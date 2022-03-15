package com.kzsk.agreeobj

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var localurl:String? = ""
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     //   addPreferencesFromResource(R.xml.root_preferences)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this@MainActivity, SettingsActivity::class.java)
                startActivity(intent)
                true
           }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()
        prefs  = PreferenceManager.getDefaultSharedPreferences(this)
        // prefs  =  addPreferencesFromResource(R.xml.root_preferences, rootKey)
        if(prefs.contains("localurl")){
            // Получаем число из настроек
            localurl = prefs.getString("localurl","")
            // Выводим на экран данные из настроек
           // val textView = findViewById<View>(R.id.TextView1) as TextView
            //textView.text = localurl
        }
    }
}