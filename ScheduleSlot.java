public class ScheduleSlot {

    int startTime; 
    int endTime; 
    String weekDay; 
    BookedSlot slot; 
    String roomName; 
    

    public ScheduleSlot(int startTime, int endTime, String weekDay, String roomName) {
        this.startTime = startTime;
        this.endTime = endTime; 
        this.weekDay = weekDay; 
        this.roomName = roomName; 
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public void setSlot(BookedSlot slot) {
        this.slot = slot;
    }

    public void setRoom(String roomName) {
        this.roomName = roomName;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public BookedSlot getSlot() {
        return slot;
    }

    public String getRoomName() {
        return roomName;
    }
    
}

