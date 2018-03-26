//The import statement may be needed for other implementation of getPosition()
//import java.util.Arrays;

public class MarsRoverOperation {
	/**
	 * Accepts a command-line argument such as "LFFFRFFFRRFFF"
	 * where "L" => rotate 90 degrees left
	 *  	 "R" => rotate 90 degrees right
	 *    	 "F" => move forward one unit
	 *
	 * Method should print the appropriate and correct final position
	 * of the robot.
	 *
	 * Example:
	 * 		 For input "FFRF", the result should be [1,2].
	 */
		int x = 0;
		int y = 0;
		char face = 'N';
		
		public void operate(char command) {
			if (command == 'L') {
				turnLeft();
			}else if (command == 'R') {
				turnRight();
			}else move();
		}
		
		public void turnLeft(){
			if (this.face =='N') {
				this.face = 'W';
			} else if (this.face =='S') {
				this.face = 'E';
			} else if (this.face == 'E') {
				this.face = 'N';
			} else if (this.face == 'W') {
				this.face = 'S';
			}
		}
		
		public void turnRight(){
			if (this.face =='N') {
				this.face = 'E';
			} else if (this.face =='S') {
				this.face = 'W';
			} else if (this.face == 'E') {
				this.face = 'S';
			} else if (this.face == 'W') {
				this.face = 'N';
			}
		}
		
		public void move() {
			if (this.face == 'E') this.x++;
			if (this.face == 'N') this.y++;
			if (this.face == 'W') this.x--;
			if (this.face == 'S') this.y--;
		}
		
		public void getPosition() {
			//This will take more memory
			//int[] position = {this.x,this.y};
			//System.out.println(Arrays.toString(position));
			
			//No new memory, just prints the result
			System.out.println("[" + this.x + "," +this.y + "]");
		}
	
	public static void main(String argv[]) {
		char[] directions = argv[0].toCharArray();
		MarsRoverOperation MI = new MarsRoverOperation();
		for (char c:directions) {
			MI.operate(c);
		}
		MI.getPosition();
	}
}
