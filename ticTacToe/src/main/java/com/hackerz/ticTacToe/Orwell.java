import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.hackerz.ticTacToe.objects.Board;

public class Orwell
{
public boolean stateChange()
{
    public class Orwell
    {
          
        public void writeToFile()
        {
            Map<String, Character> theBoard = new HashMap<String, Character>();
            Properties properties = new Properties();

            for (Map.Entry<String,Character> entry : theBoard.entrySet()) {
                properties.put(entry.getKey(), entry.getValue());
            }

            properties.store(new FileOutputStream("file.name"), null);
        }
}
}
