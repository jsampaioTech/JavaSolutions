package resources.sortingballs;

public class Ball {
	
	private int number;
	private int minValue = 0;
	private int maxValue = 60;
	
	public Ball(int number){
		this.number=number;
	}
	
	public int getNumber() {
		return number;
	}
	
	public boolean isValidNumber(int n){
		if(n>=minValue && n<maxValue){
			return true;
		}
		return false;
	}
}
