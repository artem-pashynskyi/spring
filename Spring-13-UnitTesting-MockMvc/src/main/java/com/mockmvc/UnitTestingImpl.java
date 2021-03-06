package com.mockmvc;

import java.util.Arrays;

public class UnitTestingImpl {

    DataRepository dataRepository;

    public UnitTestingImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public UnitTestingImpl() {
    }

    public int calculateSum(int[] data) {
        return Arrays.stream(data).sum();
    }

    public int calculateSumUsingDataService() {
        return Arrays.stream(dataRepository.findAll()).sum();
    }

    public int calculateSumUsingDataService_withParameter() {
        return Arrays.stream(dataRepository.findById(2)).sum();
    }
}
