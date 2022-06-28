package com.example.test1.test;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author yangshengwei_zidie
 * @description 从dataphin-oa迁移过来的代码
 * @date 2022-02-28-4:04 PM
 */
@SpringBootTest
@Slf4j
public class JsonTest {


    @Test
    public void test111() throws InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,
                10,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new ThreadFactoryBuilder()
                        .setNameFormat("Test-YSW-Thread-Pool-%d")
                        .build());

        executor.execute(  new Runnable(){
            @Override
            public void run() {
                Map<String, String> context = MDC.getCopyOfContextMap();
                if (context != null) {
                    MDC.setContextMap(context);
                }

                try {
                    while(true) {
                        log.info("Runnable:{}",Thread.currentThread());
                        try {
                            TimeUnit.SECONDS.sleep(1L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    MDC.clear();
                }
            }
        });

        while (true) {
            log.info("12345");
            log.info("main:{}",Thread.currentThread());
            TimeUnit.SECONDS.sleep(1L);
            Map<String, String> context = MDC.getCopyOfContextMap();
        }
    }

    public static void main1(String[] args) {
        String json =    "[\"name\" ,\"name22\" ]";
        List<String> webHookUrls1 = GsonUtils.fromJson(json, List.class);
    }

    public static void main2(String[] args) {

        List<Student> list = getStudentList();

        // java.lang.IllegalStateException: Duplicate key Student(id=1, name=lisi, age=5) 有异常
//        Map<Integer, Student> collect = list.stream().collect(Collectors.toMap(Student::getId, Function.identity()));

        //源码给出的解决办法 key 为ID value为name 对于key相同的value 使用逗号拼接,适用于一个联系人同名，电话不同
        Map<Integer, String> collect_ = list.stream().collect(Collectors.toMap(Student::getId, Student::getName, (s, a) -> s + ", " + a));
        for (Integer key : collect_.keySet()) {
            System.out.println("key: " + key + "====value: " + collect_.get(key));
        }
        System.out.println("'==================='");

        Map<Integer, Student> collect_1 = list.stream().collect(Collectors.toMap(Student::getId, Function.identity(), (a, b) -> a.equals(b) && a.hashCode() == b.hashCode() ? a : b));
        for (Integer key : collect_1.keySet()) {
            System.out.println("key: " + key + "====value: " + collect_1.get(key));
        }
        System.out.println("'==================='");

        // 判断一个对象是否相同equals为true 并且hashcode相同
        Map<Integer, Student> collect_2 = list.stream().collect(Collectors.toMap(Student::getId, Function.identity(), (a, b) -> a.getAge() > b.getAge() ? a : b));
        for (Integer key : collect_2.keySet()) {
            System.out.println("key: " + key + "====value: " + collect_2.get(key));
        }
    }

    private static List<Student> getStudentList(){
        List<Student> sList = new ArrayList<>();
        sList.add(new Student(1, "xixi", 12));
        sList.add(new Student(1, "lisi", 5));
        sList.add(new Student(2, "wangwu", 7));
        sList.add(new Student(3, "maliu", 9));
        return sList;
    }

    public static void main3(String[] args) {

        String s = new String("123");

        Map<String,String> stringMap = new HashMap<>();
        stringMap.put(s,"qwe");
        stringMap.put(s,"eee");

        stringMap.put("aaa","qwe");
        stringMap.put("aaa","eee");

     }

    public static void main4(String[] args) {
        List<String>  strings = new ArrayList<>();
        strings.add("qwe");
        strings.add("asd");
        boolean r =  strings.contains("qwe");
        boolean f =  strings.contains("qweww");
     }

    public static void main5(String[] args) {
        List<String> strings1 = new ArrayList<>();
        strings1.add("123");
        strings1.add("456");

        List<String> strings2 = new ArrayList<>();
       // strings2.add("123");
        strings2.add("456");

        boolean r = strings2.contains(strings1.iterator().next());

    }

    public static void main6(String[] args) {
        String str1 = "6741046626420352";
        String str2 = "238141be04e2400089835d6466fd7666";
        System.out.println(str1+":"+ isNumeric( str1));
        System.out.println(str2+":"+ isNumeric( str2));
    }
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]+");
        return pattern.matcher(str).matches();
    }

    public static void main7(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder().id(12).name("12").age(21).build());
        studentList.add(Student.builder().id(13).name("123").age(22).build());
        studentList.add(Student.builder().id(14).name("1234").age(23).build());
        studentList.add(Student.builder().id(15).name("12345").age(24).build());

        Map<Integer, String> stringMap = studentList.stream().collect(Collectors.toMap(s-> s.id, s->String.join("_",s.name,String.valueOf(s.age))));

        System.out.println(stringMap);
    }

    public static void main8(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder().id(12).name("123").age(21).build());
        studentList.add(Student.builder().id(12).name("123").age(22).build());
        studentList.add(Student.builder().id(12).name("1234").age(23).build());
        studentList.add(Student.builder().id(12).name("1234").age(24).build());
        studentList.add(Student.builder().id(13).name("123").age(21).build());
        studentList.add(Student.builder().id(13).name("123").age(22).build());
        studentList.add(Student.builder().id(13).name("1234").age(23).build());
        studentList.add(Student.builder().id(13).name("1234").age(24).build());

        Map<Integer, Map<String, List<Student>>> map = studentList.stream()
                .collect(Collectors.groupingBy(l -> l.getId(), Collectors.groupingBy(l-> l.getName())));

  /*      Map<Integer, Map<String, List<Student>>> map = studentList.stream()
                .collect(Collectors.groupingBy(l -> { return l.getId();}, Collectors.groupingBy(l-> l.getName())));
*/
    }

    public static void main9(String[] args) {


        Long str1 = 123456789L;
        String str2 = "local_";
        String str3 = "local_"+str1;
        boolean strSub = str3.contains(str2);
                if(strSub) {
                    str3 =  str3.substring(6);

                }
        System.out.println("str3:"+str3);

    }
    public static void main10(String[] args) {
        List<String> stringListNull = null;
        List<String> stringList = new ArrayList<>();
        stringList.add("123");
        stringList.add("333");
        stringList.add("123");

/*        List<String> stringList2 =  stringList.stream().
        filter(s -> "123".equals(s)).forEach(s -> System.out.println(s));

        System.out.println("stringList2:"+stringList2);*/
    }

    public static void main11(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("123");
        stringList.add("333");
        stringList.add("125");
        stringList.add("1231");
        stringList.add("3332");
        stringList.add("1254");
         String str = "123";
       //boolean r = stringList.contains(str);

        List<List<String>> newList = Lists.partition(stringList, 2);
        int t = newList.size();
        CountDownLatch countDownLatch = new CountDownLatch(t);
        for (List<String> list1:newList){
            countDownLatch.countDown();
            System.out.println(list1.size());
        }

    }

    public static void main12(String[] str) {
        Map<String, String > map = new HashMap<>();

        String str1 = "11111";

        map.put(str1, "1234");
        map.put(str1,"66666");

        System.out.println(map);

        try {
          int i =  1/0;
        } catch (Exception e) {
          //  throw new RuntimeException();
            throw e;
        }
        System.out.println("rrrrr");
    }

    public static void main13(String[] args) {
        int i = 0;
        switch(i) {
            case 0:
                System.out.println("==0=");
            case 1:
                System.out.println("===1==");

            case 2:
                System.out.println("===2=");
                break;
            case 3:
                System.out.println("==3==");
                break;

        }
    }


    public static void main(String[] args) {

        String s = "ddddd";
        String d = s;

        d= "ggg";

        System.out.println(s);
        System.out.println(d);

        RateLimiter  rateLimiter = RateLimiter.create(5);
    }

    public static void test() {

        try{
            int i = 1/0;
        }catch (Exception e) {
            throw new RuntimeException();
          //  throw e;
        }
    }

}

@Data
@AllArgsConstructor
@Builder
class Student {

    int id;
    String name;
    int age;
}
