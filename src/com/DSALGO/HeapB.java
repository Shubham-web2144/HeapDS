package com.DSALGO;
import java.util.ArrayList;

public class HeapB {
// ===> MinHeap
//    Let's create heap property checker function
    void minHeap(ArrayList<Integer> h, int i) {
        int size = h.size(); //size of an arrayList
        int currentNode = i; // current node or value
        int leftChild = 2*i+1; // find left side child of root or parent element
        int rightChild = 2*i+2; // \finding right side childe of root or parent element

        if(rightChild < size && h.get(rightChild) < h.get(currentNode)) { // first condition check's rightChild
            // element's
            // index is less than array size and second condition check's the value of rightChild is smaller than
            // current value if its true
            currentNode = rightChild; // replace rightChild value to currentNode
        }

        if(leftChild < size && h.get(leftChild) < h.get(currentNode)) {
            currentNode = leftChild;
        }

        if(currentNode != i) { // this condition checks currentNode value not equla to i
//            swap following vaiables values
            int temp = h.get(currentNode); // storing in temp vaiable
            h.set(currentNode, h.get(i));
            h.set(i, temp);

            minHeap(h,currentNode); // recursive call for other nodes
        }
    }
//    Insert function
      void insertNode(ArrayList<Integer> h, int data){
        int size = h.size();
        if(size == 0) {
            h.add(data);
        }
        else {
            h.add(data);
            for(int i = size/2-1; i >= 0; i--) { // for heap property
                minHeap(h,i);
            }
        }
    }

//    Delete function
    void deleteNode(ArrayList<Integer> h, int data) {
        int size = h.size();
        int i;
        for(i = 0; i < size; i++){
            if(data == h.get(i)) {
                break;
            }
        }

        int temp = h.get(i);
        h.set(i, h.get(size-1));
        h.set(size-1,temp);

        for(int j = size/2-1; j >= 0; j--){
            minHeap(h,j);
        }
    }
//    Print function
    void printHeap(ArrayList<Integer> h){
        int size = h.size();
        for(int i = 0; i < size; i++) {
            System.out.print(h.get(i) + "->");
        }
        System.out.print("END");
    }


    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        HeapB hb = new HeapB();
        hb.insertNode(arr,6);
        hb.insertNode(arr,1);
        hb.insertNode(arr,7);
        hb.insertNode(arr,3);
        hb.insertNode(arr,5);

        hb.printHeap(arr);

        System.out.println("AFTER DELETE");
        hb.deleteNode(arr,7);
        hb.printHeap(arr);



    }

}
