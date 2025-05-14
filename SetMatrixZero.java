class Solution {
    public void setZeroes(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int col = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    if (j != 0)
                        arr[0][j] = 0;
                    else
                        col = 0;
                }
            }
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        if(arr[0][0]==0) {
            for(int i=0;i<m;i++) {
                arr[0][i] = 0;
            }
        }

        if(col==0) {
            for(int i=0;i<n;i++) {
                arr[i][0] = 0;
            }
        }

        // List<Integer> row = new ArrayList<>();
        // List<Integer> col = new ArrayList<>();

        // int n = matrix.length;
        // int m = matrix[0].length;

        // for(int i=0;i<n;i++) {
        //     for(int j=0;j<m;j++) {
        //         if(matrix[i][j] == 0) {
        //             row.add(i);
        //             col.add(j);
        //         }
        //     }
        // }

        // for(int i=0;i<n;i++) {
        //     for(int j=0;j<m;j++) {
        //         if(col.contains(j) || row.contains(i)) matrix[i][j] = 0;
        //     }
        // }
    }
}