package sb.rxjava.examples.eventdriven.impl2.domaine.user;

/**
 * Created by cotan on 08/01/2018.
 */
public class CreateUserEvent extends UserEvent {
    public CreateUserEvent(String name, String email) {
        super(name, email);
    }
}
