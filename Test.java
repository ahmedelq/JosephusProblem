package test;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * The Josephus problem solver
 * Created by: ahmelq
 * github.com/ahmedelq
 * October 2017
 */

public class Test {

	public static void main(String[] args) {
		Scanner keyb= new Scanner(System.in);
		System.out.println("Please enter an integer bigger than 1");
		int usrInt=0;
		while(true) {
			try {
				 usrInt = keyb.nextInt();
				if(usrInt>=1)
					break;
				else
					System.out.println("please enter a valid value");

			}catch(InputMismatchException  e) {
				System.out.println("please enter a valid value");
			}
		}
		Soldiers[] n= new Soldiers[usrInt];
		fill(n);
		killSoldiers(n);


	}
	

	public static void kill(Soldiers[] n) {
		int firstID =0;
		
		for(int i=0; i<n.length; i++) {
			if(!n[i].isKilled()) {
				firstID=i;
				break;
			}
		}
		
		for(int x=firstID; x<n.length;x++) {
			if(!n[x].isKilled()) {
				System.out.println(n[x].getId() + " killed "+ n[getAliveSoldierID(x,n)].getId());
				n[getAliveSoldierID(x,n)].setKilled(true);
			}
				
			
		}
	}
	
	public static void killSoldiers(Soldiers[] n) {
		int c =1;
		int nAliveSoldiers= getnAliveSoldiers(n);
		while(nAliveSoldiers!=1) {
			kill(n);
			nAliveSoldiers= getnAliveSoldiers(n);
			
			System.out.println("phase: " + (c++) +"\n");
		}
	}
	
	public static int getAliveSoldierID(int i, Soldiers e[]) {
		i+=1;
		int requiredID = -1; // if not found -1
	
		for(;i<e.length;i++) {
			if(!e[i].isKilled())
			{
				requiredID =i;
				break;
			}
		}
		
		if (requiredID==-1) {
			for(int x=0;x<e.length;x++) {
				if(!e[x].isKilled())
				{
					requiredID =x;
					break;
				}
			}
		}
		
		
		return requiredID;
	}
	public static int getnAliveSoldiers(Soldiers e[]) {
		int aliveSoldiers=0;
		
		for(int i=0; i<e.length; i++) {
			if(!e[i].isKilled())
				aliveSoldiers++;
		}
		
		return aliveSoldiers;
	}
	
	public static void fill(Soldiers e[]) {
		int counter=1;
		for(int i=0; i<e.length;i++) {
			
			e[i]= new Soldiers(counter++, false);
		}
	}
	public static void print(Soldiers n[]) {
		for(int i=0; i<n.length;i++) {
			System.out.println("Soldiers ID:" + n[i].getId() +(n[i].isKilled() ? " Killed" : " Alive") );
		}
	}
}
