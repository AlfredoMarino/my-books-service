package com.alfredomarino.mybooks.core.utils.functions;

import com.google.api.services.books.model.Volume;

import java.util.function.Predicate;

public class IsVolumeComplete implements Predicate<Volume> {

    @Override
    public boolean test(Volume volume) {
        return volume.getId() != null
                && volume.getVolumeInfo() != null
                && volume.getVolumeInfo().getImageLinks() != null
                && volume.getVolumeInfo().getTitle() != null;
    }
}
