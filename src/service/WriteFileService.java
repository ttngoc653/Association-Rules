package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.Attribute;

public class WriteFileService {
	@SuppressWarnings("unused")
	private static Integer countNumMang(List<String> list, Integer num) {
		Integer i = 0;
		for (String string : list) {
			if(string.split(" ").length == num + 1) i++;
			else if(string.split(" ").length > num + 1) return i;
		}
		return i;
	}
	@SuppressWarnings({ "unused", "resource" })
	public static boolean FI(List<String> list,String str) {
		//List<String> list1 = Process.FrequentItemSets(list);
		
	    try {
			FileWriter fw = new FileWriter(new File(str));
			
			for (int i = 0; i < list.get(list.size() - 1).split(" ").length; i++) {
				Integer count = countNumMang(list, i+1);
				if(count > 0) {
					fw.write(Integer.toString(i+1));
					for (String string : list) {
						if(string.split(" ").length == i + 1) fw.write(string);
						else if(string.split(" ").length > i + 1) break;
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
