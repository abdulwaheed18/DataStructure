package com.waheedtechblog.hashing;

import java.util.*;

/**
 * Sort HashMap by key and Value
 */
public class SortByValues {

    public static void main(String[] args) {

        HashMap<String, String> programmingLanguage = new HashMap<String, String>();

        programmingLanguage.put("1", "Java");
        programmingLanguage.put("2", "Ruby");
        programmingLanguage.put("4", "ReactJS");
        programmingLanguage.put("6", "NativeJS");
        programmingLanguage.put("3", "PHP");
        programmingLanguage.put("8", "Python");
        programmingLanguage.put("5", "AngularJS");
        sortByValue(programmingLanguage);

    }

    public static void sortByValue(HashMap<String, String> hashMap) {

        System.out.println("Initial hashmap:");
        display(hashMap.entrySet());

        // Not important but to show how can we sort hashMap by key
        // convert the hashmap into treesort to sort by keys
        TreeMap<String, String> sortedMap = new TreeMap<>(hashMap);
        System.out.println("\n========Sorted HashMap by KEY ===========");
        display(sortedMap.entrySet());

        // create map to list to use collection sort
        List<Map.Entry<String, String>> entryList = new LinkedList<>(sortedMap.entrySet());

        // Write comparator which sorts the map by Value
        Comparator<Map.Entry<String, String>> valueComparator = new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };

        // sort the linkedlsit using Collections.sort
        Collections.sort(entryList, valueComparator);

        // Store in HashMap so that it should store the order
        LinkedHashMap<String, String> sortedByValues = new LinkedHashMap<>(entryList.size());
        for (Map.Entry<String, String> entry : entryList)
            sortedByValues.put(entry.getKey(), entry.getValue());

        System.out.println("\n========Sorted HashMap by Value ============");
        display(sortedByValues.entrySet());
    }

    public static void display(Set<Map.Entry<String, String>> entrySet) {
        entrySet.forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }
}

/**
 * "C:\Program Files\Java\jdk1.8.0_201\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2019.1.4\lib\idea_rt.jar=50349:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2019.1.4\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_201\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\rt.jar;D:\Workspaces\IntelliJ\DataStructure\bin" com.waheedtechblog.hashing.SortByValues
 * Initial hashmap:
 * 1 : Java
 * 2 : Ruby
 * 3 : PHP
 * 4 : ReactJS
 * 5 : AngularJS
 * 6 : NativeJS
 * 8 : Python
 *
 * ========Sorted HashMap by KEY ===========
 * 1 : Java
 * 2 : Ruby
 * 3 : PHP
 * 4 : ReactJS
 * 5 : AngularJS
 * 6 : NativeJS
 * 8 : Python
 *
 * ========Sorted HashMap by Value ============
 * 5 : AngularJS
 * 1 : Java
 * 6 : NativeJS
 * 3 : PHP
 * 8 : Python
 * 4 : ReactJS
 * 2 : Ruby
 */
