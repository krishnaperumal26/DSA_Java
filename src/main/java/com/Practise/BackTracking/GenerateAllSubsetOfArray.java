package com.Practise.BackTracking;

//Given an array, generate all the subsets of the array.
//Eg: if the array is [1, 2, 3], the subsets are:
// [], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GenerateAllSubsetOfArray {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        int n = A.size();
        ArrayList<Integer> subset = new ArrayList<>();
        generateSubset(0, A, subset, ans);

        Collections.sort(ans,(a, b)->{
            for(int i = 0 ; i < Math.min(a.size(),b.size());i++){
                if(a.get(i) != b.get(i)){
                    return a.get(i) - b.get(i);
                }

            }
            return a.size() -b.size();
        });
        System.out.println(ans);

    }
    static void generateSubset(int index, ArrayList A,  ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> ans)
    {
        if (A.size() == index) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        // Include the current element
        subset.add((Integer) A.get(index));
        generateSubset(index + 1, A, subset, ans);
        // Exclude the current element
        subset.removeLast();
        generateSubset(index + 1, A, subset, ans);


    }
}
