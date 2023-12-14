package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.Comparator;
import java.util.List;

public class Level1 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /*
         * TO DO 1: Afficher tous les enseignants
         */
        teachers.stream().forEach(System.out::println);

        /*
         * TO DO 2: Afficher les enseignants dont le nom commence par la lettre n
         */
        teachers.stream().filter(t->t.getName().startsWith("n")).forEach(System.out::println);

        /*
         * TO DO 3: Afficher les enseignants dont le nom commence par la lettre n et le salaire > 100000
         */
        teachers.stream().filter(t->t.getName().startsWith("n")).filter(t->t.getSalary()>10000).forEach(System.out::println);

        /*
         * TO DO 4: Afficher les enseignants JAVA triés par salaire (éliminer les redondances)
         */
        teachers.stream().distinct().filter(t->t.getSubject().equals(Subject.JAVA)).sorted((t1,t2)->t1.getSalary()-t2.getSalary()).forEach(System.out::println);

        /*
         * TO DO 5: Afficher les noms des enseignants dont le salaire > 60000 avec 2 manières différentes
         */

        /* First Way */
        teachers.stream().filter(t->t.getSalary()>60000).forEach(teacher -> System.out.println(teacher.getName()));
        /* Second Way */
        teachers.stream().filter(t->t.getSalary()>60000).map(Teacher ::getName).forEach(System.out::println);

        /*
         * TO DO 6:  Ajouter 200 Dt pour les enseignants dont le nom commence par m et afficher celui qui a le salaire le plus élevé
         */
        teachers.stream().filter(t->t.getName().startsWith("m")).peek(p->p.setSalary(p.getSalary()+200)).max(Comparator.comparingInt(Teacher::getSalary)).ifPresent(System.out::println);

    }
}
