package neacy.upmarqueer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import neacy.library.UpMarqueeLayout;

public class MainActivity extends AppCompatActivity {

    private UpMarqueeLayout mMarqueeLayout;

    private String[] names = {"我的地盘.蒲公英的约定.给我一首歌的时间.说好的幸福呢.......", "我的地盘", "蒲公英的约定", "给我一首歌的时间", "说好的幸福呢"};

    private List<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMarqueeLayout = (UpMarqueeLayout) findViewById(R.id.marquee_layout_id);


        list.add("来看电视剧啊了聚少离多");
        list.add("儿童各个价位个我普陀区");
        list.add("eltk为了天空个任务群公告");
        list.add("各个确认个人回去二乎乎");

        mMarqueeLayout.setTextArray(names);
//        mMarqueeLayout.setTextList(list);


        mMarqueeLayout.setOnClickListener(new UpMarqueeLayout.OnClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this,"跳转到评论详情页面",Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMarqueeLayout.setText("暂停");
            }
        });
    }


}
