package org.solution.dataRows;

public class JoinedDataRow<K extends Comparable<K>, V1, V2> {
    K key;
    V1 value1;
    V2 value2;


    public JoinedDataRow(K key, V1 value1, V2 value2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "JoinedDataRow(" + key + "," + value1 + "," + value2 + ")" ;
    }
}
