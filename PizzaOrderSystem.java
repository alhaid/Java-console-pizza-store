/*
 Name: Hamzah Shafeeq
 Assignment: In-Class Bonus Exercise 13.3
 Program: Computer Programmer
 
 Description:
 Pizza Order System: allows a clerk to complete customer
 orders for pizza.  An order can include more than one 
 pizza.  Lots of data validation is done for you here, but
 some you are supposed to code in the Pizza class.
 
 Fill in missing pieces by following the instructions
 marked with // ***
 
 Be sure to read the existing code and comments carefully,
 as you need to understand this program in order to 
 complete it!
 
 */
import java.util.Scanner;

public class PizzaOrderSystem 
{
    public static void main(String[] args) 
    {
        // a scanner for keyboard input
        Scanner in = new Scanner(System.in);
        
        char morePizza = 'Y'; // used to control outer loop
        double orderTotal = 0; // total for the order of many pizzas
        String output = "";  // output to show at the end of the order
        
        // A single order can contain more than one pizza.
        // This loop gets the information for one pizza and 
        // adds the pizza object's data to the "output"
        // variable, and also adds the cost of each pizza to
        // the running total "orderTotal".
        
        // while the clerk has more pizzas for this order
        while (morePizza == 'Y')
        {
            // *** CONSTRUCT A NEW PIZZA OBJECT USING THE
            //     DEFAULT CONSTRUCTOR (1 statement)
            Pizza pizza = new Pizza();
            
            
            
            // variables needed for user input:
            int toppings = 0;  // number of topings
            int size = 0;   // number for size
            
            // flag to keep track of valid values
            boolean isValid = false; 
            
            // Both inputs from the user must be valid.
            // Each input has its own loop (wish we could
            // put this in one method, but we can't this 
            // time :P )
            
            // while user input is not valid
            while (!isValid)
            {
                try
                { // get the number of toppings on this pizza 
                    System.out.print("Enter number of toppings (1 to 10): ");
                    toppings = in.nextInt();
                    
                    // *** SET THE PIZZA OBJECT'S TOPPINGS
                    //     (1 statement)
                    pizza.setToppings(toppings);
                    
                    // if we get here, it all must be valid
                    isValid = true;
                }
                catch (Exception ex)
                {
                    // user either entered a string or they
                    // entered an invalid number of toppings
                    System.out.println("Invalid value for number of toppings.");
                    in.nextLine(); // purge buffer
                }
            }
            // reset the flag for the next input
            isValid = false;
            // while user input is not valid
            while (!isValid)
            {
                try
                {  
                    // get the size of the pizza
                    System.out.print("Enter pizza size (Small=1, Medium=2, Large=3): ");
                    size = in.nextInt();
                    // *** SET THE PIZZA OBJECT'S SIZE
                    //     (1 statement)
                    pizza.setSize(size);
                    
                    // if we get here, then it must be valid
                    isValid = true;
                }
                catch (Exception ex)
                {
                    // user either entered a string or they 
                    // entered an invalid size number
                    System.out.println("Invalid value for pizza size.");
                    in.nextLine(); // purge buffer
                }
            }
            // *** GET THE COST OF THE PIZZA
            //     (uncomment this line and complete it)
            double pizzaCost = pizza.calcPrice();
            
            // add the cost to the total
            orderTotal += pizzaCost;
            
            // *** THE output VARIABLE CONTAINS THE STRINGS FOR ALL 
            //     THE PIZZAS IN THIS ORDER.  CONCATENATE THIS PIZZA
            //     OBJECT'S STRING REPRESENTATION TO THE output 
            //     VARIABLE WITH A NEW-LINE AT THE END
            //     (uncomment this line and complete it)
            output += pizza + "\n";
            
            // is there another pizza in this order?
            System.out.print("Add another pizza? (Y/N): ");
            morePizza = in.next().toUpperCase().charAt(0);
            in.nextLine(); // purge buffer
        }
        
        // display the complete order
        System.out.println("Order Total:");
        System.out.println(output);
        // display the final order total
        System.out.println("--------------");
        System.out.printf("Final Total: $%.2f%n",
                          orderTotal);
        
    }
}
