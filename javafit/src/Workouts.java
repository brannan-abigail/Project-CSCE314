import java.util.ArrayList;


public class Workouts {

  private final ArrayList<Workout> workoutList = new ArrayList<Workout>();
  
  //add a new workout to the workoutList
  public final void addWorkout(String name, Config.Equipment equipment, Config.Muscle primaryMuscle, Config.Muscle secondaryMuscle, String desc, String reminders) {
    Workout newWorkout = new Workout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
    workoutList.add(newWorkout);
  }
  public final void addWorkout(Workout workout) {
    workoutList.add(workout);
  }
  
  //Return 
  public final int size() {
	  return workoutList.size();
  }
  
  //Searches workoutList for all in given muscle including the secondary muscle based on input
  public final Workouts getWorkoutsByMuscle(Config.Muscle m, boolean includeSecondary) {
    Workouts retval = new Workouts();
    for (Workout w : workoutList) {
      if(w.hasPrimaryMuscle(m)) {
        retval.addWorkout(w);
      }
      else if (includeSecondary && w.hasSecondaryMuscle(m)) {
        retval.addWorkout(w);
      }
    }
    return retval;
  }
  //New function returning Workouts object with all workouts using the muscles given in list.
  public final Workouts getWorkoutsByMuscle(ArrayList<Config.Muscle> m, boolean includeSecondary) {
	  Workouts retval = new Workouts();
	    for (Workout w : workoutList) {
	    	if(w.hasPrimaryMuscle(m)) {
	            retval.addWorkout(w);
	          }
	          else if (includeSecondary && w.hasSecondaryMuscle(m)) {
	            retval.addWorkout(w);
	          }
	    }
	    return retval;
	}
  
  //Returns Workouts object that contains all workout using the equipment given
  public final Workouts getWorkoutsByEquipment(Config.Equipment e) {
    Workouts retval = new Workouts();
    for(Workout w : workoutList) {
      if(w.hasEquipment(e)) {
        retval.addWorkout(w);
      }
    }
    return retval;
  }
  //Returns Workouts object contains all workout using all the equipemnt given in the list
  public final Workouts getWorkoutsByEquipment(ArrayList<Config.Equipment> e) {
    Workouts retval = new Workouts();
    for(Workout w : workoutList) {
      if(w.hasEquipment(e)) {
        retval.addWorkout(w);
      }
    }
    return retval;
  }
  
 //This should return an instance of the workout class that matches the index in the workoutList.
  public final Workout getWorkout(int index) {
	  return workoutList.get(index);
  }
  
  //This function returns a list of all of the names of the workouts
  public final ArrayList<String> getNames() {
    ArrayList<String> retval = new ArrayList<String>();
    for(Workout w : workoutList) {
      retval.add(w.getName());
    }
    return retval;
  }
  
  //This searches through the list of workouts in the class and returns the index of the workout with that name.
  public final int findWorkoutByName(String name) {
	  int index = 0;
	  for (Workout w : workoutList) {
		  if (name == w.getName()) {
			  return index;
		  }
		  index++;
	  }
	  return -1;
  }
 
  //This returns all the equipment for all the workouts in the workoutList
  public final ArrayList<String> getEquipment() {
	  ArrayList<String> retval = new ArrayList<String>();
	    for(Workout w : workoutList) {
	      retval.add(w.getEquipment());
	    }
	  return retval;
  }
  
  
  //This should return the equipment of the workout at the given index.
  public final String getWorkoutEquipment(int index)  {
	  return workoutList.get(index).getEquipment().toString();
  } 
 
  
  //This returns a list with the full information of the workouts
  public final ArrayList<String[]> getFullInformation() {
    ArrayList<String[]> retval = new ArrayList<String[]>();
    for(Workout w : workoutList) {
      String[] info = new String[6];
      info[0] = w.getName();
      info[1] = w.getEquipment();
      info[2] = w.getPrimaryMuscle();
      info[3] = w.getSecondaryMuscle();
      info[4] = w.getDesc();
      info[5] = w.getReminders();
      retval.add(info);
    }
    return retval; 
  }
  
}