package resources.sortingballs;

public class BallList{

	private int size=0;
	private Ball[] balls;

	public BallList(){
		balls = new Ball[size];
	}
	
	public void addBall(Ball vball){
			Ball[] auxArray = new Ball[size+1];
			
			for(int i=0;i<balls.length;i++){
				auxArray[i] = balls[i];
			}
			auxArray[size] = vball;
			
			quicksortArray(auxArray,0,auxArray.length-1);
			setBalls(auxArray);
			size++;
	}

	public boolean containsBall(Ball vball){	
		for(Ball ball: getBalls()){
			if(ball.getNumber() == vball.getNumber()){
				return true;
			}
		}
		return false;
	}
	
	public void printBallsArray(){
		for(Ball ball: getBalls()){
			System.out.println(ball.getNumber());
		}
	}
	
	//quicksort algorithm
	private void quicksortArray(Ball[] array,int low, int high){
		
		if (array == null || array.length == 0)
			return;
 
		if (low >= high)
			return;

		//partition
		int middle = low + (high - low) / 2;
		int pivot = array[middle].getNumber();

		int i = low; 
		int j = high;

		while (i <= j) {
			while (array[i].getNumber() < pivot) {
				i++;
			}
			while (array[j].getNumber() > pivot) {
				j--;
			}
			if (i <= j) {
				Ball temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}

		if (low < j)
			quicksortArray(array,low, j);

		if (high > i)
			quicksortArray(array,i, high);		
	}
	
	public Ball[] getBalls() {
		return balls;
	}
	
	private void setBalls(Ball[] balls) {
		this.balls = balls;
	}

}
