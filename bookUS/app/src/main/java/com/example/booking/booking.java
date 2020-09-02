package com.example.booking;

public class booking {

    private String book;
    private int image;

    public booking(String bookOption, int image_op){
         book = bookOption;
         image = image_op;

    }
    public String getBook(){
        return book;
    }

    public int getImage(){
        return image;
    }
}
