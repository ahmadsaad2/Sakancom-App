package owner.util;
import java.util.Scanner;
import java.util.logging.Logger;

public class Username  {
	 static Scanner first = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(Username .class.getName());

    public static void main(String[] args) {
        while (true) {
            User us = new User();
            logger.info("Enter username: ");
            us.username = first.nextLine();

            logger.info("Enter password: ");
            us.password = first.nextLine();
            us.login(us.username, us.password);

            logger.info("Do you want to continue? (yes/no): ");
            String answer = first.nextLine().toLowerCase();
            if (answer.equals("no")) {
                break;
            }
        }
    }
}
