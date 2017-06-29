package neacy.upmarqueer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import neacy.library.UpMarqueeLayout;

public class MainActivity extends AppCompatActivity {

    private UpMarqueeLayout mMarqueeLayout;

    private String[] names = {"我的地盘.蒲公英的约定.给我一首歌的时间.说好的幸福呢.......", "我的地盘", "蒲公英的约定", "给我一首歌的时间", "说好的幸福呢"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMarqueeLayout = (UpMarqueeLayout) findViewById(R.id.marquee_layout_id);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMarqueeLayout.setTextArray(names);
            }
        });
    }


}
