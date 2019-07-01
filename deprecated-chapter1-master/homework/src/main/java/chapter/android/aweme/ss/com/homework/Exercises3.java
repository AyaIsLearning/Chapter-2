package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */

public class Exercises3 extends AppCompatActivity implements View.OnClickListener {
    List<Message> list;
    RecyclerView recyclerView;
    NormalAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tiktok);
        try {
            list = PullParser.getMessage(Exercises3.this);

            recyclerView=findViewById(R.id.rv_list);
            adapter=new NormalAdapter(list);


            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
            System.out.println(list);
        }catch (Exception e){
            System.out.println("Something is wrong when load data !");
        }

        findViewById(R.id.number1).setOnClickListener(this);
        findViewById(R.id.number2).setOnClickListener(this);
        findViewById(R.id.number3).setOnClickListener(this);
        findViewById(R.id.number4).setOnClickListener(this);

        adapter.setOnItemClickListener(new NormalAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent new_intent=new Intent(Exercises3.this, MessagePage.class);
                new_intent.putExtra("title",list.get(position).getTitle());
                new_intent.putExtra("message",list.get(position).getDescription());
                startActivity(new_intent);
            }

        });
    }

    @Override
    public void onClick(View v) {
        Intent new_intent=new Intent(this, NewPage.class);
        switch (v.getId()) {
            case R.id.number1:
                new_intent.putExtra("data", "这是第1个");
                startActivity(new_intent);
                break;
            case R.id.number2:
                new_intent.putExtra("data", "这是第2个");
                startActivity(new_intent);
                break;
            case R.id.number3:
                new_intent.putExtra("data", "这是第3个");
                startActivity(new_intent);
                break;
            case R.id.number4:
                new_intent.putExtra("data", "这是第4个");
                startActivity(new_intent);
                break;
        }
    }


}
