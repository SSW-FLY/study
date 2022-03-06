### java 基础

1. java及时编译： https://tech.meituan.com/2020/10/22/java-jit-practice-in-meituan.html
2. 重载和重写
3. == 和 equals
4. hashCode()和equals()
   hashCode()和equals()
   都是Object中的方法，2个方法都是用来判断对象是否相同的，按照java的设计，重写equals一般都会重写hashCode方法，用来维护相等的对象必须具有相等的hash值
   但是，2个对象的hashCode方法值相同，并不要求这个2个对象根据equals方法相同。即：相同的hashCode不一定equals相同，但是equals相同，hashCode需要相同
5. 创建一个对象用什么运算符，对象实体与对象引用有和不同  
   new运算符，对象实体在堆内存中，对象引用在栈内存中，对象引用指向对象实例。一个对象引用可以指向0个或者1个对象实体，一个对象实体可以有多个对象引用指向它
6. 深拷贝和浅拷贝区别了解吗？什么是引用拷贝？  
   浅拷贝：浅拷贝会在堆内存中创建一个对象，如果原对象内部属性是引用类型的话，直接复制原本对象的引用。  
   深拷贝：完全复制整个对象，包括这个对象包含的内部对象
7. String 类为什么不可变  
   保存字符的数组被final修饰且为私有的，并且String没有提供修改这个数组的方法。  
   String类被final修饰，避免了子类破坏String不可变
8. StringBuffer StringBuilder  
   Java 语言本身并不支持运算符重载，“+”和“+=”是专门为 String 类重载过的运算符，也是 Java 中仅有的两个重载过的元素符。  
   对象引用和“+”的字符串拼接方式，实际上是通过 StringBuilder 调用 append() 方法实现的，拼接完成之后调用 toString() 得到一个 String 对象 。
9. String 常量池 ?  
   String 常量池在方法区(元数据区)
   详细解析：https://segmentfault.com/a/1190000009888357/
   https://blog.csdn.net/weixin_40304387/article/details/81071816