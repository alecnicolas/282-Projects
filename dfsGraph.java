import java.util.*;

public class Graph {
	
	private LinkedList<EdgeNode>[] adjList;
	private int nVertices;
	private int nEdges;
	private int[] visited;
	
	//Constructor
	public Graph(int[][] graphData, int nVertices) {
        this.nVertices = nVertices;
        nEdges = 0;
        adjList = new LinkedList[nVertices];
        visited = new int[adjList.length];
        
        for (int j = 0; j < nVertices; j++)
        {
            adjList[j] = new LinkedList<EdgeNode>();
            for(int i = 0; i < graphData.length; i++)
            {
                if(graphData[i][0] == j)
                {
                    adjList[j].add(new EdgeNode(graphData[i][1], graphData[i][2]));
                    this.nEdges+= 1;
                }
            }
        }
	}
	
	//print graph method
	public void printGraph()
	{
		System.out.println("Graph: nVertices = " + nVertices + " nEdges = " + nEdges); 
		System.out.println("Adjacency Lists");
		
		for(int i = 0;  i < adjList.length; i++)
		{
			System.out.print("v= " + i + "  " + adjList[i] + "\n");
		}
	}
	
	//depth first search
	public void dfsTraversal(int startVertex)
	{
		for(int i = 0; i<adjList.length; i++)
		{
			visited[i] = 0;
		}

	}
	
	private void dfs(int startVertex)
	{
		visited[startVertex] = 1;
		System.out.print(startVertex + " ");
		
		for(int k = 0; k<adjList[startVertex].size(); k++)
		{
			if(visited[adjList[startVertex].get(k).getDest()] == 0)
			{
				dfs(adjList[startVertex].get(k).getDest());
			}
		}
		
	}
	

class EdgeNode
{
	int destVertex;
	int weight;
	
	public EdgeNode(int v, int w)
	{
		destVertex = v;
		weight = w;
	}
	
	public int getDest()
	{
		return destVertex;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	@Override
	public String toString()
	{
		String result = new String("[" + destVertex  + "," + weight + "]");
		return result;
	}
}

class DistNode implements Comparable<DistNode>
{
	public int vertex;
	public int distance;
	public DistNode(int v, int d)
	{
		vertex = v;
		distance = d;
	}
	
	public int compareTo(DistNode rhs)
	{
		if(this.distance < rhs.distance)
		{
			return -1;
		}
		else if(this.distance == rhs.distance)
		{
			return 0;
		}
		else
			return 1;
	}
}




















