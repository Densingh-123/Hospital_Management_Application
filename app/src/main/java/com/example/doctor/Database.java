package com.example.doctor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "healthcare.db";
    private static final int DATABASE_VERSION = 1;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create users table
        String createUsersTable = "CREATE TABLE users (" +
                "username TEXT PRIMARY KEY, " +
                "email TEXT UNIQUE, " +
                "password TEXT)";
        db.execSQL(createUsersTable);

        // Create cart table
        String createCartTable = "CREATE TABLE cart (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT, " +
                "product TEXT, " +
                "price REAL, " +
                "otype TEXT, " +
                "FOREIGN KEY (username) REFERENCES users(username))";
        db.execSQL(createCartTable);

        // Create orderplace table
        String createOrderPlaceTable = "CREATE TABLE orderplace (" +
                "username TEXT, " +
                "fullname TEXT, " +
                "package TEXT, " + // Added package field
                "price REAL, " +    // Added price field
                "address TEXT, " +
                "contactno TEXT, " +
                "pincode INTEGER, " +
                "date TEXT, " +
                "time TEXT, " +
                "amount REAL, " +
                "otype TEXT)";
        db.execSQL(createOrderPlaceTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS cart");
        db.execSQL("DROP TABLE IF EXISTS orderplace");
        onCreate(db);
    }

    // Register a new user
    public void register(String username, String email, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("email", email);
        values.put("password", password);
        db.insert("users", null, values);
        db.close();
    }

    // Check if username or email already exists
    public boolean isUserExists(String username, String email) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM users WHERE username=? OR email=?";
        Cursor cursor = db.rawQuery(query, new String[]{username, email});
        boolean exists = cursor.moveToFirst();
        cursor.close();
        db.close();
        return exists;
    }

    // Validate login credentials
    public boolean login(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM users WHERE username=? AND password=?";
        Cursor cursor = db.rawQuery(query, new String[]{username, password});
        boolean isValid = cursor.moveToFirst();
        cursor.close();
        db.close();
        return isValid;
    }

    // Add item to the cart
    public void addCart(String username, String product, float price, String otype) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("product", product);
        values.put("price", price);
        values.put("otype", otype);
        db.insert("cart", null, values);
        db.close();
    }

    // Check if item exists in the cart
    public boolean isItemInCart(String username, String product) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM cart WHERE username=? AND product=?";
        Cursor cursor = db.rawQuery(query, new String[]{username, product});
        boolean exists = cursor.moveToFirst();
        cursor.close();
        db.close();
        return exists;
    }

    // Remove items from cart by order type
    public void removeCart(String username, String otype) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("cart", "username=? AND otype=?", new String[]{username, otype});
        db.close();
    }

    // Get all items in the cart for a user
    public Cursor getCartItems(String username) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM cart WHERE username=?", new String[]{username});
    }

    // Clear the entire cart for a user
    public void clearCart(String username) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("cart", "username=?", new String[]{username});
        db.close();
    }

    // Get cart data for a specific user and order type
    public ArrayList<String> getCartData(String username, String otype) {
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] args = {username, otype};
        Cursor c = db.rawQuery("SELECT product, price FROM cart WHERE username = ? AND otype = ?", args);
        if (c.moveToFirst()) {
            do {
                String product = c.getString(0);
                String price = c.getString(1);
                arr.add(product + " $" + price);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arr;
    }

    // Add an order to the database
    public void addOrder(String username, String fullname, String packageName, float price, String address, String contactno, int pincode, String date, String time, float amount, String otype) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("fullname", fullname);
        cv.put("package", packageName); // Added package
        cv.put("price", price);         // Added price
        cv.put("address", address);
        cv.put("contactno", contactno);
        cv.put("pincode", pincode);
        cv.put("date", date);
        cv.put("time", time);
        cv.put("amount", amount);
        cv.put("otype", otype);
        db.insert("orderplace", null, cv);
        db.close();
    }

    // Get order data with name, package, and price
    public ArrayList<String> getOrderData(String username) {
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] args = {username};
        Cursor c = db.rawQuery("SELECT fullname, package, price, address, contactno, pincode, date, time, amount FROM orderplace WHERE username = ?", args);

        if (c.moveToFirst()) {
            do {
                // Format: FullName$Package$Price$Address$Contact$Pincode$Date$Time
                arr.add(c.getString(0) + "$" + c.getString(1) + "$" + c.getFloat(2) + "$" + c.getString(3) + "$" + c.getString(4) + "$" + c.getInt(5) + "$" + c.getString(6) + "$" + c.getString(7));
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arr;
    }
}
