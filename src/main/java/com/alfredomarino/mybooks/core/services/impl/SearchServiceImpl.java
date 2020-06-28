package com.alfredomarino.mybooks.core.services.impl;

import com.alfredomarino.mybooks.core.services.SearchService;
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

    public static final String ITEMS_PROPERTY = "items";
    public static final String VOLUME_INFO_PROPERTY = "volumeInfo";
    public static final String ID_PROPERTY = "id";
    public static final String TITLE_PROPERTY = "title";
    public static final String SUBTITLE_PROPERTY = "subtitle";
    public static final String DESCRIPTION_PROPERTY = "description";
    public static final String AUTHORS_PROPERTY = "authors";
    public static final String PUBLISH_DATE_PROPERTY = "publishedDate";
    public static final String CATEGORIES_PROPERTY = "categories";
    public static final String IMAGE_LINKS_PROPERTY = "imageLinks";
    public static final String THUMBNAIL_PROPERTY = "thumbnail";
    public static final String INDUSTRY_IDENTIFIERS_PROPERTY = "industryIdentifiers";
    public static final String TYPE_PROPERTY = "type";
    public static final String ISBN_13_PROPERTY = "ISBN_13";
    public static final String ISBN_10_PROPERTY = "ISBN_10";
    public static final String IDENTIFIER_PROPERTY = "identifier";

    @Override
    public List<Book> getBooksByName(String name) {
        return parseGoogleResponse(GoogleUtils.searchVolumeByAnyText(name));
    }

    @Override
    public Book getBookByGoogleId(String googleId) {
        // TODO La busqueda por google id no esta trayendo categories, ver que puede estar pasando
        // return parseNode(GoogleUtils.searchVolumeByGoogleId(googleId));
        return parseGoogleResponse(GoogleUtils.searchVolumeByAnyText(googleId)).get(0);
    }

    private List<Book> parseGoogleResponse(JsonNode root) {
        return StreamSupport.stream(root.path(ITEMS_PROPERTY).spliterator(), false)
                .map(this::parseNode)
                .collect(Collectors.toList());
    }

    private Book parseNode(JsonNode node){
        JsonNode volumeNode = node.path(VOLUME_INFO_PROPERTY);

        String title = volumeNode.path(TITLE_PROPERTY).asText();
        String subtitle = volumeNode.path(SUBTITLE_PROPERTY).asText();
        String description = volumeNode.path(DESCRIPTION_PROPERTY).asText();

        List<String> authorNames = volumeNodeIteratorToList(volumeNode, AUTHORS_PROPERTY);
        Author author = !authorNames.isEmpty() ? new Author(authorNames.get(0)) : null;

        String dateString = volumeNode.path(PUBLISH_DATE_PROPERTY).asText();
        Date publishedDate = null;
        if (!dateString.equals("")) {
            publishedDate = DateUtils.getValidDate(dateString);
        }

        List<String> categoryNames = volumeNodeIteratorToList(volumeNode, CATEGORIES_PROPERTY);
        Category category = !categoryNames.isEmpty() ? new Category(null, categoryNames.get(0)) : null;

        String image = volumeNode.path(IMAGE_LINKS_PROPERTY).path(THUMBNAIL_PROPERTY).asText();

        String isbn13 = null;
        String isbn10 = null;
        for (JsonNode industryIdentifier: volumeNode.path(INDUSTRY_IDENTIFIERS_PROPERTY)) {
            if (industryIdentifier.path(TYPE_PROPERTY).asText().equals(ISBN_13_PROPERTY)) {
                isbn13 = industryIdentifier.path(IDENTIFIER_PROPERTY).asText();
            } else if (industryIdentifier.path(TYPE_PROPERTY).asText().equals(ISBN_10_PROPERTY)) {
                isbn10 = industryIdentifier.path(IDENTIFIER_PROPERTY).asText();
            }
        }

        String googleId = node.path(ID_PROPERTY).asText();

        Book book = new Book();
        book.setTitle(title);
        book.setSubtitle(subtitle);
        book.setDescription(description);
        book.setAuthor(author);
        book.setPublicationDate(publishedDate);
        book.setCategory(category);
        book.setImage(image);
        book.setIsbn10(isbn10);
        book.setIsbn13(isbn13);
        book.setGoogleId(googleId);

        return book;
    }

    private List<String> volumeNodeIteratorToList(JsonNode node, String path) {
        return StreamSupport.stream(node.path(path).spliterator(),false)
                .map(JsonNode::asText)
                .distinct().collect(Collectors.toList());
    }

}
