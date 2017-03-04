package cn.edu.gzu.fjbai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDivision {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("请输入文件路径");
			System.exit(1);
		}
		File fileName = new File(args[0]);
		String name = fileName.getName();
		String preName = name;
		String sufName = "";
		if (name.lastIndexOf(".") != -1) {
			preName = name.substring(0, name.lastIndexOf("."));
			sufName = name.substring(name.lastIndexOf("."));
		}
		String oneLine;
		int counter = 0;
		int num = 1;
		FileReader fr;
		try {
			fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			FileWriter osw;
			try {
				osw = new FileWriter(preName + num + sufName);
				BufferedWriter bw = new BufferedWriter(osw);
				while ((oneLine = br.readLine()) != null) {
					counter++;
					bw.write(oneLine);
					bw.newLine();
					if (counter == 4000000) {
						counter = 0;
						num++;
						osw = new FileWriter(preName + num + sufName);
						bw = new BufferedWriter(osw);
					}
				}
				br.close();
				bw.close();
			} catch (IOException e) {
				System.out.println("不能创建文件或者文件不能写入");
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到");
		}
	}
}
