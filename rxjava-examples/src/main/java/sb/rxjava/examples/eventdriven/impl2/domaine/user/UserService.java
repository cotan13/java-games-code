package sb.rxjava.examples.eventdriven.impl2.domaine.user;

import rx.Observer;
import rx.util.functions.Action1;

/**
 * Created by cotan on 08/01/2018.
 */
public interface UserService {

    void addUser(String name, String email);
    void subscribeToUserEvents(Observer<UserEvent> subscriber);
    void subscribeToUserEvents(Action1<UserEvent> onNext);
}
