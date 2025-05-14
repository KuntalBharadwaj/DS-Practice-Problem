class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0;
        int r = m-1;
        int t = 0;
        int b = n-1;

        int c = 0;

        while(c <= n*m) {
            for(int i=l;i<=r;i++) {
                result.add(matrix[t][i]);
                c++;
            }
            t++;

            if(c == n*m) break;

            for(int i=t;i<=b;i++) {
                result.add(matrix[i][r]);
                c++;
            }
            r--;

            if(c == n*m) break;

            for(int i=r;i>=l;i--) {
                result.add(matrix[b][i]);
                c++;
            }
            b--;

            if(c == n*m) break;

            for(int i=b;i>=t;i--) {
                result.add(matrix[i][l]);
                c++;
            }

            l++;
            if(c == n*m) break;
        }

        return result;
    }
}