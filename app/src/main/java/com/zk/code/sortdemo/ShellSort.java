package com.zk.code.sortdemo;

/**
 * ========================================
 * Created by zhaokai on 2017/8/14.
 * Email zhaokai1033@126.com
 * des:
 * ========================================
 */

public class ShellSort extends ISort {

    @Override
    void startSort(ArrayModel arrayModel) {
        int[] data = arrayModel.getResultArray();
        int length = data.length;
        int gap, k;

        /**
         * 该循环决定步长，每次步长都缩小为原来的1/2，直至为1
         * 就类似于将整个数组按步长分为几个子数组，每个元素之间隔一个步长
         * 比如数组{2,5,9,6,3,4,7,1,5}，假设步长为4，那么得到子数组为
         * {2,3,5}，{5,4}，{9,7}，{6,1}
         */
        for (gap = data.length / 2; gap > 0; gap = gap / 2) {

            /**
             * 该循环每次循环就相当于遍历每个子数组，i=0时，遍历的第一个子数组为{2,3,5}
             *此后每次i++，都会向后遍历子数组{5,4}，{9,7}，{6,1}
             */
            for (int i = 0; i < data.length; i++) {
                //下面就相当于一个插入排序
                /**
                 * 以第一个子数组{2,3,5}为例，首先，j对应3的位置，表示准备要
                 * 插入的元素，每次循环都会自加一个步长，取得下一个元素（因为整体上
                 * 仍然是一个大的数组，只是逻辑上分为几个子数组）。
                 */
                for (int j = i + gap; j < data.length; j += gap) {
                    //判断准备插入的元素是否小于前一个元素
                    if (data[j] < data[j - gap]) {
                        int temp = data[j]; //保存待插入元素的值
                        //将大于待插入元素的值向后移
                        for (k = j - gap; k >= 0 && data[k] > temp; k = k - gap) {
//                            data[k+gap] = data[k];
                            swap(data, k + gap, k, arrayModel);
                        }
                        //前面k已经减去一个步长，这里要加回来
//                        data[k+gap] = temp;
                        break;
                    }
                }
            }
        }

        int step = length / 2;

        for (; step > 0; step = step / 2) {

        }

    }
}
