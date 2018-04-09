package cn.xxan.ThinkInJavaTest;

/**
 * @ClassName: SingleInstance
 * @Author shenguoqiang
 * @Date 2018/4/9 9:55
 * @Description: 单例中使用volatile关键字
 */
public class SingleInstance {

    private volatile static SingleInstance instance = null;

    public static SingleInstance getInstance() {
        if (instance == null) {
            // B线程检测到uniqueInstance不为空
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                    // A线程被指令重排了，刚好先赋值了；但还没执行完构造函数。
                    /*在执行instance=new SingleInstance()；时，并不是原子语句，实际是包括了下面三大步骤：
                        1.为对象分配内存
                        2.初始化实例对象
                        3.把引用instance指向分配的内存空间
                        这个三个步骤并不能保证按序执行，处理器会进行指令重排序优化，存在这样的情况：
                        优化重排后执行顺序为：1,3,2, 这样在线程A执行到3时，instance已经不为null了，
                        线程B此时判断instance!=null，则直接返回instance引用，但现在实例对象还没有初始化完毕，
                        此时线程2使用instance可能会造成程序崩溃。*/
                }
            }
        }
        return instance;// 后面B线程执行时将引发：对象尚未初始化错误。
    }
}
