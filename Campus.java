import java.util.ArrayList;

public class Campus {

    String name; 
    ArrayList<Room> roomlist; 
    

    public Campus(String name) {
        this.name = name;
        this.roomlist = new ArrayList<Room>(); 
    }

    public String getName() {
        return name;
    }

    public ArrayList<Room> getRoomlist() {
        return roomlist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addRoomToRoomlist(Room newRoom) {
        this.roomlist.add(newRoom);
    }

    public void removeRoomFromRoomlist(Room oldRoom) {
        this.roomlist.remove(oldRoom);
    }

    public boolean isRoomInRoomlist(String room) {
        for (Room r : roomlist) {
            if (r.getName() == room) {
                return true; 
            }
        }
        return false; 
    }


    
    
}
