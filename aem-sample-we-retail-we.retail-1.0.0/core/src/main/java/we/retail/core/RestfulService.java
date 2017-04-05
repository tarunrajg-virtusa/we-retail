package we.retail.core;

public interface RestfulService {

    /**
     * Returns the entire product catalog
     * Example:  http://localhost:4502/bin/destinations?region=all
     */
    public String getAllDestinations();


    /**
     * Show all Foosball Tables
     * Example:  http://localhost:4502/bin/destinations?region=asia
     */
    public String getAsia();

    /**
     * Show all Accessories
     * Example:  http://localhost:4502/bin/destinations?region=middleEast
     */
    public String getMiddleEast();

}

