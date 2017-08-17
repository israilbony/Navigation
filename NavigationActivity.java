package com.israilbony.fragmentactivity;


import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class NavigationActivity extends Activity implements ActionBar.TabListener {
    private ViewPager viewPager;

    private TabsAdapter tabsAdapter;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        /*The ViewPager is the widget that allows the user to swipe left or right to see an entirely new screen.*/
        viewPager = (ViewPager) findViewById(R.id.pager);
       actionBar = getActionBar();
       tabsAdapter = new TabsAdapter(getFragmentManager());
        viewPager.setAdapter(tabsAdapter);
       actionBar.setHomeButtonEnabled(false);
        //actionBar.setHomeButtonEnabled(true) will just make the icon clickable
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (String tabName : TabsAdapter.getTabNames())
        {
            ActionBar.Tab aTab = actionBar.newTab().setText(tabName).setTabListener(this);
            actionBar.addTab(aTab);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())

        {
                 case R.id.action_settings :
                Toast.makeText(this,"Select Detting",Toast.LENGTH_LONG).show();
                     return  true;
            case R.id.action_rateUp :
                Toast.makeText(this,"Rate up",Toast.LENGTH_LONG).show();
                return  true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
