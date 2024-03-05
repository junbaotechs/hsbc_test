package junbaonet;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class FullStackTestApplication {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Please select the question to be tested (Type 1 or 2)");
        while (true) {
            String chose = sn.next();
            switch (chose) {
                case "1":
                    System.out.println("Please input the string of a-z freely (repeatable, unlimited length)");
                    String Char = sn.next();
                    do_task(Char);
                    break;
                case "2":
                    System.out.println("Please input the string of a-z freely (repeatable, unlimited length)");
                    String Char2 = sn.next();
                    do_task2(Char2);
                    break;
                default:
                    System.out.println("Please type 1 or 2");
                    break;
            }
        }
    }

    public static void do_task(String Char) {
        char[] achar = Char.toCharArray();
        ArrayList<String> str = new ArrayList<>();
        StringBuilder achar2 = new StringBuilder();
        int isDigui = 0;
        for (int i = 0, j = 0; i <= achar.length - 1; i++) {
            if (i < achar.length - 2) {
                if (achar[i] == achar[i + 1] && achar[i] == achar[i + 2]) {
                    int repeat = 1;
                    do {
                        repeat++;
                        isDigui++;
                    } while (achar[i] == achar[i + repeat] && i + repeat < achar.length - 1);
                    i += repeat;
                }
            }
            str.add(String.valueOf(achar[i]));
            j++;
        }
        for (String s : str) {
            achar2.append(s);
        }
        System.out.println("The unrepeat result is：=> " + achar2);
        if (isDigui > 0) {
            do_task(String.valueOf(achar2));
        }
    }

    public static void do_task2(String Char) {
        byte[] achar = Char.getBytes();
        ArrayList<String> str = new ArrayList<>();
        int isDigui = 0;
        for (int i = 0; i <= achar.length - 1; i++) {
            int repeat = 0;
            if (i < achar.length - 2) {
                if (achar[i] == achar[i + 1] && achar[i] == achar[i + 2]) {
                    do {
                        repeat++;
                        isDigui++;
                    } while (achar[i] == achar[i + 1 + repeat] && i + 1 + repeat < achar.length - 1);
                    i += repeat;
                    str.add(String.valueOf((achar[i] - 1)));
                } else {
                    str.add(String.valueOf(achar[i]));
                }
            } else {
                str.add(String.valueOf(achar[i]));
            }
        }
        byte[] byteArray = new byte[str.size()];
        for (int i = 0; i < str.size(); i++) {
            int element = Integer.parseInt(str.get(i));
            byteArray[i] = (byte) element;
        }
        String result = new String(byteArray);
        System.out.println("The unrepeat result is：=> " + result);
        if (isDigui > 0) {
            do_task2(result);
        }
    }

}
