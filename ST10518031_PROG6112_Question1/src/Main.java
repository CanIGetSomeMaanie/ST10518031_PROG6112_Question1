import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] cities = {"Cape Town", "Port Elizabeth", "Pretoria"};
        String[]  ElectronicConsolesFranchises = {"PS5", "XBOX", "SWICH"};

        int[][]ConsoleData = new int[cities.length][ ElectronicConsolesFranchises.length];

        // prompt user for Electronic Consoles Franchise per city
        for (int i = 0; i < cities.length; i++) {
            System.out.print("Enter the number of PS5 for " + cities[i] + ": ");
            ConsoleData[i][0] = input.nextInt();

            System.out.print("Enter the number of XBOX for " + cities[i] + ": ");
            ConsoleData[i][1] = input.nextInt();

            System.out.print("Enter the number of SWICH for " + cities[i] + ": ");
            ConsoleData[i][2] = input.nextInt();
        }

        String dashes = "-".repeat(60);

        System.out.println();
        System.out.println(dashes);
        System.out.println("GAMING CONSOLE REPORT");
        System.out.println(dashes);

        // print header row
        System.out.printf("%-16s", "");
        for (int j = 0; j < ElectronicConsolesFranchises.length; j++) {
            System.out.printf("%-12s", ElectronicConsolesFranchises[j]);
        }
        System.out.println();

//        // print data rows
        for (int i = 0; i < ConsoleData.length; i++) {
            System.out.printf("%-16s", cities[i]);
            for (int j = 0; j < ConsoleData[i].length; j++) {
                System.out.printf("%-12d", ConsoleData[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(dashes);
        System.out.println("CONSOLE SALES TOTALS FOR EACH CITY");
        System.out.println(dashes);

        // calculate, print each city's total, tracking which city has the most sales
        int[] cityTotals = new int[cities.length];
        int highestTotal = 0;
        int highestCityIndex = 0;

        for (int i = 0; i < ConsoleData.length; i++) {
            int total = 0;
            for (int j = 0; j < ConsoleData[i].length; j++) {
                total += ConsoleData[i][j];
            }
            cityTotals[i] = total;

            System.out.printf("%-16s%d%n", cities[i], total);

            if (total > highestTotal) {
                highestTotal = total;
                highestCityIndex = i;
            }
        }

        System.out.println();
        System.out.println("CITY WITH THE MOST SALES: " + cities[highestCityIndex]);
        System.out.println(dashes);

        input.close();
    }
}