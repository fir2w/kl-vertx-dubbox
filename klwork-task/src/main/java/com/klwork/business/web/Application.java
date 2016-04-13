package com.klwork.business.web;

/**
 * Created by ww on 16/4/11.
 */
public class Application {

    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(20000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                ProtocolConfig.destroyAll();
//            }
//        }).start();
        com.alibaba.dubbo.container.Main.main(args);
    }
}
