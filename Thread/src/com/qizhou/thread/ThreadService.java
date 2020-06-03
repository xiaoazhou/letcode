package com.qizhou.thread;

import javafx.concurrent.Task;

/**
 * 题目：java高并发与多线程网络编程
 * 内容：p17暴力结束线程
 * 通过守护线程结束线程
 * 2020年4月18日14:19:49
 */
public class ThreadService {
    private Thread excuteThread;//执行线程

    private boolean finished = false; //执行结束标志位

    public void excute(Runnable task){
        excuteThread = new Thread(){
            @Override
            public void run() {
                Thread runner = new Thread(task); //真正的任务线程
                runner.setDaemon(true);            //设置为守护线程
                runner.start();

                try {
                    runner.join();
                    finished = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        excuteThread.start();
    }

    public void shutdown(long mills){
        long currentTime = System.currentTimeMillis();
        while(!finished){
            if (System.currentTimeMillis()-currentTime>=mills){
                System.out.println("任务超时，需要结束");
                excuteThread.interrupt();
                break;
            }

            try {
                excuteThread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断！");
                break;
            }
        }
        finished = false;
    }
}
