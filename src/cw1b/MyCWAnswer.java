package cw1b;

public class MyCWAnswer extends BaseClass{
	
	PGPText noises = new PGPText();
	PGPText movement = new PGPText();
	
	@Override
	public void createAnimals() {
		
		storeAnimal(new Fish());
		storeAnimal(new Bear());
		storeAnimal(new Lion());
		storeAnimal(new Bird());
		
	}
	
	@Override
	public void recordMadeSound(String str) {
		System.out.println(str);
		noises.addLine(str);
	}
	
	@Override
	public void recordMoved(String str) {
		System.out.println(str);
		movement.addLine(str);
	}
	
	@Override
	public void finish() {
		
		int noisesMade = noises.getLineCount();
		int movementsMade = movement.getLineCount();
		
		PGPFile outputFile = new PGPFile();
		
		outputFile.openWriteFile("output.txt");
		outputFile.writeLine("List of noises made:");
		for (int i = 0; i < noisesMade; i++) {
			outputFile.writeLine(noises.getLine(i));
		}
		outputFile.writeLine("List of movement made:");
		for (int i = 0; i < movementsMade; i++) {
			outputFile.writeLine(movement.getLine(i));
		}
		
		outputFile.closeWriteFile();
	}
	
	
	

}
