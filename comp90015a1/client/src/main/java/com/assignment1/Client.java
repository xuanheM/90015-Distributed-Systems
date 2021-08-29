package com.assignment1;

import com.alibaba.fastjson.JSON;
import com.assignment1.base.Enum.Command;
import com.assignment1.base.Message.C2S.Join;

public class Client {

  public static void main(String[] args) {
    Join j = new Join();
    j.setType(Command.JOIN.getCommand());
    j.setRoomid("1");
    String jsonString = JSON.toJSONString(j);
    System.out.println(jsonString);
    j = JSON.parseObject(jsonString,Join.class);
    System.out.println(j);
  }
}
