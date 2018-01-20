import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Demo {

    @Test
    public void save() throws Exception {
        Student student = new Student();
        student.setAge(18);
        student.setName("will");
        SqlSession session = MySQLSessionUtil.getSqlSession();
        session.insert("StudentMapper.insertStudent", student);
        session.commit();
        session.close();
    }


    public void testSelect() throws Exception {
        int id = 1;
        SqlSession session = MySQLSessionUtil.getSqlSession();
        Student stu = session.selectOne("StudentMapper.selectStudent", id);
        System.out.println(stu);
        session.commit();
        session.close();
    }


    @Test
    public void testUpdate() {
        SqlSession session = MySQLSessionUtil.getSqlSession();
        Student stu = new Student(1, "king", 23);
        System.out.println(stu);
        session.update("StudentMapper.updateStudent", stu);

    }

    @Test
    public void testListAll() {
        SqlSession session = MySQLSessionUtil.getSqlSession();

        List<Student> lsit = session.selectList("StudentMapper.ListAllStudent");
        for (Student stu : lsit) {
            System.out.println(stu);
        }
        session.commit();
        session.close();
    }
}
