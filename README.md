# UpMarqueerTextView
向上跑马灯效果

公司项目中的界面有一处 需要显示广告连接且可上下滚动，恰好在淘宝app上面见识到这个效果就模仿实现了。

![图片效果](https://github.com/lipeng759581712/UpMarqueerTextView/blob/master/screenshot/UpMarqueeTextView.gif "demo")

使用方法：
在xml布局中
...
<neacy.library.UpMarqueeLayout
        android:id="@+id/marquee_layout_id"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
</neacy.library.UpMarqueeLayout>
...

...
UpMarqueeLayout mMarqueeLayout = (UpMarqueeLayout) findViewById(R.id.marquee_layout_id);


private String[] names = {"我的地盘.蒲公英的约定.给我一首歌的时间.说好的幸福呢.......", "我的地盘", "蒲公英的约定", "给我一首歌的时间", "说好的幸福呢"};
mMarqueeLayout.setTextArray(names);
...
