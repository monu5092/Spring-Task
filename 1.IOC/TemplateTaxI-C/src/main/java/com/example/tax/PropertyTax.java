package com.example.tax;

public class PropertyTax implements Tax {

      double taxableAmount;
      double taxAmount;
      boolean isTaxPayed;

    @Override
    public void setTaxableAmount(int amount) {
          taxableAmount=amount;
    }

    @Override
    public double calculateTaxAmount() {
              taxAmount=0.05*taxableAmount;
        return 0;
    }

    @Override
    public double getTaxAmount() {
        return taxAmount;
    }

    @Override
    public String getTaxType() {
        return "property";
    }

    @Override
    public boolean isTaxPayed() {
        return false;
    }

    @Override
    public void payTax() {
             System.out.println("Hi, your property tax is  paid");
             isTaxPayed=true;
    }

}
