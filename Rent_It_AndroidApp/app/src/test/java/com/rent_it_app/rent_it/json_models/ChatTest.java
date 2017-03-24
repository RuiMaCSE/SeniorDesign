package com.rent_it_app.rent_it.json_models;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rui on 3/18/17./
 */
public class ChatTest {
    @Test
    public void getStatus() throws Exception {
        //given
        final Chat chat = new Chat();
        final Field field = chat.getClass().getDeclaredField("status");
        field.setAccessible(true);
        field.set(chat, 1);

        //when
        final int result = chat.getStatus();

        //then
        assertEquals("field wasn't retrieved properly", result, 1);
    }

    @Test
    public void setStatus() throws Exception {
        //given
        final Chat chat = new Chat();

        //when
        chat.setStatus(1);

        //then
        final Field field = chat.getClass().getDeclaredField("status");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(chat), 1);
    }

}