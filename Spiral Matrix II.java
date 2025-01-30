public int[][] generateMatrix(int n) {
        int r = n;
        int c = n;
        int[][] res = new int[n][n];
        int top = 0;
        int left = 0;
        int right = r-1;
        int bottom = c-1;
        
        int counter = 1;
        while(left <= right && top <= bottom){
            for(int i = left; i<= right; i++){
                res[top][i] = counter;
                counter++;
            }
            top++;
            for(int i = top; i <= bottom; i++){
                res[i][right] = counter;
                counter++;
            }
            right--;
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    res[bottom][i] = counter;
                    counter++;
                }
                bottom--;
            }
            if(left <= right){
                for(int i = bottom; i>= top; i--){
                    res[i][left] = counter;
                    counter++;
                }
                left++;
            }
        }
        return res;
    }
