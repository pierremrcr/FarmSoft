package farmSoft;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static int money = 0;
	public static Map<String, Integer> barn = new HashMap<>();
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		barn.put("milk", 0);
		barn.put("wheat", 0);
		barn.put("wool", 0);

		
		while(true) {
			presentMenu();
		}
		
	}

	public static void feedAnimals() {
		money -= 4;
	}

	public static void sell() {
		
	
		money += barn.get("milk") * 0.50;
		money += barn.get("wheat") * 0.30;
		money += barn.get("wool") * 1;

		barn.put("milk", 0);
		barn.put("wheat", 0);
		barn.put("wool", 0);

	}

	public static void milkCows(int quantity) {

	 barn.put("milk", barn.get("milk") + quantity);

	}

	public static void harvest(int quantity) {

		//quantity += barn.get("wheat");

		barn.put("wheat", barn.get("wheat") + quantity);

	}

	public static void mowSheep(int quantity) {


		 barn.put("wool", barn.get("wool") + quantity);

	}

	public static int readQuantity(String type) {

		System.out.println("Combien de " + type + " avez vous récupéré ?");

		int quantity = sc.nextInt();

		return quantity;

	}

	public static void addNewActivity() {

		System.out.println("Qu'avez vous fait aujourd'hui ? " 
							+ "\n1. 🥕  J’ai nourri mes animaux"
							+ "\n2. 💰  J’ai vendu mes produits" 
							+ "\n3. 🐄  J’ai trait mes vaches" 
							+ "\n4. 🌾  J’ai moissonné"
							+ "\n5. 🐑  J’ai tondu mes moutons");
	
		
		int choice = sc.nextInt();
		
		switch (choice) {
		
		case 1 :
			
			feedAnimals();
			break;
		
		case 2 :
			
			sell();
			break;
			
		case 3 :
			
			int quantityMilk = readQuantity("lait");
				milkCows(quantityMilk);
				break;
			
		
		case 4 :
			
			int quantityWheat = readQuantity("blé");
			harvest(quantityWheat);
			break;
			
		
		case 5 :
			
			int quantityWool = readQuantity("laine");
			mowSheep(quantityWool);
			break;
			
		default :
			
			System.out.println("Je ne comprends pas");

		}
}
	
	public static void presentMenu() {
		
		System.out.println("Que voulez-vous faire ?"
				    		+ "\n1. 🤸‍♂️  Enregistrer une nouvelle activité"
				    		+ "\n2. 🏦  Consulter ma banque"
				    		+ "\n3. 🏠  Consulter ma grange");
		
		int choice = sc.nextInt();
		
		switch (choice) {
		
		case 1 :
			
			addNewActivity();
			break;
			
		case 2 :
			
			System.out.println("votre banque contient " + money + " euros");
			break;
			
		case 3 :
			
			System.out.println("Votre grange contient : "  
					           + barn.get("milk") + " bidons de lait "
					           + barn.get("wheat") + " bottes de blé "
					           + barn.get("wool") + " pelotes de laine.");
			break;
			
		default :
			
			System.out.println("Je ne comprends pas");
		}
	}
	
}
	


