package sgh;
import java.nio.File.*;
import java.io.File;
import java.util.Scanner;

public class TicTacToe {

    public static String readFileAsString(String fileName) throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws Exception
    {
        char o = 'o';
        char x = 'x';
        int totalRow = 3;
        int totalColumn = 5;
        char[][] GameBoard = new char[totalRow][totalColumn];
        String data = readFileAsString("main/resources/board/tick1.csv");
        Scanner scanner = new Scanner (data);

        for (int row = 0; scanner.hasNextLine() && row < totalRow; row++)
        {
            char[] chars = scanner.nextLine().toCharArray();
            for (int i = 0; i < totalColumn && i < chars.length; i++) {
                GameBoard[row][i] = chars[i];
            }
        }
        int matchx = 0;
        int matcho = 0;
        int matchempty = 0;
        int xwon = 0;
        int owon = 0;
        int empty = 0;

        // checking rows
        for (int m=0; m<3; m++)
        {

            for (int n = 0; n < 5; n++) {
                if (GameBoard[m][n] == x) {
                    matchx++;
                }
                if (GameBoard[m][n] == o) {
                    matcho++;
                }
                if (GameBoard[m][n] == ' ') {
                    matchempty++;
                }
            }


                if (matchx == 3) {
                    xwon++;
                    System.out.println("X_WON");
                } else if (matcho == 3) {
                    owon++;
                    System.out.println("O_WON");
                } else if (matchempty == 1) {
                    empty++;
                    System.out.println("NOT_FINISHED");
                }
                if (xwon == 1 || owon == 1 || empty == 1) {
                    break;
                }
                if (xwon != 1 || owon !=1) {
                    matchx = 0;
                    matcho = 0;
                }
                if (xwon != 1) {
                    xwon = 0;
                }
                if (owon != 1) {
                    owon = 0;
                }
        }

        //checking columns
        for (int n=0; n<5; n++)
        {

            for (int m = 0; m < 3; m++) {
                if (GameBoard[m][n] == x) {
                    matchx++;
                }
                if (GameBoard[m][n] == o) {
                    matcho++;
                }
                if (GameBoard[m][n] == ' ') {
                    matchempty++;
                }
            }


            if (matchx == 3) {
                xwon++;
                System.out.println("X_WON");
            } else if (matcho == 3) {
                owon++;
                System.out.println("O_WON");
            } else if (matchempty == 1) {
                empty++;
                System.out.println("NOT_FINISHED");
            }
            if (xwon == 1 || owon == 1 || empty == 1) {
                break;
            }
            if (xwon != 1 || owon !=1)
            {
                matchx = 0;
                matcho = 0;

            }
            if (xwon != 1) {
                xwon = 0;
            }
            if (owon != 1) {
                owon = 0;
            }
        }

            // checking 1st diagonal
        if (GameBoard[0][0] == x && GameBoard[1][2] == x && GameBoard[2][4] == x) {
            xwon++;
            System.out.println("X_WON");
        }
        if ((GameBoard[0][0] == o && GameBoard[1][2] == o && GameBoard[2][4] == o)) {
            owon++;
            System.out.println("O_WON");
        }
        if (GameBoard[0][0] == ' ' || GameBoard[1][2] == ' ' || GameBoard[2][4] == ' ') {
            empty++;
            System.out.println("NOT_FINISHED");
        }
        if (xwon != 1) {
            xwon = 0;
        }
        if (owon != 1) {
            owon = 0;
        }

           // checking 2nd diagonal
        if (GameBoard[0][4] == x && GameBoard[1][2] == x && GameBoard[2][0] == x) {
            xwon++;
            System.out.println("X_WON");
        }
        if ((GameBoard[0][4] == o && GameBoard[1][2] == o && GameBoard[2][0] == o)) {
            owon++;
            System.out.println("O_WON");
        }
        if (GameBoard[0][4] == ' ' || GameBoard[1][2] == ' ' || GameBoard[2][0] == ' ') {
            empty++;
            System.out.println("NOT_FINISHED");
        }
        if (xwon != 1) {
            xwon = 0;
        }
        if (owon != 1) {
            owon = 0;
        }

            // checking if draw
        if (xwon != 1 && owon != 1 && empty == 0) {
            System.out.println("NO_WINNER");
        }
//     public enum Result { NOT_FINISHED, NO_WINNER, X_WON, O_WON }

//     public static Result checkBoard(String boardFileName) {
//         File boardFile = new File(boardFileName);
//         System.out.println(boardFile.getAbsolutePath());

//         // Your code here

//         return Result.NO_WINNER;
//     }


//     public static void main(String[] args) {
//         Result res = checkBoard("boards/tick0.csv");
//         System.out.println(res);
//     }
// }
