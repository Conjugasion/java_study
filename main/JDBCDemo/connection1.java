package JDBCDemo;

import java.sql.*;

/**
 * @author Lucas
 * @date 2019/7/17 17:07
 * 默认事务等级可重复读
 *  MVCC
 */
public class connection1 {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.186.128:3306/tdf?useSSL=false&serverTimezone=UTC", "root", "55990410");
                    Statement statement = connection.createStatement();
                    connection.setAutoCommit(false);
                    String sql1 = "select * from student";
                    for (int i = 0; i < 7; i++) {
                        Thread.sleep(500);
                        ResultSet rs = statement.executeQuery(sql1);
                        while (rs.next()){
                            int id = rs.getInt("id");
                            String name = rs.getString("name");
                            int age = rs.getInt("age");
                            System.out.println(id + "," + name + "," + age);
                            System.out.println("-------------");
                        }
                    }
                    connection.commit();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(1000);
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.186.128:3306/tdf?useSSL=false&serverTimezone=UTC", "root", "55990410");
                    connection.setAutoCommit(false);
                    Statement statement = connection.createStatement();
                    String sql1 = "update student set name = 'leo' where id = 2";
                    statement.execute(sql1);
                    connection.commit();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
