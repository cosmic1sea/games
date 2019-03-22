package com.hackerz.ticTacToe;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orwell
{
    @SneakyThrows
    public void writeToFile(final Map<String, Character> currentBoard)
    {
        final List<String> rowList = new ArrayList<>();
        rowList.add(currentBoard.get("A1") + "," + currentBoard.get("A2") + "," + currentBoard.get("A3"));
        rowList.add(currentBoard.get("B1") + "," + currentBoard.get("B2") + "," + currentBoard.get("B3"));
        rowList.add(currentBoard.get("C1") + "," + currentBoard.get("C2") + "," + currentBoard.get("C3"));

        PrintWriter writer = new PrintWriter("/Users/christophermosley/workspace/file.txt", "UTF-8");
        for(String row : rowList)
        {
            writer.println(row);
        }
        writer.close();
    }

    @SneakyThrows
    public Map<String, String> convertListStructureToBoard(final List<String> fileListStructure)
    {
        Map<String, String> map = new HashMap<>();
        BufferedReader in = new BufferedReader(new FileReader("/Users/christophermosley/workspace/file.txt"));
        String line = "";
        while ((line = in.readLine()) != null) {
            String parts[] = line.split("\t");
            map.put(parts[0], parts[1]);
        }
        in.close();
        System.out.println(map.toString());
        return map;
    }
}
