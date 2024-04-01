package problem2_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students=new ArrayList<Student>();
        ArrayList<Course> courses=new ArrayList<Course>();
        ArrayList<Grade> grades=new ArrayList<Grade>();//使用三个list分别存储student，course以及grade

        ArrayList<ArrayList<Double>> studentScore=new ArrayList<>();//临时list，用来参与计算

        Scanner scan=new Scanner(System.in);//声明scanner类用来读入数据

        int n,m;
        n=scan.nextInt();
        m=scan.nextInt();//读入学生和课程的个数

        for(int i=0;i<n;i++)//读入学生
        {
            Student s=new Student();
            s.name=scan.next();
            s.id=scan.next();
            int boolint=scan.nextInt();
            if(boolint==0)
                s.gender=false;
            else
                s.gender=true;
            s.Class=scan.next();

            students.add(s);
        }

        for(int i=0;i<m;i++)//读入课程
        {
            Course c=new Course();
            c.CourseName=scan.next();
            c.id=scan.next();
            c.points=scan.nextDouble();

            courses.add(c);
        }

        for(int i=0;i<m;i++)//读入成绩
        {
            ArrayList<Double> tempList=new ArrayList<Double>();
            for(int j=0;j<n;j++)
            {
                Grade g=new Grade();
                g.studentName=scan.next();
                g.courseName=scan.next();
                g.score=scan.nextDouble();

                grades.add(g);

                tempList.add(g.score);
            }
            studentScore.add(tempList);
        }

        //遍历所有课程和学生的笛卡尔积所对应的成绩，并进行各种计算
        Map<String,ArrayList<Student>> classAverageDic = new HashMap<String,ArrayList<Student>>();
        for(int i=0;i<n;i++)
        {
            if(!classAverageDic.containsKey(students.get(i).Class))
            {
                classAverageDic.put(students.get(i).Class,new ArrayList<Student>());
            }
            for(int j=0;j<m;j++)
            {
                students.get(i).sumScore+=studentScore.get(j).get(i);
                students.get(i).points+=studentScore.get(j).get(i)*0.01*courses.get(j).points;

                classAverageDic.get(students.get(i).Class).add(students.get(i));

                courses.get(j).sumScore +=studentScore.get(j).get(i);
            }
            System.out.println("name:"+students.get(i).name);
            System.out.println("sumScore:"+students.get(i).sumScore);
            System.out.println("averageScore:"+students.get(i).sumScore/m);
            System.out.println("points"+students.get(i).points);
        }
        Set<String> keys = classAverageDic.keySet();

        //计算班级的平均成绩
        for (String key : keys)
        {
            double classAverage=0;
            ArrayList<Student> value = classAverageDic.get(key);
            for (Student s:value)
            {
                classAverage+=s.sumScore/courses.size();
            }
            classAverage/=value.size();

            System.out.println("class:"+key);
            System.out.println("average:"+classAverage);
        }

        //计算课程平均成绩
        for(Course c:courses)
        {
            System.out.println("course:"+c.CourseName);
            System.out.println("averageScore:"+c.sumScore/students.size());
        }

        //对学生按成绩和班级进行排序
        Collections.sort(students);
    }
}
