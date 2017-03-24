package com.rent_it_app.rent_it.json_models;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rui on 3/18/17./
 */
public class ConversationTest {
    @Test
    public void getRental_id() throws Exception {
        //given
        final Conversation conversation = new Conversation();
        final Field field = conversation.getClass().getDeclaredField("rental_id");
        field.setAccessible(true);
        field.set(conversation, "a_rental_id");

        //when
        final String result = conversation.getRental_id();

        //then
        assertEquals("field wasn't retrieved properly", result, "a_rental_id");
    }

    @Test
    public void setRental_id() throws Exception {
        //given
        final Conversation conversation = new Conversation();

        //when
        conversation.setRental_id("a_rental_id");

        //then
        final Field field = conversation.getClass().getDeclaredField("rental_id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(conversation), "a_rental_id");
    }

    @Test
    public void getItem_id() throws Exception {
        //given
        final Conversation conversation = new Conversation();
        final Field field = conversation.getClass().getDeclaredField("item_id");
        field.setAccessible(true);
        field.set(conversation, "an_item_id");

        //when
        final String result = conversation.getItem_id();

        //then
        assertEquals("field wasn't retrieved properly", result, "an_item_id");
    }

    @Test
    public void setItem_id() throws Exception {
        //given
        final Conversation conversation = new Conversation();

        //when
        conversation.setItem_id("an_item_id");

        //then
        final Field field = conversation.getClass().getDeclaredField("item_id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(conversation), "an_item_id");
    }

    @Test
    public void getItem_name() throws Exception {
        //given
        final Conversation conversation = new Conversation();
        final Field field = conversation.getClass().getDeclaredField("item_name");
        field.setAccessible(true);
        field.set(conversation, "an_item_name");

        //when
        final String result = conversation.getItem_name();

        //then
        assertEquals("field wasn't retrieved properly", result, "an_item_name");
    }

    @Test
    public void setItem_name() throws Exception {
        //given
        final Conversation conversation = new Conversation();

        //when
        conversation.setItem_name("an_item_name");

        //then
        final Field field = conversation.getClass().getDeclaredField("item_name");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(conversation), "an_item_name");
    }

    @Test
    public void getOwner() throws Exception {
        //given
        final Conversation conversation = new Conversation();
        final Field field = conversation.getClass().getDeclaredField("owner");
        field.setAccessible(true);
        field.set(conversation, "an_owner");

        //when
        final String result = conversation.getOwner();

        //then
        assertEquals("field wasn't retrieved properly", result, "an_owner");
    }

    @Test
    public void setOwner() throws Exception {
        //given
        final Conversation conversation = new Conversation();

        //when
        conversation.setOwner("an_owner");

        //then
        final Field field = conversation.getClass().getDeclaredField("owner");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(conversation), "an_owner");
    }

    @Test
    public void getRenter() throws Exception {
        //given
        final Conversation conversation = new Conversation();
        final Field field = conversation.getClass().getDeclaredField("renter");
        field.setAccessible(true);
        field.set(conversation, "a_renter");

        //when
        final String result = conversation.getRenter();

        //then
        assertEquals("field wasn't retrieved properly", result, "a_renter");
    }

    @Test
    public void setRenter() throws Exception {
        //given
        final Conversation conversation = new Conversation();

        //when
        conversation.setRenter("a_renter");

        //then
        final Field field = conversation.getClass().getDeclaredField("renter");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(conversation), "a_renter");
    }




}