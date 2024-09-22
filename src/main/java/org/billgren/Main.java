package org.billgren;

import org.billgren.grouper.Grouper;

import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Grouper grouper = new Grouper();
        Map<String, List<String>> groups = grouper.assignGroups();

        printGroups(groups);
    }

    public static void printGroups(Map<String, List<String>> groups) {
        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            System.out.println(entry.getKey() + ": " + String.join(",", entry.getValue()));
        }
    }

}