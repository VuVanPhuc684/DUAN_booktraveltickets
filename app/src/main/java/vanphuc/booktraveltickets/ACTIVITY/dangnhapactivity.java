package vanphuc.booktraveltickets.ACTIVITY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import vanphuc.booktraveltickets.DAO.UserDao;
import vanphuc.booktraveltickets.DATABASE.DbHelper;
import vanphuc.booktraveltickets.MODEL.User;
import vanphuc.booktraveltickets.R;

public
class dangnhapactivity extends AppCompatActivity {

    private EditText ETsdtdangnhap, ETmatkhaudangnhap;
    private Button BTdangnhap;
    private TextView TVdangky;
    private UserDao userDao;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.dangnhapactivity);

        // Khởi tạo userDao với đối tượng SQLiteDatabase
        SQLiteDatabase db = new DbHelper (this).getReadableDatabase ();
        userDao = new UserDao (db);

        ETsdtdangnhap = findViewById (R.id.ETsdtdangnhap);
        ETmatkhaudangnhap = findViewById (R.id.ETmatkhaudangnhap);
        BTdangnhap = findViewById (R.id.BTdangnhap);
        TVdangky = findViewById (R.id.TVdangky);

        BTdangnhap.setOnClickListener (new View.OnClickListener () {
            @Override
            public
            void onClick(View v) {
                String phone = ETsdtdangnhap.getText ().toString ();
                String password = ETmatkhaudangnhap.getText ().toString ();

                // Gọi phương thức đăng nhập từ userDao
                User user = userDao.login (phone, password);
                if (user != null) {
                    // Đăng nhập thành công
                    Toast.makeText (dangnhapactivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show ();
                    Intent intent = new Intent (dangnhapactivity.this, MainActivity.class);
                    intent.putExtra ("user_id", user.getUserId ());
                    startActivity (intent);
                    finish ();
                } else {
                    // Đăng nhập thất bại
                    Toast.makeText (dangnhapactivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show ();
                }
            }
        });
        TVdangky.setOnClickListener (new View.OnClickListener () {
            @Override
            public
            void onClick(View view) {
                Intent intent = new Intent(dangnhapactivity.this, dangkyactivity.class);
                startActivity(intent);
            }
        });
    }
}