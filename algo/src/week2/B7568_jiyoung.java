package week2;

import java.util.*;

public class Maiㅎn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 전체 사람 수 n (2 <= n <= 50)
        List<Person> pList = new ArrayList<>();

        // 키, 몸무게 Person에 각각 저장하기
        for (int i = 0; i < n; i++) {
            pList.add(new Person(scanner.nextInt(), scanner.nextInt()));
        }

//        // [test] 잘 저장되었는지 출력
//        for (int i = 0; i < n; i++) {
//            int x = pList.get(i).weight;
//            int y = pList.get(i).height;
//            System.out.printf("%d %d\n", x, y);
//        }

        for (int i = 0; i < n; i++) {
            int x = pList.get(i).weight;
            int y = pList.get(i).height;
            for (int j = 0; j < n; j++) {
                if (x < pList.get(j).weight && y < pList.get(j).height) {
                    pList.get(i).rank++;
                }
            }

            int r = pList.get(i).rank;
            System.out.printf("%d ", r);
        }

        scanner.close();
    }
}

class Person {
    int weight, height, rank;

    public Person(int x, int y) {
        this.weight = x;
        this.height = y;
        this.rank = 1; // 1이 기본 세팅
    }
}
