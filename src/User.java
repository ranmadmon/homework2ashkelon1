public class User{
        private String userName;
        private String password;
        private String phoneNumber;
        private int realEstateBrokerOrNot;
        public User(String userName,String password){
            this.userName=userName;
            this.password=password;
        }
        public User(){

        }
        public void setUserName(String userName){
            this.userName=userName;
        }//O(1)
        public void setPassword(String password){
            this.password=password;
        }//O(1)
        public void setPhoneNumber(String phoneNumber){
            this.phoneNumber=phoneNumber;
        }//O(1)
        public void setRealEstateBrokerOrNot(int realEstateBrokerOrNot){//O(1)
            this.realEstateBrokerOrNot=realEstateBrokerOrNot;
        }
        public String getPassword(){
            return this.password;
        }//O(1)
        public String getUserName(){
            return userName;
        }//O(1)
        public String getPhoneNumber(){
            return this.phoneNumber;
        }//O(1)
        public int getRealEstateBrokerOrNot(){
            return this.realEstateBrokerOrNot;
        }//O(1)
        boolean equalsUser(String userName,String password){
            if (userName.equals(this.userName)&&password.equals(this.password)){
                return true;
            }
            return false;
        }
}
