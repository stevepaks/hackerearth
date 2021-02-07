package dongba.searching;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LinearSearch {

    @Test
    public void willSheAcceptHim() {

        Scanner s = new Scanner(System.in);
        String t = s.nextLine();

        for (int i = 0; i < Integer.valueOf(t) ; i++) {

            String[] sList = s.nextLine().split(" ");
            String s1 = sList[0];
            String s2 = sList[1];
            int k = 0;
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(k) == s2.charAt(j)) {
                    if (k == s1.length() - 1) {
                        break;
                    }

                    k++;
                }
            }

            if (s1.length()-1 == k) {
                System.out.println("Love you too");
            } else {
                System.out.println("We are only friends");
            }
        }
    }

    @Test
    public void simpleSearch() {
        Scanner s = new Scanner(System.in);
        s.nextLine();

        String[] nums = s.nextLine().split(" ");

        String k = s.nextLine();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i].compareTo(k) == 0) {
                System.out.println(i);
                break;
            }
        }
    }

    @Test
    public void easySumSetProblem() {

        Scanner s = new Scanner(System.in);
        s.nextLine();
        List<Integer> numsA = Arrays.asList(s.nextLine().split(" ")).stream().map(Integer::valueOf).collect(Collectors.toList());
        s.nextLine();
        List<Integer> numsC = Arrays.asList(s.nextLine().split(" ")).stream().map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> candidates = new ArrayList<>();
        for (int numC : numsC) {
            for (int numA : numsA) {
                int sub = numC - numA;
                if (!candidates.contains(sub)) {
                    candidates.add(sub);
                }
            }
        }

        List<Integer> numsB = new ArrayList<>();
        for (int candidate : candidates) {

            boolean isValid = true;
            for (int numA : numsA){
                int sum = candidate+numA;
                if (!numsC.contains(sum)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid && !numsB.contains(candidate)) {
                numsB.add(candidate);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numsB.size(); i++) {
            sb.append(numsB.get(i));
            if (i != numsB.size() -1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
