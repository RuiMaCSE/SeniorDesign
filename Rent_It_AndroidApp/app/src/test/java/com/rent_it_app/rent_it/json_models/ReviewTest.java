package com.rent_it_app.rent_it.json_models;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rui on 3/18/17./
 */
public class ReviewTest {
    @Test
    public void getId() throws Exception {
        //given
        final Review review = new Review();
        final Field field = review.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(review, "an_id");

        //when
        final String result = review.getId();

        //then
        assertEquals("field wasn't retrieved properly", result, "an_id");
    }

    @Test
    public void setId() throws Exception {
        //given
        final Review review = new Review();

        //when
        review.setId("an_id");

        //then
        final Field field = review.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(review), "an_id");
    }

    @Test
    public void getItem() throws Exception{
        //given
        final Review review = new Review();
        final Field field = review.getClass().getDeclaredField("item");
        field.setAccessible(true);
        field.set(review, "an_item");

        //when
        final String result = review.getItem();

        //then
        assertEquals("field wasn't retrieved properly", result, "an_item");

    }
    @Test
    public void setItem() throws Exception {
        //given
        final Review review = new Review();

        //when
        review.setItem("an_item");

        //then
        final Field field = review.getClass().getDeclaredField("item");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(review), "an_item");
    }

    @Test
    public void getOwner() throws Exception{
        //given
        final Review review = new Review();
        final Field field = review.getClass().getDeclaredField("owner");
        field.setAccessible(true);
        field.set(review, "an_owner");

        //when
        final String result = review.getOwner();

        //then
        assertEquals("field wasn't retrieved properly", result, "an_owner");

    }
    @Test
    public void setOwner() throws Exception {
        //given
        final Review review = new Review();

        //when
        review.setOwner("an_owner");

        //then
        final Field field = review.getClass().getDeclaredField("owner");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(review), "an_owner");
    }

    @Test
    public void getItemRating() throws Exception{
        //given
        final Review review = new Review();
        final Field field = review.getClass().getDeclaredField("itemRating");
        field.setAccessible(true);
        field.set(review, 1);

        //when
        final int result = review.getItemRating();

        //then
        assertEquals("field wasn't retrieved properly", result, 1);

    }
    @Test
    public void setItemRating() throws Exception {
        //given
        final Review review = new Review();

        //when
        review.setItemRating(1);

        //then
        final Field field = review.getClass().getDeclaredField("itemRating");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(review), 1);
    }

    @Test
    public void getTitle() throws Exception{
        //given
        final Review review = new Review();
        final Field field = review.getClass().getDeclaredField("title");
        field.setAccessible(true);
        field.set(review, "a_title");

        //when
        final String result = review.getTitle();

        //then
        assertEquals("field wasn't retrieved properly", result, "a_title");

    }
    @Test
    public void setTitle() throws Exception {
        //given
        final Review review = new Review();

        //when
        review.setTitle("a_title");

        //then
        final Field field = review.getClass().getDeclaredField("title");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(review), "a_title");
    }

    @Test
    public void getItemComment() throws Exception{
        //given
        final Review review = new Review();
        final Field field = review.getClass().getDeclaredField("itemComment");
        field.setAccessible(true);
        field.set(review, "an_itemComment");

        //when
        final String result = review.getItemComment();

        //then
        assertEquals("field wasn't retrieved properly", result, "an_itemComment");

    }
    @Test
    public void setItemComment() throws Exception {
        //given
        final Review review = new Review();

        //when
        review.setItemComment("an_itemComment");

        //then
        final Field field = review.getClass().getDeclaredField("itemComment");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(review), "an_itemComment");
    }

    @Test
    public void getOwnerRating() throws Exception{
        //given
        final Review review = new Review();
        final Field field = review.getClass().getDeclaredField("ownerRating");
        field.setAccessible(true);
        field.set(review, 2);

        //when
        final int result = review.getOwnerRating();

        //then
        assertEquals("field wasn't retrieved properly", result, 2);

    }
    @Test
    public void setOwnerRating() throws Exception {
        //given
        final Review review = new Review();

        //when
        review.setOwnerRating(2);

        //then
        final Field field = review.getClass().getDeclaredField("ownerRating");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(review), 2);
    }

    @Test
    public void getOwnerComment() throws Exception{
        //given
        final Review review = new Review();
        final Field field = review.getClass().getDeclaredField("ownerComment");
        field.setAccessible(true);
        field.set(review, "an_ownerComment");

        //when
        final String result = review.getOwnerComment();

        //then
        assertEquals("field wasn't retrieved properly", result, "an_ownerComment");

    }
    @Test
    public void setOwnerComment() throws Exception {
        //given
        final Review review = new Review();

        //when
        review.setOwnerComment("an_ownerComment");

        //then
        final Field field = review.getClass().getDeclaredField("ownerComment");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(review), "an_ownerComment");
    }

    @Test
    public void getReviewer() throws Exception{
        //given
        final Review review = new Review();
        final Field field = review.getClass().getDeclaredField("reviewer");
        field.setAccessible(true);
        field.set(review, "a_reviewer");

        //when
        final String result = review.getReviewer();

        //then
        assertEquals("field wasn't retrieved properly", result, "a_reviewer");

    }
    @Test
    public void setReviewer() throws Exception {
        //given
        final Review review = new Review();

        //when
        review.setReviewer("a_reviewer");

        //then
        final Field field = review.getClass().getDeclaredField("reviewer");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(review), "a_reviewer");
    }

    @Test
    public void getDateCreated() throws Exception{
        //given
        final Review review = new Review();
        final Field field = review.getClass().getDeclaredField("dateCreated");
        field.setAccessible(true);
        field.set(review, "a_dateCreated");

        //when
        final String result = review.getDateCreated();

        //then
        assertEquals("field wasn't retrieved properly", result, "a_dateCreated");

    }
    @Test
    public void setDateCreated() throws Exception {
        //given
        final Review review = new Review();

        //when
        review.setDateCreated("a_dateCreated");

        //then
        final Field field = review.getClass().getDeclaredField("dateCreated");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(review), "a_dateCreated");
    }
}