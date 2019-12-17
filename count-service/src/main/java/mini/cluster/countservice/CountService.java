package mini.cluster.countservice;

import org.springframework.stereotype.Service;

@Service
class CountService {

    private static int currentCount = 0;

    public int getCurrentCount() {
        // Implement data access here
        return CountService.currentCount;
    }

    /**
     * Takes the a count value and sets count to that value.
     * @param countValue (int) value to set current count to.
     * @return newly set value
     */
    public int setCurrentCount(int countValue) {
        CountService.currentCount = countValue;
        return CountService.currentCount;
    }
    
}