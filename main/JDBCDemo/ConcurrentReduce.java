package JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Lucas
 * @date 2019/7/17 17:42
 */
public class ConcurrentReduce {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run(){
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.186.128:3306/tdf?useSSL=false&serverTimezone=UTC", "root", "55990410");
                        Statement statement = connection.createStatement();
                        connection.setAutoCommit(false);
                        // 在select期间不允许别人修改该条记录
                        ResultSet rs = statement.executeQuery("select age from student where name = 'lucas' for update");
                        int age = 0;
                        while (rs.next()){
                            age = rs.getInt("age");
                        }
                        rs.close();
                        if (age>=20){
                            statement.execute("update student set age = " + (age-20) + " where name = 'lucas'");
                            System.out.println(Thread.currentThread().getName() + " updated it");
                            connection.commit();
                        }
                        else {
                            System.out.println("not enough!");
                            connection.rollback();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
