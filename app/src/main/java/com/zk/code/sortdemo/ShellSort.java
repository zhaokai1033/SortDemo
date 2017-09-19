package com.zk.code.sortdemo;

/**
 * ========================================
 * Created by zhaokai on 2017/8/14.
 * Email zhaokai1033@126.com
 * des:
 * ========================================
 */

public class ShellSort extends ISort {

    //    直接实现
    @Override
    void startSort(ArrayModel arrayModel) {
        int[] data = arrayModel.getResultArray();
        int length = data.length;
        int step = length / 2, k;
        //以步长分组 循环直到步长为1
        for (; step > 0; step = step / 2) {
            // 遍历所有组 ，等步长的组内 进行元素的插入排序
            for (int i = 0; i < step; i++) {

                //插入排序
                for (int j = i + step; j < length; j += step) {
                    //如果当前数值大于于当前组的上一个数据
                    if (data[j - step] > data[j]) {
                        k = j - step;
                        int temp = data[j];
                        while (k >= 0 && data[k] > temp) {
                            //交换 小数往前
                            data[k + step] = data[k];
                            k -= step;
                            swap(data, 0, 0, arrayModel);
                        }
                        //k<0 或者 data[k]>temp;
                        data[k + step] = temp;
                        swap(data, 0, 0, arrayModel);
                    }
                }
            }
        }
    }
//    @Override
//    void startSort(ArrayModel arrayModel) {
//        int[] data = arrayModel.getResultArray();
//        int length = data.length;
//        int step = length / 2, j;
//        //以步长分组 循环直到步长为1
//        for (; step > 0; step = step / 2) {
//            // 遍历所有组 ，等步长的组内 进行元素的插入排序
//            for (int i = step; i < length; i++) {
//                for (j = i - step; j >= 0 && data[j] > data[j + step]; j -= step) {
//                    swap(data, j, j + step, arrayModel);
//                }
//            }
//        }
//    }
}
