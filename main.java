package game;

import java.awt.color.CMMException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		
		Room gh = new Room("This is a large entryway to the castle.  It is dimly lit by torches across the walls."
				+ "  There is a large red carpet running the length of the hall."
				+ "  A staircase is located next to the castle entrance to the south.", "Great Hall", null);
		
		Player player = new Player();
		player.setCurrentRoom(gh);
		
		Item sword = new Item("Iron Sword","This is an iron longsword.");
		
		Room armory = new Room("There are weapons and armor strewn across the room."
				+ "  You see an iron sword on an anvil at the other end of the room","Armory", sword);
		
		Item pie = new Item("Pie Slice", "This is a pie.  The slice only has a volume of 3.14159 though...");
		
		Room kitchen = new Room("There are pots and pans littered on tables.  The smell of freshly baked pie wafts through the air.",
				"Kitchen", pie);
		
		Item book = new Item("Old Book", "This is an old and dusty book.");
		
		Room library = new Room("This is a large library.  Full bookshelves line the walls."
				+ "  A seating area is in the middle of the room.  An old book lies on a table to your right.", "Library", book);
		
		Room cr = new Room("This is a comfy looking common room.  There is a door to the east and west."
				+ "  But, the west door is locked.  Maybe there is a key somewhere...","Common Room",null);
		
		Item key = new Item("Key", "What could this unlock?");
		
		Room bedroom = new Room("This is a bedroom.  You feel wind from outside hit you as you walk inside. The doors to the balcony are open."
				+ "  A large bed is against a wall to the left.  In an open wardrobe to the right is a key!","Bedroom",key);
		
		Room balcony = new Room("This balcony has a wonderful view of a mountain range.  You see an endless amount of rolling green hills.",
				"Balcony",null);
		
		Room tr = new Room("You are amazed at the amount of gold and loot as you enter the room.  A huge pile of gold coins is in the center"
				+ " of the room.","Treasure Room",null);
		
		gh.setEastRoom(armory);
		gh.setWestRoom(library);
		gh.setNorthRoom(kitchen);
		gh.setSouthRoom(cr);
		
		armory.setWestRoom(gh);
		library.setEastRoom(gh);
		kitchen.setSouthRoom(gh);
		
		cr.setSouthRoom(gh);
		cr.setWestRoom(tr);
		cr.setEastRoom(bedroom);
		
		bedroom.setSouthRoom(balcony);
		bedroom.setWestRoom(cr);
		tr.setEastRoom(cr);
		tr.setLocked(true);
		balcony.setNorthRoom(bedroom);
		
		boolean running = true;
		String input = "";
		
		while(running) {
			
			System.out.println("Current Room: " + player.getCurrentRoom().getRoomName() + "\n"
					+ player.getCurrentRoom().getDescription() + "\n"
					+ "Available Rooms: " + player.getCurrentRoom().getAvailableRooms() + "\n"
					+ "Item: " + player.getCurrentRoom().displayItem());
			
			System.out.print("Enter Command (Enter Help for help): ");
			input = kbd.next();
			
			if (input.equalsIgnoreCase("Help")) {
				System.out.println("Commands:\n"
						+ "go <North/South/East/West> - enter room to the <North/South/East/West> of current room\n"
						+ "collect - adds any items in the room to your inventory\n"
						+ "inventory - displays your inventory\n"
						+ "quit - quits the game\n");
			}
			
			if (input.equals("go")) {
				System.out.print("Enter the direction (North, South, East, or West): ");
				input = kbd.next();
				
				System.out.println();
				
				if (input.equalsIgnoreCase("East")) {
					if (player.getCurrentRoom().getEastRoom() != null && !(player.getCurrentRoom().getEastRoom().isLocked())) {
						player.setCurrentRoom(player.getCurrentRoom().getEastRoom());
					} else if (player.getCurrentRoom().getEastRoom() != null && player.getCurrentRoom().getEastRoom().isLocked()) {
						if (player.checkForKey()) {
							player.setCurrentRoom(player.getCurrentRoom().getEastRoom());
						} else {
							System.out.println("The door is locked.  Maybe there is a key somewhere...\n");
						}
					} else {
						System.out.println("There is no room in that direction.\n");
					}
				}
				
				if (input.equalsIgnoreCase("West")) {
					if (player.getCurrentRoom().getWestRoom() != null && !(player.getCurrentRoom().getWestRoom().isLocked())) {
						player.setCurrentRoom(player.getCurrentRoom().getWestRoom());
					} else if (player.getCurrentRoom().getWestRoom() != null && player.getCurrentRoom().getWestRoom().isLocked()) {
						if (player.checkForKey()) {
							player.setCurrentRoom(player.getCurrentRoom().getWestRoom());
						} else {
							System.out.println("The door is locked.  Maybe there is a key somewhere...\n");
						}
					} else {
						System.out.println("There is no room in that direction.\n");
					}
				}
				
				if (input.equalsIgnoreCase("North")) {
					if (player.getCurrentRoom().getNorthRoom() != null && !(player.getCurrentRoom().getNorthRoom().isLocked())) {
						player.setCurrentRoom(player.getCurrentRoom().getNorthRoom());
					} else if (player.getCurrentRoom().getNorthRoom() != null && player.getCurrentRoom().getNorthRoom().isLocked()) {
						if (player.checkForKey()) {
							player.setCurrentRoom(player.getCurrentRoom().getNorthRoom());
						} else {
							System.out.println("The door is locked.  Maybe there is a key somewhere...\n");
						}
					} else {
						System.out.println("There is no room in that direction.\n");
					}
				}
				
				if (input.equalsIgnoreCase("South")) {
					if (player.getCurrentRoom().getSouthRoom() != null && !(player.getCurrentRoom().getSouthRoom().isLocked())) {
						player.setCurrentRoom(player.getCurrentRoom().getSouthRoom());
					} else if (player.getCurrentRoom().getSouthRoom() != null && player.getCurrentRoom().getSouthRoom().isLocked()) {
						if (player.checkForKey()) {
							player.setCurrentRoom(player.getCurrentRoom().getSouthRoom());
						} else {
							System.out.println("The door is locked.  Maybe there is a key somewhere...\n");
						}
					} else {
						System.out.println("There is no room in that direction.\n");
					}
				}
			}
			
			if (input.equalsIgnoreCase("collect")) {
				if (player.getCurrentRoom().getItem() != null) {
					player.addItem(player.getCurrentRoom().getItem());
					player.getCurrentRoom().setItem(null);
				}
				System.out.println();
			}
			
			if (input.equalsIgnoreCase("inventory")) {
				player.checkInventory();
				System.out.println();
			}
			
			if (input.equalsIgnoreCase("quit")) {
				running = false;
			}
			
		}
		
		System.out.println("Thank you for playing!");
		
	}

}
