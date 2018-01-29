package com.zhg.views.stickytitlerecyclerview;

/**
 * Created by User on 2017/7/21.
 */

public class DetailBean {
    private boolean isTitle;
    private String name;
    private String tag=null;

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
