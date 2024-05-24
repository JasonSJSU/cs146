class Solution:
    def floodFill(self, image, sr, sc, color):
        # Check if the image is empty
        if not image or not image[0]:
            return image

        # check if color is already given color
        original_color = image[sr][sc]
        if original_color == color:
            return image

        # recursive command to fill pixels with target color
        def fill(image, sr, sc, original_color, color):
            # checks boundaries and if current pixel matches original and ends recursive loop if conditions fit
            if (sr < 0 or sr >= len(image) or sc < 0 or sc >= len(image[0]) or
                    image[sr][sc] != original_color):
                return
            # changes pixel to color to target color
            image[sr][sc] = color
            # check other 4 directions
            fill(image, sr + 1, sc, original_color, color)
            fill(image, sr - 1, sc, original_color, color)
            fill(image, sr, sc + 1, original_color, color)
            fill(image, sr, sc - 1, original_color, color)

        # calling fill command
        fill(image, sr, sc, original_color, color)
        return image

solution = Solution()
# Test Case 1
image1 = [[1,1,1],
          [1,1,0],
          [1,0,1]]
result1 = solution.floodFill(image1, 1, 1, 2)
# ouput
print("Test Case 1:")
for row in result1:
    print(row)

# Test Case 2
image2 = [[0,0,0],
          [0,0,0]]
result2 = solution.floodFill(image2, 0, 0, 0)
# ouput
print("\nTest Case 2:")
for row in result2:
    print(row)
    