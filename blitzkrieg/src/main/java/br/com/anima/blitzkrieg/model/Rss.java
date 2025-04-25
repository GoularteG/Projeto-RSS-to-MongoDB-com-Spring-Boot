package br.com.anima.blitzkrieg.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "rss")
@Getter
@Setter
public class Rss {
    @Id
    private String id;
    private String titulo;
    private String link;
    private String descricap;
    private Date dataDePublicacao;

}