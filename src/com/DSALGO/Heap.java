package com.DSALGO;
import java.util.ArrayList;

public class Heap {
//    Heap Data Structure
    void heapify(ArrayList<Integer> h, int i) {
        int larg = i;
        int size = h.size();
        int left = 2*i+1;
        int right = 2*i+2;

        if(left < size && h.get(left) > h.get(larg)){
            larg = left;
        }

        if(right < size && h.get(right) > h.get(larg)) {
            larg = right;
        }

        if(larg != i) {
            int temp = h.get(larg);
            h.set(larg,h.get(i));
            h.set(i,temp);

            heapify(h,larg);
        }
    }

    void insert(ArrayList<Integer> h, int data) {
        int size = h.size();
        if(size == 0) {
            h.add(data);
        }
        else {
            h.add(data);
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapify(h, i);
            }
        }
    }
    void print(ArrayList<Integer > h, int size){
        for (int i = 0; i < h.size(); i++){
            System.out.print(h.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int arr[] = {3,5,6,1,9,2};
        ArrayList<Integer> arr = new ArrayList<>();
        Heap h = new Heap();
        h.insert(arr,3);
        h.insert(arr,6);
        h.insert(arr,9);
        h.insert(arr,5);
        h.insert(arr,1);
        h.insert(arr,11);
        h.insert(arr,7);





        h.print(arr,arr.size());
    }
}
