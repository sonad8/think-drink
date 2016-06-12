import java.util.Scanner;
/**
 * Tester class
 * @author ByteMe
 * @version 06/11/16
 */
import java.util.ArrayList;
public class Tester
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        ArrayList<Double> pastScores = new ArrayList<Double>();
        System.out.println("Welcome to ThinkDrink! To begin please fill out the following information:");
        System.out.println("Name:");
        String name = in.next();
        System.out.println("Height in Inches (hint: 12 inches is a foot)");
        double height = in.nextDouble();
        System.out.println("Weight in pounds");
        double weight = in.nextDouble();
        ThinkDrink user = new ThinkDrink(name, weight, height);
        user.calcCaffeineLimit();
        //reword
        //input more here
       
       boolean done = false;
       while(!done)
       {
        System.out.println("What would you like to do? Type the number of the task you would like to do.");
        System.out.println("1: Determine your Perfect Pick-Me-Up!");
        System.out.println("2: Update your ThinkDrink Score and view your ThinkDrink Score data");
         int choice = in.nextInt();
       if (choice == 1)
        {
           System.out.println("How many hours of HW/Work do you have to complete?");
           user.hw = in.nextDouble();
           System.out.println("Have you exercised more than 30 min today? (Yes/No)");
           user.exercise = in.next();
           System.out.println("On a scale of 1-5, how stressed/exhausted are you?"); 
           user.level = in.nextDouble();
           System.out.println("How many glasses of water have you had today?");
           user.water = in.nextInt();
           System.out.println("How many sugary drinks have you had today? (eg. soda, boba etc.)");
           user.sugar = in.nextInt();
           System.out.println("How much caffeine have you had today in milligrams? (brewed coffee = 150 mg per cup, instant coffee = 70mg per cup, espresso shot = 65mg, tea = 20mg per cup)");
           user.caffeine = in.nextInt();
           System.out.println("What is the approximate temperature outside? (in farenheit please)");
           user.temperature = in.nextInt();
           System.out.println(user.whatDrink());
           user.addtoGoalOther();
           System.out.println("Write done if you're finished using ThinkDrink. Otherwise, type any number to keep using");
           String doneString = in.next();
           if(doneString.toLowerCase().equals("done"))
           {
               done = true;
            }
       }
       if(choice == 2)
       {
           System.out.println("How many cups of water have you had today (0 to 8)?");
           user.actualWater = in.nextInt();
           if(user.actualWater > 8)
           {
               user.actualWater = 8;
            }
           System.out.println("How many times out of " + user.goalOther + " did you fulfill ThinkDrink's suggestion by having water or your recommended drink?");
           user.actualOther = in.nextInt();
           double score = (user.actualOther + user.actualWater)/(user.goalOther + 8.0)*100;
           pastScores.add(score);
           System.out.println("Your current ThinkDrink Score for today is " + score+ "%");
           System.out.println("Your ThinkDrink Score history is " + pastScores);
           double average = 0;
           double sum = 0;
           for(int i = 0; i < pastScores.size(); i++)
           {
               sum = sum + pastScores.get(i);
               
            }
           average = sum/(double)(pastScores.size());
           System.out.println("Your average ThinkDrink Score is " + average + "%");
           System.out.println("Write done if you're finished using ThinkDrink. Otherwise, type any number to keep using.");
           String doneString = in.next();
           if(doneString.toLowerCase().equals("done"))
           {
               done = true;
            }
           
        }
    }}}

