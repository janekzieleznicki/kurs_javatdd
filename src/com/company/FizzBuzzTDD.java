package com.company;

class FizzBuzzTDD {
//    static final int FIZZ = 3;
//    static final int BUZZ = 5;
//    static final String BUZZ_STRING = "BUZZ";
//    static final String FIZZ_STRING = "FIZZ";


    enum NazwyFizzBuzz{
        FIZZ(3), BUZZ(5);

        int nr;
        String nazwa;
        NazwyFizzBuzz(int nr){
            this.nr = nr;
            this.nazwa = this.name();
            nazwa = nazwa.substring(0,1)+nazwa.substring(1).toLowerCase();
            System.out.println(nazwa);
        }

        @Override
        public String toString() {
            return this.nazwa;
        }
    }
    static boolean isFizz(int nr) {
        return nr % NazwyFizzBuzz.FIZZ.nr == 0;
    }

    static boolean isBuzz(int nr) {
        return nr% NazwyFizzBuzz.BUZZ.nr ==0;
    }

    String numer(int nr) {
        if (nr == 0) return "0";
        else if (isFizz(nr) && isBuzz(nr)) return NazwyFizzBuzz.FIZZ.toString()+NazwyFizzBuzz.BUZZ.toString();
        else if (isFizz(nr)) return NazwyFizzBuzz.FIZZ.toString();
        else if (isBuzz(nr)) return NazwyFizzBuzz.BUZZ.toString();
        else return Integer.toString(nr);
    }
}
