import java.util.*;
import java.io.*;

class PersonalityTestHelper {

	public static void main(String[] args) throws FileNotFoundException{
		runPersonalityTest();

	}
	
	public static void runPersonalityTest() throws FileNotFoundException {
		System.out.println("This program is a peronsality test");
		//Scanner scan = new Scanner(new File("personality.txt"));
		String[] names  = new String[9];
		String[] responses = new String[9];
		populateArray(names, responses);
		
	}
	
	public static void populateArray(String[] names, String[] responses) throws FileNotFoundException{
		
      int i = 0;
		//scans the file and put the names and response into the array
		Scanner scan = new Scanner(new File("personality.txt"));
		while(scan.hasNextLine()) {
      String name = scan.nextLine();
		String response = scan.nextLine().toUpperCase();
			//names[i] = name;
			//responses[i] = response;
			//i++;
			int[] findB = countBs(response);
			int[] findA = countAs(response);
			int[] countDashes = countDashes(response);
			int[] percentage = percentage(findB);
			String[] type = type(percentage);
			displayResults(name, percentage, type);
		}	
		
	}
	
	public static int[] countBs(String response) {
		int[] countB = new int[4]; // method declares the array of 4, searching through 4 at a time
        for (int i = 0; i < response.length(); i++) { // for every time i is less than the length of the answer continue on 
            char t = response.charAt(i); // declare a char and make it set to the character at place i in the answers
            if (t == 'B') { // if at that spot you find a B continue
            if (i % 7 == 0) { // found a B is the spot it is at evenly divisible by 7 aka in the 7th spot?
                countB[0]++; // ok then at it to the array in the first spot
                }
            if (i % 7 == 1 || i % 7 == 2) { //is the B found in 
                countB[1]++;// ok then at it to the array in the second spot
            }
            if (i % 7 == 3 || i % 7 ==4) {

                countB[2]++;// ok then at it to the array in the third spot
            }
            if (i % 7 == 5 || i % 7 == 6) {
                countB[3]++; // ok then at it to the array in the fourth spot
            }
            
        }
   }
        return countB;
	}
	
	public static int[] countAs(String response) {
	     int[] countA = new int[4];
	        for (int i = 0; i < response.length(); i++) {
	            char t = response.charAt(i);
	            if (t == 'A') {
	                if (i % 7 == 0) {
	                    countA[0]++;
	                }
	                if (i % 7 == 1 || i % 7 == 2) {
	                    countA[1]++;
	                    }
	                if (i % 7 == 3 || i % 7 ==4) {
	                    countA[2]++;
	                    }
	                if (i % 7 == 5 || i % 7 == 6) {
	                    countA[3]++;
	                }
	            }
	        }
	        return countA;
	}
	
	public static int[] countDashes(String response) {
	       int[] totalDash = new int[4];

	        // loop through text and find b's
	        for (int i=0; i<response.length(); i++) {
	            // check the char
	            if (Character.toLowerCase(response.charAt(i)) == '-') {
	                // check the index if the character was b
	                if (i % 7 == 0 ) { 
	                	totalDash[0]++;
	                } else if (i % 7 == 1 || i % 7 == 2) {
	                	totalDash[1]++;
	                } else if (i % 7 == 3 || i % 7 == 4) {
	                	totalDash[2]++;
	                } else if (i % 7 == 5 || i % 7 == 6) {
	                	totalDash[3]++;
	                }
	            }
	        }
	        return totalDash;
	}
	
	 // method to calculate the percentages of 'B' answers
    public static int[] percentage(int[] countB) { // takes the information from the method count B
    	int[] percentage = new int[4]; // declares an array length of 4
    		percentage[0] =100*countB[0]/10; // makes the percent into a whole number
    	for (int  i = 0; i < countB.length; i++) { // for when i is less than the length of the array for countB keep going till you have all in the array
    		double d = percentage[i]; // takes a double of percent at place i in the array so 1,2, 3, 4
    		percentage[i] = (int) Math.round(d); // at place i make it an int that rounds the double
    	}
    	for(int i = 0; i< percentage.length; i++){
    		double j = percentage[i];
    		percentage[i]= (int) Math.round(j);
    	}
    		        return percentage;
    		        }
    
    //method to take the percentage of B for each type section and see what category they fit in
    public static String[]type(int[] percentage) { // string type takes the int array from the percentage method
    	String[] type = new String[4]; // type is a string with a array length of 4
    	for (int i = 0; i <= type.length - 1; i++) {  // for when i is less than or equal to the length of the type minus one add one and keep going
    		if (percentage[i] > 50) {	// if the percentage at spot "i" is greater than 50
    			if (i == 0) {	// if i is nothing type at spot 0 
    				type[0] = "I"; // if i is nothing type at spot 0 is 0 then it's an I
    			} else if (i == 1) {
    				type[1] = "N"; //
    			} else if (i == 2) {
    				type[2] = "F"; //
    			} else {
    				type[3] = "P"; //
    			}
    		} else if (percentage[i] < 50) {
    			if (i == 0) {
    				type[0] = "E";
    			} else if (i == 1) {
    				type[1] = "S";
    			} else if (i == 2) {
    				type[2] = "T";
    			} else {
    				type[3] = "J";
    			}
    		} else if (percentage[i] == 50) {
    			type[i] = "X";
    		}
    	}
    	return type;
    }
	
	public static void displayResults(String name, int[] percentages, String[] type) {
		System.out.println(name+ " " +Arrays.toString(percentages)+ " "+Arrays.toString(type));
	}
	
	

}