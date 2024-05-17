package com.example.demo;

import java.util.List;

public class BonusResponse {
    private String errorMessage;
    private List<BonusData> data;

    public BonusResponse() {
    }

    public BonusResponse(String errorMessage, List<BonusData> data) {
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<BonusData> getData() {
        return data;
    }

    public void setData(List<BonusData> data) {
        this.data = data;
    }
}

