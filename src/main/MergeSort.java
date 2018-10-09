package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: david
 * @Date: 2018/10/8
 */

// 非递归自下而上实现
public class MergeSort {

    public static void mergeSort(List<Integer> array){
        int size = 1;
        int i, j;
        List<Integer> tmp = new ArrayList<>(Collections.nCopies(array.size(), 0));
        while(size < array.size()){
            int index = 0;
            while(index < array.size()){
                i = index;
                j = i + size;
                int point = i;
                while(true){
                    boolean goRight = j < index + size*2 && j < array.size();
                    boolean goLeft = i < index + size && i < array.size();
                    if (goLeft && (!goRight || array.get(i) < array.get(j))){
                        tmp.set(point++, array.get(i));
                        i++;
                    }else if (goRight) {
                        tmp.set(point++, array.get(j));
                        j++;
                    }else {
                        break;
                    }
                }
                index += size*2;
            }
            size *= 2;
            for (int k = 0; k < array.size(); k++){
                array.set(k, tmp.get(k));
            }
        }
    }

    public static void main(String[] args){
        List<Integer> array = Arrays.asList(5,1,7,3,4,6,8,2,3);
        mergeSort(array);
        System.out.println(array);
    }
}


//递归实现
class MergeSort递归实现{

    public static void merge(int[] array, int start, int end){
        int[] tmp = new int[end-start + 1];
        int mid = start + (end-start)/2;
        int i = start, j = mid + 1, point = 0;
        while(true){
            boolean left = i <= mid && i <= end;
            boolean right = j <= end;
            if (!right && left || (left && array[i] < array[j])){
                tmp[point++] = array[i++];
            }else if (right){
                tmp[point++] = array[j++];
            }else {
                break;
            }
        }
        for (int k = 0; k <= end-start; k++){
            array[start+k] = tmp[k];
        }
    }

    public static void sort(int[] array, int start, int end){
        if (start >= end){
            return;
        }
        int mid = start+(end-start)/2;
        sort(array, start, mid);
        sort(array, mid+1, end);
        merge(array, start, end);
    }

    public static void main(String[] args){
        int[] array = {5,1,7,3,4,6,8,2,3,0,9,8,7};
        sort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}