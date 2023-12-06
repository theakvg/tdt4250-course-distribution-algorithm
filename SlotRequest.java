public class SlotRequest {
    int duration; 
    String typeOfActivity; 
    int expectedNumberOfStudents; 
    int numberOfSlots; 
    String assignee; 
    String prefferedRoom; 
    String course; 
    String campus; 

 

    public SlotRequest(int duration, String typeOfActivity, int expectedNumberOfStudents, int numberOfSlots, String assignee, String course, String campus) {
        this.duration = duration;
        this.typeOfActivity = typeOfActivity; 
        this.expectedNumberOfStudents = expectedNumberOfStudents; 
        this.numberOfSlots = numberOfSlots; 
        this.assignee = assignee;
        this.course = course; 
        this.campus = campus; 
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

    public int getExpectedNumberOfStudents() {
        return expectedNumberOfStudents;
    }

    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public String getRoom() {
        return prefferedRoom;
    }

    public String getTypeOfActivity() {
        return typeOfActivity;
    }

    public String getCampus() {
        return campus;
    }

    public String getPrefferedRoom() {
        return prefferedRoom;
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

    public void setExpectedNumberOfStudents(int expectedNumberOfStudents) {
        this.expectedNumberOfStudents = expectedNumberOfStudents;
    }

    public void setNumberOfSlots(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    public void setRoom(String prefferedRoom) {
        this.prefferedRoom = prefferedRoom;
    }

    public void setTypeOfActivity(String typeOfActivity) {
        this.typeOfActivity = typeOfActivity;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public void setPrefferedRoom(String prefferedRoom) {
        this.prefferedRoom = prefferedRoom;
    }


}
