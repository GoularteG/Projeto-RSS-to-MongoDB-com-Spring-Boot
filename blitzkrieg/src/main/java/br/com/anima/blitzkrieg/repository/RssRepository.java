package br.com.anima.blitzkrieg.repository;

import br.com.anima.blitzkrieg.model.Rss;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RssRepository extends MongoRepository<Rss, String> {
}
