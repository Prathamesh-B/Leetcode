// O(n^2) time | O(n^2) space
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] matrix = new char[n][m];   
        
        turnBox(box, matrix, m, n); // turn the box clockwise 90 degree
        
        turnGravity(matrix, n, m); // cause that falling effect, since matrix turned so n,m
        
        return matrix;
    }
    
    public void turnGravity(char[][] matrix, int m, int n){
        for(int c = 0; c < n; c++){
            int last  = m-1;
            for(int r = m-1; r >= 0; r--){
                char val =  matrix[r][c];
                if(val == '.') continue;
                if(val == '*') last = r-1;
                if(val == '#') {
                    matrix[r][c] = '.';
                    matrix[last][c] = '#';
                    last--;
                }
            }
        }
    }
    
    public void turnBox(char[][] box, char[][] matrix, int m, int n){
	// numbers represents sequence it would be copied
	//[4][1]
	//[5][2]
	//[6][3]
        for(int i = 0, c = m-1; i < m; i++,c--){ // c: 4,3,2,1..
            for(int j = 0, r = 0; j < n; j++, r++){ // r:0,1,2,3..
               matrix[r][c] = box[i][j];
            }
        }
    }
}