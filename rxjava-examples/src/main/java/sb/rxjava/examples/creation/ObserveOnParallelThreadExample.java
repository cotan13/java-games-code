package sb.rxjava.examples.creation;

import rx.Observable;
import rx.schedulers.Schedulers;
import sb.rxjava.examples.util.DataGenerator;
import sb.rxjava.examples.util.ThreadUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Creating an Observable that does not specify a subscribeOn or an observeOn Scheduler
 * Created by cotan on 07/01/2018.
 */
public class ObserveOnParallelThreadExample {


    public static void main(String[] args) {

        //to be sure the treatment will completed before System.exi(0)
        Object synchroObject = new Object();
        synchronized (synchroObject) {

            String currentThreadName = Thread.currentThread().getName();
            System.out.println("CurrentThreadName = [" + currentThreadName + "]");
            AtomicInteger count = new AtomicInteger(0);
            //the list
            List<Integer> events = DataGenerator.generateFibonacciList();

            //Wrap the list in an observable
            Observable<Integer> observable = Observable.from(events);

            // custom the observable
            observable
                    // We want the subscriber driving code on a new thread.
                    .observeOn(Schedulers.newThread())
                    .parallel((a) ->
                            {

                                return a.filter((i) -> i % 2 == 0)
                                        .doOnNext((evt) -> {
                                            int c = count.incrementAndGet();
                                            System.out.println("[parallel.in][" + c + "][" + currentThreadName + "]");
                                            System.out.println("parallel.event = [" + evt + "]");
                                            ThreadUtils.sleep(10);
                                            System.out.println("[parallel.out][" + c + "][" + currentThreadName + "]");
                                            System.out.println();
                                        });

                            },
                            Schedulers.io())
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
