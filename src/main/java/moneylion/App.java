package moneylion;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;
            lines.add(line);
        }
        
        if (lines.isEmpty()) {
            System.out.println("No input provided.");
            return;
        }
        
        int rows = lines.size();
        int maxCols = 0;
        
        // Determine the maximum length of any line (maximum number of columns)
        for (String line : lines) {
            maxCols = Math.max(maxCols, line.length());
        }
        
        boolean[][] visited = new boolean[rows][maxCols];
        List<int[]> boundingBoxes = new ArrayList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                if (lines.get(i).charAt(j) == '*' && !visited[i][j]) {
                    int[] box = findBoundingBox(lines, visited, i, j);
                    boundingBoxes.add(box);
                }
            }
        }
        
        int[] largestBox = findLargestBoundingBox(boundingBoxes);
        if (largestBox != null) {
            System.out.printf("(%d,%d)(%d,%d)", largestBox[0] + 1, largestBox[1] + 1, largestBox[2] + 1, largestBox[3] + 1);
        }
        
    }
    
    private static int[] findBoundingBox(List<String> lines, boolean[][] visited, int startRow, int startCol) {
        int minRow = startRow;
        int maxRow = startRow;
        int minCol = startCol;
        int maxCol = startCol;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startRow, startCol});
        visited[startRow][startCol] = true;
        
        int[] directions = {-1, 0, 1, 0, -1};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            
            for (int d = 0; d < 4; d++) {
                int newRow = row + directions[d];
                int newCol = col + directions[d + 1];
                
                if (newRow >= 0 && newRow < lines.size() && newCol >= 0 && newCol < lines.get(newRow).length()) {
                    if (lines.get(newRow).charAt(newCol) == '*' && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        queue.add(new int[] {newRow, newCol});
                        minRow = Math.min(minRow, newRow);
                        maxRow = Math.max(maxRow, newRow);
                        minCol = Math.min(minCol, newCol);
                        maxCol = Math.max(maxCol, newCol);
                    }
                }
            }
        }
        
        return new int[] {minRow, minCol, maxRow, maxCol};
    }
    
    private static int[] findLargestBoundingBox(List<int[]> boundingBoxes) {
        int maxSize = -1;
        int[] largestBox = null;
        
        for (int[] box : boundingBoxes) {
            int size = (box[2] - box[0] + 1) * (box[3] - box[1] + 1);
            if (size > maxSize) {
                maxSize = size;
                largestBox = box;
            }
        }
        
        return largestBox;
    }
}

