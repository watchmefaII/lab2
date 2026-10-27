public class Main {
    public static void main(String[] args) {
        double productCost = 9.99;
        double vatRate = 0.05;

        double vatAmount = productCost * vatRate;

        int unitsSold = 10000;
        double totalNetValue = 0.0;
        double totalVatAmount = 0.0;
        double totalGrossValue = 0.0;

        for (int i = 0; i < unitsSold; i++) {
            totalNetValue += productCost;
            totalVatAmount += vatAmount;
            totalGrossValue += (productCost + vatAmount);
        }

        System.out.println("Single Unit Net: " + productCost);
        System.out.println("Single Unit VAT: " + vatAmount);
        System.out.println("Total Net Sales: " + totalNetValue);
        System.out.println("Total VAT Amount: " + totalVatAmount);
        System.out.println("Total Gross Value: " + totalGrossValue);
    }
}