import java.util.ArrayList;
import java.util.List;
import java.util.Random; 



// the same coordinator should not appear on multiple slots at the same time, same with course

public class Algorithm {
  public static void main(String[] args) {
    ArrayList<BookedSlot> bookedSlots = new ArrayList<BookedSlot>();
    ArrayList<Campus> campusList = makeCampus(); 
    ArrayList<Room> roomList = makeRooms(5, campusList); 
    ArrayList<SlotRequest> slotList = makeSlots(30, campusList); 
    roomList.sort((r1, r2) -> Integer.compare(r1.getSize(), r2.getSize())); 
    for (SlotRequest sr : slotList) {
      System.out.println(sr.getCourse());
      boolean foundRoom = findNextFreeSlot(sr, bookedSlots, campusList);
      if (!foundRoom) {
        System.out.println("FAILURE");
        break; 
      }

    }
    System.out.println("SUCCESS");
    for (BookedSlot bs : bookedSlots) {
      System.out.println(bs.getCourse() + ", " + bs.getAssignee() + ',' + bs.getStartHour() + ',' + bs.getWeekday() + ',' + bs.getRoom().getName());
    }
  }; 

  public static ArrayList<SlotRequest> checkInput(ArrayList<SlotRequest> slotList, ArrayList<Campus> campusList) {
    boolean check = true; 
    for (SlotRequest sr : slotList) {
      check = campusList.contains(sr.getCampus());
      Campus campus = getCampus(sr.getCampus(), campusList); 
        if (campus == null) {
          check = false;   // the campus input has not the correct name for a campus
        } 
      if (sr.getRoom() != null) {
        if (!campus.isRoomInRoomlist(sr.getRoom())) {
          check = false;   // the room given is not a part of the campus given 
        } 
        
      }
    }

    return slotList; 
  }

  public static Campus getCampus(String campusName, ArrayList<Campus> campusList) {
    for (Campus c : campusList) {
      if (c.getName() == campusName) {
        return c;
      }
    }
    return null; 
  }

  public static ArrayList<Campus> makeCampus() {
    ArrayList<Campus> campusList = new ArrayList<Campus>(); 
    campusList.add(new Campus("Gløshuagen")); 
    campusList.add(new Campus("Dragvoll"));    
    return campusList; 
  }


  public static ArrayList<Room> makeRooms(int number, ArrayList<Campus> campusList) {
    ArrayList<Room> roomList = new ArrayList<Room>(); 
    Random rand = new Random();
    for (int i = 0; i < number; i++) {
        Room newRoom = new Room("room" + i,rand.nextInt(10)+15); 
        roomList.add(newRoom);
        campusList.get(rand.nextInt(campusList.size())).addRoomToRoomlist(newRoom); 
    }
    return roomList; 
  }

  public static ArrayList<SlotRequest> makeSlots(int number, ArrayList<Campus> campusList) {
    Random rand = new Random(); 
    ArrayList<SlotRequest> slotList = new ArrayList<SlotRequest>(); 
    ArrayList<String> courseList = new ArrayList<>(List.of("ITGK", "OOP", "Database", "MMI", "Algdat", "Datdig")); 
    ArrayList<String> professorList = new ArrayList<>(List.of("Leonardo", "Hallvard", "Jon", "Marie", "Ola", "Jonas")); 
    for (int i = 0; i < number; i++) {
        slotList.add(new SlotRequest(4, "lecture", rand.nextInt(10)+5, 1, professorList.get(rand.nextInt(professorList.size())), courseList.get(rand.nextInt(courseList.size())), campusList.get(rand.nextInt(campusList.size())).getName())); 
    }

    return slotList; 
  }

  public static boolean findNextFreeSlot(SlotRequest slot, ArrayList<BookedSlot> bookedSlots, ArrayList<Campus> campusList) {
    ArrayList<BookedSlot> busySlots = getBusySlots(bookedSlots, slot);
    ArrayList<Integer> days_preferred = getPreferredDays(busySlots); 
    int neededSlots = slot.getDuration() / 2; 
    ArrayList<Room> roomlist = getCampus(slot.getCampus(), campusList).getRoomlist();

    for (Room r : roomlist) {
      if (slot.getExpectedNumberOfStudents() <= r.getSize()) { // the room is big enough
        // if the there is free space on the preferred day, book
        if (days_preferred.size() > 0) { 
          for (int dp : days_preferred) {
            // get the index of the preffered day(s)
            boolean confirmed = bookSlotOnDayIfAvailable(r, dp, neededSlots, slot, bookedSlots); 
            if (confirmed) {
              return true; 
            }
          }
          
        } else {
          for (int i = 0; i < 5; i++) {
            // get the index of the preffered day(s)
            boolean confirmed = bookSlotOnDayIfAvailable(r, i, neededSlots, slot, bookedSlots); 
            if (confirmed) {
              return true; 
            }
          }
        }
      }
    }
    // find the smallest room that fits the requirements
    // coordinator cannot have another lecturer at that precise time
    // there cannot be another course slot at that precise time 
    

    return false;
  }

  public static ArrayList<BookedSlot> getBusySlots(ArrayList<BookedSlot> bookedSlots, SlotRequest slot) {
    ArrayList<BookedSlot> busySlots = new ArrayList<BookedSlot>(); 
    for (BookedSlot bs : bookedSlots) { 
      if (bs.getAssignee().equals(slot.getAssignee()) || bs.getCourse().equals(slot.getCourse())) { // ads a booked slot to busy Slots if the assignee or course is the same
        busySlots.add(bs);
      }
    }
    return busySlots; 
  }

  public static ArrayList<Integer> getPreferredDays(ArrayList<BookedSlot> busySlots) {
    ArrayList<Integer> days_preferred = new ArrayList<Integer>(List.of(0, 1, 2, 3, 4));    
    System.err.println(busySlots);
    for (BookedSlot bs : busySlots) {
        System.out.println(bs.getWeekday());
        switch (bs.getWeekday()) {
          case "mon":
              if (days_preferred.contains(0)) { // maps which day the course or professor already have a class
                days_preferred.remove(days_preferred.indexOf(0)); 
              }
              break;
          case "tue":
               if (days_preferred.contains(1)) { // maps which day the course or professor already have a class
                days_preferred.remove(days_preferred.indexOf(1)); 
              } 
              break;
          case "wed":
               if (days_preferred.contains(2)) { // maps which day the course or professor already have a class
                days_preferred.remove(days_preferred.indexOf(2)); 
              }
              break;
          case "thu":
               if (days_preferred.contains(3)) { // maps which day the course or professor already have a class
                days_preferred.remove(days_preferred.indexOf(3)); 
              }
              break;
          case "fri":
               if (days_preferred.contains(4)) { // maps which day the course or professor already have a class
                days_preferred.remove(days_preferred.indexOf(4)); 
              }
              break;
        } 
      }
      System.out.println(days_preferred);
      return days_preferred; 
    }
    

  public static boolean bookSlotOnDayIfAvailable(Room r, int day, int neededSlots, SlotRequest slot, ArrayList<BookedSlot> bookedSlots) {
    // get the index of the preffered day(s)
    // iterating over all Slots for a room, excluding the n-1 last Slots as they cannot be selected since n = the amount of Slots that are needed
    for (int i = 0; i < r.getRoomSchedule().getDays().get(day).getSlots().size() - (neededSlots - 1); i++) {
      boolean isAvailable = true;
      // checking if there are free Slots in neededSlots consecutive Slots.
      for (int j = 0; j < neededSlots; j++) {
        if (!(r.getRoomSchedule().getDays().get(day).getSlots().get(i+j).getSlot() == null)) {
          isAvailable = false; 
        }    
      }
      System.out.println(slot.getCourse() + isAvailable);
      if (isAvailable) {
        // Assigning slots to a room
        ScheduleSlot currentSlot = r.getRoomSchedule().getDays().get(day).getSlots().get(i); 
        int starthour = currentSlot.getStartTime(); 
        int endhour = currentSlot.getEndTime(); 
        String weekday = currentSlot.getWeekDay(); 
        BookedSlot newSlot = requestToBookedSlot(slot, starthour, endhour, weekday, r); 
        bookedSlots.add(newSlot); 

        for (int x = 0; x < neededSlots; x++) {
          currentSlot = r.getRoomSchedule().getDays().get(day).getSlots().get(i+x); 
          currentSlot.setSlot(newSlot); 
          // remove from  slotList and add to bookedSlots
        }
        System.out.println("available slot found for requested slot: "+ slot.getCourse());
        return isAvailable; 
      }
    }
    System.out.println("found not an available slot for: "+ slot.getCourse());
    return false; 
  }

    public static BookedSlot requestToBookedSlot(SlotRequest slot, int starthour, int endhour, String weekday, Room room) {
      BookedSlot bookedSlot = new BookedSlot(slot.getDuration(), slot.getTypeOfActivity(), slot.getAssignee(), slot.getCourse(), starthour, endhour, weekday, room); 
    return bookedSlot; 
  }

  

}