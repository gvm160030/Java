package com.java.practice;
import java.util.Scanner;
public class ChocolateCoupons {
    /**
     Determines how many chocolate bars we can get if each bar costs $1
     and a bar contains a coupon.  6 coupons can be redeemed for another bar.
     */

        public static void main(String[] args)
        {
            Scanner keyboard = new Scanner(System.in);
            int dollars;
            int coupons;
            int bars = 0;

            System.out.println("How much money can you spend on chocolate bars?");
            dollars = keyboard.nextInt();

            // Calculate initial bars and coupons
            bars = dollars;	// $1 per bar
            coupons = bars; // one coupon per bar
            // As long as we have at least 6 coupons
            // redeem them.
            while (coupons >= 6)
            {
                bars += (coupons / 6);  // Integer truncation of remainder
                // New number of coupons is how many are leftover after redemption
                // plus the coupons we got from the new chocolate bars)
                coupons = (coupons % 6) + (coupons / 6);
            }
            System.out.println("After redeeming coupons, you would have " + coupons + " leftover " +
                    "coupons and can purchase a total of " + bars + " chocolate bars.");

        } // end main
    } // end class

