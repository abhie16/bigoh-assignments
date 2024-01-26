/*

iv) Write a function Boolean isValidURL(String url).
Input : str = “https://www.bigohtech.com/” 
Output : Yes 
Explanation : 
The above URL is a valid URL.
Input : str = “https:// www.bigohtech.com/” 
Output : No 
Explanation : 
Note that there is a space after https://, hence the URL is invalid. 


*/

import java.util.Scanner;

class Solution{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String url = scn.nextLine();
        System.out.println(isValidURL(url));
       
    }

    /*
     * MARK :- Check if given url is valid or not
     * INPUT :- String URL
     * OUTPUT :- boolean
     * DESCRIPTION :- Check if given url is valid or not. It separate url in protocol and web address then check for protocols and web address are valid or not.
     */
    public static boolean isValidURL(String url){
         String[] tokens = url.split("//");
         if(tokens.length <= 2) {
            return false;
         }
        String protocol = tokens[0];
        String webAddress = tokens[1];
        System.out.println(webAddress);

        if(!protocol.equals("https:") && !protocol.equals("http:")) {
            return false;
         }
        else{
            String[] webToken = webAddress.split("\\.");

            if(webToken.length<2) return false;

            if(webToken[0].charAt(0) == ' ') {
                return false;
            }
        }

        return true;
    }
}