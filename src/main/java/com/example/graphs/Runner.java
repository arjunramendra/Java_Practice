package com.example.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Runner {

	public static void main(String[] args) {
		bfs(buildAndSetNeighbors());
		System.out.println("\n");
		DfsRec(buildAndSetNeighbors());
	}
	
	public static void bfs(Vertex root) {
		Queue<Vertex> visited = new LinkedList<>();
		root.setVisited(true);
		visited.add(root);
		
		while(!visited.isEmpty()) {
			for(Vertex v : visited.peek().getNeighbors()) {
				if(!v.isVisited()) {
					v.setVisited(true);
					visited.add(v);
				}	
			}
			System.out.println(visited.poll());
		}
	}
	
	public static void DfsIter(Vertex root) {
		
		Stack<Vertex> visited = new Stack<>();
		root.setVisited(true);
		visited.add(root);
		while(!visited.isEmpty()) {
			for(Vertex v : visited.peek().getNeighbors()) {
				if(!v.isVisited()) {
					visited.add(v);
					v.setVisited(true);
				}
			}
			System.out.println(visited.pop());
		}
	}
	
	public static void cloneGraph(Vertex root) {
		Map<String, Vertex> map = new HashMap<>();
		cloneGraph(root, map);
	}
	
	public static Vertex cloneGraph(Vertex root, Map<String, Vertex> map){
		if(!map.containsKey(root.getName())) {
			Vertex node = new Vertex(root.getName());
			node.setNeighbors(root.getNeighbors().get(0));
			map.put(node.getName(), node);
			for(Vertex v : root.getNeighbors()) {
				cloneGraph(v, map);
			}
			return node;
		}else {
			return map.get(root.getName());
		}
	}
	
	public static void DfsRec(Vertex root) {
		System.out.println(root);
		for(Vertex v : root.getNeighbors()) {
			if(!v.isVisited()) {		
				v.setVisited(true);
				DfsRec(v);
			}
		}
	}
	
	public static Vertex buildAndSetNeighbors() {
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");
		Vertex g = new Vertex("G");
		Vertex h = new Vertex("H");
		Vertex i = new Vertex("I");
		Vertex j = new Vertex("J");
		
		a.setNeighbors(b);
		a.setNeighbors(f);
		a.setNeighbors(g);
		
		b.setNeighbors(a);
		b.setNeighbors(c);
		b.setNeighbors(d);
		
		c.setNeighbors(b);
		
		d.setNeighbors(b);
		d.setNeighbors(e);
		
		e.setNeighbors(a);
		
		f.setNeighbors(e);
		
		g.setNeighbors(f);
		g.setNeighbors(g);
		g.setNeighbors(h);
		g.setNeighbors(i);
		
		h.setNeighbors(g);
		h.setNeighbors(a);
		
		i.setNeighbors(h);
		i.setNeighbors(j);
		i.setNeighbors(c);
		j.setNeighbors(i);
		return a;
	}
}
