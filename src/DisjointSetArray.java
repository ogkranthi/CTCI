
public class DisjointSetArray {
	int[] array;
	
	DisjointSetArray(int size){
		array = new int[size];
		for (int i=0;i<size;i++) {
			array[i] = -1;
		}
	}
	
	//Finds the name of the set containing element
	public int findSet(int element) {
		for (int i=0;i<this.array.length;i++) {
			if (this.array[element] < 0) return element;
			else {
				//Path compression to make all elements point to the root along the path
				//array[element] = findSet(array[element]);
				return this.array[element];
			}
		}
		return this.array[element];
	}
	
	public void union(int elem1, int elem2) {
		if (this.array[elem1] < this.array[elem2]) {
			this.array[elem2] = elem1; //elem1 is taller
		} else if (this.array[elem1] == this.array[elem2]){
			this.array[elem1]--; //both equal heights, make one as the root
		} else this.array[elem1] = elem2;
	}
	
	
	public static void main(String args[]) {
		DisjointSetArray graph = new DisjointSetArray(5);
	}
}
