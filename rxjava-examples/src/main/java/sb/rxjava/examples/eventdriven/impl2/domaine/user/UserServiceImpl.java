package sb.rxjava.examples.eventdriven.impl2.domaine.user;

import rx.Observer;
import rx.subjects.PublishSubject;
import rx.util.functions.Action1;

/**
 * Created by cotan on 08/01/2018.
 */
public class UserServiceImpl implements UserService {

    private PublishSubject<UserEvent> userSubject;

    public UserServiceImpl() {
        this.userSubject = PublishSubject.create();
    }

    @Override
    public void addUser(String name, String email) {
        // Do something interesting that would add a user...
        System.out.println("UserServiceImpl: addUser - " + name + ", " + email);

        // Instantiate a CreateUserEvent
        UserEvent addUserEvent = new CreateUserEvent(name, email);

        // Publish the event to the userEventSubject
        userSubject.onNext(addUserEvent);

        // All done...all we did in this service is worry about creating a user.

    }

    @Override
    public void subscribeToUserEvents(Observer<UserEvent> subscriber) {
        userSubject.subscribe(subscriber );

    }

    @Override
    public void subscribeToUserEvents(Action1<UserEvent> onNext) {
        userSubject.subscribe(onNext);

    }
}
