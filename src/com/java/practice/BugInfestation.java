package com.java.practice;

import java.util.Scanner;

public class BugInfestation {

    public static final double GROWTH_RATE = 0.95;//95% per week
    public static final double ONE_BUG_VOLUME = 0.002;//cubic feet

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total volume of your house");
        System.out.print("in cubic feet: ");
        double houseVolume = sc.nextDouble();

        System.out.println("Enter the estimated number of");
        System.out.print("roaches in your house:");
        int startPopulation = sc.nextInt();
        int countWeeks = 0;
        double population = startPopulation;
        double totalBugVolume = population*ONE_BUG_VOLUME;

        while (totalBugVolume < houseVolume)
        {
            population = population + (GROWTH_RATE*population);
            totalBugVolume = population*ONE_BUG_VOLUME;
            countWeeks++;
        }

        System.out.println("Starting with a roach population of "
                + startPopulation);
        System.out.println("and a house with a volume of "
                + houseVolume + " cubic feet,");
        System.out.println("after " + countWeeks + " weeks,");
        System.out.println("the house will be filled");
        System.out.println("floor to ceiling with roaches.");
        System.out.println("There will be " + (int)population
                + " roaches.");
        System.out.println("They will fill a volume of "
                + (int)totalBugVolume + " cubic feet");
        System.out.println("Better call Debugging Experts Inc.");
    }

}
