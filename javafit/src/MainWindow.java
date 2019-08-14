import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


// Bonus points: Create an icon (or find a public domain icon. Keep in mind federal Copyright law and TAMU's plagiarism policy and add it to the home screen window.
public class MainWindow {
  
  private final JFrame mainFrame = new JFrame(Config.APPLICATIONNAME);
  private final JDialog selectWorkout = new JDialog(mainFrame, "Select Workout");
  private JComboBox<String> cboType, cboGoal;
  private JSpinner spnDuration;
  private final Workouts workouts = FileAccess.loadWorkouts();
  private final EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups = FileAccess.loadFormats();
  
  //Default constructor never used
  MainWindow() {}

  //Constructor with parameters used
  MainWindow(Workouts workouts, EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups) {
	  
	  //Create buttons
	  JButton upperBodyButton = new JButton("Upper Body Workout");
	  JButton lowerBodyButton = new JButton("Lower Body Workout");
	  JButton wholeBodyButton = new JButton("Whole Body Workout");
	  
	  //Set layout, add components and set visible
	  mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	  mainFrame.setSize(600, 400);
	  mainFrame.setLayout(new GridLayout(3,1));  
	  mainFrame.add(upperBodyButton);
	  mainFrame.add(lowerBodyButton);
	  mainFrame.add(wholeBodyButton);
	  mainFrame.setVisible(true);
	 
	  upperBodyButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	          mainFrame.remove(upperBodyButton);
	          mainFrame.remove(lowerBodyButton);
	          mainFrame.remove(wholeBodyButton);
	          mainFrame.setLayout(new GridLayout(1, 1));
	          showWorkouts(muscleGroups.get(Config.MuscleGroup.UPPERBODY));
	          mainFrame.revalidate();
	          mainFrame.repaint();
	      }
	    });
	  
	  lowerBodyButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  mainFrame.remove(upperBodyButton);
	          mainFrame.remove(lowerBodyButton);
	          mainFrame.remove(wholeBodyButton);
	          mainFrame.setLayout(new GridLayout(1, 1));
	    	  showWorkouts(muscleGroups.get(Config.MuscleGroup.LOWERBODY));
	    	  mainFrame.revalidate();
	          mainFrame.repaint();
	      }
	    });
	  
	  wholeBodyButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  mainFrame.remove(upperBodyButton);
	          mainFrame.remove(lowerBodyButton);
	          mainFrame.remove(wholeBodyButton);
	          mainFrame.setLayout(new GridLayout(1, 1));
	          showWorkouts(muscleGroups.get(Config.MuscleGroup.WHOLEBODY));
	          mainFrame.revalidate();
	          mainFrame.repaint();
	      }
	    }); 
  }
  
  //Launch Home screen with workouts and muscle groups
  private void launchHomeScreen() {
   new MainWindow(workouts, muscleGroups);
  }
  
  // This is the method your actionlistener should call. It should create and display a WorkoutsPanel.
  private void showWorkouts(ArrayList<Config.Muscle> muscles) {
	  WorkoutsPanel workoutsPanel = new WorkoutsPanel(muscles, workouts);
	  mainFrame.add(workoutsPanel);
  }
}
