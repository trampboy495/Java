package pratic;
import java.io.*;
import java.util.Scanner;
import java.util.LinkedHashMap; 
import java.util.Map; 
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
public class jsondemo {
	JSONObject invent= new JSONObject();
	Scanner sc=new Scanner(System.in);
	JSONArray ja=new JSONArray();
	Map m=new LinkedHashMap(3);
	public void add(String s) {
		System.out.println("enter the no of types of "+s);
		int t=sc.nextInt();
		for(int i=1;i<=t;i++) {
			System.out.println("enter the type of "+s);
			String ty=sc.next();
			m.put("type"+i,ty );
			System.out.println("enter the quantity");
			int wt=sc.nextInt();
			m.put("weight"+i,wt);
			System.out.println("enter the price");
			int pr=sc.nextInt();
			m.put("price"+i,pr );
			ja.add(m);
			m=new LinkedHashMap(3);
		}
		invent.put(s,ja);
		ja=new JSONArray();
	}
	public void print()throws Exception {
		FileWriter fw=new FileWriter("/home/bridgeit/JSONEX.json");
		fw.write(invent.toJSONString());
		fw.close();
	}
	public static void main(String[]args)throws Exception {
		jsondemo obj=new jsondemo();
		obj.add("Rice");
		obj.add("pulses");
		obj.add("wheat");
		obj.print();
	}
}


