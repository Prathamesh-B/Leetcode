class Solution {

    List<int[]>[] graph;
    int inf = (int) 2e9;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList();

        // graph without -1 edge
        for (int[] edge : edges) {
            if (edge[2] != -1) {
                graph[edge[0]].add(new int[] { edge[1], edge[2] });
                graph[edge[1]].add(new int[] { edge[0], edge[2] });
            }
        }

        // shortest dis calculated without -1 edges
        int currShortDis = Dijkstra(n, source, destination);

        // scenario 1
        if (currShortDis < target)
            return new int[0][0];

        // scenario 2 & 3
        boolean matchesTarget = currShortDis == target;

        for (int[] edge : edges) {

            if (edge[2] != -1)
                continue;

            // we need to convert every -1 edge
            // infinity is assigned to not affect shortest distance
            edge[2] = matchesTarget ? inf : 1;
            graph[edge[0]].add(new int[] { edge[1], edge[2] });
            graph[edge[1]].add(new int[] { edge[0], edge[2] });

            if (!matchesTarget) {

                int newDis = Dijkstra(n, source, destination);

                if (newDis <= target) {
                    matchesTarget = true;
                    edge[2] += target - newDis;
                }
            }
        }

        return matchesTarget ? edges : new int[0][0];
    }

    private int Dijkstra(int n, int source, int destination) {

        int[] minDis = new int[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Arrays.fill(minDis, inf);
        minDis[source] = 0;
        minHeap.add(new int[] { source, 0 });

        while (!minHeap.isEmpty()) {

            int[] curr = minHeap.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > minDis[u])
                continue;

            for (int[] neigh : graph[u]) {

                int v = neigh[0];
                int weight = neigh[1];

                if (d + weight < minDis[v]) {

                    minDis[v] = d + weight;
                    minHeap.add(new int[] { v, minDis[v] });
                }
            }
        }
        return minDis[destination];
    }
}