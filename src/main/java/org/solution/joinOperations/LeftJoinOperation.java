package org.solution.joinOperations;

import org.solution.dataRows.DataRow;
import org.solution.dataRows.JoinedDataRow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class LeftJoinOperation<D1, D2, R> implements JoinOperation<D1, D2, R> {
    @Override
    public Collection<R> join(Collection<D1> leftCollection, Collection<D2> rightCollection) {
        ArrayList<DataRow<Integer, String>> list1 = (ArrayList<DataRow<Integer, String>>) leftCollection;
        ArrayList<DataRow<Integer, String>> list2 = (ArrayList<DataRow<Integer, String>>) rightCollection;

        ArrayList<JoinedDataRow<Integer, String, String>> answer = new ArrayList<>();

        HashMap<Integer, Integer> possibleKeys1 = new HashMap<>();
        for (int i = 0; i < list1.size(); i++) {
            possibleKeys1.put(list1.get(i).getKey(), i);
        }

        HashMap<Integer, Integer> possibleKeys2 = new HashMap<>();
        for (int i = 0; i < list2.size(); i++) {
            possibleKeys2.put(list2.get(i).getKey(), i);
        }

        Set<Integer> set1 = possibleKeys1.keySet();
        Set<Integer> set2 = possibleKeys2.keySet();

        for (Integer i : set1) {
            answer.add(new JoinedDataRow<>(i, list1.get(possibleKeys1.get(i)).getValue(),
                    (set2.contains(i) ? list2.get(possibleKeys1.get(i)).getValue() : null)));
        }

        return (Collection<R>) answer;
    }
}
