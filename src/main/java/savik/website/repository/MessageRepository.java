package savik.website.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import savik.website.entities.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

    Page<Message> findAll(Pageable pageable);
    Page<Message> findByTag(String tag, Pageable pageable);
}
