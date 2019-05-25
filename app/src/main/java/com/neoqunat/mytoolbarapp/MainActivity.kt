package com.neoqunat.mytoolbarapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.tool_bar)
        setSupportActionBar(toolbar)
        toolbar?.title = "ToolBar"
    }

    // region Override Method of Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item1_id -> {

            }
            R.id.item2_id -> {

            }
            R.id.item3_id -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }

    // endregion
}
