package by.htp.treasure.main;
import java.io.FileNotFoundException;
import java.util.Scanner;

import by.htp.treasure.service.ServiceTreasure;
import by.htp.treasure.service.ServiceTreasureInterface;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		ServiceTreasureInterface service = new ServiceTreasure();
		int number = 1;
		
		while (number != 0)
		{
		System.out.println("Чтобы увидеть список сокровищ нажмите 1");
		System.out.println("Чтобы добавить сокровище нажмите 2");
		System.out.println("Чтобы удалить сокровище нажмите 3");
		System.out.println("Чтобы найти самое дорогое сокровище нажмите 4");
		System.out.println("Чтобы подобрать сокровища на сумму нажмите 5");
		System.out.println("Чтобы выйти нажмите 0");

		 number = sc.nextInt();

		service.Command(number);
		}
		sc.close();
		
		
	}

}
