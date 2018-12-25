package com.java.string;

public class IntegerToEnglishWords {
    final static String[] less20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final static String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    final static String[] thousands = {"", "Thousand", "Million", "Billion", "Trillion"};

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        return translate(num);
    }

    private static String translate(int n) {
        String res = "";
        if (n < 20) res = less20[n];
        else if (n < 100) res = tens[n / 10] + " " + translate(n % 10);
        else if (n < 1000) res = translate(n / 100) + " Hundred " + translate(n % 100);
        else for (int i = 2; i < thousands.length; ++i) {
                long large = (long) Math.pow(10, 3 * i);
                if (n < large) {
                    int small = (int) (large / 1000);
                    res = translate(n / small) + " " + thousands[i - 1] + " " + translate(n % small);
                    break;
                }
            }
        return res.trim();
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(1456));
    }
}
