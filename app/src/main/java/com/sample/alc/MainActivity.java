package com.sample.alc;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.sample.alc.Mnt.Util;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // activity 전체 종료
        Util.removeActivityAll();
        // 메인 activity 추가
        Util.addActivity(this);
        //toolbar 설정
       Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        toolbar.setTitle("");
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.nav_weather_alc:
//                        Toast.makeText(getApplicationContext(),"qweqwe1",Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.nav_season_alc:
//                        Toast.makeText(getApplicationContext(),"qweqwe2",Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.nav_recommend_snack:
//                        Toast.makeText(getApplicationContext(),"qweqwe3",Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.nav_question:
//                        Toast.makeText(getApplicationContext(),"qweqwe4",Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.nav_recommend_alc:
//                        Toast.makeText(getApplicationContext(),"qweqwe5",Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.nav_event:
//                        Toast.makeText(getApplicationContext(),"qweqwe6",Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                drawer.closeDrawer(navigationView);
//                return false;
//            }
//        });
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_weather_alc,
                R.id.nav_season_alc,
                R.id.nav_recommend_snack,
                R.id.nav_question,
                R.id.nav_recommend_alc,
                R.id.nav_event)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);



//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                int id=menuItem.getItemId();
//                //it's possible to do more actions on several items, if there is a large amount of items I prefer switch(){case} instead of if()
//                if (id==R.id.nav_question){
//                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
//                }
//                //This is for maintaining the behavior of the Navigation view
//                NavigationUI.onNavDestinationSelected(menuItem,navController);
//                //This is for closing the drawer after acting on it
//                drawer.closeDrawer(GravityCompat.START);
//                return true;
//            }
//        });
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.nav_weather_alc:
//                        Toast.makeText(getApplicationContext(),"qweqwe",Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                return true;
//            }
//        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}