package dao.impl;

import com.world.domain.Items;
import dao.ItemsDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsDatImpl implements ItemsDao {
    @Override
    public List<Items> findAll() throws Exception{
        List<Items> list=new ArrayList<Items>();
        Connection connection=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql:///db1","root","root");
            pst=connection.prepareCall("select * from student");
            rs = pst.executeQuery();
            while (rs.next()) {
                Items items=new Items();
                items.setId(rs.getInt("id"));
                items.setName(rs.getString("name"));
                list.add(items);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
            pst.close();
            rs.close();
        }
        return list;
    }
}
