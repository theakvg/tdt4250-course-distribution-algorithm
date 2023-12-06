import java.util.ArrayList;
import java.util.List;

public class Day {
    
    String name; 
    String roomName; 
    ArrayList<ScheduleSlot> slots; 
    

    public Day(String name, String roomName) {
        this.name = name; 
        this.roomName = roomName;
        slots = new ArrayList<ScheduleSlot>(List.of(new ScheduleSlot(8, 10, name, roomName), new ScheduleSlot(10, 12, name, roomName), new ScheduleSlot(12, 14, name, roomName), new ScheduleSlot(14, 16, name, roomName), new ScheduleSlot(16, 18, name, roomName))); 
    }

    public String getName() {
        return name;
    }

    public String getRoomName() {
        return roomName;
    }

    public ArrayList<ScheduleSlot> getSlots() {
        return slots;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoom(String roomName) {
        this.roomName = roomName;
    }

    public void setSlots(ArrayList<ScheduleSlot> slots) {
        this.slots = slots;
    }

}
