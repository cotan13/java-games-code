package sb.rxjava.examples.subject;

import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
import sb.rxjava.examples.util.DataGenerator;
import sb.rxjava.examples.util.ThreadUtils;

/**
 * Created by cotan on 08/01/2018.
 */
public class PublishSubjectExample {

    public static void main(String[] args) {


        Object signal = new Object();
        synchronized (signal) {

            //create the subject from factory method create,
            //The subscribers will see the events happen after subcribe
            PublishSubject<Object> publishSubject = PublishSubject.create();


            //subscribe to this subject
            publishSubject
                    .subscribe((e) -> {
                        System.out.println("Subscriber 1 : " + e);

                        ThreadUtils.sleep(500);
                        if ("Eta".equals(e)) {
                            synchronized (signal) {
                                signal.notify();
                            }
                        }
                    });

            // Next we create an observable out of the greek alphabet...
            // For each letter, we will publish an event to the PublishSubject
            Observable
                    .from(DataGenerator.generateGreekAlphabet())
                    .subscribeOn(Schedulers.computation())
                    .subscribe(
                            //OnNext
                            (e) -> {
                                // ...for each letter, we will emit an event to the subject
                                publishSubject.onNext(e);

                            },
                            //OnError
                            (t) -> {
                                publishSubject.onError(t);
                            },
                            //onComplete
                            () -> {
                                System.out.println("Subscriber 1: onCompleted");
                                publishSubject.onCompleted();
                                synchronized (signal){
                                    signal.notify();
                                }
                            }
                    );
            ThreadUtils.wait(signal);

            publishSubject.subscribe((e) -> {System.out.println("Subscriber 2: event : " + e);},
                    (t) -> {t.printStackTrace();},
                    () -> {System.out.println("Subscriber 2: onCompleted");});

            ThreadUtils.wait(signal);
        }

        System.exit(0);
    }
}
