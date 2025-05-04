package com.Practise.BackTracking;

//Print all n digit numbers using 1,2,3,4,5
// For example, if n = 3, the output should be:
// 111, 112, 113, 114, 115, 121, 122, 123, 124, 125, 131, 132, 133, 134, 135,
// 141, 142, 143, 144, 145, 151, 152, 153, 154, 155,
// 211, 212, 213, 214, 215, 221, 222, 223, 224, 225, 231, 232, 233, 234, 235,
// 241, 242, 243, 244, 245, 251, 252, 253, 254, 255,
// 311, 312, 313, 314, 315, 321, 322, 323, 324, 325, 331, 332, 333, 334, 335,
// 341, 342, 343, 344, 345, 351, 352, 353, 354, 355,
// 411, 412, 413, 414, 415, 421, 422, 423, 424, 425, 431, 432, 433, 434, 435,
// 441, 442, 443, 444, 445, 451, 452, 453, 454, 455,
// 511, 512, 513, 514, 515, 521, 522, 523, 524, 525, 531, 532, 533, 534, 535,
// 541, 542, 543, 544, 545, 551, 552, 553, 554, 555


public class PrintAllNDigitNumberUsing1_2_3_4_5 {
    public static void main(String[] args) {
        int N = 3; // Change this to the desired number of digits
        int[] currentList = new int[N];
        generateDigit(N, 0, currentList);
    }

    static void generateDigit(int N, int index, int[] currentList) {
        if(index == N) {
            //print the currentList
            for (int digit : currentList) {
                System.out.print(digit);
            }
            System.out.println();
            return;
        }
        for(int i=1;i<=5;i++){
            currentList[index]=i;
            generateDigit(N, index + 1, currentList);
        }
    }
}

//TC: O(5^N) for recursion + O(N) for printing = O(N*5^N)
//SC: O(N) for recursion stack
