import java.util.Scanner;

public class RealEstate {
    private final String phoneNumberStartWith05="05";
    private  City[] cities = new City[10];
    private Property[] properties=new Property[500];
    private  User[] users= new User[100];

    void setProperties(Property[] properties) {
        this.properties = properties;
    }

    public void RealEstate() {
        String[] streetsBeerSheva={"Bialik","Shaul Hamelech","Jerusalem","Rabi akiva"};
        cities[0]=new City("Beer sheva","wipe",streetsBeerSheva);
        String[] streetsHaifa={"Hagefen","Hermon","Hazait","Peer","Nesher","Yosef","Hilel","Meir","Yafo"};
        cities[1]=new City("Haifa","north",streetsHaifa);
        String[] streetsTelAviv={"Yafo"," Herzl","Nahalat Binyamin","Allenby","HaCarmel","Rothshild","Montefiore","Bialik"};
        cities[2]=new City("Tel Aviv","center",streetsTelAviv);
        String[] streetsAshkelon={"Balfur","Megido","Bialik","Ben Guryon","Palmach","Bikat Rimon","Nizanim"};
        cities[3]=new City("Ashkelon","center",streetsAshkelon);
        String[] streetsHedera={"Herzel","Bialik","Begin","Ranmbam","Hayarden","Habanim","Hashikma","Ofira"};
        cities[4]=new City("Hedera","north",streetsHedera);
        String[] streetsHerzliya={"Ben Guryon","Habashan","Hasunit","Palmach","Hagalil","Hashoftim","Ben Yehuda"};
        cities[5]=new City("Herzliya","center",streetsHerzliya);
        String[] streetsAco={"Mota Gur","Hadekel","Ben Ami","Herzog","Hanadiv","Hacerem"};
        cities[6]=new City("Aco","north",streetsAco);
        String[] streetsElat={"Shor","Horev","Hanevatim","Shoham","Hahotrim","Gishron"};
        cities[7]=new City("Elat","wipe",streetsElat);
        String[] streetsAshdod={"Cineret","Bialik","Mezada","Hadekel","Hanurit","Harotem"};
        cities[8]=new City("Ashdod","south",streetsAshdod);
        String[] streetsGedera={"Shapira","Pines","Bialik","Baraket","Dolev","Odem"};
        cities[9]=new City("Gedera","center",streetsGedera);
        int number;
        User nullOrNot = new User();
        boolean oneMoreRound = false;
        do {
            oneMoreRound = false;
            Scanner scanner = new Scanner(System.in);
            System.out.println("If you want to create an account enter 1\n" +
                    "If you want to log in to your account enter 2\n" +
                    "If you want to finish enter 3");
            number = scanner.nextInt();
            if (number == 1) {
                createUser();
                oneMoreRound = true;
            } else if (number == 2) {
                nullOrNot = login();
                if (nullOrNot == null) {
                    System.out.println("The useraName or the password aren't correct");
                    oneMoreRound = true;
                } else {
                    boolean MoreRound=false;
                    do {
                        MoreRound=false;
                        System.out.println("If you want to advertise a new property enter 1\n" +
                                "If you want to remove advertising enter 2\n" +
                                "If you want to display all of the properties in the system enter 3\n" +
                                "If you want to display all of the properties of that belong to spesific user enter 4\n" +
                                "if you want to search properties by parameters enter 5\n" +
                                "if you want to exit and back to the main menu enter 6");
                        int number1 = scanner.nextInt();
                        if (number1 == 1) {
                            postNewProperty(nullOrNot);
                            MoreRound=true;
                        }
                        if (number1 == 2) {
                            removeProperty(nullOrNot);
                            MoreRound=true;
                        }
                        if (number1 == 3) {
                            printAllProperties();
                            MoreRound=true;
                        }
                        if (number1==4){
                            printProperties(nullOrNot);
                            MoreRound=true;
                        }
                        if (number1==5){
                            Property[]properties1 =search();
                            int propertyNumber=1;
                            for (int i=0;i<properties1.length;i++){
                                System.out.println("Property number "+propertyNumber+" : ");
                                System.out.println(properties1[i]);
                                propertyNumber++;
                            }
                            MoreRound=true;
                        }
                    }while (MoreRound);
                    oneMoreRound=true;
                }
            } else if (number==3) {
                oneMoreRound=false;
            }

        } while (oneMoreRound);
    }
    void createUser() {
        Scanner scanner = new Scanner(System.in);
        int indexUser = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                indexUser = i;
                break;
            }
        }
        users[indexUser] = new User();
        boolean userExist;
        String username;
        do {
            userExist = false;
            System.out.print("Enter a username : ");
            username = scanner.nextLine();
            for (int i = 0; i < indexUser; i++) {
                if (username.equals(users[i].getUserName())) {
                    userExist = true;
                    System.out.print("The userName is already taken ");
                }
            }
        } while (userExist);
        this.users[indexUser].setUserName(username);
        boolean hardChar;
        boolean numberIn;
        String password;
        do {
            System.out.print("Enter your password : ");
            password = scanner.nextLine();
            hardChar = false;
            numberIn = false;
            if (password.length() >= 5) {
                for (int i = 0; i < password.length(); i++) {
                    if (password.charAt(i) == '%' || password.charAt(i) == '_' || password.charAt(i) == '$') {
                        hardChar = true;
                    }
                    if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                        numberIn = true;
                    }
                }
            }
        } while (!numberIn || !hardChar);
        users[indexUser].setPassword(password);
        boolean phoneNumberCorrectOrNot;
        String phoneNumber;
        do {
            System.out.print("Enter your number : ");
            phoneNumber = scanner.nextLine();
            phoneNumberCorrectOrNot = true;
            if (phoneNumber.startsWith(phoneNumberStartWith05)) {
                if (phoneNumber.length() == 10) {
                    for (int i = 2; i < 10; i++) {
                        if (phoneNumber.charAt(i) > '9' || phoneNumber.charAt(i) < '0') {
                            phoneNumberCorrectOrNot = false;
                            break;
                        }
                    }
                } else {
                    phoneNumberCorrectOrNot = false;
                }
            } else {
                phoneNumberCorrectOrNot = false;
            }
        } while (!phoneNumberCorrectOrNot);
        users[indexUser].setPhoneNumber(phoneNumber);
        System.out.print("If you have realEstate broker enter 1, If you have not enter 2 : ");
        int realEstateBroker = scanner.nextInt();
        users[indexUser].setRealEstateBrokerOrNot(realEstateBroker);
    }

    User login() {//O(n)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username : ");
        String username = scanner.nextLine();
        System.out.print("Enter your password : ");
        String password = scanner.nextLine();
        for (int i=0;i<users.length;i++){
            if (users[i]==null){
                return null;
            } else if (users[i].equalsUser(username,password)){
                return users[i];
            }
        }
        return null;
    }
    int numberOfPropertiesByUser(User user){//O(n)
        int counter=0;
        for (int i=0;i<properties.length;i++){
            if (properties[i]==null){}
            else {
                if (properties[i].getUser().getUserName().equals(user.getUserName())){
                    counter++;
                }
            }
        }
        return counter;
    }
    void printCities(){//O(n)
        System.out.print("cities : ");
        for (int i=0;i<cities.length;i++){
            if (cities[i]!=null){
                if (i==cities.length-1){
                    System.out.print(cities[i].getName()+" .");
                }else {
                    System.out.print(cities[i].getName()+ " , ");
                }
            }
        }
        System.out.println();

    }
    int indexEmptyPlaceProperty(){//O(n)
        for (int i=0;i<properties.length;i++){
            if (properties[i]==null){
                return i;
            }
        }
        return -1;
    }
    boolean postNewProperty(User user){//O(n)
        Scanner scanner=new Scanner(System.in);
        if (user.getRealEstateBrokerOrNot()==1){
            if (numberOfPropertiesByUser(user)>=5){
                System.out.println("You have reached your limit of posts");
                return false;
            }
        }
        if (user.getRealEstateBrokerOrNot()==2){
            if (numberOfPropertiesByUser(user)>=2){
                System.out.println("You have reached your limit of posts");
                return false;
            }
        }
        printCities();
        System.out.print("Enter name of a city : ");
        String cityName=scanner.nextLine();
        int indexCity=0;
        City city=new City();
        boolean cityInculd=false;
        for (int i=0;i<cities.length;i++){
            if (cities[i].getName().equals(cityName)){
                indexCity=i;
                cityInculd=true;
                city=cities[i];
                break;
            }
        }
        if (cityInculd){
            cities[indexCity].printStreets();
            System.out.print("Enter a name of a strret from the list : ");
            String street=scanner.nextLine();
            boolean streetInclud=false;
            String street1="";
            for (int i=0;i<cities[indexCity].getStreets().length;i++){
                if (cities[indexCity].getStreets()[i].equals(street)){
                    streetInclud=true;
                    street1=cities[indexCity].getStreets()[i];
                    break;
                }
            }
            if (streetInclud){
                Property property=new Property();
                int floor=-1;int numberOfRooms;int numberOfHouse;int loanOrSale;
                System.out.println("What is type of the house:\n" +
                        "Regular house enter 1\n" +
                        "penthouse enter 2\n" +
                        "private house enter 3" );
                int typeHouse= scanner.nextInt();
                if (typeHouse==1||typeHouse==2){
                    System.out.print("enter thr floor : ");
                    floor= scanner.nextInt();
                }
                System.out.print("How much rooms there are in the property : ");
                numberOfRooms= scanner.nextInt();
                System.out.print("What is the number of the house : ");
                numberOfHouse= scanner.nextInt();
                System.out.println("If the property is for rent enter 1\n" +
                        "If the property for sale enter 2  ");
                loanOrSale= scanner.nextInt();
                System.out.print("Enter the price of the Property : ");
                int priceOfTheHouse= scanner.nextInt();
                properties[indexEmptyPlaceProperty()]=new Property(city,street1,numberOfRooms,priceOfTheHouse,typeHouse,loanOrSale,numberOfHouse,floor,user);
                return true;

            }else {
                System.out.println("The street aren't in the list");
                return false;
            }

        }else {
            System.out.println("The city isn't in the list of cities");
            return false;
        }
    }

    void removeProperty(User user) {//O(n)
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] == null) {

            } else {
                if (properties[i].getUser().equals(user)) {
                    counter++;
                    System.out.println(" proprety number " + counter + " :  " +"\n" + properties[i]);
                }
            }
        }
        int counter2 = 0;
        Property[] properties1 = new Property[counter];
        for (int i = 0; i < properties.length; i++) {
            if (counter == counter2) {
                break;
            }
            if (properties[i].getUser().equals(user)) {
                properties1[counter2] = properties[i];
                counter2++;
            }
        }
        if (counter == 0) {
            System.out.println("the user didn't advertise any properties");
        } else {
            System.out.print("enter the the number of property that you want to delete : ");
            int propertyRemove = scanner.nextInt();
            for (int i = 0; i < counter2; i++) {
                if (properties1[propertyRemove - 1].equals(properties[i])) {
                    properties[i] = null;
                    break;
                }
            }
        }

    }
    void printAllProperties() {//O(n)
        int counter = 1;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null) {
                System.out.println("Property number " + counter + " : " +"\n" + properties[i]);
                counter++;
            }
        }
    }
    void printProperties(User user) {//O(n)
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null) {
                if (properties[i].getUser().getUserName().equals(user.getUserName())) {
                    System.out.println(properties[i]);
                }
            }
        }
    }

    Property[] search() {//O(n)
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you don't care about a certain question enter -999 ");
        System.out.println();
        System.out.println("If you want to rent the apartment enter 1 \n" +
                "If you want to buy the apartment etner 2");
        int rentOrBuy = scanner.nextInt();
        System.out.println("If you want Regular house enter 1\n" +
                "If you  want penthouse enter 2\n" +
                "if you want private house enter 3");
        int typeOfHouse = scanner.nextInt();
        System.out.print("How much rooms do you want : ");
        int numberOfRooms = scanner.nextInt();
        System.out.println("What is your desired price range enter minimum and maximum  ");
        System.out.print("Min : ");
        int min = scanner.nextInt();
        System.out.print("Max : ");
        int max = scanner.nextInt();
        Boolean rentOrSale = false;
        if (rentOrBuy == 1) {
            rentOrSale = true;
        }
        int counter = 0;
        for (int i = 0; i < properties.length; i++) {
            if(properties[i]==null){

            } else if ((properties[i].getNumberOfRooms() == numberOfRooms || numberOfRooms == -999) && (properties[i].getTypeOfHouse() == typeOfHouse || typeOfHouse == -999) && ((properties[i].getPrice() >= min && properties[i].getPrice() <= max) || (min == -999 || max == -999)) && (properties[i].getLoanOrSale() == rentOrBuy|| rentOrBuy == -999)) {
                counter++;
            }
        }
        Property[] properties1 = new Property[counter];
        int counter2 = 0;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i]==null){
                break;
            }else if ((properties[i].getNumberOfRooms() == numberOfRooms || numberOfRooms == -999) && (properties[i].getTypeOfHouse() == typeOfHouse || typeOfHouse == -999) && ((properties[i].getPrice() >= min && properties[i].getPrice() <= max) || (min == -999 || max == -999)) && (properties[i].getLoanOrSale() == rentOrBuy || rentOrBuy == -999)) {
                if (counter == counter2) {
                    break;
                }
                properties1[counter2] = properties[i];
                counter2++;
            }
        }
        return properties1;
    }

}
