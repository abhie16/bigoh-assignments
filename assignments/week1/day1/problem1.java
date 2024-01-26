/*
 
1) Write down a method boolean isNameValid(String  name).
A name is valid if following conditions are satisfied:
• It does not contain any vowel more than once.
• If the name contains two ‘S’, then there is not any ‘T’ in between them (both in capital cases).


*/

import java.util.Scanner;

class Solution{
    // Main method
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name = sc.nextLine();
        System.out.println(isNameValid(name));
    }

    /*
     * MARK :- Check if give string is valid or not 
     * INPUT :- String name
     * OUTPUT :- boolean
     * DESCRIPTION :- This is used to check if given name is valid or not
     *               A name is valid if following conditions are satisfied:
     *                  - It does not contain any vowel more than once.
     *                  - If the name contains two ‘S’, then there is not any ‘T’ in between them (both in capital cases).
     */
    public static boolean isNameValid(String s){
        int[] letters = new int[26];

        for(int i=0; i<s.length(); i++){

            // ignore small and large 's' and 't', as it will be handled separatly
            if(s.charAt(i) != 's' && s.charAt(i) != 't' && s.charAt(i) != 'S' && s.charAt(i) != 'T'){
                letters[s.charAt(i) - 'a']++;
            }

            // ignore small s and t as on their index we will we storing large s and t
            if(s.charAt(i) == 'S' || s.charAt(i) == 'T'){
                letters[s.charAt(i) - 'A']++;
            }

            // checking vowels
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                if(letters[s.charAt(i) - 'a'] > 1) return false;
            }

            // checking T between two large S
            if(s.charAt(i) == 'S' && letters[s.charAt(i) - 'A'] == 2 &&  letters['T' - 'A'] > 0 ) return false;
        }

        return true;
    }

}