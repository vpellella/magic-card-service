package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReturningUniqueElementsFromList {

    public static void main(String[] args) {
        int[] input = {4, 6, 8, 4, 8, 5,4, 6, 8, 4, 8, 5,4, 6, 8, 4, 8, 5,4, 6, 8, 4, 8, 5,4, 6, 8, 4, 8, 5,4, 6, 8, 4, 8, 5,4, 6, 8, 4, 8, 5,4, 6, 8, 4, 8, 5,
                4, 6, 8, 4, 8, 54, 6, 8, 4, 8, 54, 6, 8, 4, 8, 54, 6, 8, 4, 8, 54, 6, 8, 4, 8, 54, 6, 8, 4, 8, 5,
                4, 6, 8, 4, 8, 54, 6, 8, 4, 8, 54, 6, 8, 4, 8, 54, 6, 8, 4, 8, 54, 6, 8, 4, 8, 5,
                4, 6, 8, 4, 8, 54, 6, 8, 4, 8, 54, 6, 8, 4, 8, 5};

        int length = 10;
        Long start = System.currentTimeMillis();
        for(int i =0; i< length; i++)
            getUniqueElementList1(input);
        Long end = System.currentTimeMillis();
        System.out.println(end -start);

        start = System.currentTimeMillis();
        for(int i =0; i< length; i++)
            getUniqueElementList(input);
        end = System.currentTimeMillis();
        System.out.println(end -start);
//        System.out.println(Arrays.toString(array));

        int reduce = IntStream.of(input).reduce(1, (a, b) -> a * b);
    }


    public static int[] getUniqueElementList1(int[] input){


        Map<Integer, Integer> map = new HashMap();
        for(int i: input){
            if(map.containsKey(i)){
               Integer value = map.get(i);
               map.put(i, value+1);
            }else
                map.put(i, 1);
        }

        List<Integer> outputList = new ArrayList();
        map.keySet().forEach(key -> {
            if(map.get(key) > 1)
            outputList.add(key);
        });
        if(outputList.size() ==0)
            return new int[]{-1};

        Collections.sort(outputList);
        int[] output = new int[outputList.size()];

        for(int l =0; l<outputList.size(); l++){
            output[l] = outputList.get(l);
        }
        return  output.clone();
    }


    public static int[] getUniqueElementList(int[] input){

        if(input.length <= 1)
            return new int[]{-1};

        Set<Integer> outputList = new HashSet<>();
          for(int i =0; i< input.length; i++){
              for(int j =i+1; j< input.length; j++) {
                  if(input[i] == input[j])
                  {
                      outputList.add(input[i]);
                  }
              }
          }

        if(outputList == null || outputList.size() == 0)
            return new int[]{-1};

        return outputList.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
