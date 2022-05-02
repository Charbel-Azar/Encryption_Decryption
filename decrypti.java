import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class decrypti {
String decrypMsg="";
	
	public decrypti() {
		
	}
	public String decString(String msg){
		
	// In this step i removed all special characters
		  msg = msg.replaceAll("[0123456789$*&/+éè¢ÉêçåïëçåïëåäâàôöòûùÖ@~_=]","");
		
	      
		 int key=encrypti.key;
		 char[][] path = new char[key][msg.length()];
		 /*In this step i created a matrix filled with #*/
		  for (int i = 0; i < key; i++){
	            for (int j = 0; j < msg.length(); j++) {
	                path[i][j] = '#';
	            }
	        } 
		  
		   // In this step, i am putting the letters of the word cbhreal in the matrix in zig-zag
		  
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
	        
	        
	       /* If you want to see the matrix formed
	        for (int i = 0; i < path.length; i++)
			{
				for (int j = 0; (path[i] != null && j < path[i].length); j++)
					System.out.print(path[i][j] + " ");

				System.out.println();
			}*/

	        // In this step , i am replacing the letters to get the original matrix
	        
	        
	        int ordr = 0;
	        for (int i = 0; i < key; i++) {
	            for (int j = 0; j < msg.length(); j++) {
	                String temp = path[i][j] + "";
	                if (temp.matches("#")){
	                    
	                    continue;
	                } else {
	                   
	                    path[i][j] = msg.charAt(ordr);
	                  
	                    ordr++;
	                } 
	            } } 
	        
	        
	        /* If you want to see the matrix formed
	        for (int i = 0; i < path.length; i++)
			{
				for (int j = 0; (path[i] != null && j < path[i].length); j++)
					System.out.print(path[i][j] + " ");

				System.out.println();
			}*/
	        

	        String decrypMsg = "";
	        check = 0;
	        row = 0;
	        
	        // In this step , i am converting the path to a word
	        
	        for (int i = 0; i < msg.length(); i++) {
	            if (check == 0){
	                decrypMsg += path[row][i];
	                row++;
	                if(row == key){
	                    check = 1;
	                    row--;
	                }
	            } else if (check == 1){
	                row--;
	                decrypMsg += path[row][i];
	                if(row == 0){
	                    check = 0;
	                    row = 1;
	                }
	            } 
	        } 
	        
     return decrypMsg;
}
	
	public void decryption() throws IOException{
	
		String firstdec="";
	Scanner scan = new Scanner (new File("D:\\eclipse\\workspace\\Final project\\src\\SuperSecretStuff.txt"));
	 String firsttime ="";
	 scan.useDelimiter("!");
	 while(scan.hasNext()) {
		 firsttime=scan.next();
		firstdec = decString(firsttime);
	 }

	 String msg1=null;
	 
	 //Here i printed the first word with the space to use a loop afterward
	 
	 msg1 = firstdec.substring(0, encrypti.space.get(0)) + " " ;
	 
	// msg1+= firstdec.substring(encrypti.space.get(0), encrypti.space.get(1)-1) + " " ;
	// msg1+= firstdec.substring(encrypti.space.get(1)-1, encrypti.space.get(2)-2) + " " ;
	// Here i am implementing the spaces i removed in the beginning following their rightful index
	 
	 	int k=0;
		  for(int j=0;j<encrypti.space.size()-1;j++) {  
		  msg1 +=firstdec.substring(encrypti.space.get(j)-j, encrypti.space.get(j+1)-(j+1)) + " " ;
		  k =j;
			}
		msg1+=firstdec.substring(encrypti.space.get(k+1)-(k+1));

	FileWriter  writer2 = new FileWriter("D:\\eclipse\\workspace\\Final project\\src\\SuperSecretStuff.txt");
	PrintWriter printw2 = new PrintWriter(writer2);
	printw2.print(msg1);
	printw2.close();
}
}
	


