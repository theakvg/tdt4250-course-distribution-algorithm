import java.util.ArrayList;

public class Timetable {
  String name; 
  ArrayList<BookedSlot> bookedSlots; 
  
  public Timetable(String name) {
      this.name = name; 
      this.bookedSlots = new ArrayList<BookedSlot>(); 
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public void addBookedSlots(BookedSlot bookedSlot) {
      this.bookedSlots.add(bookedSlot); 
  }

  public void removeBookedSlots(BookedSlot bookedSlot) {
      this.bookedSlots.remove(bookedSlot); 
  }


}