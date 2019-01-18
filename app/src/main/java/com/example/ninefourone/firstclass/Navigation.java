package com.example.ninefourone.firstclass;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ninefourone.firstclass.fragments.DashboardFragment;
import com.example.ninefourone.firstclass.fragments.HomeFragment;
import com.example.ninefourone.firstclass.fragments.NotificationsFragment;

import java.io.FileNotFoundException;

public class Navigation extends AppCompatActivity {

    private TextView mTextMessage;
    private DrawerLayout drawerLayout;
    private ImageView avatar;

    private DashboardFragment dashboardFragment = new DashboardFragment();
    private HomeFragment homeFragment;
    private NotificationsFragment notificationsFragment = new NotificationsFragment();


    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction transaction = fragmentManager.beginTransaction();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, homeFragment)
                            .commit();
                    return true;
                case R.id.navigation_dashboard:
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, dashboardFragment)
                            .commit();
                    return true;
                case R.id.navigation_notifications:
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, notificationsFragment)
                            .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mTextMessage = findViewById(R.id.message);
        drawerLayout = findViewById(R.id.drawer_layout);
        avatar = findViewById(R.id.avatar_image_view);
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlbum();
            }
        });

        homeFragment = new HomeFragment(drawerLayout);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        transaction.add(R.id.fragment_container, dashboardFragment);
        transaction.add(R.id.fragment_container, notificationsFragment);
        transaction.add(R.id.fragment_container, homeFragment);
        transaction.commit();
    }

    private void openAlbum() {
        if (ContextCompat.checkSelfPermission(Navigation.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    Navigation.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        } else {
            Intent intentToPickPic = new Intent(Intent.ACTION_PICK, null);
            // 如果限制上传到服务器的图片类型时可以直接写如："image/jpeg 、 image/png等的类型" 所有类型则写 "image/*"
            intentToPickPic.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/jpeg");
            startActivityForResult(intentToPickPic, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("TEST", resultCode + " " + requestCode);
        if (requestCode == 1) {
            Uri url = data.getData();
            Log.d("TEST","==1");
            if (url != null) {
                try {
                    Log.d("TEST", "ok" + url);
                    avatar.setImageBitmap(BitmapFactory.decodeStream(getContentResolver().openInputStream(url)));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                Log.d("TEST", "not ok" + url);
            }
        }
    }
}
