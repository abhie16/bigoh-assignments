// ii) Write a program (without using inbuilt functions and not using Strings or array) to swap first and last digits of any number

import java.util.Scanner;

class Solution{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        int len = length(num);

        if(len<2){
            System.out.println("at least two digits");
            return;
        }
        if(num == 0) {
            System.out.println(0);
            return;
        }

        int last_digit = num % 10;  //  5678 -> 8
        num = num / 10; // 5678 -> 567

        int first_digit = num / (int) (Math.pow(10, len - 2));  //  567 -> 5
        num = num % (int) (Math.pow(10, len - 2)); // 567 -> 67

        num =  last_digit * (int)Math.pow(10, len - 1) + (num * 10 + first_digit);  // 8(last-digit) * 1000 + 67 * 10 + 5(first_digit)  -> 8675

        System.out.println(num);
        
    }

    public static int length(int num){
        int count = 0;
        while(num > 0){
            num = num/10;
            count++;
        }
        return count;
    }
}