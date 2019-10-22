package com.kh.member.model.dao;

<<<<<<< HEAD
public class MemberDao {

	

=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
<<<<<<< HEAD

=======
import com.kh.member.model.vo.Member;
>>>>>>> ee340be8a12028d82746491911757d9be61f64d7
import com.kh.member.model.vo.MemberPage;
import com.kh.member.model.vo.Profile;

public class MemberDao {

	public ArrayList<MemberPage> rankingView(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MemberPage> list = new ArrayList<MemberPage>();
		String query = "select * from (select * from member join profile using(member_id) order by heart desc) where rownum <= 12";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Profile p = new Profile();
				p.setId(rset.getString("member_id"));
				p.setBlood(rset.getString("blood"));
				p.setCity(rset.getString("city"));
				p.setHeart(rset.getInt("heart"));
				p.setHeight(rset.getInt("height"));
				p.setHobby(rset.getString("hobby"));
				p.setIntro(rset.getString("intro"));
				p.setJob(rset.getString("profile_job"));
				p.setReligion(rset.getString("religion"));
				p.setSmoke(rset.getString("smoke"));
				MemberPage mp = new MemberPage();
				mp.setProfile(p);
				mp.setAge(rset.getInt("age"));
				mp.setPhoto(rset.getString("photopath"));
				mp.setHeart(rset.getInt("heart"));
				list.add(mp);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}return list;
	}

	public ArrayList<MemberPage> randomView(Connection conn, int[] lotto) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MemberPage> list = new ArrayList<MemberPage>();
		String query = "select * from (select rownum rn,n.* from (select * from member join profile using(member_id)) n ) where rn in(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			for(int i=0;i<12;i++) {
				pstmt.setInt(i+1, lotto[i]);
			}
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Profile p = new Profile();
				p.setId(rset.getString("member_id"));
				p.setBlood(rset.getString("blood"));
				p.setCity(rset.getString("city"));
				p.setHeart(rset.getInt("heart"));
				p.setHeight(rset.getInt("height"));
				p.setHobby(rset.getString("hobby"));
				p.setIntro(rset.getString("intro"));
				p.setJob(rset.getString("profile_job"));
				p.setReligion(rset.getString("religion"));
				p.setSmoke(rset.getString("smoke"));
				MemberPage mp = new MemberPage();
				mp.setProfile(p);
				mp.setAge(rset.getInt("age"));
				mp.setPhoto(rset.getString("photopath"));
				mp.setHeart(rset.getInt("heart"));
				list.add(mp);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}return list;
		
	}
	public int heart() {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into heart values(?,?,sysdate)";
		String query = "UPDATE PROFILE SET HEART = (heart)+?  WHERE MEMBER_ID = '?'";
	}

	public int insertHeart(Connection conn, String toId, String fromId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into heart values(?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, toId);
			pstmt.setString(2, fromId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}return result;
		
	}

	
	
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, 'standard', sysdate, ?, 0, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			//Member m = new Member(id, pw, name, birth, gender, phone, email, city, "standard", null, 0, 0, null, photoname);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setString(3, m.getName());
			pstmt.setDate(4, m.getBirth());
			pstmt.setString(5, m.getGender());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getEmail());
			pstmt.setString(8, m.getCity());
			pstmt.setInt(9, m.getAge());
			pstmt.setString(10, m.getPhotopath());
			pstmt.setString(11, m.getPhotoname());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	
	}

	public Member selectOne(Connection conn, String id) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m.setId(rset.getString("id"));
				m.setPw(rset.getString("pw"));
				m.setName(rset.getString("name"));
				m.setBirth(rset.getDate("birth"));
				m.setGender(rset.getString("gender"));
				m.setPhone(rset.getString("phone"));
				m.setEmail(rset.getString("email"));
				m.setCity(rset.getString("city"));
				m.setGrade(rset.getString("grade"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setAge(rset.getInt("age"));
				m.setBlockCount(rset.getInt("block_count"));
				m.setPhotopath(rset.getString("photopath"));
				m.setPhotoname(rset.getString("photoname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public int selectEmail(Connection conn, String emailAddr) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select * from member where email = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, emailAddr);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = 1;
			}else {
				result = 0;
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
			
	}

	public Member login(Connection conn, String id, String pw) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where id = ? and pw = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m.setId(rset.getString("id"));
				m.setPw(rset.getString("pw"));
				m.setName(rset.getString("name"));
				m.setBirth(rset.getDate("birth"));
				m.setGender(rset.getString("gender"));
				m.setPhone(rset.getString("phone"));
				m.setEmail(rset.getString("email"));
				m.setCity(rset.getString("city"));
				m.setGrade(rset.getString("grade"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setAge(rset.getInt("age"));
				m.setBlockCount(rset.getInt("block_count"));
				m.setPhotopath(rset.getString("photopath"));
				m.setPhotoname(rset.getString("photoname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public int delete(Connection conn, String id) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from member where id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);;
			result = pstmt.executeUpdate();
			System.out.println("삭제 "+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
>>>>>>> d2ea2537b9be55e62062b94e1074354f41cb6858
}
