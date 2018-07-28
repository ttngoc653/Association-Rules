package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
	public static boolean FI(List<String> list,String str_file_name_out) {
		try {
			FileWriter fw = new FileWriter(new File(str_file_name_out));
			
			for (int i = 1; i < list.get(list.size() - 1).split(" ").length; i++) {
				Integer count = countNumMang(list, i);
					fw.write(Integer.toString(count)+"\n");
					for (String string : list) {
						if(string.split(" ").length == i+1) fw.write(string+"\n");
						else if(string.split(" ").length > i+1) break;
					}
			}
			
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
