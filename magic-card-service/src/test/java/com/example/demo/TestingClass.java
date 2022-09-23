package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RunWith(MockitoJUnitRunner.class)
public class TestingClass{

    @Test
    public void est1() {
//        Map<String, Long> collect = Arrays.stream("Vineel Pellella".split(""))
//                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
//        System.out.println(collect);

        Map map =  new HashMap();
        map.put(1,"1");
        map.put(13,"2");
        map.put(9,"3");
        map.put(4,"4");

        System.out.println(map.size());

    }

    @Test
    public void patternMatcher() {
        Pattern pattern = Pattern.compile(".*[aeiou].*");
        Matcher matcher = pattern.matcher("I am a valid user");
        if(matcher.find())
            System.out.println("Vowels exist");
        Collections.sort(Arrays.asList(), (obj1, obj2) -> {
            return obj1.hashCode() > obj2.hashCode()?1:-1;
        });

    }


    @Test
    public void est2() {
        verifyRotatingPalindrome(new int[]{6, 7,7, 6, 8, 4, 3, 4, 8});
    }

    public void verifyRotatingPalindrome(int[] arr){
        long start = System.currentTimeMillis();
        for (int i =0; i < arr.length-1; i++){
            int[] temparr = rotateArray(arr, i);
            if(verifyPalindrome(temparr)){
                System.out.println("postion of rotation: "+ i);

            }
        }
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }
    public int[] rotateArray(int[] arr, int fromIndex){
        if(fromIndex ==0 )
            return arr;
        int[] tempArr = new int[arr.length];
        int tempArrIndex =0;
        for(int startpos = fromIndex ; startpos <= arr.length-1 ; startpos++){
            tempArr[tempArrIndex] = arr[startpos];
            tempArrIndex++;
        }
        for(int startpos = 0 ; startpos<fromIndex ; startpos++){
            tempArr[tempArrIndex] = arr[startpos];
            tempArrIndex++;
        }

        return tempArr;
    }

    public int[] rotateArrayBy1Pos(int[] arr){

        int[] tempArr = new int[arr.length];
        for(int startpos = 1 ; startpos <= arr.length-1 ; startpos++){
            tempArr[startpos-1] = arr[startpos];
        }
        tempArr[arr.length-1] = arr[0];

        return tempArr;
    }

    public boolean verifyPalindrome(int[] arr){
        for (int i =0; i < (arr.length-1)/2; i++){
            if(arr[i] != arr[arr.length-1-i])
                return  false;
        }
        return true;
    }



}

