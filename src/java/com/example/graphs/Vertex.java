package com.example.graphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String name;
	private boolean visited;
	private List<Vertex> neighbors;
	
	Vertex(String name){
		this.name = name;
		neighbors = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public List<Vertex> getNeighbors() {
		return neighbors;
	}
	public void setNeighbors(Vertex neighbor) {
		this.neighbors.add(neighbor);
	}
	@Override
	public String toString() {
		return "Vertex [name=" + name + "]";
	}
	
	
	
}
