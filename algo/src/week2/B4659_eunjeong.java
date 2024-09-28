package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        while (!str.equals("end")) {
            char[] chars = str.toCharArray();
            if (check1(chars) && check2(chars) && check3(chars)){
                System.out.println("<" + str + "> is acceptable." );
            }
            else{
                System.out.println("<" + str + "> is not acceptable." );
            }
            str = bf.readLine();
        }
    }

    // 조건1: 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
    // 조건 충족 시에만 true
    public static boolean check1(char[] charArr){
        for (char c : charArr) {
            if ( isVowels(c) )
                return true;
        }
        return false;
    }

    // 조건2: 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
    // 조건 충족 시에만 true
    public static boolean check2(char[] charArr){
        if (charArr.length < 3){
            return true;
        }
        for(int i = 2; i < charArr.length ; i++){
            if (isVowels(charArr[i-2]) && isVowels(charArr[i-1]) && isVowels(charArr[i])){
                return false;
            }
            if(!isVowels(charArr[i-2]) && !isVowels(charArr[i-1]) && !isVowels(charArr[i])) {
                return false;
            }
        }
        return true;
    }

    // 조건3: 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
    // 조건 충족 시에만 true
    public static boolean check3(char[] charArr){
        if (charArr.length < 2){
            return true;
        }
        for(int i = 1; i < charArr.length ; i++){
            if ((charArr[i-1] == charArr[i]) && (charArr[i] != 'e') && (charArr[i] != 'o'))
                    return false;
        }
        return true;
    }


    public static boolean isVowels(char c){
        if ( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
}