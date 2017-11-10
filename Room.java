package game;

// Author: Nicholas Caiazza

public class Room {
	
	private Room northRoom;
	private Room southRoom;
	private Room eastRoom;
	private Room westRoom;
	private String description;
	private String roomName;
	private Item item;
	private boolean locked;
	
	public Room(String desc, String name, Item i) {
		description = desc;
		item = i;
		this.roomName = name;
		this.locked = false;
	}
	
	public String getRoomName() {
		return this.roomName;
	}

	public Room getNorthRoom() {
		return northRoom;
	}

	public void setNorthRoom(Room northRoom) {
		this.northRoom = northRoom;
	}

	public Room getSouthRoom() {
		return southRoom;
	}

	public void setSouthRoom(Room southRoom) {
		this.southRoom = southRoom;
	}

	public Room getEastRoom() {
		return eastRoom;
	}

	public void setEastRoom(Room eastRoom) {
		this.eastRoom = eastRoom;
	}

	public Room getWestRoom() {
		return westRoom;
	}

	public void setWestRoom(Room westRoom) {
		this.westRoom = westRoom;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setLocked(boolean l) {
		this.locked = l;
	}
	
	public boolean isLocked() {
		return this.locked;
	}
	
	public String getAvailableRooms() {
		String output = "";
		
		if (this.eastRoom != null) {
			output += "East";
		}
		
		if (this.westRoom != null) {
			if (!output.equals("")) {
				output += ", ";
			}
			
			output += "West";
		}
		
		if (this.southRoom != null) {
			if (!output.equals("")) {
				output += ", ";
			}
			
			output += "South";
		}
		
		if (this.northRoom != null) {
			if (!output.equals("")) {
				output += ", ";
			}
			
			output += "North";
		}
		
		return output;
	}
	
	public String displayItem() {
		if (this.item == null) {
			return "None";
		}
		
		return this.item.getName();
	}
}
