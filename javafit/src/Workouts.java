import java.util.ArrayList; // We choose ArrayList over Vector because...? 
/**
* Use the provided enumerations and code framework to create our workouts class.
* This class should contain all the functionality we need to interact with our workout list.
* Minimize duplication of code by writing helper functions as needed.
* 
* Do not change any of the provided code, although you can, and should, add to it as needed. 
* (E.G. Do not make private attributes public, or change the parameters of a function.)
*/

public class Workouts {

  // Use the Refactor functionality in Eclipse to rename "muscle" to "Muscle" to match our naming convention.
  public enum Muscle {ABS, BACK, BICEPS, CHEST, FOREARM, GLUTES, LOWERLEG, SHOULDER, TRICEPS, UPPERLEG, NONE} // Why didn't I have to declare this static?
  public enum Equipment {BARBELL, BODYWEIGHT, DUMBBELL, CABLE, HAMMERSTRENGTH}
	private final ArrayList<Workout> workoutList = new ArrayList<Workout>();
	
	// This is a nested class, also known as an inner class. Why do we use a nested class?
	// You will need to create a number of methods for the inner class. You are not limited to 
	// only the methods listed inside this class.
	private class Workout {
	  private String name;
	  private Equipment equipment;
	  private Muscle primaryMuscle;
	  private Muscle secondaryMuscle;
	  private String desc;
	  private String reminders;
	
    Workout(String name, Equipment equipment, Muscle primaryMuscle, Muscle secondaryMuscle, String desc, String reminders) {
    	this.name = name;
    	this.equipment = equipment;
    	this.primaryMuscle = primaryMuscle;
    	this.secondaryMuscle = secondaryMuscle;
    	this.desc = desc;
    	this.reminders = reminders;
    }
    // How do we get the name of an enumeration value?
	}

// This function adds a new workout to the Workouts object.
  public final void addWorkout(String name, Equipment equipment, Muscle primaryMuscle, Muscle secondaryMuscle, String desc, String reminders)
  {
	 Workout newWorkout = new Workout(name, equipment, primaryMuscle, secondaryMuscle, desc,  reminders);
	 workoutList.add(newWorkout);
  }
  
  // This function adds a workout to the Workouts object.
  public final void addWorkout(Workout workout)
  {
	  workoutList.add(workout);
  }
  
  // This list returns a new Workouts object that contains only the workouts that contain the
  // Equipment value that is provided as an argument. The programmer has an option to get
  // Workouts that only have the Muscle in the PrimaryMuscle attribute, or to also look
  // in the secondaryMuscle category.
	public final Workouts getWorkoutsByMuscle(Muscle m, boolean includeSecondary)
	{
	  // What is short-circuit evaluation?
		Workouts workoutsUsingMuscles = new Workouts();
		  for (Workout workout: workoutList) {
			  if (workout.primaryMuscle.equals(m)) {
				  workoutsUsingMuscles.addWorkout(workout);
			  } else {
				  if (includeSecondary) {
					  if (workout.secondaryMuscle.equals(m)) {
						  workoutsUsingMuscles.addWorkout(workout);
					  }
				  }
			  }
		  }
		return workoutsUsingMuscles;
	}
	
// This list returns a new Workouts object that contains only the workouts that contain the
// Equipment value that is provided as an argument.
  public final Workouts getWorkoutsByEquipment(Equipment e)
  {
	  Workouts workoutsUsingEquipment = new Workouts();
	  for (Workout workout: workoutList) {
			  if (workout.equipment.equals(e)) {
				  workoutsUsingEquipment.addWorkout(workout);
			  }
	  }
	  return workoutsUsingEquipment;
  }
	
  // This returns a new Workouts object that contains only the workouts that contain an Equipment
  // value that is in the provided ArrayList of Equipment.
  public final Workouts getWorkoutsByEquipment(ArrayList<Equipment> e)
  {
	  Workouts workoutsUsingEquipment = new Workouts();
	  for (Workout workout: workoutList) {
		  for (Equipment equipment: e) {
			  if (workout.equipment.equals(equipment)) {
				  workoutsUsingEquipment.addWorkout(workout);
			  }
		  }
	  }
	  return workoutsUsingEquipment;
  }
	
  // This method returns an ArrayList of Strings. Each String is a name of a workout in our Workouts list.
  public final ArrayList<String> getNames()
  {
	  ArrayList<String> workoutsNames = new ArrayList<String>();
	  for (Workout workout: workoutList) {
		  workoutsNames.add(workout.name);
	  }
	  return workoutsNames;
	  
  }
 
  // This method returns all the information of the Workouts as an ArrayList of String arrays, 
  // one entry in the ArrayList per Workout. The String array should contain the workout's Name, 
  // Equipment, Primary and Secondary Muscles, Description, and Reminders. All of these should be strings.
  public final ArrayList<String[]> getFullInformation()
  {
	  ArrayList<String[]> allInfo = new ArrayList<String[]>();
	  for (Workout workout: workoutList) {
		  String[] workoutInfo = new String[6];
		  workoutInfo[0] = workout.name;
		  workoutInfo[1] = workout.equipment.toString();
		  workoutInfo[2] = workout.primaryMuscle.toString();
		  workoutInfo[3] = workout.secondaryMuscle.toString();
		  workoutInfo[4] = workout.desc;
		  workoutInfo[5] = workout.reminders;
		  
		  allInfo.add(workoutInfo);
	  }
	  return allInfo;
  }
}