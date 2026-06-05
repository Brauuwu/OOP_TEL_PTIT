import java.util.*;

abstract class Asset{
    private String name;
    private double value;
    private Date acquisitionDate;
    
    public Asset(String name, double value, Date acquisitionDate){
        this.name = name;
        this.value = value;
        this.acquisitionDate = acquisitionDate;
    }
    
    public String getName(){
        return name;
    }
    
    public double getValue(){
        return value;
    }
    
    public Date getAcquisitionDate(){
        return acquisitionDate;
    }
    
    abstract public double getDepreciation();
    
    public void displayAsset(){
        System.out.println("Asset Name: " + name);
        System.out.printf("Asset Value: %.1f\n", value);
        System.out.println("Depreciation: " + String.format("%.1f", getDepreciation()));
        System.out.println("---------------------------");
    }
}

class FixedAsset extends Asset{
    private int usefulLife;
    
    public FixedAsset(String name, double value, Date acquisitionDate, int usefulLife){
        super(name, value, acquisitionDate);
        this.usefulLife = usefulLife;
    }
    
    @Override
    public double getDepreciation(){
        return getValue() / usefulLife;
    }
    
}

class CurrentAsset extends Asset{
    private double liquidationValue;
    
    public CurrentAsset(String name, double value, Date acquisitionDate, double liquidationValue){
        super(name, value, acquisitionDate);
        this.liquidationValue = liquidationValue;
    }
    
    @Override
    public double getDepreciation(){
        return getValue() * 0.1;
    }
}

class IntangibleAsset extends Asset{
    private int amortizationPeriod;
    
    public IntangibleAsset(String name, double value, Date acquisitionDate, int amortizationPeriod){
        super(name, value, acquisitionDate);
        this.amortizationPeriod = amortizationPeriod;
    }
    
    @Override
    public double getDepreciation(){
        return getValue() / amortizationPeriod;
    }
}

class AssetManager{
    private ArrayList<Asset> assets;
    private double totalValue;
    private double totalDepreciation;
    
    public AssetManager(){
        assets = new ArrayList<Asset>();
        totalValue = 0;
        totalDepreciation = 0;
    }
    
    public void addAsset(Asset asset){
        assets.add(asset);
        totalValue += asset.getValue();
        totalDepreciation += asset.getDepreciation();
    }
    
    public double getTotalValue(){
        return totalValue;
    }
    
    public double getTotalDepreciation(){
        return totalDepreciation;
    }
}

public class Main{
    public static void main(String[] args){
        AssetManager manager = new AssetManager();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String[] s = sc.nextLine().split("\\s+");
            switch(s[0]){
                case "FixedAsset":
                    FixedAsset fa = new FixedAsset(s[1], Double.parseDouble(s[2]), new Date(), Integer.parseInt(s[3]));
                    manager.addAsset(fa);
                    fa.displayAsset();
                    break;
                case "CurrentAsset":
                    CurrentAsset ca = new CurrentAsset(s[1], Double.parseDouble(s[2]), new Date(), Double.parseDouble(s[3]));
                    manager.addAsset(ca);
                    ca.displayAsset();
                    break;
                case "IntangibleAsset":
                    IntangibleAsset ia = new IntangibleAsset(s[1], Double.parseDouble(s[2]), new Date(), Integer.parseInt(s[3]));
                    manager.addAsset(ia);
                    ia.displayAsset();
                    break;
            }
        }
        
        System.out.printf("Total Value of Assets: %.1f\n", manager.getTotalValue());
        System.out.printf("Total Depreciation of Assets: %.1f\n", manager.getTotalDepreciation());
        sc.close();
    }
}
