package com.alfredomarino.mybooks.core.business.services;

import com.alfredomarino.mybooks.core.model.Author;
import com.alfredomarino.mybooks.core.model.Book;
import com.alfredomarino.mybooks.core.model.Category;
import com.alfredomarino.mybooks.core.utils.DateUtils;
import com.alfredomarino.mybooks.core.utils.GoogleUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SearchServiceImpl implements SearchService {

    @Override
    public List<Book> getBooksByName(String name) throws Exception {

        JsonNode root = GoogleUtils.searchVolume(name);

        List<Book> books = StreamSupport.stream(root.path("items").spliterator(), false)
                .map(item -> {
                    String title = item.path("volumeInfo").path("title").asText();
                    String subtitle = item.path("volumeInfo").path("subtitle").asText();
                    String synopsis = item.path("volumeInfo").path("description").asText();

                    List<String> authorNames = StreamSupport.stream(
                            item.path("volumeInfo").path("authors").spliterator(),
                            false
                    ).map(JsonNode::asText).distinct().collect(Collectors.toList());
                    Author author = authorNames.size() > 0 ? new Author(authorNames.get(0)) : null;

                    String dateString = item.path("volumeInfo").path("publishedDate").asText();
                    Date publishedDate = null;
                    if (!dateString.equals("")) {
                        publishedDate = DateUtils.getValidDate(dateString);
                    }

                    List<String> categoryNames = StreamSupport.stream(
                            item.path("volumeInfo").path("categories").spliterator(),
                            false
                    ).map(JsonNode::asText).distinct().collect(Collectors.toList());
                    Category category = categoryNames.size() > 0 ? new Category(null, categoryNames.get(0)) : null;

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

                    return new Book(title, subtitle, synopsis, author, publishedDate, category, image, isbn10, isbn13, idGoogle);
                })
                .collect(Collectors.toList());

        System.out.println("totalItems: " + books.size());

        return books;
    }


}
