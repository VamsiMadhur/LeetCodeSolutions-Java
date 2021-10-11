/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Employee[] cache = new Employee[2000];
        
        for(Employee employee : employees) {
            cache[employee.id-1] = employee;
        }
        
        int result = cache[id-1].importance;
        Queue<Integer> next = new LinkedList<>();
        for(Integer sub : cache[id-1].subordinates) {
            next.offer(sub);
        }
        
        while(!next.isEmpty()) {
            int nid = next.poll();
            result += cache[nid-1].importance;
            for(Integer sub : cache[nid-1].subordinates) {
                next.offer(sub);
            }
        }
        return result;
    }
}