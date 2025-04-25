package br.com.anima.blitzkrieg.service;

import br.com.anima.blitzkrieg.model.Rss;
import br.com.anima.blitzkrieg.repository.RssRepository;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.net.URL;

@Service
public class RssService {

    @Autowired
    private RssRepository rssRepository;

    public void fetchAndSaveRss(String rssUrl) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}