package kelompok9.rapidrail;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import javafx.scene.control.Alert;

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

    String filePath = "D:/Semester 2/PBO/Praktikum/TubesPBO/app/account.json";
    private static List<User> userList = new ArrayList<>();

    public static void loadUsersFromJson(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            JSONArray userArray = new JSONArray(new JSONTokener(reader));
            for (Object obj : userArray) {
                JSONObject userData = (JSONObject) obj;
                String username = userData.getString("username");
                String password = userData.getString("password");
                String name = userData.getString("name");
                String address = userData.getString("address");
                String phoneNumber = userData.getString("phoneNumber");

                User user = new User(username, password, name, address, phoneNumber);
                userList.add(user);
            }
        } catch (IOException | JSONException e) {
            System.err.println("Error loading user data: " + e.getMessage());
        }
    }
    public static void registerUser(String username, String password, String name, String address, String phoneNumber) {
        if (isUsernameTaken(username)) {
            Alert usIsTaken = new Alert(Alert.AlertType.ERROR);
            usIsTaken.setTitle("Error");
            usIsTaken.setHeaderText(null);
            usIsTaken.setContentText("Password harus minimal 8 karakter");
            usIsTaken.showAndWait();
            return;
        } else {
            User newUser = new User(username, password, name, address, phoneNumber);
            userList.add(newUser);
            saveUsersToJson();
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Registrasi Berhasil");
            success.setHeaderText(null);
            success.setContentText("Registrasi berhasil untuk pengguna: " + username);
            success.showAndWait();
        }
    }
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
            file.write(userArray.toString(4));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static boolean isUsernameTaken(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    public static boolean loginUser(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login berhasil.");
                return true;
            }
        }
        Alert uorpWrong = new Alert(Alert.AlertType.ERROR);
        uorpWrong.setTitle("Error");
        uorpWrong.setHeaderText(null);
        uorpWrong.setContentText("Incorrect username or password");
        uorpWrong.showAndWait();
        return false;
    }

    public static boolean deleteUser(String usernameToDelete) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUsername().equals(usernameToDelete)) {
                iterator.remove();
                Alert delsuc = new Alert(Alert.AlertType.ERROR);
                delsuc.setTitle("Error");
                delsuc.setHeaderText(null);
                delsuc.setContentText("Account Delete Succesfully");
                delsuc.showAndWait();
                saveUsersToJson();
                return true;
            } else {
                Alert undel = new Alert(Alert.AlertType.ERROR);
                undel.setTitle("Error");
                undel.setHeaderText(null);
                undel.setContentText("Username not Found!");
                undel.showAndWait();
                return true;}
            }
        return false;
    }

    
    }

