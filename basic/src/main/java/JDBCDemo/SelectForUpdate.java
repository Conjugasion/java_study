package JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Lucas
 * @date 2019/7/18 11:11
 * 我执行select status from t_goods where id=1 for update;后。我在另外的事务中如果再次执行
 * select status from t_goods where id=1 for update;则第二个事务会一直等待第一个事务的提交，此时第二个查询处于阻塞的状态，
 * 但是如果我是在第二个事务中执行select status from t_goods where id=1;则能正常查询出数据，不会受第一个事务的影响。
 */
public class SelectForUpdate {
    public static void main(String[] args) {
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
                    //Thread.sleep(1000);
                    int age = 0;
                    while (rs.next()){
                        age = rs.getInt("age");
                    }
                    rs.close();
                    if (age>=20){
                        statement.execute("update student set age = " + (age-20) + " where name = 'lucas'");
                        System.out.println(Thread.currentThread().getName() + " updated it");
                        Thread.sleep(1000);
                        connection.commit();
                    }
                    else {
                        System.out.println("not enough!");
                        connection.rollback();
                    }
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
                    Thread.sleep(500);
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.186.128:3306/tdf?useSSL=false&serverTimezone=UTC", "root", "55990410");
                    Statement statement = connection.createStatement();
                    connection.setAutoCommit(false);
                    ResultSet rs = statement.executeQuery("select age from student where name = 'lucas'");
                    int age = 0;
                    while (rs.next()){
                        age = rs.getInt("age");
                        System.out.println("当前余额：" + age);
                    }
                    rs.close();
                    connection.commit();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
