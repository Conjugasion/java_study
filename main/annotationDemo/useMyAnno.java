package annotationDemo;

/**
 * @auther Lucas
 * @date 2019/1/24 23:07
 */
public class useMyAnno {
    enum e{
        MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        System.out.println(e.MONDAY);
        System.out.println(useMyAnno.class.getClassLoader().getClass());
    }
}
