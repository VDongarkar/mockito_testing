package com.springframework.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeBusinessImplTest {

    @Test
    void findTheGreatestFromAllData_basics() {
        DataServiceStub dataServiceStub = new DataServiceStub();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25,result);
    }
}

class DataServiceStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{25,5,15};
    }
}