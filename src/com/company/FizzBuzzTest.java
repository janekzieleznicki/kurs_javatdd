package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class FizzBuzzTest {

    private final FizzBuzzTDD fbt;
    private static List<String> bledy;
//TODO: zrobic podzial na klase testowa i klase do odpalania testow
    private FizzBuzzTest() {
        fbt = new FizzBuzzTDD();
        bledy = new LinkedList<>();
    }

    private void fbtAssert(int nr, String expected){
        assert fbt.numer(nr).equals(expected): String.format("dla %d nie zwraca %s",nr, expected);
    }

    private void odpalTest(int i, String s) {
        try {
            fbtAssert(i, s);
        } catch (AssertionError assertionError) {
            bledy.add(assertionError.getLocalizedMessage()+"\n");
        }
    }

    public static void main(String[] args){
        final FizzBuzzTest fizzBuzzTest = new FizzBuzzTest();
        fizzBuzzTest.odpalTest(0, "0");
        fizzBuzzTest.odpalTest(1, "1");
        fizzBuzzTest.odpalTest(2, "2");
        int[] fizzes = new int[]{3, 6, 9, 12, 18};
        for(int x : fizzes)
            fizzBuzzTest.odpalTest(x, "Fizz");

        int[] buzzes = new int[]{5, 10, 20, 25, 35};
        for (int x : buzzes)
            fizzBuzzTest.odpalTest(x,"Buzz");

        int[] fizzbuzzes = new int[]{15, 30, 45, 60, 75};
        for (int x : fizzbuzzes)
            fizzBuzzTest.odpalTest(x,"FizzBuzz");

        int[] numbers = new int[]{0,1,2,4,7,8,11};
        for (int x : numbers) {
            fizzBuzzTest.odpalTest(x,Integer.toString(x));
        }
        fizzBuzzTest.odpalTest(15,"FizzBuzz");
        fizzBuzzTest.odpalTest(16,"16");

        final Random random = new Random();
        for (int i =0; i<1000; i++) {
            int losowy = random.nextInt();
            if(FizzBuzzTDD.isFizz(losowy)&& FizzBuzzTDD.isBuzz(losowy))
                fizzBuzzTest.odpalTest(losowy, "FizzBuzz");
            else if(FizzBuzzTDD.isFizz(losowy))
                fizzBuzzTest.odpalTest(losowy, "Fizz");
            else if(FizzBuzzTDD.isBuzz(losowy))
                fizzBuzzTest.odpalTest(losowy, "Buzz");
            else
                fizzBuzzTest.odpalTest(losowy, Integer.toString(losowy));
        }
        //FIXME: podzielne przez 3 ale nie przez 5
        //FIXME: podzielne przez 5 ale nie przez 3
        //FIXME: podzielne przez 5 ORAZ przez 3

        System.out.println(
                !bledy.isEmpty() ? bledy : "bez bledow"
        );
    }
}
