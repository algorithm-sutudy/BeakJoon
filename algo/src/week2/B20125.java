package week2;

import java.util.*;

public class B20125 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[][] array = initArrays(scanner, n);
        AbstractMap.SimpleEntry<Integer, Integer>[] coordinators = findCoordinators(array);

        System.out.println((coordinators[0].getKey() + 1) + " " + (coordinators[0].getValue() + 1));
        System.out.println(
                getCountByDirection(Direction.Left, coordinators[0].getValue() - 1, coordinators[0].getKey(), array) + " " +
                getCountByDirection(Direction.Right, coordinators[0].getValue() + 1, coordinators[0].getKey(), array) + " " +
                getCountByDirection(Direction.Down, coordinators[0].getKey() + 1, coordinators[0].getValue(), array) + " " +
                getCountByDirection(Direction.Down, coordinators[1].getKey() + 1, coordinators[1].getValue() - 1, array) + " " +
                getCountByDirection(Direction.Down, coordinators[1].getKey() + 1, coordinators[1].getValue() + 1, array)
        );
        scanner.close();
    }

    private static char[][] initArrays(Scanner scanner, int n) {
        char[][] array = new char[n][n];

        Arrays.setAll(array, c -> scanner.next().toCharArray());
        return array;
    }

    private static AbstractMap.SimpleEntry<Integer, Integer>[] findCoordinators(char[][] array) {
        AbstractMap.SimpleEntry<Integer, Integer>[] coordinators = new AbstractMap.SimpleEntry[2];

        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 1; j < array[i].length - 1; j++) {
                if (array[i][j] == '*') {
                    if (array[i - 1][j] == '*' && array[i][j - 1] == '*' && array[i][j + 1] == '*' && array[i + 1][j] == '*') {
                        coordinators[0] = new AbstractMap.SimpleEntry<>(i, j);
                    } else if (array[i + 1][j - 1] == '*' && array[i + 1][j + 1] == '*') {
                        coordinators[1] = new AbstractMap.SimpleEntry<>(i, j);
                    }
                }
            }
        }
        return coordinators;
    }

    private static int getCountByDirection(Direction direction, int start, int other, char[][] array) {
        int result = 0;

        switch (direction) {
            case Down:
                for (int i = start; i < array.length; i++) {
                    if (array[i][other] == '*') result++;
                }
                break;
            case Left:
                for (int i = start; i >= 0; i--) {
                    if (array[other][i] == '*') result++;
                }
                break;
            case Right:
                for (int i = start; i < array[other].length; i++) {
                    if (array[other][i] == '*') result++;
                }
                break;
        }
        return result;
    }

    enum Direction {
        Down, Left, Right
    }
}
