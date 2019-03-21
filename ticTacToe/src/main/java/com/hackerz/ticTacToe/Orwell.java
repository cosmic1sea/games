package com.hackerz.ticTacToe;

import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Orwell
{
    @SneakyThrows
    public void writeToFile()
    {
        Map<String, Character> theBoard = new HashMap<String, Character>();
        Properties properties = new Properties();

        for (Map.Entry<String, Character> entry : theBoard.entrySet())
        {
            properties.put(entry.getKey(), entry.getValue());
        }

        properties.store(new FileOutputStream("file.name"), null);
    }
}
