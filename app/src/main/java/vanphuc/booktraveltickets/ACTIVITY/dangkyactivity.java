package vanphuc.booktraveltickets.ACTIVITY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vanphuc.booktraveltickets.DAO.UserDao;
import vanphuc.booktraveltickets.DATABASE.DbHelper;
import vanphuc.booktraveltickets.MODEL.User;
import vanphuc.booktraveltickets.R;

public class dangkyactivity extends AppCompatActivity {
    private EditText ETsdtdangky, ETtendangky, ETmatkhaudk, ETmatkhaunhaplaidk;
    private Button BTdangky;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangkyactivity);

        // Khởi tạo userDao với đối tượng SQLiteDatabase
        SQLiteDatabase db = new DbHelper(this).getWritableDatabase();
        userDao = new UserDao(db);

        ETsdtdangky = findViewById(R.id.ETsdtdangky);
        ETtendangky = findViewById(R.id.ETtendangky);
        ETmatkhaudk = findViewById(R.id.ETmatkhaudk);
        ETmatkhaunhaplaidk = findViewById(R.id.ETmatkhaunhaplaidk);
        BTdangky = findViewById(R.id.BTdangky);

        BTdangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin từ các trường EditText
                String phone = ETsdtdangky.getText().toString();
                String name = ETtendangky.getText().toString();
                String password = ETmatkhaudk.getText().toString();
                String confirmPassword = ETmatkhaunhaplaidk.getText().toString();

                // Kiểm tra mật khẩu nhập lại
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(dangkyactivity.this, "Mật khẩu nhập lại không khớp", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Tạo đối tượng User mới
                User user = new User();
                user.setPhone(phone);
                user.setName(name);
                user.setPassword(password);

                // Gọi phương thức đăng ký từ userDao
                boolean isSuccess = userDao.register(user);
                if (isSuccess) {
                    // Đăng ký thành công
                    Toast.makeText(dangkyactivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    // Chuyển đến màn hình đăng nhập
                    Intent intent = new Intent(dangkyactivity.this, dangnhapactivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Đăng ký thất bại
                    Toast.makeText(dangkyactivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}