package furnitureshop.company;

import furnitureshop.product.chair.Chair;
import furnitureshop.product.coffetable.CoffeTable;
import furnitureshop.product.sofa.Sofa;

public abstract class Company {
    
    public abstract Chair createChair();

    public abstract CoffeTable createCoffeTable();

    public abstract Sofa createSofa();
}
