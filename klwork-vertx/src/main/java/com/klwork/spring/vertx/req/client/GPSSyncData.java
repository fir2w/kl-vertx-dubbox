package com.klwork.spring.vertx.req.client;

/**
 * Created by young on 15/11/27.
 */
public class GPSSyncData {
    //设备序列号 ，固定长度
    private String serialNumber;
    // 4 2 2
    private String yearMonthDate;
    // 2 2 2
    private String hourMinuteSecond;

    //经度，取值范围为（0～180*3600*100），转换公式为：longitude= 实际度*3600*100+实际分*60*100+实际秒*100
    private long longitude;
    // 0 ～ 东经；1 ～ 西经
    private int eastOrwest;
    // 纬度，取值范围为（0～90*3600*100），转换公式为：latitude = 实际度*3600*100+实际分*60*100+实际秒*100
    private long latitude;
    // 0 ～ 北纬；1 ～ 南纬
    private int northOrsouth;
    // 方向，取值范围为 [0, 359.9*100]，转换公式为：direction= 实际方向*100
    private long direction;
    private long speed;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getYearMonthDate() {
        return yearMonthDate;
    }

    public void setYearMonthDate(String yearMonthDate) {
        this.yearMonthDate = yearMonthDate;
    }

    public String getHourMinuteSecond() {
        return hourMinuteSecond;
    }

    public void setHourMinuteSecond(String hourMinuteSecond) {
        this.hourMinuteSecond = hourMinuteSecond;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public int getEastOrwest() {
        return eastOrwest;
    }

    public void setEastOrwest(int eastOrwest) {
        this.eastOrwest = eastOrwest;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public int getNorthOrsouth() {
        return northOrsouth;
    }

    public void setNorthOrsouth(int northOrsouth) {
        this.northOrsouth = northOrsouth;
    }

    public long getDirection() {
        return direction;
    }

    public void setDirection(long direction) {
        this.direction = direction;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }
}
