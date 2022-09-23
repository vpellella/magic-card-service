package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SinglyLinkedList {

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.addressList.add(new Address("Hyd"));
        emp1.addressList.add(new Address("Bang"));
        Employee emp2 = new Employee();
        emp2.addressList.add(new Address("Goa"));
        emp2.addressList.add(new Address("Che"));
        List addresses = Arrays.asList(emp1, emp2).stream().flatMap(emp -> emp.addressList.stream()).collect(Collectors.toList());
        System.out.println(addresses);


//        Arrays.asList(list).stream().collect(Collectors.summingInt(Integer::intValue));
//        ListNode i1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode i2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//
//        ListNode i1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
//        ListNode i2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
//        ListNode output = new Solution().addTwoNumbers(i1, i2);
//        System.out.println(output.val);
//        while(output.next != null){
//            output = output.next;
//            System.out.println("Child Node Val: ");
//            System.out.print(output.val);
//
//        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode rootNode = new ListNode(0);
        ListNode previousNode= rootNode;
        while (l1 != null || l2 != null) {
            int l1Val = l1 != null? l1.val : 0;
            int l2Val = l2 != null? l2.val : 0;
            int currVal = (l1Val + l2Val+ carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            previousNode.next = new ListNode(currVal);
            previousNode = previousNode;
            l1 = l2 != null? l2.next :null ;
            l2 = l2 != null? l2.next :null ;
        }
        rootNode = previousNode;
        return rootNode;



    }


}

class Address{
    public String city;

     Address(){}
    Address(String city){
         this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
class Employee{
    List<Address> addressList = new ArrayList<>();
}