package com.springframework.mockito.mockito_demo.list;

import org.junit.jupiter.api.Test;
import org.mockito.internal.util.MockUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    void simpleTest(){
        List mock2 = mock(List.class);

        mock2.size();
        when(mock2.size()).thenReturn(3);

        assertEquals(3,mock2.size());
        //multiple times it will return the same value once it is decided
    }

    @Test
    void parameteres(){
        List mock2 = mock(List.class);
        when(mock2.get(0)).thenReturn("SomeString");
        assertEquals("someString",mock2.get(0));
        assertEquals(null, mock2.get(1));
    }
    @Test
    void multipleReturns(){
        List mock2 = mock(List.class);
        when(mock2.size()).thenReturn(1).thenReturn(2);
        assertEquals(1,mock2.size());
        assertEquals(2,mock2.size());
        //the 2 will be the last value any no of times you call the function
    }

}
