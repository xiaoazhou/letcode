package com.qizhou.thread;

/**
 * 测试ThreadService
 * 1.时间到了，打断
 * 2.执行结束，执行完成。
 */
public class ThreadCloseForce {

    public static void main(String[] args) {
        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();
        service.excute(() -> {
            try {
                Thread.sleep(5000);     //如果先执行结束，标志位改变，执行线程被打断
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.shutdown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}