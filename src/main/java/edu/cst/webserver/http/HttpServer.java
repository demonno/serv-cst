package edu.cst.webserver.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(9191);

            while (true) {
                Socket socket = serverSocket.accept();
                socket.setSoTimeout(10000);
                process(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void process(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            int contentLength = 10;
            String line;
            List<String> httpMessage = new ArrayList<String>();
            List<String> httpHeaders = new ArrayList<String>();
            StringBuilder body = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                httpMessage.add(line);

                if (line.length() == 0) {
                    ByteArrayOutputStream entityBody = new ByteArrayOutputStream();

                    try {
                        byte[] remaining = new byte[contentLength];
                        int read = inputStream.read(remaining);
                        if (read > -1) {
                            entityBody.write(remaining);
                        }
                        entityBody.flush();
                    } catch (IOException e) {
                        break;
                    }

                    //for(int i = 1;i<)

//                    HttpHeaderFieldParser.parse_list(httpMessage);

//                    HttpRequestLineParser

//                    String body;


                    HttpRequest request = new HttpRequestWrapper(null,null,"");
                    for (String messageLine : httpMessage) {
                        System.out.println(messageLine);
                    }

                    OutputStream streamOut = null;

                    entityBody.writeTo(streamOut);

                    OutputStreamWriter writer = new OutputStreamWriter(streamOut);
                    BufferedWriter fout = new BufferedWriter(writer);

                    socket.close();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}