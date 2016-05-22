/*
 Name: Hamzah Shafeeq
 Assignment: In-Class Bonus Exercise 13.3
 Program: Computer Programmer
 
 Description:
 Pizza Order System: allows a clerk to complete customer
 orders for pizza.
 */
public class Pizza{
    //data
    public final double TOPPING_COST = 1.75;
    public final int MAX_TOPPINGS = 10;
    public int small = 1;
    public int medium = 2;
    public int large = 3;
    public final double SMALL_COST = 8.0;
    public final double MED_COST = 10.0;
    public final double LARGE_COST = 12.0;
    public int size;
    private int toppings;
    private double totalPrice = 0;
    
    //constructor
    public Pizza() {
        size = small;
        toppings = 1;
    }
    //overloaded constructor
    public Pizza(int size, int toppings) throws IllegalArgumentException{
        this.setSize(size);
        this.setToppings(toppings);
    }
    //method to set the size between 1-3
    public void setSize (int size) throws IllegalArgumentException{
        if(size >=small && size <= large){
            this.size = size;
        }else{
            throw new IllegalArgumentException("Your size must be between 1-3");
        }
    }
    //method to return the size
    public int getSize() {return size;}
    //method to set the toppings between 1-10
    public void setToppings (int toppings) throws IllegalArgumentException{
        if(toppings > 0 && toppings <= 10){
            this.toppings = toppings;
        }else{
            throw new IllegalArgumentException("toppings must be between 1-10");
        }
    }
    //method to return the toppings
    public int getToppings(){return toppings;}
    //method to calculate the price of the pizza
    public double calcPrice(){
        switch (this.size){
            case 1 :
                totalPrice = SMALL_COST + TOPPING_COST * toppings;
                break;
            case 2 :
                totalPrice = MED_COST + TOPPING_COST * toppings;
                break;
            case 3 :
                totalPrice = LARGE_COST + TOPPING_COST * toppings;
                break;
        }
        return totalPrice;
    }
    //method to print out the price, the size and the number of toppings
    public String toString() {
        String sizeS = "";
        if (size == 1){sizeS = "small";}
        if (size == 2){sizeS = "medium";}
        if (size == 3){sizeS = "large";}
        return String.format ("%s Pizza %n %d Toppings %n Total Price $%.2f",
            sizeS, toppings, calcPrice());
    }
}