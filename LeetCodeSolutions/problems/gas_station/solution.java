class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0; i<gas.length; i++) {
            if(cost[i]<=gas[i]) {
                if(canCompleteCircuit(gas, cost, i)) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public boolean canCompleteCircuit(int[] gas, int[] cost, int index) {
        int carGas = gas[index];
        for(int count=0; count<gas.length; count++) {
            carGas -= cost[index];
            if(carGas<0) {
                return false;
            }
            int nextIndex = (index+1)%gas.length;
            carGas += gas[nextIndex];
            index = nextIndex;
        }
        return true;
        
    }
}