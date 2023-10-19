package org.example;

import java.util.Scanner;

public class GradeCalculatorWithColors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int totalMarks = 0;
        double averagePercentage;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Marks should be between 0 and 100. Please re-enter.");
                i--; // Decrement i to re-enter marks for the same subject.
                continue;
            }
            totalMarks += marks;
        }

        averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;

        String grade = calculateGrade(averagePercentage);

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        displayColoredGrade(grade);

        scanner.close();
    }
    public static String calculateGrade(double percentage) {
        if (percentage >= 70) {
            return "A";
        } else if (percentage >= 60) {
            return "B";
        } else if (percentage >= 50) {
            return "C";
        } else if (percentage >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void displayColoredGrade(String grade) {
        System.out.print("Grade: ");
        switch (grade) {
            case "A+", "A":
                System.out.println("\u001B[32m" + grade + "\u001B[0m"); // Green
                break;
            case "B":
                System.out.println("\u001B[34m" + grade + "\u001B[0m"); // Yellow
                break;
            case "C":
                System.out.println("\u001B[33m" + grade + "\u001B[0m"); // Yellow
                break;
            case "D", "F":
                System.out.println("\u001B[31m" + grade + "\u001B[0m"); // Red
                break;
            default:
                System.out.println(grade);
        }
    }
}
