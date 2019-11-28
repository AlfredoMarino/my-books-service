package com.alfredomarino.mybooks.core.business.services;

import org.springframework.stereotype.Service;

import static com.alfredomarino.mybooks.core.utils.GoogleUtils.searchVolume;

/**
 * BookServiceImpl
 */
@Service
public class BookServiceImpl implements BookService {

    public void create(String searchText) {

        try {
            System.out.println(searchVolume("aldsjf"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}