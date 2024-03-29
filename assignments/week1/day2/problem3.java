
 
// iii) Write a program to print the below pattern:

// \*****/         
// *\***/*         
// **\*/**         
// ***\***        
// **/*\**        
// */***\*         
// /*****\

import java.util.Scanner;

class ProblemThree{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPattern(n);
    }

    /*
     * MARK :- Print X pattern 
     * INPUT :- int (number of stars)
     * OUTPUT :- void
     */
    public static void printPattern(int n){
        int posForwardSlash = n+1; // track position of forward slash
        int posBackSlash = 0;  // traack position of backward slash

        // upper half of pattern
        for(int i=0; i<n/2+1; i++){

            // n+2 iteration because it contains n star + 2 slash
            for(int j=0; j<n+2; j++){
                if(j==posBackSlash){
                    System.out.print("\\");
                    
                }
                else if(j!=posBackSlash && j!=posForwardSlash)
                    System.out.print("*");
                if(j==posForwardSlash){
                    System.out.print("/");
                   
                }
            }
            posBackSlash++;
            posForwardSlash--;
            
            System.out.println();
        }


        // for middle line of row 
        for(int i=0; i<n/2+1; i++){
            System.out.print("*");
        }
        System.out.print("\\");
        for(int i=0; i<n/2+1; i++){
            System.out.print("*");
        }
        System.out.println();

        // lower half of pattern
        posForwardSlash = n/2;
        posBackSlash = n/2+2;
        for(int i=0; i<n/2+1; i++){

            // n+2 iteration because it contains n star + 2 slash
            for(int j=0; j<n+2; j++){
                if(j==posForwardSlash){
                    System.out.print("/");
                }
                else if(j!=posBackSlash && j!=posForwardSlash)
                    System.out.print("*");
                if(j==posBackSlash){
                    System.out.print("\\");
                }
            }
            posBackSlash++;
            posForwardSlash--;

            System.out.println();
        }
    }
}

 