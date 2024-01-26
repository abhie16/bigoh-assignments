// iii) Find the largest number less than N whose each digit is prime number

// intuition
// one digit prime numbers -> 2, 3, 5, 7

import java.util.Scanner;

class Solution{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        for(int n = num-1; n>1; n--){
            if(isEachDigitPrime(n)){
                System.out.println(n);
                return;
            }
        }

        System.out.println("not found");
    }

    /*
     * MARK :- Check if each digit of given num is prime or not
     * INPUT :- int Number
     * OUTPUT :- boolean
     * DESCRIPTION :- Check if each digit of given num is prime or not. It check for only 2,3,5 and 7 as we have to check a digit of a num;
     */
    public static boolean isEachDigitPrime(int num){
        while(num>0){
            int dig = num % 10;
            num = num / 10;
            
            if(dig != 2 && dig != 3 && dig != 5 && dig != 7){
                return false;
            }
        }

        return true;
    }
}