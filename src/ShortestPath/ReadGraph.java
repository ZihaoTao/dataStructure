package ShortestPath;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by tino on 1/19/19.
 */
public class ReadGraph {

    private Scanner scanner;

    // 由于文件格式的限制，我们的文件读取类只能读取权值为Double类型的图
    public ReadGraph(Graph graph, String filename){

        readFile("src/ShortestPath/" + filename);

        try {
            int V = scanner.nextInt();
            if (V < 0)
                throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            assert V == graph.V();

            int E = scanner.nextInt();
            if (E < 0)
                throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");

            for (int i = 0; i < E; i++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                Double weight = scanner.nextDouble();
                assert v >= 0 && v < V;
                assert w >= 0 && w < V;
                graph.addEdge(new Edge(v, w, weight));
            }
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from input stream, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attemps to read an 'int' value from input stream, but there are no more tokens available");
        }
    }

    private void readFile(String filename){
        assert filename != null;
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            }
            else
                throw new IllegalArgumentException(filename + " doesn't exist.");
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Could not open " + filename, ioe);
        }
    }

}
