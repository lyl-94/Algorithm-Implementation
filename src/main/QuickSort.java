package main;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: david
 * @Date: 2018/10/3
 */
public class QuickSort {

    public static int partition(List<Integer> array, int start, int end){
        int i = start, j = end;
        Integer target = array.get(end);
        while(i < j){
            while (i < j) {
                if (array.get(i) > target) {
                    array.set(j--, array.get(i));
                    break;
                }else {
                    i++;
                }
            }
            while (i < j) {
                if (array.get(j) < target) {
                    array.set(i++, array.get(j));
                    break;
                }else {
                    j--;
                }
            }
        }
        array.set(j, target);
        return j;
    }

    public static void sort(List<Integer> array, int start, int end){
        if (start >= end){
            return;
        }
        int middle = partition(array, start, end);
        sort(array, start, middle-1);
        sort(array, middle+1, end);
    }

    public static void main(String []args){
        List<Integer> array = Arrays.asList(3,7,9,5,4,5,1);
        sort(array, 0, array.size()-1);
        System.out.println(array);
    }
}

// 使用数组实现
class QuickSort数组实现{

    public static int partition(int[] array, int start, int end){
        int i = start, j = end, target = array[end];
        while(i < j){
            while(i < j){
                if (array[i] > target){
                    array[j--] = array[i];
                    break;
                }else {
                    i++;
                }
            }
            while(i<j){
                if (array[j] < target){
                    array[i++] = array[j];
                    break;
                }else {
                    j--;
                }
            }
        }
        array[j] = target;
        return j;
    }

    public static void sort(int[] array, int start, int end){
        if (start >= end){
            return ;
        }
        int middle = partition(array, start, end);
        sort(array, start, middle-1);
        sort(array, middle+1, end);
    }

    public static void main(String[] args){
        int[] array = {3,7,9,5,4,5,1};
        sort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
