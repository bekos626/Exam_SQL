import java.sql.*;
import java.util.Scanner;

public class Connect {
    Scanner sc = new Scanner(System.in);
    private final String url = "jdbc:postgresql://localhost:5432/study_database";
    private final String user = "postgres";
    private final String password = "0000";

    public Connection connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

//    public void insertNews() {
//        String SQLInsertNews = "INSERT INTO \"news\".news (header, text) VALUES (?, ?)";
//        try {
//            PreparedStatement preparedStatement = connection().prepareStatement(SQLInsertNews);
//            System.out.println("Write headline please");
//            preparedStatement.setString(1, );
//            System.out.println("Write text of the news");
//            String text = sc.nextLine();
//            preparedStatement.setString(2, text);
//            preparedStatement.executeUpdate();
//        } catch (Exception throwable) {
//            throwable.printStackTrace();
//        }
//    }

    public void addNews(News news) {
        String add = "INSERT INTO \"news\".news (header, text) VALUES (?, ?)";
        try (Connection conn = connection();
             PreparedStatement statement = conn.prepareStatement(add)) {
            statement.setString(1, news.getHeader());
            statement.setString(2, news.getText());
            statement.executeUpdate();
            ResultSet rs = statement.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectNews() {
        String select = "SELECT header, text from \"news\".news";
        try (Connection conn = connection();
             Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(select);
            while (rs.next()) {
                System.out.println(rs.getString("header") + " " + rs.getString("text"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNews(News news) {
        String delete = "delete from \"news\".news where id = ?";
        try (Connection conn = connection();
             PreparedStatement preparedStatement = conn.prepareStatement(delete)) {
            preparedStatement.setInt(1, news.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeNews(News news) {
        String change = "UPDATE \"news\".news SET header = ?, text = ? where id = ?";
        try (Connection conn = connection();
             PreparedStatement preparedStatement = conn.prepareStatement(change)) {
            preparedStatement.setString(1, news.getHeader());
            preparedStatement.setString(2, news.getText());
            preparedStatement.setInt(3, news.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
