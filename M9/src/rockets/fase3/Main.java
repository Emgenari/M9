package rockets.fase3;

public class Main {

    public static void main(String[] args) {

        Rocket rocket1 = null;
        Rocket rocket2 = null;
        int[] rocket1Engines = {10, 30, 80};
        int[] rocket2Engines = {30, 40, 50, 50, 30, 10};
        int i = 0;

        try {
            rocket1 = new Rocket("32WESSDS");
            for (i = 0; i < rocket1Engines.length; i++) {
                rocket1.addEngine("Engine " + (i+1) + " " + rocket1.getRocketId(), rocket1Engines[i]);
            }
            rocket2 = new Rocket("LDSFJA32");
            for (i = 0; i < rocket2Engines.length; i++) {
                rocket2.addEngine("Engine " + (i+1) + " " + rocket2.getRocketId(), rocket2Engines[i]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Rocket 1: " + rocket1.toString());
        System.out.println("Rocket 2: " + rocket2.toString());

        //Speed Up both rockets
        for (i = 0; i < 2; i++) {
            rocket1.speedUp();
            rocket2.speedUp();
        }
        //Speed Up x Slow Down
        for (i = 0; i < 1; i++) {
            rocket1.slowDown();
            rocket2.speedUp();
        }
        //Speed Up one rocket
        for (i = 0; i < 2; i++) {
            rocket2.speedUp();
        }
        //Speed Up
        for (i = 0; i < 8; i++) {
            rocket1.speedUp();
            rocket2.speedUp();
        }
    }
}