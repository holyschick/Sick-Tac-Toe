/**
 * The Square class models each individual Square of the game board.
 */
public class Square {
    String content; // content of this Square of type String.
                    // take a value of "EMPTY", "EX", or "OH"
                    
   /** Constructor to initialize this Square */
   public Square() {
       content = "EMPTY";
    
   }
 
   /** Set the Square content to param */
   public void set(String s) {
       if(content.equals("EX") || content.equals("OH")){
           content = s;
        }
       else{
           content = "EMPTY";
        }
   }
 
 
   /** Get the Square content */
   public String get() {
       return content;
   }
 
   /** Clear the Square content to EMPTY */
   public void clear() {
       content = "EMPTY";
   }

   /** Paint itself */
   public void paint() {  // print each symbol as a string
        // use System.out.print()
        // 3 chars long, with symbol in middle
        switch(content){
            case "EX": System.out.print(" X ");
            break;
            case "OH": System.out.print(" O ");
            break;
            default: System.out.print("   ");
            break;
        }
    }
}