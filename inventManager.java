package pratic;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.JSONParser;
import pratic.Main.Node;
import java.util.Scanner;
import java.io.*;

public class inventManager<T>   {
	Main<Object> t=new Main<Object>();
	jsondemo j=new jsondemo();
	Scanner sc=new Scanner(System.in);
	@SuppressWarnings("rawtypes")
	Map m=new LinkedHashMap(3);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  Map add(String s,int j) {
            System.out.println("enter the no of types of "+s+" you want to add");
		    int tn=sc.nextInt();
		    m=new LinkedHashMap(3);
		    for(int i=1;i<=tn;i++) {
		    	System.out.println("enter the type of "+s);
				String ty=sc.next();
				m.put("type"+j,ty );
				System.out.println("enter the quantity");
				int wt=sc.nextInt();
				m.put("weight"+j,wt);
				System.out.println("enter the price");	                  
				int pr=sc.nextInt();
				m.put("price"+j,pr );
			    j++;
			}
	        return m;
	}


	@SuppressWarnings("unchecked")
	public void update(String s)throws Exception {
		Object obj=new JSONParser().parse(new FileReader("/home/bridgeit/JSONEX.json"));
		JSONObject jo=(JSONObject)obj;
		JSONArray ja=  (JSONArray)jo.get(s);
		for(int i=0;i<ja.size();i++) {
			t.insert(ja.get(i));
		}
		inventManager<String> i1=new inventManager<String>();
		System.out.println("what you want to do /n 1.add /n 2.deleteAt ");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			int j=t.getSize()+1;
			t.insert(i1.add(s,j));
			break;
		case 2:
			System.out.println("specify the type no you want to delete");
			int ty=sc.nextInt();
			t.deleteAt(ty);
			break;
		default:
			System.out.println("wrong input ");
			break;
		}
		
		@SuppressWarnings("rawtypes")
		Node n=t.head ;
		int i=0;
		JSONArray ja1= new JSONArray();
		while(n!=null) {
			ja1.add(i,n.data);
			i++;
			n=n.next;
		}
		jo.put(s,ja1);
		FileWriter fw=new FileWriter("/home/bridgeit/JSONEX.json");
		fw.write(jo.toJSONString());
		fw.close();
	}
	public static void main(String[]args)throws Exception {
		inventManager<String> i=new inventManager<String>();
		System.out.println("what you want to update /n 1.Rice /n 2.Wheat /n 3.Pulses");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			i.update("Rice");
			break;
		case 2:
			i.update("wheat");
			break;
		case 3:
			i.update("pulses");
			break;
		default:
			System.out.println("wrong input ");
		    break;
	    }
		sc.close();
    }
}	
