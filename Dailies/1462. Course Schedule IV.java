class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {

        boolean adjMatrix[][] = new boolean[n][n];

        for (int[] i : prerequisites) {
            adjMatrix[i[0]][i[1]] = true;
        }

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    adjMatrix[i][j] = adjMatrix[i][j] || (adjMatrix[i][k] && adjMatrix[k][j]);
                }
            }
        }

        List<Boolean> ans = new ArrayList<Boolean>();

        for (int i = 0; i < queries.length; ++i) {
            ans.add(adjMatrix[queries[i][0]][queries[i][1]]);
        }

        return ans;

    }
}