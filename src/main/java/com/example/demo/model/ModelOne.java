package com.example.demo.model;

import java.io.Serializable;

/**
 * @Description ModelOne
 */
public class ModelOne implements Serializable {
    private String token;
    private String password;
    private String id;

    /**
     * Serialization discloses sensitive information. The serializable class contains sensitive information fields.
     * The token and password fields are sensitive information and should not be serialized,
     * If several Point objects are serialized, sensitive information may be disclosed or tampered with.
     *
     * @param token    token
     * @param password password
     * @param id       id
     */
    public ModelOne(String token, String password, String id) {
        this.token = token;
        this.password = password;
        this.id = id;
    }
}
