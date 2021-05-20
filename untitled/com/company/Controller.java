package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Controller {

    //Scanner for user input
    Scanner input = new Scanner(System.in);

    //Global string variables
    String rubricName;
    String finalRubricName;

    //Global rubric object
    Rubric found;

    //Global lists
    ArrayList<Rubric> rubrics = new ArrayList<>();
    ArrayList<StudentGrade> studentGrades = new ArrayList<>();

    public void createRubric() {
        //Create a rubric
        Rubric createdRubric = new Rubric();
        //Ask user to name Rubric
        System.out.println("Enter Rubric Name : ");
        //User input
        rubricName = input.nextLine().toLowerCase(Locale.ROOT);

        //Setting final name to not cause duplication of naming due to object mapping
        finalRubricName = rubricName;
        //Check if the Rubric name is already used, return null if not
        found = rubrics.stream()
                .filter(rubricInList -> finalRubricName.equals(rubricInList.getRubricName()))
                .findAny()
                .orElse(null);

        //Check if null or not
        if (found == null) {
            //If it's not set the Rubric name with the user input
            createdRubric.setRubricName(rubricName);

            //Add the Rubric to the list of Rubrics
            rubrics.add(createdRubric);
        } else {
            //Error message
            System.out.println("Sorry, this Rubric already exists, please try again!");
        }
        //Success message
        System.out.println("Rubric added successfully!");
    }

    public void addCriteriaToRubric() {
        //Setting variables
        int criteriaLength;

        //Ask user for Rubric name
        System.out.println("Enter the name of Rubric you wish to add a Criteria to : ");
        //Take in user input
        rubricName = input.nextLine().toLowerCase(Locale.ROOT);
        //check if the Rubric already exists, return null if it does
        found = rubrics.stream()
                .filter(rubricInList -> rubricName.equals(rubricInList.getRubricName()))
                .findAny()
                .orElse(null);

        //Check if null or not
        if (found != null) {
            //Ask user for the number of criteria there are in the Rubric
            System.out.println("How many criteria do you wish to add? (Max of 10) - ");
            //Take in user input - check if valid
            try {
                criteriaLength = Integer.parseInt(input.nextLine().toLowerCase(Locale.ROOT));
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number, please try again!");
                criteriaLength = Integer.parseInt(input.nextLine().toLowerCase(Locale.ROOT));
            }
            //Create an array of criteria for a Rubric
            ArrayList<String> rubricCriteriaList = found.getCriteria();

            //Check if it is greater than 10 already or will be with the new criteria
            if (criteriaLength > 10 || (rubricCriteriaList.size() + criteriaLength) > 10) {
                //Error message
                System.out.println("Too many criteria, please try again! (Max of 10)");
            } else {
                //For loop to run the amount of times the user asked for to name all the criteria
                for (int i = 0; i < criteriaLength; i++) {
                    //User input
                    System.out.println("Enter Criteria Name : ");
                    //Get criterion name
                    String criterionName = input.nextLine().toLowerCase(Locale.ROOT);

                    //Check if the name already exists in the array
                    if (rubricCriteriaList.contains(criterionName)) {
                        //Error message
                        System.out.println("Sorry, this criteria already exists, please try again!");
                    } else {
                        //Add criterion if it doesn't exist
                        rubricCriteriaList.add(criterionName);
                    }

                }
                //Success message
                System.out.println("Criteria added successfully!");
            }
        } else {
            //Error message
            System.out.println("Rubric does not exist, please try again!");
        }
    }

    public void getRubrics() {
        //Print out the Rubrics by going through the list
        rubrics.forEach(System.out::println);
    }

    public void getRubricByName() {
        //Ask user for Rubric name
        System.out.println("Enter the name of the Rubric you wish to see : ");
        //User input
        rubricName = input.nextLine().toLowerCase(Locale.ROOT);

        //Check if the Rubric exists, return null if not
        found = rubrics.stream()
                .filter(rubricInList -> rubricName.equals(rubricInList.getRubricName()))
                .findAny()
                .orElse(null);

        //Check if null or not
        if (found != null) {
            //Print out the Rubric if found
            System.out.println(found);
        } else {
            //Error message
            System.out.println("Rubric does not exist, please try again!");
        }
    }

    public void createStudentGrade() {
        //Create a list of criterion for a rubric
        ArrayList<String> rubricCriterion;
        //Setting variable
        int score;
        //Create a studentGrade object
        StudentGrade studentGrade = new StudentGrade();
        //Create a criteriaScores hashMap
        HashMap<String, Integer> criteriaScores = new HashMap<>();

        //Ask user for student's name
        System.out.println("What is the student's name? : ");
        //User input
        String studentName = input.nextLine().toLowerCase(Locale.ROOT);

        //Set student name in studentGrade object
        studentGrade.setStudentName(studentName);

        //Ask user for Rubric name
        System.out.println("What Rubric are they being graded on? : ");
        //User input
        rubricName = input.nextLine().toLowerCase(Locale.ROOT);

        //Check if rubric exists, null if it doesn't
        found = rubrics.stream()
                .filter(rubricInList -> rubricName.equals(rubricInList.getRubricName()))
                .findAny()
                .orElse(null);

        //Check if null
        if (found != null) {
            //Set rubricName in studentGrade object
            studentGrade.setRubricName(rubricName);
            //Get criteria for the chosen rubric
            rubricCriterion = found.getCriteria();

            //Check if list of criteria is empty
            if (!rubricCriterion.isEmpty()) {
                //Run through the criteria one by one
                for (String criteria : rubricCriterion) {
                    //Ask user for score for each criteria
                    System.out.println("What score did " + studentName + " get in " + criteria + " : ");
                    //User input - check if valid
                    try {
                        score = Integer.parseInt(input.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Input must be a number, please try again!");
                        score = Integer.parseInt(input.nextLine());
                    }

                    //Check if score between 1 and 5
                    if (score < 1 || score > 5) {
                        //Error message
                        System.out.println("Score must be between 1 and 5, please try again!");
                    } else {
                        //Add to criteriaScores hashMap
                        criteriaScores.put(criteria, score);
                        //Set score in studentGrade object with the criteriaScores
                        studentGrade.setScores(criteriaScores);
                    }
                }
                //Add to studentGrade to studentGrades list
                studentGrades.add(studentGrade);
                //Success message
                System.out.println("Student Grade added successfully!");
            } else {
                //Error message
                System.out.println("Sorry this rubric has no criteria yet, please try again!");
            }
        } else {
            //Error message
            System.out.println("No Rubric found, please try again!");
        }
    }

    public void addScoreForCriterion() {
        //Create a list of criterion for a rubric
        ArrayList<String> rubricCriterion = new ArrayList<>();
        //Create a hashMap
        HashMap<String, Integer> studentGradeFound = new HashMap<>();
        //Setting variable
        int score;

        //Ask user for student's name
        System.out.println("Enter the student's name : ");
        //User input
        String studentName = input.nextLine().toLowerCase(Locale.ROOT);

        //Ask user for rubric name
        System.out.println("Enter the rubric name : ");
        //User input
        rubricName = input.nextLine().toLowerCase(Locale.ROOT);

        //Check if rubric exists
        found = rubrics.stream()
                .filter(rubricInList -> rubricName.equals(rubricInList.getRubricName()))
                .findAny()
                .orElse(null);

        //Check if null
        if (found != null) {
            //Run through studentGrades list
            for (StudentGrade studentGrade : studentGrades) {
                //Check if name and rubric name are stored on an existing studentGrade object
                if (studentGrade.getStudentName().equals(studentName) && studentGrade.getRubricName().equals(rubricName)) {
                    //Get the criteria for the found rubric
                    rubricCriterion = found.getCriteria();
                    //Get the scores from the studentGrade object and store in hashMap object
                    studentGradeFound = studentGrade.getScores();
                } else {
                    //Error message
                    System.out.println("No grade found for this student on this Rubric");
                }
            }
            //Ask user for criteria name from listed criteria
            System.out.println("Which of these criteria do you want to add a score for? : " + rubricCriterion);
            //User input
            String criteria = input.nextLine().toLowerCase(Locale.ROOT);

            //Check if criteria list contains the inputted criteria name
            if (rubricCriterion.contains(criteria)) {
                //Ask user for the score they want to give
                System.out.println("What score do you want to give - " + studentName + " for criteria " + criteria);
                //User input - check if valid
                try {
                    score = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Input must be a number, please try again!");
                    score = Integer.parseInt(input.nextLine());
                }
                //Add/Update the map
                studentGradeFound.put(criteria, score);
            } else {
                //Error message
                System.out.println("Criteria does not exist, please try again!");
            }
            //Success message
            System.out.println("Score added successfully!");
        } else {
            //Error message
            System.out.println("Rubric does not exist, try again!");
        }
    }

    public void getAllStudentGradesForARubric() {
        //Ask user for Rubric name
        System.out.println("Enter the name of the Rubric you wish to see Student Grades for : ");
        //User input
        rubricName = input.nextLine().toLowerCase(Locale.ROOT);

        //Check if the Rubric exists, return null if not
        found = rubrics.stream()
                .filter(rubricInList -> rubricName.equals(rubricInList.getRubricName()))
                .findAny()
                .orElse(null);

        //Check if null
        if (found != null) {
            //Run through the studentGrades list
            for (StudentGrade studentGrade : studentGrades) {
                //Check for studentGrade objects with the inputted rubric name
                if (studentGrade.getRubricName().equals(rubricName)) {
                    //Display
                    System.out.println(studentGrade);
                } else {
                    //Error message
                    System.out.println("No student grades for this Rubric, please try again!");
                }
            }
        } else {
            //Error message
            System.out.println("Sorry no Rubric with this name, please try again!");
        }
    }

    public void getSummaryCalculationsForARubric() {
        //Create a map for storing the studentGrade objects for the specific Rubric
        HashMap<String, Integer> studentGradesForRubric = new HashMap<>();
        //Create an array to store the totalScore for each student for a Rubric
        ArrayList<Integer> rubricScores = new ArrayList<>();

        //Setting variables
        int score = 0, totalScore = 0, maximum = 0, minimum = 50;
        double average, standardDeviationTotalScore = 0, standardDeviation, standardDeviationAverage;

        //Ask user for Rubric name
        System.out.println("Enter Rubric name : ");
        //User input
        rubricName = input.nextLine().toLowerCase(Locale.ROOT);

        //Check if the Rubric exists, return null if not
        found = rubrics.stream()
                .filter(rubricInList -> rubricName.equals(rubricInList.getRubricName()))
                .findAny()
                .orElse(null);

        //Check if null or not
        if (found != null) {
            //Run through studentGrades list
            for (StudentGrade studentGrade : studentGrades) {
                //Check for the inputted rubric
                if (studentGrade.getRubricName().equals(rubricName)) {
                    //Add the studentGrade scores to the studentGradesForRubric hashMap
                    studentGradesForRubric.putAll(studentGrade.getScores());
                } else {
                    //Error message
                    System.out.println("No scores for this Rubric, try again!");
                }
                //Run through the studentGradesForRubric hashMap
                for (String criterion : studentGradesForRubric.keySet()) {
                    //Add the scores per criterion together for each student
                    score += studentGradesForRubric.get(criterion);
                }
                //Add the individual scores to an array
                rubricScores.add(score);
                //Set score to 0 to restart the loop
                score = 0;
            }

            //Getting size of array
            double n = rubricScores.size();

            //Running through the rubricScores array to calculate the total, minimum and maximum score
            for (Integer rubricScore : rubricScores) {
                totalScore += rubricScore;
                if (rubricScore < minimum) {
                    minimum = rubricScore;
                }
                if (rubricScore > maximum) {
                    maximum = rubricScore;
                }
            }
            //Calculating average score
            average = totalScore / n;

            //Running through rubricScores array to begin calculating standard deviation
            for (Integer rubricScore : rubricScores) {
                standardDeviationTotalScore += Math.pow((rubricScore - average), 2);
            }

            //Getting average for standard deviation calculation
            standardDeviationAverage = (standardDeviationTotalScore) / n;

            //Getting standard deviation score
            standardDeviation = Math.sqrt(standardDeviationAverage);

            //Outputting results
            System.out.println("Average score for Rubric : " + rubricName + " - is : " + average);
            System.out.println("Standard Deviation score for Rubric : " + rubricName + " - is : " + standardDeviation);
            System.out.println("Minimum score for Rubric : " + rubricName + " - is : " + minimum);
            System.out.println("Maximum score for Rubric : " + rubricName + " - is : " + maximum);
        } else {
            //Error message
            System.out.println("Rubric does not exist, please try again!");
        }
    }

    public void getSummaryCalculationsForACriterion() {
        //Create a map for storing the studentGrade objects for the specific Criterion
        HashMap<String, Integer> studentGradesForCriterion = new HashMap<>();
        //Create a criteria list
        ArrayList<String> criteria;
        //Create a criterionScores list
        ArrayList<Integer> criterionScores = new ArrayList<>();

        //Setting variables
        int totalScore = 0, maximum = 0, minimum = 5;
        double average, standardDeviationTotalScore = 0, standardDeviation, standardDeviationAverage;

        //Ask user for Rubric name
        System.out.println("Enter Rubric name : ");
        //User input
        rubricName = input.nextLine().toLowerCase(Locale.ROOT);

        //Check if the Rubric exists, return null if not
        found = rubrics.stream()
                .filter(rubricInList -> rubricName.equals(rubricInList.getRubricName()))
                .findAny()
                .orElse(null);

        //Check if null
        if (found != null) {
            //Get the criteria for the Rubric
            criteria = found.getCriteria();

            //Ask user to input which criterion they want to choose
            System.out.println("Which criteria from the list would you like to see a summary for - " + criteria);
            //User input
            String criterionInput = input.nextLine().toLowerCase(Locale.ROOT);

            //Check if input is valid in list
            if (criteria.contains(criterionInput)) {
                //Run through studentGrades list
                for (StudentGrade studentGrade : studentGrades) {
                    //Check for the inputted rubric
                    if (studentGrade.getRubricName().equals(rubricName)) {
                        //Add the studentGrade scores to the studentGradesForCriterion hashMap
                        studentGradesForCriterion.putAll(studentGrade.getScores());
                    } else {
                        //Error message
                        System.out.println("No scores for this Rubric, try again!");
                    }

                    //Run through studentGradeForCriterion hashMap
                    for (String criterion : studentGradesForCriterion.keySet()) {
                        //Check for the inputted criterion
                        if (criterion.equals(criterionInput)) {
                            //Add the score in for the criterion
                            criterionScores.add(studentGradesForCriterion.get(criterion));
                            //Adding scores together
                            totalScore += studentGradesForCriterion.get(criterion);
                            //Get minimum
                            if (studentGradesForCriterion.get(criterion) < minimum) {
                                minimum = studentGradesForCriterion.get(criterion);
                            }
                            //Get maximum
                            if (studentGradesForCriterion.get(criterion) > maximum) {
                                maximum = studentGradesForCriterion.get(criterion);
                            }
                        }
                    }
                }

                //Get length of array
                double n = criterionScores.size();
                //Calculate average score
                average = totalScore / n;

                //Running through rubricScores array to begin calculating standard deviation
                for (Integer criterionScore : criterionScores) {
                    standardDeviationTotalScore += Math.pow((criterionScore - average), 2);
                }

                //Getting average for standard deviation calculation
                standardDeviationAverage = (standardDeviationTotalScore) / n;

                //Getting standard deviation score
                standardDeviation = Math.sqrt(standardDeviationAverage);

                //Outputting results
                System.out.println("Average score for criterion : " + criterionInput + " - is : " + average);
                System.out.println("Standard Deviation score for criterion : " + criterionInput + " - is : " + standardDeviation);
                System.out.println("Minimum score for criterion : " + criterionInput + " - is : " + minimum);
                System.out.println("Maximum score for criterion : " + criterionInput + " - is : " + maximum);
            } else {
                //Error message
                System.out.println("Criterion does not exist, please try again!");
            }

        } else {
            //Error message
            System.out.println("Rubric does not exist, please try again!");
        }
    }
}
