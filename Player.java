package game;

// Author: Nicholas Caiazza

public class Player {
	
	private Room currentRoom;
	private Item[] inventory;
	
	public Player() {
		inventory = new Item[4];
		
		for (int i = 0; i < inventory.length; i++) {
			inventory[i] = null;
		}
	}
	
	public boolean checkForKey() {
		for(int i = 0; i < this.inventory.length; i++) {
			if (this.inventory[i] != null && this.inventory[i].getName() == "Key") {
				return true;
			}
		}
		
		return false;
	}
	
	public Room getCurrentRoom() {
		return this.currentRoom;
	}
	
	public void setCurrentRoom(Room r) {
		this.currentRoom = r;
	}
	
	public void checkInventory() {
		for (int i = 0; i < this.inventory.length; i++) {
			if (this.inventory[i] != null) {
				System.out.println("Item " + (i + 1) + ":");
				System.out.println(this.inventory[i].toString());
			}
		}
	}
	
	public void addItem(Item item) {
		for (int i = 0; i < this.inventory.length; i++) {
			if (this.inventory[i] == null) {
				this.inventory[i] = item;
				break;
			}
		}
	}
}
