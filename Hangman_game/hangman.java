import java.util.*;  
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class hangman {
    public ArrayList<String> words =new ArrayList<String>();
    public ArrayList<String> guesses =new ArrayList<String>();
    public String guesses_string;
    public String word;
    public String current_guess_word;
    public boolean correct_puzzel = false;
    public boolean correct_guess = true;

    public void food_category(){
        try {
            File myObj = new File("food.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              words.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
//          for(int i =0; i<words.size();i++){
//              System.out.println(words.get(i));
//          }
          double double_Rand_Num = Math.random()*words.size();
          int random_number = (int)double_Rand_Num;
          word = words.get(random_number);
          System.out.println(word+ " random word");
    }

    public void sports_category(){
        try {
            File myObj = new File("sports.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              words.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
//          for(int i =0; i<words.size();i++){
//              System.out.println(words.get(i));
//          }
          double double_Rand_Num = Math.random()*words.size();
          int random_number = (int)double_Rand_Num;
          word = words.get(random_number);
          System.out.println(word+ " random word");
    }

    public void pets_category(){
        try {
            File myObj = new File("pets.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              words.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
//          for(int i =0; i<words.size();i++){
//              System.out.println(words.get(i));
//          }
          double double_Rand_Num = Math.random()*words.size();
          int random_number = (int)double_Rand_Num;
          word = words.get(random_number);
          System.out.println(word+ " random word");
    }

    public void check_input(String user_input, char[] inwork_word){
        if(user_input.length() > 1){
          if(word.equals(user_input)){
            correct_puzzel = true;
          }else{
            guesses.add(user_input);
            correct_guess = false;
          }
        }else{
          guesses.add(user_input);
          if(word.contains(user_input)){
            for(int i = 0;i<word.length();i++){
              if(word.charAt(i) == user_input.charAt(0)){
                inwork_word[i] = user_input.charAt(0);
              }
            }
          }else{
            correct_guess = false;
          }
        }
    }
    public static void main(String[] args) {
        boolean correct_input = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the category you would like to select from: Food,Sports,or Pets");
        String input = sc.nextLine();
        while(correct_input == false){
            if(input.toLowerCase().equals("food") || input.toLowerCase().equals("sports") || input.toLowerCase().equals("pets")){
                correct_input = true;
            }else{
                System.out.println("Enter the category you would like to select from: Food,Sports,or Pets");
                input = sc.nextLine();

            }
        }
        hangman caller = new hangman();
        if(input.toLowerCase().equals("food")){
            caller.food_category();
        }
        if(input.toLowerCase().equals("sports")){
            caller.sports_category();
        }
        if(input.toLowerCase().equals("pets")){
            caller.pets_category();
        }
        System.out.println("You're word is " + caller.word.length() + " letters long");
        System.out.println(" ");
        System.out.println("In the category of " + input);
        System.out.println(" ");
        System.out.println("You have " + (6 - caller.guesses.size()) + " guesses left");
        System.out.println(" ");
        System.out.println("Enter you're guess");
        String guess = sc.nextLine();
        char[] making_word = new char[caller.word.length()];
        for(int i = 0; i<making_word.length;i++){
          making_word[i] = '_';
        }
        while(caller.correct_puzzel == false){
          if(caller.guesses.size() < 5){
            caller.check_input(guess, making_word);
            System.out.println(" ");
            System.out.println("/ / / / / / / / / / / / / / / / / / / / / / /");
            System.out.println(" ");
            if(caller.correct_guess == false){
              System.out.println("Your guess was wrong");
            }else{
              System.out.println("Your guess was correct");
            }
            StringBuffer sb = new StringBuffer();
            for(int i =0; i<making_word.length;i++){
              sb.append(making_word[i]);
            }
            caller.current_guess_word = sb.toString();
            if(caller.current_guess_word.equals(caller.word)){
              caller.correct_puzzel = true;
            }
            System.out.println(caller.current_guess_word);
            if(caller.correct_puzzel == true){
              break;
            }
            caller.correct_guess = true;
            System.out.println(" ");
            System.out.println("previous gueses" + caller.guesses);
            System.out.println(" ");
            System.out.println("You have " + (6 - caller.guesses.size()) + " guesses left");
            System.out.println(" ");
            System.out.println("Enter you're guess");
            guess = sc.nextLine();
            for(int i =0; i<caller.guesses.size();i++){
              sb.append(caller.guesses.get(i));
            }
            caller.guesses_string = sb.toString();
            if(guess.length() < 2){
              while(caller.guesses_string.contains(guess)){
                System.out.println("You have already guessed, enter in a new value");
                System.out.println("Enter you're guess");
                guess = sc.nextLine();
              }
            }
          }else{
            break;
          }
        }
        if(caller.correct_puzzel == true){
          System.out.println("Congrats you win!!");
        }else{
          System.out.println("Unlucky, you didnt get it");
        }
        sc.close();

  
    }
}
