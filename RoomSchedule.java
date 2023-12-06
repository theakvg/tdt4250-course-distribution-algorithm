import java.util.ArrayList;
import java.util.List;

public class RoomSchedule {

    String roomName; 
    // Day monday = new Day("monday", roomName); 
    // Day tuesday = new Day("tuesday", roomName); 
    // Day wednesday = new Day("wednesday", roomName); 
    // Day thursday = new Day("thursday", roomName);
    // Day friday = new Day("friday", roomName); 
    ArrayList<Day> days;  
    

    public RoomSchedule(String roomName) {
        this.roomName = roomName; 
        days = new ArrayList<>(List.of(new Day("mon", roomName), new Day("tue", roomName), new Day("wed", roomName), new Day("thu", roomName), new Day("fri", roomName))); 
    }

    public String getRoomName() {
        return roomName;
    }

    public void setroomName(String roomName) {
        this.roomName = roomName;
    }

    public ArrayList<Day> getDays() {
        return days;
    }

    
}
