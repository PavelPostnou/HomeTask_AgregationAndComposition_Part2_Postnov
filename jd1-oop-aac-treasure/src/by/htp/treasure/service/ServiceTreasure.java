package by.htp.treasure.service;
import java.io.FileNotFoundException;
import java.util.Scanner;

import by.htp.treasure.dao.TreasureDAO;
import by.htp.treasure.dao.TreasureDAOInterface;

public class ServiceTreasure implements ServiceTreasureInterface {
	
	TreasureDAOInterface tDAOIn = new TreasureDAO();
	
	@Override
	public void Command(int number) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		
		if (number == 1) {
			System.out.println(tDAOIn.treasureList());
		}
		else if (number == 2) {
			System.out.println("Введите название сокровища");
			String name = sc.nextLine();
			System.out.println("Введите цену сокровища");
			int cost = sc.nextInt();
			tDAOIn.addTreasure(name, cost);
		}
		else if (number == 3) {
			System.out.println("Введите номер сокровища для удаления");
			int id = sc.nextInt();
			tDAOIn.removeTreasure(id);
		}
		else if (number == 4) {
			tDAOIn.expensiveTreasure();
		}
		else if (number == 5) {
			System.out.println("Сколько у вас есть денег?");
			int cash = sc.nextInt();
			tDAOIn.selectionTreasure(cash);
	    }
		else if(number == 0) {
			 sc.close();
			 System.exit(0);
		}
		
		else {
			System.out.println("Введено неверное число");
		}
	}
	
}
