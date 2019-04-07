import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

// Write code to load the workouts from the provided workouts.csv file. The function should return a Workouts object.

public class FileAccess {
  
	// What is a try/catch block and why do we need one?
   // What is an exception?
  public static Workouts loadWorkouts() {
	  
	  try {
		  FileInputStream fis = new FileInputStream("workouts.csv");
		  System.out.println("I loaded the file!");
		  fis.close();
	  }
	  catch (FileNotFoundException e) {
		  System.out.println(e);
		  e.printStackTrace();
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
		e.printStackTrace();
	}
	 
	  return new Workouts();
  }

}
