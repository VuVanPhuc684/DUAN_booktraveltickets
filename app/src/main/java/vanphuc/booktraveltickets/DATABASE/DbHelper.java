package vanphuc.booktraveltickets.DATABASE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "travel_tickets.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Tạo bảng Users
        String createUsersTable = "CREATE TABLE Users (" +
                "user_id INTEGER PRIMARY KEY," +
                "phone TEXT," +
                "name TEXT," +
                "password TEXT" +
                ")";
        sqLiteDatabase.execSQL(createUsersTable);
        sqLiteDatabase.execSQL ("insert into Users values (1,'0981139895','admin','admin')");




        // Tạo bảng Trips
        String createTripsTable = "CREATE TABLE Trips (" +
                "trip_id INTEGER PRIMARY KEY," +
                "title TEXT," +
                "description TEXT," +
                "start_date DATE," +
                "end_date DATE," +
                "destination TEXT," +
                "price DECIMAL," +
                "created_at DATETIME" +
                ")";
        sqLiteDatabase.execSQL(createTripsTable);

        // Tạo bảng Bookings
        String createBookingsTable = "CREATE TABLE Bookings (" +
                "booking_id INTEGER PRIMARY KEY," +
                "user_id INTEGER," +
                "trip_id INTEGER," +
                "num_of_tickets INTEGER," +
                "total_price DECIMAL," +
                "created_at DATETIME," +
                "FOREIGN KEY (user_id) REFERENCES Users(user_id)," +
                "FOREIGN KEY (trip_id) REFERENCES Trips(trip_id)" +
                ")";
        sqLiteDatabase.execSQL(createBookingsTable);

        // Tạo bảng Tickets
        String createTicketsTable = "CREATE TABLE Tickets (" +
                "ticket_id INTEGER PRIMARY KEY," +
                "booking_id INTEGER," +
                "ticket_number TEXT," +
                "passenger_name TEXT," +
                "created_at DATETIME," +
                "FOREIGN KEY (booking_id) REFERENCES Bookings(booking_id)" +
                ")";
        sqLiteDatabase.execSQL(createTicketsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Xóa bảng cũ nếu tồn tại và tạo lại cơ sở dữ liệu
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Tickets");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Bookings");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Trips");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Users");
        onCreate(sqLiteDatabase);
    }
}