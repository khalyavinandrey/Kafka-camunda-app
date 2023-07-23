package app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message_counter")
public class MessageCounter {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "counter_value")
    private Integer counter;

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }
}
