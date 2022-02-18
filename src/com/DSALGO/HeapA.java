package com.DSALGO;

import java.util.ArrayList;

public class HeapA {
//    ===> MaxHeap
//    Heap property checker function
    void maxHeapProp(ArrayList<Integer> h, int i) {
        int size = h.size();
        int currNode = i;
        int leftChilde = 2*i+1;
        int rightChild = 2*i+2;

        if(leftChilde < size && h.get(leftChilde) > h.get(currNode)) currNode = leftChilde;
        if(rightChild < size && h.get(rightChild) > h.get(currNode)) currNode = rightChild;

        if(currNode != i) {
            int temp = h.get(currNode);
            h.set(currNode, h.get(i));
            h.set(i, temp);

            maxHeapProp(h,currNode);
        }

    }
//    insert function
    void insert(ArrayList<Integer> h, int data) {
        int size = h.size();
        if(size == 0) {
            h.add(data);
        }
        else {
            h.add(data);
            for(int i = size/2-1; i >= 0; i--) {
                maxHeapProp(h,i);
            }
        }
    }

//    delete function
    void deleteNode(ArrayList<Integer> h, int data) {
        int size = h.size();
        int i;
        for(i = 0; i < size; i++) {
            if(data == h.get(i)){
                break;
            }
        }
        int temp = h.get(i);
        h.set(i, h.get(size-1));
        h.set(size-1,temp);
        h.remove(size-1);
        for(int j = size/2-1; j >= 0; j--) {
            maxHeapProp(h,j);
        }
    }
//    print fucntion
      void printHeap(ArrayList<Integer> h){
            int size = h.size();
            for(int i = 0; i < size; i++) {
            System.out.print(h.get(i) + "->");
            }
            System.out.print("END");
     }
    public static void main(String[] args) {
       ArrayList<Integer> arr = new ArrayList<>();
       HeapA ha = new HeapA();
       ha.insert(arr,6);
       ha.insert(arr,1);
       ha.insert(arr,7);
       ha.insert(arr,9);
       ha.insert(arr,3);
       ha.insert(arr,5);
       ha.insert(arr,4);

        System.out.println("ALL NODES");
        ha.printHeap(arr);
        System.out.println("AFTER DELETE");
        ha.deleteNode(arr,6);
        ha.printHeap(arr);
    }
}
