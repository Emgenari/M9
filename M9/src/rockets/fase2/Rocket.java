package rockets.fase2;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

    private String rocketId;
    private List<Engine> engines;
   
    public Rocket(String rocketId) throws Exception {
        if (rocketId.length() != 8) throw new Exception("Rocket Id must have 8 characters");
        this.rocketId = rocketId;
        this.engines = new ArrayList<>();
    }
    
    public String getRocketId() {
        return rocketId;
    }
    
    public void addEngine(int maxPower) {
        engines.add(new Engine(maxPower));
    }
    
    public int getNumberOfEngines() {
        return engines.size();
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