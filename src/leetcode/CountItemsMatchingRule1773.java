package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountItemsMatchingRule1773 {
    public static void main(String[] args){
        List<List<String>> items = new ArrayList<>();
        List<String> record = new ArrayList<>();
        record.add("phone");
        record.add("blue");
        record.add("pixel");
        items.add(record);
        record = new ArrayList<>();
        record.add("phone");
        record.add("gold");
        record.add("iPhone");
        items.add(record);
        record = new ArrayList<>();
        record.add("computer");
        record.add("silver");
        record.add("lenovo");
        items.add(record);

        String ruleKey1 = "color";
        String ruleKey2 = "type";
        String ruleKey3 = "name";
        String ruleValue1 = "silver";
        String ruleValue2 = "phone";
        String ruleValue3 = "lenovo";

        int res = countMatches(items, ruleKey1, ruleValue1);
        System.out.println(res);
        res = countMatches(items, ruleKey2, ruleValue2);
        System.out.println(res);
        res = countMatches(items, ruleKey3, ruleValue3);
        System.out.println(res);
        res = countMatches(items, ruleKey1, ruleValue3);
        System.out.println(res);

    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int typeIndex = 0, colorIndex = 1, nameIndex = 2;

        if(ruleKey.equalsIgnoreCase("type")) {
            return lookForRuleValue(items, typeIndex, ruleValue);
        } else if(ruleKey.equalsIgnoreCase("color")) {
            return lookForRuleValue(items, colorIndex, ruleValue);
        } else if(ruleKey.equalsIgnoreCase("name")) {
            return lookForRuleValue(items, nameIndex, ruleValue);
        }
        return 0;
    }

    static int lookForRuleValue(List<List<String>> items, int column, String ruleValue) {
        int count =0;
        for(int i=0;i<items.size();i++) {
            if(ruleValue.equalsIgnoreCase(items.get(i).get(column))) {
                count++;
            }
        }
        return count;
    }
}
