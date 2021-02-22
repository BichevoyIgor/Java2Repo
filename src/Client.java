import java.io.*;
import java.net.Socket;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 9456;
    private static Socket socket;

    public static void main(String[] args) {
        try {
            socket = new Socket(HOST, PORT);
            System.out.println("Подключение установлено");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //отдельный поток чтения с клавиатуры и отправки на сервер
            Thread thread = new Thread(() -> {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    try {
                        out.write(reader.readLine() + "\n");
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.setDaemon(true);
            thread.start();

            while (true){
                String str = input.readLine();
                if (str.equals("/exit")) {
                    System.out.println("Соединение с сервером завершено");
                    out.write("/exit" + "\n");
                    out.flush();
                    break;
                }else {
                    System.out.println("Server: " + str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
