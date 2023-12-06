import java.util.ArrayList;

public class BookedSlot {
    String typeOfActivity; 
    String assignee; 
    String course;
    int duration; 
    int startHour; 
    int endHour; 
    String weekday; 
    Room room; 
    

    public BookedSlot(int duration, String typeOfActivity, String assignee, String course,  int startHour, int endHour, String weekday, Room room) {
        this.duration = duration;
        this.typeOfActivity = typeOfActivity; 
        this.assignee = assignee;
        this.course = course; 
        this.startHour = startHour;  
        this.endHour = endHour; 
        this.weekday = weekday;
        this.room = room; 
    }


    public String getAssignee() {
        return assignee;
    }

    public String getCourse() {
        return course;
    }

    public int getDuration() {
        return duration;
    }

    public String getTypeOfActivity() {
        return typeOfActivity;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public String getWeekday() {
        return weekday;
    }

    public Room getRoom() {
        return room;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTypeOfActivity(String typeOfActivity) {
        this.typeOfActivity = typeOfActivity;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
