JAVA基础

JAVA中的几种基本数据类型是什么，各自占用多少字节。
boolean 1b, byte 1b, char 2b, short 2b, int 4b, long 8b, float 4b, double 8b


String类能被继承吗，为什么。
不能，final修饰

JDK8中的接口Interface可以实现具体方法
1、default void method(){...};         普通方法，必须写default
2、public static void method(){...};   类方法，只能用public或者省略不写


String，Stringbuffer，StringBuilder的区别。
不可变类， 可变线程安全，  可变线程不安全


ArrayList和LinkedList有什么区别。
数组实现，扩容时拷贝，查找方便；链表实现，增删方便


讲讲类的实例化顺序，比如父类静态数据，构造函数，字段，子类静态数据，构造函数，字段，当new的时候，他们的执行顺序。
父类静态数据 and 父类静态代码块 > 子类静态数据 and 子类静态代码块 > 父类普通变量、非静态代码块、构造方法 > 子类普通变量、非静态代码块、构造方法


用过哪些Map类，都有什么区别，HashMap是线程安全的吗,并发下使用的Map是什么，他们内部原理分别是什么，比如存储方式，hashcode，扩容，默认容量等。
hashtable             hashmap                 linkedhashmap                treemap
线程安全           线程不安全效率高          线程不安全插入顺序即存储顺序  可以按照指定顺序存储数据，自动排序
 哈希表               哈希表                  hashmap+双向链表记录顺序         红黑树
hashmap/linkedhashmap冲突个数超过8(默认值)的列表，jdk1.8中采用了红黑树的结构，那么查询的时间复杂度可以降低到O(logN)
存入TreeMap的元素应当实现Comparable接口或者实现Comparator接口，treemap的key不允许null，value允许null；           
Hashtable计算hash是直接使用key的hashcode对table数组的长度直接进行取模
HashMap计算hash对key的hashcode进行了二次hash，以获得更好的散列值，然后对table数组长度取模
HashMap的初始容量为16，Hashtable初始容量为11，两者的填充因子默认都是0.75
HashMap扩容时是当前容量翻倍即:capacity*2，Hashtable扩容时是容量翻倍+1即:capacity*2+1
HashMap是非线程安全的,只是用于单线程环境下,多线程环境下可以采用concurrent并发包下的concurrentHashMap。HashTable是线程安全的,synchronized
HashMap/linkedhashmap中key和value都允许为null。key为null的键值对永远都放在以table[0]为头结点的链表中。
HashTable在 key、value 遇到null时，会抛出NullPointerException异常
HashMap仅支持Iterator的遍历方式，Hashtable支持Iterator和Enumeration两种遍历方式


JAVA8的ConcurrentHashMap为什么放弃了分段锁，有什么问题吗，如果你来设计，你如何设计。
ConcurrentHashMap的Key和Value不允许null值。ConcurrentHashmap和Hashtable都是支持并发的，这样会有一个问题，当你通过get(k)获取对应的value时，
如果获取到的是null时，你无法判断，它是put（k,v）的时候value为null，还是这个key从来没有做过映射。
HashMap是非并发的，可以通过containsKey(key)来做这个判断。
而ConcurrentHashMap在调用m.containsKey(key)和m.get(key)，这两个方法都是没有加锁的，调用的时候可能被其他线程改变了。

1.7 ConcurrentHashMap加锁粒度是基于Segment（ReentrantLock）的，包含多个HashEntry。多个线程同时竞争获取同一个segment锁，获取成功的线程更新
map；失败的线程尝试多次获取锁仍未成功，则挂起线程，等待释放锁。
1.8 ConcurrentHashMap加锁粒度是基于HashEntry数组，采用Synchronized和CAS，锁粒度变小了。当bucket为空时，使用CAS操作，将Node放入对应的
bucket中；当出现hash冲突时，则采用synchronized关键字。链表超过一定长度会转成红黑树。

为什么采用Synchronized而不是ReentrantLock?
锁已经被细化的很小了,出现并发争抢的可能性不高。哪怕出现了争抢,只要线程可以在30~50次自旋里拿到锁,那么Synchronized就不会升级为重量级锁,
等待的线程也不用被挂起,也就少了挂起和唤醒带来的上下文切换开销。
但如果是ReentrantLock，若线程没有抢到锁,不会自旋而是直接挂起,就会带来线程上下文开销。当然,你也可以使用tryLock(),但是这样又出现了一个问题,
你怎么知道tryLock的时间呢?在时间范围里还好,假如超过了呢?所以使用Synchronized是最好的选择。


ThreadLocal详解
在Thread类中包含一个ThreadLocal.ThreadLocalMap成员变量threadLocals，ThreadLocalMap是ThreadLocal类的一个静态内部类，键为线程对象，值为对应线程的变量副本。
实际上，每个线程Thread持有一个ThreadLocalMap类型的实例threadLocals，结合ThreadLocalMap的构造方法可以理解成每个线程Thread都持有一个Entry型
的数组table，ThreadLocal确定了一个数组下标，而这个下标就是value存储的对应位置


有没有有顺序的Map实现类，如果有，他们是怎么保证有序的。
linkedHashmap： hashmap+双向链表记录顺序
treeMap： 自定义排序，自动维护顺序， 红黑树


抽象类和接口的区别，类可以继承多个类么，接口可以继承多个接口么,类可以实现多个接口么。
接口方法默认public static，接口变量默认public staic final，方法一般是不能实现的；抽象类可以有抽象方法也可以有具体方法。
类不可以继承多个类，但是可以实现多个接口，接口可以继承多个接口。


IO模型有哪些，讲讲你理解的nio ，他和bio，aio的区别是啥，谈谈reactor模型。
同步阻塞的BIO，面向流，都是inputstream和outputstream，服务端启动一个severSocket监听特定端口，然后客户端创建指定ip地址和端口的socket去连接
服务器。每有一个客户端连接进来，服务器都要创建一个线程，当有大量客户端连接时，服务器会不堪重负。
同步非阻塞的NIO，面向缓存，从channel读到buffer，从buffer写到channel。事件驱动型，Reactor设计模式，socket会注册感兴趣的事件，少量线程负责
轮询socket，当感兴趣的事件准备好的时候，再创建一个线程去处理。但是具体的IO读写还是阻塞的。
异步非阻塞AIO，Proactor设计模式，不用用户线程亲自读写，OS会把可读的流传入read方法缓冲区，write方法的写入完毕时会通知用户线程。


反射的原理，反射创建类实例的三种方式是什么。
根据类名找到对应的.class文件，通过字节码文件进行一系列操作
Class clazz = Class.forname()；
Class clazz = 实例.getClass()；
Class clazz = 类.class


反射中，Class.forName和ClassLoader区别。
JVM加载class有三个步骤：加载，链接(检查、准备、解析)，初始化
Class.forName()得到的class对象是已经初始化完毕的。
ClassLoader得到的class对象还没有链接，仅仅加载了而已，不会执行static中的内容,只有在newInstance才会去执行static块。


描述动态代理的几种实现方式，分别说出相应的优缺点。
1. 原生JDK方式。代理类和目标类实现同一接口，代理类持有目标类对象来达到拦截的目的。必须借助接口才能产生代理对象，只有在接口中声明的方法，代理类才能进行拦截。
2. CGLIB，底层使用ASM在内存中动态生成被代理类的子类，即使代理类没有实现任何接口也可以实现动态代理功能。CGLIB简单易用，它的运行速度要远远快于JDK的Proxy动态代理
3. asm
4. javassist


动态代理与cglib实现的区别。
1.原生JDK方式。代理类和目标类实现同一接口，代理类持有目标类对象，来达到拦截的目的。必须借助接口才能产生代理对象，只有在接口中声明的方法，代理类才能进行拦截。
2.CGLIB，底层使用ASM在内存中动态生成被代理类的子类，即使代理类没有实现任何接口也可以实现动态代理功能。CGLIB简单易用，它的运行速度要远远快于JDK的Proxy动态代理


为什么CGlib方式可以对接口实现代理。
CGLIB，底层使用ASM在内存中动态生成被代理类的子类，即使代理类没有实现任何接口也可以实现动态代理功能。CGLIB简单易用，它的运行速度要远远快于JDK的Proxy动态代理


final的用途。
1.final修饰类，类不能被继承
2.final修饰基本类型变量，变量的值不能修改
3.final修饰引用变量，变量不能被指向其它对象
4.final修饰方法，方法不能被重写，但是能被重载


写出三种单例模式实现 。
1.饿汉式
public class Singleton{
	private staic Singleton instance = new Singleton();
	private Singleton(){
		System.out.println("构造方法");
	}
	public Singleton getSingleton(){
		return instance;
	}
}
tips:调用外部类的静态变量和静态方法，不会初始化静态内部类
2.public class Singleton{
	private Singleton(){
		System.out.println("构造方法");
	}
	private static class InnerSingleton{
		private final staic Singleton instance = new Singleton(); 
	}
	public Singleton getSingleton(){
		return InnerSingleton.instance;
	}
}
加同步锁，前后两次判断
3.public class Singleton{
	private volatile Singleton instance = null;
	private Singleton{
		System.out.println("构造方法");
	}
	public Singleton getSingleton(){
		if (instance==null) {
			synchronized(Singleton.class){
				if (instance==null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
枚举类
4.public enum Singleton {  
    INSTANCE;  
    public void whateverMethod() {  
    }  
} 


请结合OO设计理念，谈谈访问修饰符public、private、protected、default在应用设计中的作用。
public 对所有人都开放，private 仅对本类成员开放， protected 对本类、子类、本包开放， default 对本类和本包开放


深拷贝和浅拷贝区别。
浅拷贝：源本和副本共享相同的引用类型对象，基本类型是各自一份的，所以修改引用类型会引起源本和副本的同时变化，修改基本类型不会引起同时变化。
深拷贝：源本和副本引用类型和基本类型都是各自一份，所以修改只会影响自己。
Object.clone()默认是浅拷贝，若要实现深拷贝，需要将对象引用到的所有类都 implement Cloneable 接口并重写clone方法。
可以采用序列化的方法实现简单深拷贝，需要将对象引用到的所有类都 implements Serializable 接口(不需要重写方法)。
transient 和 static 修饰的属性不能被序列化。


error和exception的区别，CheckedException，RuntimeException的区别。
error 表示虚拟机发生了严重错误，必须修改程序。
exception 表示程序可以处理的异常，可以捕获且可能恢复。遇到这类异常，应该尽可能处理异常，使程序恢复运行，而不应该随意终止异常。
CheckedException 受查异常/编译时异常 编写代码的时候必须考虑到的异常，可以 throws 或者 try-catch。
RuntimeException 非受查异常/运行时异常 不需要捕获，一旦抛出 RuntimeException 异常，请修改程序。


请列出5个运行时异常。
空指针异常 NullPointerException 
类找不到异常 ClassNotFoundException 
算数异常 ArithmeticException
数组越界异常 ArrayIndexOutOfBoundsException
类型转换异常 ClassCastException


在自己的代码中，如果创建一个java.lang.String类，这个类是否可以被类加载器加载？为什么？
不可以，因为存在双亲委派模型。先交给 bootStrap ClassLoader，若无法加载再交给 extension ClassLoader，若还不能加载则交给 System ClassLoader
通过双亲委托模式传递到引导加载器，而引导加载器在核心 Java API 发现这个名字的类，所以会加载该核心类，并不会加载自己写 java.lang.String类。
这样便可以防止核心API库被随意篡改。
public class String {
    public static void main(String[] args) {
        String str = "my String";
        System.out.println(str);
    }
}
错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
   public static void main(String[] args)
否则 JavaFX 应用程序类必须扩展javafx.application.Application

如果我们在 classpath 路径下自定义一个名为 java.lang.MyString 类(该类是胡编的)呢？该类并不存在 java.lang中，经过双亲委托模式，传递到启动类加载器中，
由于父类加载器路径下并没有该类，所以不会加载，将反向委托给子类加载器加载，最终会通过 System 加载器加载该类。
但是这样做是不允许，因为 java.lang 是核心API包，需要访问权限，强制加载将会报出如下异常：
java.lang.SecurityException: Prohibited package name: java.lang


说一说你对java.lang.Object对象中 hashCode和equals方法的理解。在什么场景下需要重新实现这两个方法。
两个对象属性相同应当认为这两个对象是相同的，而不能简单的去比较两个对象的内存地址是否相同。equals 比较的是两个对象的属性，若 equals返回true，
两个对象的hashcode必须相等；若两个对象的 hashcode相等，equals不一定为true。
需要根据对象属性去判断两个对象是否相等的场景需要重写 hashcode 和 equals


在jdk1.5中，引入了泛型，泛型的存在是用来解决什么问题。
泛型的主要目标是实现 java 的类型安全。 泛型可以使编译器知道一个对象的限定类型是什么，从而检查是否有代码错误。
消除了强制类型转换 使得代码可读性好，减少了很多出错的机会


这样的a.hashcode() 有什么用，与a.equals(b)有什么关系。
默认调用 object 的hashcode方法，用于计算对象的内存地址。equals在不重写的情况下，使用的是object默认的 equals，调用==比较的也是对象的内存地址。


有没有可能2个不相等的对象有相同的hashcode。
可能，hash冲突


Java中的HashSet内部是如何工作的。
hashSet基于hashMap实现，因为 hashMap 的 key 是不能重复的，value 是统一的 public final static Object PRESENT = new Object()。
往 HashSet 中添加元素，首先判断元素（也就是key）是否存在，如果不存在则插入，如果存在则不插入，这样 HashSet 中就不存在重复值。


什么是序列化，怎么序列化，为什么序列化，反序列化会遇到什么问题，如何解决。
将 JVM 中的对象持久化保存到磁盘，只要一个类实现了 java.io.Serializable 接口，那么它就可以被序列化。
FileOutputStream fs = new FileOutputStream();
ObjectOutputSream os = new ObjectOutputSream(fs);
os.writeObject(对象);
os.close();
序列化的作用就是为了不同 jvm 之间共享实例对象;内存中的对象状态保存到一个文件中或者数据库中时候；当你想用套接字在网络上传送对象的时候；当你想通过RMI传输对象的时候；
transient 和 static 修饰的变量不参与序列化
serialVersionUID 不要改动


java8的新特性。
Lambda 表达式，Stream API，接口默认方法......


什么情况下会发生栈内存溢出。
递归太深


JVM的内存结构，Eden和Survivor比例。
8:1:1


Java常量池
方法区存放了一些常量、静态变量、类信息等，可以理解成class文件在内存中的存放位置。jdk1.8后取消了方法区，改成了元空间。
Java中的常量池存放在方法区/元空间中，实际上分为两种形态：静态常量池和运行时常量池。
静态常量池，即*.class文件中的常量池，class文件中的常量池不仅仅包含字符串、数字的字面量，还包含类、方法的信息，占用class文件绝大部分空间。
运行时常量池，则是jvm虚拟机在完成类装载操作后，将class文件中的常量池载入到内存中，并保存在方法区中，我们常说的常量池，就是指方法区中的运行时常量池。
必须要关注编译期的行为，才能更好的理解常量池。编译期可知的字符串常量会根据ASCII码值转换为十六进制存放在class文件中。
运行时常量池中的常量，基本来源于各个class文件中的常量池。
程序运行时，除非手动向常量池中添加常量(比如调用intern方法)，否则jvm不会自动添加常量到常量池。
除了字符串常量池，还有整型常量池，只不过它不可以手动添加常量，程序启动后常量池中的常量就已经确定，而且只有-128~127 这个范围的数字可以用到整型常量池。


JVM内存为什么要分成新生代，老年代，永久代(方法区)。新生代中为什么要分为Eden和Survivor。
永久代(方法区)存放字符串常量池、类的基本信息，默认大小4m，Jdk8 已经直接取消了 永久代 区域，新建了一个分配在本地内存的元空间。
因为新生代采用复制算法，Eden和to的存活对象复制到from，然后删除Eden和to中的对象，最后from和to互换。


JVM中一次完整的GC流程是怎样的，对象如何晋升到老年代，说说你知道的几种主要的JVM参数。
-XX:+printGC(打印GC)；-XX:+PrintGCDetails；(打印GC细节)-XX:+PrintHeapAtGC；(在GC时打印堆状况)-XX:+TraceClassLoading；(打印class加载细节)
-Xmx（最大堆的空间)；-Xms（最小堆的空间）; -Xmn (设置新生代的大小)；-XX:NewRatio(新生代和老年代比例，默认1:2)；-XX:SurvivorRatio；
-Xss (设置栈空间的大小); -XX:+HeapDumpOnOutOfMemoryError；


你知道哪几种垃圾收集器，各自的优缺点，重点讲下cms和G1，包括原理，流程，优缺点。
新生代垃圾收集器： Serial，采用复制算法，单线程，在进行垃圾回收时会暂停其他所有工作线程(stop the world)
				ParNew，Serial 的多线程版，采用复制算法，在进行垃圾回收时会暂停其他所有工作线程(stop the world)
				Parallel Scavenge，多线程，采用复制算法，吞吐量优先,运行代码时间/(运行代码时间+垃圾收集时间)，最高效率地利用CPU时间，
				尽快地完成程序的运算任务,在进行垃圾回收时会暂停其他所有工作线程(stop the world)
				G1......

老年代垃圾收集器： Serial Old，采用标记-整理算法，单线程，在进行垃圾回收时会暂停其他所有工作线程(stop the world)
				Parallel Old,采用标记-整理算法，多线程，吞吐量优先,在进行垃圾回收时会暂停其他所有工作线程(stop the world)
				CMS 采用标记-清除算法，多线程，主要目标是获取最短垃圾回收停顿时间，真正意义上并发垃圾收集器，它第一次实现了让垃圾收集线程和用户线程同时工作。
				G1 基于标记-整理算法，高垃圾收集效率。可以非常精确控制停顿时间，在不牺牲吞吐量前提下，实现低停顿垃圾回收。
				G1收集器避免全区域垃圾收集，它把堆内存划分为大小固定的几个独立区域，并且跟踪这些区域的垃圾收集进度，
				同时在后台维护一个优先级列表，每次根据所允许的收集时间，优先回收垃圾最多的区域。


垃圾回收算法的实现原理。
标记清除算法；标记整理算法；复制算法；分代收集算法
GC Root：栈中的对象


当出现了内存溢出，你怎么排错。
-XX:+HeapDumpOnOutOfMemoryError，Mat分析堆转储文件


JVM内存模型的相关知识了解多少，比如重排序，内存屏障，happen-before，主内存，工作内存等。
重排序指编译器和处理器为了优化程序性能而对指令序列进行重新排序的手段。
对于有数据依赖的代码，不会重排序，比如写后读、写后写和读后写；
happen-before是指 A 操作 happen-before B 操作，只要保证结果正确，具体指令按什么顺序执行时可以重排序的。
as-if-serial语义保证单线程内程序的执行结果不被改变，happens-before关系保证正确同步的多线程程序的执行结果不被改变。
程序顺序规则：一个线程中的每个操作，happens-before于该线程中的任意后续操作。
监视器锁规则：对一个锁的解锁，happens-before于随后对这个锁的加锁。
volatile变量规则：对一个volatile域的写，happens-before于任意后续对这个volatile域的读。
传递性：如果A happens-before B，且B happens-before C，那么A happens-before C。
start()规则：如果线程A执行操作ThreadB.start()（启动线程B），那么A线程的ThreadB.start()操作happens-before于线程B中的任意操作。
join()规则：如果线程A执行操作ThreadB.join()并成功返回，那么线程B中的任意操作happens-before于线程A从ThreadB.join()操作成功返回。

内存屏障
Store：将cache的数据刷新到内存中。Load：将内存存储的数据拷贝到cache中。
四种屏障：loadload、storestore、loadstore、storeload


简单说说你了解的类加载器，可以打破双亲委派么，怎么打破。
bootStrap ClassLoader、extension ClassLoader 和 System ClassLoader
首先自己写一个加载器继承 ClassLoader，重写loadClass和findClass方法
两个类是否相同，需要他们的加载器相同！ 所以即使自己自定义加载器加载自己写的java.lang.String，系统也不认为该类就是真正的String


讲讲JAVA的反射机制。
反射就是对.class文件(字节码)进行一系列操作，包括获取所有变量、属性、方法、构造器...


g1和cms区别,吞吐量优先和响应优先的垃圾收集器选择。
CMS 是多线程老年代垃圾回收器，基于标记-清除算法，是真正意义上的并发垃圾收集器，追求最短的垃圾回收停顿时间。大概分为四步，首先初始标记(stop the world)，
标记出root可达的对象，然后并发标记，跟踪可达对象，再标记可达对象，接着重新标记(stop the world)，标记可达对象，最后并发清理。缺点是占用cpu，清理不彻底。
G1 基于对于新生代采用复制算法，对于老年代采用标记-整理算法，高垃圾收集效率。可以非常精确控制停顿时间，在不牺牲吞吐量前提下，实现低停顿垃圾回收。
G1 垃圾收集器避免全区域垃圾收集，它把堆内存划分为大小固定的几个独立区域，并且跟踪这些区域的垃圾收集进度，同时在后台维护一个优先级列表，
每次根据所允许的收集时间，优先回收垃圾最多的区域。


怎么打出线程栈信息。
jstack


请解释如下jvm参数的含义： 
-server -Xms512m -Xmx512m -Xss1024K 
server: 指java启用JIT的Server Compiler，全局优化，优化比较慢，client Compiler 仅采用局部优化，优化比较快。
java堆最小512M，最大512M，栈空间大小1024K
-XX:PermSize=256m -XX:MaxPermSize=512m
永久代大小初始256m，最大512m
-XX:MaxTenuringThreshold=20
新生代晋升老年代的年龄阈值，默认15； 
-XX:MSInitiatingOccupancyFraction=80 -XX:+UseCMSInitiatingOccupancyOnly。
当内存被占用达到80%时，启动full GC；指定cms使用手动设定的阈值full GC，否则只有第一次会在80%时GC，之后则自动调整


LongAdder和AtomicLong的区别
AtomicLong的原理是依靠底层的cas来保障原子性的更新数据，在要添加或者减少的时候，会使用死循环不断地cas到特定的值，从而达到更新数据的目的。
如果并发量大的时候会导致cas经常失败，相当于一直在自旋，白白浪费cpu资源。
LongAdder中会维护一个或多个变量，这些变量共同组成一个long型的"和"，当多个线程同时更新值时，如果他们之间不操作同一个值(cell)，则可以并行增减这组变量
的数值，若多个线程操作同一个cell，则通过cas方法尝试。"sum"方法会返回这组值的"和"。思路类似于concurrentHashMap，减小锁粒度。小并发情况下，效率和
AtomicLong差不多，高并发下LongAdder吞吐量明显更高，但有着更高的空间复杂度。


强软弱虚--Java中的四种引用类型
软引用：SoftReference<T>，Java堆内存不够的时候会回收被软引用的对象，主要用于缓存(比如大图片缓存)
弱引用(重要)：WeakReference<T>，被GC发现就会被回收。如果没有被回收，调用get()可以get到
虚引用：PhantomReference<T>，不管有没有被回收，调用get()不可以get到(因为它指向堆内内存)。唯一作用：用于管理堆外内存，DirectByteBuffer变量指向一块堆外内存，当要释放堆外内存时，
DirectByteBuffer的某个信息会被加到一个被GC监听的队列中，并调用底层cpp方法释放堆外内存。

ThreadLocal--弱引用
Thread类有一个名叫threadlocals的ThreadlocalMap对象，key是ThreadLocal对象，value是存入ThreadLocal的对象。
ThreadLocal。set(Threadlocal<?> key, Object value){
	内部有一个Entry[]，即一组key-value对；
}
static class Entry extends WeakReference<ThreadLocal<?>> {
	Object value;

    Entry(ThreadLocal<?> k, Object v) {
        super(k);      // new了一个WeakReference对象"弱引用"key(ThreadLocal对象)
        value = v;
    }
}
ThreadLocal<person> tl = new ThreadLocal();
此时tl变量"强引用"ThreadLocal对象，WeakReference对象"弱引用"ThreadLocal对象
为什么这么设计?主要是为了防止内存泄露，当tl不在引用ThreadLocal对象时，不会因为WeakReference对象仍引用而不回收ThreadLocal对象。
虽然ThreadLocal对象被回收，即key指向null，但是其value仍存在于Entry[]中，所以当某个ThreadLocal对象不再使用时，要手动移除 tl.remove()，不然会造成内存泄漏。

请问Object o = new Object()在内存中占了多少字节?(对象在内存中的布局是如何的?)
对象由四部分组成：对象头markword，class point类型指针(表示该对象是哪个类的))，实例数据，对齐(为了凑到8字节的整数倍)
markword占8字节，class point由于默认开启compressClassPoint占4字节(不压缩占8字节)，实例数据：基本类型按所占字节计算，
引用类型按指向其类型的指针大小计算，由于默认开启compressOop，一个指针占4字节。
所以此处o占用8 + 4 + 4(对齐) = 16字节
举例：
User u = new User()，User类包括int id和String name属性
此处u占用8 + 4 + 4 + 4 + 4(对齐) = 24字节


对象的创建过程
示例：
class T{
	int m = 8；
}

public static void main(String[] args){
	T t = new T();
}

转换成汇编码：
0 new #2 <T>                    // 在内存中根据对象布局分配内存，此时m变量是int的默认值0,此阶段称为"半初始化"阶段
3 dup
4 invokespecial #3 <T.<init>>   // 调用对象的构造方法
7 astore_1                      // 将栈上t变量指向创建的对象
8 return


DCL(Double Check Lock双重检查锁)需不需要volatile?
在对象的创建过程中，0 new #2 <T>执行完毕是"半初始化"状态，其内部属性还未赋值，均为初始值。由于cpu存在指令重排，有可能导致
4 invokespecial #3 <T.<init>>和 7 astore_1顺序倒转，即先将t变量指向还未完全初始化完毕的对象，再进行运行对象的构造方法，
若此时有另一个线程进入判断t!=null(true)，会认为该对象已经被创建，进而使用该对象做业务操作，可是事实上该对象还未完成初始化操作。


Synchronized实现过程
1.Java代码层面：代码里添加Synchronized
2.编译后的Java字节码文件里在进入临界区的位置添加monitorenter，在退出临界区的位置添加monitorexit
3.在jvm解释器执行字节码文件的过程中完成锁升级
4.底层汇编其实是通过调用lock comxchg指令


Synchronized锁升级过程
关于锁的信息都记录在锁对象的markword里。
具体过程：当锁对象第一次被某线程获取到时，在锁对象markword里记录指向该线程的指针(类似于在书本上写上自己的名字)。
发生竞争时撤销偏向锁，在各自的线程栈中生成Lock Record，并尝试(采用自旋、CAS的方式)在锁对象markword里记录指向自己Lock Record的指针。
当竞争激烈时升级为重量级锁，会向操作系统申请mutex，并在锁对象markword里记录指向互斥量的指针，而线程则进入该mutex的等待队列中。
-----------------
锁状态       25位                    31位                       1位         4位         1位(偏向锁位)       2位(锁标志位)
无锁状态    unused     如果有调用hashcode()会填充hashcode       unused     分代年龄           0                 0   1
-----------------
锁状态                54位                    2位       1位         4位         1位(偏向锁位)       2位(锁标志位)
偏向锁       指向当前拥有锁的线程的指针        Epoch     unused     分代年龄           1                0   1
----------------- 
锁状态                                 62位                          2位(锁标志位)     
轻量级锁(自旋锁、无锁)        指向线程栈中Lock Record的指针                0    0
重量级锁                      指向互斥量(重量级锁)的指针                  1    0
GC标志信息                      CMS过程用到的标记信息                     1    1   
-----------------


锁消除是什么
示例：
public void add(String str1, String str2){
	StringBuffer sb = new StringBuffer();
	sb.append(str1).append(str2);
}
StringBuffer是线程安全的，它的关键方法被Synchronized修饰。上面这段代码中的sb这个变量旨在add()中使用，不可能被其它线程引用(局部变量，线程栈私有)，
因此sb是不可能共享的资源，JVM会自动消除sb对象内部的锁。


锁粗化是什么
public String test(String str){
	int i = 0;
	StringBuffer sb = new StringBuffer();
	while(i < 100){
		sb.append(str);
		i++;
	}
	return sb.toString();
}
JVM会检测到一连串操作都是对同一个对象加锁(while循环内100次执行append，没有锁粗化的话就要100次加锁和解锁)，此时JVM就会将加锁的范围粗化到这一连串操作
的外部(while循环体外)，使得这一连串操作只需要加一次锁。


系统底层如何实现数据一致性？
1、采用MESI协议
2、如果MESI不能解决问题，比如数据过大超过了一个cache line，则采用锁总线的方法(只允许一个cpu访问该块内存)


系统底层如何保证有序性
1、sfence写串行化、lfence读串行化、mfence读写串行化等系统原语
2、锁总线


volatile如何解决指令重排序
在代码中添加volatile，会在字节码中为该变量添加ACC_VOLATILE记号，当字节码文件交给JVM执行时，JVM会添加内存屏障
(LoadLoad、LoadStore、StoreLoad、StoreStore，屏障两边的指令不可以重排，保证有序)在volatile变量的读写操作前后，具体如下：
在hotspot中内存屏障(LoadLoad、LoadStore、StoreLoad、StoreStore)并没有采用底层原语(sfence、lfence、mfence，因为不是所有的cpu都支持)，而是自己通过lock原语实现。

 StoreStoreBarrier         volatile变量的写操作和之前的写操作不能换顺序 
volatile变量的写操作        
 StoreLoadBarrier          volatile变量的写操作完成后才能进行读操作  

LoadLoadBarrier            volatile变量的读操作和之前的读操作不能换顺序
volatile变量的读操作
LoadStoreBarrier           volatile变量的读操作完成后才能进行写操作


JMM Java内存模型
JMM定义了JVM在计算机内存RAM中的工作方式，JMM隶属于JVM。
JMM定义了线程和主内存之间的抽象关系：线程之间的共享变量存储在主内存中，每个线程都有一个私有的本地内存，本地内存中存储了该线程共享变量的副本。
基本变量 int a=-128~127，a变量存储在线程栈的局部变量表中，指向常量池中的-128~127；若不属于该范围，变量a和a的值都存储在线程栈中。
引用变量 Person a = new Person()，a变量存储在线程栈的局部变量表中，实际对象存储在堆中。

JMM 带来的问题
1.可见性问题
A线程在工作内存中修改了共享变量count，使之从1变成2，由于还没有flush到主内存，所以此时B线程读取到的count还是1。 需要引入Volatile
2.竞争现象
A、B线程同时在各自的工作内存中操作共享变量count，执行count++，结果可能为2或者3。需要引入Synchronized

3.重排序：在执行程序时，为了提高性能，编译器和处理器常常会对指令做重排序。
重排序类型
1、编译器优化的重排序。编译器在不改变单线程程序语义的前提下，可以重新安排语句的执行顺序。
2、指令级并行的重排序。现代处理器采用了指令级并行技术来将多条指令重叠执行。如果不存在数据依赖性，处理器可以改变语句对应机器指令的执行顺序。
3、内存系统的重排序。由于处理器使用缓存和读/写缓冲区，这使得加载和存储操作看上去可能是在乱序执行。

重排序与依赖性
1、写后读、写后写、读后写，这些语句顺序不能被改动，一旦顺序被重排序，执行结果就会被改变。
2、控制依赖性，flag变量是个标记，用来标识变量a是否已被写入，在use方法中是否对变量i进行操作依赖于if (flag)的判断。
在单线程程序中，对存在控制依赖的操作重排序，不会改变执行结果。处理器为了不闲置，会"猜测"flag为true，先行对i进行操作，万一后来发现flag其实是
false，大不了抛弃之前进行的操作，重新进行正确的操作。
但在多线程程序中，对存在控制依赖的操作重排序，可能会改变程序的执行结果。
3、as-if-serial：不管怎么重排序，单线程程序的执行结果不能被改变。为了遵守as-if-serial语义，编译器和处理器不会对存在数据依赖关系的操作做重排序。
(这里所说的数据依赖性仅针对单个处理器中执行的指令序列和单个线程中执行的操作，不同处理器之间和不同线程之间的数据依赖性不被编译器和处理器考虑。)

解决在并发下的问题
1、Java层面的内存屏障——禁止重排序
JMM的四种内存屏障
LoadLoad Barrier           Load1，LoadLoad，Load2             确保Load1(从主内存装载到工作内存)数据装载，先于Load2及其后的所有指令     
LoadStore Barrier          Load1，LoadStore，Store2			 确保Load1数据装载，先于Store2(将数据从工作内存刷新到主内存)及其后的所有指令
StoreLoad Barrier          Store1，StoreLoad，Load2
StoreStore Barrier         Store1，StoreStore，Store2
2、临界区
临界区内的代码可以重排序（但JMM不允许临界区内的代码"逸出"到临界区之外，那样会破坏监视器的语义）。JMM会在退出临界区和进入临界区这两个关键时间点
做一些特别处理，虽然线程A在临界区内做了重排序，但由于监视器互斥执行的特性，这里的线程B根本无法"观察"到线程A在临界区内的重排序。
这种重排序既提高了执行效率，又没有改变程序的执行结果。

Happens-Before规则要求前一个操作（执行的结果）对后一个操作可见...... 程序顺序规则、监视器锁规则、volatile变量规则、传递性、start()规则、join()规则、线程中断规则

volatile的内存语义
1、保证内存可见性 2、禁止重排序
当写一个volatile变量时，JMM会把该线程对应的本地内存中的volatile变量值刷新到主内存。
当读一个volatile变量时，JMM会把该线程对应的本地内存的volatile变量置为无效，接着将从主内存中读取volatile变量。
volatile内存语义的实现——JMM对volatile的内存屏障插入策略：
在每个volatile写操作的前面插入一个StoreStore屏障。在每个volatile写操作的后面插入一个StoreLoad屏障。
在每个volatile读操作的前面插入一个LoadLoad屏障。在每个volatile读操作的后面插入一个LoadStore屏障。

锁的内存语义
当线程释放锁时，JMM会把该线程对应的本地内存中的共享变量刷新到主内存中。
当线程获取锁时，JMM会把该线程对应的本地内存置为无效。从而使得被监视器保护的临界区代码必须从主内存中读取共享变量。


synchronized的实现原理
使用monitorenter和monitorexit指令实现。
monitorenter指令是在编译后插入到同步代码块的开始位置，而monitorexit是插入到方法结束处和异常处。
每个monitorenter必须有对应的monitorexit与之配对。
synchronized上锁对象的对象头里的重量级锁标志指向monitor，monitor中保存了当前抢到锁的线程。

各种锁
锁一共有4种状态，级别从低到高依次是：无锁状态、偏向锁状态、轻量级锁状态和重量级锁状态。

偏向锁：大多数情况下，锁不存在多线程竞争，总是由同一线程获得。为了让线程获得锁的代价降低，引入了偏向锁。只需要在锁的Mark Word中通过CAS记录
当前拥有锁的线程，如果记录成功，则获取偏向锁，之后当前线程只需要检查锁对象的Mark Word的偏向锁位是否指向自己。

轻量级锁：少量竞争时通过CAS操作来加锁和解锁。（自旋锁——是一种锁的机制，不是状态）
线程A和线程B分别在自己的栈空间中新建lock record，然后将锁对象的Mark Word信息(比如锁对象的hashcode)复制到开辟的lock record中，然后线程A和线程B进行CAS操作，尝试在锁
对象的Mark Word里记录指向自己lock record的指针。
假如线程B竞争成功，则线程A进入自旋状态，尝试修改锁对象的Mark Word的轻量级锁指针，使其指向自己的lock record，如果30~50次尝试失败则进入重量级锁。

重量级锁：真正的加锁操作。此处将会用到monitor对象！锁对象的Mark Word的重量级锁标志指向monitor，monitor中保存了当前抢到锁的线程信息


操作系统

L1、L2、L3三级缓存
L1和L2位于核内，是核心私有缓存，而L3是同个CPU内的核心共享，它可能装在CPU上也可能装在主板上。


超线程是什么？
cpu核主要由ALU数学运算单元、Register寄存器、PC指令寄存器、L1、L2组成
一组ALU、Register和PC同一时刻只能执行一个线程，而超线程技术可以让单个核心模拟出两组Register和PC，使一个ALU对应两组Register和PC，切换线程时不用改变Register和PC里的内容(切换上下文)，只需要改变ALU的对应关系，所谓的四核八线程。


Cache line 缓存行的概念、对齐、伪共享
main memory 主内存 -> L3缓存 -> L2缓存 -> L1缓存 ->计算单元与寄存器
核心需要数据时首先会去L1找，若没有命中则去L2找，若没有命中则去L3找，若仍没有命中则去主存中读取.
根据局部性原理，从主存中读取数据按块(cache line，64字节)读取。
缓存行对齐：CPU核心的操作是针对与64字节的cache line的，利用这一点可以提升运行速度
缓存航越大，局部性空间效率越高，但读取时间长；缓存行越小，局部性空间效率越低，但读取时间快。目前一般是64字节。
示例 disruptor开源环形队列
public long p1,p2,p3,p4,p5,p6,p7;        // cache linepadding
private volatile long cursor = INITIAL_CURSOR_VALUE;
public long p8,p9,p10,p11,p12,p13,p14;   // cache linepadding
cursor这个long类型必定是和p1-p7、p8-p14中的7个变量组合成64字节cache line。    


Linux系统下你关注过哪些内核参数，说说你知道的。
fs.file-max 和 ulimit: 前者是指整个系统最大能打开的文件描述符的数量，后者指某个进程最大能打开的文件描述符的数量。

net.ipv4.tcp_fin_timeout = 2           #保持在FIN-WAIT-2状态的时间，使系统可以处理更多的连接。此参数值为整数，单位为秒。
net.ipv4.tcp_max_tw_buckets = 5000     #系统同时保持TIME_WAIT套接字的最大数量，如果超过这个数值将立刻被清楚并输出警告信息。默认值为180000。对于squid来说效果不是很大，但可以控制TIME_WAIT套接字最大值，避免squid服务器被拖死。 
net.ipv4.tcp_tw_reuse = 1              #开启重用，允许将TIME_WAIT socket用于新的TCP连接。默认为0，表示关闭。
net.ipv4.tcp_tw_recycle = 1            #开启TCP连接中TIME_WAIT socket的快速回收。默认值为0，表示关闭。

net.ipv4.tcp_max_syn_backlog = 262144  #表示SYN队列的长度，预设为1024，这里设置队列长度为262144，以容纳更多的等待连接。
net.ipv4.tcp_syncookies = 1            #开启SYN cookie，出现SYN等待队列溢出时启用cookie处理，防范少量的SYN攻击。默认为0，表示关闭。
net.core.somaxconn = 16384             #定义了系统中Accept队列长度, 即完成三次握手的连接数量，对于一个经常处理新连接的高负载web服务环境来说，默认值为128，偏小。

net.ipv4.tcp_keepalive_time = 600      #keepalived启用时TCP发送keepalived消息的频度。
net.ipv4.tcp_keepalive_probes = 5      #TCP发送keepalive探测以确定该连接已经断开的次数。根据情形也可以适当地缩短此值。
net.ipv4.tcp_keepalive_intvl = 15      #探测消息发送的频率，乘以tcp_keepalive_probes就得到对于从开始探测以来没有响应的连接杀除的时间。默认值为75秒。对于普通应用来说,这个值有一些偏大,可以根据需要改小.特别是web类服务器需要改小该值。
net.ipv4.ip_local_port_range = 1024 65000 #指定外部连接的端口范围。默认值为32768 61000。
net.ipv4.tcp_max_orphans = 16384       #表示系统中最多有多少TCP套接字不被关联到任何一个用户文件句柄上。如果超过这里设置的数字，连接就会复位并输出警告信息。这个限制仅仅是为了防止简单的DoS攻击。此值不能太小。 


Linux下IO模型有几种，各自的含义是什么。
阻塞IO：传统IO                             
非阻塞IO：用户线程不断轮询内核数据是否准备好了，长期占用cpu。       
多路复用IO：Reactor模式，由单个内核线程不断轮询多个socket channel状态。
信号驱动型IO：每个socket注册一个信号函数，当数据就绪时会发送一个信号给用户线程，然后用户线程进行IO读写。				   				   
异步IO：用户线程发起IO请求，立刻就可以去做自己的事情。用户线程和内核线程通过mmap映射同一块内存区域，内核会等待数据准备完成，然后将数据读取到共享内存。最后告知用户线程IO操作已经完成，可以直接使用数据了。                   


epoll和poll有什么区别。
poll:和select没啥区别。采用遍历fd的方式获取已经就绪的socket。因为是基于链表存储，所以没有单个线程监视文件描述符的数量限制。
	 仅支持水平触发模式，如果报告的fd没有被处理，下次轮询还是会报告该fd。
epoll:linux特有，支持水平触发和边缘触发；边缘触发:仅会通知一次fd就绪的消息，若没有处理，下次也不会通知了。
	 使用"事件"就绪通知方式，使用epoll_ctl注册fd，一旦该fd就绪，内核会调用callback回调机制激活fd，epoll_wait会收到通知。
	 没有并发连接限制(1G -> 10W连接)，不采用轮询方式。epoll采用mmap技术。
	 如果没有大量空闲连接，epoll效率和poll/select差不多


用一行命令查看文件的最后五行。
tail -n 5 filename
用一行命令查看文件的开头五行。
head -n 5 filename
查看文件的第三行到第五行
cat filename | tail -n +3 | head -n 5
将标准输出流和错误输出流都重定向到log
ls filename > log 2>&1


用一行命令输出正在运行的java进程。
jps


进程切换和线程切换的区别。
保护现场(保存程序计数器和相关寄存器)、恢复现场
虚拟内存：操作系统为每个进程提供的一种抽象，每个进程都有私有的、地址连续的虚拟内存。操作系统通过页表完成地址空间映射(虚拟内存映射物理内存)
		 页表存储在进程控制块PCB，切换页表以使用新的地址空间
进程切换：进程切换会导致虚拟内存的切换。虚拟内存映射到物理内存需要查找页表，为了加速查找，引入了缓存技术(快表TLB存放与单独的寄存器)加快查询，
		 显然每个进程都有属于自己的页表，进程切换后，缓存就失效了，导致缓存命中率降低，表现出来就是程序运行变慢。
线程切换：首先存储当前线程的本地数据(栈)，程序指针等，然后载入另一个线程的本地数据，程序指针等，最后才开始执行。线程切换不会导致虚拟内存的切换，所以代价低。

引起上下文切换的原因
1、时间片用完，CPU正常调度下一个任务
2、被其他优先级更高的任务抢占
3、执行任务碰到IO阻塞，调度器挂起当前任务，切换执行下一个任务
4、用户代码主动挂起当前任务让出CPU时间
5、多任务抢占资源，由于没有抢到被挂起
6、硬件中断


用户态切换到内核态的3种方式
1、系统调用
这是用户态进程主动要求切换到内核态的一种方式，用户态进程通过系统调用申请使用操作系统提供的服务程序完成工作，比如fork()创建新进程
2、异常
当CPU在执行运行在用户态下的程序时，发生了某些事先不可知的异常，这时会触发由当前运行进程切换到处理此异常的内核相关程序中，也就转到了内核态，比如缺页异常。
3、外围设备的中断
当外围设备完成用户请求的操作后，会向CPU发出相应的中断信号，这时CPU会暂停执行下一条即将要执行的指令转而去执行与中断信号对应的处理程序，如果先前
执行的指令是用户态下的程序，那么这个转换的过程自然也就发生了由用户态到内核态的切换。比如硬盘读写操作完成，系统会切换到硬盘读写的中断处理程序中执行后续操作。


子进程和父进程
相同：UID和GroupID，用户信息，目录信息，环境(表)，已打开的文件描述符，堆栈，共享内存等。
不同：进程号PID、父进程号、自己打开的文件描述符和目录流的拷贝、不继承父进程的进程正文(text)，数据和其他锁定内存(memory locks),不继承异步输入和输出

经过fork()以后，父进程和子进程拥有相同内容的代码段、数据段和用户堆栈，就像父进程把自己克隆了一遍。事实上，父进程只复制了自己的PCB块。而代码段、
数据段和用户堆栈内存空间并没有复制一份，而是与子进程共享。只有当子进程在运行中出现写操作时，才会产生中断，并为子进程分配内存空间。


top 命令之后有哪些内容，有什么作用。
进程号、进程所有者、进程名，ni静态优先级-20~19，越低优先级越高，pr动态优先级，virt进程使用的虚拟内存总量，shr共享物理内存大小，res进程使用的未被换出的物理内存大小
S进程状态， %CPU CPU使用率，%MEM 内存使用率，TIME 进程使用时间


source、sh、bash和.运行脚本有什么区别
./jiaoben.sh 需要脚本有执行权限，source、sh和bash不需要脚本有执行权限；source和.是在当前shell内执行脚本，同一个进程号，而sh和bash是另起一个进程执行脚本


僵尸进程和孤儿进程
僵尸进程:父进程还在运行，子进程却挂了，父进程没有使用wait来清理子进程信息，导致系统中还保留着一些子进程信息，浪费系统资源
孤儿进程:子进程还在运行，父进程却挂了，子进程会交给init(PID=1)进程统一管理，完成状态收集工作


linux下进程的五种状态
就绪状态，运行状态，中止状态，
可中断睡眠状态:进程未获得它所申请的资源而处在等待状态。一旦资源有效或者有唤醒信号，进程会立即结束等待而进入就绪状态。
不可中断睡眠状态:进程不能被信号量或者中断所唤醒，只有当它申请的资源有效时才能被唤醒。
僵死状态:僵尸进程，虽然线程已死亡，但是系统中还残留部分信息


多线程

多线程的几种实现方式，什么是线程安全。
继承Thread类、实现Runnable接口、实现Callable接口


volatile的原理，作用，能代替锁么。
不能代替锁。被volatile修饰的变量每次都从主存中读取，并且禁止指令重排序。volatile变量是一种比sychronized关键字更轻量级的同步机制


画一个线程的生命周期状态图。
就绪状态，运行状态，阻塞状态，结束状态
结束状态:程序正常执行完毕/调用stop(会释放锁)
阻塞状态:比如调用sleep(不会释放锁)，阻塞式IO读写，没有获得监视器，wait(释放锁)某个notify()，调用suspend(不会释放锁)，yield(不会释放锁)


sleep和wait的区别。
sleep不会释放锁，wait会释放锁


sleep和sleep(0)的区别。
sleep(long time) 线程在指定时间内不参与cpu竞争；sleep(0) 线程会从阻塞队列直接回到就绪队列，参与cpu竞争，是想让其他线程也有得到cpu运行的机会，


Lock(ReentrantLock)与Synchronized的区别 。
Synchronized是内置锁，处于jvm层面，Lock是java类；
Synchronized无法判断是否获取锁，Lock可以判断是否获取到锁；
Synchronized会自动释放锁，Lock需在finally中手工释放锁；
Synchronized会导致无法获得锁的线程一直等待，Lock可以tryLock(time)，若还不能获得锁则执行别的逻辑
Synchronized可重入、不可中断、非公平，Lock可重入、可中断、可公平、可不公平
Synchronized锁适合代码量少的同步问题，Lock锁适合代码量大的同步问题。

Synchronized是唤醒锁池里所有的线程+刚好来访问的线程,而ReentrantLock处于非公平状态，则唤醒当前释放锁线程的后一个线程+刚好来访问的线程，
若处于公平状态，则唤醒当前释放锁线程的后一个线程。因为ReentrantLock是基于CAS+AQS实现，AQS内部是FIFO的队列，每当新进来的线程没能获取锁，
便会加入到队列末尾，等待唤醒。


synchronized的原理是什么，一般用在什么地方(比如加在静态方法和非静态方法的区别，静态方法和非静态方法同时执行的时候会有影响吗)。
同步代码块是使用MonitorEnter和MoniterExit指令实现的，在编译时，MonitorEnter指令被插入到同步代码块的开始位置，MoniterExit指令被插入到同步代码块的结束位置和异常位置。
加在静态方法前锁定的是整个类，加在非静态方法前锁定的是当前对象。
修饰静态方法，锁是加在类上的，类的所有对象竞争一把锁;修饰非静态方法，锁加在单个对象上，不同对象间没有竞争关系。


解释以下名词：重排序，自旋锁，偏向锁，轻量级锁，可重入锁，公平锁，非公平锁，乐观锁，悲观锁。
重排序:编译器和处理器为了优化程序性能而对指令进行重新排序
自旋锁:为了编译线程上下文切换带来的损耗，所以让线程空等待
偏向锁:在没有实际竞争的情况下，自始至终都只有一个线程在使用锁，降低获取锁的消耗，仅要一次CAS操作
轻量级锁:无实际竞争，多个线程交替使用锁，允许短时间的锁竞争(自旋)
可重入锁:线程可以进入它拥有的锁所同步的代码块
悲观锁:假设一定会发生并发冲突，通过阻塞其他所有线程来保证数据的完整性。比如Synchronized
乐观锁:假设不会发生并发冲突，不加锁去完成某项更新，如果冲突就返回失败。比如CAS机制


公平锁和非公平锁有什么区别?
公平锁：线程严格按照先进先出(FIFO)的顺序, 获取锁资源。
非公平锁：拥有锁的线程在释放锁资源后, 当前线程可以和等待队列中的第一个线程竞争锁资源, 若当前线程竞争失败，则加入队列尾部。队列中的线程按照先进先出的顺序获取锁资源


用过哪些原子类，他们的原理是什么。
AtomicInteger、AtomicLong、AtomicBoolean，CAS


JUC下研究过哪些并发工具，讲讲原理。
CountDownLatch:使一个线程等待其他线程都执行完毕后才开始执行
CyclicBarrier:所有线程相互等待，只有当所有线程都到达某个点之后才能开始接着往下做
Semaphore:限制同一时刻访问某种资源的线程数量
Exchanger:交换器,两个线程到达同步点后交换数据


用过线程池吗，如果用过，请说明原理，并说说newCache和newFixed有什么区别，构造函数的各个参数的含义是什么，比如coreSize，maxsize等。
一般需要根据任务的类型来配置线程池大小：
如果是CPU密集型任务，就需要尽量压榨CPU，参考值可以设为核心数+1
如果是IO密集型任务，参考值可以设置为2*核心数

ThreadPoolExecutor的addThread(Runnable firstTask)方法用提交的firstTask任务创建一个Worker对象，然后调用线程工厂threadFactory创建一个
新的线程t，然后将线程t的引用赋值给Worker对象的成员变量thread，接着通过(HashSet<Worker>)workers.add(w)将Worker对象添加到工作集中。

ThreadPoolExecutor(......)
corePoolSize核心线程数量，maxsize核心线程+非核心线程数量，keepAliveTime非核心线程最大闲置时间，timeUnit时间单位，workQueue等待队列
threadFactory工厂方法，Reject拒绝机制
几种常用的线程池
CachedThreadPool():new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
				   核心线程为0，非核心线程数量几乎无限制，60秒限制销毁线程，等待队列为同步队列，出队和入队必须同时进行。
				   快速处理大量耗时较短的任务，如Netty的NIO接受请求时，可使用CachedThreadPool。
FixedThreadPool:new ThreadPoolExecutor(nThreads, nThreads,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
			    核心线程数为nThread，没有非核心线程，等待队列几乎无限制，可以存储大量任务。
			    可用于Web服务瞬时削峰，但需注意长时间持续高峰情况造成的队列阻塞。
SingleThreadPool:仅一个核心线程，一个一个的执行任务
ScheduledThreadPool:隔多久执行一个任务


线程池的关闭方式有几种，各自的区别是什么。
shutDownNow:线程池拒绝接收新提交的任务，同时立马关闭线程池，线程池里的任务不再执行。
shutDown:线程池拒绝接收新提交的任务，同时等待线程池里的任务执行完毕后关闭线程池。
awaitTermination 和 shutDown 配合使用


假如有一个第三方接口，有很多个线程去调用获取数据，现在规定每秒钟最多有10个线程同时调用它，如何做到。
ScheduledThreadPool + Semaphore


spring的controller是单例还是多例，怎么保证并发的安全。
Controller 默认情况下是单例模式


ThreadLocal用过么，用途是什么，原理是什么，用的时候要注意什么。
用于保存某个共享变量的副本，修改、删除不会影响别的线程。Thread类中有一个成员变量属于ThreadLocalMap类，一个定义在ThreadLocal类中的内部类
ThreadLocalMap<ThreadLocal，Object>成员变量，以Thread对象为key


如果让你实现一个并发安全的链表，你会怎么做。
ConcurrentLinkedQueue，Collections.synchronizedList()


有哪些无锁数据结构，他们实现的原理是什么。
CAS


讲讲java同步机制的wait和notify。
都是Object方法，只能在同步代码块中调用，wait释放锁、线程阻塞，notify唤醒等待在监视器上的线程，使之重新加入cpu竞争


CAS机制是什么，如何解决ABA问题。
AtomicStampedReference，加版本戳/时间戳


多线程如果线程挂住了怎么办。
因为wait挂住，需要等待notify/notifyAll才能进入可执行状态
因为sleep挂住，需要等待指定时间
因为join挂住，需要等待之前的线程都完成才能执行
因为suspend挂住，需要等待resume唤醒


countdownlatch和cyclicbarrier的内部原理和用法，以及相互之间的差别(比如countdownlatch的await方法和是怎么实现的)。
CountDownLatch等待前面的线程都完成之后，后面的线程才能开始执行，递减，不可重复利用
执行countdown的某个子线程可能会因为某些原因无法执行countdown，导致countDownLatch的倒计时不能减到0，await线程一直阻塞下去。
CyclicBarrier线程相互等待，直到所有线程都完成任务到达屏障点，再一块往下执行，递加，可重复利用


对AbstractQueuedSynchronizer了解多少，讲讲加锁和解锁的流程，独占锁和公平锁加锁有什么不同。
AQS定义两种资源共享方式:独占，只有一个线程能执行，如ReentrantLock；共享，多个线程可同时执行，如Semaphore。
AQS为Java中的并发同步组件提供统一的底层支持，关键点:同步状态和同步队列
同步状态state为0，说明当前锁已经被占，需要添加到同步队列中；同步状态state为1，说明线程可以获取到锁，共享锁state大于1
同步队列:它是一个双端队列，遵循FIFO原则，主要作用是用来存放在锁上阻塞的线程，当一个线程尝试获取锁时，如果已经被占用，那么当前线程就会被构造成一个Node
	    节点插入到同步队列的尾部。队列的头节点是成功获取锁的节点，当独占锁的头节点线程释放锁时，会唤醒其直接后继节点并释放当前头节点的引用；
	    当共享锁头节点释放锁，会唤醒其后面的所有节点 


使用synchronized修饰静态方法和非静态方法有什么区别。
修饰静态方法，锁定的是这个类，修饰非静态方法锁定的是这个对象


简述ConcurrentLinkedQueue和LinkedBlockingQueue的用处和不同之处。
LinkedBlockingQueue 是一个基于单向链表的、范围任意的（其实是有界的）、FIFO 阻塞队列。 
ConcurrentLinkedQueue是一个基于链节点的无界线程安全队列。


导致线程死锁的原因？怎么解除线程死锁。
在死锁时，线程间相互等待资源，而又不释放自身的资源，导致无穷无尽的等待，其结果是系统任务永远无法执行完成。
释放某个线程拥有的资源。


用过读写锁吗，原理是什么，一般在什么场景下用。
ReentrantReadWriteLock 适用读比写多的场景。基于AQS实现同步功能，将同步状态state掰成两份用，读与写互斥，支持重入，但是可以从写锁降级为读锁，反之不行


延迟队列的实现方式，delayQueue和时间轮算法的异同。
延迟一段时间后触发事件
delayQueue:采用PriorityQueue实现，二叉堆实现，在插入和获取时都是O(logn)
时间轮:一个轮子，有8个“槽”，可以代表未来的一个时间。如果以秒为单位，中间的指针每隔一秒钟转动到新的“槽”上面，就好像手表一样。如果当前指针指在1上面，
	  我有一个任务需要4秒以后执行，那么这个执行的线程回调或者消息将会被放在5上。采用数组或者环形链表实现。
DelayQueue由于涉及到排序，需要调堆，插入和移除的复杂度是O(lgn)，而时间轮在插入和移除的复杂度都是O(1)。


TCP与HTTP

http1.0和http1.1有什么区别。
缓存处理，1.1引入了更多的缓存控制策略；
带宽优化，1.1允许只请求资源的某个部分；
新增错误码，1.1新增了24个错误状态响应码；
Host头处理，HTTP1.1的请求消息和响应消息都应支持Host头域，一台服务器上可能有多台虚拟服务器共享ip，所以请求需要带hostname
长连接，1.1默认开启keep-alive，一定程度上弥补了HTTP1.0每次请求都要创建连接的缺点。


TCP三次握手和四次挥手的流程，为什么断开连接要4次,如果握手只有两次，会出现什么。
FIN_WAIT1 ---FIN M--->  CLOSE_WAIT

FIN_WAIT2 <--ACK M+1--

TIME_WAIT <---FIN N---   LAST_ACK

          --ACK N+1-->   CLOSED
断开的时候，只有当服务器端所有的报文都发送完了，它才能发送FIN报文，因此不能一起发送。故需要四步握手。
如果只有两次握手，可能会导致服务器端建立一些实际不应该建立的连接。比如服务器接收到本来以为已经丢失的数据报，就会返回客户端一个syn和ack消息，
然后服务器认为我已经建立了一个新连接，其实根本没有人来连接服务器，白白浪费资源。
如果是三次建立连接，服务端需要等待客户端的确认，而客户端并不会发送ack，所以就不会建立连接。


TIME_WAIT和CLOSE_WAIT的区别。
TIME_WAIT位于客户端FIN_WAIT1和FIN_WAIT2之后，他需要等待2msl(最大报文生存时间)时长......
CLOSE_WAIT位于服务端接收到FIN_WAIT1发来FIN之后
TIME_WAIT状态用来重发可能丢失的ACK报文。 
TIME_WAIT表示主动关闭，CLOSE_WAIT表示被动关闭。


说说你知道的几种HTTP响应码，比如200, 302, 404。
200 ok  一切正常 
301  永久重定向
302/303  暂时性转移 重定向
4xx(客户端请求错误)  	
400  服务器不理解请求的语法
404  页面未找到 
5xx (服务器错误)


当你用浏览器打开一个链接（如：http://www.javastack.cn）的时候，计算机做了哪些工作步骤。
请求dns服务器解析域名得到请求主机ip，发起tcp建立请求，然后发起http请求，服务器接收http请求并处理，服务器响应，返回html，浏览器对页面进行渲染，断开连接


TCP/IP如何保证可靠性，说说TCP头的结构。
如何保证可靠性：
1、收到发送端发出数据包会返回确认信号ACK。
当接收端接收到来自发送端的数据包之后，会返回一个已收到消息的ACK(序列号+1)

2、针对数据包丢失或者出现超时的重发机制。
情况一、数据包丢失：重发即可
情况二、接收端ACK丢失：会导致接收端收到重复数据包，造成网络资源浪费，需要引入滑动窗口机制
超时时间：TCP在每次发包时都会计算往返时间及其偏差，将这个"往返时间+偏差"，重发超时就是比这个总和值要稍大一点的值。
MSS：最大消息长度，在建立TCP连接时，确定发送单个数据包的大小(选择发送端和接收端能适应的较小的MSS值)。最理想的情况是，最大消息长度MSS正好是网络层中不被分包处理的最大数据长度。

3、针对数据包到达接收端主机顺序乱掉的顺序控制。
发送端要发送的数据由很多数据包构成。网络层仅保证单个数据包完整性，若传输层发给网络层的数据包过大，会被分包，到达接收端网络层会被组包，只有一个
完整的数据包才会被交给传输层，否则会被丢弃。网络层不保证数据包一定到达，需要传输层保证，所以TCP有超时重传机制。
TCP数据包都有序列号，即使B比A先到达了，也会等A到达之后，先把A提交给应用层，再把B提交给应用层，从而保证同一条TCP链接，先发的包先到。
UDP数据包没有序列号，所以不会将网络层乱序到达的数据包按顺序排序，需要应用层自己排序。

4、针对高效传输数据包的滑动窗口控制。
ACK不再以每个段(比如1~1000、1001~2000)为单位进行确认了，发送端在发送了一个段之后，没必要一直等待对端主机的确认应答信号，而是继续发送。
窗口大小，指的就是无需等待接收端返回ACK而可以持续发送的数据的最大值。
滑动窗口左外侧是已经确认对端收到的数据，右外侧是还未发送的数据。当收到ACK信号之后，会把滑动窗口的位置滑动到确认应答的序列号的位置。
若发生数据丢包：
情况一、数据包丢失。比如接收端没收到1001~2000这段数据，接收端会一直返回"下一次数据是1001"提醒发送端缺失了哪一段数据。
情况二、ACK确认号丢失。比如接收端没有成功发送"已成功接收1001~2000"段数据，只要下一次接收端返回给发送端"已成功接收2001~3000"段数据，就能反推出之前的数据其实已经被收到了。

5、针对避免网络拥堵时候的流量控制。
可以让发送端根据接收端的实际接收能力来控制自己发送的数据量。接收端的缓冲区一旦面临数据溢出，就会主动减小窗口的大小再次发送给发送端，从而可以控制数据发送量
若接收端缓冲区满了之后会把窗口大小设置为0，发送端会停止发送数据直到接收端通知(发送端也会时不时的发送一个叫做"探测窗口"的数据包，仅包含一个字节，以获取最新的窗口大小)

6、针对避免刚开始启动的时候一下子发送大量数据包而导致网络瘫痪的慢启动算法和拥塞控制。
在通信一开始的时候会使用"慢启动"算法对发送的数据量进行控制。为了在发送端调节所要发送的数据量，定义了一个叫做"拥塞窗口"的概念。在慢启动刚开始的
时候，把这个拥塞窗口设置为1个MSS（1个最大消息长度）发送数据，随着数据包的每次成功往返，拥塞窗口会以1、2、4、8形式增长，直到到达上限。
当发生超时时，会把拥塞窗口上限设置为原来的一半，拥塞窗口回到最小值1MSS。	
然后，在发送数据的时候，把拥塞窗口和滑动窗口的大小作比较，按照它们当中较小的那个值来发送比其还要小的数据量。

TCP头结构：
源端口，目的端口，序列号，确认号，首部长度字段，六位标志位，窗口大小，校验和，紧急指针


如何避免浏览器缓存。
请求头中设置Cache-Control:max-age=0，告诉浏览器不要缓存信息
POST请求无法被缓存；动态请求不能被缓存

动态请求和静态请求、动态页面和静态页面
html、htm后缀结尾是静态页面，ASP、PHP、JSP、ASP.net、Perl、或CGI结尾是动态页面
静态页面网页不包含在服务器端运行的任何脚本，网页上的每一行代码都是由网页设计人员预先编写好后，放置到Web服务器上的，在发送到客户端浏览器之后不再发生任何变化。
动态页面实际上并不是独立存在于服务器上的网页文件，只有当用户请求时服务器才返回一个完整的网页；
动态页面上的内容存在于数据库中，根据用户发出的不同请求，其提供个性化的网页内容；
动态页面内容不是存在于页面上，而是在数据库中，从而大大降低网站维护的工作量；
采用动态网页技术的网站可以实现更多的功能，如用户注册、用户登录、在线调查、用户管理、订单管理等等，静态页面则无法实现这些功能。


如何理解HTTP协议的无连接和无状态性。
无连接:请求时建连接、请求完释放连接，以尽快将资源释放出来服务其他客户端。但是因为现在网页变得越来越复杂，里面可能嵌入了很多图片，这时候每次访问图片都需要
	  建立一次 TCP 连接就显得很低效。Keep-Alive 功能使客户端到服务器端的连接持续有效，当出现对服务器的后继请求时，Keep-Alive 功能避免重新建立连接。
无状态:协议对于事务处理没有记忆能力，服务器不知道客户端是什么状态。即我们给服务器发送 HTTP 请求之后，服务器根据请求，会给我们发送数据过来，但是发送完，
	  不会记录任何信息。但是当大量客户端与服务器进行动态交互的 Web 应用程序出现之后，引入了cookie和session。


简述Http请求get和post的区别以及数据包格式。
get请求将参数放置于url后面，post请求将参数放在请求体里，更安全；
get提交的数据最多1024字节，post能传输的数据量很大。


HTTP有哪些method
get、post、put、delete、head、options、trace、patch


简述HTTP请求的报文格式。
请求报文:请求行(请求方法、url、http版本)、请求头(一堆的键值对)、请求体(get方法没有请求体，post方法有请求体)
响应报文:响应行(http版本、状态码、状态码描述符)、响应头(一堆键值对)、响应体(服务器返回给客户端的文本信息)


HTTP的长连接是什么意思。
HTTP1.1规定了默认保持长连接，数据传输完成了保持TCP连接不断开（不发RST包、不四次握手），等待在同域名下继续用这个通道传输数据
keepalived,不要断开连接，后续如果还有请求，直接在当前连接上请求。


HTTPS的加密方式是什么，讲讲整个加密解密流程。
HTTPS 443端口，HTTP+SSL/TLS
客户端发起https请求。
采用HTTPS协议的服务器必须要有一套数字证书，可以自己制作，也可以向组织申请。
传送证书给客户端，这个证书其实就是公钥，只是包含了很多信息，如证书的颁发机构，过期时间等等。
客户端解析证书，验证该证书是否有效，如果证书没有问题，那么就生成一个随机值，然后用证书对该随机值进行加密。
传送加密信息，让服务端得到这个随机值，以后客户端和服务端的通信就可以通过这个随机值来进行加密解密了。
服务端用私钥解密后，得到了客户端传过来的随机值(私钥)，然后把要传输的内容通过该值进行对称加密。除非知道私钥，不然无法获取内容。


Http和Https的三次握手有什么区别。
当浏览器使用https时，浏览器会先同SSL/TLS进行通信，然后SSL/TLS再同tcp进行通信


REST和RPC的区别
REST是面向资源的（URL表示资源，HTTP动词表示动作），RPC是面向动作的（方法调用）
RPC的编程模型较重量级，REST的编程模型更轻量级
RPC 自定义tcp+json 传输更轻量化， rest http报文会包含很多无用的信息，效率低
对外开放的api采用rest，内部通信采用rpc


Session和cookie的区别。
Session 存放在服务器端的客户端信息，通过sessionID进行标识，客户端每次访问都要带着这个id(通过cookie或者url重写)。会占用服务器性能
Cookie 服务端存放在客户端的信息，不是很安全



消息队列

消息队列的使用场景。
异步处理、应用解耦、流量削峰、日志处理


如何保证消息的有序性。
思路：1)单线程消费来保证消息的顺序性；
     2)对消息进行编号，消费者处理时根据编号判断顺序。 
RabbitMQ、Kafka和RocketMQ采用思路一
MQ里创建多个queue，有顺序要求的数据按顺序放入同一queue，同一个消费者从该queue一个一个消费数据；
MQ只创建一个queue，仅对应一个消费者，消费者内部维护一个队列，按顺序处理数据；
ActiveMQ采用思路二
activeMq 里面有 messageGroups 属性，可以指定 JMSXGroupID，消费者会消费指定的 JMSXGroupID。即保证了顺序性，又解决负载均衡的问题。


消息队列的推拉模式(push/pull)
push模式：由消息中间件主动地将消息推送给消费者。采用push模式可以尽可能快地将消息发送给消费者。
但是如果消费者的处理消息的能力很弱(一条消息需要很长时间处理)，而消息中间件不断地向消费者Push消息，消费者的缓冲区可能会溢出。
改进方法：可以规定一次最多向消费者Push(推送)多少条消息。
pull模式：由消费者主动向消息中间件拉取消息。采用pull模式会增加消息的延迟，即消息到达消费者的时间有点长。



用过哪些MQ，和其他mq比较有什么优缺点，MQ的连接是线程安全的吗，你们公司的MQ服务架构怎样的。
ActiveMQ：成熟的产品，协议支持好。大规模应用场景有待考证，社区不活跃。
RocketMQ：性能优秀，支持多种消费，集群消费、广播消费等。产品较新，缺少文档，对已有系统而言不能兼容。
RabbitMQ：基于erlang天生支持高并发，性能较好，已经得到大规模应用场景验证，社区活跃。集群不支持动态扩展。
RabbitMQ的消息类型：
1、simple简单队列
某个队列只有一个消费者，不常用
2、Fair dispatch公平分发
公平的意思是 消费者消费消息的多少，完全取决于消费者的处理能力，能者多劳。消费端消费数据时，会有一个确认消费完成的动作，mq收到消费完成的通知后，
才会继续向该消费者发送消息，因此，如果消费者处理速度快，那么最终mq向它发送的消息就多，如果消费者处理的慢，mq向它发送的消息就少。
3、Round-robin轮询分发
所谓轮询分发，就是Fair dispatch公平分发的退化版，开启自动通知，去掉消费端消费条数限制。mq根据一个简单的规则(比如取模运算)，先确定好哪些消息发送给
哪些消费者，无论消费者处理能力如何，这些消息都得让你处理，因此每个消费者最终处理的消息数量是相同的。
该模式存在一些明显的缺点：不能很好的利用消费端的性能差异，做不到真正意义上的负载均衡，浪费资源；其次（只是猜测），这种模型还有可能造成大量消息堆积在
					 消费者容器中，这是非常危险的，不仅会造成消息丢失，还有可能压垮消费者。
4、publish_subscribe发布订阅模式
RabbitMQ 中有一个交换机Exchanges的概念，发布订阅就是通过交换机实现的。交换机的概念非常简单，就是一个转发器，有了交换机之后，生产端先把消息发送到
交换机，然后交换机再把消息发送到与其绑定的消息队列，这样就解决了生成端如何把一条消息批量发送到多个消息队列的问题。
实现发布订阅的关键在于：
生产端(发布端)直接发送消息到交换机，而不是具体的消息队列。
多个消费端(订阅端)将自己的消息队列绑定到同一个交换机上。
5、routing路由模式
基于发布订阅之上增加些新功能。在发布订阅模式中，交换机无脑向所有与之绑定的消息队列发送消息，而路由模式对交换机做了一些限制，它指定了一个route key，
生产端向交换机发送消息时，指定消息的route key。消费端将消息队列绑定到交换机时，也指定该队列消费的route key。这样一来，交换机就可以根据消息的route key，
将该消息转发到绑定该route key的消息队列。
6、topic主题模式
路由模式的一个加强：route key支持通配符。
消费端route key不用写死，增加了一个模糊匹配的功能，这样在某些场景下，消费端就不用逐一绑定所有监听的route key，直接用抽象的通配符表示即可


MQ系统的数据如何保证不丢失。
生产者 -> MQ -> 消费者
1)消费者实例宕机的时候，如何保障数据是不会丢失？
消费者收到一个消息会发送ack给MQ，MQ收到ack之后才会删除这个消息，如果消费者还没发送ack，消费者自己就宕机了，MQ会认为消费者宕机，就会重新投递
这条消息给其他的消费者实例。通过这种机制保证消费者实例宕机时，数据不会丢失。
2)如何保证生产者投递到消息中间件(MQ)的消息不丢失？
生产者需要开启confirm模式，投递消息到MQ，如果MQ将消息持久化到磁盘之后，必须要回传一个confirm消息给生产者。如果生产者接收到了confirm消息，就
知道已经持久化到磁盘了。如果没有接收到confirm消息，就说明这条消息可能丢失了，此时需要重新投递消息到MQ，确保消息不要丢失。


rabbitmq如何实现集群高可用。
单一模式、普通模式、镜像模式
单一模式：最简单、非集群模式
普通模式：默认的集群模式。消息实体只存在于其中一个节点rabbit01(或者rabbit02)，rabbit01和rabbit02两个节点仅有相同的元数据，即队列的结构。
当消息进入rabbit01节点的Queue后，consumer从rabbit02节点消费该消息时，RabbitMQ会临时在rabbit01、rabbit02间进行消息传输，把rabbit01中的
消息实体取出并经过rabbit02发送给consumer。所以consumer应尽量连接每一个节点，不然只能从特定的服务器上取数据。当rabbit01节点故障后，rabbit02
无法获取rabbit01中的消息。如果做了消息持久化，那么得等rabbit01节点恢复，然后才可被消费；如果没有持久化的话，就会产生消息丢失的现象。
镜像模式：消息实体会主动在节点间同步，而不是在consumer取数据时临时拉取。该模式带来的副作用也很明显，除了降低系统性能外，如果镜像队列数量
过多，加之大量的消息进入，集群内部的网络带宽将会被这种同步通讯大大消耗掉。难以水平扩展


kafka为什么那么快?
一、写入数据角度
1、采用顺序写入方式：kafka的消息是不断追加到文件中的，这个特性使kafka可以充分利用磁盘的顺序读写性能。
2、采用MMap(Memory Mapped Files)：内存和磁盘建立映射，在指定内存中写入数据后，操作系统会帮你写入磁盘。
3、分区：kafka的topic中的内容可以被分为多份partition,每个partition又分为多个segment,每次操作仅针对一部分，增加并行操作的能力。

二、读取数据角度
1、基于sendfile实现zero copy(零拷贝):通过sendfile这个系统调用，减少内核空间和用户空间的数据拷贝次数。
2、PageCache页缓存：将磁盘中的数据缓存到内存中，把对磁盘的访问变为对内存的访问。读取数据时首先查看数据是否在页缓存中，没有命中再去磁盘找。
3、批量压缩：为减少网络传输量，kafka将多个消息一起压缩以提高压缩率。
-----------------
传统的网络I/O操作流程如下：
1. OS从硬盘把数据读到内核缓冲区。
2. 用户进程把数据从内核缓冲区拷贝到用户缓冲区。
3. 然后用户进程再把数据写入到内核与Socket相关的缓冲区。
4. OS再把数据从Socket缓冲区拷贝到网卡，完成一次发送。
-----------------
基于sendfile实现zero copy后的运行流程如下：
1、sendfile系统调用，文件数据被copy至内核缓冲区
2、再从内核缓冲区copy至内核中socket相关的缓冲区
3、最后再socket相关的缓冲区copy到协议引擎


kafka 和其他消息队列的区别，kafka 主从同步怎么实现。
Producer ：消息生产者，就是向 kafka broker 发消息的客户端
Consumer ：消息消费者，向 kafka broker 取消息的客户端
Topic ：每条发布到Kafka集群的消息都有一个类别，这个类别被称为Topic
Broker ：一台 kafka 服务器就是一个 broker。一个集群由多个 broker 组成。一个 broker 可以容纳多个 topic。
Partition：为了实现扩展性，一个非常大的 topic 可以分布到多个 broker（即服务器）上。每个 partition 是一个有序的队列。partition 中的每条消息
都会被分配一个有序的 id（offset）。kafka 只保证按一个 partition 中的顺序将消息发给 consumer，不保证一个 topic 的整体(多个partition间)的顺序。

kafka具有高的吞吐量，内部采用消息的批量处理，zero-copy机制，数据的存储和获取是本地磁盘顺序批量操作，具有O(1)的复杂度，消息处理的效率很高。
rabbitMQ在吞吐量方面稍逊于kafka，但是支持对消息的可靠传递，支持事务，不支持批量的操作；可以采用内存或者硬盘进行持久化。
kafka的broker支持主备模式。rabbitMQ支持miror的queue，主queue失效，miror queue接管。
kafka采用zookeeper对集群中的broker、consumer进行管理，可以注册topic到zookeeper上；通过zookeeper的协调机制，producer保存对应topic的broker
信息，可以随机或者轮询发送到broker上；并且producer可以基于语义指定分片，消息发送到broker的某分片上。rabbitMQ的负载均衡需要单独的loadbalancer进行支持。

kafka 主从同步：leader和follower。创建副本的单位是topic的Partition，每个Partition都有一个leader和零或多个followers.所有的读写操作都由
leader处理，一般Partition的数量都比broker的数量多的多，各分区的leader均匀的分布在brokers中。所有的followers都复制leader的日志，日志中的
消息和顺序都和leader中的一致。flowers像普通的consumer那样从leader那里拉取消息并保存在自己的日志文件中。

Kafka判断一个节点是否活着有两个条件：
1、节点必须可以维护和ZooKeeper的连接，Zookeeper通过心跳机制检查每个节点的连接。
2、如果节点是个follower,他必须能及时的同步leader的写操作，延时不能太久。


利用mq怎么实现最终一致性。
CAP理论(一致性、可用性、分区容错性)，不可能都满足
在互联网领域的绝大多数场景，都需要牺牲强一致性来换取系统的高可用性，系统往往只需要保证“最终一致性”，只要这个最终时间是在用户可以接受的范围内即可。
生产者 ->  MQ -> 消费者
1)生产者给MQ发送事务消息，MQ收到消息后返回ACK，并暂时设置该消息对Consumer不可见
2)生产者开始执行本地事务逻辑，若执行成功则告知MQ确认该消息并push给消费者，若不成功则告知MQ删除该消息
3)若MQ发送消息给消费者，消费者开始执行本地事务逻辑，如果执行成功则向MQ返回"消费成功"，反之出现异常则需要返回"消费失败"，以便MQ再次Push该消息


MQ有可能发生重复消费，如何避免，如何做到幂等。
生产者 -> MQ 重复发送
此时重发是生产者发起的。
对每条消息，MQ系统内部必须生成一个inner-msg-id，作为去重和幂等的依据，全局唯一，业务无关性，对消息发送方和消息接收方屏蔽。
MQ -> 消费者
此时重发是MQ-server发起的。
业务消息体中，必须有一个biz-id，全局唯一，对MQ透明，与业务相关，比如支付id、订单id，由消费者自己负责判重、保证幂等性。


MQ消息可以设置过期时间么，过期了你们一般怎么处理？MQ快满了如何处理？
RabbitMQ消息可以设置过期时间。手动找出过期数据，批量重导。
修复消费者，紧急扩容MQ，新建topic，partition*10，queue*10，consumer*10


缓存

Redis为什么这么快
1、完全基于内存，绝大部分请求是纯粹的内存操作，非常快速。
2、采用单线程，避免了不必要的上下文切换和竞争条件，也不存在多进程或者多线程导致的切换而消耗 CPU；
3、使用多路I/O复用模型，非阻塞IO；
4、使用底层模型不同，它们之间底层实现方式以及与客户端之间通信的应用协议不一样，Redis直接自己构建了VM 机制 ，因为一般的系统调用系统函数的话，会浪费一定的时间去移动和请求；


常见的缓存策略有哪些，如何做到缓存(比如redis)与DB里的数据一致性，你们项目中用到了什么缓存系统，如何设计的。
缓存策略的分类：
           1）基于访问的时间：此类算法按各缓存项被访问时间来组织缓存队列，决定替换对象。如LRU
           2）基于访问频率：此类算法用缓存项的被访问频率来组织缓存。如LFU、LRU2、2Q、LIRS。
           3）访问时间与频率兼顾：通过兼顾访问时间和频率。使得数据模式在变化时缓存策略仍有较好性能。如FBR、LRUF、ALRFU。
		     多数此类算法具有一个可调或自适应参数，通过该参数的调节使缓存策略在基于访问时间与频率间取得一个平衡。
           4）基于访问模式：某些应用有较明确的数据访问特点，进而产生与其相适应的缓存策略。如专用的VoD系统设计的A&L缓存策略，同时适应随机、顺序两种访问模式的SARC策略。

思路：保持缓存的"新鲜性"，每当数据发生变化的时候（数据被修改，或被删除的情况下），要同步更新缓存信息，确保用户不会在缓存取到旧的数据。
解决办法：对于读操作，若缓存没有命中，读取数据库，然后将数据set到缓存；
		 对于写操作，先删除相应缓存，然后修改数据库，下次查询该条数据时再将其加入缓存。


如何防止缓存穿透、缓存击穿、缓存雪崩和缓存刷新。
缓存穿透：收到一个请求，但是该请求缓存中不存在，只能去数据库中查询，然后放进缓存。但当有好多请求同时访问同一个数据时，业务系统把这些请求全发到
了数据库；或者恶意构造一个逻辑上不存在的数据，然后大量发送这个请求，这样每次都会被发送到数据库，最终导致数据库挂掉。
1)最常见是采用布隆过滤器，将所有可能存在的数据哈希到一个足够大的bitmap中，一个一定不存在的数据会被这个bitmap拦截掉，不要发送到数据库；
2)缓存空结果，就是对查询不存在的数据也记录在缓存中，这样就可以有效的减少查询数据库的次数。

缓存击穿：对于热点数据，当缓存失效的一瞬间，所有的请求都被下放到数据库去请求更新缓存，数据库被压垮。
1)加全局锁，就是所有访问某个数据的请求都共享一个锁，获得锁的那个才有资格去访问数据库，其他线程必须等待。但现在大部分系统都是分布式的，
本地锁无法控制其他服务器也等待，所以要用到全局锁，比如Redis的setnx实现全局锁。
2)对即将过期的数据进行主动刷新，比如新起一个线程轮询数据，或者把所有的数据划分为不同的缓存区间，定期分区间刷新数据。

缓存雪崩：当我们给所有的缓存设置了同样的过期时间，当某一时刻，整个缓存的数据全部过期了，然后瞬间所有的请求都涌向了数据库，数据库就崩掉了。
划分更小的缓存区间，按区间过期；要么给每个key的过期时间加一个随机值，避免同时过期，达到错峰刷新缓存的目的。

缓存刷新：一般在insert、update、delete操作后就需要刷新缓存，如果不执行就会出现脏数据。但当缓存请求的系统崩掉后，返回给缓存的值为null。


缓存更新策略。
对时效性要求高的缓存数据，但发生变更的时候，直接采取数据库和Redis/MemCached(分布式)缓存双写方案，提高缓存时效性
对时效性不高的数据，当发生变更之后，采用MQ异步通知的方式，通过数据生产服务来监听MQ消息，然后异步拉取数据库数据更新tomcat jvm(本地缓存)和
Redis/MemCached(分布式)缓存，本地缓存过之后就可以从redis中拉取新的数据更新nginx缓存。


缓存数据过期检测。
定时扫描：将每个设置了过期时间的key放到一个独立的hash中，默认每秒定时遍历这个hash而不是整个空间
惰性策略：客户端访问的时候，会对这个key的过期时间进行检查，如果过期了就立即删除。


redis的list结构相关的操作。
lpush，lpop，rpush，rpop，llen，lrange，


Redis的数据结构都有哪些。
String、List、Hash、Set、Sorted Set


Redis的使用要注意什么，讲讲持久化方式，内存设置，集群的应用和优劣势，淘汰策略等。
使用注意：1)从数据存储方面考虑
		 在能表达业务含义的基础上，尽可能缩减key长度；在不影响使用的情况下，缩减value大小，比如value是文本或者图像，可以压缩之后在存入redis，
		 value是序列化对象，可以考虑不序列化非必要的业务属性。
		 减少键值对的数量，对于大量的String类型的小对象，可以尝试使用Hash的形式组合他们，在Hash对象内Field数量少于1000，且Value的字符长度
		 小于40时，内部使用ziplist的编码形式，能够极大的降低小对象占据的内存空间。
		 Redis内维护了一个[0-9999]的整数对象池，类似Java内的运行时常量池，只创建一个常量，使用时都去引用这个常量，所以当存储的value是这个
		 范围内的数字时均是引用同一个内存地址，所以能够降低一些内存空间耗费。
		 2)从数据访问方面考虑
		 redis是数据库，所以也需要"连接"数据库。
		 复用连接，将多次查询合并成一次查询，PipeLine,批量的将数据写入redis，允许一定比例的写入失败
		 对于多次String类型的查询，使用mget，将多次请求合并为一次，能有效提高响应速度
		 对于Hash内多个Field查询，使用hmget，起到和mget同样的效果
持久化方式：RDB时间点快照；AOF记录服务器执行的所有写操作命令，并在服务器启动时，通过重新执行这些命令来还原数据集
内存设置： maxmemory used_memory
虚拟内存： vm-enabled yes


redis2和redis3的区别，redis3内部通讯机制。
集群方式的区别：Redis3采用Cluster，Redis2采用客户端分区方案和代理方案
通信过程说明：
1）集群中的每个节点都会单独开辟一个TCP通道，用于节点之间彼此通信，通信端口号在基础端口上加10000。
2）每个节点在固定周期内通过特定规则选择几个节点发送ping消息。
3）接收到ping消息的节点用pong消息作为响应。


当前redis集群有哪些玩法，各自优缺点，场景。
 1）数据共享：Redis提供多个节点实例间的数据共享，也就是 Redis A,B,C 彼此之间的数据是同步的，同样彼此之间也可以通信，而对于客户端操作的keys
 是由Redis系统自行分配到各个节点中。
 2）主从复制：Redis的多个实例间通信时，一旦其中的一个节点故障，那么Redis集群就不能继续正常工作，所以需要一种复制机制（Master-Slave）机制，
做到一旦节点A故障了，那么其从节点A1和A2就可以接管并继续提供与A同样的工作服务，当然如果节点A,A1,A2节点都出现问题，那么同样这个集群不会继续
保持工作，但是这种情况比较罕见，即使出现了，也会及时发现并修复使用。建议：部署主从复制机制（Master-Slave）。
 3）哈希槽值：Redis集群中使用哈希槽来存储客户端的keys，而在Redis中，目前存在16384个哈希槽，它们被全部分配给所有的节点，正如上图所示，
所有的哈希槽值被节点A，B，C分配完成了。


redis哨兵模式
Redis提供了哨兵的命令，哨兵是一个独立的进程。通过发送命令，让Redis服务器返回监控其运行状态，包括主服务器和从服务器。
当哨兵监测到master宕机，会自动将slave切换成master，而不用人工干预，然后通过发布订阅模式通知其他的slave服务器，修改配置文件，让它们切换主机。
故障切换（failover）的具体过程：
假设master服务器宕机，哨兵1先检测到这个结果，系统并不会马上进行failover过程，因为仅仅是哨兵1主观的认为master服务器不可用，这个现象成为主观
下线。当后面的哨兵也检测到master服务器不可用，并数量达到一定值时，那么哨兵之间就会进行一次投票，是否进行failover操作。切换成功后，就会通过发
布订阅模式，让各个哨兵把自己监控的从服务器实现切换主机，这个过程称为客观下线。


Memcache的原理，哪些数据适合放在缓存中。
MemCache的数据存放在内存中，最大键长为250字节，可以接受的储存数据不能超过1MB(Redis 键值均为512MB)
1）访问数据的速度比传统的关系型数据库要快，因为Oracle、MySQL这些传统的关系型数据库为了保持数据的持久性，数据存放在硬盘中，IO操作速度慢
2）MemCache的数据存放在内存中同时意味着只要MemCache重启了，数据就会消失
3）既然MemCache的数据存放在内存中，那么势必受到机器位数的限制，32位机器最多只能使用4GB的内存空间，64位机器可以认为没有上限。
变化频繁、不需要实时入库、可靠性要求不高的数据(比如用户在线状态、在线人数..)门户网站的新闻等，觉得页面静态化仍不能满足要求，可以放入到memcache中.(配合jquey的ajax请求)。


redis和memcached 的内存管理的区别。
MongoDB其实只是一种非关系型数据库，其优势在于可以存储海量数据，具备强大的查询功能，因此不宜用于缓存数据的场景。
Memcached单个key-value大小有限，一个value最大只支持1MB，而Redis最大支持512MB
Memcached只是个内存缓存，对可靠性无要求；而Redis更倾向于内存数据库，因此对可靠性方面要求比较高
1)性能上：
性能上都很出色，具体到细节，由于Redis只使用单核，而Memcached可以使用多核，所以平均每一个核上Redis在存储小数据时比Memcached性能更高。
而在100K以上的数据中，Memcached性能要高于Redis，虽然Redis最近也在存储大数据的性能上进行优化，但是比起 Memcached，还是稍有逊色。

2)内存空间和数据量大小：
MemCached可以修改最大内存，采用LRU算法。Redis增加了VM的特性，突破了物理内存的限制。

3)操作便利上：
MemCached数据结构单一，仅用来缓存数据，而Redis支持更加丰富的数据类型，也可以在服务器端直接对数据进行丰富的操作,这样可以减少网络IO次数和数据体积。

4)可靠性上：
MemCached不支持数据持久化，断电或重启后数据消失，但其稳定性是有保证的。Redis支持数据持久化和数据恢复，允许单点故障，但是同时也会付出性能的代价。

5)应用场景：
Memcached：动态系统中减轻数据库负载，提升性能；做缓存，适合读多写少，大数据量的情况（如大量查询用户信息、好友信息、文章信息等）。
Redis：适用于对读写效率要求都很高，数据处理业务复杂和对安全性要求较高的系统（如新浪微博的计数和微博发布部分系统，对数据安全性、读写要求都很高）。


Redis的并发竞争问题如何解决，了解Redis事务的CAS操作吗。
Redis为单进程单线程模式，采用队列模式将并发访问变为串行访问。Redis本身没有锁的概念，Redis对于多个客户端连接并不存在竞争，但是在Jedis客户端
对Redis进行并发访问时会发生连接超时、数据转换错误、阻塞、客户端关闭连接等问题，这些问题均是由于客户端连接混乱造成。对此有2种解决方法：
【1】客户端角度，为保证每个客户端间正常有序与Redis进行通信，对连接进行池化，同时对客户端读写Redis操作采用内部锁synchronized。
【2】服务器角度，利用setnx实现锁。MULTI，EXEC，DISCARD，WATCH 四个命令是 Redis 事务的四个基础命令。其中：
☆ MULTI，告诉 Redis 服务器开启一个事务。注意，只是开启，而不是执行
☆ EXEC，告诉 Redis 开始执行事务
☆ DISCARD，告诉 Redis 取消事务
☆ WATCH，监视某一个键值对，它的作用是在事务执行之前如果监视的键值被修改，事务会被取消、无法执行。可以通过watch实现乐观锁


redis的持久化的机制，aof和rdb的区别。
一种是RDB持久化（将Reids在内存中的数据库记录定时dump到磁盘上的RDB文件），另外一种是AOF持久化（将Reids的操作日志以追加的方式写入文件）。
区别：RDB持久化是指在指定的时间间隔内将内存中的数据集快照写入磁盘，实际操作过程是fork一个子进程，先将数据集写入临时文件，写入成功后，再替换之前的文件，用二进制压缩存储。
	 AOF持久化以日志的形式记录服务器所处理的每一个写、删除操作，查询操作不会记录，以文本的方式记录，可以打开文件看到详细的操作记录。
RDB性能最大化。对于Redis的服务进程而言，在开始持久化时，它唯一需要做的只是fork出子进程，之后再由子进程完成这些持久化的工作，这样就可以极大的避免服务进程执行IO操作了。
如果你想保证数据的高可用性，即最大限度的避免数据丢失，那么RDB将不是一个很好的选择。因为系统一旦在定时持久化之前出现宕机现象，此前没有来得及写入磁盘的数据都将丢失。


redis的集群怎么同步数据的。
1）master可以有多个slave
2）除了多个slave连到相同的master外，slave也可以连接其他slave形成图状结构
3）主从复制不会阻塞master。也就是说当一个或多个slave与master进行初次同步数据时，master可以继续处理client发来的请求。相反slave在初次同步数据时则会阻塞不能处理client的请求
4）主从复制可以用来提高系统的可伸缩性,我们可以用多个slave专门用于client的读请求，比如sort操作可以使用slave来处理。也可以用来做简单的数据冗余
5）可以在master禁用数据持久化，只需要注释掉master配置文件中的所有save配置，然后只在slave上配置数据持久化


知道哪些redis的优化操作。
1)根据业务需要选择合适的数据类型，并为不同的应用场景设置相应的紧凑存储参数。
不管是内存使用或者是性能，数据结构将产生很大的影响，下面是一些可以参考的最佳实践：
取代将数据存储为数千（或者数百万）独立的字符串，可以考虑使用哈希数据结构将相关数据进行分组。哈希表是非常有效率的，并且可以减少你的内存使用；
同时，哈希还更有益于细节抽象和代码可读。合适时候，使用list代替set。如果你不需要使用set特性，List在使用更少内存的情况下可以提供比set更快的速度。
Sorted sets是最昂贵的数据结构，不管是内存消耗还是基本操作的复杂性。如果你只是需要一个查询记录的途径，并不在意排序这样的属性，那么轻建议使用哈希表。
2)控制所有键名的长度
3)掌控储存在Redis中的所有键,不用的键值要及时删除
4)当业务场景不需要数据持久化时，关闭所有的持久化方式可以获得最佳的性能以及最大的内存使用量。
5)如果需要使用持久化，根据是否可以容忍重启丢失部分数据在RDB与AOF之间选择其一，不要使用虚拟内存VM以及diskstore方式。
6)不要让你的Redis所在机器物理内存使用超过实际内存总量的3/5。


Reids的主从复制机制原理。
redis采用异步的形式复制数据到slave，从redis 2.8开始，slave会周期性地确认自己每次复制的数据量
1)一个master node可以连接多个slave node
2)slave node 也可以连接其他slave node
3)slave node复制数据时不会block master node
4)slave node 复制数据也不会block 自己的查询操作，它会用旧的数据对外提供服务，但复制完成后，需要删除旧的数据，加载新数据，这个时候会暂停对外服务
5)slave node主要用来进行横向扩容，扩容可以提高更高的读吞吐量


Redis的线程模型是什么。
Redis 基于 Reactor 模式开发了自己的网络事件处理器：文件事件处理器。基于 select、epoll 实现IO多路复用程序来监听多个套接字。


如何看待缓存的使用（本地缓存，集中式缓存），简述本地缓存和集中式缓存和优缺点。 
Nginx+Redis/Memcached+Ehcache
Nginx常来做流量分发，同时nginx本身也有自己的缓存机制，可以用来缓存静态资源，让用户的请求直接走缓存并返回，从而减少流向服务器的流量。
对于部署多个nginx而言，如果不加入一些路由策略，那么可能导致每个nginx的缓存命中率很低，因此可以部署双层Nginx提升缓存命中率。
用户的请求，在nginx没有缓存相应数据，那么进入到 Redis 缓存中，Redis 可做到全量数据缓存，通过水平扩展能够提升高并发，高可用能力。
Ehcache jvm堆内存缓存，如果redis出现了大规模的宕机，导致nginx大量流量直接流向数据库，那么最后JVM缓存也可以处理部分请求，避免所有请求直接流向数据库。

一致性
进程内缓存：当使用进程内缓存时，缓存元素是特定应用程序实例本地的。然而许多中大型应用通常会做负载均衡，往往是多台机器跑同一个应用。在这种情况下，
很可能会构建出一个有多少应用实例就有多少缓存，每个缓存都有各自的状态，导致缓存不一致。
分布式缓存：虽然部署在由多个节点构成的集群上，但是会提供一个单一缓存的逻辑视图（以及状态）。多数情况下，分布式缓存中的对象将会存在于集群中的单
个节点。通过哈希算法，缓存引擎总是可以判断出某个键值对位于哪个特定节点。由于整个集群总是会有一个特定状态，所以不会存在缓存不一致情况。
备注
如果你需要缓存不变的对象，一致性将不是一个问题。在这种情况下，进程内缓存是一个更好的解决方案，因为它没有分布式缓存的管理开销。
如果你的应用部署在多个节点上，想要缓存可变的对象同时需要每次读都是一致的而不仅仅满足最终一致性，则应当采用分布式缓存。

开销
进程内缓存可能会影响垃圾回收进而影响系统性能。这将会由缓存大小以及对象逐出和过期的频率决定。
分布式缓存有两大主要开销会导致其慢于进程内缓存（但优于无缓存方案）：网络延迟和对象序列化。
备注
如果你试图寻求一个多节点部署情况下的强一致性缓存解决方案，采用分布式缓存。

可靠性
进程内缓存与应用程序使用同一堆空间，因此必须非常小心地决定缓存所能使用的内存上限。如果应用程序用光了内存，想要恢复并不容易。
分布式缓存作为多个节点的独立进程运行，因此单点故障并不会导致缓存失效。丢失的缓存元素将会在下一次缓存未命中时进入存活的节点。分布式缓存情况下，
缓存整体失效的最坏后果是降低系统性能，而不是导致系统整体故障。
备注
进程内缓存适用于较小且频率可预见的访问场景，尤其适用于不变对象。对于较大且不可预见的规模的访问，最好采用分布式缓存。

总结
对于较小规模的不变对象，可预见次数的访问，进程内缓存是一个理想解决方案，性能上它优于分布式缓存。然而，对于要缓存的对象数量是未知的并且较大的
情况下，同时要求读一致性，分布式缓存是一个更好的解决方案，尽管进程内缓存可能具备与它相同的性能。


本地缓存在并发使用时的注意事项。
一个缓存如果失效，可能出现多个请求该数据的进程同时查询DB、同时设置缓存的情况。如果并发确实很大，会造成DB压力过大，还有缓存频繁更新的问题。
在某个请求发现缓存没有数据时，需要获取一个排它锁，由此请求查询数据库并更新缓存，完成后释放锁。在此请求操作的过程中，阻塞所有其它请求同一数据的请求，等这个更新请求完成后直接从缓存获取数据。


开源框架知识

SpringMVC如何做到零配置?
方法：自定义类实现WebApplicationInitializer接口，在其中完成一系列代码形式上的配置，用以替代XML形式的配置。
原理：Tomcat启动时会利用SPI(spring-web-4.3.3.RELEASE.jar!\META-INF\services\javax.servlet.ServletContainerInitializer)机制
调用org.springframework.web.SpringServletContainerInitializer类，此类实现了ServletContainerInitializer接口，所以在Tomcat启动时，Tomcat会
调用SpringServletContainerInitializer类。
SpringServletContainerInitializer类有@HandlesTypes(WebApplicationInitializer.class)注解，意思是类中的onStartup()会调用
WebApplicationInitializer所有实现类的onStartup()。

@HandlesTypes(WebApplicationInitializer.class)
public class SpringServletContainerInitializer implements ServletContainerInitializer {
	@Override
	public void onStartup(Set<Class<?>> webAppInitializerClasses, ServletContext servletContext) throws ServletException {
		......
		for (WebApplicationInitializer initializer : initializers) {
			initializer.onStartup(servletContext);
		}
	}
}


SpringBoot的两种启动方式。
1.以Jar包形式运行
@SpringBootApplication
public class ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
    }
}

2.以war包形式运行
SpringBootServletInitializer类实现WebApplicationInitializer接口，所以启动原理和SpringMVC零配置相似。
@SpringBootApplication
public class ApplicationRunner extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApplicationRunner.class);
    }
}

简单讲讲tomcat结构，以及其类加载器流程，线程模型等。
Tomcat的核心组件就Connector和Container，一个Connector+一个Container（Engine）构成一个Service，Service就是对外提供服务的组件
BootStrap引导加载器，extension扩展加载器，system系统加载器，common加载器(负责加载/common目录的类库，这儿存放的类库可被tomcat以及所有的应用使用)
tomcat支持四种线程模型:BIO、NIO、APR和AIO


tomcat如何调优，涉及哪些参数 。
1）吞吐量  2）Responsetime  3）Cpuload  4）MemoryUsage
-server、-Xms和-Xmx设置成一样大、-Xmn合理设置新生代大小(Sun官方推荐配置为整个堆的3/8)、-Xss设置栈大小
Tomcat容器内优化：打开tomcat安装目录\conf\server.xml文件,可以设置一堆参数


1、什么是 Spring 框架？Spring 框架有哪些主要模块？
Spring 框架是一个为 Java 应用程序的开发提供了综合、广泛的基础性支持的 Java 平台。

Spring帮助开发者解决了开发中基础性的问题，使得开发人员可以专注于应用程序的开发。

Spring 框架本身亦是按照设计模式精心打造，这使得我们可以在开发环境中安心的集成 Spring 框架，不必担心 Spring 是如何在后台进行工作的。

Spring 框架至今已集成了 20 多个模块。这些模块主要被分如下图所示的核心容器、数据访问/集成,、Web、AOP（面向切面编程）、工具、消息和测试模块。


2、使用 Spring 框架能带来哪些好处？
下面列举了一些使用 Spring 框架带来的主要好处：
1、Dependency Injection(DI) 方法使得构造器和 JavaBean properties 文件中的依赖关系一目了然。
2、与 EJB 容器相比较，IOC 容器更加趋向于轻量级。这样一来 IOC 容器在有限的内存和 CPU资源的情况下进行应用程序的开发和发布就变得十分有利。
3、Spring 并没有闭门造车，Spring 利用了已有的技术比如 ORM 框架、logging 框架、J2EE、Quartz 和 JDK Timer，以及其他视图技术。
4、Spring 框架是按照模块的形式来组织的。由包和类的编号就可以看出其所属的模块，开发者仅仅需要选用他们需要的模块即可。
5、要测试一项用 Spring 开发的应用程序十分简单，因为测试相关的环境代码都已经囊括在框架中了。更加简单的是，利用 JavaBean 形式的 POJO 类，可以很方便的利用依赖注入来写入测试数据。
6、Spring 的 Web 框架亦是一个精心设计的 Web MVC 框架，为开发者们在 web 框架的选择上提供了一个除了主流框架比如 Struts、过度设计的、不流行 web 框架的以外的有力选项。
7、Spring 提供了一个便捷的事务管理接口，适用于小型的本地事务处理（比如在单 DB 的环境下）和复杂的共同事务处理（比如利用 JTA 的复杂 DB 环境）。


3、什么是控制反转(IOC)？什么是依赖注入？
1、控制反转是应用于软件工程领域中的，在运行时被装配器对象来绑定耦合对象的一种编程技巧，对象之间耦合关系在编译时通常是未知的。

在传统的编程方式中，业务逻辑的流程是由应用程序中的早已被设定好关联关系的对象来决定的。在使用控制反转的情况下，业务逻辑的流程是由对象关系图来决定的，该对象关系图由装配器负责实例化，这种实现方式还可以将对象之间的关联关系的定义抽象化。而绑定的过程是通过“依赖注入”实现的。
2、控制反转是一种以给予应用程序中目标组件更多控制为目的设计范式，并在我们的实际工作中起到了有效的作用。
3、依赖注入是在编译阶段尚未知所需的功能是来自哪个的类的情况下，将其他对象所依赖的功能对象实例化的模式。这就需要一种机制用来激活相应的组件以提供特定的功能，所以依赖注入是控制反转的基础。否则如果在组件不受框架控制的情况下，框架又怎么知道要创建哪个组件？
4、在 Java 中依然注入有以下三种实现方式：
1.构造器注入
2.Setter 方法注入
3.接口注入


4、请解释下 Spring 框架中的 IOC？
Spring 中的 org.springframework.beans 包和 org.springframework.context 包构成了Spring 框架 IOC 容器的基础。
BeanFactory 接口提供了一个先进的配置机制，使得任何类型的对象的配置成为可能。
ApplicationContext 接口对 BeanFactory（是一个子接口）进行了扩展，在 BeanFactory 的基础上添加了其他功能，比如与 Spring 的 AOP 更容易集成，也提供了处理 message resource的机制（用于国际化）、事件传播以及应用层的特别配置，比如针对 Web 应用的WebApplicationContext。


5、BeanFactory 和 ApplicationContext 有什么区别？
BeanFactory 可以理解为含有 bean 集合的工厂类。BeanFactory 包含了各种 bean 的定义，以便在接收到客户端请求时将对应的 bean 实例化。
BeanFactory 还能在实例化对象时生成协作类之间的关系。此举将 bean 自身与 bean 客户端的配置中解放出来。BeanFactory 还包含了 bean 生命周期的控制，调用客户端的初始化方法（initialization methods）和销毁方法（destruction methods）。
从表面上看，application context 如同 bean factory 一样具有 bean 定义、bean 关联关系的设置，根据请求分发 bean 的功能。但 application context 在此基础上还提供了其他的功能。
1.提供了支持国际化的文本消息
2.统一的资源文件读取方式
3.已在监听器中注册的 bean 的事件
以下是三种较常见的 ApplicationContext 实现方式：
1、ClassPathXmlApplicationContext：从 classpath 的 XML 配置文件中读取上下文，并生成上下文定义。应用程序上下文从程序环境变量中取得。
ApplicationContext context = new ClassPathXmlApplicationContext(“application.xml”);
2、FileSystemXmlApplicationContext ：由文件系统中的 XML 配置文件读取上下文。ApplicationContext context = new FileSystemXmlApplicationContext(“application.xml”);
3、XmlWebApplicationContext：由 Web 应用的 XML 文件读取上下文。


6、Spring 提供几种配置方式来设置元数据？
将 Spring 配置到应用开发中有以下三种方式：
1.基于 XML 的配置
2.基于注解的配置
3.基于 Java 的配置

7、如何使用 XML 配置的方式配置 Spring？
在 Spring 框架中，依赖和服务需要在专门的配置文件来实现，我常用的 XML 格式的配置文件。
这些配置文件的格式通常用开头，然后一系列的 bean 定义和专门的应用配置选项组成。
SpringXML配置的主要目的是使所有的Spring组件都可以用xml文件的形式来进行配置。
这意味着不会出现其他的 Spring 配置类型（比如声明的方式或基于 Java Class 的配置方式）Spring 的 XML 配置方式是使用被 Spring 命名空间的所支持的一系列的 XML 标签来实现的。
Spring 有以下主要的命名空间：context、beans、jdbc、tx、aop、mvc 和 aso。 

<beans>
<!-- JSON Support -->
<bean name="viewResolver"
class="org.springframework.web.servlet.view.BeanNameViewResolver"/>
<bean name="jsonTemplate"
class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"/>
<bean id="restTemplate" class="org.springframework.web.client.RestTemplate"/>
</beans>
下面这个 web.xml 仅仅配置了 DispatcherServlet，便能满足应用程序配置运行时组件的需求。

<web-app>
<display-name>Archetype Created Web Application</display-name>
<servlet>
<servlet-name>spring</servlet-name>
<servlet-class>
org.springframework.web.servlet.DispatcherServlet
</servlet-class>
<load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
<servlet-name>spring</servlet-name>
<url-pattern>/</url-pattern>
</servlet-mapping>
</web-app>

8、如何用基于 Java 配置的方式配置 Spring？
Spring 对 Java 配置的支持是由@Configuration 注解和@Bean 注解来实现的。由@Bean 注解的方法将会实例化、配置和初始化一个新对象，这个对象将由 Spring 的 IOC 容器来管理。
@Bean 声明所起到的作用与 元素类似。被@Configuration 所注解的类则表示这个类的主要目的是作为 bean 定义的资源。被@Configuration 声明的类可以通过在同一个类的内部调用@bean 方法来设置嵌入 bean 的依赖关系。

最简单的@Configuration 声明类请参考下面的代码：

@Configuration
public class AppConfig{
@Bean
public MyService myService() {
return new MyServiceImpl();
}
}
对于上面的@Beans 配置文件相同的 XML 配置文件如下：

<beans>
<bean id="myService" class="com.gupaoedu.services.MyServiceImpl"/>
</beans>
上述配置方式的实例化方式如下：利用AnnotationConfigApplicationContext 类进行实例化

public static void main(String[] args) {
ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
MyService myService = ctx.getBean(MyService.class);
myService.doStuff();
}
在上面的例子中，com.gupaoedu 包首先会被扫到，然后再容器内查找被@Component 声明的类，找到后将这些类按照 Sring bean 定义进行注册。
如果你要在你的web应用开发中选用上述的配置的方式的话，需要用AnnotationConfigWebApplicationContext 类来读取配置文件，可以用来配置Spring的Servlet监听器ContrextLoaderListener 或者 Spring MVC 的 DispatcherServlet。

<web-app>
<!-- Configure ContextLoaderListener to use AnnotationConfigWebApplicationContext
instead of the default XmlWebApplicationContext -->
<context-param>
<param-name>contextClass</param-name>
<param-value>
org.springframework.web.context.support.AnnotationConfigWebApplicationContext
</param-value>
</context-param>
<!-- Configuration locations must consist of one or more comma- or space-delimited
fully-qualified @Configuration classes. Fully-qualified packages may also be
specified for component-scanning -->
<context-param>
<param-name>contextConfigLocation</param-name>
<param-value>com.gupaoedu.AppConfig</param-value>
</context-param>
<!-- Bootstrap the root application context as usual using ContextLoaderListener -->
<listener>
<listener-class>org.springframework.web.context.ContextLoaderListener</listener-cla
ss>
</listener>
<!-- Declare a Spring MVC DispatcherServlet as usual -->
<servlet>
<servlet-name>dispatcher</servlet-name>
<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
<!-- Configure DispatcherServlet to use AnnotationConfigWebApplicationContext
instead of the default XmlWebApplicationContext -->
<init-param>
<param-name>contextClass</param-name>
<param-value>
org.springframework.web.context.support.AnnotationConfigWebApplicationContext
</param-value>
</init-param>
<!-- Again, config locations must consist of one or more comma- or space-delimited
and fully-qualified @Configuration classes -->
<init-param>
<param-name>contextConfigLocation</param-name>
<param-value>com.gupaoedu.web.MVCConfig</param-value>
</init-param>
</servlet>
<!-- map all requests for /web/ to the dispatcher servlet -->
<servlet-mapping>
<servlet-name>dispatcher</servlet-name>
<url-pattern>/web/</url-pattern>
</servlet-mapping></web-app>

9、怎样用注解的方式配置 Spring？
Spring 在 2.5 版本以后开始支持用注解的方式来配置依赖注入。可以用注解的方式来替代 XML方式的 bean 描述，可以将 bean 描述转移到组件类的内部，只需要在相关类上、方法上或者字段声明上使用注解即可。注解注入将会被容器在 XML 注入之前被处理，所以后者会覆盖掉前者对于同一个属性的处理结果。
注解装配在 Spring 中是默认关闭的。所以需要在 Spring 文件中配置一下才能使用基于注解的装配模式。如果你想要在你的应用程序中使用关于注解的方法的话，请参考如下的配置。

<beans>
<context:annotation-config/>
<!-- bean definitions go here -->
</beans>

在标签配置完成以后，就可以用注解的方式在 Spring 中向属性、方法和构造方法中自动装配变量。
下面是几种比较重要的注解类型：
1.@Required：该注解应用于设值方法。
2.@Autowired：该注解应用于有值设值方法、非设值方法、构造方法和变量。
3.@Qualifier：该注解和@Autowired 注解搭配使用，用于消除特定 bean 自动装配的歧义。
4.JSR-250 Annotations ：Spring 支持 基于 JSR-250 注解 的以下 注解 ，@Resource、
@PostConstruct 和 @PreDestroy。


10、请解释 Spring Bean 的生命周期？
Spring Bean 的生命周期简单易懂。在一个 bean 实例被初始化时，需要执行一系列的初始化操作以达到可用的状态。同样的，当一个 bean 不在被调用时需要进行相关的析构操作，并从 bean容器中移除。
Spring bean factory 负责管理在 spring 容器中被创建的 bean 的生命周期。Bean 的生命周期由两组回调（call back）方法组成。
1.初始化之后调用的回调方法。
2.销毁之前调用的回调方法。
Spring 框架提供了以下四种方式来管理 bean 的生命周期事件：
1、InitializingBean 和 DisposableBean 回调接口
2、针对特殊行为的其他 Aware 接口
3、Bean 配置文件中的 Custom init()方法和 destroy()方法
4、@PostConstruct 和@PreDestroy 注解方式
使用 customInit()和 customDestroy()方法管理 bean 生命周期的代码样例如下：

<beans>
<bean id="demoBean" class="com.gupaoedu.task.DemoBean"
init-method="customInit" destroy-method="customDestroy">
</bean>
</beans>

11、Spring Bean 作用域之间的区别？
Spring 容器中的 bean 可以分为 5 个范围。所有范围的名称都是自说明的，但是为了避免混淆，
还是让我们来解释一下：
1.singleton：这种 bean 范围是默认的，这种范围确保不管接受到多少个请求，每个容器中只有一个 bean 的实例，单例的模式由 bean factory 自身来维护。
2.prototype：原形范围与单例范围相反，为每一个 bean 请求提供一个实例。
3.request：在请求 bean 范围内会为每一个来自客户端的网络请求创建一个实例，在请求完成以后，bean 会失效并被垃圾回收器回收。
4.Session：与请求范围类似，确保每个 session 中有一个 bean 的实例，在 session 过期后，bean 会随之失效。
5.global-session：global-session 和 Portlet 应用相关。当你的应用部署在 Portlet 容器中作时，它包含很多 portlet。如果你想要声明让所有的 portlet 共用全局的存储变量的话，那么这全局变量需要存储在 global-session 中。全局作用域与 Servlet 中的 session 作用域效果相同。


12、什么是 Spring inner beans？
在 Spring 框架中，无论何时 bean 被使用时，当仅被调用了一个属性。一个明智的做法是将这个 bean 声明为内部 bean。内部 bean 可以用 setter 注入“属性”和构造方法注入“构造参数”的方式来实现。
比如，在我们的应用程序中，一个 Customer 类引用了一个 Person 类，我们的要做的是创建一个 Person 的实例，然后在 Customer 内部使用。

public class Customer{
private Person person;
//Setters and Getters
}
public class Person{
private String name;
private String address;
private int age;
//Setters and Getters
}

内部 bean 的声明方式如下：

<bean id="CustomerBean" class="com.howtodoinjava.common.Customer">
<property name="person">
<!-- This is inner bean -->
<bean class="com.howtodoinjava.common.Person">
<property name="name" value="lokesh" />
<property name="address" value="India" />
<property name="age" value="34" />
</bean>
</property>
</bean>

13、Spring 框架中的单例 Beans 是线程安全的么？
Spring 框架并没有对单例 bean 进行任何多线程的封装处理。关于单例 bean 的线程安全和并发问题需要开发者自行去搞定。但实际上，大部分的 Spring bean 并没有可变的状态(比如Serview类和DAO类)，所以在某种程度上说Spring的单例bean是线程安全的。如果你的bean有多种状态的话（比如 View Model 对象），就需要自行保证线程安全。
最浅显的解决办法就是将多态 bean 的作用域由“singleton”变更为“prototype”。


14、请举例说明如何在 Spring 中注入一个 Java 集合？
Spring 提供了以下四种集合类的配置元素：
1、 : 该标签用来装配可重复的 list 值。
2、 : 该标签用来装配没有重复的 set 值。
3、 : 该标签可用来注入键和值可以为任何类型的键值对。
4、 : 该标签支持注入键和值都是字符串类型的键值对。
下面看一下具体的例子：

<beans>
<!-- Definition for javaCollection -->
<bean id="javaCollection" class="com.gupaoedu.JavaCollection">
<!-- java.util.List -->
<property name="customList">
<list>
<value>INDIA</value>
<value>Pakistan</value>
<value>USA</value>
<value>UK</value>
</list>
</property>
<!-- java.util.Set -->
<property name="customSet">
<set>
<value>INDIA</value>
<value>Pakistan</value>
<value>USA</value>
<value>UK</value>
</set>
</property>
<!-- java.util.Map -->
<property name="customMap">
<map>
<entry key="1" value="INDIA"/>
<entry key="2" value="Pakistan"/>
<entry key="3" value="USA"/>
<entry key="4" value="UK"/>
</map>
</property>
<!-- java.util.Properties -->
<property name="customProperies">
<props>
<prop key="admin">admin@gupaoedu.com</prop>
<prop key="support">support@gupaoedu.com</prop>
</props>
</property>
</bean>
</beans>
15、如何向 Spring Bean 中注入 java.util.Properties？
第一种方法是使用如下面代码所示的 标签：

<bean id="adminUser" class="com.howtodoinjava.common.Customer">
<!-- java.util.Properties -->
<property name="emails">
<props>
<prop key="admin">admin@gupaoedu.com</prop>
<prop key="support">support@gupaoedu.com</prop>
</props>
</property>
</bean>


也可用”util:”命名空间来从 properties 文件中创建出一个 propertiesbean，然后利用 setter方法注入 bean 的引用。


16、请解释 Spring Bean 的自动装配？
在 Spring 框架中，在配置文件中设定 bean 的依赖关系是一个很好的机制，Spring 容器还可以自动装配合作关系 bean 之间的关联关系。
这意味着 Spring 可以通过向 Bean Factory 中注入的方式自动搞定 bean 之间的依赖关系。自动装配可以设置在每个bean上，也可以设定在特定的bean上。
下面的 XML 配置文件表明了如何根据名称将一个 bean 设置为自动装配：
<bean id="employeeDAO" class="com.gupaoedu.EmployeeDAOImpl" autowire="byName" />除了 bean 配置文件中提供的自动装配模式，还可以使用@Autowired 注解来自动装配指定的bean。在使用@Autowired 注解之前需要在按照如下的配置方式在 Spring 配置文件进行配置才可以使用。
<context:annotation-config />也可以通过在配置文件中配置 AutowiredAnnotationBeanPostProcessor 达到相同的效果。

<bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>
1配置好以后就可以使用@Autowired 来标注了。

@Autowired
public EmployeeDAOImpl ( EmployeeManager manager ) {
this.manager = manager;
}

17、请解释各种自动装配模式的区别？
在 Spring 框架中共有 5 种自动装配，让我们逐一分析。
1.no：这是 Spring 框架的默认设置，在该设置下自动装配是关闭的，开发者需要自行在 bean定义中用标签明确的设置依赖关系。
2.byName：该选项可以根据 bean 名称设置依赖关系。当向一个 bean 中自动装配一个属性时，容器将根据 bean 的名称自动在配置文件中查询一个
		  匹配的 bean。如果找到的话，就装配这个属性，如果没找到的话就报错。
3.byType：该选项可以根据 bean 类型设置依赖关系。当向一个 bean 中自动装配一个属性时，容器将根据 bean 的类型自动在配置文件中查询一个
    	  匹配的 bean。如果找到的话，就装配这个属性，如果没找到的话就报错。
4.constructor：构造器的自动装配和 byType 模式类似，但是仅仅适用于与有构造器相同参数的bean，如果在容器中没有找到与构造器参数类型一致的bean，那么将会抛出异常。
5.autodetect：该模式自动探测使用构造器自动装配或者 byType 自动装配。首先会尝试找合适的带参数的构造器，如果找到的话就是用构造器自动装配，
			  如果在 bean 内部没有找到相应的构造器或者是无参构造器，容器就会自动选择 byTpe 的自动装配方式。


18、如何开启基于注解的自动装配？
要使用 @Autowired，需要注册AutowiredAnnotationBeanPostProcessor，可以有以下两种方式来实现：
1、在配置文件中引入

<beans>
<context:annotation-config />
</beans>
2、在 bean 配置文件中直接引入 AutowiredAnnotationBeanPostProcessor

<beans>
<bean
class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>
</beans>

19 、 自动装配有哪些局限性？
自动装配有如下局限性：
重写：你仍然需要使用 和< property>设置指明依赖，这意味着总要重写自动装配。
原生数据类型:你不能自动装配简单的属性，如原生类型、字符串和类。
模糊特性：自动装配总是没有自定义装配精确，因此，如果可能尽量使用自定义装配。


20、在 Spring 中可以注入 null 或空字符串吗？
完全可以。


21、请举例解释@Required Annotation？
在产品级别的应用中，IOC 容器可能声明了数十万了 bean，bean 与 bean 之间有着复杂的依赖关系。设值注解方法的短板之一就是验证所有的属性是否被注解是一项十分困难的操作。可以通过在中设置“dependency-check”来解决这个问题。
在应用程序的生命周期中，你可能不大愿意花时间在验证所有 bean 的属性是否按照上下文文件正确配置 。 或者你宁可验证某个bean的特定属性是否被正确的设置。即使是用“dependency-check”属性也不能很好的解决这个问题，在这种情况下，你需要使用@Required 注解。
需要用如下的方式使用来标明 bean 的设值方法。

public class EmployeeFactoryBean extends AbstractFactoryBean<Object>{
private String designation;
public String getDesignation() {
return designation;
}
@Required
public void setDesignation(String designation) {
this.designation = designation;
}
}
RequiredAnnotationBeanPostProcessor 是 Spring 中的后置处理用来验证被@Required 注解的 bean 属性是否被正确的设置了。在使用RequiredAnnotationBeanPostProcesso 来验证bean 属性之前，首先要在 IOC 容器中对其进行注册：

<bean
class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor"/>
BeanInitializationException 异常。



22、请举例解释@Autowired 注解？
@Autowired 注解对自动装配何时何处被实现提供了更多细粒度的控制。@Autowired 注解可以像@Required 注解、构造器一样被用于在 bean 的设值方法上自动装配 bean 的属性，一个参数或者带有任意名称或带有多个参数的方法。
比如，可以在设值方法上使用@Autowired 注解来替代配置文件中的 元素。当 Spring 容器在setter 方法上找到@Autowired 注解时，会尝试用 byType 自动装配。
当然我们也可以在构造方法上使用@Autowired 注解。带有@Autowired 注解的构造方法意味着在创建一个 bean 时将会被自动装配，即便在配置文件中使用 元素。

public class TextEditor {
private SpellChecker spellChecker;
@Autowired
public TextEditor(SpellChecker spellChecker){
System.out.println("Inside TextEditor constructor." );
this.spellChecker = spellChecker;
}
public void spellCheck(){
spellChecker.checkSpelling();
}
}


下面是没有构造参数的配置方式：

<beans>
<context:annotation-config/>
<!-- Definition for textEditor bean without constructor-arg -->
<bean id="textEditor" class="com.gupaoedu.TextEditor">
</bean>
<!-- Definition for spellChecker bean -->
<bean id="spellChecker" class="com.gupaoedu.SpellChecker">
</bean>
</beans>

23、请举例说明@Qualifier 注解？
@Qualifier 注解意味着可以在被标注 bean 的字段上可以自动装配。Qualifier 注解可以用来取消 Spring 不能取消的 bean 应用。
下面的示例将会在 Customer 的 person 属性中自动装配 person 的值。

public class Customer{
@Autowired
private Person person;
}


下面我们要在配置文件中来配置 Person 类。

<bean id="customer" class="com.gupaoedu.common.Customer" />
<bean id="personA" class="com.gupaoedu.common.Person" >
<property name="name" value="lokesh" />
</bean>
<bean id="personB" class="com.gupaoedu.common.Person" >
<property name="name" value="alex" />
</bean>

Spring 会知道要自动装配哪个 person bean 么？不会的，但是运行上面的示例时，会抛出下面的异常：
Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException:
No unique bean of type [com.gupaoedu.common.Person] is defined:
expected single matching bean but found 2: [personA, personB]要解决上面的问题，需要使用 @Quanlifier 注解来告诉 Spring 容器要装配哪个 bean：

public class Customer{
@Autowired
@Qualifier("personA")
private Person person;
}

24、构造方法注入和设值注入有什么区别？
请注意以下明显的区别：
1.在设值注入方法支持大部分的依赖注入，如果我们仅需要注入 int、string 和 long 型的变量，我们不要用设值的方法注入。对于基本类型，如果我们没有注入的话，可以为基本类型设置默认值。在构造方法注入不支持大部分的依赖注入，因为在调用构造方法中必须传入正确的构造参数，否则的话为报错。
2.设值注入不会重写构造方法的值。如果我们对同一个变量同时使用了构造方法注入又使用了设置方法注入的话，那么构造方法将不能覆盖由设值方法注入的值。很明显，因为构造方法尽在对象被创建时调用。
3.在使用设值注入时有可能还不能保证某种依赖是否已经被注入，也就是说这时对象的依赖关系有可能是不完整的。而在另一种情况下，构造器注入则不允许生成依赖关系不完整的对象。
4.在设值注入时如果对象A和对象B互相依赖，在创建对象A时Spring会抛出sObjectCurrentlyInCreationException 异常，因为在 B 对象被创建之前 A 对象是不能被创建的，反之亦然。所以 Spring 用设值注入的方法解决了循环依赖的问题，因对象的设值方法是在对象被创建之前被调用的。


25、Spring 框架中有哪些不同类型的事件？
Spring 的 ApplicationContext 提供了支持事件和代码中监听器的功能。
我们可以创建 bean 用来监听在 ApplicationContext 中发布的事件。ApplicationEvent 类和在 ApplicationContext 接口中处理的事件，如果一个 bean 实现了 ApplicationListener 接口，当一个 ApplicationEvent 被发布以后，bean 会自动被通知。

public class AllApplicationEventListener implements ApplicationListener <ApplicationEvent> {
@Override
public void onApplicationEvent(ApplicationEvent applicationEvent)
{
//process event
}
}


Spring 提供了以下 5 中标准的事件：
1.上下文更新事件（ContextRefreshedEvent）：该事件会在 ApplicationContext 被初始化或者更新时发布。也可以在调用 ConfigurableApplicationContext 接口中的 refresh()方法时被触发。


2.上下文开始事件（ContextStartedEvent）：当容器调用ConfigurableApplicationContext的 Start()方法开始/重新开始容器时触发该事件。


3.上下文停止事件（ContextStoppedEvent）：当容器调用ConfigurableApplicationContext的 Stop()方法停止容器时触发该事件。


4.上下文关闭事件（ContextClosedEvent）：当 ApplicationContext 被关闭时触发该事件。容器被关闭时，其管理的所有单例 Bean 都被销毁。


5.请求处理事件（RequestHandledEvent）：在 Web 应用中，当一个 http 请求（request）结束触发该事件。
除了上面介绍的事件以外，还可以通过扩展 ApplicationEvent 类来开发自定义的事件。

public class CustomApplicationEvent extends ApplicationEvent{
public CustomApplicationEvent ( Object source, final String msg ){
super(source);
System.out.println("Created a Custom event");
}
}
为了监听这个事件，还需要创建一个监听器：

public class CustomEventListener implements ApplicationListener <CustomApplicationEvent>{
@Override
public void onApplicationEvent(CustomApplicationEvent applicationEvent) {
//handle event
}
}
之后通过 applicationContext 接口的 publishEvent()方法来发布自定义事件。

CustomApplicationEvent customEvent = new CustomApplicationEvent(applicationContext,“Test message”);
applicationContext.publishEvent(customEvent);

26、FileSystemResource 和 ClassPathResource 有何区别？
在 FileSystemResource 中需要给出 spring-config.xml 文件在你项目中的相对路径或者绝对路径。在 ClassPathResource 中 spring 会在 ClassPath 中自动搜寻配置文件，所以要把ClassPathResource 文件放在 ClassPath 下。
如果将 spring-config.xml 保存在了 src 文件夹下的话，只需给出配置文件的名称即可，因为 src文件夹是默认。
简而言之，ClassPathResource 在环境变量中读取配置文件FileSystemResource 在配置文件中读取配置文件。


27、Spring 框架中都用到了哪些设计模式？
Spring 框架中使用到了大量的设计模式，下面列举了比较有代表性的：
1、代理模式—在 AOP 和 remoting 中被用的比较多。
2、单例模式：在 spring 配置文件中定义的 bean 默认为单例模式。
3、模板模式：用来解决代码重复的问题。
比如. RestTemplate, JmsTemplate, JpaTemplate。
4、委派模式：Spring 提供了 DispatcherServlet 来对请求进行分发。
5、工厂模式：BeanFactory 用来创建对象的实例，贯穿于 BeanFactory / ApplicationContext
接口的核心理念。
6、代理模式：AOP 思想的底层实现技术，Spring 中采用 JDK Proxy 和 CgLib 类库。


28、在 Spring 框架中如何更有效的使用 JDBC？
使用Spring JDBC框架，资源管理以及错误处理的代价都会减轻。开发人员只需通过statements和 queries 语句从数据库中存取数据。Spring 框架中通过使用模板类能更有效的使用 JDBC，也就是所谓的 JdbcTemplate。


29、Spring5 新特性
1、依赖 JDK 8+和 Java EE7+以上版本
2、首次采用反应式编程模型
3、支持使用注解进行编程
4、新增函数式编程
5、支持使用 REST 断点执行反应式编程
6、支持 HTTP 2.0
7、新增 Kotlin 和 Spring WebFlux
8、可使用 Lambda 表达式注册 Bean
9、Spring WebMVC 支持最新的 API
10、使用 JUnit5 执行条件和并发测试
11、使用 Spring WebFlux 执行集成测试
12、核心容器优化




1、Spring是什么?

Spring是一个轻量级的IoC和AOP容器框架。是为Java应用程序提供基础性服务的一套框架，目的是用于简化企业应用程序的开发，它使得开发者只需要关心业务需求。常见的配置方式有三种：基于XML的配置、基于注解的配置、基于Java的配置。

主要由以下几个模块组成：

Spring Core：核心类库，提供IOC服务；

Spring Context：提供框架式的Bean访问方式，以及企业级功能（JNDI、定时任务等）；

Spring AOP：AOP服务；

Spring DAO：对JDBC的抽象，简化了数据访问异常的处理；

Spring ORM：对现有的ORM框架的支持；

Spring Web：提供了基本的面向Web的综合特性，例如多方文件上传；

Spring MVC：提供面向Web应用的Model-View-Controller实现。

 

2、Spring 的优点？

（1）spring属于低侵入式设计，代码的污染极低；

（2）spring的DI机制将对象之间的依赖关系交由框架处理，减低组件的耦合性；

（3）Spring提供了AOP技术，支持将一些通用任务，如安全、事务、日志、权限等进行集中式管理，从而提供更好的复用。

（4）spring对于主流的应用框架提供了集成支持。

 

3、Spring的AOP理解：

OOP面向对象，允许开发者定义纵向的关系，但并不适用于定义横向的关系，导致了大量代码的重复，而不利于各个模块的重用。

AOP，一般称为面向切面，作为面向对象的一种补充，用于将那些与业务无关，但却对多个对象产生影响的公共行为和逻辑，抽取并封装为一个可重用的模块，
这个模块被命名为“切面”（Aspect），减少系统中的重复代码，降低了模块间的耦合度，同时提高了系统的可维护性。可用于权限认证、日志、事务处理。

AOP实现的关键在于 代理模式，AOP代理主要分为静态代理和动态代理。静态代理的代表为AspectJ；动态代理则以Spring AOP为代表。

（1）AspectJ是静态代理的增强，所谓静态代理，就是AOP框架会在编译阶段生成AOP代理类，因此也称为编译时增强，他会在编译阶段将AspectJ(切面)织入到Java字节码中，运行的时候就是增强之后的AOP对象。

（2）Spring AOP使用的动态代理，所谓的动态代理就是说AOP框架不会去修改字节码，而是每次运行时在内存中临时为方法生成一个AOP对象，这个AOP对象包含了目标对象的全部方法，并且在特定的切点做了增强处理，并回调原对象的方法。

Spring AOP中的动态代理主要有两种方式，JDK动态代理和CGLIB动态代理：

        ①JDK动态代理只提供接口的代理，不支持类的代理。核心InvocationHandler接口和Proxy类，InvocationHandler 通过invoke()方法反射来调用
		 目标类中的代码，动态地将横切逻辑和业务编织在一起；接着，Proxy利用 InvocationHandler动态创建一个符合某一接口的的实例,  生成目标类的代理对象。

        ②如果代理类没有实现 InvocationHandler 接口，那么Spring AOP会选择使用CGLIB来动态代理目标类。CGLIB（Code Generation Library），
		 是一个代码生成的类库，可以在运行时动态的生成指定类的一个子类对象，并覆盖其中特定方法并添加增强代码，从而实现AOP。CGLIB是通过继承的方式做的动态代理，因此如果某个类被标记为final，那么它是无法使用CGLIB做动态代理的。

（3）静态代理与动态代理区别在于生成AOP代理对象的时机不同，相对来说AspectJ的静态代理方式具有更好的性能，但是AspectJ需要特定的编译器进行处理，而Spring AOP则无需特定的编译器处理。

 InvocationHandler 的 invoke(Object  proxy,Method  method,Object[] args)：proxy是最终生成的代理实例;  method 是被代理目标实例的某个具体方法;  args 是被代理目标实例某个方法的具体入参, 在方法反射调用时使用。

 

4、Spring的IoC理解和有点：

（1）IOC就是控制反转，是指创建对象的控制权的转移，以前创建对象的主动权和时机是由自己把控的，而现在这种权力转移到Spring容器中，并由容器根据
	配置文件去创建实例和管理各个实例之间的依赖关系，对象与对象之间松散耦合，也利于功能的复用。DI依赖注入，和控制反转是同一个概念的不同角度的描述，即 应用程序在运行时依赖IoC容器来动态注入对象需要的外部资源。

（2）最直观的表达就是，IOC让对象的创建不用去new了，可以由spring自动生产，使用java的反射机制，根据配置文件在运行时动态的去创建对象以及管理对象，并调用对象的方法的。

（3）Spring的IOC有三种注入方式 ：构造器注入、setter方法注入、根据注解注入。
IoC让相互协作的组件保持松散的耦合，而AOP编程允许你把遍布于应用各层的功能分离出来形成可重用的功能组件。

优点1：例子，车，车身，底盘，轮胎。仅仅是为了修改轮胎的构造函数，这种设计却需要修改整个上层所有类的构造函数。
      在实际工程项目中，有的类可能会是几千个类的底层，如果每次修改这个类，我们都要修改所有以它作为依赖的类，那软件的维护成本就太高了。
      所以我们需要进行控制反转，上层控制下层，而不是下层控制着上层。我们用依赖注入DI这种方式来实现控制反转。所谓依赖注入，就是把底层类作为参数传入上层类，实现上层类对下层类的“控制“
优点2：容器可以自动对你的代码进行初始化，你只需要维护一个Configuration（可以是xml可以是一段代码），而不用每次初始化一辆车都要亲手去写那一大段初始化的代码。
	  我们在创建实例的时候不需要了解其中的细节(轮胎->底盘->车身->车)。


5、BeanFactory和ApplicationContext有什么区别？

BeanFactory和ApplicationContext是Spring的两大核心接口，都可以当做Spring的容器。其中ApplicationContext是BeanFactory的子接口。

（1）BeanFactory：是Spring里面最底层的接口，包含了各种Bean的定义，读取bean配置文档，管理bean的加载、实例化，控制bean的生命周期，
	维护bean之间的依赖关系。ApplicationContext接口作为BeanFactory的派生，除了提供BeanFactory所具有的功能外，还提供了更完整的框架功能：

①继承MessageSource，因此支持国际化。

②统一的资源文件访问方式。

③提供在监听器中注册bean的事件。

④同时加载多个配置文件。

⑤载入多个（有继承关系）上下文 ，使得每一个上下文都专注于一个特定的层次，比如应用的web层。

（2）①BeanFactroy采用的是延迟加载形式来注入Bean的，即只有在使用到某个Bean时(调用getBean())，才对该Bean进行加载实例化。这样，我们就不能发现
	 一些存在的Spring配置问题。如果Bean的某一个属性没有注入，BeanFacotry加载后，直至第一次使用调用getBean方法才会抛出异常。

    ②ApplicationContext，它是在容器启动时，一次性创建了所有的Bean。这样，在容器启动时，我们就可以发现Spring中存在的配置错误，这样有利于检查
	 所依赖属性是否注入。 ApplicationContext启动后预载入所有的单例Bean，通过预载入单实例bean ,确保当你需要的时候，你就不用等待，因为它们已经创建好了。

    ③相对于基本的BeanFactory，ApplicationContext 唯一的不足是占用内存空间。当应用程序配置Bean较多时，程序启动较慢。

（3）BeanFactory通常以编程的方式被创建，ApplicationContext还能以声明的方式创建，如使用ContextLoader。

（4）BeanFactory和ApplicationContext都支持BeanPostProcessor、BeanFactoryPostProcessor的使用，但两者之间的区别是：BeanFactory需要手动注册，而ApplicationContext则是自动注册。

 

6、请解释Spring Bean的生命周期？

 首先说一下Servlet的生命周期：实例化，初始init，接收请求service，销毁destroy；

 Spring上下文中的Bean生命周期也类似，如下：

（1）实例化Bean：

对于BeanFactory容器，当客户向容器请求一个尚未初始化的bean时，或初始化bean的时候需要注入另一个尚未初始化的依赖时，容器就会调用createBean
进行实例化。对于ApplicationContext容器，当容器启动结束后，通过获取BeanDefinition对象中的信息，实例化所有的bean。

（2）设置对象属性（依赖注入）：

实例化后的对象被封装在BeanWrapper对象中，紧接着，Spring根据BeanDefinition中的信息 以及 通过BeanWrapper提供的设置属性的接口完成依赖注入。

（3）处理Aware接口：

接着，Spring会检测该对象是否实现了xxxAware接口，并将相关的xxxAware实例注入给Bean：

①如果这个Bean已经实现了BeanNameAware接口，会调用它实现的setBeanName(String beanId)方法，此处传递的就是Spring配置文件中Bean的id值；

②如果这个Bean已经实现了BeanFactoryAware接口，会调用它实现的setBeanFactory()方法，传递的是Spring工厂自身。

③如果这个Bean已经实现了ApplicationContextAware接口，会调用setApplicationContext(ApplicationContext)方法，传入Spring上下文；

（4）BeanPostProcessor：

如果想对Bean进行一些自定义的处理，那么可以让Bean实现了BeanPostProcessor接口，那将会调用postProcessBeforeInitialization(Object obj, String s)方法。由于这个方法是在Bean初始化结束时调用的，所以可以被应用于内存或缓存技术；

（5）InitializingBean 与 init-method：

如果Bean在Spring配置文件中配置了 init-method 属性，则会自动调用其配置的初始化方法。

（6）如果这个Bean实现了BeanPostProcessor接口，将会调用postProcessAfterInitialization(Object obj, String s)方法；

以上几个步骤完成后，Bean就已经被正确创建了，之后就可以使用这个Bean了。

（7）DisposableBean：

当Bean不再需要时，会经过清理阶段，如果Bean实现了DisposableBean这个接口，会调用其实现的destroy()方法；

（8）destroy-method：

最后，如果这个Bean的Spring配置中配置了destroy-method属性，会自动调用其配置的销毁方法。

 

7、 解释Spring支持的几种bean的作用域。

Spring容器中的bean可以分为5个范围：

（1）singleton：默认，每个容器中只有一个bean的实例，单例的模式由BeanFactory自身来维护。

（2）prototype：为每一个bean请求提供一个实例。

（3）request：为每一个网络请求创建一个实例，在请求完成以后，bean会失效并被垃圾回收器回收。

（4）session：与request范围类似，确保每个session中有一个bean的实例，在session过期后，bean会随之失效。

（5）global-session：全局作用域，global-session和Portlet应用相关。当你的应用部署在Portlet容器中工作时，它包含很多portlet。如果你想要声明
	让所有的portlet共用全局的存储变量的话，那么这全局变量需要存储在global-session中。全局作用域与Servlet中的session作用域效果相同。

 

8、Spring框架中的单例Beans是线程安全的么？

Spring框架并没有对单例bean进行任何多线程的封装处理。关于单例bean的线程安全和并发问题需要开发者自行去搞定。但实际上，大部分的Spring bean并
没有可变的状态(比如Service类和DAO类)，所以在某种程度上说Spring的单例bean是线程安全的。如果你的bean有多种状态的话（比如 View Model 对象），
就需要自行保证线程安全。最浅显的解决办法就是将多态bean的作用域由“singleton”变更为“prototype”。

9、Spring如何处理线程并发问题？

在一般情况下，只有无状态的Bean才可以在多线程环境下共享，在Spring中，绝大部分Bean都可以声明为singleton作用域，因为Spring对一些Bean中非线程
安全状态采用ThreadLocal进行处理，解决线程安全问题。

ThreadLocal和线程同步机制都是为了解决多线程中相同变量的访问冲突问题。同步机制采用了“时间换空间”的方式，仅提供一份变量，不同的线程在访问前需要
获取锁，没获得锁的线程则需要排队。而ThreadLocal采用了“空间换时间”的方式。

ThreadLocal会为每一个线程提供一个独立的变量副本，从而隔离了多个线程对数据的访问冲突。因为每一个线程都拥有自己的变量副本，从而也就没有必要对
该变量进行同步了。ThreadLocal提供了线程安全的共享对象，在编写多线程代码时，可以把不安全的变量封装进ThreadLocal。

 

10-1、Spring基于xml注入bean的几种方式：

（1）Set方法注入；

（2）构造器注入：①通过index设置参数的位置；②通过type设置参数类型；

（3）静态工厂注入；

（4）实例工厂；



10-2、Spring的自动装配：

在spring中，对象无需自己查找或创建与其关联的其他对象，由容器负责把需要相互协作的对象引用赋予各个对象，使用autowire来配置自动装载模式。

在Spring框架xml配置中共有5种自动装配：

（1）no：默认的方式是不进行自动装配的，通过手工设置ref属性来进行装配bean。

（2）byName：通过bean的名称进行自动装配，如果一个bean的 property 与另一bean 的name 相同，就进行自动装配。 

（3）byType：通过参数的数据类型进行自动装配。

（4）constructor：利用构造函数进行装配，并且构造函数的参数通过byType进行装配。

（5）autodetect：自动探测，如果有构造方法，通过 construct的方式自动装配，否则使用 byType的方式自动装配。

基于注解的方式：

使用@Autowired注解来自动装配指定的bean。在使用@Autowired注解之前需要在Spring配置文件进行配置，<context:annotation-config />。
在启动spring IoC时，容器自动装载了一个AutowiredAnnotationBeanPostProcessor后置处理器，当容器扫描到@Autowied、@Resource或@Inject时，
就会在IoC容器自动查找需要的bean，并装配给该对象的属性。在使用@Autowired时，首先在容器中查询对应类型的bean：

如果查询结果刚好为一个，就将该bean装配给@Autowired指定的数据；

如果查询的结果不止一个，那么@Autowired会根据名称来查找；

如果上述查找的结果为空，那么会抛出异常。解决方法时，使用required=false。

@Autowired可用于：构造函数、成员变量、Setter方法

注：@Autowired和@Resource之间的区别

(1) @Autowired默认是按照类型装配注入的，默认情况下它要求依赖对象必须存在（可以设置它required属性为false）。

(2) @Resource默认是按照名称来装配注入的，只有当找不到与名称匹配的bean才会按照类型来装配注入。

 

11、Spring 框架中都用到了哪些设计模式？

（1）工厂模式：BeanFactory就是简单工厂模式的体现，用来创建对象的实例；

（2）单例模式：Bean默认为单例模式。

（3）代理模式：Spring的AOP功能用到了JDK的动态代理和CGLIB字节码生成技术；

（4）模板方法：用来解决代码重复的问题。比如. RestTemplate, JmsTemplate, JpaTemplate。

（5）观察者模式：定义对象键一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都会得到通知自动更新，如Spring中listener的实现--ApplicationListener。

 

12、Spring事务的实现方式和实现原理：

Spring事务的本质其实就是数据库对事务的支持，没有数据库的事务支持，spring是无法提供事务功能的。真正的数据库层的事务提交和回滚是通过binlog或者redo log实现的。

（1）Spring事务的种类：

spring支持编程式事务管理和声明式事务管理两种方式：

①编程式事务管理使用TransactionTemplate。

②声明式事务管理建立在AOP之上的。其本质是通过AOP功能，对方法前后进行拦截，将事务处理的功能编织到拦截的方法中，也就是在目标方法开始之前加入一个事务，在执行完目标方法之后根据执行情况提交或者回滚事务。

声明式事务最大的优点就是不需要在业务逻辑代码中掺杂事务管理的代码，只需在配置文件中做相关的事务规则声明或通过@Transactional注解的方式，便可以将事务规则应用到业务逻辑中。

声明式事务管理要优于编程式事务管理，这正是spring倡导的非侵入式的开发方式，使业务代码不受污染，只要加上注解就可以获得完全的事务支持。唯一不足地方是，最细粒度只能作用到方法级别，无法做到像编程式事务那样可以作用到代码块级别。

（2）spring的事务传播行为：

spring事务的传播行为说的是，当多个事务同时存在的时候，spring如何处理这些事务的行为。

1) PROPAGATION_REQUIRED：如果当前没有事务，就创建一个新事务，如果当前存在事务，就加入该事务，该设置是最常用的设置。

2) PROPAGATION_SUPPORTS：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就以非事务执行。

3) PROPAGATION_MANDATORY：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就抛出异常。

4) PROPAGATION_REQUIRES_NEW：创建新事务，无论当前存不存在事务，都创建新事务。

5) PROPAGATION_NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。

6) PROPAGATION_NEVER：以非事务方式执行，如果当前存在事务，则抛出异常。

7) PROPAGATION_NESTED：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则按REQUIRED属性执行。

（3）Spring中的隔离级别：

1) ISOLATION_DEFAULT：这是个 PlatfromTransactionManager 默认的隔离级别，使用数据库默认的事务隔离级别。

2) ISOLATION_READ_UNCOMMITTED：读未提交，允许另外一个事务可以看到这个事务未提交的数据。

3) ISOLATION_READ_COMMITTED：读已提交，保证一个事务修改的数据提交后才能被另一事务读取，而且能看到该事务对已有记录的更新。

4) ISOLATION_REPEATABLE_READ：可重复读，保证一个事务修改的数据提交后才能被另一事务读取，但是不能看到该事务对已有记录的更新。

5) ISOLATION_SERIALIZABLE：一个事务在执行的过程中完全看不到其他事务对数据库所做的更新。

 

13、Spring框架中有哪些不同类型的事件？

Spring 提供了以下5种标准的事件：

（1）上下文更新事件（ContextRefreshedEvent）：在调用ConfigurableApplicationContext 接口中的refresh()方法时被触发。

（2）上下文开始事件（ContextStartedEvent）：当容器调用ConfigurableApplicationContext的Start()方法开始/重新开始容器时触发该事件。

（3）上下文停止事件（ContextStoppedEvent）：当容器调用ConfigurableApplicationContext的Stop()方法停止容器时触发该事件。

（4）上下文关闭事件（ContextClosedEvent）：当ApplicationContext被关闭时触发该事件。容器被关闭时，其管理的所有单例Bean都被销毁。

（5）请求处理事件（RequestHandledEvent）：在Web应用中，当一个http请求（request）结束触发该事件。

如果一个bean实现了ApplicationListener接口，当一个ApplicationEvent 被发布以后，bean会自动被通知。

 

14、解释一下Spring AOP里面的几个名词：

（1）切面（Aspect）：被抽取的公共模块，可能会横切多个对象。 在Spring AOP中，切面可以使用通用类（基于模式的风格） 或者在普通类中以 @AspectJ 注解来实现。

（2）连接点（Join point）：指方法，在Spring AOP中，一个连接点 总是 代表一个方法的执行。 

（3）通知（Advice）：在切面的某个特定的连接点（Join point）上执行的动作。通知有各种类型，其中包括“around”、“before”和“after”等通知。许多AOP框架，包括Spring，都是以拦截器做通知模型， 并维护一个以连接点为中心的拦截器链。

（4）切入点（Pointcut）：切入点是指 我们要对哪些Join point进行拦截的定义。通过切入点表达式，指定拦截的方法，比如指定拦截add*、search*。

（5）引入（Introduction）：（也被称为内部类型声明（inter-type declaration））。声明额外的方法或者某个类型的字段。Spring允许引入新的接口（以及一个对应的实现）到任何被代理的对象。例如，你可以使用一个引入来使bean实现 IsModified 接口，以便简化缓存机制。

（6）目标对象（Target Object）： 被一个或者多个切面（aspect）所通知（advise）的对象。也有人把它叫做 被通知（adviced） 对象。 既然Spring AOP是通过运行时代理实现的，这个对象永远是一个 被代理（proxied） 对象。

（7）织入（Weaving）：指把增强应用到目标对象来创建新的代理对象的过程。Spring是在运行时完成织入。

切入点（pointcut）和连接点（join point）匹配的概念是AOP的关键，这使得AOP不同于其它仅仅提供拦截功能的旧技术。 切入点使得定位通知（advice）可独立于OO层次。 例如，一个提供声明式事务管理的around通知可以被应用到一组横跨多个对象中的方法上（例如服务层的所有业务操作）。



15、Spring通知有哪些类型？

（1）前置通知（Before advice）：在某连接点（join point）之前执行的通知，但这个通知不能阻止连接点前的执行（除非它抛出一个异常）。

（2）返回后通知（After returning advice）：在某连接点（join point）正常完成后执行的通知：例如，一个方法没有抛出任何异常，正常返回。 

（3）抛出异常后通知（After throwing advice）：在方法抛出异常退出时执行的通知。 

（4）后通知（After (finally) advice）：当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）。 

（5）环绕通知（Around Advice）：包围一个连接点（join point）的通知，如方法调用。这是最强大的一种通知类型。 环绕通知可以在方法调用前后完成
	自定义的行为。它也会选择是否继续执行连接点或直接返回它们自己的返回值或抛出异常来结束执行。 环绕通知是最常用的一种通知类型。大部分基于拦截的AOP框架，例如Nanning和JBoss4，都只提供环绕通知。 

同一个aspect，不同advice的执行顺序：

①没有异常情况下的执行顺序：

around before advice
before advice
target method 执行
around after advice
after advice
afterReturning

②有异常情况下的执行顺序：

around before advice
before advice
target method 执行
around after advice
after advice
afterThrowing:异常发生
java.lang.RuntimeException: 异常发生


讲讲Spring加载流程。
初始化环境—>加载配置文件—>实例化Bean—>调用Bean显示信息


Spring AOP的实现原理。
将与业务无关，却被业务模块共同调用的逻辑封装起来，
Spring提供了两种方式生成代理对象：JDKProxy和Cglib具体使用哪种方式生成由AopProxyFactory根据AdvisedSupport对象的配置来决定。


讲讲Spring事务的传播属性。
PROPAGATION_REQUIRED:如果当前没有事务，就创建一个新事务，如果当前存在事务，就加入当前事务(都执行成功才提交，有一个失败就回滚)
PROPAGATION_REQUIRES_NEW:无论当前是否存在事务，都创建一个新事务(事务成败与否，不会影响其它事务)
PROPAGATION_NESTED:如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作(内层事务失败与否不会影响外层事务，外层事务回滚，内层事务也回滚)


Spring如何管理事务的。
PlatformTransactionManager：事务管理器，主要用于平台相关事务的管理。
TransacitonDefinition：事务定义信息，用来定义事务相关属性。
TransationStatus：事务具体运行状态，事务管理过程中，每个时间点事务的状态信息。


Spring怎么配置事务（具体说出一些关键的xml 元素）。
1）基于XML的事务配置  2）基于注解方式的事务配置(@Transactional)。
编程式事务使用TransactionTemplate或者直接使用底层的PlatformTransactionManager。
声明式事务是建立在AOP之上的。其本质是对方法前后进行拦截，然后在目标方法开始之前创建或者加入一个事务，在执行完目标方法之后根据执行情况提交或者回滚事务。
声明式事务管理要优于编程式事务管理，这正是spring倡导的非侵入式的开发方式。


说说你对Spring的理解，非单例注入的原理？它的生命周期？循环注入的原理，aop的实现原理，说说aop中的几个术语，它们是怎么相互工作的。
IOC和AOP框架
IOC控制反转：由spring来负责控制对象的生命周期和对象间的关系。
			所有的类都会在Spring中登记，Spring管理所有的对象，当某个具体类需要什么对象的时候，不需要自己创建对象，直接调用spring即可。
			最常见的方式叫做依赖注入（Dependency Injection，简称DI），还有一种方式叫“依赖查找”（Dependency Lookup）。
DI依赖注入：在程序运行中，动态的向某个对象提供它所需要的其他对象。
		   spring使用java bean对象的set方法或者带参数的构造方法，在创建对象的过程中将其属性自动设置为设定值
           set方法注入、构造方法注入、静态工厂方法注入、实例工厂方法注入
AOP面向切面编程：将一个个对象某些类似的方面横向抽象成一个切面，对这个切面进行一些如权限验证，事务管理，记录日志等公共操作
生命周期：创建(实例化:分配内存空间、初始化:属性注入)-使用-销毁。IOC容器启动时，并没有初始化所有对象，只有调用getBean()才会触发bean的初始化操作。
循环注入：两个或多个Bean相互之间的持有对方，比如A引用B，B引用C，C引用A。
		 构造器循环依赖，无法解决，抛出BeanCurrentlyInCreationException
		 setter方法循环注入。


netty的线程模型，netty如何基于reactor模型上实现的。
多路复用IO，select、poll、epoll


为什么选择netty。
稳定，API使用简单，开发门槛低


什么是TCP粘包，拆包。解决方式是什么。
TCP粘包：socket读取时，读到了实际意义上的两个或多个数据包的内容，同时将其作为一个数据包进行处理。
TCP拆包：socket读取时，没有完整地读取一个数据包，只读取一部分。
解决方法：数据段定长，位数不足的空位补齐；
		 消息头+消息体，消息头中一般会包含消息体的长度、消息类型等信息；
		 特殊字符(比如回车符)作为消息数据的结尾，以实现消息数据的分段
		 通过复杂的应用层协议


netty的fashwheeltimer的用法，实现原理，是否出现过调用不够准时，怎么解决。
时间轮算法


netty的心跳处理在弱网下怎么办。
心跳机制:在长链接中双方没有数据交互的时候互相发送数据(可能是空包，也可能是特殊数据)，对方收到该数据之后也回复相应的数据用以确保双方都在线。
一般实现心跳机制由两种方式：TCP协议自带的心跳机制来实现；在应用层实现。
通常采用应用层自定义实现：Client启动一个定时器，不断发送心跳；Server收到心跳后，做出回应；Server启动一个定时器，判断Client是否存在，
					   这里做判断有两种方法：时间差和简单标识。


netty的通讯协议是什么样的。


springmvc用到的注解，作用是什么，原理。
DispatcherServlet前端控制器，HandlerMapping处理器映射，Controller，VierResolver视图解析器
SpringMVC运行原理：
1.客户端提交请求到DispatchServlet
2.DispatchServlet查询一个或多个HandleMapping，找到处理请求的Controller
3.DispatchServlet将请求交给Controller
4.Controller调用相应的xxxService方法，返回ModelAndView
5. DispatcherServlet查询一个或多个ViewResoler视图解析器，找到ModelAndView指定的视图
6.View视图将结果显示到客户端
常用注解：
@Controller 声明Action组件
@Service 声明Service组件 @Service("myMovieLister")
@Repository 声明Dao组件
@Component 泛指组件, 当不好归类时.
@RequestMapping("/menu") 请求映射
@Resource 用于注入，(j2ee提供的)默认按名称装配，@Resource(name="beanName")
@Autowired 用于注入，(srping提供的)默认按类型装配
@Transactional(rollbackFor={Exception.class})事务管理
@ResponseBody
@Scope("prototype") 设定bean的作用域


SSM 和 Springboot 的最大区别
1.Springboot 将原有的 xml 配置，简化为 java 注解
2.使用 IDE 可以很方便的搭建一个 springboot 项目，选择对应的 maven 依赖，简化Spring应用的初始搭建以及开发过程
3.springboot 有内置的 tomcat 服务器，可以 jar 形式启动一个服务,可以快速部署发布 web 服务
4.springboot 使用 starter 依赖自动完成 bean 配置，解决 bean 之间的冲突，并引入相关的 jar 包（这一点最重要）


springboot启动机制。
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@SpringBootApplication详解：
@SpringBootConfiguration             // 继承了Configuration，表示当前是注解类
@EnableAutoConfiguration             // 开启springboot的注解功能，springboot的四大神器之一，其借助@import的帮助
@ComponentScan(excludeFilters = {    // 扫描路径设置（具体使用待确认）
public @interface SpringBootApplication {
...
}

虽然定义使用了多个Annotation进行了原信息标注，但实际上重要的只有三个Annotation：
@Configuration（@SpringBootConfiguration点开查看发现里面还是应用了@Configuration）
@EnableAutoConfiguration
@ComponentScan

@Configuration：使用注解方式
基于XML的配置形式是这样：
<bean id="mockService" class="..MockServiceImpl">         
    ...
</bean>
而基于JavaConfig的配置形式是这样的：
@Configuration
public class MockConfiguration{
    @Bean
    public MockService mockService(){
        return new MockServiceImpl();
    }
}

@ComponentScan：
自动扫描并加载符合条件的组件（比如@Component和@Repository等）或者bean定义，将这些bean定义加载到IoC容器中。

@EnableAutoConfiguration：
借助@Import的帮助，将所有符合自动配置条件的bean定义加载到IoC容器


1、什么是 Spring Boot？
Spring Boot 是 Spring 开源组织下的子项目，是 Spring 组件一站式解决方案，主要是简化了使用 Spring 的难度，简省了繁重的配置，提供了各种启动器，开发者能快速上手。


2、为什么要用 Spring Boot？
Spring Boot 优点非常多，如：
独立运行
简化配置
自动配置
无代码生成和XML配置
应用监控
上手容易
...


3、Spring Boot 的核心配置文件有哪几个？它们的区别是什么？
Spring Boot 的核心配置文件是 application 和 bootstrap 配置文件。
application 配置文件这个容易理解，主要用于 Spring Boot 项目的自动化配置。
bootstrap 配置文件有以下几个应用场景：
使用 Spring Cloud Config 配置中心时，这时需要在 bootstrap 配置文件中添加连接到配置中心的配置属性来加载外部配置中心的配置信息；
一些固定的不能被覆盖的属性；
一些加密/解密的场景；


4、Spring Boot 的配置文件有哪几种格式？它们有什么区别？
.properties 和 .yml，它们的区别主要是书写格式不同。
.properties
app.user.name = javastack

.yml
app:
  user:
    name: javastack
另外，.yml 格式不支持 @PropertySource 注解导入配置。


5、Spring Boot 的核心注解是哪个？它主要由哪几个注解组成的？
启动类上面的注解是@SpringBootApplication，它也是 Spring Boot 的核心注解，主要组合包含了以下 3 个注解：
@SpringBootConfiguration：组合了 @Configuration 注解，实现配置文件的功能。
@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能： @SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })。
@ComponentScan：Spring组件扫描。


6、开启 Spring Boot 特性有哪几种方式？
1）继承spring-boot-starter-parent项目
2）导入spring-boot-dependencies项目依赖


7、Spring Boot 需要独立的容器运行吗？
可以不需要，内置了 Tomcat/ Jetty 等容器。


8、运行 Spring Boot 有哪几种方式？
1）打包用命令或者放到容器中运行
2）用 Maven/ Gradle 插件运行
3）直接执行 main 方法运行


9、Spring Boot 自动配置原理是什么？
注解 @EnableAutoConfiguration, @Configuration, @ConditionalOnClass 就是自动配置的核心，首先它得是一个配置文件，其次根据类路径下是否有这个类去自动配置。


10、Spring Boot 的目录结构是怎样的？
cn
 +- javastack
     +- MyApplication.java
     |
     +- customer
     |   +- Customer.java
     |   +- CustomerController.java
     |   +- CustomerService.java
     |   +- CustomerRepository.java
     |
     +- order
         +- Order.java
         +- OrderController.java
         +- OrderService.java
         +- OrderRepository.java

这个目录结构是主流及推荐的做法，而在主入口类上加上 @SpringBootApplication 注解来开启 Spring Boot 的各项能力，如自动配置、组件扫描等。


11、你如何理解 Spring Boot 中的 Starters？
Starters可以理解为启动器，它包含了一系列可以集成到应用里面的依赖包，你可以一站式集成 Spring 及其他技术，而不需要到处找示例代码和依赖包。
如你想使用 Spring JPA 访问数据库，只要加入 spring-boot-starter-data-jpa 启动器依赖就能使用了。Starters包含了许多项目中需要用到的依赖，
它们能快速持续的运行，都是一系列得到支持的管理传递性依赖。


12、如何在 Spring Boot 启动的时候运行一些特定的代码？
可以实现接口 ApplicationRunner 或者 CommandLineRunner，这两个接口实现方式一样，它们都只提供了一个 run 方法。


13、Spring Boot 有哪几种读取配置的方式？
Spring Boot 可以通过 @PropertySource,@Value,@Environment, @ConfigurationProperties 来绑定变量。


14、Spring Boot 支持哪些日志框架？推荐和默认的日志框架是哪个？
Spring Boot 支持 Java Util Logging, Log4j2, Lockback 作为日志框架，如果你使用 Starters 启动器，Spring Boot 将使用 Logback 作为默认日志框架。


15、SpringBoot 实现热部署有哪几种方式？
主要有两种方式：
Spring Loaded
Spring-boot-devtools


16、你如何理解 Spring Boot 配置加载顺序？
在 Spring Boot 里面，可以使用以下几种方式来加载配置。
1）properties文件；
2）YAML文件；
3）系统环境变量；
4）命令行参数；
……


17、Spring Boot 如何定义多套不同环境配置？
提供多套配置文件，运行时指定具体的配置文件。如：
applcation.properties
application-dev.properties
application-test.properties
application-prod.properties


18、Spring Boot 可以兼容老 Spring 项目吗，如何做？
可以兼容，使用 @ImportResource 注解导入老 Spring 项目配置文件。


19、保护 Spring Boot 应用有哪些方法？
在生产中使用HTTPS
使用Snyk检查你的依赖关系
升级到最新版本
启用CSRF保护
使用内容安全策略防止XSS攻击
...


20、Spring Boot 2.X 有什么新特性？与 1.X 有什么区别？
配置变更
JDK 版本升级
第三方类库升级
响应式 Spring 编程支持
HTTP2.0 支持
配置属性绑定
...


架构设计与分布式

多人同时操作同一条数据，如何保证不出错
利用数据库层面的锁、事务、给数据加上一列last update time；分布式锁


2PC和3PC简述
分布式事务/分布式协议/分布式一致性算法
两阶段提交：分为准备阶段和提交阶段，提议的节点称为协调者，参与投票的节点称为参与者。
           准备阶段，协调者发起一个提议，分别询问各参与者是否接受；
           提交阶段，协调者根据参与者的反馈，提交或中止事务，如果参与者全部同意则提交，只要有一个参与者不同意就中止。
存在的问题：同步阻塞问题。所有参与的节点都是阻塞的，如果部分节点回应慢，会导致其它节点长时间锁定公共资源。
		   单点故障。协调者宕机会导致参与者长时间等待。
		   数据不一致。提交阶段，由于网络原因，只有部分参与者收到commit信息，导致部分参与者提交，部分参与者未提交。
		   协调者和参与者宕机。协调者发送完commit后宕机，唯一收到该信息的参与者也宕机了，那么即使通过选举协议重新选举出协调者，这条事务的状态也是未知的。
三阶段提交：CanCommit阶段  协调者向参与者发送CanCommit请求，询问是否可以执行事务提交操作。然后开始等待参与者的响应。
		   PreCommit阶段  发送预提交请求 协调者向参与者发送PreCommit请求，并进入Prepared阶段。
						  事务预提交 参与者接收到PreCommit请求后，会执行事务操作，并将undo和redo信息记录到事务日志中。
						  响应反馈 如果参与者成功的执行了事务操作，则返回ACK响应，同时开始等待最终指令。
						  假如有任何一个参与者向协调者发送了No响应，或者等待超时之后，协调者都没有接到参与者的响应，那么就执行事务的中断
		   doCommit阶段   发送提交请求 协调接收到参与者发送的ACK响应，那么他将从预提交状态进入到提交状态。并向所有参与者发送doCommit请求。
						  事务提交 参与者接收到doCommit请求之后，执行正式的事务提交。并在完成事务提交之后释放所有事务资源。
						  响应反馈 事务提交完之后，向协调者发送Ack响应。
						  完成事务 协调者接收到所有参与者的ack响应之后，完成事务。
2PC和3PC区别：引入超时机制。同时在协调者和参与者中都引入超时机制。
			 在第一阶段和第二阶段中插入一个准备阶段。保证了在最后提交阶段之前各参与节点的状态是一致的。


分布式集群下如何做到唯一序列号。
1.数据库自增长序列或字段：在单个数据库或读写分离或一主多从的情况下，只有一个主库可以生成，有单点故障的风险
2.UUID：全球唯一；没有排序，无法保证趋势递增；使用字符串存储，查询的效率比较低；存储空间大
3.Redis生成ID：利用Redis的原子操作 INCR和INCRBY。比如一个集群中有5台Redis。可以初始化每台Redis的值分别是1,2,3,4,5，然后步长都是5
4.Twitter的snowflake算法


设计一个秒杀系统，30分钟没付款就自动关闭交易。
前端：页面静态化、禁止重复提交(按钮点击后响应前置灰)
后端：扩展。对于用户的请求，映射到不同的数据库，减少单台数据库的压力。
     缓存。将参加秒杀的商品信息事先缓存到redis等缓存系统中，这样可以大大的提高系统的吞吐量，减少关系型数据库的读写压力。
     限流。在库存没有之后，将前端的秒杀入口关闭。
     削峰。将大量涌入的请求添加到消息中间件中。
如何抗住高并发：
配置静态页面；提前将静态页面刷新到cdn节点；将H5页面部署在公有云上，便于动态扩展；在提供秒杀业务功能的服务器上，需要进行限流和熔断，防止秒杀
业务影响其它正常服务的功能，比如使用hystrix，当流量超过限定阈值后，返回失败报文；服务降级，首页、购物车、订单查询、大数据等功能都会进行一定程
度的服务降级，以保证秒杀系统能得到系统最大支持。
如何防止超卖：
思路1：实时库存的扣减在缓存(比如redis)中进行，然后异步扣减数据库中的库存，保证缓存中和数据库中库存的最终一致性。
思路2：将要促销的商品数量以list的方式存入redis中，每当用户抢到一件促销商品则从队列中删除一个数据，确保商品不会超卖。


如何使用redis和zookeeper实现分布式锁？ 有什么区别优缺点，会有什么问题，分别适用什么场景。（如果知道redlock，讲讲算法实现，争议在哪里）
1.基于数据库表主键唯一做分布式锁
对请求信息进行hash运算,得到一个hash值,并以此作为主键保存到数据库中，保存成功之后,才进行正常的业务逻辑处理。
如果有多个相同请求同时提交请求，它们对请求信息的hash值是相同的，由于主键唯一性，数据库会保证只有一个操作可以成功，那么我们就可以认为操作成功
的那个线程获得了该方法的锁。当方法执行完毕之后，删除这条数据库记录即可释放锁。

2.基于表字段Version做分布式锁
为每个表设计一个Version字段，然后每次写sql都要带着Version字段。
-- 添加版本号控制字段
ALTER TABLE table ADD COLUMN version INT DEFAULT '0' NOT NULL AFTER t_bonus;

-- 线程1查询，当前left_count为1，则有记录，当前版本号为1234
select left_count, version from t_bonus where id = 10001 and left_count > 0

-- 线程2查询，当前left_count为1，有记录，当前版本号为1234
select left_count, version from t_bonus where id = 10001 and left_count > 0

-- 线程1,更新完成后当前的version为1235，update状态为1，更新成功
update t_bonus set version = 1235, left_count = left_count-1 where id = 10001 and version = 1234

-- 线程2,更新由于当前的version为1235，udpate状态为0，更新失败，再针对相关业务做异常处理
update t_bonus set version = 1235, left_count = left_count-1 where id = 10001 and version = 1234

3.基于数据库排他锁做分布式锁
使用 select for update，数据库会在查询过程中给行/表增加排他锁。我们可以认为获得排他锁的线程即可获得分布式锁，当获取到锁之后，
可以执行方法的业务逻辑，执行完方法之后，通过connection.commit()操作来释放锁。

4.基于Redis做分布式锁
4.1 基于Redis的 SETNX()、EXPIRE() 方法做分布式锁
setnx key value，该方法是原子的，若当前已经存在key，则设置key失败返回0，如果key不存在，则设置key成功返回1；
expire key seconds，设置key的过期时间；
步骤一、setnx(lockkey, 1) 如果返回 0，则说明占位失败；如果返回 1，则说明占位成功
步骤二、expire() 命令对 lockkey 设置超时时间，为的是避免死锁问题。
步骤三、执行完业务代码后，可以通过 delete 命令删除 key。
存在的问题：setnx成功后、expire执行前，若服务器宕机，仍然可能会出现死锁

4.2 基于Redis的 SETNX()、GET()、GETSET()方法做分布式锁
getset key value，设置新值返回旧值；
步骤一、setnx(lockkey,当前时间+过期超时时间)，如果返回1，则获取锁成功，如果返回0，则没有获取锁，转2
步骤二、get(lockkey)获得oldExpireTime，若小于当前时间，说明锁已经过期，别的请求可以获取锁
步骤三、getset(lockkey,当前时间+过期超时时间)获得currentExpireTime
步骤四、比较oldExpireTime和currentExpireTime，若两者相等，说明成功获取到锁，若不相等，说明get和getset期间有别的请求获取到了锁
步骤五、在获取到所之后，当前线程可以开始业务处理，当执行完毕后，比较执行时间和锁过期超时时间，若小于超时时间，则执行del lockkey释放锁，若大于锁超时时间，则不需要进行锁处理

5.基于 RedLock 做分布式锁
它基于N个完全独立的Redis节点(通常情况下N可以设置成5)
步骤一、client获取当前时间t0
步骤二、使用4.2 的方法向N个节点申请锁，client需要设置访问接口超时时间(远小于锁超时时间)，比如锁自动释放的时间是 10s，那么接口超时大概设置
5-50ms。这样可以在有 redis 节点宕机后，访问该节点时能尽快超时，跳到下一个节点去申请锁。
步骤三、client通过当前时间t1减去t0，计算获得锁消耗的时间t2，如果t2小于锁超时时间并且client在超过半数的节点上获得锁，则认为锁获取成功
步骤四、如果client获取锁失败了，client会依次删除已经获取的节点锁。

6.基于 ZooKeeper 做分布式锁
zk 一般由多个节点构成（单数），采用zab一致性协议。因此可以将 zk 看成一个单点结构，对其修改数据其内部自动将所有节点数据进行修改而后才提供查询服务。
zk 的数据以目录树的形式，每个目录称为 znode， znode 中可存储数据（一般不超过 1M），还可以在其中增加子节点。
子节点有三种类型：序列化节点，每在该节点下增加一个节点自动给该节点的名称上自增。临时节点，一旦创建这个 znode 的客户端与服务器失去联系，这个 znode 也将自动删除。最后就是普通节点。
Watch 机制，client可以监控每个节点的变化，当发生变化会给 client 产生一个事件。
锁服务分两种，一个是保持独占，一个是控制时序。 
保持独占
步骤一、所有客户端都去创建/distribute_lock节点，创建成功则获得锁，用完删除自己创建的/distribute_lock节点。
控制时序
步骤一、所有客户端在预先存在的/distribute_lock节点下面创建临时顺序节点
步骤二、只有序号最小的可以拥有锁，如果这个节点序号不是最小则watch序号比本身小的前一个节点/序号最小的节点(公平锁/非公平锁)。等待watch事件到来后，再次判断是否序号最小。
步骤三、取锁成功则执行代码，最后释放锁(删除临时节点)。


分布式事务的原理，优缺点，如何使用分布式事务。
两阶段提交、三阶段提交、Paxos
优点是可以管理多机事务，拥有无限扩展性 缺点是易用性难，有延时风险


什么是一致性hash。
一致性Hash算法是对2^32取模，将整个哈希值空间顺时针组织成一个虚拟的圆环(0~2^32-1)；然后将服务器根据IP进行哈希，确定其在环上的位置。
接着分配数据到服务器：将数据key使用相同的函数计算哈希值，并确定此数据在环上的位置，从此位置沿环顺时针“行走”，第一台遇到的服务器就是其定位到的服务器。
容错性和可扩展性强
一致性Hash算法在服务器节点太少时，容易因为节点分部不均匀而造成数据倾斜，可以引入虚拟节点。


什么是restful，讲讲你理解的restful。
面向资源；url不包含动词：GET /zoos/ID/animals：列出某个指定动物园的所有动物
表述性状态转移。URI统一资源标识符，URL统一资源定位符
每一个URI代表一种资源；客户端通过四个HTTP动词(post增del删put改get查)，对服务器资源进行操作，实现"状态转化"。


如何设计一个良好的API。
明确职责；
单一性原则：一个接口只做一件事；
协议规范：采用 http/https/ftp；
路径规则：由于api获取的是一种资源，所以网址中尽量为名词，而非动词，比如/api/v1.0/Pruduct/2019；
http请求方式：get(获取)，post(新增)，put(修改)和delete(删除)
域名：域名分为主域名和专有域名，主域名适合api长期不变或变化较少的业务，专有域名是解决具体的专有业务的，比如主域名:www.baidu.com  百度文库 https://wenku.baidu.com/ 百度公益 http://gongyi.baidu.com
适度过滤信息：当记录数比较多时(如 SELECT * FROM TBName)，因适当添加一些条件对数据进行过滤，如TOP,分页,分组，排序和WHERE条件等，比如 ?limit=100：返回100条数据，?offset=101：从第101条数据开始返回
返回数据格式：采用json (1)失败情况(状态码、错误码和错误描述) (2)成功情况(状态码，标识id,数据对象)


如何设计建立和保持100w的长连接。
Netty NIO框架，增加xmx最大堆内存


解释什么是 MESI 协议(Intel的CPU核之间的缓存一致性协议)
任何多核系统中的缓存都处于如下四种状态之中：
失效（Invalid）缓存行，要么已经不在缓存中，要么它的内容已经过时。为了达到一致性目的，这种状态的缓存航将会被忽略。一旦缓存行被标记为失效，那效果就等同于它从来没被加载到缓存中。
共享（Shared）缓存行，它是和主内存内容保持一致的一份拷贝，在这种状态下的缓存行只能被读取，不能被写入。多组缓存可以同时拥有针对同一内存地址的共享缓存段，这就是名称的由来。
独占（Exclusive）缓存行，和共享状态一样，也是和主内存内容保持一致的一份拷贝。区别在于，如果一个处理器持有了某个独占状态的缓存行，那其他处理器就不能同时持有它，所以叫“独占”。这意味着，如果其他处理器原本也持有同一缓存行，那么它会马上变成“失效”状态。
已修改（Modified）缓存行，属于脏行，它们已经被所属的处理器修改了。如果一个段处于已修改状态，那么它在其他处理器缓存中的副本马上会变成失效状态，
此外，已修改缓存行如果被丢弃或标记为失效，那么先要把它的内容回写到内存中——这和回写模式下常规的脏段处理方式一样。


说说你知道的几种HASH算法，简单的也可以。
HASH算法：MD4、MD5、SHA-1，应用：文件校验，数字签名、鉴权协议
常用的构造散列函数的方法：
直接寻址法：取关键字或关键字的某个线性函数值为散列地址
数字分析法：寻找冲突小的数字部分
平方取中法：取关键字平方后的中间几位作为散列地址
随机数法、除数取余法
解决冲突的办法：线性探查法、双散列函数法、链表法


什么是paxos算法， 什么是zab协议。
paxos：Proposer提案者、acceptor投票者、learner学习者。只有被提出propose的值才可能被最终选定chosen。只有一个值会被选定chosen。进程只会获知到已经确认被选定chosen的值。
zab：Zookeeper Atomic Broadcast Zookeeper原子广播协议，一种支持崩溃恢复和原子广播的协议，整个 Zookeeper 就是在这两个模式之间切换。
基于该协议，Zookeeper 实现了一种主备模式的系统架构来保持集群中各个副本之间数据一致性。所有客户端写入数据都是写入到主进程(Leader)中，然后由Leader复制到备份进程(Follower)中，从而保证数据一致性。
消息广播:Zab协议的消息广播过程使用的是一个原子广播协议，类似一个 2PC。对于客户端发送的写请求，全部由 Leader 接收，Leader 将请求封装成一个事务
Proposal，将其发送给所有 Follower ，然后如果超过半数Follower成功响应，则执行 commit 操作。
崩溃恢复: Leader 选举算法能够保证新选举出来的 Leader 服务器拥有集群中最大的事务编号ZXID，那么就能够保证这个新选举出来的 Leader 一定具有所有已经提交的提案。


一个在线文档系统，文档可以被编辑，如何防止多人同时对同一份文档进行编辑更新
点击编辑的时候，利用redis的setNX进行加锁，并expire设置过期时间；使用版本号进行控制


线上系统突然变得异常缓慢，你如何查找问题。
第一步
top命令，查看CPU、内存、磁盘、I/O、网络带宽哪个因素导致系统变慢
如果是cpu占用过高，查看占用cpu高的进程，jstack生成进程的栈信息，看是否发生频繁 Full GC，如果是，需要查看一下堆内存快照，看看是否有内存泄漏；
如果是磁盘占用过高，及时清理磁盘；如果是带宽占用过大，请找网络工程师。如果都不是走第二步。
第二步
检查应用服务器Tomcat的线程池配置是否合理，看一下请求排队是否严重，如果严重则需要重新设置合理的线程池。同样，检查一下数据库的连接池设置是否合理，
是否需要增大数据库连接池，同时检查一下是否有慢sql，如果有慢sql，则进行优化（优化方案是查看执行计划，设置合理的索引等）。
第三步
查看访问慢的服务的调用链，到底是因为调用哪个服务过慢，导致整体变慢，联系相关系统的负责人进行排查和解决。
第四部
检查web服务器的请求日志，看一下是否存在DDos攻击，如果有DDoS攻击，则将攻击者的IP添加到防火墙的黑名单里。


说说你平时用到的设计模式。
单例模式、抽象工厂、适配器模式、外观模式、观察者模式、装饰器模式、迭代器模式、策略模式、建造者模式
具体例子见java_study


Dubbo的原理，有看过源码么，数据怎么流转的，怎么实现集群，负载均衡，服务注册和发现，重试转发，快速失败的策略是怎样的 。
一次RPC请求的流程是什么。
自己实现过rpc么，原理可以简单讲讲。Rpc要解决什么问题。


编程中自己都怎么考虑一些设计原则的，比如开闭原则，以及在工作中的应用。
对扩展开放，对修改封闭


MVC模式，即常见的MVC框架。
spring、struts


如何实现负载均衡，有哪些算法可以实现。
轮询法：将请求按顺序依次分配到服务器上，达到请求分布的绝对平衡。适用于机器性能相同的场景
随机法：通过系统随机函数，根据后台服务器列表的大小值来随机选取其中一台进行访问。适用于机器性能相同的场景
随机轮询法：随机选择第一个节点，之后仍像轮询法一样，依次分配
源地址哈希法：客户端IP哈希值%服务端列表，IP相同、服务器列表不变，每次都将访问同一个列表，可以增加缓存命中率
加权轮询法：Nginx的默认算法。配置高的服务器分配高权重，配置低的服务器分配低权重，具体实现：每次选择权重最大节点，然后对其减1，如果所有服务器权重都为0，则恢复初始权重
加权随机法：依据权重随机选择服务器，权重大被选中的几率大
最小连接数法：根据服务器当前的连接情况，动态选取当前积压连接数最少的服务器来处理请求，尽可能提高服务器利用率，将负载合理的分流到每一台服务器
最小延迟法：请求服务器的往返延迟（RTT），动态地选择延迟最低的服务器处理当前请求


Zookeeper的用途，选举的原理是什么。
zk的用途：1.命名服务 2.配置管理 3.集群管理 4.分布式锁 5.队列管理	
命名服务：通过指定的名字来获取资源或者服务的地址。zk会在自己的文件系统上创建一个以路径为名称的节点，它可以指向提供服务的地址，远程对象等。
配置管理：将各个程序的配置全部放在zk的某个目录节点上，然后所有相关程序监听该节点，一旦配置信息发生变化，每个应用程序就会收到zk的通知。
集群管理：主要有两点，一个是机器退出和加入，一个是选举master。 
		 对于第一点，所有机器约定在父目录GroupMembers下创建临时目录节点，然后监听该节点的子节点变化消息。一旦有机器挂掉，导致与zk断开连接，
		 其创建的临时目录节点会被删除，其他机器都会收到通知。新机器加入也是类似，所有机器收到通知：新兄弟目录加入。
		 对于第二点，可以让所有机器创建临时顺序目录节点，每次选取编号最小的机器作为master。
分布式锁：锁服务分两种，一个是保持独占，另一个是控制时序。 
		 对于第一类，我们将zk上的一个znode看作是一把锁，通过createznode的方式来实现。所有客户端都去创建/distribute_lock节点，最终成功创建的
		 那个客户端拥有这把锁，用完删除自己创建的distribute_lock 节点就释放了锁。
		 对于第二类，/distribute_lock节点已经预先存在，所有客户端在它下面创建临时顺序编号目录节点，和选master一样，编号最小的获得锁，用完删除。
队列管理：一种是同步队列，当队列成员都聚齐时，这个队列才可用，否则一直等待。 在约定目录下创建临时目录节点，监听节点数目是否达到我们要求的数目。
		 一种是FIFO队列，和分布式锁服务中的控制时序场景基本原理一致，入列有编号，出列按编号。

ZooKeeper是一个分布式应用程序协调服务，它是集群的管理者，监视着集群中各个节点的状态,根据节点提交的反馈进行下一步合理操作。
(1)文件系统
zk文件系统 每个子目录项如 NameService 都被称作为znode，和文件系统一样，我们能够自由的增加、删除znode，在一个znode下增加、删除子znode，唯一的
不同在于znode可以存储数据。 有四种类型的znode，持久化目录节点、持久化顺序目录节点(客户端与zookeeper断开连接后，该节点依旧存在，并且zk给该节点名称进行顺序编号)
临时目录节点和临时顺序目录节点。
(2)通知机制
客户端注册监听它关心的目录节点，当目录节点发生变化(数据改变、被删除、子目录节点增加删除)时，zookeeper会通知客户端。

选举过程
当leader崩溃或者leader失去大多数的follower，这时候zk进入恢复模式，恢复模式需要重新选举出一个新的leader，让所有的Server都恢复到一个正确的
状态。Zk的选举算法有两种：一种是基于basic paxos实现，另外一种是基于fast paxos算法实现。系统默认的选举算法为fast paxos。


Zookeeper watch机制原理。
所有的Zookeeper读操作，包括getData()、getChildren()和exists()，都有一个开关，可以在操作的同时再设置一个watch。Watch是一个一次性触发器，
会在被设置watch的数据发生变化的时候，发送事件给设置watch的客户端(类似于Redis的Watch)。
Watch是异步发送的。但ZooKeeper保证了一个顺序：一个客户端在收到watch事件之前，一定不会看到它设置过watch的值变动。


请思考一个方案，实现分布式环境下的countDownLatch。
每个子任务在zk文件系统的指定目录下创建一个临时目录文件，每当子任务完成，删除自己创建的节点。主任务监听该目录，当该目录下没有子文件，主任务启动。


后台系统怎么防止请求重复提交。
如果是单体服务器,我们可以通过多线程的常规锁解决,但是目前大部分系统,采用了多机负载均衡。
后端解决办法：方式一：在服务器端，生成一个唯一的Token标识符，将它存入session，同时将它写入表单的隐藏字段中，然后将表单页面发给浏览器，用户
			        录入信息后点击提交，在服务器端，获取表单中隐藏字段的值，与session中的唯一标识符比较，相等说明是首次提交，处理本次请求，
			        然后将session中的唯一标识符移除。不相等说明是重复提交，不再处理。
			 方式二：基于数据库主键唯一性的分布式锁、Redis setnx分布式锁、Zookeeper分布式锁。

前端解决办法：Js防止表单重复提交。方式一：设置标志符，提交后置为false，后序即使点了按钮也不提交后台。
							   方式二：按钮置灰，不可再用。
			 Redirect重定向到"提交成功"页面。
			 使用Cookie处理，设置是否提交的键值对，若已提交，提示客户端已提交。


描述一个服务从发布到被消费的详细过程。
dubbo


讲讲你理解的服务治理。
服务治理指的是管理微服务。网关就是整个整体的守门人，日志采集，追踪工具，服务注册发现都是用来采集信息的，然后需要监控平台来展现这些采集的信息，
并进行监控和分析。最后根据分析的结果采取治理策略，有的服务快撑不住了要限流，有的服务坏了要熔断，并且还能够及时的调整这些服务的配置。

常用工具如下：
Eureka，这是一个用来注册服务的工具，通过简单的配置，在服务启动的时候就会自动注册到Eureka服务器上。
Hystrix，这是一个用来保护服务的熔断工具，虽然最近宣布已经停止维护更新了。
Zuul，这是一个用来对请求进行路由的服务网关工具，最近的zuul2采用了Netty实现了异步非阻塞编程模型。
Ribbon，这是一个用来分配请求的负载均衡工具
Feign，这是一个用来更方便调用其它服务的工具，也能进行负载均衡
Archaius，这是一个管理配置API的工具
Spring Cloud Config，用来对配置进行管理，可以把每个服务的配置放在远端服务器以方便进行配置修改
Spring Cloud Sleuth，Tracing采集工具包，对Zipkin，HTrace进行了封装
Spring Cloud Consul，封装了Consul操作，同样是用来进行服务注册发现的
Spring Cloud Zookeeper，封装了Zookeeper，也是用来进行服务注册发现的
Spring Cloud Gateway，给Spring MVC提供API网关功能的工具，里面也包含安全处理等特性
除了Spring Cloud和Netfix提供的这些工具以外，还有下面这些工具也经常在服务监控治理中被使用：
Dubbo，自称是一个高性能的Java RPC框架，但是其实广泛用于服务注册发现，提供三个核心能力：面向接口的远程方法调用，智能容错和负载均衡，服务注册发现。
logback，java日志框架，是log4j的升级版本
ElasticSearch，虽然是一个搜索引擎和分析框架，但因为提供很好的存储和查询性能，所以经常用于日志的采集和存储
Kibana，Elastic的可视化插件，可以配合Elastic使用可视化查询日志
logstash，Elastic的日志分析工具
grafna，时序性分析工具，提供漂亮的图形化界面
Promethues，强大系统监控和报警框架，提供多维度数据模型，灵活强大的查询语句，有多种可视化图形界面
Spring boot admin，用来管理Spring Boot应用的工具，提供可视化的用户界面
Zipkin，分布式追踪工具，用来采集程序的延时数据
Htrace，Apache的分布式追踪工具。
resilience4j，用来被Hystrix指定作为熔断的替代工具。

如果把功能相同的进行一下归类，会发现有这样几个主要功能：
服务注册发现：Eurake，Dobbo，Consul，ZooKeeper
服务配置：Spring Cloud Config，Archaius
服务熔断：Hystrix，resilience4j
网关：Zuul，Spring Cloud Gateway
负载均衡：Ribbon，Feign
追踪工具：Sleuth，Zipkin，Htrace
日志采集：logback，ElasticSearch
监控平台：Promethues，Kibana，grafna，Spring boot admin


如何做到接口的幂等性。
方法一、根据业务的操作和内容生成一个全局ID，在执行操作前先根据这个全局唯一ID是否存在，来判断这个操作是否已经执行。如果不存在则把全局ID，
	   存储到存储系统中，比如数据库、redis等。如果存在则表示该方法已经执行。
方法二、去重表，适用于业务有唯一标识的插入场景中，比如在支付场景中，订单ID可以作为唯一标识。我们就可以建一张去重表，并且把唯一标识作为唯一索引，
	   在我们实现时，把创建支付单据和写入去去重表，放在一个事务中，如果重复创建，数据库会抛出唯一约束异常，操作就会回滚。
方法三、多版本控制，适合在更新的场景中，比如我们要更新商品的名字，这时我们就可以在更新的接口中增加一个Version号，来做幂等


如何做限流策略，令牌桶和漏斗算法的使用场景。
高并发系统的三中保护机制：缓存、限流和降级。
缓存：缓存的目的是提升系统访问速度和增大系统处理容量。
降级：降级是当服务器压力剧增的情况下，根据当前业务情况及流量对一些服务和页面有策略的降级，以此释放服务器资源以保证核心任务的正常运行。 
限流：通过对并发请求进行限速，或者对一个时间窗口内的请求进行限速来保护系统，一旦达到限制速率则可以拒绝服务、排队或等待、降级等处理。
常用的限流算法有令牌桶和和漏桶。
漏桶：把请求比作是水，水来了都先放进桶里，并以限定的速度出水，当水来得过猛而出水不够快时就会导致桶溢出，即拒绝服务。
令牌桶：系统以恒定的速率产生令牌，然后把令牌放到令牌桶中，令牌桶有一个容量，当令牌桶满了的时候，再向其中放令牌，那么多余的令牌会被丢弃。
	   当想要处理一个请求的时候，需要从令牌桶中取出一个令牌，如果此时令牌桶中没有令牌，那么则拒绝请求。
	   令牌桶不仅能够限制数据的平均传输速率，还能允许某种程度的突发传输。


什么叫数据一致性，你怎么理解数据一致性。
CAP理论，为了保证高可用和分区容忍性，会牺牲部分数据一致性。
强一致性： 要求无论更新操作是在哪一个副本执行，之后所有的读操作都要能获得最新的数据。
弱一致性：用户读到某一操作对系统特定数据的更新需要一段时间，我们称这段时间为“不一致性窗口”。
最终一致性：是弱一致性的一种特例，保证用户最终能够读取到某操作对系统特定数据的更新。
常用的实现数据一致性的技术：
1、Quorum系统NRW策略，N台服务器，R表示完成读操作最少需要读取的副本数，W表示完成写操作最少需要写入的副本数。只需要保证R+W>N，就可以保证强一致性。 
  当R=Q,W=Q(Q=N/2+1)时，系统在读写性能之间取得平衡，兼顾了性能和可用性。
2、两阶段提交算法、三阶段提交算法
3、分布式锁服务实现数据一致性，是在操作目标之前先获取操作许可，然后再执行操作，如果其他用户同时尝试操作该目标将被阻止，直到前一个用户释放许可后，
  其他用户才能够操作目标。	
  采用分布式锁实现多副本内容修改的一致性问题， 选择控制内容颗粒度实现锁服务。例如我们要保证一个文件的多个副本修改一致， 可以对整个文件设置一把锁，
  修改时申请锁，修改这个文件的多个副本，确保多个副本内容一致，修改完成后释放锁；也可以对文件分段，或者是文件中的单个字节设置锁，实现更细颗粒度的锁操作，减少冲突。
  常用的锁实现算法有 Lamport面包店算法：解决多个线程并发访问一个共享的单用户资源的互斥问题的算法。
  				   Paxos算法
  				   基于Version字段的乐观锁


分布式服务调用方，不依赖服务提供方的话，怎么处理服务方挂掉后，大量无效资源请求的浪费，如果只是服务提供方吞吐不高的时候该怎么做，如果服务挂了，那么一会儿重启，该怎么做到最小的资源浪费，流量半开的实现机制是什么。
dubbo的泛化调用怎么实现的，如果是你，你会怎么做。
远程调用会有超时现象，如果做到优雅的控制，JDK自带的超时机制有哪些，怎么实现的。



数据库知识

客户端(向数据库发送请求，cli、jdbc、navicat、sqlyog)->连接器(控制用户连接)->分析器(词法分析语法分析)->优化器(优化sql语句)->执行器(实际的执行组件)->存储引擎(常用的有InnoDB、MyISAM、Memory)
可以为不同的表设置不同的存储引擎，即存储引擎是表级别的，MyISAM的表文件后缀是.MYD和.MYI，InnoDB的表文件后缀是.ibd


数据库的原子性是如何实现的?
undo log是为了实现事物的原子性，在MySQL数据库InnoDB存储引擎中还用Undo log来实现多版本并发控制。
在操作任何数据之前，首先将数据备份到undo log，然后进行数据修改。如果出现了错误或者用户执行RollBack语句，系统可以利用Undo log将数据恢复到事务开始之前的状态。
undo log是逻辑日志，可以理解为：
当delete一条记录时，undo log会记录一条对应的insert记录；
当insert一条记录时，undo log会记录一条对应的delete记录；
当update一条记录时，undo log会记录一条相反的update记录；


数据库的持久性是如何实现的?
redo log是新数据的备份。在事务提交前，只要将redo log立刻持久化即可，不需要立刻将数据持久化。当系统崩溃时，虽然数据没有持久化，但是redo log已经持久化。系统可以根据redo log的内容，将所有数据恢复到最新状态。
当commit时redo log -> 数据库进程中的log buffer -> os buffer -> 磁盘


数据库的隔离级别
读未提交(脏读、不可重复读，幻读)，读已提交(不可重复读，幻读)，可重复读(幻读)，串行化。
脏读：读到其他未交提交事务修改的值。
不可重复读：在同一个事务内前后两次读到的数据不一样，可能因为其他事物修改了该值并提交了。
幻读：一个事务按相同的查询条件重新读取以前检索过的数据，却发现其他事务插入了满足其查询条件的新数据。


数据库隔离性是如何实现的?
在Mysql中，锁可以分为两类：共享锁和排它锁
锁的粒度：锁定单条记录、锁定某张表、锁定整个数据库
共享锁：select...lock in share mode将对象数据变为只读形式，阻止其他事务获取相同数据集的排它锁，即不能进行写操作
排它锁：当执行insert/update/delete、select...for update时，阻止其他事务获取相同数据集的排它锁和共享锁，其他事务不能修改数据，也不能通过select...for update和select...lock in share mode的方式查询数据，但是可以通过select...from...查询数据，因为普通查询没有任何锁机制。
除了锁可以实现并发控制之外，还可以通过基于时间戳的并发控制、基于有效性的并发控制、基于快照隔离的并发控制


InnoDB行锁实现方式
InnoDB行锁是通过给索引的索引项加锁实现，而Oracle是通过在数据块中对相应数据航加锁实现的。InnoDB这种行锁实现特点意味着：只有通过索引条件检索数据，InnoDB才使用行级锁，否则使用表锁。


hash索引格式的缺点
1、需要将所有的数据文件添加到内存，比较耗费内存。
2、等值查询，hash索引很快，但是范围查询，hash索引无能为力。


二叉树/红黑树索引的缺点
因为树的深度过深而造成IO次数过多


B树索引结构
------------------------------------------------
|         			------------------------   |
|磁盘块  		   | p1 | 16 | p2 | 34 | p3 |  |
|(B树的某个节点)     ------------------------   |
|       				|data|    |data|       |
------------------------------------------------
p1表示指向<16的下个节点的指针，16和data表示该节点索引和对应的数据。
比如现在要查找索引为28的的节点数据，28介于16和34之间，索引根据指针p2找到对应的节点，再循环如此直至找到28索引。一个节点大小为4K，每查询一个节点相当于从磁盘读取4K数据。
假设数据库一条记录1KB，| p1 | 16 | p2 | 34 | p3 |不占用空间，所以一个节点可以存4条记录，三层节点可以存4*4*4=64条记录，存储效率有点低，原因在于节点中存储了data占用了大量空间。


B+树索引结构
------------------------------------------------
|         			------------------------   |
|磁盘块  		   | p1 | 16 | p2 | 34 | p3 |  |
|(B+树的某个节点)    ------------------------   |
|       				                       |
------------------------------------------------
和B树节点大致相同，只不过B+树非叶子节点不存储数据，仅在叶子节点存储数据。
假设| p1 | 16 |占10b，一个节点大小为4kb，能存储400条记录，三层节点能存储400*400*400条记录。


聚簇索引和非聚簇索引
InnoDB是聚簇索引，B+树叶子节点存放实际数据；MyIsam是非聚簇索引，B+树叶子节点存放数据地址。


主键索引、辅助索引、唯一索引、全文索引、组合索引
主键索引：叶子节点存放实际数据
辅助索引：叶子节点存放主键值，需要经过"回表"，即利用主键再查一次
select * from student where name = 'zhangsan'   需要回表
select id(主键) from student where name = 'zhangsan'  不需要回表，这种情况称作"索引覆盖"
唯一索引：索引值唯一但是可以为空
全文索引：InnoDB用得不多，比如要从存储的一篇文章中查询出包含"java"关键字的内容
组合索引：例如建立(name,age)组合索引(类似于主关键词副关键词)，以下1,2,4能利用到索引
select * from student where name = ? and age = ?
select * from student where name = ?
select * from student where age = ?
select * from student where age = ? and name = ?


mysql 数据库varchar(100)可以存储多少个汉字，多少个数字？
4.0版本以下，varchar(100)，指的是100字节，如果存放UTF8汉字时，只能存33个（每个汉字3字节） 
5.0版本以上，varchar(100)，指的是100字符，无论存放的是数字、字母还是UTF8汉字（每个汉字3字节），都可以存放100个。


join和union的区别
union 并操作，会把两张表的结果合并，不保留重复；union all 保留重复
join 交操作，inner join 内连接，left join 左连接，right join 右连接，full join 全连接


数据库隔离级别有哪些，各自的含义是什么，MYSQL默认的隔离级别是是什么。
读未提交，读已提交/不可重复读，可重复读，串行化
mysql默认是可重复读


什么是幻读。
事务1向表中插入一条记录并提交，事务2查询该表并没有查询到这条数据，于是也向该表插入这条数据，但是数据库报错"主键冲突"


MYSQL有哪些存储引擎，各自优缺点。
myisam:拥有较高的插入，查询速度，但不支持事务,使用表级锁，并发性差,主机宕机后，MyISAM 表易损坏，灾难恢复性不佳 
innodb:5.5版本后Mysql的默认数据库，事务型数据库的首选引擎，支持ACID事务，支持行级锁定,灾难恢复性好


高并发下，如何做到安全的修改同一行数据。
使用悲观锁 悲观锁本质是当前只有一个线程执行操作，结束了唤醒其他线程进行处理。 
也可以缓存队列中锁定主键。
加锁分为显式加锁与隐式加锁，上面的写法是显式加锁。mysql在执行insert、update会自动加锁，mysql对select却不会加锁


乐观锁和悲观锁是什么，INNODB的标准行级锁有哪2种，解释其含义。
乐观锁:认为修改不会发生冲突，只有在提交事务的时候才去检查，如果发生冲突则回滚
悲观锁:认为修改会引起冲突，所以一定要获得排它锁之后才能进行操作
共享锁S和排它锁X,意向共享锁IS和意向排它锁IX


SQL优化的一般步骤是什么，怎么看执行计划，如何理解其中各个字段的含义。
show status 通过慢查询日志定位哪些是执行效率低的sql语句
explain sql 显示了mysql如何使用索引来处理select语句以及连接表。可以帮助选择更好的索引和写出更优化的查询语句


数据库会死锁吗，举一个死锁的例子，mysql怎么解决死锁。
事务A先修改表1后修改表2，事务2先修改表2后修改表1
原因：
系统资源不足
进程运行推进的顺序不合适 
资源分配不当等
处理：
重启数据库；杀死抢资源的进程


Mysql的索引原理，索引的类型有哪些，如何创建合理的索引，索引如何优化。
最左前缀匹配原则，非常重要的原则，mysql会一直向右匹配直到遇到范围查询(>、<、between、like)就停止匹配，比如a=1 and b=2 and c>3 and d=4
如果建立(a,b,c,d)顺序的索引，d是用不到索引的，如果建立(a,b,d,c)的索引则都可以用到，a,b,d的顺序可以任意调整。
=和in可以乱序，比如a = 1 and b = 2 and c = 3 建立(a,b,c)索引可以任意顺序，mysql查询优化器会调整到最优顺序。
尽量选择区分度高的列作为索引，尽量少重复
尽量的扩展索引，不要新建索引。


聚集索引和非聚集索引的区别。
聚簇索引就是索引和记录紧密在一起。 
非聚簇索引 索引文件和数据文件分开存放，索引文件的叶子只保存了数据所在的物理地址，需要根据地址查找相应的数据块


select for update 是什么含义，会锁表还是锁行或是其他。
被select for update选定的数据不能被其他事务修改或删除，但是可以被普通select。若where指定了主键，锁行，否则锁表。


InnoDB实现了以下两种类型的行锁：
共享锁(S)：允许一个事务去读一行，阻止其他事务获得相同数据集的排他锁。
排他锁(X)：允许获得排他锁的事务更新数据，阻止其他事务取得相同数据集的共享读锁和排他写锁。
另外，为了允许行锁和表锁共存，实现多粒度锁机制，InnoDB还有两种内部使用的意向锁（Intention Locks），这两种意向锁都是表锁。
意向共享锁（IS）：事务打算给数据行加行共享锁，事务在给一个数据行加共享锁前必须先取得该表的IS锁。
意向排他锁（IX）：事务打算给数据行加行排他锁，事务在给一个数据行加排他锁前必须先取得该表的IX锁。

意向锁是InnoDB自动加的，不需用户干预。对于UPDATE、DELETE和INSERT语句，InnoDB会自动给涉及数据集加排他锁(X)；
对于普通SELECT语句，InnoDB不会加任何锁；事务可以通过以下语句显示给记录集加共享锁或排他锁。
共享锁(S)：SELECT * FROM table_name WHERE … LOCK IN SHARE MODE。
排他锁(X)：SELECT * FROM table_name WHERE … FOR UPDATE。


数据库的ACID是什么。
A，atomic，原子性，要么都提交，要么都失败，不能一部分成功，一部分失败。 
C，consistent，一致性，事物开始及结束后，数据的一致性约束没有被破坏 
I，isolation，隔离性，并发事物间相互不影响，互不干扰。 
D，durability,持久性，已经提交的事物对数据库所做的更新必须永久保存。即便发生崩溃，也不能被回滚或数据丢失。


某个表有近千万数据，CRUD比较慢，如何优化。
1.sql vs nosql
  不一定必须要关系型数据库存储，如果可靠性要求不高，完全可以用非关系型数据库存储
2.优化结构、sql语句+索引
  合理设计表结构，甚至违反设计范式做到适当冗余(避免经常需要join)。
  优化语句，生产环境分析慢日志。
  合理设置索引。
3.缓存
  对于读多写少的数据可以引入Redis/Memcached缓存
4.复制及读写分离(做主从复制，读写分离)    
                   -> Slave2
  Master -> Slave1 -> Slave3 
 		           -> Slave4 
  master负责写操作，slave负责读操作，master和slave需要保持数据一致性。为了减少master压力，可以让slave1和mater同步数据，然后slave1与其余slave同步数据
5.切分 垂直切分(分库)  水平切分(分表)
  垂直切分保证业务的独立性，防止不同业务争抢资源，毕竟业务是有优先级的。
  水平切分主要用于解决单表过大，突破单机瓶颈，只有切分才能真正做到分配负载。


Mysql怎么优化table scan的。
避免在where子句中对字段进行is null判断 
应尽量避免在where 子句中使用!=或<>操作符，否则将引擎放弃使用索引而进行全表扫描。 
避免在where 子句中使用or 来连接条件 
in 和not in 也要慎用 
Like查询（非左开头） 
使用NUM=@num参数这种 
where 子句中对字段进行表达式操作num/2=XX 
在where子句中对字段进行函数操作


如何写sql能够有效的使用到复合索引。
例1：SELECT c1, c2 FROM t WHERE c = 100 and d = 'xyz' ORDER BY b  
我们可以创建一个集过滤、排序、覆盖于一体的索引：（c，d，b，c1，c2）
例2：SELECT * FROM t WHERE c > 100 and b < 10 and d = 'xyz'  
创建索引（d，b）/索引（d，c）
(先过滤后排序)先执行=，其次执行 order by，(范围查询会终止索引查询)<、>、between放最后。

模糊查询 select * from tableA from content like "%xxx%"
这里有个问题，即使我为content加了索引，下面这两种情况索引也是无效的
content like "%xxx" / like "%xxx%" 都不能使用索引
如果想索引作用只能使用content like "xxx%"


mysql中in 和exists 区别。
mysql中的in语句是把外表和内表作hash 连接，而exists语句是对外表作loop循环，每次loop循环再对内表进行查询。大家都认为exists比in语句的效率要高，
这种说法其实是不准确的。这个是要区分环境的。
如果查询的两个表大小相当，那么用in和exists差别不大。 
A B 两表，A in B 如果B较小，in不错，如果B很大，使用exists
not in 和not exists如果查询语句使用了not in 那么内外表都进行全表扫描，没有用到索引；而not extsts 的子查询依然能用到表上的索引。所以无论那个表大，用not exists都比not in要快。 
1.EXISTS只返回TRUE或FALSE，不会返回UNKNOWN。
2.IN当遇到包含NULL的情况，那么就会返回UNKNOWN。


数据库自增主键可能的问题。
自增主键会产生表锁；在分库分表时可能会生成重复主键


MVCC的含义，如何实现的。
多版本并发控制，只有在InnoDB引擎下存在为了实现事务的隔离性，通过版本号，避免同一数据在不同事务间的竞争，你可以把它当成基于多版本号的一种乐观锁
InnoDB在每行数据都增加两个隐藏字段，一个记录创建的版本号，一个记录删除的版本号。


你做过的项目里遇到分库分表了吗，怎么做的，有用到中间件么，比如sharding jdbc等,他们的原理知道么。
COBAR -> MYCAT -> DBproxy
Sharding-JDBC直接封装JDBC API，可以理解为增强版的JDBC驱动，用客户端直连数据库，以jar包形式提供服务，无proxy代理层，无需额外部署，
无其他依赖，DBA也无需改变原有的运维方式


数据冷热分离
热数据可以存放在redis，冷数据存放在mysql
每次优先查询热库，当查询条件未命中（结果集为空）/当查询条件部分命中时，查询冷库。 
查询和使用热数据时，将一段时间不再使用的热数据移到冷库。
查询冷库时，将本次查询的结果移到热库，附上最新查询日期。


MYSQL的主从延迟怎么解决。
当主库的TPS并发较高时，产生的DDL(数据定义语言)数量超过slave一个sql线程所能承受的范围，那么延时就产生了，当然还有就是可能与slave的大型query语句产生了锁等待。
1、最简单的减少slave同步延时的方案就是在架构上做优化，尽量让主库的DDL快速执行。还有就是主库是写，对数据安全性较高，比如sync_binlog=1，innodb_flush_log_at_trx_commit = 1 
之类的设置，而slave则不需要这么高的数据安全，完全可以将sync_binlog设置为0或者关闭binlog，innodb_flushlog也可以设置为0来提高sql的执行效率。
2、使用比主库更好的硬件设备作为slave。这台slave只用于备份master，不用提供读服务，其他slave同步该台slave。
3、增加slave，分散读压力，从而降低slave压力。

master服务器负责写操作，多台slave服务器负责读操作，所以master和slave之间要保持数据一致性。
一主多从、多主一从、级联复制 
						-> Slave
				 Master -> Slave -> Slave -> Slave
				 		-> Slave -> Slave -> Slave
架构改进:
业务的持久化层的实现采用分库架构，mysql服务可平行扩展，分散压力
服务的基础架构在业务和mysql之间加入memcache或者redis的cache层。降低mysql的读压力。
不同业务的mysql物理上放在不同机器，分散压力。
单个库读写分离，一主多从，主写从读，分散压力。这样从库压力比主库高，保护主库。
硬件改进:
花钱


数据库

SQL执行慢的原因分析
一、针对偶尔很慢的情况
1、数据库在刷新脏页(数据库在同步数据到磁盘)
当我们要往数据库插入一条数据、或者要更新一条数据的时候，我们知道数据库会在内存中把对应字段的数据更新了，但是更新之后，这些更新的字段并不会马上
同步持久化到磁盘中去，而是把这些更新的记录写入到 redo log 日记中去，等到空闲的时候，在通过 redo log 里的日记把最新的数据同步到磁盘中去。

不过，redo log 里的容量是有限的，如果数据库一直很忙，更新又很频繁，这个时候 redo log 很快就会被写满了，这个时候就没办法等到空闲的时候再把数据
同步到磁盘的，只能暂停其他操作，全身心来把数据同步到磁盘中去的，而这个时候，就会导致我们平时正常的SQL语句突然执行的很慢。

2、拿不到锁
我们要执行的这条语句，刚好这条语句涉及到的表，别人在用，并且加锁了，我们拿不到锁，只能慢慢等待别人释放锁了。或者，表没有加锁，但要使用到的某个一行被加锁了。
如果要判断是否真的在等待锁，我们可以用 show processlist这个命令来查看当前的状态

二、针对一直都慢的情况
1 字段没有索引

2 字段有索引，但却没有用索引
不等查询、范围查询会中断索引的使用

3 函数操作导致没有用上索引
在索引字段上使用函数导致没有用上索引




一、基本概念
1.主键、外键、超键、候选键
超键：在关系中能唯一标识元组的属性集称为关系模式的超键。一个属性可以为作为一个超键，多个属性组合在一起也可以作为一个超键。超键包含候选键和主键。
候选键：是最小超键，即没有冗余元素的超键。
主键：数据库表中对储存数据对象予以唯一和完整标识的数据列或属性的组合。一个数据列只能有一个主键，且主键的取值不能缺失，即不能为空值（Null）。
外键：在一个表中存在的另一个表的主键称此表的外键。

2.为什么用自增列作为主键
如果我们定义了主键(PRIMARY KEY)，那么InnoDB会选择主键作为聚集索引；

如果没有显式定义主键，则InnoDB会选择第一个不包含有NULL值的唯一索引作为主键索引；

如果也没有这样的唯一索引，则InnoDB会选择内置6字节长的ROWID作为隐含的聚集索引(ROWID随着行记录的写入而主键递增，这个ROWID不像ORACLE的ROWID那样可引用，是隐含的)。

数据记录本身被存于主索引（一颗B+Tree）的叶子节点上。这就要求同一个叶子节点内（大小为一个内存页或磁盘页）的各条数据记录按主键顺序存放，
因此每当有一条新的记录插入时，MySQL会根据其主键将其插入适当的节点和位置，如果页面达到装载因子（InnoDB默认为15/16），则开辟一个新的页（节点）

如果表使用自增主键，那么每次插入新的记录，记录就会顺序添加到当前索引节点的后续位置，当一页写满，就会自动开辟一个新的页

如果使用非自增主键（如果身份证号或学号等），由于每次插入主键的值近似于随机，因此每次新纪录都要被插到现有索引页得中间某个位置，此时MySQL不得不
为了将新记录插到合适位置而移动数据，甚至目标页面可能已经被回写到磁盘上而从缓存中清掉，此时又要从磁盘上读回来，这增加了很多开销，同时频繁的移动、
分页操作造成了大量的碎片，得到了不够紧凑的索引结构，后续不得不通过OPTIMIZE TABLE来重建表并优化填充页面。

3.触发器的作用？
触发器是一种特殊的存储过程，主要是通过事件来触发而被执行的。它可以强化约束，来维护数据的完整性和一致性，可以跟踪数据库内的操作从而不允许未经
许可的更新和变化。可以联级运算。如，某表上的触发器上包含对另一个表的数据操作，而该操作又会导致该表触发器被触发。

4.什么是存储过程？用什么来调用？
存储过程是一个预编译的SQL语句，优点是允许模块化的设计，就是说只需创建一次，以后在该程序中就可以调用多次。如果某次操作需要执行多次SQL，使用存储过程比单纯SQL语句执行要快。

调用：

1）可以用一个命令对象来调用存储过程。

2）可以供外部程序调用，比如：java程序。

5.存储过程的优缺点？
优点：

1）存储过程是预编译过的，执行效率高。

2）存储过程的代码直接存放于数据库中，通过存储过程名直接调用，减少网络通讯。

3）安全性高，执行存储过程需要有一定权限的用户。

4）存储过程可以重复使用，可减少数据库开发人员的工作量。

缺点：移植性差

6.存储过程与函数的区别


7.什么叫视图？游标是什么？
视图：

是一种虚拟的表，具有和物理表相同的功能。可以对视图进行增，改，查，操作，试图通常是有一个表或者多个表的行或列的子集。对视图的修改会影响基本表。它使得我们获取数据更容易，相比多表查询。

游标：

是对查询出来的结果集作为一个单元来有效的处理。游标可以定在该单元中的特定行，从结果集的当前行检索一行或多行。可以对结果集当前行做修改。一般不使用游标，但是需要逐条处理数据的时候，游标显得十分重要。

8.视图的优缺点
优点：
对数据库的访问，因为视图可以有选择性的选取数据库里的一部分。
用户通过简单的查询可以从复杂查询中得到结果。
维护数据的独立性，试图可从多个表检索数据。
对于相同的数据可产生不同的视图。

缺点：

性能：查询视图时，必须把视图的查询转化成对基本表的查询，如果这个视图是由一个复杂的多表查询所定义，那么，那么就无法更改数据

9.drop、truncate、 delete区别
最基本：
drop直接删掉表。
truncate删除表中数据，再插入时自增长id又从1开始。
delete删除表中数据，可以加where字句。
（1） DELETE语句执行删除的过程是每次从表中删除一行，并且同时将该行的删除操作作为事务记录在日志中保存以便进行进行回滚操作。
	 TRUNCATE TABLE 则一次性地从表中删除所有的数据并不把单独的删除操作记录记入日志保存，删除行是不能恢复的。并且在删除的过程中不会激活与表有关的删除触发器。执行速度快。

（2） 表和索引所占空间。当表被TRUNCATE 后，这个表和索引所占用的空间会恢复到初始大小，而DELETE操作不会减少表或索引所占用的空间。drop语句将表所占用的空间全释放掉。

（3） 一般而言，drop > truncate > delete

（4） 应用范围。TRUNCATE 只能对TABLE；DELETE可以是table和view

（5） TRUNCATE 和DELETE只删除数据，而DROP则删除整个表（结构和数据）。

（6） truncate与不带where的delete ：只删除数据，而不删除表的结构（定义）drop语句将删除表的结构被依赖的约束(constrain),
	  触发器(trigger)索引(index);依赖于该表的存储过程/函数将被保留，但其状态会变为：invalid。

（7） delete语句为DML(data maintain Language),这个操作会被放到 rollback segment中,事务提交后才生效。如果有相应的 tigger,执行的时候将被触发。

（8） truncate、drop是DLL(data define language),操作立即生效，原数据不放到 rollback segment中，不能回滚。

（9） 在没有备份情况下，谨慎使用 drop 与 truncate。要删除部分数据行采用delete且注意结合where来约束影响范围。回滚段要足够大。
	 要删除表用drop;若想保留表而将表中数据删除，如果于事务无关，用truncate即可实现。如果和事务有关，或老师想触发trigger,还是用delete。

（10）Truncate table 表名 速度快,而且效率高,因为:?truncate table 在功能上与不带 WHERE 子句的 DELETE 语句相同：二者均删除表中的全部行。
	 但 TRUNCATE TABLE 比 DELETE 速度快，且使用的系统和事务日志资源少。DELETE 语句每次删除一行，并在事务日志中为所删除的每行记录一项。
	 TRUNCATE TABLE 通过释放存储表数据所用的数据页来删除数据，并且只在事务日志中记录页的释放。

（11） TRUNCATE TABLE 删除表中的所有行，但表结构及其列、约束、索引等保持不变。新行标识所用的计数值重置为该列的种子。如果想保留标识计数值，请改用 DELETE。如果要删除表定义及其数据，请使用 DROP TABLE 语句。

（12） 对于由 FOREIGN KEY 约束引用的表，不能使用 TRUNCATE TABLE，而应使用不带 WHERE 子句的 DELETE 语句。由于 TRUNCATE TABLE 不记录在日志中，所以它不能激活触发器。

10.什么是临时表，临时表什么时候删除?
临时表可以手动删除：
DROP TEMPORARY TABLE IF EXISTS temp_tb;

临时表只在当前连接可见，当关闭连接时，MySQL会自动删除表并释放所有空间。因此在不同的连接中可以创建同名的临时表，并且操作属于本连接的临时表。
创建临时表的语法与创建表语法类似，不同之处是增加关键字TEMPORARY，

如：

CREATE TEMPORARY TABLE tmp_table (

NAME VARCHAR (10) NOT NULL,

time date NOT NULL
);

select * from tmp_table;

11.非关系型数据库和关系型数据库区别，优势比较?
非关系型数据库的优势：

性能：NOSQL是基于键值对的，可以想象成表中的主键和值的对应关系，而且不需要经过SQL层的解析，所以性能非常高。
可扩展性：同样也是因为基于键值对，数据之间没有耦合性，所以非常容易水平扩展。
关系型数据库的优势：

复杂查询：可以用SQL语句方便的在一个表以及多个表之间做非常复杂的数据查询。
事务支持：使得对于安全性能很高的数据访问要求得以实现。
其他：

1.对于这两类数据库，对方的优势就是自己的弱势，反之亦然。

2.NOSQL数据库慢慢开始具备SQL数据库的一些复杂查询功能，比如MongoDB。

3.对于事务的支持也可以用一些系统级的原子操作来实现例如乐观锁之类的方法来曲线救国，比如Redis set nx。

12.数据库范式，根据某个场景设计数据表?
第一范式:(确保每列保持原子性)所有字段值都是不可分解的原子值。

第一范式是最基本的范式。如果数据库表中的所有字段值都是不可分解的原子值，就说明该数据库表满足了第一范式。
第一范式的合理遵循需要根据系统的实际需求来定。比如某些数据库系统中需要用到“地址”这个属性，本来直接将“地址”属性设计成一个数据库表的字段就行。
但是如果系统经常会访问“地址”属性中的“城市”部分，那么就非要将“地址”这个属性重新拆分为省份、城市、详细地址等多个部分进行存储，这样在对地址中某一部分操作的时候将非常方便。

第二范式:(确保表中的每列都和主键相关)在一个数据库表中，一个表中只能保存一种数据，不可以把多种数据保存在同一张数据库表中。

第二范式在第一范式的基础之上更进一层。第二范式需要确保数据库表中的每一列都和主键相关，而不能只与主键的某一部分相关（主要针对联合主键而言）。
也就是说在一个数据库表中，一个表中只能保存一种数据，不可以把多种数据保存在同一张数据库表中。
比如要设计一个订单信息表，因为订单中可能会有多种商品，所以要将订单编号和商品编号作为数据库表的联合主键。

第三范式:(确保每列都和主键列直接相关,而不是间接相关) 数据表中的每一列数据都和主键直接相关，而不能间接相关。

第三范式需要确保数据表中的每一列数据都和主键直接相关，而不能间接相关。
比如在设计一个订单数据表的时候，可以将客户编号作为一个外键和订单表建立相应的关系。而不可以在订单表中添加关于客户其它信息（比如姓名、所属公司等）的字段。

BCNF:符合3NF，并且，主属性不依赖于主属性。

若关系模式属于第二范式，且每个属性都不传递依赖于键码，则R属于BC范式。
通常BC范式的条件有多种等价的表述：每个非平凡依赖的左边必须包含键码；每个决定因素必须包含键码。
BC范式既检查非主属性，又检查主属性。当只检查非主属性时，就成了第三范式。满足BC范式的关系都必然满足第三范式。
还可以这么说：若一个关系达到了第三范式，并且它只有一个候选码，或者它的每个候选码都是单属性，则该关系自然达到BC范式。
一般，一个数据库设计符合3NF或BCNF就可以了。

第四范式:要求把同一表内的多对多关系删除。

第五范式:从最终结构重新建立原始结构。

13.什么是 内连接、外连接、交叉连接、笛卡尔积等?
内连接: 只连接匹配的行

左外连接: 包含左边表的全部行（不管右边的表中是否存在与它们匹配的行），以及右边表中全部匹配的行

右外连接: 包含右边表的全部行（不管左边的表中是否存在与它们匹配的行），以及左边表中全部匹配的行

例如1：
SELECT a.,b. FROM luntan LEFT JOIN usertable as b ON a.username=b.username

例如2：
SELECT a.,b. FROM city as a FULL OUTER JOIN user as b ON a.username=b.username

全外连接: 包含左、右两个表的全部行，不管另外一边的表中是否存在与它们匹配的行。

交叉连接: 生成笛卡尔积－它不使用任何匹配或者选取条件，而是直接将一个数据源中的每个行与另一个数据源的每个行都一一匹配

例如：
SELECT type,pub_name FROM titles CROSS JOIN publishers ORDER BY type


14.varchar和char的使用场景?
1.char的长度是不可变的，而varchar的长度是可变的。

定义一个char[10]和varchar[10]。
如果存进去的是‘csdn’,那么char所占的长度依然为10，除了字符‘csdn’外，后面跟六个空格，varchar就立马把长度变为4了，取数据的时候，char类型的要用trim()去掉多余的空格，而varchar是不需要的。

2.char的存取数度还是要比varchar要快得多，因为其长度固定，方便程序的存储与查找。
char也为此付出的是空间的代价，因为其长度固定，所以难免会有多余的空格占位符占据空间，可谓是以空间换取时间效率。
varchar是以空间效率为首位。

3.char的存储方式是：对英文字符（ASCII）占用1个字节，对一个汉字占用两个字节。
varchar的存储方式是：对每个英文字符占用2个字节，汉字也占用2个字节。

4.两者的存储数据都非unicode的字符数据。

15.SQL语言分类
SQL语言共分为四大类：

数据查询语言DQL
数据操纵语言DML
数据定义语言DDL
数据控制语言DCL。
1. 数据查询语言DQL

数据查询语言DQL基本结构是由SELECT子句，FROM子句，WHERE子句组成的查询块：

SELECT
FROM
WHERE

2 .数据操纵语言DML

数据操纵语言DML主要有三种形式：
 插入：INSERT
 更新：UPDATE
 删除：DELETE

3. 数据定义语言DDL

数据定义语言DDL用来创建数据库中的各种对象-----表、视图、索引、同义词、聚簇等如：
CREATE TABLE/VIEW/INDEX/SYN/CLUSTER

表 视图 索引 同义词 簇

DDL操作是隐性提交的！不能rollback

4. 数据控制语言DCL

数据控制语言DCL用来授予或回收访问数据库的某种特权，并控制数据库操纵事务发生的时间及效果，对数据库实行监视等。如：
 GRANT：授权。

 ROLLBACK [WORK] TO [SAVEPOINT]：回退到某一点。回滚---ROLLBACK；回滚命令使数据库状态回到上次最后提交的状态。其格式为：
SQL>ROLLBACK;

 COMMIT [WORK]：提交。

在数据库的插入、删除和修改操作时，只有当事务在提交到数据
库时才算完成。在事务提交前，只有操作数据库的这个人才能有权看
到所做的事情，别人只有在最后提交完成后才可以看到。
提交数据有三种类型：显式提交、隐式提交及自动提交。下面分
别说明这三种类型。

(1) 显式提交
用COMMIT命令直接完成的提交为显式提交。其格式为：
SQL>COMMIT；

(2) 隐式提交
用SQL命令间接完成的提交为隐式提交。这些命令是：
ALTER，AUDIT，COMMENT，CONNECT，CREATE，DISCONNECT，DROP，
EXIT，GRANT，NOAUDIT，QUIT，REVOKE，RENAME。

(3) 自动提交
若把AUTOCOMMIT设置为ON，则在插入、修改、删除语句执行后，
系统将自动进行提交，这就是自动提交。其格式为：
SQL>SET AUTOCOMMIT ON；


16.like %和-的区别
通配符的分类:

%百分号通配符:表示任何字符出现任意次数(可以是0次).

**_下划线通配符:**表示只能匹配单个字符,不能多也不能少,就是一个字符.

like操作符: LIKE作用是指示mysql后面的搜索模式是利用通配符而不是直接相等匹配进行比较.

注意: 如果在使用like操作符时,后面的没有使用通用匹配符效果是和=一致的,SELECT * FROM products WHERE products.prod_name like '1000';
只能匹配的结果为1000,而不能匹配像JetPack 1000这样的结果.

%通配符使用: 匹配以"yves"开头的记录:(包括记录"yves") SELECT FROM products WHERE products.prod_name like 'yves%';
匹配包含"yves"的记录(包括记录"yves") SELECT FROM products WHERE products.prod_name like '%yves%';
匹配以"yves"结尾的记录(包括记录"yves",不包括记录"yves ",也就是yves后面有空格的记录,这里需要注意) SELECT * FROM products WHERE products.prod_name like '%yves';

_通配符使用: SELECT *FROM products WHERE products.prod_name like '_yves'; 匹配结果为: 像"yyves"这样记录.
SELECT* FROM products WHERE products.prodname like 'yves_'; 匹配结果为: 像"yvesHe"这样的记录.(一个下划线只能匹配一个字符,不能多也不能少)

注意事项:
注意大小写,在使用模糊匹配时,也就是匹配文本时,mysql是可能区分大小的,也可能是不区分大小写的,这个结果是取决于用户对MySQL的配置方式.如果是区分大小写,那么像YvesHe这样记录是不能被"yves__"这样的匹配条件匹配的.
注意尾部空格,"%yves"是不能匹配"heyves "这样的记录的.
注意NULL,%通配符可以匹配任意字符,但是不能匹配NULL,也就是说SELECT * FROM products WHERE products.prod_name like '%';是匹配不到products.prod_name为NULL的的记录.

技巧与建议:
正如所见， MySQL的通配符很有用。但这种功能是有代价的：通配符搜索的处理一般要比前面讨论的其他搜索所花时间更长。这里给出一些使用通配符要记住的技巧。
不要过度使用通配符。如果其他操作符能达到相同的目的，应该 使用其他操作符。
在确实需要使用通配符时，除非绝对有必要，否则不要把它们用 在搜索模式的开始处。把通配符置于搜索模式的开始处，搜索起 来是最慢的。
仔细注意通配符的位置。如果放错地方，可能不会返回想要的数.


**17.count(*)、count(1)、count(column)的区别**
count(*)对行的数目进行计算,包含NULL

count(column)对特定的列的值具有的行数进行计算,不包含NULL值。

count()还有一种使用方式,count(1)这个用法和count(*)的结果是一样的。

性能问题:

1.任何情况下SELECT COUNT(*) FROM tablename是最优选择;

2.尽量减少SELECT COUNT(*) FROM tablename WHERE COL = ‘value’ 这种查询;

3.杜绝SELECT COUNT(COL) FROM tablename WHERE COL2 = ‘value’ 的出现。

如果表没有主键,那么count(1)比count(*)快。

如果有主键,那么count(主键,联合主键)比count(*)快。

如果表只有一个字段,count(*)最快。

count(1)跟count(主键)一样,只扫描主键。count(*)跟count(非主键)一样,扫描整个表。明显前者更快一些。

18.最左前缀原则
多列索引：

ALTER TABLE people ADD INDEX lname_fname_age (lame,fname,age);

为了提高搜索效率，我们需要考虑运用多列索引,由于索引文件以B－Tree格式保存，所以我们不用扫描任何记录，即可得到最终结果。

注：在mysql中执行查询时，只能使用一个索引，如果我们在lname,fname,age上分别建索引,执行查询时，只能使用一个索引，mysql会选择一个最严格(获得结果集记录数最少)的索引。

最左前缀原则：顾名思义，就是最左优先，上例中我们创建了lname_fname_age多列索引,相当于创建了(lname)单列索引，(lname,fname)组合索引以及(lname,fname,age)组合索引。

二、索引
1.什么是索引？
何为索引：

数据库索引，是数据库管理系统中一个排序的数据结构，索引的实现通常使用B树及其变种B+树。

在数据之外，数据库系统还维护着满足特定查找算法的数据结构，这些数据结构以某种方式引用（指向）数据，这样就可以在这些数据结构上实现高级查找算法。这种数据结构，就是索引。

2.索引的作用？它的优点缺点是什么？
索引作用：

协助快速查询、更新数据库表中数据。

为表设置索引要付出代价的：

一是增加了数据库的存储空间
二是在插入和修改数据时要花费较多的时间(因为索引也要随之变动)。

3.索引的优缺点？
创建索引可以大大提高系统的性能（优点）：

1.通过创建唯一性索引，可以保证数据库表中每一行数据的唯一性。

2.可以大大加快数据的检索速度，这也是创建索引的最主要的原因。

3.可以加速表和表之间的连接，特别是在实现数据的参考完整性方面特别有意义。

4.在使用分组和排序子句进行数据检索时，同样可以显著减少查询中分组和排序的时间。

5.通过使用索引，可以在查询的过程中，使用优化隐藏器，提高系统的性能。

增加索引也有许多不利的方面(缺点)：

1.创建索引和维护索引要耗费时间，这种时间随着数据量的增加而增加。

2.索引需要占物理空间，除了数据表占数据空间之外，每一个索引还要占一定的物理空间，如果要建立聚簇索引，那么需要的空间就会更大。

3.当对表中的数据进行增加、删除和修改的时候，索引也要动态的维护，这样就降低了数据的维护速度。

4.哪些列适合建立索引、哪些不适合建索引？
索引是建立在数据库表中的某些列的上面。在创建索引的时候，应该考虑在哪些列上可以创建索引，在哪些列上不能创建索引。

一般来说，应该在这些列上创建索引：

（1）在经常需要搜索的列上，可以加快搜索的速度；

（2）在作为主键的列上，强制该列的唯一性和组织表中数据的排列结构；

（3）在经常用在连接的列上，这些列主要是一些外键，可以加快连接的速度；

（4）在经常需要根据范围进行搜索的列上创建索引，因为索引已经排序，其指定的范围是连续的；

（5）在经常需要排序的列上创建索引，因为索引已经排序，这样查询可以利用索引的排序，加快排序查询时间；

（6）在经常使用在WHERE子句中的列上面创建索引，加快条件的判断速度。

对于有些列不应该创建索引：

（1）对于那些在查询中很少使用或者参考的列不应该创建索引。

这是因为，既然这些列很少使用到，因此有索引或者无索引，并不能提高查询速度。相反，由于增加了索引，反而降低了系统的维护速度和增大了空间需求。

（2）对于那些只有很少数据值的列也不应该增加索引。

这是因为，由于这些列的取值很少，例如人事表的性别列，在查询的结果中，结果集的数据行占了表中数据行的很大比例，即需要在表中搜索的数据行的比例很大。增加索引，并不能明显加快检索速度。

（3）对于那些定义为text, image和bit数据类型的列不应该增加索引。

这是因为，这些列的数据量要么相当大，要么取值很少。

(4)当修改性能远远大于检索性能时，不应该创建索引。

这是因为，修改性能和检索性能是互相矛盾的。当增加索引时，会提高检索性能，但是会降低修改性能。当减少索引时，会提高修改性能，降低检索性能。因此，当修改性能远远大于检索性能时，不应该创建索引。

5.什么样的字段适合建索引
唯一、不为空、经常被查询的字段

6.MySQL B+Tree索引和Hash索引的区别?
Hash索引和B+树索引的特点：

Hash索引结构的特殊性，其检索效率非常高，索引的检索可以一次定位;

B+树索引需要从根节点到枝节点，最后才能访问到页节点这样多次的IO访问;

为什么不用Hash索引而使用B+树索引？

Hash索引仅仅能满足"=","IN"和""查询，不能使用范围查询,因为经过相应的Hash算法处理之后的Hash值的大小关系，并不能保证和Hash运算前完全一样；

Hash索引无法被用来避免数据的排序操作，因为Hash值的大小关系并不一定和Hash运算前的键值完全一样；

Hash索引不能利用部分索引键查询，对于组合索引，Hash索引在计算Hash值的时候是组合索引键合并后再一起计算Hash值，而不是单独计算Hash值，所以通过组合索引的前面一个或几个索引键进行查询的时候，Hash索引也无法被利用；

Hash索引在任何时候都不能避免表扫描，由于不同索引键存在相同Hash值，所以即使取满足某个Hash键值的数据的记录条数，也无法从Hash索引中直接完成查询，还是要回表查询数据；

Hash索引遇到大量Hash值相等的情况后性能并不一定就会比B+树索引高。

补充：

1.MySQL中，只有HEAP/MEMORY引擎才显示支持Hash索引。

2.常用的InnoDB引擎中默认使用的是B+树索引，它会实时监控表上索引的使用情况，如果认为建立哈希索引可以提高查询效率，则自动在内存中的“自适应哈希
索引缓冲区”建立哈希索引（在InnoDB中默认开启自适应哈希索引），通过观察搜索模式，MySQL会利用index key的前缀建立哈希索引，如果一个表几乎大部分都在缓冲池中，那么建立一个哈希索引能够加快等值查询。

B+树索引和哈希索引的明显区别是：

3.如果是等值查询，那么哈希索引明显有绝对优势，因为只需要经过一次算法即可找到相应的键值；当然了，这个前提是，键值都是唯一的。如果键值不是唯一的，就需要先找到该键所在位置，然后再根据链表往后扫描，直到找到相应的数据；

4.如果是范围查询检索，这时候哈希索引就毫无用武之地了，因为原先是有序的键值，经过哈希算法后，有可能变成不连续的了，就没办法再利用索引完成范围查询检索；
同理，哈希索引没办法利用索引完成排序，以及like ‘xxx%’ 这样的部分模糊查询（这种部分模糊查询，其实本质上也是范围查询）；

5.哈希索引也不支持多列联合索引的最左匹配规则；

6.B+树索引的关键字检索效率比较平均，不像B树那样波动幅度大，在有大量重复键值情况下，哈希索引的效率也是极低的，因为存在所谓的哈希碰撞问题。

7.在大多数场景下，都会有范围查询、排序、分组等查询特征，用B+树索引就可以了。

7.B树和B+树的区别
B树，每个节点都存储key和data，所有节点组成这棵树，并且叶子节点指针为nul，叶子结点不包含任何关键字信息。

B+树，所有的叶子结点中包含了全部关键字的信息，及指向含有这些关键字记录的指针，且叶子结点本身依关键字的大小自小而大的顺序链接，所有的非终端结点可以看成是索引部分，结点中仅含有其子树根结点中最大（或最小）关键字。 (而B 树的非终节点也包含需要查找的有效信息)

8.为什么说B+比B树更适合实际应用中操作系统的文件索引和数据库索引？
1.B+的磁盘读写代价更低

B+的内部结点并没有指向关键字具体信息的指针。因此其内部结点相对B树更小。如果把所有同一内部结点的关键字存放在同一盘块中，那么盘块所能容纳的关键字数量也越多。一次性读入内存中的需要查找的关键字也就越多。相对来说IO读写次数也就降低了。

2.B+tree的查询效率更加稳定

由于非终结点并不是最终指向文件内容的结点，而只是叶子结点中关键字的索引。所以任何关键字的查找必须走一条从根结点到叶子结点的路。所有关键字查询的路径长度相同，导致每一个数据的查询效率相当。

9.聚集索引和非聚集索引(二级索引)区别?
聚合索引(clustered index):

聚集索引表记录的排列顺序和索引的排列顺序一致，所以查询效率快，只要找到第一个索引值记录，其余就连续性的记录在物理也一样连续存放。聚集索引对应的缺点就是修改慢，因为为了保证表中记录的物理和索引顺序一致，在记录插入的时候，会对数据页重新排序。
聚集索引类似于新华字典中用拼音去查找汉字，拼音检索表于书记顺序都是按照a~z排列的，就像相同的逻辑顺序于物理顺序一样，当你需要查找a,ai两个读音的字，或是想一次寻找多个傻(sha)的同音字时，也许向后翻几页，或紧接着下一行就得到结果了。

非聚合索引(nonclustered index):

非聚集索引指定了表中记录的逻辑顺序，但是记录的物理和索引不一定一致，两种索引都采用B+树结构，非聚集索引的叶子层并不和实际数据页相重叠，而采用叶子层包含一个指向表中的记录在数据页中的指针方式。非聚集索引层次多，不会造成数据重排。
非聚集索引类似在新华字典上通过偏旁部首来查询汉字，检索表也许是按照横、竖、撇来排列的，但是由于正文中是a~z的拼音顺序，所以就类似于逻辑地址于物理地址的不对应。同时适用的情况就在于分组，大数目的不同值，频繁更新的列中，这些情况即不适合聚集索引。

根本区别：

聚集索引和非聚集索引的根本区别是表记录的排列顺序和与索引的排列顺序是否一致。

三、事务
1.什么是事务？
事务是对数据库中一系列操作进行统一的提交或者回滚操作，主要用来保证数据的完整性和一致性。

2.事务四大特性（ACID）原子性、一致性、隔离性、持久性?
原子性（Atomicity）:
原子性是指事务包含的所有操作要么全部成功，要么全部失败回滚，因此事务的操作如果成功就必须要完全应用到数据库，如果操作失败则不能对数据库有任何影响。

一致性（Consistency）:
事务开始前和结束后，数据库的完整性约束没有被破坏。比如A向B转账，不可能A扣了钱，B却没收到。

隔离性（Isolation）:
隔离性是当多个用户并发访问数据库时，比如操作同一张表时，数据库为每一个用户开启的事务，不能被其他事务的操作所干扰，多个并发事务之间要相互隔离。
同一时间，只允许一个事务请求同一数据，不同的事务之间彼此没有任何干扰。比如A正在从一张银行卡中取钱，在A取钱的过程结束前，B不能向这张卡转账。

持久性（Durability）:
持久性是指一个事务一旦被提交了，那么对数据库中的数据的改变就是永久性的，即便是在数据库系统遇到故障的情况下也不会丢失提交事务的操作。

3.事务的并发?事务隔离级别，每个级别会引发什么问题，MySQL默认是哪个级别?
从理论上来说, 事务应该彼此完全隔离, 以避免并发事务所导致的问题，然而, 那样会对性能产生极大的影响, 因为事务必须按顺序运行， 在实际开发中, 为了提升性能, 事务会以较低的隔离级别运行， 事务的隔离级别可以通过隔离事务属性指定。
事务的并发问题

1、脏读：事务A读取了事务B更新的数据，然后B回滚操作，那么A读取到的数据是脏数据

2、不可重复读：事务 A 多次读取同一数据，事务 B 在事务A多次读取的过程中，对数据作了更新并提交，导致事务A多次读取同一数据时，结果因此本事务先后两次读到的数据结果会不一致。

3、幻读：幻读解决了不重复读，保证了同一个事务里，查询的结果都是事务开始时的状态（一致性）。

例如：事务T1对一个表中所有的行的某个数据项做了从“1”修改为“2”的操作 这时事务T2又对这个表中插入了一行数据项，而这个数据项的数值还是为“1”并且提交给数据库。 
而操作事务T1的用户如果再查看刚刚修改的数据，会发现还有跟没有修改一样，其实这行是从事务T2中添加的，就好像产生幻觉一样，这就是发生了幻读。

小结：不可重复读的和幻读很容易混淆，不可重复读侧重于修改，幻读侧重于新增或删除。解决不可重复读的问题只需锁住满足条件的行，解决幻读需要锁表。


事务的隔离级别

读未提交：另一个事务修改了数据，但尚未提交，而本事务中的SELECT会读到这些未被提交的数据脏读

不可重复读：事务 A 多次读取同一数据，事务 B 在事务A多次读取的过程中，对数据作了更新并提交，导致事务A多次读取同一数据时，结果因此本事务先后两次读到的数据结果会不一致。

可重复读：在同一个事务里，SELECT的结果是事务开始时时间点的状态，因此，同样的SELECT操作读到的结果会是一致的。但是，会有幻读现象

串行化：最高的隔离级别，在这个隔离级别下，不会产生任何异常。并发的事务，就像事务是在一个个按照顺序执行一样

特别注意：

MySQL默认的事务隔离级别为repeatable-read

MySQL 支持 4 中事务隔离级别.

事务的隔离级别要得到底层数据库引擎的支持, 而不是应用程序或者框架的支持.

Oracle 支持的 2 种事务隔离级别：READ_COMMITED , SERIALIZABLE

SQL规范所规定的标准，不同的数据库具体的实现可能会有些差异

MySQL中默认事务隔离级别是“可重复读”时并不会锁住读取到的行

事务隔离级别：未提交读时，写数据只会锁住相应的行。

事务隔离级别为：可重复读时，写数据会锁住整张表。

事务隔离级别为：串行化时，读写数据都会锁住整张表。

隔离级别越高，越能保证数据的完整性和一致性，但是对并发性能的影响也越大，鱼和熊掌不可兼得啊。对于多数应用程序，可以优先考虑把数据库系统的隔离级别设为Read Committed，它能够避免脏读取，而且具有较好的并发性能。尽管它会导致不可重复读、幻读这些并发问题，在可能出现这类问题的个别场合，可以由应用程序采用悲观锁或乐观锁来控制。

4.事务传播行为
1.PROPAGATION_REQUIRED：如果当前没有事务，就创建一个新事务，如果当前存在事务，就加入该事务，该设置是最常用的设置。

2.PROPAGATION_SUPPORTS：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就以非事务执行。

3.PROPAGATION_MANDATORY：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就抛出异常。

4.PROPAGATION_REQUIRES_NEW：创建新事务，无论当前存不存在事务，都创建新事务。

5.PROPAGATION_NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。

6.PROPAGATION_NEVER：以非事务方式执行，如果当前存在事务，则抛出异常。

7.PROPAGATION_NESTED：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。

最常用的三种传播行为：
REQUIRED：外层调用方法和内层被调用方法，有异常一起回滚，没问题一起提交。（共用一个事务）
REQUIRES_NEW：内层被调用方法回滚与否，不会影响外层调用方法。而外层调用方法出异常回滚，也不会回滚内层被调用方法（两个独立的事务）
NESTED：内层被调用方法回滚与否，不会影响外层调用方法。而外层调用方法出异常回滚，也会回滚内层被调用方法（嵌套事务）


5.嵌套事务
什么是嵌套事务？

嵌套是子事务套在父事务中执行，子事务是父事务的一部分，在进入子事务之前，父事务建立一个回滚点，叫save point，然后执行子事务，这个子事务的执行也算是父事务的一部分，然后子事务执行结束，父事务继续执行。重点就在于那个save point。

如果子事务回滚，会发生什么？

父事务会回滚到进入子事务前建立的save point，然后尝试其他的事务或者其他的业务逻辑，父事务之前的操作不会受到影响，更不会自动回滚。

如果父事务回滚，会发生什么？

父事务回滚，子事务也会跟着回滚！为什么呢，因为父事务结束之前，子事务是不会提交的，我们说子事务是父事务的一部分，正是这个道理。那么：

事务的提交，是什么情况？

是父事务先提交，然后子事务提交，还是子事务先提交，父事务再提交？答案是第二种情况，还是那句话，子事务是父事务的一部分，由父事务统一提交。


四、存储引擎
1.MySQL常见的三种存储引擎（InnoDB、MyISAM、MEMORY）的区别?
两种存储引擎的大致区别表现在：

1.InnoDB支持事务，MyISAM不支持， 这一点是非常之重要。事务是一种高级的处理方式，如在一些列增删改中只要哪个出错还可以回滚还原，而MyISAM就不可以了。

2.MyISAM适合查询以及插入为主的应用。

3.InnoDB适合频繁修改以及涉及到安全性较高的应用。

4.InnoDB支持外键，MyISAM不支持。

5.从MySQL5.5.5以后，InnoDB是默认引擎。

6.InnoDB不支持FULLTEXT类型的索引。

7.InnoDB中不保存表的行数，如select count() from table时，InnoDB需要扫描一遍整个表来计算有多少行，但是MyISAM只要简单的读出保存好的行数即可。注意的是，当count()语句包含where条件时MyISAM也需要扫描整个表。

8.对于自增长的字段，InnoDB中必须包含只有该字段的索引，但是在MyISAM表中可以和其他字段一起建立联合索引。

9.DELETE FROM table时，InnoDB不会重新建立表，而是一行一行的 删除，效率非常慢。MyISAM则会重建表。

10.InnoDB支持行锁（某些情况下还是锁整表，如 update table set a=1 where user like '%lee%'。

2.MySQL存储引擎MyISAM与InnoDB如何选择
MySQL有多种存储引擎，每种存储引擎有各自的优缺点，可以择优选择使用：MyISAM、InnoDB、MERGE、MEMORY(HEAP)、BDB(BerkeleyDB)、EXAMPLE、FEDERATED、ARCHIVE、CSV、BLACKHOLE。

虽然MySQL里的存储引擎不只是MyISAM与InnoDB这两个，但常用的就是两个。
关于MySQL数据库提供的两种存储引擎，MyISAM与InnoDB选择使用：

1.INNODB会支持一些关系数据库的高级功能，如事务功能和行级锁，MyISAM不支持。
2.MyISAM的性能更优，占用的存储空间少，所以，选择何种存储引擎，视具体应用而定。
如果你的应用程序一定要使用事务，毫无疑问你要选择INNODB引擎。但要注意，INNODB的行级锁是有条件的，只有通过索引条件检索数据，InnoDB才使用行级锁，否则，InnoDB将使用表锁！比如DELETE FROM mytable这样的删除语句。

如果你的应用程序对查询性能要求较高，就要使用MyISAM了。MyISAM索引和数据是分开的，而且其索引是压缩的，可以更好地利用内存。所以它的查询性能明显优于INNODB。压缩后的索引也能节约一些磁盘空间。MyISAM拥有全文索引的功能，这可以极大地优化LIKE查询的效率。

有人说MyISAM只能用于小型应用，其实这只是一种偏见。如果数据量比较大，这是需要通过升级架构来解决，比如分表分库，而不是单纯地依赖存储引擎。

现在一般都是选用innodb了，主要是MyISAM的全表锁，读写串行问题，并发效率锁表，效率低，MyISAM对于读写密集型应用一般是不会去选用的。
MEMORY存储引擎

MEMORY是MySQL中一类特殊的存储引擎。它使用存储在内存中的内容来创建表，而且数据全部放在内存中。这些特性与前面的两个很不同。
每个基于MEMORY存储引擎的表实际对应一个磁盘文件。该文件的文件名与表名相同，类型为frm类型。该文件中只存储表的结构。而其数据文件，都是存储在内存中，这样有利于数据的快速处理，提高整个表的效率。值得注意的是，服务器需要有足够的内存来维持MEMORY存储引擎的表的使用。如果不需要了，可以释放内存，甚至删除不需要的表。

MEMORY默认使用哈希索引。速度比使用B型树索引快。当然如果你想用B型树索引，可以在创建索引时指定。

注意，MEMORY用到的很少，因为它是把数据存到内存中，如果内存出现异常就会影响数据。如果重启或者关机，所有数据都会消失。因此，基于MEMORY的表的生命周期很短，一般是一次性的。

3.MySQL的MyISAM与InnoDB两种存储引擎在，事务、锁级别，各自的适用场景?
事务处理上方面

MyISAM：强调的是性能，每次查询具有原子性,其执行数度比InnoDB类型更快，但是不提供事务支持。

InnoDB：提供事务支持事务，外部键等高级数据库功能。 具有事务(commit)、回滚(rollback)和崩溃修复能力(crash recovery capabilities)的事务安全(transaction-safe (ACID compliant))型表。

锁级别

MyISAM：只支持表级锁，用户在操作MyISAM表时，select，update，delete，insert语句都会给表自动加锁，如果加锁以后的表满足insert并发的情况下，可以在表的尾部插入新的数据。

InnoDB：支持事务和行级锁，是innodb的最大特色。行锁大幅度提高了多用户并发操作的新能。但是InnoDB的行锁，只是在WHERE的主键是有效的，非主键的WHERE都会锁全表的。


五、优化
1.查询语句不同元素（where、jion、limit、group by、having等等）执行先后顺序?
1.查询中用到的关键词主要包含六个，并且他们的顺序依次为 select--from--where--group by--having--order by
其中select和from是必须的，其他关键词是可选的，这六个关键词的执行顺序 与sql语句的书写顺序并不是一样的，而是按照下面的顺序来执行

from:需要从哪个数据表检索数据

where:过滤表中数据的条件

group by:如何将上面过滤出的数据分组

having:对上面已经分组的数据进行过滤的条件

select:查看结果集中的哪个列，或列的计算结果

order by :按照什么样的顺序来查看返回的数据

2.from后面的表关联，是自右向左解析 而where条件的解析顺序是自下而上的。
也就是说，在写SQL语句的时候，尽量把数据量小的表放在最右边来进行关联（用小表去匹配大表），而把能筛选出小量数据的条件放在where语句的最左边 （用小表去匹配大表）


2.使用explain优化sql和索引?
对于复杂、效率低的sql语句，我们通常是使用explain sql 来分析sql语句，这个语句可以打印出，语句的执行。这样方便我们分析，进行优化

table：显示这一行的数据是关于哪张表的

type：这是重要的列，显示连接使用了何种类型。从最好到最差的连接类型为const、eq_reg、ref、range、index和ALL

all:full table scan ;MySQL将遍历全表以找到匹配的行；

index: index scan; index 和 all的区别在于index类型只遍历索引；

range：索引范围扫描，对索引的扫描开始于某一点，返回匹配值的行，常见与between ，等查询；

ref：非唯一性索引扫描，返回匹配某个单独值的所有行，常见于使用非唯一索引即唯一索引的非唯一前缀进行查找；

eq_ref：唯一性索引扫描，对于每个索引键，表中只有一条记录与之匹配，常用于主键或者唯一索引扫描；

const，system：当MySQL对某查询某部分进行优化，并转为一个常量时，使用这些访问类型。如果将主键置于where列表中，MySQL就能将该查询转化为一个常量。

possible_keys：显示可能应用在这张表中的索引。如果为空，没有可能的索引。可以为相关的域从WHERE语句中选择一个合适的语句

key： 实际使用的索引。如果为NULL，则没有使用索引。很少的情况下，MySQL会选择优化不足的索引。这种情况下，可以在SELECT语句中使用USE INDEX（indexname）来强制使用一个索引或者用IGNORE INDEX（indexname）来强制MySQL忽略索引

key_len：使用的索引的长度。在不损失精确性的情况下，长度越短越好

ref：显示索引的哪一列被使用了，如果可能的话，是一个常数

rows：MySQL认为必须检查的用来返回请求数据的行数

Extra：关于MySQL如何解析查询的额外信息。将在表4.3中讨论，但这里可以看到的坏的例子是Using temporary和Using filesort，意思MySQL根本不能使用索引，结果是检索会很慢。

3.MySQL慢查询怎么解决?
slow_query_log 慢查询开启状态。

slow_query_log_file 慢查询日志存放的位置（这个目录需要MySQL的运行帐号的可写权限，一般设置为MySQL的数据存放目录）。

long_query_time 查询超过多少秒才记录。


六、数据库锁
1.mysql都有什么锁，死锁判定原理和具体场景，死锁怎么解决?
MySQL有三种锁的级别：页级、表级、行级。

表级锁：开销小，加锁快；不会出现死锁；锁定粒度大，发生锁冲突的概率最高,并发度最低。
行级锁：开销大，加锁慢；会出现死锁；锁定粒度最小，发生锁冲突的概率最低,并发度也最高。
页面锁：开销和加锁时间界于表锁和行锁之间；会出现死锁；锁定粒度界于表锁和行锁之间，并发度一般
什么情况下会造成死锁?
什么是死锁？

死锁: 是指两个或两个以上的进程在执行过程中。因争夺资源而造成的一种互相等待的现象,若无外力作用,它们都将无法推进下去。此时称系统处于死锁状态或系统产生了死锁,这些永远在互相等竺的进程称为死锁进程。

表级锁不会产生死锁.所以解决死锁主要还是针对于最常用的InnoDB。

死锁的关键在于：两个(或以上)的Session加锁的顺序不一致。

那么对应的解决死锁问题的关键就是：让不同的session加锁有次序。

死锁的解决办法?

1.查出的线程杀死 kill
SELECT trx_MySQL_thread_id FROM information_schema.INNODB_TRX;

2.设置锁的超时时间
Innodb 行锁的等待时间，单位秒。可在会话级别设置，RDS 实例该参数的默认值为 50（秒）。

生产环境不推荐使用过大的 innodb_lock_wait_timeout参数值
该参数支持在会话级别修改，方便应用在会话级别单独设置某些特殊操作的行锁等待超时时间，如下：
set innodb_lock_wait_timeout=1000; —设置当前会话 Innodb 行锁等待超时时间，单位秒。

3.指定获取锁的顺序

2.有哪些锁（乐观锁悲观锁），select 时怎么加排它锁?
悲观锁（Pessimistic Lock）:
悲观锁特点:先获取锁，再进行业务操作。
即"悲观"的认为获取锁是非常有可能失败的，因此要先确保获取锁成功再进行业务操作。通常所说的“一锁二查三更新”即指的是使用悲观锁。
悲观锁依靠数据库的锁机制实现，即通过常用的select … for update操作来实现悲观锁。当数据库执行select for update时会获取被select中的数据行的行锁，
因此其他并发执行的select for update如果试图选中同一行则会发生排斥（需要等待行锁被释放），因此达到锁的效果。select for update获取的行锁会在当前事务结束时自动释放，因此必须在事务中使用。
补充：
不同的数据库对select for update的实现和支持都是有所区别的，
oracle支持select for update no wait，表示如果拿不到锁立刻报错，而不是等待，MySQL就没有no wait这个选项。
MySQL还有个问题是select for update语句执行中所有扫描过的行都会被锁上，这一点很容易造成问题。因此如果在MySQL中用悲观锁务必要确定走了索引，而不是全表扫描。

乐观锁（Optimistic Lock）:
1.乐观锁，也叫乐观并发控制，它假设多用户并发的事务在处理时不会彼此互相影响，各事务能够在不产生锁的情况下处理各自影响的那部分数据。
在提交数据更新之前，每个事务会先检查在该事务读取数据后，有没有其他事务又修改了该数据。如果其他事务有更新的话，那么当前正在提交的事务会进行回滚。
2.乐观锁的特点先进行业务操作，不到万不得已不去拿锁。即“乐观”的认为拿锁多半是会成功的，因此在进行完业务操作需要实际更新数据的最后一步再去拿一下锁就好。
乐观锁在数据库上的实现完全是逻辑的，不需要数据库提供特殊的支持。
3.一般的做法是在需要锁的数据上增加一个版本号，或者时间戳，
实现方式举例如下：
大多数基于数据版本（Version）记录机制实现。
SELECT data AS old_data, version AS old_version FROM …;
根据获取的数据进行业务操作，得到new_data和new_version
UPDATE SET data = new_data, version = new_version WHERE version = old_version
if (updated row > 0) {

// 乐观锁获取成功，操作完成

} else {

// 乐观锁获取失败，回滚并重试

}

拓展：ORM框架中悲观锁乐观锁的应用
1.Hibernate的悲观锁：
String hqlStr ="from TUser as user where user.name=Max";  
Query query = session.createQuery(hqlStr);  
query.setLockMode("user",LockMode.UPGRADE); //加锁  
List userList = query.list();//执行查询，获取数据  

2.Hibernate的乐观锁
通过class描述符的optimistic-lock属性结合version描述符指定。

注意：
乐观锁在不发生取锁失败的情况下开销比悲观锁小，但是一旦发生失败回滚开销则比较大，因此适合用在取锁失败概率比较小的场景，可以提升系统并发性能
乐观锁还适用于一些比较特殊的场景，例如在业务操作过程中无法和数据库保持连接等悲观锁无法适用的地方。

总结：
悲观锁和乐观锁是数据库用来保证数据并发安全防止更新丢失的两种方法，例子在select ... for update前加个事务就可以防止更新丢失。悲观锁和乐观锁大部分场景下差异不大，一些独特场景下有一些差别，一般我们可以从如下几个方面来判断。
响应速度： 如果需要非常高的响应速度，建议采用乐观锁方案，成功就执行，不成功就失败，不需要等待其他并发去释放锁。
冲突频率： 如果冲突频率非常高，建议采用悲观锁，保证成功率，如果冲突频率大，乐观锁会需要多次重试才能成功，代价比较大。
重试代价： 如果重试代价大，建议采用悲观锁。


七、其他
1.数据库的主从复制
主从复制的几种方式:
同步复制:
所谓的同步复制，意思是master的变化，必须等待slave-1,slave-2,...,slave-n完成后才能返回。 这样，显然不可取，也不是MySQL复制的默认设置。比如，在WEB前端页面上，用户增加了条记录，需要等待很长时间。

异步复制:
如同AJAX请求一样。master只需要完成自己的数据库操作即可。至于slaves是否收到二进制日志(binlog)，是否完成操作，不用关心,MySQL的默认设置。

半同步复制:
master只保证slaves中的一个操作成功，就返回，其他slave不管。 这个功能，是由google为MySQL引入的。

2.数据库主从复制分析的 7 个问题?
问题1：master的写操作，slaves被动的进行一样的操作，保持数据一致性，那么slave是否可以主动的进行写操作？
假设slave可以主动的进行写操作，slave又无法通知master，这样就导致了master和slave数据不一致了。因此slave不应该进行写操作，至少是slave上涉及到复制的数据库不可以写。实际上，这里已经揭示了读写分离的概念。

问题2：主从复制中，可以有N个slave,可是这些slave又不能进行写操作，要他们干嘛？
实现数据备份:
类似于高可用的功能，一旦master挂了，可以让slave顶上去，同时slave提升为master。

异地容灾:比如master在北京，地震挂了，那么在上海的slave还可以继续。
主要用于实现scale out,分担负载,可以将读的任务分散到slaves上。
(很可能的情况是，一个系统的读操作远远多于写操作，因此写操作发向master，读操作发向slaves进行操作)

问题3：主从复制中有master,slave1,slave2,...等等这么多MySQL数据库，那比如一个JAVA WEB应用到底应该连接哪个数据库?
我们在应用程序中可以这样，insert/delete/update这些更新数据库的操作，用connection(for master)进行操作，
select用connection(for slaves)进行操作。那我们的应用程序还要完成怎么从slaves选择一个来执行select，例如使用简单的轮循算法。
这样的话，相当于应用程序完成了SQL语句的路由，而且与MySQL的主从复制架构非常关联，一旦master挂了，某些slave挂了，那么应用程序就要修改了。能不能让应用程序与MySQL的主从复制架构没有什么太多关系呢？
找一个组件，application program只需要与它打交道，用它来完成MySQL的代理，实现SQL语句的路由。
MySQL proxy并不负责，怎么从众多的slaves挑一个？可以交给另一个组件(比如haproxy)来完成。
这就是所谓的MySQL READ WRITE SPLITE，MySQL的读写分离。

问题4：如果MySQL proxy , direct , master他们中的某些挂了怎么办？
总统一般都会弄个副总统，以防不测。同样的，可以给这些关键的节点来个备份。

问题5：当master的二进制日志每产生一个事件，都需要发往slave，如果我们有N个slave,那是发N次，还是只发一次？如果只发一次，发给了slave-1，那slave-2,slave-3,...它们怎么办？
显然，应该发N次。实际上，在MySQL master内部，维护N个线程，每一个线程负责将二进制日志文件发往对应的slave。master既要负责写操作，
还得维护N个线程，负担会很重。可以这样，slave-1是master的从，slave-1又是slave-2,slave-3,...的主，同时slave-1不再负责select。 slave-1将master的复制线程的负担，转移到自己的身上。这就是所谓的多级复制的概念。

问题6：当一个select发往MySQL proxy，可能这次由slave-2响应，下次由slave-3响应，这样的话，就无法利用查询缓存了。
应该找一个共享式的缓存，比如memcache来解决。将slave-2,slave-3,...这些查询的结果都缓存至mamcache中。

问题7：随着应用的日益增长，读操作很多，我们可以扩展slave，但是如果master满足不了写操作了，怎么办呢？
scale on ?更好的服务器？ 没有最好的，只有更好的，太贵了...
scale out ? 主从复制架构已经满足不了。
可以分库(垂直拆分)：表多，把关系紧密（比如同一模块）的表切分出来放在一个server上
分表(水平拆分)：表的数据多，把表的数据按某种规则（比如按ID散列）切分到多个数据库(server)上，

3.mysql 高并发环境解决方案?
MySQL 高并发环境解决方案： 分库 分表 分布式 增加二级缓存...
需求分析：互联网单位 每天大量数据读取，写入，并发性高。
现有解决方式：水平分库分表，由单点分布到多点数据库中，从而降低单点数据库压力。
集群方案：解决DB宕机带来的单点DB不能访问问题。
读写分离策略：极大限度提高了应用中Read数据的速度和并发量。无法解决高写入压力。

4.数据库崩溃时事务的恢复机制（REDO日志和UNDO日志）?
MySQL REDO日志和UNDO日志
Undo Log:
Undo Log是为了实现事务的原子性，在MySQL数据库InnoDB存储引擎中，还用了Undo Log来实现多版本并发控制(MVCC)。
事务的原子性(Atomicity)事务中的所有操作，要么全部完成，要么不做任何操作，不能只做部分操作。如果在执行的过程中发生了错误，要回滚(Rollback)到事务开始前的状态，就像这个事务从来没有执行过。
原理Undo Log的原理很简单，为了满足事务的原子性，在操作任何数据之前，首先将数据备份到一个地方（这个存储数据备份的地方称为UndoLog）。
然后进行数据的修改。如果出现了错误或者用户执行了ROLLBACK语句，系统可以利用Undo Log中的备份将数据恢复到事务开始之前的状态。

之所以能同时保证原子性和持久化，是因为以下特点：
更新数据前记录Undo log。
为了保证持久性，必须将数据在事务提交前写到磁盘。只要事务成功提交，数据必然已经持久化。
Undo log必须先于数据持久化到磁盘。如果在G,H之间系统崩溃，undo log是完整的， 可以用来回滚事务。
如果在A-F之间系统崩溃,因为数据没有持久化到磁盘。所以磁盘上的数据还是保持在事务开始前的状态。

缺陷：每个事务提交前将数据和Undo Log写入磁盘，这样会导致大量的磁盘IO，因此性能很低。
如果能够将数据缓存一段时间，就能减少IO提高性能。但是这样就会丧失事务的持久性。因此引入了另外一种机制来实现持久化，即Redo Log。

Redo Log:
原理和Undo Log相反，Redo Log记录的是新数据的备份。在事务提交前，只要将Redo Log持久化即可，不需要将数据持久化。
当系统崩溃时，虽然数据没有持久化，但是Redo Log已经持久化。系统可以根据Redo Log的内容，将所有数据恢复到最新的状态。


5.binlog的作用
binlog是一个二进制格式的文件，用于记录用户对数据库更新的SQL语句信息，例如更改数据库表和更改内容的SQL语句都会记录到binlog里，但是对库表的查询不会记录。
主要用于数据库的主从复制和数据恢复。



----------------------------------------------------------------------------


主从复制通过三个线程来完成，在master节点运行的binlog dump的线程，I/O线程和SQL线程运行在slave 节点。

        1、master节点的Binlog dump线程，当slave节点与master正常连接的时候，master把更新的binlog 内容推送到slave节点。
    
        2、slave节点的I/O 线程 ，该线程通过读取master节点binlog日志名称以及偏移量信息将其拷贝到本地relay log日志文件。
    
        3、slave节点的SQL线程，该线程读取relay log日志信息，将在master节点上提交的事务在本地回放，达到与主库数据保持一致的目的。
    
        我们可以看到，基于这个机制的主从复制存在一个问题，Master节点的数据库实例并发跑多个线程同时提交事务，但是slave节点只有

SQL单线程来执行relay log中的日志信息，重放主库提交的事务，这会造成主备数据库存在延迟（lag）。

 

MySQL5.6的改进

        MySQL 5.6版本引入并发复制（schema级别），基于schema级别的并发复制核心思想：“不同schema下的表并发提交时的数据不会相互

影响，即slave节点可以用对relay log中不同的schema各分配一个类似SQL功能的线程，来重放relay log中主库已经提交的事务，保持数据与主

库一致”。可见MySQL5.6版本的并发复制，一个schema分配一个类似SQL线程的功能。

### rpc的泛化调用
因为服务消费者没有了接口，我们直接编写消费者端spring的配置文件consumer.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
       http://code.alibabatech.com/schema/dubbo http://code.alibabatech.com/schema/dubbo/dubbo.xsd">
      

    <dubbo:application name="demotest-consumer" owner="programmer" organization="dubbox"/>
    <!--向 zookeeper 订阅 provider 的地址，由 zookeeper 定时推送-->
    <dubbo:registry address="zookeeper://localhost:2181"/>
    <!--使用 dubbo 协议调用定义好的 api.PermissionService 接口-->
    <dubbo:reference id="permissionService" interface="com.alibaba.dubbo.demo.DemoService" generic="true"/>
</beans>

　　可以看到上图的配置文件中有两个地方需要注意一下，第一个是interface，其实该接口在消费者端并不存在，这是与往常写的不一样的地方，第二个地方需要注意的地方就是generic=”true”这样的标签，表示该接口支持泛型调用。

　　好了，我们写一个服务测试类，看看如何进行泛型调用Consumer.java

package com.alibaba.dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.service.GenericService;

public class Consumer {
    public static void main(String[] args) {
        /////////////////Spring泛化调用/////////  
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("consumer start");
        GenericService demoService = (GenericService) context.getBean("permissionService");
        System.out.println("consumer");
        Object result = demoService.$invoke("getPermissions", new String[] { "java.lang.Long" }, new Object[]{ 1L });
        System.out.println(result);
    }
}
看到Main函数中，从spring的上下文中读到”permissionService”之后却把它强转为GenericService的类，然后调用GenericService的$invoke的方法，该方法有三个参数，第一个参数是你调用远程接口的具体方法名，第二个参数是permissionService这个方法的入参的类型，最后一个参数是值。 



### Java的SPI机制实例详解

SPI的全名为Service Provider Interface.普通开发人员可能不熟悉，因为这个是针对厂商或者插件的。在java.util.ServiceLoader的文档里有比较详细的介绍。究其思想，其实是和"Callback"差不多。“Callback”的思想是在我们调用API的时候，我们可以自己写一段逻辑代码，传入到API里面，API内部在合适的时候会调用它，从而实现某种程度的“定制”。
典型的是Collections.sort（List<T> list,Comparator<? super T> c）这个方法，它的第二个参数是一个实现Comparator接口的实例。我们可以根据自己的排序规则写一个类，实现此接口，传入此方法，那么这个方法就会根据我们的规则对list进行排序。
把这个思想扩展开来，我们用SPI来重新实现上面的例子。客户把自己的排序规则写成一个类，并且打包成Jar文件，这个Jar文件里面必须有META-INF目录，其下又有services目录，其下有一个文本文件，文件名即为接口的全名：java.util.Comparator。
--META-INF
 --services
  --java.util.Comparator
文件内容只有一行：
com.company1.ComparatorProvider

这一行是你实现了Comparator接口的类的全名，它的代码如下：
package com.company1;
import java.util.Comparator;
import com.mycompany.myapp.MyItem;
public class ComparatorProvider implements Comparator<MyItem>{
  @Override
  public int compare(MyItem o1, MyItem o2) {
        //依据name排序 
    return o1.getName().compareTo(o2.getName());
  }
}

编译打包后，把它放到你的主程序的class path里。下面是你的主程序：

//从class path中所有Jar的META-INF目录中搜索，找到合适的类并加载。
private static ServiceLoader<Comparator> serviceLoader
= ServiceLoader.load(Comparator.class);

public static void main(String[] args)
{
  List<MyItem> myList = new ArrayList<MyItem>();
  myList.add(new MyItem(2,"c","hhh"));
  myList.add(new MyItem(3,"k","ooo"));
  myList.add(new MyItem(4,"d","ppp"));
  myList.add(new MyItem(5,"b","ggg"));

  showList(myList);

  Collections.sort(myList,getCompartor());

  showList(myList);  
}

@SuppressWarnings("unchecked")
private static Comparator<MyItem> getCompartor() {

  for(Comparator service : serviceLoader)
  {
    return (Comparator<MyItem>)service;
  }
       
  return null;
}



### maven打包指定moudle

假设现有项目结构如下
dailylog-parent
|-dailylog-common
|-dailylog-web

三个文件夹处在同级目录中
dailylog-web依赖dailylog-common
dailylog-parent管理dailylog-common和dailylog-web。
根据资料已知：

参数	全称	释义	说明
-pl	--projects	Build specified reactor projects instead of all projects	
选项后可跟随{groupId}:{artifactId}或者所选模块的相对路径(多个模块以逗号分隔)

-am	--also-make	If project list is specified, also build projects required by the list	
表示同时处理选定模块所依赖的模块

-amd	--also-make-dependents	If project list is specified, also build projects that depend on projects on the list	
表示同时处理依赖选定模块的模块

-N	--Non-recursive	Build projects without recursive	
表示不递归子模块

-rf	--resume-from	Resume reactor from specified project	
表示从指定模块开始继续处理

以下是在maven-3.3.9中的试验

1. 在dailylog-parent目录运行`mvn clean install -pl org.lxp:dailylog-web -am`，结果

dailylog-common成功安装到本地库
dailylog-parent成功安装到本地库
dailylog-web成功安装到本地库
该命令等价于`mvn clean install -pl ../dailylog-web -am`

2. 在dailylog-parent目录运行`mvn clean install -pl ../dailylog-common -am`，结果

dailylog-common成功安装到本地库
dailylog-parent成功安装到本地库
3. 在dailylog-parent目录运行`mvn clean install -pl ../dailylog-common -amd`，结果

dailylog-common成功安装到本地库
dailylog-web成功安装到本地库
由于dailylog-parent并不依赖dailylog-common模块，故没有被安装

4. 在dailylog-parent目录运行`mvn clean install -pl ../dailylog-common,../dailylog-parent -amd`，结果

dailylog-common成功安装到本地库
dailylog-parent成功安装到本地库
dailylog-web成功安装到本地库
5. 在dailylog-parent目录运行`mvn clean install -N`，结果

dailylog-parent成功安装到本地库
-N表示不递归，那么dailylog-parent管理的子模块不会被同时安装

6. 在dailylog-parent目录运行`mvn clean install -pl ../dailylog-parent -N`，结果

dailylog-parent成功安装到本地库
7. 在dailylog-parent目录运行`mvn clean install -rf ../dailylog-common`，结果

dailylog-common成功安装到本地库
dailylog-web成功安装到本地库



自定义META-INF文件夹，可以放在resources下，另外需要在pom文件中添加以下配置，不让Maven打包时生成maven自己的描述文件，这样就maven就不会覆盖自定义的文件了
<build>
    <plugins>
        <plugin>  
            <groupId>org.apache.maven.plugins</groupId>  
            <artifactId>maven-jar-plugin</artifactId>  
            <configuration>  
                <archive>
                    <addMavenDescriptor>false</addMavenDescriptor>  
                </archive>
            </configuration>  
        </plugin>
    </plugins>
</build>

### 脑裂问题
对于一个集群，想要提高这个集群的可用性，通常会采用多机房部署，比如现在有一个由6台zkServer所组成的一个集群，部署在了两个机房。
正常情况下，此集群只会有一个Leader，那么如果机房之间的网络线路断了之后，两个机房内的zkServer还是可以相互通信的，如果不考虑过半机制，那么就会出现每个机房内部都将选出一个Leader。
解决方案：
1.引入过半机制，对于一个Zookeeper集群，要么没有Leader，要么只有1个Leader，这样就避免了脑裂问题。
避免方案：
1.添加冗余的网络线路，尽量减少“裂脑”发生几率
2.设置仲裁机制。例如设置参考IP（如网关IP），当机房完全断开时，2个节点都各自ping一下参考IP，不通则表明断点出现在本机房，即使启动（或继续）应用服务也没有用，还不如主动放弃竞争，以彻底释放有可能还占用着的共享资源，让能够ping通参考IP的一端继续服务。

### 事务失效的场景
其实发生最多就是：
1.自身调用
调用本类自己的方法，而没有经过 Spring 的代理类，默认只有在外部调用事务才会生效
2.异常被吃
被catch住了
3.异常抛出类型
因为默认回滚的是：RuntimeException，如果你想触发其他异常的回滚，需要在注解上配置一下，如@Transactional(rollbackFor = Exception.class)
4.方法不是public
@Transactional 只能用于 public 的方法上，否则事务不会失效，如果要用在非 public 方法上，可以开启 AspectJ 代理模式

### HTTP/2相比于HTTP1.1的改进
多路复用
1.文件传输从串行变为并行。当请求a文件时，b文件只能等待，等待a连接到服务器、服务器处理文件、服务器返回文件，这三个步骤。我们假设这三步用时都是1秒，那么a文件用时为3秒，b文件传输完成用时为6秒，依此类推。（注：此项计算有一个前提条件，就是浏览器和服务器是单通道传输）。在HTTP1.1的协议中，我们传输的request和response都是基本于文本的，这样就会引发一个问题：所有的数据必须按顺序传输，比如需要传输：hello world，只能从h到d一个一个的传输，不能并行传输，因为接收端并不知道这些字符的顺序，所以并行传输在HTTP1.1是不能实现的。HTTP/2引入二进制数据帧和流的概念，其中帧对数据进行顺序标识，这样浏览器收到数据之后，就可以按照序列对数据进行合并，而不会出现合并后数据错乱的情况。同样是因为有了序列，服务器就可以并行的传输数据，这就是流所做的事情。
2.HTTP/2基于流式传输。我们假设Apache设置了最大并发数为300，因为浏览器限制，浏览器发起的最大请求数为6，也就是服务器能承载的最高并发为50，当第51个人访问时，就需要等待前面某个请求处理完成。。HTTP/2对同一域名下所有请求都是基于流，也就是说同一域名不管访问多少文件，也只建立一路连接。同样Apache的最大连接数为300，因为有了这个新特性，最大的并发就可以提升到300，比原来提升了6倍！
3.解决了http队头阻塞，但是依然没有解决TCP队头阻塞，但是改造TCP涉及范围太广，包括一系列硬件设备，所以HTTP/3采用基于UDP的QUIC技术



### 卫语句：解决嵌套if-then-else
if（obj != null）{
  doSomething();
}

转换成卫语句以后的代码如下：
if(obj == null){
   return;
}
doSomething();



### 系统稳定性建设

团队协作理念，一人会团队会

不稳定来自哪里，人为，系统，自然。
稳定性指标：不可用时间+恢复时间

人是基本：
稳定性建设杂谈：风险认知+排除侥幸心理+加强owner意识
操作sop规范
合理团队划分

系统设计：
面向失败，0信任理念。
基本操作，自我保护，限流，熔断
流量治理分级，分集群+流量重要度分级。
依赖治理：梳理强弱依赖，超时管控，qps管控等。
数据容灾：静态数据兜底，多级缓存

架构拆分，避免循环依赖等，减少发布频率，避免敏态稳态项目重合，沉淀基础能力。
系统扩展，能力扩展，扩展的同时需要隔离机制，例：hystrix，
代码bug，依赖经验+开发规范，举例：大事物，第三方库使用管控等。
场景容灾：兜底产品方案。
数据库依赖，redis等，面向失败设计

日常手段：
核心监控+值班，噪音治理。
大促压测，常态压测
突发流量+日常容量规划
降级回滚监控预案
混沌工程建设
运营配置check机制
快速协调响应处理机制
补偿机制
改进项action跟进

自然因素：及时发现+双机房
事前充分准备，事中快速止血+稳定客户情绪，事后快速补偿+反思改进

线上事故紧急处理流程宣导。

### Groovy VS Java 性能
如果在一个groovy文件中没有任何类定义，它将被当做script来处理，也就意味着这个文件将被透明的转换为一个Script类型的类，这个自动转换得到的类将使用原始的groovy文件名作为类的名字。groovy文件的内容被打包进run方法，另外在新产生的类中被加入一个main方法以进行外部执行该脚本。
如果在groovy文件只有一个类的定义，并且该类的名字与文件名称相同，那么这就和java中的类与文件的一一对应关系相同。
在一个groovy文件中可以包含多个类定义，并且没有强制要求其中有一个类的类名与文件名相同。groovyc编译器会很乐于把该文件中定义的所有的类都编译成*.class文件。如果希望能够直接调用这个groovy script，比如说在使用groovy命令行或者在某个IDE中执行，那么应该在该文件中的第一个类中定义一个main方法。
在一个groovy文件中可以混合类的定义和脚本定义。在这种情况下，那些脚本代码将会变成直接调用的主类，所以在这种情况下不应该再定义一个和文件同名的类。

1、递归形式计算斐波那契数列 时间复杂度 2^n
开启JIT
n=25时，采用Groovy编写，耗时14毫秒，采用Java编写，耗时2毫秒
n=40时，采用Groovy编写，耗时1017毫秒，采用Java编写，耗时417毫秒
n=50时，采用Groovy编写，耗时102秒，采用Java编写，耗时45秒
n=55时，采用Groovy编写，耗时1165秒，采用Java编写，耗时490秒
不开启JIT
n=25时，采用Groovy编写，耗时50毫秒，采用Java编写，耗时6毫秒
n=40时，采用Groovy编写，耗时61秒，采用Java编写，耗时6秒
n=50时，采用Groovy编写，耗时几小时以上，采用Java编写，耗时755秒


2、冒泡排序 时间复杂度 n^2
开启JIT
数组长度=1万时，采用Groovy编写，耗时243毫秒，采用Java编写，耗时248毫秒
数组长度=10万时，采用Groovy编写，耗时21秒，采用Java编写，耗时21秒
数组长度=20万时，采用Groovy编写，耗时92秒，采用Java编写，耗时84秒
数组长度=30万时，采用Groovy编写，耗时203秒，采用Java编写，耗时195秒
不开启JIT
数组长度=1万时，采用Groovy编写，耗时6秒，采用Java编写，耗时2秒
数组长度=10万时，采用Groovy编写，耗时586秒，采用Java编写，耗时135秒


3、快速排序 时间复杂度 nlogn
开启JIT
数组长度=10万时，采用Groovy编写，耗时42毫秒，采用Java编写，耗时48毫秒
数组长度=100万时，采用Groovy编写，耗时288毫秒，采用Java编写，耗时210毫秒
数组长度=1000万时，采用Groovy编写，耗时2秒，采用Java编写，耗时2秒
数组长度=1亿时，采用Groovy编写，耗时16秒，采用Java编写，耗时16秒
不开启JIT
数组长度=10万时，采用Groovy编写，耗时430毫秒，采用Java编写，耗时53毫秒
数组长度=100万时，采用Groovy编写，耗时2.4秒，采用Java编写，耗时9秒
数组长度=1000万时，采用Groovy编写，耗时28秒，采用Java编写，耗时6.6秒
数组长度=1亿时，采用Groovy编写，耗时310秒，采用Java编写，耗时77秒


4、累加求和 时间复杂度 n
开启JIT
n=10万时，采用Groovy编写，耗时6毫秒，采用Java编写，耗时2毫秒
n=100万时，采用Groovy编写，耗时10毫秒，采用Java编写，耗时4毫秒
n=1000万时，采用Groovy编写，耗时14毫秒，采用Java编写，耗时7毫秒
n=1亿时，采用Groovy编写，耗时47毫秒，采用Java编写，耗时47毫秒
n=10亿时，采用Groovy编写，耗时380毫秒，采用Java编写，耗时365毫秒
不开启JIT
n=10万时，采用Groovy编写，耗时7毫秒，采用Java编写，耗时1毫秒
n=100万时，采用Groovy编写，耗时31毫秒，采用Java编写，耗时16毫秒
n=1000万时，采用Groovy编写，耗时410毫秒，采用Java编写，耗时140毫秒
n=1亿时，采用Groovy编写，耗时2.7秒，采用Java编写，耗时1.3秒
n=10亿时，采用Groovy编写，耗时22.6秒，采用Java编写，耗时11.5秒

如果在Groovy代码的类或者方法上添加@CompileStatic注解，将会进行静态类型检查和静态编译，并且生成的字节码和javac生成的字节码很相似(不添加此注释生成的字节码文件和java字节码文件很不一样)
代码运行速度和java持平,对于通过复制和粘贴从Java移植到Groovy的类可以通过@CompileStatic提高性能。
副作用是所有的动态功能都不再可用，比如元对象协议(Meta Object Protocol)。



### 用例图

用例图主要用来描述角色以及角色与用例之间的**连接关系**。说明的是谁要使用系统，以及他们使用该系统可以做些什么。一个用例图包含了**多个模型元素**，如系统、参与者和用例，并且**显示这些元素之间的各种关系**，如**泛化**、**关联**和**依赖**。它展示了一个外部用户能够观察到的系统功能模型图。

【用途】：帮助开发团队以一种可视化的方式理解系统的功能需求

**参与者(Actor)——**与应用程序或系统进行交互的用户、组织或外部系统。**用一个小人表示**。

**用例(Use Case)——**用例就是外部可见的系统功能，对系统提供的服务进行描述。**用椭圆表示**。

**子系统(Subsystem)——**用来展示系统的一部分功能，这部分功能联系紧密。

**关联**：发送或接收消息，箭头指向消息接收方

**泛化**：继承关系

**包含**：大用例包含各个子用例(大功能划分为一个个小功能)，比如维护用户信息包括添加信息、修改信息、删除信息

**扩展**：用例之外的附属功能，比如查询功能扩展导出查询结果or打印查询结果

 

