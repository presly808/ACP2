package ua.artcode.week1.home;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Luxsoft task for intern
 * Sort mas of chars and move duplicates to separate mas
 * ex . input :
 *          {'4','1','r','N','2','g','5','1','9','g','5','4'}
 *      output :
 *          sorted=[1, 2, 4, 5, 9, N, g, r]
 *          duplicates=[1, 4, 5, g]
 *
 */
public class Sorter {

	private char[] sorted;
	private char[] duplicates;
	private int end;

    //Here we use selection sort
    public void sortWithNoDuplicates(char[] mas){
    	sorted = mas;
        duplicates = new char[mas.length];
        int counterForDuplicates = 0;
        end = mas.length - 1;


        for(int i = 0; i < end; i++){
            char value = mas[i]; //temp ceil for comparing(selection sort)
            int minI = i; //temp index for comparing(selection sort)

            for(int j = i + 1; j <= end; j++){
                if(mas[j] < value){
                    minI = j; 
                    value = mas[j];
                } else if(mas[j] == value){ // condition for duplicates 
                    duplicates[counterForDuplicates++] = mas[j]; // put into mas for duplicates
                    swap(mas, j, end--);//duplicate go to end position, end limit will decrease
                }
            }

            swap(mas, i, minI);
        }
        
        trimToSize();

    }
    
    private void trimToSize(){
    	sorted = Arrays.copyOf(sorted, end + 1);
    	duplicates = Arrays.copyOf(duplicates, duplicates.length - end - 1);
    }
    
    public char[] getSorted() {
		return sorted;
	}

	public char[] getDuplicates() {
		return duplicates;
	}

	private void swap(char[] mas, int a, int b){
        char t = mas[a];
        mas[a] = mas[b];
        mas[b] = t;
    }
	
    @Override
	public String toString() {
		return "sorted=" + Arrays.toString(sorted) + "\nduplicates="
				+ Arrays.toString(duplicates);
	}

	public static void main(String[] args) {
        Sorter sorter = new Sorter();
    	char[] mas = {'4','1','r','N','2','g','5','1','9','g','5','4'};
        sorter.sortWithNoDuplicates(mas);
        System.out.println(sorter);

    }

}
