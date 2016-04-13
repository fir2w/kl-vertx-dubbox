package com.klwork.spring.vertx.resp.poi;


import com.klwork.spring.vertx.resp.BaseResp;

import java.util.List;

/**
 * Created by young on 15/11/18.
 */
public class GetRouteList4JobResp extends BaseResp {

    /**
     * 总数
     */
    private Integer total;

    /**
     * 当页数据
     */
    private List<Route4JobInfo> dataList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Route4JobInfo> getDataList() {
        return dataList;
    }

    public void setDataList(List<Route4JobInfo> dataList) {
        this.dataList = dataList;
    }

    public static class Route4JobInfo {

        private String departureTime;
        /**
         * 经度
         */
        private String longitude;

        /**
         * 纬度
         */
        private String latitude;
        /**
         * 司机ID
         */
        private Integer driverId;

        /**
         * 司机姓名
         */
        private String driverName;

        private String driverPhone;
        /**
         * 路线ID
         */
        private Integer routeId;
        private String routeRemark;
        /**
         * 车辆ID
         */
        private String vehicleId;

        /**
         * 车牌号
         */
        private String plateNo;

        private String direction;

        private String speed;

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public void setDepartureTime(String departureTime) {
            this.departureTime = departureTime;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Integer getDriverId() {
            return driverId;
        }

        public void setDriverId(Integer driverId) {
            this.driverId = driverId;
        }

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public String getDriverPhone() {
            return driverPhone;
        }

        public void setDriverPhone(String driverPhone) {
            this.driverPhone = driverPhone;
        }

        public Integer getRouteId() {
            return routeId;
        }

        public void setRouteId(Integer routeId) {
            this.routeId = routeId;
        }

        public String getRouteRemark() {
            return routeRemark;
        }

        public void setRouteRemark(String routeRemark) {
            this.routeRemark = routeRemark;
        }

        public String getVehicleId() {
            return vehicleId;
        }

        public void setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
        }

        public String getPlateNo() {
            return plateNo;
        }

        public void setPlateNo(String plateNo) {
            this.plateNo = plateNo;
        }
    }
}
