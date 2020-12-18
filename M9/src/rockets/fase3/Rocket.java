package rockets.fase3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Rocket {

    private String rocketId;
    private List<Engine> engines;
    private CountDownLatch doneSignal = null;

    public Rocket(String rocketId) throws Exception {
        if (rocketId.length() != 8) throw new Exception("Rocket Id must have 8 characters");

        this.rocketId = rocketId;
        this.engines = new ArrayList<>();
    }
    
    public String getRocketId() {
        return rocketId;
    }
    
    public void addEngine(String name, int maxPower) throws Exception {
        engines.add(new Engine(name, maxPower));
    }
    
    public int getNumberOfEngines() {
        return engines.size();
    }
    
    public void printAct(String act) {
        System.out.println("\nRocket " + rocketId + " " + act);
    }
    
    public synchronized void speedUp() {
        printAct("Speeds Up");
        runPropellers(RocketAct.SPEEDUP);
    }

    public synchronized void slowDown() {
        printAct("Slows Down");
        runPropellers(RocketAct.SLOWDOWN);
    }
    
    public void runPropellers(RocketAct action) {
        doneSignal = new CountDownLatch(getNumberOfEngines());
        for (Engine engine : engines) {
            engine.setAct(action);
            Engine t = engine.clone();
            t.setSignal(doneSignal);
            t.start();
        }
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            wait(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        int i = 0;
        StringBuilder sb = new StringBuilder()
                .append("Id = ").append(rocketId)
                .append(", Number of engines = ").append(getNumberOfEngines())
                .append(", Engines maximum power = ");
        for (i = 0; i < getNumberOfEngines(); i++) {
            sb.append(engines.get(i).getMaxPower() + " ");
        }
        return sb.toString();
    }
}