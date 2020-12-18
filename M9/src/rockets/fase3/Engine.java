package rockets.fase3;

import java.util.concurrent.CountDownLatch;

public class Engine extends Thread {

    private int maxPower;
    private int currentPower;
    private RocketAct act;
    private Engine engine = null;
    private CountDownLatch doneSignal = null;

    public Engine(String name, int maxPower) throws Exception {
        super(name);
        if (maxPower <= 0) throw new Exception("Maximum power must be bigger then 0");

        this.maxPower = maxPower;
        this.currentPower = 0;
    }

    public Engine(Engine engine) {
        super(engine.getName());
        this.engine = engine;
        this.maxPower = engine.getMaxPower();
        this.currentPower = engine.getCurrentPower();
        this.act = engine.getAct();
    }
    
    public int getMaxPower() {
        return maxPower;
    }

    public int getCurrentPower() {
        return currentPower;
    }
    
    public void setCurrentPower(int currentPower) {
        if (Math.abs(currentPower) <= maxPower) {
            this.currentPower = currentPower;
        }
    }
    
    public RocketAct getAct() {
        return act;
    }

    public void setAct(RocketAct act) {
        this.act = act;
    }
    
    public void setSignal(CountDownLatch doneSignal) {
        this.doneSignal = doneSignal;
    }
    
    public void morePower() {
        engine.setCurrentPower(currentPower + 10);
    }

    public void lessPower() {
        engine.setCurrentPower(currentPower - 10);
    }
 
    @Override
    public Engine clone() {
        return new Engine(this);
    }
    
    @Override
    public void run() {
        if (act.equals(RocketAct.SPEEDUP)) {
            morePower();
        } else if (act.equals(RocketAct.SLOWDOWN)) {
            lessPower();
        }
        System.out.println(engine.getName() + " Current power " + engine.getCurrentPower() + " of " + engine.getMaxPower());
        doneSignal.countDown();
    }  
}