package HW11;

public class HW11 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //checks for empty input
        if (image == null || image.length == 0) return image;
        int originalColor = image[sr][sc];
        //checks if target color is already present
        if (originalColor == color) return image;
        //begin recursion
        fill(image, sr, sc, originalColor, color);
        return image;
    }

    // recursive command to fill image with target pixels from given coords
    private void fill(int[][] image, int sr, int sc, int originalColor, int color) {
        //check boundaries and that current pixel matches original
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != originalColor)
            return;

        // change pixel color to target color
        image[sr][sc] = color;
        fill(image, sr + 1, sc, originalColor, color);
        fill(image, sr - 1, sc, originalColor, color);
        fill(image, sr, sc + 1, originalColor, color);
        fill(image, sr, sc - 1, originalColor, color);
    }

    public static void main(String[] args) {
        HW11 solution = new HW11();

        // Test Case 1
        int[][] image1 = {{1,1,1},
                          {1,1,0},
                          {1,0,1}};
        int[][] result1 = solution.floodFill(image1, 1, 1, 2);
        //output
        System.out.println("Test Case 1:");
        for (int[] row : result1) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }

        // Test Case 2
        int[][] image2 = {{0,0,0},
                          {0,0,0}};
        int[][] result2 = solution.floodFill(image2, 0, 0, 0);
        //output
        System.out.println("\nTest Case 2:");
        for (int[] row : result2) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
