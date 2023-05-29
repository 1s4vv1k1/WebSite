package savik.website.repository;

import org.springframework.data.repository.CrudRepository;
import savik.website.entities.Message;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findByTag(String tag);
}
