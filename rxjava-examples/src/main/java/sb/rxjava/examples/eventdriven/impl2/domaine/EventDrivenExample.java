package sb.rxjava.examples.eventdriven.impl2.domaine;


import sb.rxjava.examples.eventdriven.impl2.domaine.email.EmailService;
import sb.rxjava.examples.eventdriven.impl2.domaine.email.EmailServiceImpl;
import sb.rxjava.examples.eventdriven.impl2.domaine.monitor.EmailMonitor;
import sb.rxjava.examples.eventdriven.impl2.domaine.user.UserService;
import sb.rxjava.examples.eventdriven.impl2.domaine.user.UserServiceImpl;
import sb.rxjava.examples.util.ThreadUtils;

/**
 * Created by cotan on 08/01/2018.
 */
public class EventDrivenExample {

    public static void main(String[] args) {


        //create a user service
        UserService userService = new UserServiceImpl();

        //
        EmailService emailService = new EmailServiceImpl();

        // Create an EmailMonitor...no need to track a reference.
        new EmailMonitor(emailService, userService);

        userService.addUser("said", "toto@titi.com");

        ThreadUtils.sleep(2000);

        System.exit(0);

    }
}
