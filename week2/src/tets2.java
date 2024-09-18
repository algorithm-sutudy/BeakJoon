import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        Set<Integer> aieoue = new HashSet<>();
//        aieoue.add(97);  // 'a'
//        aieoue.add(101); // 'e'
//        aieoue.add(105); // 'i'
//        aieoue.add(111); // 'o'
//        aieoue.add(117); // 'u'
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        while (true) {

            boolean containaieoue = false;
            boolean threetime = true;
            boolean twotime = true;

            String N = br.readLine();
            if (N.equals("end")) {
                break;
            }

            char[] charArray = N.toCharArray();  // 문자열을 char 배열로 변환
            int[] intArray = new int[charArray.length];  // int 배열 생성

            int aieoueCount = 0;
            int etcCount = 0;

            // 각 문자를 int로 변환
            int pre = -1;
            for (int i = 0; i < charArray.length; i++) {
                intArray[i] = charArray[i];

                if(vowels.contains(intArray[i])){
                    containaieoue=true;
                    aieoueCount++;
                    etcCount=0;
                }else {
                    etcCount++;
                    aieoueCount=0;
                }

                if(etcCount == 3 || aieoueCount == 3){
                    threetime=false;
                    break;
                }

                //
                if(pre==intArray[i] && !(intArray[i]==101 || intArray[i]==111)){
                    twotime=false;
                    break;
                }

                pre = intArray[i];

            }

            if (containaieoue && twotime && threetime) {
                System.out.println("<" + N + "> is acceptable.");
            } else {
                System.out.println("<" + N + "> is not acceptable.");
            }

        }


    }
}
