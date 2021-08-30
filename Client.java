package com.assignment1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.assignment1.base.Enum.Command;
import com.assignment1.base.Enum.MessageType;
import com.assignment1.base.Message.Base;
import com.assignment1.base.Message.C2S.Join;
import com.assignment1.base.Message.C2S.Message;
import com.assignment1.base.Message.Identity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Client {

  public static void main(String[] args)throws IOException {
    /*Join j = new Join();
    j.setType(Command.JOIN.getCommand());
    j.setRoomid("1");
    String jsonString = JSON.toJSONString(j);
    System.out.println(jsonString);
    j = JSON.parseObject(jsonString,Join.class);
    System.out.println(j);*/

    client_connection();
  }

  static void client_connection() throws IOException {
    String remoteHostname = "127.0.0.1";
    int remotePort = 6379;
    JSONObject json_client = new JSONObject();
    JSONObject json_server = new JSONObject();

    Socket socket = new Socket(remoteHostname, remotePort);

    OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String message = keyboard.readLine();
      String[] spiltCmd = message.trim().split("\\s+");
      json_client.put("type", spiltCmd[0]);
      for(int i =1; i < spiltCmd.length; i++) {
        json_client.put("Content", spiltCmd[i]);
      }

      writer.write(json_client.toString());
      writer.flush();

      if (message.equals("quit")) break;

      String response = reader.readLine();

      json_server.put("message", response);
      System.out.format("Server: %s\n", json_server.toString());


    }
    socket.close();
  }
}
