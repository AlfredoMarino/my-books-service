package com.alfredomarino.mislibros.core.business.services;

import com.alfredomarino.mislibros.core.model.Autor;
import com.alfredomarino.mislibros.core.model.Genero;
import com.alfredomarino.mislibros.core.model.Libro;
import com.alfredomarino.mislibros.core.utils.DateUtils;
import com.alfredomarino.mislibros.core.utils.GoogleUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SearchServiceImpl implements SearchService {

    @Override
    public List<Libro> getBooksByName(String name) throws Exception {

        JsonNode root = GoogleUtils.searchVolume(name);

        List<Libro> libros = StreamSupport.stream(root.path("items").spliterator(), false)
                .map(item -> {
                    String title = item.path("volumeInfo").path("title").asText();
                    String subtitle = item.path("volumeInfo").path("subtitle").asText();
                    String synopsis = item.path("volumeInfo").path("description").asText();

                    List<String> authorNames = StreamSupport.stream(
                            item.path("volumeInfo").path("authors").spliterator(),
                            false
                    ).map(JsonNode::asText).distinct().collect(Collectors.toList());
                    Autor author = authorNames.size() > 0 ? new Autor(authorNames.get(0)) : null;

                    String dateString = item.path("volumeInfo").path("publishedDate").asText();
                    Date publishedDate = null;
                    if (dateString != null && dateString != "") {
                        publishedDate = DateUtils.getValidDate(dateString);
                    }

                    List<String> categoryNames = StreamSupport.stream(
                            item.path("volumeInfo").path("categories").spliterator(),
                            false
                    ).map(JsonNode::asText).distinct().collect(Collectors.toList());
                    Genero category = categoryNames.size() > 0 ? new Genero(null, categoryNames.get(0)) : null;

                    String image = item.path("volumeInfo").path("imageLinks").path("thumbnail").asText();

                    String isbn13 = null;
                    String isbn10 = null;
                    for (JsonNode industryIdentifier: item.path("volumeInfo").path("industryIdentifiers")) {
                        if (industryIdentifier.path("type").asText().equals("ISBN_13")) {
                            isbn13 = industryIdentifier.path("identifier").asText();
                        } else if (industryIdentifier.path("type").asText().equals("ISBN_10")) {
                            isbn10 = industryIdentifier.path("identifier").asText();
                        }
                    }

                    String idGoogle = item.path("id").asText();

                    return new Libro(title, subtitle, synopsis, author, publishedDate, category, image, isbn10, isbn13, idGoogle);
                })
                .collect(Collectors.toList());

        System.out.println("totalItems: " + libros.size());

        return libros;
    }


}
