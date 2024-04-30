package kelompok9.rapidrail;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class User {
    String username;
    String password;
    String name;
    String address;
    String phoneNumber;

    User(String username, String password, String name, String address, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    String filePath = "app/src/main/resources/account.json";
    private static List<User> userList = new ArrayList<>();

    
    // Metode untuk menambahkan pengguna baru ke dalam list
    public static void registerUser(String username, String password, String name, String address, String phoneNumber) {
        if (isUsernameTaken(username)) {
            System.out.println("Gagal mendaftar. Username sudah digunakan.");
            return;
        }

        User newUser = new User(username, password, name, address, phoneNumber);
        userList.add(newUser);
        saveUsersToJson(); // Simpan pengguna ke dalam file JSON setiap kali ada perubahan
        System.out.println("Registrasi berhasil untuk akun " + username);
    }


    // Metode untuk menyimpan data pengguna ke dalam file JSON
    public static void saveUsersToJson() {
        JSONArray userArray = new JSONArray();

        for (User user : userList) {
            JSONObject userData = new JSONObject();
            userData.put("username", user.getUsername());
            userData.put("password", user.getPassword());
            userData.put("name", user.getName());
            userData.put("address", user.getAddress());
            userData.put("phoneNumber", user.getPhoneNumber());

            userArray.put(userData);
        }
        
        try (FileWriter file = new FileWriter("account.json")) {
            // Mengatur opsi indentasi untuk JSON agar lebih terstruktur
            file.write(userArray.toString(4)); // Angka 4 menunjukkan jumlah spasi indentasi

            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
    private static boolean isUsernameTaken(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true; // Username sudah digunakan
            }
        }
        return false; // Username tersedia
    }
    public static boolean loginUser(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login berhasil.");
                return true;
            }
        }
        System.out.println("Username atau password salah.");
        return false;
    }

    public static boolean deleteUser(String username) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUsername().equals(username)) {
                iterator.remove();
                System.out.println("Akun " + username + " berhasil dihapus.");
                saveUsersToJson();
                return true;
            }
        }
        System.out.println("Akun " + username + " tidak ditemukan.");
        return false;
    }

    
    }

