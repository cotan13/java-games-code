package sb.rxjava.examples.eventdriven.impl2.domaine.email;

import java.util.List;

/**
 * Created by cotan on 08/01/2018.
 */
public class EmailServiceImpl implements EmailService {
    @Override
    public void sendEmail(List<String> dest, String from, String subject, String body) {

        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println("Sending Email");
        System.out.println("--------------------------------------------------------------");

        System.out.print("To     : ");
        for (String nextEmail : dest) {
            System.out.print(nextEmail);
            System.out.print("; ");
        }
        System.out.println();

        System.out.println("From   : " + from);
        System.out.println("Subject: " + subject);
        System.out.println("Text   : ");
        System.out.println();
        System.out.print(body);
        System.out.println();

        System.out.println("--------------------------------------------------------------");
    }
}
