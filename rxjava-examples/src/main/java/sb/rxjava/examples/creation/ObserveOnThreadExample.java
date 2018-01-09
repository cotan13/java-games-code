package sb.rxjava.examples.creation;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;
import sb.rxjava.examples.util.DataGenerator;
import sb.rxjava.examples.util.ThreadUtils;

import java.util.List;

/**
 * Creating an Observable that does not specify a subscribeOn or an observeOn Scheduler
 * Created by cotan on 07/01/2018.
 */
public class ObserveOnThreadExample {


    public static void main(String[] args) {

        //to be sure the treatment will completed before System.exi(0)
        Object synchroObject = new Object();
        synchronized (synchroObject) {

            String currentThreadName = Thread.currentThread().getName();
            System.out.println("CurrentThreadName = [" + currentThreadName + "]");

            //the list
            List<Integer> events = DataGenerator.generateFibonacciList();

            //Wrap the list in an observable
            Observable<Integer> observable = Observable.from(events);

            // custom the observable
            observable
                    //use the io scheduler
                    .observeOn(Schedulers.io())
                    .subscribe(
                            //onNext
                            (event) -> {
                                System.out.println("[begin][" + currentThreadName + "]");
                                System.out.println("event = [" + event + "]");
                                System.out.println("[end][" + currentThreadName + "]");
                                System.out.println();
                            },//OnError
                            (t) -> {
                                t.printStackTrace();
                            },//OnComplete
                            () -> {
                                System.out.println("Complete !!!");
                                //as we finiched, we can wake up the waiting thread ( main)
                                synchronized (synchroObject) {
                                    synchroObject.notify();
                                }
                            }
                    );
            ThreadUtils.wait(synchroObject);
        }

        System.exit(0);
    }
}
