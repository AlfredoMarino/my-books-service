package com.alfredomarino.mislibros.core.business.services;

import org.springframework.stereotype.Service;

import static com.alfredomarino.mislibros.core.utils.GoogleUtils.searchVolume;

/**
 * LibroServiceImpl
 */
@Service
public class LibroServiceImpl implements LibroService {

    public void create(String searchText) {

        try {
            System.out.println(searchVolume("aldsjf"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}