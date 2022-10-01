package GraphAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Edge_Dijks {
		int source, dest, weight;

		public Edge_Dijks (int source, int dest, int weight) {
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}
	}

class Node_Dijks {
		int vertex, weight;

		public Node_Dijks(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}

class Graph_Dijks {
		List<List<Edge_Dijks>> adjList = null;

		Graph_Dijks(List<Edge_Dijks> edges, int N) {
			adjList = new ArrayList<>();

			for(int i = 0 ; i < N; i++) {
				adjList.add(new ArrayList<>());
			}

			for(Edge_Dijks edge: edges) {
				adjList.get(edge.source).add(edge);
			}
		}
	}

	class Main {
		private static void getRoute(int[] prev, int i, List<Integer> route) {
			if (i >= 0) {
				getRoute(prev, prev[i], route);
				route.add(i);
			}
		}

		public static void shortestPath(Graph_Dijks graph, int source, int N) {
			PriorityQueue<Node_Dijks> minHeap;
			minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
			minHeap.add(new Node_Dijks(source, 0));

			List<Integer> dist = new ArrayList<>(Collections.nCopies(N, Integer.MAX_VALUE));

			dist.set(source, 0);

			boolean[] done = new boolean[N];

			done[source] = true;

			int[] prev = new int[N];
			prev[source] = -1;

			List<Integer> route = new ArrayList<>();

			while (!minHeap.isEmpty()) {
				Node_Dijks node = minHeap.poll();

				int u = node.vertex;

				for (Edge_Dijks edge: graph.adjList.get(u)) {
					int v = edge.dest;
					int weight = edge.weight;

					if(!done[v] && (dist.get(u) + weight) < dist.get(v)) {
						dist.set(v, dist.get(u) + weight);
						prev[v] = u;
						minHeap.add(new Node_Dijks(v, dist.get(v)));
					}
				}

				done[u] = true;
			}

			for(int i = 1; i < N; ++i) {
				if(i != source && dist.get(i) != Integer.MAX_VALUE) {
					getRoute(prev, i, route);
					System.out.printf("Path (%d -> %d): Minimum Cost = %d and Route is %s", source, i, dist.get(i), route);
					route.clear();
				}
			}
		}

		public static void main(String[] args) {
			List<Edge_Dijks> edge_dijks = Arrays.asList(
				new Edge_Dijks(0, 1, 10),
				new Edge_Dijks(0, 4, 3),
				new Edge_Dijks(1, 2, 2),
				new Edge_Dijks(1, 4, 4),
				new Edge_Dijks(2, 3, 9),
				new Edge_Dijks(3, 2, 7),
				new Edge_Dijks(4, 1, 1),
				new Edge_Dijks(4, 2, 8),
				new Edge_Dijks(4, 3, 2)
			);

			final int N = 5;

			Graph_Dijks graph = new Graph_Dijks(edge_dijks, N);

			int source = 0;
			shortestPath(graph, source, N);
		}
	}
