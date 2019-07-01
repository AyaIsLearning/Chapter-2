package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 *
 * 解答
 * 设计的界面为一个线性布局，内部第一层为一个TextView 其下为一个有5个item的ListView
 *
 * 最终能在嘴上端的TextView中显示出 7 个
 *
 */
public class Exercises2 extends AppCompatActivity {


    private String[] city = {"Beijing", "Nanjing", "Shanghai", "Chengdu", "Tianjin"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Exercises2.this, android.R.layout.simple_list_item_1, city);

        final ListView list = findViewById(R.id.TestList);
        list.setAdapter(adapter);

        list.post(new Runnable(){
            public void run(){
                // fileList为与adapter做连结的list总数
                if (list.getChildCount()!=0){
                    //对ListView中的ChildView进行操作。。。
                    View current_view = getWindow().getDecorView().findViewById(R.id.root);
                    int viewCount=getViewCount(current_view);

                    TextView text=findViewById(R.id.TotalViewNum);
                    text.setText("共有"+viewCount+"个view");
                    Toast.makeText(Exercises2.this,"共有"+viewCount,Toast.LENGTH_LONG).show();
                }

            }

        });




        /*
        setContentView(R.layout.im_list_item);
        View current_view = getWindow().getDecorView().findViewById(R.id.root2);
        int viewCount=getViewCount(current_view);
        Toast.makeText(Exercises2.this,"共有"+viewCount,Toast.LENGTH_LONG).show();
         */
        //System.out.println(viewCount);

    }

    public static int getViewCount(View view) {
        //todo 补全你的代码
        int viewCount = 0;
        if (view == null) {
            return 0;
        }
        if (view instanceof ViewGroup) {
            viewCount++;

            System.out.println(((ViewGroup) view).getChildCount());

            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View temp_view = ((ViewGroup) view).getChildAt(i);

                if (temp_view instanceof ViewGroup) {
                    viewCount += getViewCount(temp_view);
                }
                else {
                    viewCount++;
                }
            }
        }
        return viewCount;
    }
}
