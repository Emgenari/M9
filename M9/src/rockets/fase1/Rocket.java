package rockets.fase1;

public class Rocket {
	
	private String rocketId;
	private int numberOfEngines;
	
	public Rocket (String rocketId, int numberOfEngines) throws Exception {
		if (rocketId.length() != 8) { 
			throw new Exception("Rocket Id must have 8 characters");
			}	
		
		this.rocketId = rocketId;
		this.numberOfEngines = numberOfEngines;			
	}

	public String getRocketId() {
		return rocketId;
	}
	
	public int getNumberOfEngines() {
		return numberOfEngines;
	}

	public void setNumberOfEngines(int numberOfEngines) {
		this.numberOfEngines = numberOfEngines;
	}

	@Override
	public String toString() {
		return "Rocket [rocketId=" + rocketId + ", numberOfEngines=" + numberOfEngines + "]";
	}
}