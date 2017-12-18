import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();

        //reader.readTextNotBuffered();
        //reader.readTextBuffered();
        reader.readByteNotBuffered();
    }
}
