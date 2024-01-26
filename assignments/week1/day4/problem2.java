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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class ProblemTwo{

    // MARK : main method
    public static void main(String[] args) {
        HashMap<String, char[]> valueMap = new HashMap<>();
        valueMap.put("1",new char[]{'Z', 'Y', 'A'});
        valueMap.put("2",new char[]{'B', 'O'});
        valueMap.put("12",new char[]{'L'});
        valueMap.put("3",new char[]{'U', 'P'});

        Scanner scn = new Scanner(System.in);
        String inputStr = scn.next();

        ArrayList<String> result = new ArrayList<String>();

        ArrayList<ArrayList<String>> possibleCombination = new ArrayList<>();
        ArrayList<String> sepcialCombo = new ArrayList<>();
        ArrayList<String> eachDigitCombo = new ArrayList<>();


        // Generate key from the given input
        for(int i=0; i<inputStr.length(); i++){
            eachDigitCombo.add(inputStr.charAt(i) + "");          
        }

        
        
        for(int i=0; i<eachDigitCombo.size(); i++){
            if(eachDigitCombo.get(i).equals("1") && i+1 < eachDigitCombo.size() && eachDigitCombo.get(i+1).equals("2")){
                sepcialCombo.add("12");
                i++;
            }
            else{
                sepcialCombo.add(eachDigitCombo.get(i));
            }
        }
        
        possibleCombination.add(eachDigitCombo);
        possibleCombination.add(sepcialCombo);

        // Iterationg over all the possible set of keys from the given input String
        for(ArrayList<String> keyCombo : possibleCombination){
            generateLetterCombo(keyCombo, valueMap, new StringBuilder(),result, 0);
        }

        // Print all the combination generated
        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i)+" ");
        }
    }


    /*
     * MARK :- Generate letter combination from the given key and its value 
     * INPUT :- ArrayList<String>, HashMap<String, char[]>, StringBuilder, ArrayList<String>, int
     * OUTPUT :- void method
     * DESCRIPTION :- Generate combination of letters assign to the given key using recursion
     */
    public static void generateLetterCombo(ArrayList<String> keys, HashMap<String, char[]> valueMap, StringBuilder pattern, ArrayList<String> result, int index){

        if(index == keys.size()){
            result.add(pattern.toString());
            return;
        }
        for(int i=0; i<valueMap.get(keys.get(index)).length; i++){
            pattern.append(valueMap.get(keys.get(index))[i]);
            generateLetterCombo(keys, valueMap, pattern, result, index + 1);
            pattern.deleteCharAt(pattern.length() - 1);
        }
        
    }
 }