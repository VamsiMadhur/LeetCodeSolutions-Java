public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> (a[1]-b[1]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        int time=0;
        for(int[] course : courses) {
            if(time + course[0] <= course[1]) {
                queue.offer(course);
                time += course[0];
            } else if(!queue.isEmpty() && queue.peek()[0] > course[0]) {
                time += course[0] - queue.poll()[0];
                queue.offer(course);
            }
        }
        return queue.size();
    }
}