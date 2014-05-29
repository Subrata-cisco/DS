package com.subrata.graph;

public class Node {
	public char label;
	public boolean visited = false;

	public Node(char l) {
		this.label = l;
	}

	@Override
	public String toString() {
		return "Node [label=" + label + ", visited=" + visited + "]";
	}
}
