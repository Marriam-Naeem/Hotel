package com.practice;

import java.util.*;

class customer_details{
    private String name;
    private String phoneno;
    private String email;
    private int customer_id;
    customer_details(){

    }
    customer_details(String name, String phoneno, String email,  int customer_id){
        this.name = name;
        this.email = email;
        this.phoneno = phoneno;
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }
    public int getCustomer_id() {
        return customer_id;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "-----RELAX  INN HOTEL----" +
                "\nCustomer Details" +
                "\nName: " + getName() +
                "\nPhone Number: " + getPhoneno() +
                "\nEmail: " + getEmail() +
                "\nCostumer Id: " +  getCustomer_id();
    }
}

class serviceavailable extends customer_details {

    private int service;

    public void display() {
        System.out.println("""
                
                At RELAX INN, we have following services available:
                1. Dine-in
                2. Stay-in
                3. Both Dine-in and Stay-in
                
                "Which service do you want: (enter 1,2,3)")
                """);

    }

    serviceavailable() {

    }

    serviceavailable(int service) {
        this.service = service;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public String getservice(int service) {
        return switch (service) {
            case 1 -> "Dine-in";
            case 2 -> "Stay-in";
            case 3 -> "Both";
            default -> "Not Valid";
        };
    }
}

class Orderfood extends serviceavailable{

    private String order;
    private String meal_type;
    double bill;
    private String main_course;
    private String desert;
    private String beverage;
    private String sauce;

    Orderfood(){
    }

    Orderfood(String mealtype) {
        this.meal_type = mealtype;
    }


    public String order() {
        System.out.println("""
                
                "AVAILABLE OPTIONS:"
                
                MAIN COURSE:
                Pizza    .........   Rs.1000
                Burger   .........   Rs. 500
                Pasta    .........   Rs.1000
                Lasagne  .........   Rs.700
                Salad    .........   Rs.200
                Desi Platter .....   Rs.2000
                Chinese Platter ..   Rs.1700
                Italian Platter ..   Rs.1800
                
                BREAKFAST:
                Waffles .........    Rs.300
                Pancake .........    Rs.300
                Cheese Omelet ...    Rs.200
                                                  
                DESERT:
                Chocolate Lava Cake ...  Rs.450
                Brownie   ...........    Rs.350
                Cheesecake ..........    Rs.500

                BEVERAGE:
                Ice-cream Shake ...   Rs. 200
                Juice     .........   Rs.150
                Soft Drink ........   Rs.130
                Tea     .........    Rs.70
                Coffee  .........    Rs.70

                SAUCE:
                Mayo Garlic Sauce ...  Rs.50
                Ranch Sauce .........  Rs.100
                BBQ sauce   .........  Rs.70
                
                *Make sure you enter the menu as stated above.
                """);

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your Main Course (if you want something from breakfast menu, enter here)");
        main_course = input.nextLine();
        System.out.println("Enter your Desert (if any or press enter to terminate):");
        desert = input.nextLine();
        System.out.println("Enter your Beverage (if any or press enter to terminate) :");
        beverage = input.nextLine();
        System.out.println("Enter your Sauce (if any or press enter to terminate)");
        sauce = input.nextLine();
        System.out.println("Do you want to confirm this order? (YES / NO )");
        String choice = input.next();
        if (choice.toLowerCase().equals("yes")) {
            order = main_course + "  " + desert + "  " + beverage + "  " + sauce;
            return order;
        }
        else if (choice.toLowerCase().equals("no")){
            System.out.println("Place your order again");
            System.out.println("Enter your Main Course (if you want something from breakfast menu, enter here)");
            main_course = input.nextLine();
            System.out.println("Enter your Desert (if any):");
            desert = input.nextLine();
            System.out.println("Enter your Beverage (if any) :");
            beverage = input.nextLine();
            System.out.println("Enter your Sauce (if any)");
            sauce = input.nextLine();
            order = main_course + "  " + desert + "  " + beverage + "  " + sauce;
            return order;
        }
        order = main_course + "  " + desert + "  " + beverage + "  " + sauce;
        return order;

    }
    public double bill() {
        switch (main_course.toLowerCase()) {
            case "pizza", "pasta" -> bill += 1000;
            case "burger" -> bill += 500;
            case "lasagne" -> bill += 700;
            case "desi platter" -> bill += 2000;
            case "chinese platter" -> bill += 1500;
            case "salad", "cheese omelet" -> bill += 200;
            case "italian platter" -> bill +=1800;
            case "waffles", "pancake" -> bill+=300;
        }

        switch (desert.toLowerCase()) {
            case "chocolate lava cake" -> bill += 450;
            case "brownie" -> bill += 350;
            case "cheesecake" -> bill += 500;
        }
        switch (beverage.toLowerCase()) {
            case "ice-cream shake" -> bill += 200;
            case "juice" -> bill += 150;
            case "soft drink" -> bill += 130;
            case "tea","coffee" -> bill+=70;
        }
        switch (sauce.toLowerCase()) {
            case "mayo garlic sauce" -> bill += 50;
            case "ranch sauce" -> bill += 100;
            case "bbq sauce" -> bill += 70;
        }
        return bill;
    }


    public void setMeal_type() {
        System.out.println("""
                
                Options for Meal Type are:
                Breakfast
                Lunch
                Dinner
                
                Enter your choice:
                """);
        Scanner input = new Scanner(System.in);
        String meal = input.next();
        switch (meal.toLowerCase()) {
            case "breakfast", "lunch", "dinner" -> meal_type = meal;
            default -> {
                System.out.println("Unknown Option Entered. You can only enter \"Breakfast\"" +
                        "\"Lunch\" or \"Dinner\"");
                meal = input.next();
                meal_type = meal;
            }
        }
    }

    public String getOrder() {
        return order;
    }

    public String getMeal_type() {
        return meal_type;
    }

    public double getBill() {
        return bill;
    }

    public void setMain_course(String main_course) {
        this.main_course = main_course;
    }

    public void setDesert(String desert) {
        this.desert = desert;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setBeverage(String beverage) {
        this.beverage = beverage;
    }
    public String toString() {
        return
                "\nFood Order: " +
                "\nOrder: \n" + order  +
                "\nMeal type: " + getMeal_type()  +
                "\nFood Bill: " + getBill() ;
    }
}

class Dine_in extends Orderfood{

    private String location;

    Scanner input = new Scanner(System.in);
    Dine_in(){
    }
    Dine_in (String location){
        this.location = location;
    }

    public void setLocation() {
        System.out.println("""
                \nOptions for Dine in location are:         
                Indoor
                Outdoor
                
                Enter your choice:""");
        location = input.next();
        if (location.equalsIgnoreCase("indoor"))
            this.location = location;
        else if (location.equalsIgnoreCase("outdoor"))
            this.location = location;
        else {
            System.out.println("Unknown Option Entered. You can only enter \"Indoor\"  or \"Outdoor\"");
            location = input.next();
            this.location = location;
        }
    }
    public void food(){

        String order = order();
        double bill = bill();

    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String toString() {
        return   super.toString() +
                "\nLocation: " + getLocation();
        }
}
class Staying extends Dine_in {

    private int total_rooms_king = 15;
    private int total_rooms_queen = 15;
    private int total_rooms_luxury = 15;

    private int no_of_rooms;
    private String type_of_room;
    private int no_of_days;
    private double cost;

    Scanner input = new Scanner(System.in);

    Staying() {
    }
    Staying(int room, String type, int days) {
        no_of_rooms = room;
        type_of_room = type;
        no_of_days = days;
    }

    public void foodorder() {
        setMeal_type();
        food();
    }

    public double cost() {
        return no_of_days * cost;

    }

    public void setNo_of_days() {
        System.out.println("Enter the number of days You want to Stay:");
        int days = input.nextInt();
        this.no_of_days = days;
    }


    public int getNo_of_rooms() {
        return no_of_rooms;
    }
    public void displayrooms(){
        System.out.println("""
                We have 3 types of rooms available:
                _______________________________________________________
                
                Room Type      |  Price per day  |   Available Rooms
                King           |    Rs.5000      |   Available 15
                Queen          |    Rs.3000      |   Available = 15
                Luxury         |    Rs.7000      |   Available = 15
                ________________________________________________________
                
                Now enter the type of room you want:""");

    }

    public void room_type() {
        Scanner input = new Scanner(System.in);
        String type = input.next();
        switch (type.toLowerCase()) {
            case "king" -> {
                System.out.println("Cost per room per day = Rs.5000");
                System.out.println("Enter Number of rooms you want:");
                int no = input.nextInt();
                if (no >= 15) {
                    System.out.println("Rooms Not available. Enter again.");
                    no = input.nextInt();
                    this.no_of_rooms = no;
                    total_rooms_king = total_rooms_king - no_of_rooms;
                    double cost_per_room = 5000;
                    this.type_of_room = type;
                    cost = cost_per_room * no_of_rooms;
                } else {
                    this.no_of_rooms = no;
                    total_rooms_king = total_rooms_king - no_of_rooms;
                    double cost_per_room = 5000;
                    this.type_of_room = type;
                    cost = cost_per_room * no_of_rooms;
                }
            }
            case "queen" -> {

                System.out.println("Cost per room per day = Rs.3000");
                System.out.println("Enter Number of rooms you want:");
                int no = input.nextInt();
                if (no >= 15) {
                    System.out.println("Rooms Not availaible. Enter again.");
                    no = input.nextInt();
                    this.no_of_rooms = no;
                    total_rooms_queen = total_rooms_queen - no;
                    double cost_per_room = 3000;
                    this.type_of_room = type;
                    cost = cost_per_room * no_of_rooms;
                } else {
                    this.no_of_rooms = no;
                    total_rooms_queen = total_rooms_queen - no;
                    double cost_per_room = 3000;
                    this.type_of_room = type;
                    cost = cost_per_room * no_of_rooms;
                }
            }
            case "luxury" -> {
                System.out.println("Cost per room per day = Rs.7000");
                System.out.println("Enter the number of rooms you want");
                int no = input.nextInt();
                if (no >= 15) {
                    System.out.println("Rooms Not availaible. Enter again.");
                    no = input.nextInt();
                    this.no_of_rooms = no;
                    total_rooms_luxury = total_rooms_luxury - no;
                    double cost_per_room = 7000;
                    this.type_of_room = type;
                    cost = cost_per_room * no_of_rooms;
                } else {
                    this.no_of_rooms = no;
                    total_rooms_luxury = total_rooms_luxury - no;
                    double cost_per_room = 7000;
                    this.type_of_room = type;
                    cost = cost_per_room * no_of_rooms;
                }
            }
            default -> {
                System.out.println("Invalid Option Entered. You can only select \"King\" , \"Queen\" or \"Luxury\"");
                type_of_room=null;
            }
        }
    }

    public String getType_of_room() {
        return type_of_room;
    }

    public int getNo_of_days() {
        return no_of_days;
    }

    public void setNo_of_rooms(int no_of_rooms) {
        this.no_of_rooms = no_of_rooms;
    }

    public void setNo_of_days(int no_of_days) {
        this.no_of_days = no_of_days;
    }

    public String toString(){
        return super.toString() +
                "\nStaying Facility:" +
                "\nNumber of rooms: " + no_of_rooms+
                "\nType  of rooms: " + getType_of_room() +
                "\nNumber of Days: " + getNo_of_days() +
                "\nStaying Cost: " + cost();
    }
}

public class Hotel {
    public static void main(String[] args) {
        System.out.println("--------------------\"WELCOME TO RELAX INN\"-----------------------");
        Scanner input = new Scanner(System.in);
        System.out.println("PERSONAL INFORMATION:");
        System.out.println("Name: ");
        String name  = input.nextLine();
        System.out.println("Email Address: ");
        String email = input.nextLine();
        System.out.println("Phone Number (+92xxxxxxxxxx): ");
        String phone = input.nextLine();
        Random r = new Random();
        int cos_id = r.nextInt(500);
        customer_details user = new customer_details(name,phone,email,cos_id);
        serviceavailable s1 = new serviceavailable();
        s1.display();
        int service1 = input.nextInt();
        String check1 = s1.getservice(service1);
        Dine_in user1 = new Dine_in();
        Staying user2 = new Staying();
        if (check1.equalsIgnoreCase("dine-in")){
            user1.setLocation();
            user1.setMeal_type();
            int check2;
            user1.food();
            System.out.println("---------RECEIPT--------");
            System.out.println(user);
            System.out.println(user1);
        }
        if  (check1.equalsIgnoreCase("stay-in")){
            user2.displayrooms();
            do {
                user2.room_type();
            }while (user2.getType_of_room()==null);
            user2.setNo_of_days();

            System.out.println("---------RECEIPT--------");
            System.out.println(user);
            System.out.println(user2);
        }
        if (check1.equalsIgnoreCase("both")){
            user2.setLocation();
            user2.foodorder();
            user2.displayrooms();
            do {
                user2.room_type();
            }while (user2.getType_of_room()==null);
            user2.setNo_of_days();
            System.out.println("---------RECEIPT--------");
            System.out.println(user);
            System.out.println(user2);
        }
        System.out.println("---Thank you for choosing RELAX INN---");
    }
}









