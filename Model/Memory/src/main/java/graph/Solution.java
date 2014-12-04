package graph;

import graph.manager.GraphManager;

import java.io.IOException;

/**
 * Created by Alex on 29.11.2014.
 */
public class Solution {
    public static void main(String[] args) throws IOException {

        GraphManager manager = new GraphManager();


        manager.addAllFilesForReadingInGraph("C:\\Users\\Alex\\Downloads\\7100\\7100\\7100");
       // manager.addAllFilesForReadingInGraph("src\\main\\resources\\graph\\texts");
        manager.printGraphInFile("src\\main\\resources\\graph\\rezult\\graph.txt");
    }
}
