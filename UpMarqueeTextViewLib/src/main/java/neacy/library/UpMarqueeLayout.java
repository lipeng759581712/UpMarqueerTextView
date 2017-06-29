package neacy.library;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by maxpengli on 2017/6/29.
 */

public class UpMarqueeLayout extends FrameLayout{

    private UpMarqueeTextView mMarqueeTextView;

    private String[] textArray;
    private List<String> textList;

    private Timer timer;
    private TimerTask task;
    private int index;



    private Handler MyHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (index > textArray.length-1) {
                index = 0;
            }
            mMarqueeTextView.setText(textArray[index]);
            index++;
        }
    };



    public void setTextList(List<String> list){
        this.textList = list;

    }

    public void setTextArray(String[] array){
        this.textArray = array;
        index = 0;

        task = new TimerTask() {
            @Override
            public void run() {

                MyHandler.sendEmptyMessage(0);
            }
        };

        timer = new Timer();
        // 参数：
        // 0，延时0秒后执行。
        // 1000，每隔2秒执行1次task。
        timer.schedule(task, 0, 2000);




    }

    /**
     * new 的时候调用
     * @param context
     */
    public UpMarqueeLayout(Context context) {
        super(context);
        init(context);
    }

    /**
     * 在xml中实例化的时候调用
     * @param context
     * @param attrs
     */
    public UpMarqueeLayout(Context context,AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * 有自定义属性的时候调用
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public UpMarqueeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.up_marquee_layout, this);
        mMarqueeTextView = (UpMarqueeTextView) findViewById(R.id.marquee);
    }


}
