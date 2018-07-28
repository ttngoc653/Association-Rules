package main;

import model.Attribute;
import service.Process;
import service.ReadFileService;
import service.WriteFileService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
        /*
    	ReadFileService fileService = new ReadFileService();
        try {
            List<Attribute> attributes = fileService.readFile("example.csv");

            for (Attribute attribute : attributes) {
                System.out.println(attribute.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    	
    	try {
			List<Attribute> list_attribute = ReadFileService.readFile("example.csv");
			
			System.out.println("Input minsup: ");
			Float minsup = SCANNER.nextFloat();
			
			List<String> list_exam = Process.FrequentItemSets(list_attribute, minsup);
			
			for (String string : list_exam) {
				System.out.println(string);
			}
			System.out.println("da ghi ra file");
			WriteFileService.FI(list_exam, "FI.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
