package com.rent_it_app.rent_it.json_models;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rui on 3/18/17./
 */
public class CategoryTest {
    @Test
    public void getId() throws Exception {
        //given
        final Category category = new Category();
        final Field field = category.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(category, "an_id");

        //when
        final String result = category.getId();

        //then
        assertEquals("field wasn't retrieved properly", result, "an_id");
    }

    @Test
    public void setId() throws Exception {
        //given
        final Category category = new Category();

        //when
        category.setId("an_id");

        //then
        final Field field = category.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(category), "an_id");
    }

    @Test
    public void getName() throws Exception{
        //given
        final Category category = new Category();
        final Field field = category.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(category, "a_name");

        //when
        final String result = category.getName();

        //then
        assertEquals("field wasn't retrieved properly", result, "a_name");

    }
    @Test
    public void setName() throws Exception {
        //given
        final Category category = new Category();

        //when
        category.setName("a_name");

        //then
        final Field field = category.getClass().getDeclaredField("name");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(category), "a_name");
    }

    @Test
    public void getImage() throws Exception{
        //given
        final Category category = new Category();
        final Field field = category.getClass().getDeclaredField("image");
        field.setAccessible(true);
        field.set(category, "an_image");

        //when
        final String result = category.getImage();

        //then
        assertEquals("field wasn't retrieved properly", result, "an_image");

    }
    @Test
    public void setImage() throws Exception {
        //given
        final Category category = new Category();

        //when
        category.setImage("an_image");

        //then
        final Field field = category.getClass().getDeclaredField("image");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(category), "an_image");
    }


}