package com.hackerz.ticTacToe.players;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerImpl implements Player
{
//    @Override
//    public Map<String, Character> makeMove(final Map<String, Character> currentBoard)
//    {
//        // TODO: link to Jeff
//        // read from Jeff's file
//        final List<String> fileListStructure = new ArrayList<>(); // temp
//
//        return convertListStructureToBoard(fileListStructure);
//    }

    public void convertListStructureToBoard(String[] fileListStructure) throws IOException
    {
        Map<String, String> map = new HashMap<String, String>();
        BufferedReader in = new BufferedReader(new FileReader("file.txt"));
        String line = "";
        while ((line = in.readLine()) != null) {
            String parts[] = line.split("\t");
            map.put(parts[0], parts[1]);
        }
        in.close();
        System.out.println(map.toString());
                 
    }

    @Override
    public Map<String, Character> makeMove(Map<String, Character> currentBoard)
    {
        // TODO Auto-generated method stub
        return null;
    }
}
