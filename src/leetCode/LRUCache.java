package leetCode;
import java.util.*;

public class LRUCache {
	 class Node{
	        int key;
	        int value;
	        Node prev;
	        Node next;
	        
	    }
	    
	   private  Map<Integer,Node> map=new HashMap<>();
	    private int capacity;
	    private Node head;
	    private Node tail;
	    
	    public void addNode(Node n){
	        Node tailNode=tail.prev;
	        tailNode.next=n;
	        n.next=tail;
	        
	        tail.prev=n;
	        n.prev=tailNode;
	    }
	    
	    public void removeNode(Node node){
	        Node temp1=node.prev;
	        Node temp2=node.next;
	        temp1.next=temp2;
	        temp2.prev=temp1;
	        
	        node.next=null;
	        node.prev=null;
	    }
	    
	    public int popHeadNext(){
	        Node temp=head.next;
	        
	        int key=temp.key;
	        removeNode(temp);
	        return key;
	        
	    }
	    
	    
	    public LRUCache(int capacity) {
	        this.capacity=capacity;
	        
	        head=new Node();
	        head.prev=null;
	        
	        tail=new Node();
	        tail.next=null;
	        
	        head.next=tail;
	        tail.prev=head;
	        
	    }
	    
	    public void moveNode(Node n){
	        removeNode(n);
	        addNode(n);
	    }
	    
	    public int get(int key) {
	        Node val=map.get(key);
	        if(val==null){
	            return -1;
	        }
	        
	        moveNode(val);
	        
	        return val.value;
	    }
	    
	    public void put(int key, int value) {
	        Node x=map.get(key);
	        if(x!=null){
	            x.value=value;
	            moveNode(x);
	        }
	        else{
	            Node temp=new Node();
	            temp.key=key;
	            temp.value=value;
	            addNode(temp);
	            map.put(key,temp);

	            if(map.size()>capacity){
	                int node=popHeadNext();
	                map.remove(node);
	            }
	        }
	        
	    }
}
