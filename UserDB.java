public class UserDB {
    User[] users;
    int numUser;


    UserDB(){
        users = new User[3];
        numUser = 0;
    }

    public void addUser(User user){
        this.users[numUser] = user;
    }
}
