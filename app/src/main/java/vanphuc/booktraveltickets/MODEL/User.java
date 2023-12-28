package vanphuc.booktraveltickets.MODEL;

public
class User {
    private int user_id;
    private String phone;
    private String name;
    private String password;

    public
    User(int user_id, String phone, String name, String password) {
        this.user_id = user_id;
        this.phone = phone;
        this.name = name;
        this.password = password;
    }

    // Getters and setters

    public
    int getUserId() {
        return user_id;
    }

    public
    String getPhone() {
        return phone;
    }

    public
    String getName() {
        return name;
    }

    public
    String getPassword() {
        return password;
    }
}
