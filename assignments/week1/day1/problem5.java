// v) Write a program to find the smallest number divisible by all the numbers between 1 to n.


import java.util.Scanner;

class Solution{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        long n = scn.nextLong();

        long ans = 1;
        for(long i = 2; i<n; i++){
            ans = lcm(ans, i);
        }

        System.out.println(ans);
    }

    public static long lcm(long a, long b){
        long min = Math.min(a,b);
        long max = Math.max(a,b);

        for(long i = max; ; i += max){
            if(i % min == 0) return i;
        }
    }
}