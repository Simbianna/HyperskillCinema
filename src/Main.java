import java.util.Scanner;

/**
 * JetBrains Academy task solution. Cinema.
 * The cinema has n rows, each row consists of m seats (n and m do not exceed 20).
 * The two-dimensional matrix stores the information on the sold tickets,
 * number 1 means that the ticket for this place is already sold, the number 0 means that the place is available.
 * You want to buy k tickets to the neighboring seats in the same row. Find whether it can be done.
 * Input data format
 * <p>
 * On the input, the program gets the number of n rows and m seats.
 * Then, there are n lines, each containing m numbers (0 or 1) separated by spaces. The last line contains a number k.
 * <p>
 * Output data format
 * <p>
 * The program should output the number of the row with k consecutive available seats.
 * If there are several rows with k available seats, output the first row with these seats. If there is no such a row, output the number 0.
 * <p>
 * Sample Input 1:
 * <p>
 * 3 4
 * 0 1 0 1
 * 1 1 0 1
 * 1 0 0 1
 * 2
 * <p>
 * Sample Output 1:
 * <p>
 * 3
 * Sample Input 2:
 * <p>
 * 3 3
 * 0 1 0
 * 1 0 0
 * 1 1 1
 * 3
 * Sample Output 2:
 * <p>
 * 0
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int m = 0;
        try {
            String[] line = scanner.nextLine().split(" ");
            n = Integer.parseInt(line[0]);
            m = Integer.parseInt(line[1]);
        } catch (NumberFormatException nfe) {
            System.out.println("line doesnt contain numbers");
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println("Not enough numbers");
        }

        if (n >= 0 && n <= 20 && m >= 0 && m <= 20) {
            int[][] matrix = new int[n][m];
            fillMatrix(matrix, scanner);
            int k = scanner.nextInt();
            System.out.println(getAvailableSeatsInRow(matrix, k));
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        try {
            for (int i = 0; i < matrix.length; i++) {
                String[] line = scanner.nextLine().split(" ");
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("line doesnt contain numbers");
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println("Not enough numbers");
        }

    }

    private static int getAvailableSeatsInRow(int[][] matrix, int visitors) {
        int result = 0;
        int visitorsLeft = visitors;

        for (int i = 0; i < matrix.length; i++) {
            if (visitorsLeft == 0) {
                break;
            }
            visitorsLeft = visitors;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    visitorsLeft--;
                } else {
                    visitorsLeft = visitors;
                }
                if (visitorsLeft == 0) {
                    result = i + 1;
                    break;
                }
            }

        }
        return result;
    }
}

