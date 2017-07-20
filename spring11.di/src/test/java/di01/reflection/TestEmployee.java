package di01.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import di00.model.Employee;

public class TestEmployee {
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testMakeInstanceWithNew() {
        Employee emp1 = new Employee();
        emp1.setFirstname("aaa");
        emp1.setLastname("bbb");
        emp1.setSalary(1000);
        assertSame(emp1.getFirstname(), "aaa");
        
        Employee emp2 = new Employee("aaa", "bbb", 1000);
        assertSame(emp2.getFirstname(), "aaa");
        
    }
    @Test
    public void testMakeInstanceWithReflection() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // new 다음 부분 만드는 4줄
        Class klass = Class.forName("di00.model.Employee");
        Class[] paramTypes = {String.class, String.class, Integer.TYPE};
        
        Constructor cons = klass.getConstructor(paramTypes);
        Object[] objs = {"aaa", "bbb", 1000};
        
        // new 부분
        Object instance = cons.newInstance(objs);
        System.out.println(instance.toString());
        
        // setter 를 이용한 필드 사용
        // 메서드 지정
        Method m = null;
        m = klass.getMethod("setFirstname", String.class);
        // 메서드 호출
        Object[] params = {"hello"};
        m.invoke(instance, params);
        
        System.out.println(instance.toString());
        
        // getter 를 이용한 가져오기
        // 메서드 지정
        m = klass.getMethod("getFirstname");
        Object result = m.invoke(instance);
        
        System.out.println(result);
        assertEquals("hello", result);
    }
}
