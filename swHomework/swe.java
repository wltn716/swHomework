package swHomework;

import java.util.Scanner;


public class swe {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int func = 0;
		do {
			do {
				
				System.out.println("1. Memo Manager");
				System.out.println("2. Calculator");
				System.out.println("3. Account Book");
				System.out.println("4. End");
				func = scan.nextInt();
				
			}while(func<0&&func>5);
			
			switch(func) {
					case 1: break;
					case 2: 

						do {
							Calculator calculator = new Calculator();
							System.out.println("a. 사칙연산");
							System.out.println("b. 단위변환");
							System.out.println("c. 돌아가기");
							calculator.selected = scan.next();
							if(calculator.selected.equals("a") || calculator.selected.equals("b")) { 
								calculator.calculating();
								Scanner scan1 = new Scanner(System.in);
								String clear = scan1.nextLine();
							}
							else break;							
						}while(true);
						
					case 3: break;
					case 4: 
						System.out.println("이용해 주셔서 감사합니다.");
						System.exit(0);
			
			
			
			}
		}while(true);

	}
}
