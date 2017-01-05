package resources.spellsitout;

public class NumberWord {
	
	private int number;
	private int minValue = 0;
	private int maxValue = 1000000000;
	
	private NumberTranslation numberTranslation;
	
	public NumberWord(int number){
		this.number=number;
		numberTranslation = new NumberTranslation();
	}
	
	public boolean isValidNumber(){
		if(number >= minValue && number<= maxValue){
			return true;
		}
		return false;
	}
	
	public String getTranslation(){
		if(isValidNumber()){
			return numberTranslation.translateNumbers(number);
		}
		return null;
	}

	public int getNumber() {
		return number;
	}
}
