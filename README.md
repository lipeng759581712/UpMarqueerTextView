# UpMarqueerTextView
向上跑马灯效果

公司项目中的界面有一处 需要显示广告连接且可上下滚动，恰好在淘宝app上面见识到这个效果就模仿实现了。

![图片效果](https://github.com/lipeng759581712/UpMarqueerTextView/blob/master/screenshot/UpMarqueeTextView.gif)


## 使用说明：
```xml
<neacy.library.UpMarqueeLayout
        android:id="@+id/marquee_layout_id"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
</neacy.library.UpMarqueeLayout>
```

```java
UpMarqueeLayout mMarqueeLayout = (UpMarqueeLayout) findViewById(R.id.marquee_layout_id);

//添加点击监听
mMarqueeLayout.setOnClickListener(new UpMarqueeLayout.OnClickListener() {
    @Override
    public void onClick() {
        Toast.makeText(MainActivity.this,"跳转到评论详情页面",Toast.LENGTH_SHORT).show();
    }
});
```


支持两种类型的数据传入：

```java
1、传入字符串数组
private String[] names = {"我的地盘.蒲公英的约定.给我一首歌的时间.说好的幸福呢.......", "我的地盘", "蒲公英的约定", "给我一首歌的时间", "说好的幸福呢"};
mMarqueeLayout.setTextArray(names);
```

```java
2、字符串集合
private List<String> list = new ArrayList<String>();
list.add("来看电视剧啊了聚少离多");
list.add("儿童各个价位个我普陀区");
list.add("eltk为了天空个任务群公告");
list.add("各个确认个人回去二乎乎");
mMarqueeLayout.setTextList(list);
```

```java
3、传入单个字符串（这个时候是没有定时任务的）
mMarqueeLayout.setText("骷髅精灵框架类");
```
