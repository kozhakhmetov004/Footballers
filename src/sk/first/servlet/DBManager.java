package sk.first.servlet;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {

    private static Connection connection;

    static {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/footballers?useUnicode=true&serverTimezone=UTC","root","");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean AddFootballer(Footballer footballer){

        int rows = 0;
        try{ PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO footballers(id,name,surname,salary,club,transfer_price, born_city_id) " +
                    "VALUES (null,?,?,?,?,?,?)");
            statement.setString(1,footballer.getName());
            statement.setString(2,footballer.getSurname());
            statement.setInt(3,footballer.getSalary());
            statement.setString(4,footballer.getClub());
            statement.setInt(5,footballer.getTransferPrice());
            statement.setInt(6,footballer.getBorn_city().getId());
            rows=statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public  static ArrayList<Footballer> getFootballers(){

        ArrayList<Footballer> footballers = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT fb.id, fb.name,fb.surname, fb.salary, fb.club, fb.transfer_price, fb.born_city_id, bc.name as bornCityName, bc.country_code " +
                    "FROM footballers fb " +
                    "INNER JOIN born_cities bc on fb.born_city_id = bc.id " +
                    "ORDER BY fb.salary DESC ");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                footballers.add(new Footballer(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("salary"),
                        resultSet.getString("club"),
                        resultSet.getInt("transfer_price"),
                        new Born_cities(
                                resultSet.getInt("born_city_id"),
                                resultSet.getString("bornCityName"),
                                resultSet.getString("country_code")

                        )
                )); }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return footballers;
    }

    public static Footballer getFootballer(Long id){
        Footballer footballer = null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT fb.id, fb.name,fb.surname, fb.salary, fb.club, fb.transfer_price, fb.born_city_id, bc.name as bornCityName, bc.country_code "+
                    "FROM footballers fb " +
                    "INNER JOIN born_cities bc on fb.born_city_id = bc.id " +
                    "WHERE fb.id = ?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                footballer = (new Footballer(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("salary"),
                        resultSet.getString("club"),
                        resultSet.getInt("transfer_price"),
                        new Born_cities(
                                resultSet.getInt("born_city_id"),
                                resultSet.getString("bornCityName"),
                                resultSet.getString("country_code")

                        )
                )); }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }return footballer;
    }
    public void deleteFootballer(Long id){
    }
    public static boolean EditFootballer(Footballer footballer){
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE footballers SET name=?, surname=?, salary=?, club=?, transfer_price=?, born_city_id=? WHERE id=?");
            statement.setString(1,footballer.getName());
            statement.setString(2,footballer.getSurname());
            statement.setInt(3,footballer.getSalary());
            statement.setString(4,footballer.getClub());
            statement.setInt(5,footballer.getTransferPrice());
            statement.setInt(6,footballer.getBorn_city().getId());
            statement.setLong(7,footballer.getId());
            rows=statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace(); }
        return rows>0;
    }
    public static boolean DeleteFootballer(Footballer footballer){
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM footballers WHERE id=?");
            statement.setLong(1,footballer.getId());
            rows=statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace(); }
        return rows>0;
    }
    public  static ArrayList<Born_cities> getBornCities(){

        ArrayList<Born_cities> born_cities = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM born_cities");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                born_cities.add(new Born_cities(

                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("country_code")

                ));

            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return born_cities;
    }

    public  static Born_cities getBornCity(int id){

        Born_cities born_cities = null;

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM born_cities " +
                    "WHERE id=?");
            statement.setInt(1,id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {

                born_cities=(new Born_cities(

                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("country_code")

                ));

            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return born_cities;
    }

    public  static AuthUsers getUser(String email){

        AuthUsers user = null;

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email=?");
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                user = new AuthUsers(
                  resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name")
                );

                 }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static boolean AddUser(AuthUsers authUsers){

        int rows = 0;
        try{ PreparedStatement statement = connection.prepareStatement("" +
                "INSERT INTO users(id,email,password,full_name) " +
                "VALUES (null,?,?,?)");
            statement.setString(1,authUsers.getEmail());
            statement.setString(2,authUsers.getPassword());
            statement.setString(3,authUsers.getFullName());
            rows=statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static boolean addBlog(Blogs blog){
        int rows =0;

        try{

            PreparedStatement statement = connection.prepareStatement("INSERT INTO blogs(user_id,title,short_content,content,post_date) " +
                    "VALUES (?,?,?,?,CURRENT_TIMESTAMP )");
            statement.setLong(1,blog.getUser().getId());
            statement.setString(2,blog.getTitle());
            statement.setString(3,blog.getShortContent());
            statement.setString(4,blog.getContent());

            rows =statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static ArrayList<Blogs> getAllBlogs() {
        ArrayList<Blogs> blogs = new ArrayList<>();
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT b.id,b.title,b.short_content , b.post_date , u.id ,b.user_id, u.full_name " +
                    "FROM blogs b " +
                    "INNER JOIN users u on b.user_id =u.id " +
                    "ORDER BY b.post_date DESC");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                blogs.add(new Blogs(
                        resultSet.getLong("id"),
                        new AuthUsers(
                                resultSet.getLong("user_id"),
                                null, null,
                                resultSet.getString("full_name")
                        ),
                        resultSet.getString("title"),
                        resultSet.getString("short_content"),
                        null,
                        resultSet.getDate("post_date")
                        )
                );

            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return blogs;
    }
    public static Blogs getBlog(Long id) {
         Blogs blog = null;
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT b.id,b.title,b.short_content,b.content , b.post_date , u.id ,b.user_id, u.full_name " +
                    "FROM blogs b " +
                    "INNER JOIN users u on b.user_id =u.id " +
                    "WHERE b.id=?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                blog=(new Blogs(
                                resultSet.getLong("id"),
                                new AuthUsers(
                                        resultSet.getLong("user_id"),
                                        null, null,
                                        resultSet.getString("full_name")
                                ),
                                resultSet.getString("title"),
                                resultSet.getString("short_content"),
                                resultSet.getString("content"),
                                resultSet.getDate("post_date")
                        )
                );

            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return blog;
    }
    }

