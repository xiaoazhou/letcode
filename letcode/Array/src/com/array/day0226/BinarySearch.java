package com.array.day0226;

public class BinarySearch<T extends Comparable> {
    int search(T arr[],int n,T target){
        int l = 0;
        int r = n-1;                  //在[l.....r]的区间中寻找target
        while(l <= r){                //当l==r时，区间[l....r]仍然是有效的
            //int mid = (l+r)/2;        //使用加法会有bug，因为两个int相加可能越界
            int mid = l + (r-l)/2;
            if (arr[mid].compareTo(target) == 0){
               return mid;
           }else if (arr[mid].compareTo(target) < 0){
               l = mid + 1;             //target在[mid+1.....r]中
           }else
               r = mid - 1;             //target在[l.....mid-1]中
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer [] arrr = new Integer[1000000];
        for (int i = 0; i < 1000000; i++) {
            arrr[i] = i;
        }
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arrr.length; i++) {
            binarySearch.search(arrr,arrr.length,i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间

    }
}
