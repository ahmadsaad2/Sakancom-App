package owner.util;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class username {

    private static final Logger logger = Logger.getLogger(username.class.getName());

    public static void main(String[] args) {
        while (true) {
            User us = new User();

            Scanner first = new Scanner(System.in);
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
