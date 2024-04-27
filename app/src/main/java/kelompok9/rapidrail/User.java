package kelompok9.rapidrail;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
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

    private static final String jsonFilePath = "app/src/main/java/kelompok9/rapidrail/users.json";
    private static List<User> userList = new ArrayList<>();
    private static int registrationCount = 0; 

    public static boolean registerUser(String username, String password, String name, String address, String phoneNumber) {
        if (registrationCount > 3) {
            System.out.println("Batas registrasi telah tercapai. Tidak dapat melakukan registrasi lagi.");
            return false;
        }

        JSONArray jsonArray;
        if (Files.exists(Paths.get(jsonFilePath))) {
            try {
                String jsonString = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
                jsonArray = new JSONArray(jsonString);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject userJson = jsonArray.getJSONObject(i);
                    if (userJson.getString("username").equals(username)) {
                        return false;
                    }
                }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            jsonArray = new JSONArray();
        }

        JSONObject newUserJson = new JSONObject();
        newUserJson.put("username", username);
        newUserJson.put("password", password);
        newUserJson.put("name", name);
        newUserJson.put("address", address);
        newUserJson.put("phoneNumber", phoneNumber);

        jsonArray.put(newUserJson);

        try (FileWriter fileWriter = new FileWriter(jsonFilePath)) {
            fileWriter.write(jsonArray.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        User newUser = new User(username, password, name, address, phoneNumber);
        userList.add(newUser);

        registrationCount++;
        return true;
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

    private static void saveUsersToJson() {
        JSONArray jsonArray = new JSONArray();
        for (User user : userList) {
            JSONObject userJson = new JSONObject();
            userJson.put("username", user.getUsername());
            userJson.put("password", user.getPassword());
            userJson.put("name", user.getName());
            userJson.put("address", user.getAddress());
            userJson.put("phoneNumber", user.getPhoneNumber());
            jsonArray.put(userJson);
        }

        try (FileWriter fileWriter = new FileWriter(jsonFilePath)) {
            fileWriter.write(jsonArray.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
