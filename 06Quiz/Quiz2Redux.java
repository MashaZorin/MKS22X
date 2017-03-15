import java.util.*;
public class Quiz2Redux{  
  /*Returns an ArrayList<String> that contains all subsets of the
   *characters of String s. Assume s has no duplicate characters.
   *the characters should appear in the same order that they occur 
   *in the original string.
   */
  public static ArrayList<String> combinations(String s){
      ArrayList<String>words = new ArrayList<String>();
      help( words , s /*fill this in with more */);
      Collections.sort(words);
      return words;
  }
  
    private static void help( ArrayList<String> words, String s/*fill this in with more arguments*/ ){
   /*METHOD TO BE WRITTEN BY YOU.*/
	words.add("");
	for (int strIndex = 0; strIndex < s.length(); strIndex ++){
	    int size = words.size();
	    char letter = s.charAt(strIndex);
	    for (int aryIndex = 0; aryIndex < size; aryIndex ++){
		words.add(words.get(aryIndex) + letter);
	    }
	}
    }

    public static void main(String[]args){
	System.out.println(combinations("abc"));
	System.out.println(combinations("wxof"));
    }
}
