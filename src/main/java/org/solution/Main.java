package org.solution;

import org.solution.dataRows.DataRow;
import org.solution.dataRows.JoinedDataRow;
import org.solution.joinOperations.InnerJoinOperation;
import org.solution.joinOperations.LeftJoinOperation;
import org.solution.joinOperations.RightJoinOperation;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<DataRow<Integer, String>> leftCollection = new ArrayList<>();
        leftCollection.add(new DataRow<>(0, "Ukraine"));
        leftCollection.add(new DataRow<>(1, "Germany"));
        leftCollection.add(new DataRow<>(2, "France"));
        System.out.println("LeftCollection: " + leftCollection);

        ArrayList<DataRow<Integer, String>> rightCollection = new ArrayList<>();
        rightCollection.add(new DataRow<>(0, "Kiev"));
        rightCollection.add(new DataRow<>(1, "Berlin"));
        rightCollection.add(new DataRow<>(3, "Budapest"));
        System.out.println("RightCollection: " + rightCollection);


        System.out.println();
        InnerJoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow<Integer, String, String>> innerJoinOperation = new InnerJoinOperation<>();
        System.out.println("Inner Join: " + innerJoinOperation.join(leftCollection, rightCollection));

        LeftJoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow<Integer, String, String>> leftJoinOperation = new LeftJoinOperation<>();
        System.out.println("Left Join: " + leftJoinOperation.join(leftCollection, rightCollection));

        RightJoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow<Integer, String, String>> rightJoinOperation = new RightJoinOperation<>();
        System.out.println("Right Join: " + rightJoinOperation.join(leftCollection, rightCollection));

    }

}