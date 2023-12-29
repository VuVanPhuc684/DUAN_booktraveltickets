package vanphuc.booktraveltickets.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import vanphuc.booktraveltickets.MODEL.User;

public
class UserDao {
    private SQLiteDatabase database;

    public UserDao(SQLiteDatabase database) {
        this.database = database;
    }

    public boolean register(User user) {
        ContentValues values = new ContentValues ();
        values.put("phone", user.getPhone());
        values.put("name", user.getName());
        values.put("password", user.getPassword());

        long result = database.insert("Users", null, values);
        return result != -1;
    }

    public
    User login(String phone, String password) {
        User user = null;
        String[] columns = { "user_id", "phone", "name", "password" };
        String selection = "phone = ? AND password = ?";
        String[] selectionArgs = { phone, password };
        Cursor cursor = database.query("Users", columns, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            @SuppressLint("Range") int userId = cursor.getInt(cursor.getColumnIndex("user_id"));
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
            user = new User(userId, phone, name, password);
        }
        cursor.close();
        return user;
    }
}
