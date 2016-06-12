
/**
 * App for BaseHacks
 * 
 * @author Sona Dolasia 
 * @version 06/11/2016
 */
import java.util.ArrayList;
public class ThinkDrink
{
   public String name;
   public double weight;
   public double height;
   public double caffeineLimit;
   public double hw;
   public String exercise;
   public double level;
   public int water;
   public int sugar;
   public int caffeine;
   public int sportDrink;
   public int sweetDrink;
   public int coffee;
   public int decafCoffee;
   public int tea;
   public int decafTea;
   public int sweetened;
   public int temperature;
   public int goalOther;
   public int actualWater;
   public int actualOther;
   //inches
   public ThinkDrink (String n, double w, double h)
   {
       name = n; 
       weight = w; 
       height = h;
       sportDrink = 0;
       sweetDrink = 0;
       coffee = 0;
       decafCoffee = 0;
       tea = 0;
       decafTea = 0;
       sweetened = 0;
       goalOther = 0;
       actualWater = 0;
       actualOther = 0;
      
   }
   public void calcCaffeineLimit()
   {
       double factor = height + weight;
       caffeineLimit = 400 + (factor - 216);
    }
   public double getCaffeineLimit()
   {
        return caffeineLimit;
   }
   public String whatDrink ()
   {
       // work left in the day
       if(hw >= 1 && hw <= 2)
       {
           coffee += 3;
           decafCoffee +=2;
        }
       if(hw > 2 && hw <= 3)
       {
           tea += 2;
           decafTea += 1;
        }
       if (hw > 3)
       {
            tea += 3;
            decafTea += 2;
       }
       
       // exercise so far
       if(exercise.toLowerCase().equals("yes"))
       {
           sportDrink += 5;
        }
        
       // exhaustion/stress level
       if(level >= 4)
       {
           sweetDrink += 3;
           sweetened += 1;
        }
        
       // water
       if(water <= 4)
       {
           tea += 2;
           decafTea +=2;
           coffee -= 1;
           decafCoffee -= 1;
        }
       if(water > 4 && water < 8)
       {
           tea += 1;
           decafTea += 1;
        }
       
       // sweetDrinks
       if(sugar >= 1)
       {
            sweetDrink = -1;
            sportDrink -= 3;
            sweetened = -1;
       }
    
       // caffeiene
       if(caffeine >= caffeineLimit - 100)
       {
            coffee = -1;
       }
       if(caffeine >= caffeineLimit)
       {
            tea = -1;
       }
       
       int[] drinks = {sportDrink, sweetDrink, coffee, decafCoffee, tea, decafTea};
           String[] alsoDrinks = {"WOW you've been working out! Get it! Werk that New Years Resolution. Make sure to re-hydrate and get a sports drink like Gatorade, Vitamin Water, or a fruit smoothie. A sports drink will also help to replenish your electrolytes!",
           "You get a swet drink! TREAT YO SELF! Get that milkshake, bring all them boys to the yard! Something like a milkshake or a hot chocolate will perk you up. And stay hydrated!", 
           "Get ready to WERK. You have  a lot to get done, so you need some major caffeine. Go get a cup of coffee and get ready to werk, werk, werk, werk, werk. And stay hydrated!", 
           "Y I K E S - you need to lay off the caffeine… but that’s okay! You can still enjoy your favorite Starbucks drink, just get decaf! And stay hydrated!", 
           "Do you hate the taste of coffee? Does it taste as bitter as your ex?  Perfect, you can still get the caffeine you need with a nice big cup of tea!", 
           "Sip on some decaf tea to calm yourself down, whether you have a night of studying or High School Musical, decaf tea is perfect for the occasion."};
           int max = drinks[0];
        ArrayList<Integer> maximum = new ArrayList<Integer>();
           for(int i = 1; i < drinks.length; i++)
        {
            if(drinks[i] > max)
            {
                max = drinks[i];
            }
        }
        for(int j = 0; j < drinks.length; j++)
        {
            if(drinks[j] == max)
            {
                maximum.add(j);
            }
        }
        int value = (int)(Math.random()*maximum.size());
        if(sweetened == 1 && maximum.get(value) >= 2 && temperature >= 78)
        {
          return "Drink water and... " + alsoDrinks[maximum.get(value)] + 
          " **Spice up your life! Or rather, sweeten up your life! Throw a pack or two of sugar in your drink! You deserve it. ;)"
          + " **Damn it's hotter than Beyonce out there. Fee free to get yourself a version of this drink as cold as the shade the queen herself throws. ;)";
        }
        else if(sweetened == 1 && maximum.get(value) >= 2)
        {
            return "Drink water and... " + alsoDrinks[maximum.get(value)] + 
            " **Spice up your life! Or rather, sweeten up your life! Throw a pack or two of sugar in your drink! You deserve it. ;)";
        }
        else if(temperature >= 78 && maximum.get(value) >= 2)
        {
            return "Drink water and... " + alsoDrinks[maximum.get(value)] + 
            " **Damn it's hotter than Beyonce out there. Fee free to get yourself a version of this drink as cold as the shade the queen herself throws. ;)";
            
        }
        
        return "Drink water and... " + alsoDrinks[maximum.get(value)];
       
    }
   public void addtoGoalOther()
   {
       goalOther += 1;
    }
    
}
