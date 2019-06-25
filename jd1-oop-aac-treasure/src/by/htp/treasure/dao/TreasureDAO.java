package by.htp.treasure.dao;
import java.util.ArrayList;
import java.util.Scanner;

import by.htp.treasure.entity.Treasure;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TreasureDAO implements TreasureDAOInterface{

	@Override
	public ArrayList<Treasure> treasureList () throws FileNotFoundException{
		
		FileReader treasures = new FileReader("Treasures.txt");
		Scanner scan = new Scanner(treasures);
		ArrayList <Treasure> allTreasure = new ArrayList<>(); 
		String line;
		int i = 0;
	        
	        while (scan.hasNextLine()) {
	        	line = scan.nextLine();
	        	String words [] = line.split(" ");
	        	int cost = Integer.parseInt(words[1]);
	        	allTreasure.add(new Treasure(i, words[0], cost));
	            i++;
	        }
	 
	      scan.close();
	        
		return allTreasure;
		
	}
	
	@Override
	public void addTreasure(String name, int cost) throws FileNotFoundException {
		
		try {
		    Files.write(Paths.get("Treasures.txt"), ("\n" + name + " " + cost).getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		}
		
	}
	
	@Override
	public  void removeTreasure(int id) throws FileNotFoundException{
		
		 ArrayList <Treasure> allTreasure = treasureList();
	      
	     allTreasure.remove(id);
	     PrintWriter writer = new PrintWriter("Treasures.txt");
	      
	      
	     for (Treasure treasuresNew: allTreasure) {
	    	  String name = treasuresNew.getTreasureName();
	    	  int cost = treasuresNew.getTreasureCost();
	    	  writer.write(name + " " + cost + System.getProperty("line.separator"));
	    	  }
	    	  writer.close();
	     
	    }
	
	@Override
	public  void expensiveTreasure() throws FileNotFoundException {
		
		ArrayList <Treasure> allTreasure = treasureList();
		int max;
		int id;
		id = 0;
		max = allTreasure.get(0).getTreasureCost();
		for (int i = 0; i <= allTreasure.size()-1; i++ ) {
			
			if (allTreasure.get(i).getTreasureCost() > max) {
				id = allTreasure.get(i).getId();
				max = allTreasure.get(i).getTreasureCost();
			}
		}
		ArrayList<Treasure> expensiveTreasures = new ArrayList<>();
		for (int i = 0; i <= allTreasure.size()-1; i++ ) {
			
			if (allTreasure.get(i).getTreasureCost() == max) {
				expensiveTreasures.add(new Treasure(id, allTreasure.get(i).getTreasureName(), allTreasure.get(i).getTreasureCost()));
				id++;
			}
			
		}
		System.out.println(expensiveTreasures);
		
		
	}
	
	@Override
	public  void selectionTreasure(int sum) throws FileNotFoundException {
		
		ArrayList <Treasure> allTreasure = treasureList();
		Scanner sc = new Scanner(System.in);
		int id;
		int treasureSum;
		treasureSum = 0;
		int choice;
		int ostatok;
		int cost;
		cost = 0;
		ostatok = sum;
		choice = 1;
		while (choice != 0) {
		System.out.println("Введите номер сокровища для покупки");
		id = sc.nextInt();
		cost = allTreasure.get(id).getTreasureCost();
		treasureSum += cost;
		
		if (treasureSum > sum) {
			System.out.println("Вы не можете приобрести данное сокровище");
		}
		else {
			System.out.println(allTreasure.get(id).toString());
			ostatok = ostatok - cost;
		}
		
		System.out.println("У вас осталось " + ostatok + " рублей(я)");
		System.out.println("Продолжить покупки? 1-да / 0-нет");
		choice = sc.nextInt();
		}
		sc.close();
	}
	      
	
	
}