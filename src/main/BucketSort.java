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
public class BucketSort {

    public static void bucketSort(List<Integer> array){
        Integer max = Collections.max(array);
        List<Integer> bucket = new ArrayList<>(Collections.nCopies(max+1,0));
        for (int i = 0; i < array.size(); i++){
            bucket.set(array.get(i), bucket.get(array.get(i))+1);
        }
        for (int i = 0, j = 0; i < bucket.size(); i++){
            if (bucket.get(i) != 0){
                int count = bucket.get(i);
                while(count-- > 0) {
                    array.set(j++, i);
                }
            }
        }
    }

    public static void main(String[] args){
        List<Integer> array = Arrays.asList(5,1,7,3,4,6,8,2,3);
        bucketSort(array);
        System.out.println(array);
    }
}
