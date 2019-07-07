package com.alfredomarino.mislibros.core.business.services;

import org.springframework.stereotype.Service;

import static com.alfredomarino.mislibros.core.utils.GoogleUtils.searchVolume;

/**
 * LibroService
 */
@Service
public class LibroService {

    public void createLibro(String searchText) {

        try {
            System.out.println(searchVolume("aldsjf"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}