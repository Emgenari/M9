package rockets.fase2;

public class Main {

    public static void main(String[] args) {

        Rocket rocket1 = null;
        Rocket rocket2 = null;
        int[] rocket1Engines = {10, 30, 80};
        int[] rocket2Engines = {30, 40, 50, 50, 30, 10};

        try {
			rocket1 = new Rocket("32WESSDS");
				for (int i = 0; i < rocket1Engines.length; i++) {
					rocket1.addEngine(rocket1Engines[i]);
				}
			rocket2 = new Rocket("LDSFJA32");
				for (int i = 0; i < rocket2Engines.length; i++) {
					rocket2.addEngine(rocket2Engines[i]);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}

        System.out.println("Rocket 1: " + rocket1.toString());
        System.out.println("Rocket 2: " + rocket2.toString());
    }
}