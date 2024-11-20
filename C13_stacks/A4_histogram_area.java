package C13_stacks;

import java.util.Stack;

public class A4_histogram_area {
    public static int maxarea(int[] histogram){
        int n = histogram.length;
        int maxArea = 0;
        Stack<Integer> obstacle = new Stack<>(); // indices of obstacle
        for (int i = 0; i < n; i++){
            if(obstacle.isEmpty() || histogram[i] >= histogram[obstacle.peek()]) {
                obstacle.push(i);
            }else{

//                ----this is a wrong code as leftObstacle = 0 is a potent value of left obs so is cant be used as a flag
//                while (!obstacle.isEmpty() && histogram[i] < histogram[obstacle.peek()] ){
//                    int currhtidx = obstacle.pop();
//                    int leftobstacle = (obstacle.isEmpty()) ? 0 : obstacle.peek();
//                    if(leftobstacle == 0){
//                        maxArea = Math.max(maxArea, histogram[currhtidx] * i);
//                    }else {
//                        maxArea = Math.max(maxArea, histogram[currhtidx] * (i - leftobstacle - 1));
//                    }
//                }

                    while (!obstacle.isEmpty() && histogram[i] < histogram[obstacle.peek()]) {
                        int currHtIdx = obstacle.pop();
                        int width = (obstacle.isEmpty()) ? i : i - obstacle.peek() - 1;
                        maxArea = Math.max(maxArea, histogram[currHtIdx] * width);
                    }
                obstacle.push(i);
            }
        }
        while(!obstacle.isEmpty()){
            int rightobs = n;
            int currhtidx = obstacle.pop();
            int leftobstacle = (obstacle.isEmpty()) ? 0 : obstacle.peek();
            if(leftobstacle == 0){
                maxArea = Math.max(maxArea, histogram[currhtidx] * rightobs);
            }else {
                maxArea = Math.max(maxArea, histogram[currhtidx] * (rightobs - leftobstacle - 1));
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] histogram = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(maxarea(histogram));
    }
}
