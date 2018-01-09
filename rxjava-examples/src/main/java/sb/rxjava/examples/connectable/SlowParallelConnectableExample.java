package sb.rxjava.examples.connectable;

import rx.observables.ConnectableObservable;
import rx.schedulers.Schedulers;
import sb.rxjava.examples.util.ThreadUtils;
import sb.rxjava.examples.util.TimeTicker;

/**
 * Created by cotan on 08/01/2018.
 */
public class SlowParallelConnectableExample {

    public static void main(String[] args) {


        // TimeTicker is a class that generates an event every
        // 100 milliseonds.  The event is a Long that represents
        // the current value of System.currentTimeMillis()
        TimeTicker ticker = new TimeTicker(500);
        ticker.start();


        //Create a connectable observabe by applying of publish method
        ConnectableObservable<Long> connectable = ticker.toObservable().publish();

        //create the first subscription
        connectable
                //run on the different thread
                .observeOn(Schedulers.computation())
                .subscribe((t) -> {
                    System.out.println("Tick 1 = [" + ThreadUtils.currentThreadName() + "], event = [" + t +"]");
                });

        //create the second subscription
        connectable
                .observeOn(Schedulers.computation())
                .subscribe((t) -> {
                    System.out.println("Tick 2 = [" + ThreadUtils.currentThreadName() + "], event = [" + t +"]");
                    ThreadUtils.sleep(1000);
                });


        //wait for 3 sec
        ThreadUtils.sleep(3000);

        //Connect to the conncetable observable
        System.out.println("Connecting ...");
        connectable.connect();

        //3 sec of ticker working
        ThreadUtils.sleep(5000);
        ticker.stop();

        //wait for an other 5 sec to catch up
        ThreadUtils.sleep(5000);
        System.exit(0);

    }
}
