### java 基础

1. java及时编译： https://tech.meituan.com/2020/10/22/java-jit-practice-in-meituan.html
2. 重载和重写
3. == 和 equals
4. hashCode()和equals()
   hashCode()和equals()都是Object中的方法，2个方法都是用来判断对象是否相同的，按照java的设计，重写equals一般都会重写hashCode方法，用来维护相等的对象必须具有相等的hash值
   但是，2个对象的hashCode方法值相同，并不要求这个2个对象根据equals方法相同。即：相同的hashCode不一定equals相同，但是equals相同，hashCode需要相同
5. 创建一个对象用什么运算符，对象实体与对象引用有和不同  
   new运算符，对象实体在堆内存中，对象引用在栈内存中，对象引用指向对象实例。一个对象引用可以指向0个或者1个对象实体，一个对象实体可以有多个对象引用指向它