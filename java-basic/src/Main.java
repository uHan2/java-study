import java.io.*;
import java.util.*;

public class Main
{
	public static int vertex = 0;
	public static int edge = 0;
	public static int start = 0;;
	public static int[][] map;
	public static boolean[] visit;
	public static ArrayList<ArrayList<Integer>> adList;

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());

		vertex = Integer.parseInt(str.nextToken());
		edge = Integer.parseInt(str.nextToken());
		start = Integer.parseInt(str.nextToken());

		map = new int[vertex+1][vertex+1];

		adList = new ArrayList<>();
		for(int i = 0; i < vertex+1; i++)
		{
			adList.add(new ArrayList<>());
		}

		visit = new boolean[vertex+1];

		for(int i = 0; i < edge; i++)
		{
			str = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(str.nextToken());
			int v2 = Integer.parseInt(str.nextToken());

			map[v1][v2] = 1;
			map[v2][v1] = 1;
			adList.get(v1).add(v2);
			adList.get(v2).add(v1);
		}

		// for(int i = 1; i < vertex+1; i++)
		// {
		//     for(int j = 1; j < vertex+1; j++)
		//     {
		//         System.out.print(map[i][j]);
		//     }
		//     System.out.println();
		// }

		// // for(int i=1; i < adList.size(); i++)
		// {
		//     System.out.print("정점 " + i + "의 인접리스트");

		//     for(int j=0; j < adList.get(i).size(); j++)
		//     {
		//         System.out.print(" -> " + adList.get(i).get(j));
		//     }
		//     System.out.println();
		// // }

		dfs(start);
		System.out.println();
		Arrays.fill(visit, false);
		// dfsList(start);
		bfs(start);


	}

	public static void dfs(int start)
	{
		visit[start] = true;
		System.out.print(start + " ");

		for(int i = 1; i < visit.length; i++)
		{
			if(map[start][i] == 1 && visit[i] == false)
			{
				dfs(i);
			}
		}
	}

	public static void dfsList(int start)
	{
		visit[start] = true;
		System.out.print(start + " ");

		for(int i : adList.get(start))
		{
			if(visit[i] == false)
			{
				dfsList(i);
			}
		}
	}

	public static void bfs(int start)
	{
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(start);
		while(!queue.isEmpty())
		{
			int temp = queue.poll();
			visit[temp] = true;
			System.out.print(temp + " ");
			for(int i = 1; i < visit.length; i++)
			{
				if(map[temp][i] == 1 && visit[i] == false)
				{
					queue.offer(i);
					visit[i] = true;
				}
			}
		}
	}
}
