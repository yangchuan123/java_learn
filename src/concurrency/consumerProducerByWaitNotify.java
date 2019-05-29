package concurrency;

import java.util.PriorityQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Copyright(C) 2014-2018 Tianheng Tech Co.ltd Rights Reserved.
 * FileName:
 * Description:
 * 使用Object的wait()和notify()实现生产者-消费者模型
 * History:
 * 版本号      作者        日期        备注
 * 1.0         chuan.yang    2019/5/29
 **/

public class consumerProducerByWaitNotify {
//    private int queueSize = 10;
//    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);
//    public static void main(String[] args){
//        consumerProducerByWaitNotify test = new consumerProducerByWaitNotify();
//        Consume consume = test.new Consume();
//        Produce produce = test.new Produce();
//        consume.start();
//        produce.start();
//    }
//
//    class Consume extends Thread{
//        @Override
//        public void run(){
//            consume();
//        }
//
//        private void consume(){
//            while (true){
//                synchronized (queue){
//                    while (queue.size() == 0){
//                        try {
//                            queue.wait();
//                        }
//                        catch (InterruptedException ex){
//                            queue.notify();
//                        }
//                    }
//                    queue.poll();
//                    queue.notify();
//                }
//            }
//        }
//    }
//
//    class Produce extends Thread{
//        @Override
//        public void run(){
//            produce();
//        }
//
//        private void produce(){
//            while (true){
//                synchronized (queue){
//                    while (queue.size() == queueSize){
//                        try {
//                            queue.wait();
//                        }
//                        catch (InterruptedException ex){
//                            queue.notify();
//                        }
//                    }
//                    queue.offer(1);
//                    queue.notify();
//                }
//            }
//        }
//    }


    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);

    public static void main(String[] args)  {
        consumerProducerByWaitNotify test = new consumerProducerByWaitNotify();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();

        producer.start();
        consumer.start();
    }

    class Consumer extends Thread{

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while(true){
                synchronized (queue) {
                    while(queue.size() == 0){
                        try {
                            System.out.println("队列空，等待数据");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.poll();          //每次移走队首元素
                    queue.notify();
                    System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");
                }
            }
        }
    }

    class Producer extends Thread{

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while(true){
                synchronized (queue) {
                    while(queue.size() == queueSize){
                        try {
                            System.out.println("队列满，等待有空余空间");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.offer(1);        //每次插入一个元素
                    queue.notify();
                    System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
                }
            }
        }
    }
}
