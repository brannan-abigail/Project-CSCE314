### JavaFit: CSCE 314 Java Project

# Project Overview
Fitness for Computer Scientists! JavaFit is a Java application to assist its users to create workouts by reading the given CSV file of workouts for different body parts, and building a workout based on the input of its users. The second phase of this project involved creating the backend and the main window for the GUI, 
as well as the CSV file reader.

## Instructions

# Overview:
This project is composed of two parts. This is phase 2, involving creating an updated backend supporting a design shift seperating the Workout from an inner class in Workouts into its own class, creating the main window for the GUI according to the given specs (below), and anwsering the questions posed in the comments in
a text file.

# Coding:
Backend Changes:
The Muscle and the Equipment enumerations were moved to the Config class, which is where they should have been from the beginning. 

We were to take what you learned writing the loadWorkouts() method and write a loadFormats() group to read a file defined in Config.WORKOUTFORMATFILE as a CSV file and return an enumeration hashmap.

The Workout inner class was changed to public and the Refactor option was used to extract the workout class to a new file, so the class is now its own file. This reflects a design change in the future use of the software.

The following methods were added to the Workout class to function just like the hasEquipment equivalent:
``` protected boolean hasPrimaryMuscle(ArrayList<Config.Muscle> muscleList) ```
``` protected boolean hasSecondaryMuscle(ArrayList<Config.Muscle> muscleList) ```

Similarly, the following methods were added to the Workouts class:
``` public final Workouts getWorkoutsByMuscle(ArrayList<Config.Muscle> m, boolean includeSecondary) ```
This should function just like the getWorkoutsByEquipment equivalent.

``` public final ArrayList<String> getEquipment() ```
This should function just like the getNames equivalent.

``` public final int size() ```
This should return the number of workouts in the class.

``` public final Workout getWorkout(int index) ```
This should return an instance of the workout class that matches the index in the workoutList.

``` public final String getWorkoutEquipment(int index) ```
This should return the equipment of the workout at the given index.

``` public final int findWorkoutByName(String name) ```
This searches through the list of workouts in the class and returns the index of the workout with that name.

The javaFit.java file loads the two data files and creates a new window. 

Frontend Creation:
The bulk of the assignment was to create a Swing class that creates and displays three full-size buttons in a 600x400 window and then add ActionListeners to them that call a function to display the appropriate workout groups.
The WorkoutsPanel.java class was provided for us to use in this frontend.

# Style:
Glen mentioned the importance of use a specific programming style. The refactor tool was used to rename class names as per the Google Java Style Guide. 

# Notes:
Indents in these files are set to 2 spaces. 

# Contents:
1) Working code with none of Glen's code modified.(Graded on completeness, checked for compliance with Academic Honesty standards).
2) Text file with the questions from the comments anwsered concisely, precisely and with examples.

## Build Status
Build Passing

## Code Style
Standard Java (SE 8) using the Google Java Style Guide.

## Tech Used
This application was written entirely in Java and utilizes the Swing library, from the Eclipse editor as instructed. It was tested in a Linux command line (Git Bash).

## Features
The user can construct workouts based upon the muscle group(s) and using the equipment that the user enters.

## Installation
TODO: Figure out installation and write an explanation.

## Use Instructions
This will depend on how the application is installed, but from the command line, to use this application one must:
1) Navigate to the directory with the source files (javaFit.java specifically).
2) Compile the program using ``` javac javaFit.java ```.
3) Run the program using ``` java javaFit ```.

## Contributing
This project is complete and not intended for outside contributions; I may extend the functionality at a later date, but will most likely do so independently.

## Credits
The skeleton code and the base code was written by a TA for my CSCE 314 class, Glen Hordmann. The repository that this was taken from is located at https://github.com/tdeng100/Project-CSCE314.git.
As mentioned, the style guide utilized was the Google Java Style Guide at https://google.github.io/styleguide/javaguide.html.
This README was written based upon the format found at https://medium.com/@meakaakka/a-beginners-guide-to-writing-a-kickass-readme-7ac01da88ab3.
Various articles and tutorials were used for help in creating this project and in anwsering the questions, particularly the documentation for the Swing library and components.