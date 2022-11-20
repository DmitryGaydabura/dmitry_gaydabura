package org.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.solution.dataRows.DataRow;
import org.solution.dataRows.JoinedDataRow;
import org.solution.joinOperations.LeftJoinOperation;
import org.solution.joinOperations.RightJoinOperation;

import java.util.ArrayList;

public class TestRightJoinOperation {
    @Test
    void testCaseInput() {

        ArrayList<DataRow<Integer, String>> leftCollection = new ArrayList<>();
        leftCollection.add(new DataRow<>(0, "Ukraine"));
        leftCollection.add(new DataRow<>(1, "Germany"));
        leftCollection.add(new DataRow<>(2, "France"));

        ArrayList<DataRow<Integer, String>> rightCollection = new ArrayList<>();
        rightCollection.add(new DataRow<>(0, "Kiev"));
        rightCollection.add(new DataRow<>(1, "Berlin"));
        rightCollection.add(new DataRow<>(3, "Budapest"));

        RightJoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow<Integer, String, String>> rightJoinOperation = new RightJoinOperation<>();
        ArrayList<JoinedDataRow<Integer, String, String>> actual = (ArrayList<JoinedDataRow<Integer, String, String>>) rightJoinOperation.join(leftCollection, rightCollection);
        ArrayList<JoinedDataRow<Integer, String, String>> expected = new ArrayList<>();
        expected.add(new JoinedDataRow<>(0, "Ukraine", "Kiev"));
        expected.add(new JoinedDataRow<>(1, "Germany", "Berlin"));
        expected.add(new JoinedDataRow<>(3, null, "Budapest"));

        Assertions.assertEquals(expected.toString(), actual.toString());

    }

    @Test
    void testEmptyCollections() {

        ArrayList<DataRow<Integer, String>> leftCollection = new ArrayList<>();
        ArrayList<DataRow<Integer, String>> rightCollection = new ArrayList<>();

        RightJoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow<Integer, String, String>> rightJoinOperation = new RightJoinOperation<>();
        ArrayList<JoinedDataRow<Integer, String, String>> actual = (ArrayList<JoinedDataRow<Integer, String, String>>) rightJoinOperation.join(leftCollection, rightCollection);

        Assertions.assertEquals(new ArrayList<>().toString(), actual.toString());
    }

    @Test
    void testEmptyLeftCollection() {

        ArrayList<DataRow<Integer, String>> leftCollection = new ArrayList<>();
        ArrayList<DataRow<Integer, String>> rightCollection = new ArrayList<>();
        rightCollection.add(new DataRow<>(0,"Kiev"));
        rightCollection.add(new DataRow<>(1,"Berlin"));
        rightCollection.add(new DataRow<>(3,"Budapest"));

        RightJoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow<Integer, String, String>> rightJoinOperation = new RightJoinOperation<>();
        ArrayList<JoinedDataRow<Integer, String, String>> actual = (ArrayList<JoinedDataRow<Integer, String, String>>) rightJoinOperation.join(leftCollection, rightCollection);
        ArrayList<JoinedDataRow<Integer, String, String>> expected = new ArrayList<>();
        expected.add(new JoinedDataRow<>(0, null,"Kiev"));
        expected.add(new JoinedDataRow<>(1, null,"Berlin"));
        expected.add(new JoinedDataRow<>(3, null,"Budapest"));
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testEmptyRightCollection() {

        ArrayList<DataRow<Integer, String>> leftCollection = new ArrayList<>();
        leftCollection.add(new DataRow<>(0, "Ukraine"));
        leftCollection.add(new DataRow<>(1, "Germany"));
        leftCollection.add(new DataRow<>(2, "France"));
        ArrayList<DataRow<Integer, String>> rightCollection = new ArrayList<>();

        RightJoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow<Integer, String, String>> rightJoinOperation = new RightJoinOperation<>();
        ArrayList<JoinedDataRow<Integer, String, String>> actual = (ArrayList<JoinedDataRow<Integer, String, String>>) rightJoinOperation.join(leftCollection, rightCollection);
        ArrayList<JoinedDataRow<Integer, String, String>> expected = new ArrayList<>();

        Assertions.assertEquals(expected.toString(), actual.toString());
    }
}
