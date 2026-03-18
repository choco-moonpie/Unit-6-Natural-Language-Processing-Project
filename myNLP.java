import java.util.ArrayList;
import java.util.Scanner;

public class myNLP {

  /**
  *creates ArrayList<String? arraylists from the text files wordDefintion.txt and synonym.txt
  **/

  ArrayList<String> words = FileReader.toStringList("wordDefinition.txt");
  ArrayList<String> synonyms = FileReader.toStringList("synonym.txt");

  /**
   * Starts the app and gets user input
   */
  public void prompt() {
    Scanner input = new Scanner(System.in);
    
    // Starting text
    System.out.println("Welcome to my NLP app!");
    System.out.println("1. Define a word");
    System.out.println("2. Find a synonym");
    String userInput = input.nextLine(); // collect userInput
    
    /**
    *When 1 is selected, it will run this option in the if else. 
    *It will ask for a word to define.
    **/
    if (userInput.equals("1")) {
      System.out.println("\n" + "Find a definition selected." + "\n");
      // Add code here for option 1:
      System.out.println("What word would you like to define?");
      String wordInput = input.nextLine(); // Collect the word input
            
      String definition = findDefinition(wordInput); // Call the method
      System.out.println("\n" + "The definition of \"" + wordInput + "\" is: " + definition);

      /**
      *If 2 is selected, it will  run this option of the if else statement.
      *It will find the synonym to the asked input of a word.
      **/
      
    } else if (userInput.equals("2")) {
     System.out.println("\n" + "Find a synonym of a word." + "\n");
      // Add code here for option 1:
      System.out.println("What word would you like to find synonyms for?");
      String wordInput = input.nextLine(); // Collect the word input
            
      String synonymtofind = findSynonym(wordInput); // Call the method
      System.out.println("\n" + "The synonyms of \"" + wordInput + "\" is: " + synonymtofind);
      
    } else {
      // Error Handling
      System.out.println("\nSorry, I dont understand that."); 
      System.out.println("Please restart, and only choose option 1 or 2"); 
    }
    
    System.out.println("\nGoodbye!");
    input.close();
  }
  
  /**
   * Takes the inputted word when option 1 is selctected and runs through the wordDefinition.txt to find the word, it then returns the defintion if found. 
   * If not found, then it will return "Word not found. Try again."
   */
  public String findDefinition(String wordToFind) {

    String definition = "Word not found. Try again.";
    
    for(int i = 0; i < words.size(); i++){
  
      String current = words.get(i);
      int start = current.indexOf("|");
      int end = current.indexOf("/");

      String word = current.substring(0, start);
      
        if(word.equals(wordToFind)){
          
          return definition = current.substring(start, end);
          
        }
    }

    return definition;
  }

  /**
  *If the player selects the 2nd options, to find a synonym, used to expand vocabulary and write better sentences.
  *It will take the input given by the player and search through the synonym.txt and try to match up the given input
  *If it is found, it will take the synonym that come after it in the txt file, but if not
  *it will return "Not Found. Try Again."
  **/

  
  public String findSynonym(String synonymToFind){
    
    String result = "Not Found. Try Again.";
    
     for(String current : synonyms){
      int start = current.indexOf(",");

      String word = current.substring(0, start);
      
        if(word.equals(synonymToFind)){
          
          return result = current.substring(start+1);
          
        }
     }
    
    return result;
    
  }
}
