package semester1.Homework.practice02.homework;

public class Task1CurrencyExchange {
    static void main (String [] args) {
        double usdAmount = 250.0;
        final double EXCHANGE_RATE = 41.25;
        final double COMMISSION_PERCENT = 1.5;

        double sumaGrn = usdAmount * EXCHANGE_RATE;
        double commission = sumaGrn * COMMISSION_PERCENT/100 ;
        double chystaSuma = sumaGrn - commission;
        long doVydachi =  Math.round(chystaSuma);

        System.out.println("================ КВИТАНЦІЯ ОБМІНУ ================");
        System.out.println("Сума до обміну:                  "+usdAmount+" USD");
        System.out.println("Курс валют:                      "+EXCHANGE_RATE+" UAH/USD");
        System.out.println("Нараховано до комісії:           "+sumaGrn+" UAN");
        System.out.println("Комісія банку : (" + COMMISSION_PERCENT +"%):          " + commission + " UAH");
        System.out.println("--------------------------------------------------");
        System.out.println("Чиста сума до видачі:            "+doVydachi+" UAN" );
        System.out.println("До видачі готівкою:              "+doVydachi+" UAN");



    }
}
