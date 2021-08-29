package com.assignment1.base.Enum;

public enum MessageType {

    IDENTITYCHANGE("identitychange"),JOIN("join"),
    WHO("who"),LIST("list"),CREATEROOM("createroom"),
    DELETEROOM("delete"),QUIT("quit"),
    NEWIDENTITY("newidentity"),ROOMCHANGE("roomchange"),
    ROOMCONTENTS("roomcontents"),ROOMLIST("roomlist"),
    MESSAGE("message");

    private String type;

    MessageType(String type) {
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

}
