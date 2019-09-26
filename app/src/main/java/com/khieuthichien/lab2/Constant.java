package com.khieuthichien.lab2;

public interface Constant {

    public static final String BASE_URL = "http://asian.dotplays.com";


    boolean isDEBUG = true;


    // USER TABLE

    String USER_TABLE = "users";
    String COLUMN_USERNAME = "Username";
    String COLUMN_PASSWORD = "Password";
    String COLUMN_NAME = "Name";

    String CREATE_USER_TABLE = "CREATE TABLE " + USER_TABLE + "(" +
            COLUMN_USERNAME + " VARCHAR PRIMARY KEY," +
            COLUMN_PASSWORD + " VARCHAR," +
            COLUMN_NAME + " VARCHAR" +
            ")";


}
