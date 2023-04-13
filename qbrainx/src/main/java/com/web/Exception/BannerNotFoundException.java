package com.web.exception;

public class BannerNotFoundException  extends RuntimeException{
    public BannerNotFoundException(int id) {
        super(" with ID " + id + " not found");
    }

}
