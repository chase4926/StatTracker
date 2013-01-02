package com.gmail.chase4926.stattracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.plugin.java.JavaPlugin;

public class StatTracker extends JavaPlugin {
	private HashMap<String, Integer> stat_hash = null;
	
	public void onEnable() {
		this.saveDefaultConfig();
		
		stat_hash = new HashMap<String, Integer>();
		try {
			read_stats();
		} catch (IOException e) {
			e.printStackTrace();
		}
		getServer().getPluginManager().registerEvents(new StatTrackerListener(this), this);
	}
	
	public void set_value(String key, Integer value) {
		stat_hash.put(key, value);
		//System.out.println("Setting '" + key + "' to " + value);
		save_stats();
	}
	
	public Integer get_value(String key) {
		Integer value = stat_hash.get(key);
		if (value == null) {
			set_value(key, 0);
			return 0;
		} else {
			return value;
		}
	}
	
	private void save_stats() {
		String content_string = "";
		for (Entry<String, Integer> entry : stat_hash.entrySet()) {
			content_string += entry.getKey();
			content_string += ":";
			content_string += entry.getValue();
			content_string += "\n";
		}
		writeFile("stats.txt", content_string);
	}
	
	private void read_stats() throws IOException {
		File f = new File("stats.txt");
		if (f.exists()) {
			String content_string = readFile("stats.txt");
			BufferedReader bufReader = new BufferedReader(new StringReader(content_string));
			String line = null;
			String[] key_value = null;
			while ((line=bufReader.readLine()) != null) {
				key_value = line.split(":");
				if (key_value.length == 2) {
					set_value(key_value[0], Integer.parseInt(key_value[1]));
				}
			}
		}
	}
	
	void writeFile(String filename, String data) {
		File file = new File(filename);
		FileWriter fw = null;
		try {
			fw = new FileWriter(file.getAbsoluteFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			bw.write(data);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	String readFile(String filename) {
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String result_string = "";
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (line != null) {
			result_string += line;
			result_string += "\n";
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result_string;
	}
}
