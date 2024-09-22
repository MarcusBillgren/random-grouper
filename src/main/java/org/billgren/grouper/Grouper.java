package org.billgren.grouper;

import org.billgren.readers.ResourceReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Grouper {
    public Map<String, List<String>> assignGroups(){
        try {
            List<String> allGroups = ResourceReader.generateArrayListFromFile("src/main/resources/groups.txt");
            List<String> allMembers = ResourceReader.generateArrayListFromFile("src/main/resources/members.txt");

            //Shuffle members for some sweet randomness
            Collections.shuffle(allMembers);

            // Create groups from group names
            Map<String, List<String>> groups = createGroups(allGroups);

            // Add members to groups
            int totalIndex = allGroups.size() -1;
            int count = 0;
            for (String member: allMembers) {
                if(count > totalIndex){
                    count  = 0;
                }
                groups.get(allGroups.get(count)).add(member);
                count++;
            }

            return groups;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, List<String>> createGroups(List<String> allGroups){
        Map<String, List<String>> groups = new TreeMap<>();

        for (String group : allGroups) {
            groups.put(group, new ArrayList<>());
        }

        return groups;
    }


}
