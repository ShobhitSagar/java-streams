package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people
    int limit = 0;
    List<Person> youngPeople = new ArrayList<>();
    for(Person p: people) {
        if(p.getAge() <= 18) {
            limit++;
            youngPeople.add(p);
            if(limit == 10) {
                break;
            }
        }
    }

      System.out.println(youngPeople);
      System.out.println(youngPeople.size());

  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();
    List<Person> youngPeople = people.stream().filter(person -> person.getAge() <= 18).limit(10).collect(Collectors.toList());
    youngPeople.forEach(System.out::println);
  }
}
