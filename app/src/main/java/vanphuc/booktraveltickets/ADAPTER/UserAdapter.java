package vanphuc.booktraveltickets.ADAPTER;

import java.util.List;

import vanphuc.booktraveltickets.MODEL.User;

public
class UserAdapter {
    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    public User login(String phone, String password) {
        User user = null;
        for (User u : userList) {
            if (u.getPhone().equals(phone) && u.getPassword().equals(password)) {
                user = u;
                break;
            }
        }
        return user;
    }
}
