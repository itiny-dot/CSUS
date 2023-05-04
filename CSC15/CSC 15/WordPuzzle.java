import java.util.*;
import java.io.*;
public class WordPuzzle{
   public static void main(String[] args){
      String[] needles = new String[6];
		String[] haystacks = new String[8];
		try {
			Scanner scan = new Scanner(new File("wordpuzzle.txt"));
			int index = 0;
			String divider = "***";
			while(scan.hasNext() && index<6) {
				String word = scan.next();
				if(word.equals(divider)) {
            System.out.println(word);
               break;
				}
            needles[index] = word;
            index++;
			}
         while(
			
		} catch(FileNotFoundException e) {
			System.out.println("Error has occured" +e);
		}
		
		System.out.println(Arrays.toString(needles));
	}

   }
