package com.yk.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.yk.navigation.SpaceItem;
import com.yk.navigation.SpaceNavigationView;
import com.yk.navigation.SpaceOnClickListener;

public class MainActivity extends AppCompatActivity {

    private SpaceNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = findViewById(R.id.navigation);
        initNavigationBar(savedInstanceState);
    }

    /**
     * 初始化自定义导航栏
     * https://github.com/BenShanYang/Space-Navigation-View
     *
     * @param savedInstanceState
     */
    private void initNavigationBar(Bundle savedInstanceState) {
        navigation.initWithSaveInstanceState(savedInstanceState);
        navigation.addSpaceItem(new SpaceItem("HOME", R.drawable.ic_home_normal));
        navigation.addSpaceItem(new SpaceItem("MY", R.drawable.ic_my_normal));
        navigation.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                showToast("点击了中间的按钮");
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                if (itemIndex == 0) {
                    showToast("点击了左边的按钮");
                } else if (itemIndex == 1) {
                    showToast("点击了右边的按钮");
                }
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {

            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        navigation.onSaveInstanceState(outState);
    }

    /**
     * 弹出提示
     *
     * @param message 提示的信息
     */
    private void showToast(CharSequence message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

}
