public class Solution {
    public static void main(String[] args) {
        int[] roomsHeight = {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
        // int[] roomsHeight = {5,8};
        // int[] roomsHeight = {1,1,1,1};
        System.out.println(getNumberOfStrokes(roomsHeight));
    }

    private static int getNumberOfStrokes(int[] roomsHeight) {
        int maxHeight = getMaxHeight(roomsHeight);
        int numberOfLines = 0;
        for (int j = 1; j < maxHeight+1; j++) {
            boolean sameLine = false;
            for (int i = 0; i < roomsHeight.length; i++) {
                if (!sameLine && roomsHeight[i] >= j) {
                    numberOfLines++;
                    sameLine = true;
                } else if (roomsHeight[i] < j) {
                    sameLine = false;
                }
            }
            if (numberOfLines > 1e9) {
                return -1;
            }
        }
        return numberOfLines;
    }

    private static int getMaxHeight(int[] input) {
        int max = -1;
        for (int i : input) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}