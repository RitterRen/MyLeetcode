package AmazonOA;

import java.util.*;

public class CreateAccount {
    public static void main(String[] args) {
        CreateAccount createAccount = new CreateAccount();
        List<String> realNames1 = new LinkedList<>();
        realNames1.add("alice");
        realNames1.add("bob");
        realNames1.add("terry");
        List<String> allNames1 = new LinkedList<>();
        allNames1.add("celia");
        allNames1.add("alice");
        allNames1.add("retry");
        allNames1.add("bob");
        allNames1.add("terry");

        System.out.println(createAccount.findRecurringName(realNames1, allNames1));
    }

    public List<String> findRecurringName(List<String> realNames, List<String> allNames) {
        HashMap<String, Integer> nameMap = new HashMap<>();
        List<String> res = new LinkedList<>();
        for (String name : allNames) {
            String orderedRealName = getOrderedStr(name);
            nameMap.put(orderedRealName, nameMap.getOrDefault(orderedRealName, 0) + 1);
        }

        for (String name : realNames) {
            String orderedName = getOrderedStr(name);
            if (nameMap.getOrDefault(orderedName, 0) > 1) {
                res.add(name);
            }
        }

        if (res.isEmpty()) res.add("None");

        res.sort(String::compareTo);

        return res;
    }

    private String getOrderedStr(String str) {
        char[] realNameCh = str.toCharArray();
        Arrays.sort(realNameCh);
        return Arrays.toString(realNameCh);
    }
}
