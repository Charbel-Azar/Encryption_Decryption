import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class encrypti {
	String encrypMsg;
	public static int  key;
	public static ArrayList<Integer> space = new ArrayList<Integer>();
	public encrypti ()
	
	{Random rand2= new Random();
		key =rand2.nextInt(14)+6;
		encrypMsg = "";
	}
	public String encString(String msg) {
	
		// In this step i removed all special characters
		  msg = msg.replaceAll("[0123456789$*&/+éè¢ÉêçåïëçåïëåäâàôöòûùÖ@~_=]","");
	
		
		 char[][] path = new char[key][msg.length()];
		 //In this step i created a matrix filled with #
	       for (int i = 0; i < key; i++){
	            for (int j = 0; j < msg.length(); j++) {
	                path[i][j] = '#';
	            }
	        }
	       
	       
	    // In this step, i am putting the letters in the matrix in zig-zag
	        int row = 0;
	        int check = 0;
	        for (int i = 0; i < msg.length(); i++) {
	            if (check == 0){
	                path[row][i] = msg.charAt(i);
	                row++;
	                if (row == key){
	                    check = 1;
	                    row--;
	                }
	            } else if(check == 1){
	                row--;
	                path[row][i] = msg.charAt(i);
	                if (row == 0){
	                    check = 0;
	                    row = 1;
	                }
	            } 
	        } 
	        
	        
	        //This comment is to see the matrix 
	       /* for (int i = 0; i < path.length; i++)
			{
				for (int j = 0; (path[i] != null && j < path[i].length); j++)
					System.out.print(path[i][j] + " ");

				System.out.println();
			}*/
	        
	        
	        /*In this step , i am reading the matrix in a horizontal way
	         * and adding random symbols and integers around each letter*/
	        
	        String encrypMsg = "";
	   Random rand= new Random();
	        
	        for (int i = 0; i < key; i++) {
	            for (int j = 0; j < msg.length(); j++) {
	            	int r=rand.nextInt(10000);
	            	  String latin = "éè¢ÉêçåïëçåïëåäâàôöòûùÖ";
	            	  char letterlatin=latin.charAt(rand.nextInt(latin.length()));
	            	  String letterlatin2=""+letterlatin;
	            	String [] bonus= {""+r,"$","&","*","/","+",letterlatin2,"@",letterlatin2,"~",letterlatin2,"_",letterlatin2,"=",letterlatin2};
	                encrypMsg +=""+bonus[rand.nextInt(bonus.length)]+bonus[rand.nextInt(bonus.length)]+bonus[rand.nextInt(bonus.length)]+ path[i][j]+bonus[rand.nextInt(bonus.length)]+bonus[rand.nextInt(bonus.length)]+bonus[rand.nextInt(bonus.length)]+"";
	                
	               
	            }

	        }
	        
	        //In this step , i am removing all the # placed in the encrypted messgae
	         
	        encrypMsg = encrypMsg.replaceAll("#","");
	  
      return encrypMsg;
}
public void encryption() throws IOException {
	 String firstenc = null;
	 String firstencsum="";
	 String firsttime = "";
	Scanner scan = new Scanner (new File("D:\\eclipse\\workspace\\Final project\\src\\SuperSecretStuff.txt"));
		 scan.useDelimiter("!"); 
		 while(scan.hasNext()) {
			 
		 // scan the whole text
			 
		 firsttime=scan.next() ;
		 
		 // find the index of all the spaces, add the indexes to the arraylist 
		 
		 for(int i=0; i<firsttime.length();i++) {
			
			 char letter=(firsttime.charAt(i));
			 String letter2 =""+letter;
			    if (letter2.equals(" ")) {
			    space.add(i);
			}}	
		 
		//I removed all of the spaces
		 
		firsttime= firsttime.replaceAll(" ","");
		 firstenc = encString(firsttime);
	
	 }
	 
	  
	FileWriter  writer = new FileWriter("D:\\eclipse\\workspace\\Final project\\src\\SuperSecretStuff.txt");
	PrintWriter printw = new PrintWriter(writer);
	printw.print(firstenc);
	printw.close();
}
}