package JDBCDemo;

import java.sql.*;

/**
 * @author Lucas
 * @date 2019/7/22 16:23
 */
public class ConcurrentReduce2 {
    public static void main(String[] args) {
        new Thread("p1"){
            @Override
            public void run() {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.186.128:3306/tdf?useSSL=false&serverTimezone=UTC", "root", "55990410");
                    Statement statement = connection.createStatement();
                    connection.setAutoCommit(false);
                    // select默认不加锁
                    /*ResultSet rs = statement.executeQuery("select age from student where name = 'lucas' for update");
                    int age = 0;
                    while (rs.next()){
                        age = rs.getInt("age");
                    }
                    rs.close();
                    System.out.println(Thread.currentThread().getName() + "age = " + age);
                    if (age>=20){
                        statement.execute("update student set age = " + (age-20) + " where name = 'lucas'");
                        System.out.println(Thread.currentThread().getName() + " updated it");
                        connection.commit();
                    }
                    else {
                        System.out.println("not enough!");
                        connection.rollback();
                    }*/
                    // 增删改默认加锁
                    statement.execute("update student set age = (age-20) where name = 'lucas'");
                    Thread.sleep(1000);
                    connection.commit();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread("p2"){
            @Override
            public void run() {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.186.128:3306/tdf?useSSL=false&serverTimezone=UTC", "root", "55990410");
                    Statement statement = connection.createStatement();
                    connection.setAutoCommit(false);
                    /*ResultSet rs = statement.executeQuery("select age from student where name = 'lucas' for update");
                    int age = 0;
                    while (rs.next()){
                        age = rs.getInt("age");
                    }
                    rs.close();
                    System.out.println(Thread.currentThread().getName() + "age = " + age);
                    if (age>=20){
                        statement.execute("update student set age = " + (age-30) + " where name = 'lucas'");
                        System.out.println(Thread.currentThread().getName() + " updated it");
                        connection.commit();
                    }
                    else {
                        System.out.println("not enough!");
                        connection.rollback();
                    }*/
                    statement.execute("update student set age = (age-30) where name = 'lucas'");
                    Thread.sleep(1000);
                    connection.commit();
                }
                //回滚一般写在catch块中
                catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    //connection.commit();
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
