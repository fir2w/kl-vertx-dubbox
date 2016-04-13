package com.klwork.spring.vertx.resp.poi;

import java.util.Map;

/**
 * Created by young on 16/1/7.
 */
public class RoutePoiInfo {

    private RoutePoi from;
    private RoutePoi to;

    public RoutePoi getFrom() {
        return from;
    }

    public void setFrom(RoutePoi from) {
        this.from = from;
    }

    public RoutePoi getTo() {
        return to;
    }

    public void setTo(RoutePoi to) {
        this.to = to;
    }

    public static class RoutePoi {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            RoutePoi poiInfo = (RoutePoi) o;

            if (!longitude.equals(poiInfo.longitude)) return false;
            return latitude.equals(poiInfo.latitude);

        }

        @Override
        public int hashCode() {
            int result = longitude.hashCode();
            result = 31 * result + latitude.hashCode();
            return result;
        }

        /**
         * id
         */
        private String id;

        /**
         * 名字
         */
        private String name;

        /**
         * 详细地址
         */
        private String address;

        /**
         * 邮编
         */
        private String postCode;

        /**
         * 描述（如某酒店门口）
         */
        private String remark;

        /**
         * 经度
         */
        private String longitude;

        /**
         * 纬度
         */
        private String latitude;

        /**
         * 半径（单位:米）
         */
        private Integer radius;

        private String type;

        /**
         * 公司id
         */
        private String companyId;

        private String companyName;

        private String customerId;

        private String customerName;

        private String customerPhone;

        private String updateBy;

        private String updateTime;

        /**
         * 自定义属性
         */
        private Map<String, Object> extend;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public Integer getRadius() {
            return radius;
        }

        public void setRadius(Integer radius) {
            this.radius = radius;
        }

        public Map<String, Object> getExtend() {
            return extend;
        }

        public void setExtend(Map<String, Object> extend) {
            this.extend = extend;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
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

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCustomerPhone() {
            return customerPhone;
        }

        public void setCustomerPhone(String customerPhone) {
            this.customerPhone = customerPhone;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
