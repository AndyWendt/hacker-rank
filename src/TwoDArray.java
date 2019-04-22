public class TwoDArray {
    public static int hourglassSum(int[][] arr) {
        int length = arr.length;
        int leftColumn, middleColumn, rightColumn;
        int topRow, middleRow, bottomRow;
        Integer max = null, sum = null;

        if (arr.length == 0) {
            return 0;
        }

        // need to get all the values for the columns and rows
        // with hopefully one iteration
        for (int row = 0; row < length; row++) {
            topRow = row;
            middleRow = row + 1;
            bottomRow = row + 2;

            if (bottomRow >= length) {
                break;
            }
            
            for (int column = 0; column < length; column++) {
                leftColumn = column;
                middleColumn = column + 1;
                rightColumn = column + 2;
                
                if (rightColumn >= length) {
                    break;
                }
                
                sum = arr[topRow][leftColumn] + arr[topRow][middleColumn] + arr[topRow][rightColumn] + 
                    arr[middleRow][middleColumn] +
                        arr[bottomRow][leftColumn] + arr[bottomRow][middleColumn] + arr[bottomRow][rightColumn];
                if (max == null || sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }
}
