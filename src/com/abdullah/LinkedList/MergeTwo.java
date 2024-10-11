package com.abdullah.LinkedList;

public class MergeTwo {
    LL ll1 = new LL();
    LL ll2 = new LL();
    int[] list1 = {2, 5, 9, 14, 15, 7, 20, 17, 30};
    int[] list2 = {14, 2, 9, 13, 37, 8, 7, 28};

    public MergeTwo(){
        for (int j : list1) {
            ll1.insertLast(j);
        }

        for (int j : list2) {
            ll2.insertLast(j);
        }
    }
    public LL commonElement() {
        LL result = new LL();
        LL.Node temp1 = ll1.head;
        while (temp1 != null) {
            LL.Node temp2 = ll2.head;
            while (temp2 != null) {
                if(temp1.data == temp2.data) {
                    result.insertLast(temp1.data);
                    break;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return result;
    }

    public static void main(String[] args) {
        MergeTwo output = new MergeTwo();
        output.commonElement().display();
    }

}
