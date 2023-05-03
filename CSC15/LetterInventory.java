public class LetterInventory(){
   public static final int ALPHABET = 26;
   private int size;
   private int[] inventory = new int[ALPHABET];
   
   
   //creates a count of how many letters there are. and it should be lower case
   //and ignores non-alphabetic letters
   public LetterInventory(String data){
      data.toLowerCase();
   for(int i = 0; i<data.length(); i++){
      if(Character.isLetter(data.charAt(i)){
         inventory[data.charAt(i)-'a']++;
         size++;
      }
   }
   }
   
   //returns the count of how many of that letter are in that inventory
   //if the letter is non-alphabetic throws IllegalArgumentException
   public int get(char letter){
      if(!(Character.isLetter(letter)){
         throw new IllegalArgumentException();
      }
      letter = Character.toLowerCase(letter);
      return inventory[letter - 'a'];
   }
   
   //returns sum of all the counts in the inventory
   public int size(){
      return size;
   }
   
   //returns true if the inventory is empty 
   public boolean isEmpty(){
      return size == 0;
   }
   
   public String toString(){
      String a = "[";
      for(int i = 0; i<ALPHABET; i++){
         for(int j = 0; j<inventory[i]; j++){
         a += (char) (i + 'a');
         }
      }
      return a + "]";
   }
   
   
}