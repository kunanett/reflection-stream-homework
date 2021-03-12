package reflect;

import java.lang.reflect.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Homework1 {

    static List<Method> methods = Arrays.asList(String.class.getDeclaredMethods());

    /**
     * Prints the declared methods of java.lang.String sorted by name.
     */
    public void streamPipeline1() {
        methods.stream().sorted(Comparator.comparing(Method::getName)).forEach(System.out::println);
    }

    /**
     * Prints all distinct names of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline2() {
        methods.stream().sorted(Comparator.comparing(Method::getName))
                .map(Method::getName).distinct().forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with two or more parameters whose parameters are all of the same type, sorted by name.
     */
    public void streamPipeline3() {
        methods.stream().filter(method -> Arrays.stream(method.getParameterTypes()).count() > 1)
                .filter(method -> Arrays.stream(method.getParameterTypes()).distinct().count() == 1)
                .sorted(Comparator.comparing(Method::getName)).forEach(System.out::println);
    }

    /**
     * Prints all distinct return types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline4() {
        methods.stream().map(Method::getReturnType).sorted(Comparator.comparing(Class::getSimpleName))
                .distinct().forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with at least one boolean parameter, sorted by name.
     */
    public void streamPipeline5() {
        methods.stream().filter(method -> Arrays.stream(method.getParameterTypes())
                .anyMatch(parameterType -> parameterType.getSimpleName().equals("boolean")))
                .sorted(Comparator.comparing(Method::getName)).forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String whose parameters are all of type int, sorted by name.
     */
    public void streamPipeline6() {
        methods.stream().filter(method -> Arrays.stream(method.getParameterTypes()).count() > 0)
                .filter(method -> Arrays.stream(method.getParameterTypes())
                        .allMatch(type -> type.getSimpleName().equals("int"))).sorted(Comparator.comparing(Method::getName))
                .forEach(System.out::println);
    }

    /**
     * Returns the longest name of the declared methods of java.lang.String.
     */
    public String streamPipeline7() {
        return methods.stream().max(Comparator.comparingInt(method -> method.getName().length())).map(Method::getName).get();
    }

    /**
     * Returns the longest one from the names of the public declared methods of java.lang.String.
     */
    public String streamPipeline8() {
        return methods.stream().filter(method -> method.getModifiers() == Modifier.PUBLIC).max(Comparator.comparingInt(method -> method.getName().length())).map(Method::getName).get();
    }

    /**
     * Returns summary statistics about the number of parameters for the declared methods of java.lang.String.
     */
    public IntSummaryStatistics streamPipeline9() {
        return methods.stream().map(Method::getParameterTypes).mapToInt(t -> t.length).summaryStatistics();
    }

    /**
     * Returns the maximum number of parameters accepted by the declared methods of java.lang.String.
     */
    public int streamPipeline10() {
        return methods.stream().map(Method::getParameterTypes).mapToInt(t -> t.length).max().getAsInt();
    }

    /**
     * Returns the declared method of java.lang.String with the most number of parameters.
     */
    public Method streamPipeline11() {
        return methods.stream().max(Comparator.comparingInt(method -> method.getParameterTypes().length)).get();
    }

    /**
     * Prints all distinct parameter types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline12() {
        methods.stream().flatMap(method -> Arrays.stream(method.getParameterTypes())).map(Class::getSimpleName)
                .distinct().sorted().forEach(System.out::println);
    }

}
