public class City {
    private String name;
    private String geographicDistrict;
    private String[] streets;

    public City(String name, String geographicDistrict, String[] streets) {//O(1)
        this.name = name;
        this.geographicDistrict = geographicDistrict;
        this.streets = streets;
    }

    String getName() {
        return name;
    }//O(1)
    String[] getStreets(){return streets;}//O(1)

    void setStreets(String[] streets) {
        this.streets = streets;
    }//O(1)
    public City(){}//O(1)

    void printStreets() {//O(n)
        System.out.print("Streets : ");
        for (int i = 0; i < streets.length; i++) {
            if (i == streets.length - 1) {
                System.out.print(streets[i] + " .");
            } else {
                System.out.print(streets[i] + " , ");
            }
        }
        System.out.println();
    }

}
