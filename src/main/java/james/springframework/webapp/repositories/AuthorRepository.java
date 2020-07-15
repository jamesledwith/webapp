package james.springframework.webapp.repositories;

import james.springframework.webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository <Author, Long>{
}
