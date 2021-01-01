package DB;

import java.sql.*;

public class JDBC {

    static Connection conn;
    static Statement statement;
    static ResultSet resultSet;

    public JDBC() {
        try {
            //加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动加载成功");//jdbc:mysql://localhost:3306/library?characterEncoding=utf8&useSSL=false
            //连接数据库jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&serverTimezone=UTC
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sportsmeeting?characterEncoding=utf-8&serverTimezone=UTC", "root", "root");
            System.out.println("数据库连接成功");

            //2.创建statement类对象，用来执行SQL语句！！
            statement = conn.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet sql(String str) throws SQLException {
        resultSet = statement.executeQuery(str);
        System.out.println(str);
        return resultSet;
    }


    public static ResultSet sql1(String str) {

        try {
            //加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动加载成功");//jdbc:mysql://localhost:3306/library?characterEncoding=utf8&useSSL=false
            //连接数据库jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&serverTimezone=UTC
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?characterEncoding=utf-8&serverTimezone=UTC", "root", "root");
            System.out.println("数据库连接成功");

            //2.创建statement类对象，用来执行SQL语句！！
            statement = conn.createStatement();

            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet resultSet = statement.executeQuery(str);
            String sId;
            String sName;
            String sSex;
            int sAge;
            String sProgress;
            String sGrade;
            String sIntegrity;

            while (resultSet.next()) {

                sId = resultSet.getString("s_id");
                sName = resultSet.getString("s_name");

                //输出结果
                System.out.println(sId + "\t" + sName);
            }

            return resultSet;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;

    }




    public void update1(){
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");

            String url="jdbc:mysql://localhost/test?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url,    "root","******");//url 账号 密码
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库！");

            //查询数据的代码
            String sql = "select * from stu";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            System.out.println("原始数据： \n " + "编号"+"\t"+"姓名"+"\t"+"年龄");
            while (rs.next()){
                System.out.print(rs.getInt(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getInt(3) + "\t");
                System.out.println();
            }

            //增加数据
            String sql1 = "insert into stu (id,name,age) values(?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql1);
            pst.setInt(1,4);
            pst.setString(2,"sunlu");
            pst.setInt(3, 25);
            pst.executeUpdate();
            ResultSet rs1 = stmt.executeQuery(sql);//创建数据对象
            System.out.println("插入后数据：  \n" + "编号"+"\t"+"姓名"+"\t"+"年龄");
            while (rs1.next()){
                System.out.print(rs1.getInt(1) + "\t");
                System.out.print(rs1.getString(2) + "\t");
                System.out.print(rs1.getInt(3) + "\t");
                System.out.println();
            }

            //修改数据的代码
            String sql2 = "update stu set name=? where id=?";
            pst = conn.prepareStatement(sql2);
            pst.setString(1,"nick");
            pst.setInt(2,1);
            pst.executeUpdate();

            ResultSet rs3 = stmt.executeQuery(sql2);//创建数据对象
            System.out.println("修改后数据：  \n" + "编号"+"\t"+"姓名"+"\t"+"年龄");
            while (rs3.next()){
                System.out.print(rs3.getInt(1) + "\t");
                System.out.print(rs3.getString(2) + "\t");
                System.out.print(rs3.getInt(3) + "\t");
                System.out.println();
            }
            //删除数据的代码
            String sql3 = "delete from stu where id=?";
            pst = conn.prepareStatement(sql3);
            pst.setInt(1,1);
            pst.executeUpdate();

            ResultSet rs2 = stmt.executeQuery(sql);//创建数据对象
            System.out.println("删除后数据：   \n" + "编号"+"\t"+"姓名"+"\t"+"年龄");
            while (rs2.next()){
                System.out.print(rs2.getInt(1) + "\t");
                System.out.print(rs2.getString(2) + "\t");
                System.out.print(rs2.getInt(3) + "\t");
                System.out.println();
            }

            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}
