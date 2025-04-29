package br.com.anima.gep.service;

import br.com.anima.gep.model.Rss;
import br.com.anima.gep.repository.RssRepository;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class RssService {

    @Autowired
    private RssRepository rssRepository;

    public void fetchAndSaveRss(String rssUrl) {
        if (rssUrl == null || rssUrl.isBlank()) {
            throw new IllegalArgumentException("URL do RSS não pode ser vazia!");
        }
        try {
            URL feedUrl = new URL(rssUrl);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));

            for (SyndEntry entry : feed.getEntries()) {
                Rss rssFeed = new Rss();
                rssFeed.setTitulo(entry.getTitle());
                rssFeed.setLink(entry.getLink());
                rssFeed.setDescricao(entry.getDescription().getValue());
                rssFeed.setDataDePublicacao(entry.getPublishedDate());

                rssRepository.save(rssFeed);
            }
        }  catch (MalformedURLException e) {
            System.err.println("URL mal formatada: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro de conexão com o feed RSS: " + e.getMessage());
        } catch (FeedException e) {
            System.err.println("Erro ao processar o XML do RSS: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }

    }
}