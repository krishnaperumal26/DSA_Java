package com.Practise.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Print all n digit numbers using 1 and 2 only
// For example, if n = 3, the output should be:
// 111, 112, 121, 122, 211, 212, 221, 222

//For example, if n = 4, the output should be:
// 1111, 1112, 1121, 1122, 1211, 1212, 1221, 1222, 2111, 2112, 2121, 2122, 2211, 2212, 2221, 2222
public class PrintAllNDigitNumberUsing1And2 {
    public static void main(String[] args) {
        int N = 2;
        int[] currentList = new int[N];
        generateDigit(N, 0, currentList);
    }

   static void generateDigit(int N, int  index, int[] currentList) {
        if(index == N) {
            //print the currentList
            for (int digit : currentList) {
                System.out.print(digit);
            }
            System.out.println();
            return;
        }
       currentList[index]=1;
       generateDigit(N, index + 1, currentList);
       currentList[index]= 2;
       generateDigit(N, index + 1, currentList);

       //Instead of ans Array, if we use List
//       ans.add(1);
//       generateDigit(N, index + 1, ans);
//       ans.set(index, 2);
//       generateDigit(N, index + 1, ans);
//       ans.remove(index);

    }
}

//TC: O(2^N) for recursion + O(N) for printing = O(N*2^N)
//SC: O(N) for recursion stack
/*
    generateDigit(3, 0, [])
|
        |-- currentList[0] = 1
        |   generateDigit(3, 1, [1])
|   |
        |   |-- currentList[1] = 1
        |   |   generateDigit(3, 2, [1, 1])
|   |   |
        |   |   |-- currentList[2] = 1
        |   |   |   generateDigit(3, 3, [1, 1, 1]) -> Output: 111
        |   |   |
        |   |   |-- currentList[2] = 2
        |   |       generateDigit(3, 3, [1, 1, 2]) -> Output: 112
        |   |
        |   |-- currentList[1] = 2
        |       generateDigit(3, 2, [1, 2])
|       |
        |       |-- currentList[2] = 1
        |       |   generateDigit(3, 3, [1, 2, 1]) -> Output: 121
        |       |
        |       |-- currentList[2] = 2
        |           generateDigit(3, 3, [1, 2, 2]) -> Output: 122
        |
        |-- currentList[0] = 2
    generateDigit(3, 1, [2])
    |
            |-- currentList[1] = 1
        |   generateDigit(3, 2, [2, 1])
    |   |
            |   |-- currentList[2] = 1
        |   |   generateDigit(3, 3, [2, 1, 1]) -> Output: 211
        |   |
        |   |-- currentList[2] = 2
        |       generateDigit(3, 3, [2, 1, 2]) -> Output: 212
        |
        |-- currentList[1] = 2
        generateDigit(3, 2, [2, 2])
        |
                |-- currentList[2] = 1
        |   generateDigit(3, 3, [2, 2, 1]) -> Output: 221
        |
        |-- currentList[2] = 2
        generateDigit(3, 3, [2, 2, 2]) -> Output: 222

*/
//Output: 111, 112, 121, 122, 211, 212, 221, 222