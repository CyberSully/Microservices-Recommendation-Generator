import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.io.FileWriter;
import java.io.IOException;



public class Main {
    public static void main(String[] args) {
        String topicChoice;
        System.out.println("Welcome to the Movies and Fun Facts Program");
        System.out.println("You have the choice of getting either movie suggestions or fun facts");
        System.out.println("Type 1 for movies, 2 for fun facts");
        System.out.println("You can also type any other number to exit at anytime throughout your journey");
        Scanner input = new Scanner(System.in);
        int selection = input.nextInt();
        if (selection == 1) {
            try {
                FileWriter myWriter = new FileWriter("C:\\CS-361\\Final-361-Project\\runnerMovies.txt");
                myWriter.write("run"); //writes run command to movie runner file
                myWriter.close();
                Thread.sleep(2000);
                System.out.println("Successfully wrote run command to the movie file.");
                System.out.println("Now lets go over to that program to get some suggestions");
                System.out.println("type any number after to continue to your results");
                int userChoice = input.nextInt();
                fileReader(); //calls fileReader method to show results from other program
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);  //end of first file writer
            }

        }
        if (selection == 2){

            try {
                FileWriter myWriter = new FileWriter("C:\\CS-361\\Final-361-Project\\runnerFacts.txt");
                myWriter.write("run"); //writes run command to facts runner file
                myWriter.close();
                Thread.sleep(2000);
                System.out.println("Successfully wrote run command to the fun facts file.");
                System.out.println("Now lets go over to that program to get some fun facts");
                System.out.println("type any number after to continue to your results");
                int userChoice = input.nextInt();
                fileReader(); //calls fileReader method to show results from other program
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);  //end of first file writer
            }
        }
        else{
            System.out.println("Thank you for checking out my program");
        }
    }
    public static void fileReader(){
        System.out.println("Now lets see our results from the other program");
        ArrayList<String> returnInfo = new ArrayList<>();
        int i = 0;
        try {
            File myObj = new File("C:\\CS-361\\Final-361-Project\\returnFile.txt"); //creates object to read from file
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                returnInfo.add(i,data +"\n"); //adds each line from file into an array list to display
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Your results from other program are: \n \n" + returnInfo);
    }
}