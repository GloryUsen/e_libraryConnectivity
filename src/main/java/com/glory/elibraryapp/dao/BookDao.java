package com.glory.elibraryapp.dao;

import com.glory.elibraryapp.beans.BookBean;
import com.glory.elibraryapp.beans.IssueBookBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookDao {

    public static int save(BookBean beans){
        int status = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = Provider.getPostgresConnection();
            PreparedStatement ps = con.prepareStatement("insert into E book values(?,?,?,?,?,?)");
            ps.setString(1, beans.getCallNo());
            ps.setString(2, beans.getAuthor());
            ps.setString(3, beans.getName());
            ps.setString(4, beans.getPublish());
            ps.setInt(5, beans.getIssued());
            ps.setInt(6, beans.getQuantity());

            status = ps.executeUpdate();
            con.close();

        } catch (Exception e1) {
            System.out.println(e1);

        }
        return status;
    }

    public static List<BookBean> view(){

        List<BookBean> list = new ArrayList<>();
        try {
            Connection conny = Provider.getPostgresConnection();
            PreparedStatement state = conny.prepareStatement("select * from E book");
            ResultSet set = state.executeQuery();

            while (set.next()){
                BookBean bean = new BookBean();
                bean.setCallNo(set.getString("callNo"));
                bean.setName(set.getString("name"));
                bean.setAuthor(set.getString("author"));
                bean.setPublish(set.getString("publish"));
                bean.setQuantity(set.getInt("Quantity"));
                bean.setIssued(set.getInt("issued"));

                list.add(bean);
            }

            conny.close();
        } catch (Exception beanCatching) {
            System.out.println(beanCatching);

        }
        return list;
    }

    public static int delete(String callNo){

        int status = 0;
        try {
            Connection connect = Provider.getPostgresConnection();
            PreparedStatement prep = connect.prepareStatement("delete from ebook where callNo=?");
            prep.setString(1, callNo);
            status = prep.executeUpdate();
            connect.close();

        } catch (Exception deletingData) {
            System.out.println(deletingData);
        }

        return status;
    }

    public static int getIssued(String callNo){
        int issued = 0;
        try {
            Connection comic = Provider.getPostgresConnection();
            PreparedStatement peer = comic.prepareStatement("select * from ebook where callNo = ?");
            peer.setString(1, callNo);
            ResultSet resting = peer.executeQuery();
            if (resting.next()){
                issued = resting.getInt("issued");
            }
            comic.close();
        } catch (SQLException getIssues) {
            System.out.println(getIssues);


        }


        return issued;
    }

    public static boolean checkIssue(String callNo){
        boolean status2 = false;
        try {
            Connection connection = Provider.getPostgresConnection();
            PreparedStatement steps = connection.prepareStatement("select * from ebook where callNo=?" +
                    "and quantity>issued");
            steps.setString(1, callNo);
            ResultSet set = steps.executeQuery();
            if (set.next()){
                status2 = true;
            }

            connection.close();
        } catch (SQLException checking) {
            System.out.println(checking);

        }
        return status2;
    }

    public static int issueBook(IssueBookBean issue){
        String callNo = issue.getCallNo();
        boolean checkStatus = checkIssue(callNo);
        System.out.println("Check status: " + checkStatus);
        if (checkStatus){
            int status3 = 0;
            try {
                Connection con = Provider.getPostgresConnection();
                PreparedStatement prepare = con.prepareStatement("insert into eissuebook values(?,?,?,?,?,?)");
                prepare.setString(1, issue.getCallNo());
                prepare.setString(2, issue.getStudentId());
                prepare.setString(3, issue.getStudentName());
                prepare.setLong(4, issue.getStudentMobile());
                prepare.setString(5, "no");
                java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
                prepare.setDate(6, currentDate);

                status3 = prepare.executeUpdate();
                if (status3 > 0);
                PreparedStatement prepare2 = con.prepareStatement("update  ebook set issued = ? where callNo=?");
                prepare2.setInt(1, getIssued(callNo) +1);
                prepare2.setString(2, callNo);
                status3 = prepare2.executeUpdate();

                con.close();
            } catch (Exception e) {
                System.out.println(e);

            }
        }

        return 0;
    }

    public static int returnBook(String callNo, int studentId){
        int status4 = 0;
        try {
            Connection connecting = Provider.getPostgresConnection();
            PreparedStatement prep = connecting.prepareStatement("update eissuebook set returnstatus='Yes' where callNo=? and studentId=?");
            prep.setString(1, callNo);
            prep.setInt(2, studentId);

            status4 = prep.executeUpdate();

            connecting.close();

        } catch (Exception returning) {
            System.out.println(returning);

        }

        return status4;
    }

    public static List<IssueBookBean> viewIssuedBook(){
        List<IssueBookBean> list = new ArrayList<>();

        try {
            Connection con = Provider.getPostgresConnection();
            PreparedStatement stage = con.prepareStatement("select * from eissuebook order by issuedDate desc ");
            ResultSet rs = stage.executeQuery();
            while (rs.next()){
                IssueBookBean bean = new IssueBookBean();
                bean.setCallNo(rs.getString("callNo"));
                bean.setStudentId(rs.getString("studentId"));
                bean.setStudentName(rs.getString("studentName"));
                bean.setStudentMobile(rs.getLong("issuedMobile"));
                bean.setIssuedDate(rs.getDate("issuedDate"));
                bean.setReturnsStatus(rs.getString("returnStatus"));

                list.add(bean);
            }

            con.close();
        } catch (Exception viewBook) {
            System.out.println(viewBook);

        }
        return list;
    }
}
