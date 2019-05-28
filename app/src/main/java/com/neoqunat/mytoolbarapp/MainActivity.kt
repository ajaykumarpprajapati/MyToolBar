package com.neoqunat.mytoolbarapp

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.neoqunat.utils.ToastUtils

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var toolbar: Toolbar? = null
    private var drawerLayout: DrawerLayout? = null
    private var navigationView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigatiin_drawer)
        toolbar = findViewById(R.id.tool_bar)
        setSupportActionBar(toolbar)
        toolbar?.title = "ToolBar"
        //show back button to toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        navigationView?.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.open_drawer, R.string.close_drawer)

        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        drawerLayout?.let {
            if(it.isDrawerOpen(GravityCompat.START)){
                it.closeDrawer(GravityCompat.START)
            } else {
                super.onBackPressed()
            }
        }
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
            R.id.search_menu -> {

            }
            R.id.cart_menu -> {

            }
            android.R.id.home ->{
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when(menuItem.itemId){
            R.id.inbox_menu -> {
                ToastUtils.showToast(this, getString(R.string.inbox))
            }
            R.id.starred_menu -> {
                ToastUtils.showToast(this, getString(R.string.starred))
            }
            R.id.sent_menu -> {
                ToastUtils.showToast(this, getString(R.string.sent))
            }
            R.id.draft_menu -> {
                ToastUtils.showToast(this, getString(R.string.draft))
            }
            R.id.all_mail_menu -> {
                ToastUtils.showToast(this, getString(R.string.all_mail))
            }
            R.id.trash_menu -> {
                ToastUtils.showToast(this, getString(R.string.thrash))
            }
            R.id.spam_menu -> {
                ToastUtils.showToast(this, getString(R.string.spam))
            }

        }
        drawerLayout?.closeDrawers()
        return true
    }
    // endregion
}
