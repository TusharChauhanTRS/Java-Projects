import java.util.Scanner;

public class project {
    public static void main(String[] args) {
        System.out.println("Hello Welcome to the Food App");
        System.out.println("Please create a password: ");
        Scanner sc = new Scanner(System.in);
        String pass1 = sc.next();
        System.out.println("Your Password is now: " + pass1);

        System.out.println("Please enter your password: ");
        String pass = sc.next();

        while (!pass.equals(pass1)) {
            System.out.println("This is not your password please try again: ");
            pass = sc.next();
        }

        System.out.println("Access Granted");
        System.out.println("Are you hungry Yes or No : ");
        String ans1 = sc.next();

        if (ans1.equals("yes")) {
            System.out.println("Choose what you want to eat between Pizza, Burger or Fish");
            String ans2 = sc.next();

            while (!ans2.equals("pizza") && !ans2.equals("burger") && !ans2.equals("fish")) {
                System.out.println("Sorry we do not have it what would you like between pizza, burger or fish ");
                ans2 = sc.next();
            }
            if (ans2.equals("pizza") || ans2.equals("burger") || ans2.equals("fish")) {
                System.out.println("Do you want something to drink? Yes or No :");
                String ans3 = sc.next();

                while (!ans3.equals("yes") && !ans3.equals("no")) {
                    System.out.println("Wrong Command please try again: ");
                    ans3 = sc.next();
                }
                if (ans3.equals("yes")) {
                    System.out.println("What would you like to drink Coffee or Drink? :");
                    String ans4 = sc.next();

                    while (!ans4.equals("coffee") && !ans4.equals("drink")) {
                        System.out.println(
                                "Sorry we don't have it what would you like between cold coffee and cold drink: ");
                        ans4 = sc.next();
                    }
                    if (ans4.equals("coffee") || ans4.equals("drink")) {
                        System.out.println("Great you have ordered " + ans2 + " and " + ans4);
                    }
                    System.out.println("Please confirm your password: ");
                    pass = sc.next();

                    while (!pass.equals(pass1)) {
                        System.out.println("This is not the right password please try again: ");
                        pass = sc.next();
                    }
                    System.out.println("Thank You your order is on it's way");
                } else {
                    System.out.println("You have ordered " + ans2);
                    System.out.println("Please confirm your password: ");
                    pass = sc.next();

                    while (!pass.equals(pass1)) {
                        System.out.println("This is not the right password please try again: ");
                        pass = sc.next();
                     }
                   System.out.println("Thank You your order is on it's way");
                }
            }
        } else {
            System.out.println("Alright have a good day");
        }

    }

}
