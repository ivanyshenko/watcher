/**
 * Created by alex on 10.09.2016.
 */
public class Main {
    public static void main(String args[]){
        Searcher searcher = new Searcher("https://hh.ru/vacancy/", 100);
        String content = searcher.next();

        Parser parser = new Parser();
        parser.parseHTML(content);


    }
}


