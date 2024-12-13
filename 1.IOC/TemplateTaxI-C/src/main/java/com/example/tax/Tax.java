package com.example.tax;

public interface Tax {

    void setTaxableAmount(int amount);

    double calculateTaxAmount();
    double getTaxAmount();
    // This method returns the taxType i.e. "income" or "property".
    String getTaxType();

    // This method returns the isTaxPayed boolean. Helpful when you load the bean from the
    // context to check if the tax is already paid.
    boolean isTaxPayed();
    void payTax();
}
