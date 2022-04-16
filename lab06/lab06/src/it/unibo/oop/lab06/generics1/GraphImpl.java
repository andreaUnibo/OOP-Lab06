package it.unibo.oop.lab06.generics1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {

	LinkedHashSet<Object> nodes = new LinkedHashSet<Object>();
	Map<Object,HashSet<Object>> edges = new LinkedHashMap<>();
	Map<Object,HashSet<Object>> copy = edges;
	
	@Override
	public void addNode(Object node) {
		
	nodes.add(node);
		
	}

	@Override
	public void addEdge(Object source, Object target) {
		
	
		int i = 0;
		for(Entry<Object,HashSet<Object>> o : edges.entrySet()) {
			
			if(o.getKey().equals(source)) {
				edges.get(source).add(target);
				i++;
				
			}
			
		}
		
		if(i==0) {
			HashSet<Object> temp = new HashSet<Object>();
			temp.add(target);
			edges.put(source,temp );
		}
	/*	
		for(Entry<Object,HashSet<Object>> d : edges.entrySet()) {
			System.out.println(d.getKey() + " " + d.getValue());
		}
	*/	
	}

	@Override
	public Set nodeSet() {
		
		return nodes;
	}

	@Override
	public Set linkedNodes(Object node) {
		
		Set<Object> set = new LinkedHashSet<Object>();
		
		for(Entry<Object, HashSet<Object>> s : edges.entrySet()) {
		
			if(s.getKey() == node) {
				
				set.add(s.getValue());
			}
			
		}
		
		return set;
	}

	@Override
	public List getPath(Object source, Object target) {
	
		List<Object> path = new ArrayList<Object>();
		
		int i = 0;
		
		for(Entry<Object, HashSet<Object>> s : copy.entrySet()) {
			System.out.println("p1-->"+ s + " source: " +  source);
			if(source == null) {
				System.out.println("no path was found");
			}
			else {
			if(source.equals(target)) {
				System.out.println("p4");
				List<Object> end = new ArrayList<Object>();
				path.add(source);
				return path;
				
			}
			System.out.println(s.getKey() + " != " +source);
			if(s.getKey().equals(source)) {
				System.out.println("p3");
				i++;
				
				path.add(source);
				System.out.println("ci sono");
				for( Object l : copy.get(source)) {
					
					
					
					Map<Object,HashSet<Object>> newcopy = copy;
					
					
					//copy.remove(source);
					System.out.println("p2 --> "+ newcopy.get(source));
					
				List ret = getPath(newcopy.get(source),target);
				if( ret != null) {
					path .add(ret);
				}
				}
			}
			
			
			
			}
		
			System.out.println("ends");
		}
		if(i == 0) {
				return null;
			}
		return path;
	}
}
