package com.kelvinhado.eventparis.event;

import java.util.List;

/**
 * Created by Kelvin HADO
 * on 13/11/15
 * http://www.github.com/kelvinhado
 */
public class DataSet {

    private int nhits;
    private Events records;

    public int getNhits() {
        return nhits;
    }

    public Events getRecords() {
        return records;
    }

    @Override
    public String toString() {
        return "DataSet{" +
                "nhits=" + nhits +
                ", records=" + records +
                '}';
    }
}
