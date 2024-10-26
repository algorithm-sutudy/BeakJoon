import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);

        Set<String> people = new HashSet<>();
        for (int i = 0; i < num; i++) {
            people.add(br.readLine());
        }

        switch (game){
            case 'Y':
                System.out.println(people.size()); // 2 - 1
                break;
            case 'F':
                System.out.println(people.size() / 2); // 3 - 2
                break;
            case 'O':
                System.out.println(people.size() / 3); // 4 - 1
                break;
        }
    }

}
