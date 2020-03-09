package pratic;
import java.io.FileWriter;
import java.io.FileReader;
public class Main<T> {
     class Node{
        T data;
        Node next;
        
    }
     int size=0;
     Node head;
     Node tail;
        public void insert(T data){
            Node n= new Node();
            n.data=data;
            n.next=null;
            if(head==null){
                head=n;
                tail=n;
            }
            else{
                tail.next=n;
                tail=n;
                
            }
            size++;
        }
        public int getSize() {
        	return size;
        }
        
        public  void show(){
            Node curr=head;
            while(curr!=null){
                System.out.print(curr.data +" ");
                curr=curr.next;
            }
      
        }
        public void insertAtStart(T data){
            Node n= new Node();
            n.data=data;
            n.next=null;
            n.next=head;
            head=n;
            size++;
        }
        public void insertAt(int index,T data){
            Node n= new Node();
            n.data=data;
            n.next=null;
            if(index==0){
                insertAtStart(data);
            }
            else{
                Node n2=head;
                for(int i=0;i<index-1;i++){
                    n2=n2.next;
                }
                n.next=n2.next;
                n2.next=n;
            }
            size++;
        }
        public void  deleteAt(int index){
            if(index==0){
                head=head.next;
            }
            else if(index==getSize()) {
            	Node n=head;
            	while(n.next!=tail) {
            		n=n.next;
            	}
            	n.next=null;
            	tail=n;
            }
            else{
                Node n=head;
                Node n1=null;
                for(int i=0;i<index-1;i++){
                    n=n.next;
                }
                n1=n.next;
                n.next=n1.next;
                n1=null;
            }
            size--;
        }
        
        public void reverseList() {
        	Node prev=null,curr=null,pointer=head;
        	while(pointer!=null) {
        		curr=pointer;
        		head=pointer;
        		pointer=pointer.next;
        		curr.next=prev;
        		prev=curr;
        	}
        }
        public void fileWriter()throws Exception {
        	
        	FileWriter fw=new FileWriter("/home/bridgeit/new.txt");
        	int i=0;
        	String ch="";
        	Node n=head;
        	while(n!=null) {
        		ch+=n.data;
        		fw.write(ch.charAt(i));
        		i++;
        		n=n.next;
        	}
        	
        	fw.close();
        }
        
    
    public static void main(String[] args)throws Exception{
        Main<Character> list=new Main<Character>();
        FileReader fr=new FileReader("/home/bridgeit/Documents/mc.txt");
        int i;
        while((i=fr.read())!=-1) {
        	list.insert((char)i);
        	
        }
        fr.close();
        list.show();
        System.out.println(list.getSize());
        list.reverseList();
        
        list.fileWriter();
        FileReader fr1=new FileReader("/home/bridgeit/new.txt");
        while((i=fr1.read())!=-1) {
        	System.out.print((char)i);
        }
        fr1.close();
        
    }
}

