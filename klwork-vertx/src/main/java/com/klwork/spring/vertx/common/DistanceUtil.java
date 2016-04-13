package com.klwork.spring.vertx.common;

/**
 * DistanceUtil
 *
 * @author Young
 * @date 2015/11/21 0021
 */
public class DistanceUtil {
    public static double getDistance(double long1, double lat1, double long2,
                                     double lat2) {
        double a, b, R;
        R = 6378137;
        lat1 = lat1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        a = lat1 - lat2;
        b = (long1 - long2) * Math.PI / 180.0;
        double d;
        double sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2
                * R
                * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)
                * Math.cos(lat2) * sb2 * sb2));
        return d;
    }

    public static double getDistanceFromStr(String long1, String lat1, String long2,
                                            String lat2) {
        return getDistance(Double.valueOf(long1), Double.valueOf(lat1), Double.valueOf(long2), Double.valueOf(lat2));
    }

    public static boolean checkRange(String long1, String lat1, String long2,
                                     String lat2, int radius) {
        return getDistance(Double.valueOf(long1), Double.valueOf(lat1), Double.valueOf(long2), Double.valueOf(lat2)) < radius ? true : false;

    }
}
