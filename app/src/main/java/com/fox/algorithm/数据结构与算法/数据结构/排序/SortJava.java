package com.fox.algorithm.数据结构与算法.数据结构.排序;

/**
 * Created by fox.hu on 2018/11/28.
 */

public class SortJava {

    public static void selectionSort(Comparable[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (less(input[j], input[i])) {
                    swap(input, i, j);
                }
            }
        }
    }

    public static void insertSort(Comparable[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(input[j], input[j - 1])) {
                    swap(input, j, j - 1);
                }
            }
        }
    }

    public static void shellSort(Comparable[] input) {
        int h = 1;
        while (h < input.length / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < input.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(input[j], input[j - h])) {
                        swap(input, j, j - h);
                    }
                }
            }
            h = h / 3;
        }
    }

    //线性复杂度实现的随机打乱 洗牌功能
    public static void shuffle(Object[] input) {
        for (int i = 0; i < input.length; i++) {
            int r = (int) (Math.random() * (i + 1));
            swap(input, i, r);
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void swap(Object[] a, int i, int j) {
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Created by fox.hu on 2018/12/20.
     */

    public static class QuickSort {
        public static void sort(Comparable[] a) {
            shuffle(a);
            sort(a, 0, a.length - 1);
        }

        public static void sort(Comparable[] a, int lo, int hi) {
            if (hi <= lo) {
                return;
            }
            //1 寻找切分点 切分点的要点在于 在切分点的左侧 都比它小 在切分点的右侧 都比它大
            //2 递归的进行
            int partition = partition(a, lo, hi);
            sort(a, lo, partition - 1);
            sort(a, partition + 1, hi);
        }

        public static int partition(Comparable[] a, int lo, int hi) {
            int i = lo;
            int j = hi + 1;
            while (true) {
                //只为了移动小端的指针
                while (less(a[++i], a[lo])) {
                    if (i >= hi) {
                        break;
                    }
                }
                //只为了移动大端的指针
                while (less(a[lo], a[--j])) {
                    if (j <= lo) {
                        break;
                    }
                }
                if (i >= j) {
                    break;
                }
                swap(a, i, j);
            }
            swap(a, lo, j);
            //交换lo j的位置后，在j的左侧都是比j小的 在j的右侧都是比j大的
            return j;
        }
    }

    /**
     * Created by fox.hu on 2018/12/17.
     */

    public static class MergeSort {
        private static Comparable[] axu;

        public static void sort(Comparable[] a) {
            axu = new Comparable[a.length];
            sort(a, 0, a.length - 1);
        }

        private static void sort(Comparable[] a, int lo, int hi) {
            if (hi <= lo) {
                return;
            }
            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }

        private static void merge(Comparable[] a, int lo, int mid, int hi) {
            //lo = 0; mid = 0; hi =1 ; i = 0;j =1;k=1
            int i = lo, j = mid + 1;

            for (int k = lo; k <= hi; k++) {
                axu[k] = a[k];
            }

            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    a[k] = axu[j++];
                } else if (j > hi) {
                    a[k] = axu[i++];
                } else if (less(axu[j], axu[i])) {
                    a[k] = axu[j++];
                } else {
                    a[k] = axu[i++];
                }
            }
        }
    }
}
