package com.devcolibri.servlet;

/**
 * Created by PMY Archon on 13.01.2017.
 */
public class JsonData {
    private String id;
    private String id1;
    private String symbol;
    private String symbol1;
    private boolean isWon;
    private String msg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol1() {
        return symbol1;
    }

    public void setSymbol1(String symbol1) {
        this.symbol1 = symbol1;
    }

    public boolean getisWon() {
        return isWon;
    }

    public void setisWon(boolean isWon) {
        this.isWon = isWon;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
