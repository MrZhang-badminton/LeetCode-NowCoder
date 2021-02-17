package oj.temp.LRU;

import java.util.*;


public class Solution {

    public static List<Integer> calculate(List<Integer> list){
        List<ArrayList<Integer>> resList = new ArrayList<>();
        int index = -1;
        int max = -1;
        
        for(int i = 0; i < list.size() - 1; i++){
            ArrayList<Integer> tmpList = new ArrayList<>();
            int lastNum = list.get(i);
            tmpList.add(list.get(i));
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(j) > lastNum){
                    lastNum = list.get(j);
                    tmpList.add(list.get(j));
                }
            }
            if(tmpList.size() > max){
                max = tmpList.size();
                index = i;
            }
            resList.add(tmpList);
        }
        return resList.get(index);
    }

//    public static int calSum(ArrayList<Integer> list){
//        int sum = 0;
//        for(Integer i : list){
//            sum += i;
//        }
//        return sum;
//    }
//
//    public static List<Integer> calculate(List<Integer> list){
//        List<ArrayList<Integer>> resList = new ArrayList<>();
//        int index = -1;
//        int max = -1;
//        int sumMin = Integer.MAX_VALUE;
//
//
//        for(int i = 0; i < list.size() - 1; i++){
//            ArrayList<Integer> tmpList = new ArrayList<>();
//            int lastNum = list.get(i);
//            tmpList.add(list.get(i));
//            for(int j = i + 1; j < list.size(); j++){
//                if(list.get(j) > lastNum){
//                    lastNum = list.get(j);
//                    tmpList.add(list.get(j));
//                }
//            }
//            int sum = calSum(tmpList);
//            if(tmpList.size() > max){
//                max = tmpList.size();
//                index = i;
//            }else if(tmpList.size() == max && sum < sumMin){
//                max = tmpList.size();
//                index = i;
//            }
//            resList.add(tmpList);
//        }
//        return resList.get(index);
//    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(6);

        list.add(4);
        list.add(8);
        list.add(9);
        list.add(7);

        System.out.println(calculate(list));

    }
}