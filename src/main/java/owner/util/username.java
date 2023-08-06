package owner.util;

//import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonArray;

import java.util.Scanner;

import static owner.util.Tenant.scanner;


public class username {
	

	 
public static void main(String []args) {
    while (true) {
        User us = new User();


        Scanner first = new Scanner(System.in);
        System.out.print("Enter username: ");
        us.username = first.nextLine();

        System.out.print("Enter password :");
        us.password = first.nextLine();
        us.login(us.username, us.password);


        System.out.print("Do you want to continue? (yes/no): ");
        String answer = scanner.nextLine().toLowerCase();
        if (answer.equals("no")) {
            break;
        }
    }
}
}


