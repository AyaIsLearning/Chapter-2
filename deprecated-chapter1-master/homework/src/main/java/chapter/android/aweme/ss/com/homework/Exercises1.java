package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * 作业1：
 * 打印出Activity屏幕切换 Activity会执行什么生命周期？
 */
public class Exercises1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(Exercises1.this,"创建了exercises1",Toast.LENGTH_LONG).show();
        System.out.println("创建了exercises1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(Exercises1.this,"摧毁了exercises1",Toast.LENGTH_LONG).show();
        System.out.println("摧毁了exercises1");
    }

}
