package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();

        int userChoice = 0;

        loop:
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("---------------------------------------------------------------");
            System.out.println("Menu : 1. Create a Rubric, 2. Add a Criterion to a Rubric, 3. Get a list of all Rubrics, 4. Get a specific Rubric by name, ");
            System.out.println("5. Create a new Student Grade, 6. Add a score for a particular criterion to a grade, 7. Get all Student Grades for a specific Rubric, ");
            System.out.println("8. Get summary calculations for a Rubric, 9. Get summary calculations for a Criterion, 10. Exit");
            System.out.println("Enter your choice from the menu above - ");

            try {
                userChoice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice, please try again!");
            }

            System.out.println("User chose - " + userChoice);

            switch (userChoice) {
                case 1: //Create a Rubric
                    controller.createRubric();
                    break;

                case 2: //Add Criteria to Rubric
                    controller.addCriteriaToRubric();
                    break;

                case 3: //Get all Rubrics
                    controller.getRubrics();
                    break;

                case 4: //Get a Rubric by name
                    controller.getRubricByName();
                    break;

                case 5: //Create a student grade

                    controller.createStudentGrade();
                    break;

                case 6: //Add a score for a particular criterion

                    controller.addScoreForCriterion();
                    break;

                case 7: //Get all student grades for a specific Rubric

                    controller.getAllStudentGradesForARubric();
                    break;

                case 8: //Summary calculations for a Rubric

                    controller.getSummaryCalculationsForARubric();
                    break;

                case 9: //Summary calculations for a Criterion

                    controller.getSummaryCalculationsForACriterion();
                    break;

                case 10: //Exit system
                    System.out.println("Goodbye");
                    break loop;

                default:
                    System.out.println("Command not recognised, please try again!");
            }
        }
    }
}
