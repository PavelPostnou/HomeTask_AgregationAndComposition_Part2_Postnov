package by.htp.treasure.dao;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import by.htp.treasure.entity.Treasure;

public interface TreasureDAOInterface {
	
	public ArrayList<Treasure> treasureList() throws FileNotFoundException;
	
	public void addTreasure(String name, int cost) throws FileNotFoundException;
	
	public  void removeTreasure(int id) throws FileNotFoundException;
	
	public  void expensiveTreasure() throws FileNotFoundException;
	
	public  void selectionTreasure(int sum) throws FileNotFoundException;
}
