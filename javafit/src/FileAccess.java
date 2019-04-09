import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

// Write code to load the workouts from the provided workouts.csv file. The function should return a Workouts object.

public class FileAccess {
  
	// What is a try/catch block and why do we need one?
   // What is an exception?
  public static Workouts loadWorkouts() {
	  
	  Workouts loadedWorkouts = new Workouts();
	  String csvFile = "workouts.csv";
	  BufferedReader br = null;
	  String line = "";
	  String csvSplitBy=",";
	  
	  try {
		  br = new BufferedReader(new FileReader(csvFile));
		  while ((line = br.readLine()) != null) {
			  String[] workoutString = line.split(csvSplitBy);
			  
			  String name = workoutString[0]; 
			  Workouts.Equipment equipment = Workouts.Equipment.valueOf(workoutString[1]); 
			  Workouts.Muscle primaryMuscle = Workouts.Muscle.valueOf(workoutString[2]);
			  Workouts.Muscle secondaryMuscle = Workouts.Muscle.valueOf(workoutString[3]); 
			  String desc = workoutString[4];
			  String reminders = workoutString[5];
			  
			  loadedWorkouts.addWorkout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
		  }
	  } catch (FileNotFoundException e) {
		  System.out.println(e);
		  e.printStackTrace();
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
		e.printStackTrace();
	  } finally {
		  if (br != null) {
			  try {
				  br.close();
			  } catch (IOException e) {
				  e.printStackTrace();
			  }
		  }
	  }
	 
	  return loadedWorkouts;
  }
}
