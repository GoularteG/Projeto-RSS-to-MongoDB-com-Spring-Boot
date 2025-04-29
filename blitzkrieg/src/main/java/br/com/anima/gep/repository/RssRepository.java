package br.com.anima.gep.repository;

import br.com.anima.gep.model.Rss;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RssRepository extends MongoRepository<Rss, String> {
}
