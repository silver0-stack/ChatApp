package com.example.chatapp;

/*채팅 안에 사용할 get,set*/
public class DataItem {
    //내용
    private final String content;
    //이름
    private final String name;
    //뷰타입(왼쪽,오른쪽)
    private final int viewType;

    public DataItem(String content,String name,int viewType){
        this.content=content;
        this.name=name;
        this.viewType=viewType;
    }
    //firebase DB에 객체로 값을 읽어올 때..
    //파라미터가 비어있는 생성자가 핑요함.

    public String getContent(){return content;}
    public String getName(){return name;}
    public int getViewType(){return viewType;}

}
