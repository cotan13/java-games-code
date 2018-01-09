package sb.rxjava.examples.eventdriven.impl2.domaine.user;

import java.util.Date;

/**
 * Created by cotan on 08/01/2018.
 */
public class UserEvent {

    private String userName;
    private String emailAddress;
    private Date eventDate;

    public UserEvent(String userName, String emailAddress) {
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.eventDate = new Date();
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Date getEventDate() {
        return eventDate;
    }
}
