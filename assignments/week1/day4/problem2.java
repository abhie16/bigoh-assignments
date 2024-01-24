/*
    2. Write a program to print all the possible combinations according to the input values.
    Example :
    Given Values
    '1' : ['Z', 'Y', 'A'],
    '2' : ['B', 'O'],
    '12' : ['L']
    '3' : ['U', 'P']
    Input: 123
    Output : [ZBU, ZBP, ZOU, ZOP, YBU, YBP, YOU, YOP, ABU, ABP, AOU, AOP, LU, LP]
 */

import java.util.HashMap;
import java.util.Scanner;

class ProblemTwo{
    public static void main(String[] args) {
        HashMap<Integer, char[]> valueMap = new HashMap<>();
        valueMap.put(1,new char[]{'Z', 'Y', 'A'});
        valueMap.put(2,new char[]{'B', 'O'});
        valueMap.put(12,new char[]{'L'});
        valueMap.put(3,new char[]{'U', 'P'});

        Scanner scn = new Scanner(System.in);
        int input = scn.nextInt();

        helper(input, valueMap, new StringBuilder());
    }

    public static void helper(int input, HashMap<Integer, char[]> valueMap, StringBuilder pattern){
        if(input == 0){
            System.out.print(pattern + " ");
            return;
        }
        else{
            int key = input%10;
            input = input/10;

            char[] letters = valueMap.get(key);
            for(int i=0; i<letters.length; i++){
                pattern.append(letters[i]);
                helper(input, valueMap, pattern);
            }
        }
    }
 }