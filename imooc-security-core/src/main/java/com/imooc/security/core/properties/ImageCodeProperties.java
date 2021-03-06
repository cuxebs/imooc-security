package com.imooc.security.core.properties;

/**
 * LN
 * 2019/10/10 0010 18:50
 */
public class ImageCodeProperties {
    //默认值
    private int width = 67;
    private int height = 23;
    private int length = 4;
    private int expireIn = 60;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }
}
