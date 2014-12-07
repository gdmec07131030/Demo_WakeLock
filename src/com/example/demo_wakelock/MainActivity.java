package com.example.demo_wakelock;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {
    PowerManager manager;
    WakeLock lock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager=(PowerManager) getSystemService(Context.POWER_SERVICE);
        lock=manager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "lock");
    }

    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	if(lock!=null){
    		lock.acquire();
    	}
    }
    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	if(lock!=null&&lock.isHeld()){
    		lock.release();
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
