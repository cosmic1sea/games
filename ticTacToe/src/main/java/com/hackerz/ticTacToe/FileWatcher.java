package com.hackerz.ticTacToe;

import javafx.application.Platform;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class FileWatcher extends Thread 
{
	 private final File file;
	 private AtomicBoolean stop = new AtomicBoolean(false);
	 private long lastModified = 0;
	 private Judy judge;

	 public FileWatcher(String file, Judy judge) throws FileNotFoundException
	 {
	 	this.judge = judge;
		this.file = new File(file);
	 }
	 
	public static List<String> readFile(File fileLoc) throws FileNotFoundException
	{
		List<String> lineList = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(fileLoc));

		String line;
		try 
		{
			while ((line = br.readLine()) != null) 
			{				
				lineList.add(line);
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineList;
	}
	    
	   public boolean isStopped() 
	   { 
		   return stop.get(); 
	   }
	   public void stopThread() throws InterruptedException 
	   {
		   System.out.println("Setting stop to true");
		   stop.set(true);
		   Thread.currentThread().interrupt();
		   return;
	   }
	    
	   @Override
	   public void run()
	   {
	        try (WatchService watcher = FileSystems.getDefault().newWatchService()) 
	        {
	            Path path = file.toPath().getParent();
	            path.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);
	            while (!isStopped()) 
	            {
	                WatchKey key;
	                try 
	                { 
	                	key = watcher.poll(25, TimeUnit.MILLISECONDS);
	                }
	                catch (InterruptedException e) 
	                { 
	                	return; 
	                }
	                if (key == null) 
	                { 
	                	Thread.yield();
	                	continue; 
	                }

	                for (WatchEvent<?> event : key.pollEvents()) 
	                {
	                    WatchEvent.Kind<?> kind = event.kind();

	                    @SuppressWarnings("unchecked")
	                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
	                    Path filename = ev.context();

	                   if (kind == StandardWatchEventKinds.ENTRY_MODIFY && filename.toString().equals(file.getName()))
	                    {
	                    	if(lastModified != this.file.lastModified())
	                    	{
	                    		this.lastModified = this.file.lastModified();
	                            System.out.println(this.file.lastModified());
	                            // todo
								judge.orderInTheCourt(readFile(this.file));
	                    	}
	            
	                    }
	                    boolean valid = key.reset();
	                    if (!valid) 
	                    { 
	                    	break; 
	                    }
	                }
	                Thread.yield();
	            }
	        } 
	        catch (Throwable e)
	        {
	            System.out.println("error");
	        }
	    }
}
