package algoriWeek2;

import java.util.Arrays;

public class MyArrayList {

	int maxSize = 20;
	int [] array = new int [maxSize];
	int nOfItems = 0;
	
	public void add(int data) {  // add last
		if (nOfItems >= maxSize) {
			grow();
		}
		
		array[nOfItems++]=data;
	}
	
	private void grow() {
		int [] newArray = new int [maxSize*2];
		for (int i=0;i<nOfItems; i++)
			newArray[i]=array[i];
		array=newArray;
		maxSize *=2;
	}

	public void add(int index, int data) {
		if (nOfItems >=maxSize) {
			grow();
		}
		
		if (index <0 || index>nOfItems) {
			System.out.println("Invalid Index !");
			return;
		}
		
		for (int i=nOfItems-1; i>=index; i--)
			array[i+1]=array[i];
		
		array[index] = data;
		nOfItems++;
	}
	
	public int removeIndex(int index) { // return value
		if (index < 0 || index >= nOfItems) {
			System.out.println("Invalid Index !");
			return -1;
		}
		
		int removedElement = array[index];
		for (int i = index; i < nOfItems - 1; i++)
			array[i] = array[i + 1];
		
		nOfItems--;
		
		return removedElement;
	}
	
	public int removeData(int data) { // return index
		int index = indexOf(data);
		if (index == -1) {
			System.out.println("Data not found !");
			return -1;
		}
		
		for (int i = index; i < nOfItems - 1; i++)
			array[i] = array[i + 1];
		
		nOfItems--;
		
		return index;
	}

	public int get(int index) { // return value
		if (index < 0 || index >= nOfItems) {
			System.out.println("Invalid Index !");
			return -1;
		}
		return array[index];
	}
	
	public void set(int index, int data) {
		if (index < 0 || index >= nOfItems) {
			System.out.println("Invalid Index !");
			return;
		}
		array[index] = data;
	}
	
	public int indexOf(int data) {  // return index, if not found, return -1
		for (int i = 0; i < nOfItems; i++) {
			if (array[i] == data)
				return i;
		}
		return -1;
	}
	
	public int size() {
		return nOfItems;
	}
	
	public void showArray() {
		System.out.println("Array Contents:");
		for (int i = 0; i < nOfItems; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int [] data = {113,  336,  74,  71,  86,  176,  313,  80,  225,  342,
				  170,  292,  275,  266 , 79,  16,  109,  175 , 245,  156,
				  50,  61,  277,  167,  81,  24,  76,  186,  78,  101,
				  301,  62,  152,  219,  294};

		MyArrayList al = new MyArrayList();
		
		for (int i=0; i<10; i++)
			al.add(data[i]);
		al.showArray();
		
		al.add(5, 100);
		al.showArray();
		
		System.out.println("Index of 100: " + al.indexOf(100));
		
		System.out.println("Removed element at index 2: " + al.removeIndex(2));
		al.showArray();
		
		System.out.println("Removed element with data 100 at index: " + al.removeData(100));
		al.showArray();
		
		System.out.println("Element at index 3: " + al.get(3));
		
		al.set(3, 999);
		System.out.println("Array after setting element at index 3 to 999:");
		al.showArray();
	}
}
