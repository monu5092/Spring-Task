package com.example.tax;

public class IncomeTax implements Tax{

    double taxableAmount ;
    double taxAmount;
    boolean isTaxPayed;

    public IncomeTax(){
        isTaxPayed=false;
    }

    @Override
    public void setTaxableAmount(int amount) {
          taxableAmount=amount;
    }

    @Override
    public double calculateTaxAmount() {
          if(taxableAmount<=300000){
                 taxAmount=0;
          }
          else if(taxableAmount>300000 &&  taxableAmount<=600000){
              taxAmount = taxableAmount*0.05;
          }
          else if(taxableAmount>600000 && taxableAmount<=900000){
              taxAmount=taxableAmount*0.1;
          }
          else if(taxableAmount>900000 && taxableAmount<=1200000){
              taxAmount=taxableAmount*0.15;
          }
          else if(taxableAmount>1200000 && taxableAmount<=1500000){
              taxAmount=taxableAmount*0.2;
          }
          else{
              taxAmount=taxableAmount*0.3;
          }
        return 0;
    }

    @Override
    public double getTaxAmount() {
        return taxAmount ;
    }

    @Override
    public String getTaxType() {
        return "income";
    }

    @Override
    public boolean isTaxPayed() {
        return false;
    }

    @Override
    public void payTax() {
     System.out.println("Hi, your income tax is paid");
      isTaxPayed=true;
    }
}
