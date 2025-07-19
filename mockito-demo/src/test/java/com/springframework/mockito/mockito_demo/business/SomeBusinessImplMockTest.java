package com.springframework.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl businessImpl;
    @Test
    void findTheGreatestFromAllData_basics() {

        //DataService dataServiceMock = mock(DataService.class);
        //we have to tell mockito when this method is called then the mockito should return the array of integers
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25,12,10});
        //SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25,result);
    }

    @Test
    void findTheGreatestFromAllData_OneValue() {

        //DataService dataServiceMock = mock(DataService.class);
        //we have to tell mockito when this method is called then the mockito should return the array of integers
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{35});
        //SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(35,result);
    }

    @Test
    void findTheGreatestFromAllData_EmptyArray(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE,businessImpl.findTheGreatestFromAllData());
    }

}

class DataServiceMock implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{25,5,15};
    }
}