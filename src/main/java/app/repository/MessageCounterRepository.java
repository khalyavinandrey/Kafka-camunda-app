package app.repository;

import app.model.MessageCounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageCounterRepository extends JpaRepository<MessageCounter, Integer> {
}
