package mini.cluster.countservice;

import mini.cluster.countservice.persistance.CountRepository;
import mini.cluster.countservice.persistance.CountValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class CountService {


    @Autowired
    CountRepository countRepository;


    /**
     * This akward method returns the current count value persisted in the database
     * or if there is no countValue record, it inits the record to 0 and returns the value.
     *
     * @return
     */
    public CountValue getCurrentCount() {
        var optCount = countRepository.findById(1);
        if (optCount.isEmpty()) {
            return countRepository.save(new CountValue(0));
        } else {
            return optCount.get();
        }
    }

    /**
     * Takes the a count value and sets count to that value.
     *
     * @param countValue (int) value to set current count to.
     * @return newly set value
     */
    public CountValue setCurrentCount(int countValue) {
        var count = getCurrentCount();
        count.setCountVal(countValue);
        return countRepository.save(count);
    }
    
}