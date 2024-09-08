import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int S = 0;
        int allSet = (1 << 20) - 1;

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("all")) {
                S = allSet;
            } else if (cmd.equals("empty")) {
                S = 0;
            } else {
                int x = Integer.parseInt(st.nextToken()) - 1;
                if (cmd.equals("add")) {
                    S |= (1 << x);
                } else if (cmd.equals("remove")) {
                    S &= ~(1 << x);
                } else if (cmd.equals("check")) {
                    sb.append((S & (1 << x)) != 0 ? "1\n" : "0\n");
                } else if (cmd.equals("toggle")) {
                    S ^= (1 << x);
                }
            }
        }

        System.out.print(sb.toString());
    }
}
