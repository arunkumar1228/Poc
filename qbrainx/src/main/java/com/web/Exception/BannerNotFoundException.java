package com.web.Exception;

public class BannerNotFoundException  extends RuntimeException{
    public BannerNotFoundException(int id) {
        super(" with ID " + id + " not found");
    }

}
