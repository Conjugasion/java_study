package annotationDemo;

import java.util.Enumeration;

/**
 * @auther Lucas
 * @date 2019/1/24 22:49
 */
public @interface MyAnnotation {
    enum e{};
    String name();
    @interface anno{};
    Class c();
    char ch();
}
