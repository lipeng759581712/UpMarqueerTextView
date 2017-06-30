package neacy.library;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;



/*
写这个的主要目的是：
1、把布局文件封装起来、外面直接这样引用就可以了
<neacy.library.UpMarqueeLayout
    android:id="@+id/marquee_layout_id"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
</neacy.library.UpMarqueeLayout>

2、把定时滚动任务封装在这个类，就不用在外面去写了，保持代码整洁、外层调用也方便
*/


/**
 * Created by maxpengli on 2017/6/29.
 */

public class UpMarqueeLayout extends FrameLayout{


    private final int MESSAGE_TYPE_TEXT_ARRAY = 0;
    private final int MESSAGE_TYPE_TEXT_LIST  = 1;

    private UpMarqueeTextView mMarqueeTextView;

    private String[] textArray;
    private List<String> textList;

    private Timer timer;
    private TimerTask task;
    private int index;

    private OnClickListener listener = null;

    public interface OnClickListener{
        void onClick();
    }

    public void setOnClickListener(OnClickListener listener){
        this.listener = listener;
    }

    private void notifyOnClick(){
        if (listener != null){
            listener.onClick();
        }
    }


    private Handler MyHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case MESSAGE_TYPE_TEXT_ARRAY:
                    handlerArray();
                    break;
                case MESSAGE_TYPE_TEXT_LIST:
                    handerList();
                    break;
            }


        }
    };
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
        mMarqueeTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                notifyOnClick();
            }
        });
    }


    /**
     * 传入单个字符串数据
     * @param string
     */
    public void setText(String string){
        closeTimer();//先关掉以前的定时器
        mMarqueeTextView.setText(string);
    }

    /**
     * 传入字符串list
     */
    public void setTextList(List<String> list){
        this.textList = list;
        index = 0;
        closeTimer();//先关掉以前的定时器
        timeTask(MESSAGE_TYPE_TEXT_LIST);

    }

    /**
     * 传入字符串数组
     * @param array
     */
    public void setTextArray(String[] array){
        this.textArray = array;
        index = 0;
        closeTimer();//先关掉以前的定时器
        timeTask(MESSAGE_TYPE_TEXT_ARRAY);

    }

    private void timeTask(final int what) {
        task = new TimerTask() {
            @Override
            public void run() {

                MyHandler.sendEmptyMessage(what);
            }
        };

        timer = new Timer();
        // 参数：
        // 0，延时0秒后执行。
        // 1000，每隔2秒执行1次task。
        timer.schedule(task, 0, 2000);
    }


    /**
     * 关闭定时任务
     */
    private void closeTimer(){
        if (timer != null){
            timer.cancel();
            timer = null;
        }
        if(task != null){
            task.cancel();
            task = null;
        }
    }

    private void handlerArray(){
        if (index > textArray.length-1) {
            index = 0;
        }
        mMarqueeTextView.setText(textArray[index]);
        index++;
    }

    private void handerList(){
        if (index > textList.size()-1) {
            index = 0;
        }
        mMarqueeTextView.setText(textList.get(index));
        index++;
    }




}
