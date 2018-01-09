package sb.rxjava.examples.eventdriven.impl2.domaine.monitor;

import sb.rxjava.examples.eventdriven.impl2.domaine.email.EmailService;
import sb.rxjava.examples.eventdriven.impl2.domaine.user.UserEvent;
import sb.rxjava.examples.eventdriven.impl2.domaine.user.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cotan on 08/01/2018.
 */
public class EmailMonitor {

    private final EmailService emailService;

    public EmailMonitor(EmailService emailService, UserService userService) {
        this.emailService = emailService;
        userService.subscribeToUserEvents(this::handleUserEvent);

    }

    private void handleUserEvent(UserEvent userEvent) {
        System.out.println( "EmailMonitorServiceImpl::handleUserEvent - " + Thread.currentThread().getName() );
        List<String> reciept = new ArrayList<>();
        reciept.add(userEvent.getEmailAddress());

        String body = "Hi " + userEvent.getUserName() + ", Welcome to RX-JAVA demo!";
        emailService.sendEmail(reciept, "s.boulalf@gigi.com", "Welcome", body);
    }
}
