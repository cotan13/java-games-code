package sb.rxjava.examples.connectable;

import rx.observables.ConnectableObservable;
import sb.rxjava.examples.util.ThreadUtils;
import sb.rxjava.examples.util.TimeTicker;

/**
 * Created by cotan on 08/01/2018.
 */
public class BasicConnectableExample {

    public static void main(String[] args) {


        // TimeTicker is a class that generates an event every
        // 100 milliseonds.  The event is a Long that represents
        // the current value of System.currentTimeMillis()
        TimeTicker ticker = new TimeTicker(500);
        ticker.start();


        //Create a connectable observabe by applying of publish method
        ConnectableObservable<Long> connectable = ticker.toObservable().publish();

        //create the subscription
        connectable
                .subscribe((t) -> {
                    System.out.println("Tick = [" + ThreadUtils.currentThreadName() + "], event = [" + t +"]");
                });

        //wait for 3 sec
        ThreadUtils.sleep(3000);

        //Connect to the conncetable observable
        System.out.println("Connecting ...");
        connectable.connect();

        //3 sec of ticker working
        ThreadUtils.sleep(3000);
        ticker.stop();

        System.exit(0);

    }
}
