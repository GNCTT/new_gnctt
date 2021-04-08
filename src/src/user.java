package src;

public class user {
    private String userIdAccount;
    private String userName;
    private String userAddress;
    private int accountBalance;

    public user(String userIdAccount){
        this.userIdAccount=userIdAccount;
        this.userName="undefined";
        this.userAddress="undefined";
        this.accountBalance=0;
    }
    public user(String userIdAccount,String userName){
        this.userIdAccount=userIdAccount;
        this.userName=userName;
        this.userAddress="undefined";
        this.accountBalance=0;
    }
    public user(String userIdAccount,String userName,String userAddress){
        this.userIdAccount=userIdAccount;
        this.userName=userName;
        this.userAddress=userAddress;
        this.accountBalance=0;
    }
    public user(String userIdAccount,String userName,String userAddress,int accountBalance){
        this.userIdAccount=userIdAccount;
        this.userName=userName;
        this.userAddress=userAddress;
        this.accountBalance=accountBalance;
    }

    public void transferMoney(int amountOfMoney){
        this.accountBalance=this.accountBalance+amountOfMoney;
    }

    public void payBill(int amountOfMoney){
        this.accountBalance=this.accountBalance-amountOfMoney;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserIdAccount() {
        return userIdAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int compareTo(user x){
        if(this.userName.equals("undefined") && x.userName.equals("undefined")) return 1;
        else if(this.userName.equals("undefined")) return -1;
        else if(x.userName.equals("undefined")) return 1;
        else {
            return this.userName.compareTo(x.userName);
        }
    }
}
