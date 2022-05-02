import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class main {
	public static void main (String[] args) throws IOException{
	
	 encrypti enc= new encrypti();
	   enc.encryption();

		System.out.println("Please enter your Username and Password : ");
	Scanner use = new Scanner(System.in);
	System.out.print("Username :");
	String username=use.nextLine();
	System.out.print("Password :");
	String password=use.nextLine();
	Boolean login1=username.equals("admin") && password.equals("admin");
	
	
	while (login1==false) {
		
	 
		System.out.println("Your input is incorrect please try again");
		Scanner use2 = new Scanner(System.in);
	System.out.print("Username :");
	 username=use2.nextLine();
	
	System.out.print("Password :");
	 password=use2.nextLine();
	
	 login1=username.equals("admin") && password.equals("admin");
		
	}
	
	decrypti dec= new decrypti();
	   dec.decryption();
		System.out.println("If you want to log out please press \"y\"");
		Scanner out = new Scanner(System.in);
		String logout=out.nextLine();
		while(!logout.equals("y")) {
			System.out.println("Your input is incorrect please try again");
			logout=out.nextLine();
			
		}
		encrypti enc2= new encrypti();
		   enc2.encryption();
		 
		
	}}
	
