package com.bestboke.forkjoin;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class Test1 extends RecursiveTask<Integer> {
    //要插入的数据
    List<Integer> records;

    public Test1(List<Integer> records) {
        this.records = records;
    }

    @Override
    protected Integer compute() {
        //当要插入的数据少于3，则直接插入
        if (records.size() < 3) {
            return computeDirectly();
        } else {
            //如果要插入的数据大于等于3，则进行分组插入
            int size = records.size();

            //第一个分组
            Test1 aTask = new Test1(records.subList(0, size / 2));
            //第二个分组
            Test1 bTask = new Test1(records.subList(size / 2, records.size()));
            //两个任务并发执行起来
            invokeAll(aTask, bTask);
            //两个分组的插入的行数加起来
            return aTask.join() + bTask.join();
        }
    }

    /**
     * 真正插入数据的逻辑
     */
    private int computeDirectly() {
        try {
            Thread.sleep((long) (records.size() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("插入了：" + Arrays.toString(records.toArray()));
        return records.size();
    }

}