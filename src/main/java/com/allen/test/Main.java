package com.allen.test;

import java.util.*;

/**
 * @author Allen
 * @date 2021/6/15 19:04
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        Deque<Integer> queue = new ArrayDeque<>(n);
        for(int i=0;i<n;i++){
            int temp = sc.nextInt();
            array[i] = temp;
            queue.addLast(temp);
        }

        Arrays.sort(array);

        int count = 0;
        int i=0;

        while(queue.size()>1){
            if(array[i]!=queue.getFirst()){
                int t = queue.pollFirst();
                queue.addLast(t);
            }else{
                queue.pollFirst();
                i++;
            }
            count++;
        }
        count++;
        System.out.println(count);
    }
}
