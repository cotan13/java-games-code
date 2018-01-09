package sb.rxjava.examples.transforation;

import rx.Observable;
import sb.rxjava.examples.util.DataGenerator;

public class ScanExample {

    public static void main(String[] args) {

        Observable.from(DataGenerator.generateGreekAlphabet())
                .scan(new StringBuilder(), (accumBuffer, nextLetter) -> {

                    return accumBuffer.append(nextLetter);
                })
                .subscribe((total) -> {
                    System.out.println("Scan Event: " + total.toString());
                });

        System.out.println("--------------------------------------------------");
       
        Observable.from(DataGenerator.generateGreekAlphabet())
                .scan(new StringBuilder(), (accumBuffer, nextLetter) -> {

                    return accumBuffer.append(nextLetter);
                })
                .last()
                .subscribe((total) -> {
                    System.out.println("Scan Event: " + total.toString());
                });

        System.out.println("--------------------------------------------------");

        System.exit(0);
    }
}
