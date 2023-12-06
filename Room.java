public class Room {
    int size; 
    String name; 
    RoomSchedule roomSchedule; 
    
    

    public Room(String name, int size) {
        this.size = size;
        this.name = name; 
        roomSchedule = new RoomSchedule(name); 
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public RoomSchedule getRoomSchedule() {
        return roomSchedule;
    }

    
}
