package com.model.tests;

import com.model.Model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    Model m;

    @BeforeEach
    void setUp() {
        m = new Model();
    }

    @AfterEach
    void tearDown() {
        m = null;
    }

    @Test
    void getItems() {
    }

    @Test
    void login() {
    }

    @Test
    void postCoupon() {
    }

    @Test
    void getItem() {
    }

    @Test
    void postItem() {
    }

    @Test
    void deleteItem() {
    }
}