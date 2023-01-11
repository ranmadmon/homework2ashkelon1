public class Property {
    private City city;
    private String street;
    private int numberOfRooms;
    private int price;
    private int typeOfHouse;
    private int loanOrSale;
    private int numberOfHouse;
    private int floor;
    private User user;
    public String toString()//O(1)
    {
        String forRent;
        if (this.loanOrSale==1){
            forRent="for rent";
        }else {
            forRent="For sale";
        }
        String realEstateBrokerOrNot="";
        if (this.user.getRealEstateBrokerOrNot()==1){
            realEstateBrokerOrNot="(real estate broker) .";
        }else {
            realEstateBrokerOrNot="(personal pepole) .";
        }
        String typeHouse;
        if (typeOfHouse==1){
            typeHouse="Regular apartment";
        }else if(typeOfHouse==2){
            typeHouse="Penthouse";
        }else {
            typeHouse="private house";
        }
        String floor=" .";
        if (this.floor!=-1){
            floor=", floor "+this.floor+" .";
        }
        return city.getName()+" - "+ this.street+" "+this.numberOfHouse+" ."+"\n"+
                typeHouse + " - "+forRent+" : "+ this.numberOfRooms+" rooms"+floor+"\n"+
                "Price: "+price+"$."+"\n"+
                "Contact info: "+user.getUserName()+" "+user.getPhoneNumber()+" "+realEstateBrokerOrNot+"\n" +
                "";

    }
    void setUser(User user){
        this.user=user;
    }//O(1)
    void setCity(City city){
        this.city=city;
    }//O(1)
    User getUser(){return this.user;}//O(1)
    int getNumberOfRooms(){return numberOfRooms;}//O(1)
    int getTypeOfHouse(){return typeOfHouse;}//O(1)
    int getPrice(){return price;}//O(1)
    int getLoanOrSale(){return loanOrSale;}//O(1)
    public Property(){};//O(1)
    public Property(City city,String street,int numberOfRooms,int price,int typeOfHouse,int loanOrSale,int numberOfHouse,int floor,User user){//O(1)
        this.city=city;
        this.street=street;
        this.numberOfRooms=numberOfRooms;
        this.price=price;
        this.typeOfHouse=typeOfHouse;
        this.loanOrSale=loanOrSale;
        this.numberOfHouse=numberOfHouse;
        this.floor=floor;
        this.user=user;
    }
}
