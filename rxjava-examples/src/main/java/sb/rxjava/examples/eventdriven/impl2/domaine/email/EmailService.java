package sb.rxjava.examples.eventdriven.impl2.domaine.email;

import java.util.List;

/**
 * Created by cotan on 08/01/2018.
 */
public interface EmailService {

    void sendEmail(List<String> dest, String from, String sibject, String body);
}
