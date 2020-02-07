package mini.cluster.countservice.persistance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CountValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer countVal;

    public CountValue() {
    }

    public CountValue(Integer countVal) {
        this.countVal = countVal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountVal() {
        return countVal;
    }

    public void setCountVal(Integer countVal) {
        this.countVal = countVal;
    }
}
