package swExpertAcademy;

import java.util.Scanner;

public class No2072 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int T = sc.nextInt();
		
		for (int i=1; i<=T; i++) {
			String input = sc.nextLine();
			String[] numbers = input.split("\\s");
			
			for (String number : numbers) {
				int num = Integer.parseInt(number);
				if (num%2==1) {
					sum += num;
				}
				
			}
			
			System.out.println("#" + i + sum);
		}

	}

}
