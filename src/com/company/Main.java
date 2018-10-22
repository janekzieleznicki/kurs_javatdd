package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Kod na efektach ubocznych
        Scanner s = new Scanner(System.in);
        final int num = s.nextInt();
        String out = magicznaMetoda(num);
        if(out.isEmpty())
            System.out.println(num);
        else
            System.out.println(out);
    }

    private static String magicznaMetoda(int num) {
        String out = "";
        if (num%3 == 0)
            out+="fizz";
        if(num%5 == 0)
            out+="buzz";
        return out;
    }

    class FizzBuzzPoProstuTest{
        void dla0zwraca0(){
            Main klasa = new Main();
            assert klasa.magicznaMetoda(0).equals("fizz");
        }
        public void main(String[] strings){

        }
    }
}
