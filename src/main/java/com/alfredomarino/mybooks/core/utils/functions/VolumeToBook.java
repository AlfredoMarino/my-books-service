package com.alfredomarino.mybooks.core.utils.functions;

import com.alfredomarino.mybooks.core.model.Author;
import com.alfredomarino.mybooks.core.model.Book;
import com.alfredomarino.mybooks.core.model.Category;
import com.alfredomarino.mybooks.core.utils.DateUtils;
import com.google.api.services.books.model.Volume;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class VolumeToBook implements Function<Volume, Book> {

    public static final String ISBN_13_PROPERTY = "ISBN_13";
    public static final String ISBN_10_PROPERTY = "ISBN_10";

    @Override
    public Book apply(Volume volume) {
        Book book = new Book();
        book.setGoogleId(volume.getId());
        book.setTitle(volume.getVolumeInfo().getTitle());
        book.setSubtitle(volume.getVolumeInfo().getSubtitle());
        book.setDescription(volume.getVolumeInfo().getDescription());
        book.setImage(volume.getVolumeInfo().getImageLinks().getThumbnail());

        List<String> authorNames = volume.getVolumeInfo().getAuthors();
        if (authorNames != null && !authorNames.isEmpty()) {
            book.setAuthors(authorNames.stream().map(Author::new).collect(Collectors.toList()));
        }
        String publishedDate = volume.getVolumeInfo().getPublishedDate();
        if (publishedDate != null) {
            book.setPublicationDate(DateUtils.getValidDate(publishedDate));
        }
        List<String> categoryNames = volume.getVolumeInfo().getCategories();
        if (categoryNames != null && !categoryNames.isEmpty()) {
            book.setCategories(categoryNames.stream().map(Category::new).collect(Collectors.toList()));
        }
        List<Volume.VolumeInfo.IndustryIdentifiers> industryIdentifiers = volume.getVolumeInfo().getIndustryIdentifiers();
        if (industryIdentifiers != null) {
            for (Volume.VolumeInfo.IndustryIdentifiers industryIdentifier: industryIdentifiers) {
                if (industryIdentifier.getType().equals(ISBN_13_PROPERTY)) {
                    book.setIsbn13(industryIdentifier.getIdentifier());
                } else if (industryIdentifier.getType().equals(ISBN_10_PROPERTY)) {
                    book.setIsbn10(industryIdentifier.getIdentifier());
                }
            }
        }

        return book;
    }
}
