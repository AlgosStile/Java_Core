package dz_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 Код представляет игровое поле для игры в крестики-нолики в виде двумерного массива gameBoard размером 3x3, где каждый элемент массива содержит числа от 0 до 3, представляющие состояния ячеек поля.
Функция writeGameBoardToFile записывает игровое поле в файл, разделяя числа пробелами и переводя строки для каждой строки игрового поля.
Функция readGameBoardFromFile считывает игровое поле из файла, разделяя числа по пробелам и заполняя двумерный массив gameBoard считанными значениями.
Функция printGameBoard выводит игровое поле на консоль, заменяя числа символами "X" для значения 1, "O" для значения 2, "•" для значения 3 и "-" для остальных значений.
Код выполняет все требуемые функциональные задачи - запись игрового поля в файл, чтение игрового поля из файла и вывод игрового поля на консоль с использованием символов вместо чисел для представления состояний ячеек.
**/
public class TicTacToeFileIO {
    public static void main(String[] args) {
        int[][] gameBoard = {
                {1, 0, 2},
                {0, 1, 2},
                {2, 3, 1}
        };

        String filePath = "путь_к_файлу.txt";

        try {
            writeGameBoardToFile(gameBoard, filePath);
            int[][] importedGameBoard = readGameBoardFromFile(filePath);
            printGameBoard(importedGameBoard);
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    public static void writeGameBoardToFile(int[][] gameBoard, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int[] ints : gameBoard) {
                for (int anInt : ints) {
                    writer.write(Integer.toString(anInt));
                    writer.write(" ");
                }
                writer.newLine();
            }
        }
    }

    public static int[][] readGameBoardFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int[][] gameBoard = new int[3][3];
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null && row < 3) {
                String[] values = line.trim().split("\\s+");
                for (int col = 0; col < 3 && col < values.length; col++) {
                    gameBoard[row][col] = Integer.parseInt(values[col]);
                }
                row++;
            }
            return gameBoard;
        }
    }

    public static void printGameBoard(int[][] gameBoard) {
        for (int[] ints : gameBoard) {
            for (int value : ints) {
                String symbol = switch (value) {
                    case 1 -> "X";
                    case 2 -> "O";
                    case 3 -> "•";
                    default -> "-";
                };
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}
