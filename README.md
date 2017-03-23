#ParamInitDemo
## 注解的分类

### 按照运行机制分为3类
- 源码注解
    - 指的是注解自在源码中存在，编译成class文件之后就不存在了
- 编译时注解
    - 指的是在源码中和class文件中都存在
- 运行时注解
    - 指的是在运行阶段还起作用，甚至影响运行逻辑的注解

> 元注解：指的是注解的注解

## 示例：
```java
@Target({ElementType.METHOD,ElementType.Type})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @Interface Desciption{
    String desc();
    String author();
    int age() default 18;
}
```
>注意：
- 注解使用"@interface"来标识
- 成员必须以无参数，无异常的方式来声明，可以使用default来赋一个默认值
- 成员类型是受限的，限制于：原始类型，String，Class，Annotaion，Enumeration
- 如果注解中只有一个成员，则必须名为value()，在使用时可以忽略成员名和赋值号(=)
- 注解类可以没有成员，这种注解被称为标识注解

### [@Target]注解的作用域表
| 属性值 | 含义  |
| :--  | :--  |
| CONSTRUCTOR | 构造方法声明 |
| FIELD | 字段声明 |
| LOCAL_VARIBLE | 局部变量声明 |
| METHOD | 方法声明 |
| PACKAGE | 包声明 |
| PARAMETER | 参数声明 |
| TYPE | l类，接口 |

### [@Retention]生命周期
-  源码注解
-  编译时注解
-  运行时注解

### [@Inherited]
表示允许子类继承

### [@Documented]
生成javadoc时候会包含注解
